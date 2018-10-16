package com.xu.bootweb.springUtil;

import org.junit.Test;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * <p>
 * spring 工具类
 * </p>
 *
 * @author xuhongda on 2018/10/16
 * com.xu.bootweb.springUtil
 * com-boot-ex
 */
public class SpringUtilTest {
    /**
     * 复制
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        File in = new File("D:\\工作文档\\短信确认登录.txt");
        File out = new File("C:\\Users\\ydyt16\\Desktop\\xx.txt");
        int copy = FileCopyUtils.copy(in, out);
        System.out.println(copy);
    }


    @Test
    public void test2() throws IOException {
        File in = new File("D:\\工作文档\\短信确认登录.txt");
        byte[] bytes = FileCopyUtils.copyToByteArray(in);
        String str = new String(bytes);
        System.out.println(str);
    }


    @Test
    public void test3() throws IOException {
        File in = new File("D:\\工作文档\\短信确认登录.txt");
        File out = new File("C:\\Users\\ydyt16\\Desktop\\xx.txt");
        FileSystemUtils.copyRecursively(in, out);
    }

    @Test
    public void test4() {
        String str = "adBB";
        //首字母大写
        String s = StringUtils.capitalize(str);
        System.out.println(s);
    }

}
