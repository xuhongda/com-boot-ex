package com.xu.bootweb.exception;

/**
 * @author xuhongda on 2018/10/17
 * com.xu.bootweb.exception
 * com-boot-ex
 */
public class ZeRoException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = -6112780192479692859L;

    private String id;

    public ZeRoException(String id) {
        super();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
