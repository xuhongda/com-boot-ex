package entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xuhongda on 2019/6/18
 * entity
 * com-boot-ex
 */
@Data
@ToString
public class Account implements Serializable {

    private String username;

    private String password;
}
