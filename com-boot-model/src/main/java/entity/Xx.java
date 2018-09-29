package entity;

/**
 * @author xuhongda on 2018/9/29
 * entity
 * com-boot-ex
 */
public class Xx {
    Integer a;
    Integer b;
    Integer c;

    public Xx() {
    }

    public Xx(Integer a, Integer b, Integer c) {
        System.out.println(c + 1);
        /* notice that null not do operation */
        Integer d = 9 / c + 1;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }
}
