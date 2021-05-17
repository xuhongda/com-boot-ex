package com.xu.bootweb.beanFactory;

import com.xu.bootweb.processor.MyBeanPostProcessor;
import entity.Car;
import entity.People;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Map;

/**
 * @author xuhongda on 2021/5/17
 * com.xu.bootweb.beanFactory
 * com-boot-ex
 * <p>
 *     beanfactory
 * </p>
 */
@Slf4j
public class BeanFactoryTest {


    @Test
    public void test001(){

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource resource = pathMatchingResourcePatternResolver.getResource("classpath:config/spring.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        int i = xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        log.info("bean 的数量 i = {}",i);

        People peoPle = (People)defaultListableBeanFactory.getBean("people");

        System.out.println(peoPle.getAge());

        Map<String, People> beansOfType = defaultListableBeanFactory.getBeansOfType(People.class);

        beansOfType.keySet().iterator().forEachRemaining(System.out::println);

        beansOfType.values().forEach(System.out::println);



    }


    /**
     *  探讨 bean 的生命周期
     */
    @Test
    public void test002(){

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource resource = pathMatchingResourcePatternResolver.getResource("classpath:config/spring.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 手动添加后置 bean 后处理器，ApplicationContext 会自动识别添加进容器，这事 beanFactory 与 ApplicationContext
        // 最大的区别
        defaultListableBeanFactory.addBeanPostProcessor(new MyBeanPostProcessor());

        System.out.println("BeanPostProcessorCount = "+defaultListableBeanFactory.getBeanPostProcessorCount());

        defaultListableBeanFactory.getBeanPostProcessors().forEach(System.out::println);

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        int i = xmlBeanDefinitionReader.loadBeanDefinitions(resource);

        log.info("bean 的数量 i = {}",i);

        Car car = (Car)defaultListableBeanFactory.getBean("car");

        System.out.println(car.getColor());



    }
}
