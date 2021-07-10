package com.xu.bootweb.others;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Items;
import org.junit.Test;

/**
 * @author xuhongda on 2021/7/10
 * com.xu.bootweb.others
 * com-boot-ex
 */
public class ItemsTest {
    @Test
    public void test() throws JsonProcessingException {
        Items items = new Items();
        items.setIcon("x");
        items.setTitle("a");
        items.setIndex("1-1");
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(items);
        System.out.println(s);
    }
}
