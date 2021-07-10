package entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author xuhongda on 2021/7/10
 * entity
 * com-boot-ex
 */
@Data
@ToString
public class Items {
    private String icon;
    private String index;
    private String title;
    private List<Subs> subs;
}
