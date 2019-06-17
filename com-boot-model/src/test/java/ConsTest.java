import entity.Xx;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author xuhongda on 2018/9/29
 * PACKAGE_NAME
 * com-boot-ex
 */
public class ConsTest {
    public static void main(String[] args) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        Xx xx = new Xx(a, b, c);
    }


    @Test
    public void test(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4);
        List<Integer> list = Arrays.asList(1, 2);
        boolean b = integers.retainAll(list);
        System.out.println(b);
    }
}
