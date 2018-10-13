package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xuhongda on 2018/9/29
 * entity
 * com-boot-ex
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeoPle {
    private Integer age;
    private String name;
}
