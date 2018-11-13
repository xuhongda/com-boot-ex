package entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import validator.MyConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author xuhongda on 2018/9/12
 * entity
 * com-boot-ex
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Girl {

    public interface GirlSimpleView {
    }

    public interface GirlDetailView extends GirlSimpleView {
    }

    /**
     * 自定义校验
     */
    @MyConstraint(message = "测试")
    private String age;

    @JsonView(GirlSimpleView.class)
    private String name;

    @JsonView(GirlDetailView.class)
    private String weight;

    @NotBlank(message = "密码不能为空")
    private String password;

    @Past(message = "生日必须是过去的时间")
    private Date birthday;
}
