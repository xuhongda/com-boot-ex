package com.xu.bootweb.properties;

import entity.Girl;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/10/16
 * com.xu.bootweb.properties
 * com-boot-ex
 */
@Component
@ConfigurationProperties(prefix = "com.xu")
@Data
public class MyProperties {
    private Girl girl;
}
