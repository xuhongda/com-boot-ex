package com.xu.bootweb.applicationContext;

import com.xu.bootweb.listener.MyEvent;
import com.xu.bootweb.listener.MyEventListener;
import entity.People;
import org.junit.Test;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Collection;

/**
 * @author xuhongda on 2021/5/17
 * com.xu.bootweb.applicationContext
 * com-boot-ex
 * <p>
 *     ApplicationContext 实现了 BeanFactory 的接口
 * </p>
 */
public class ApplicationContextTest {

    @Test
    public void test001(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/spring.xml");
        People people = (People)applicationContext.getBean("people");
        System.out.println(people.getAge());

        Collection<ApplicationListener<?>> applicationListeners = applicationContext.getApplicationListeners();

        applicationListeners.forEach(System.out::println);

        //往这个容器中添加事件监听器并发布事件
        applicationContext.addApplicationListener(new MyEventListener());
        applicationContext.publishEvent(new MyEvent(this));






    }
}
