package com.xu.bootweb.resolvers;

import com.xu.bootweb.annotation.InMyHeart;
import entity.Girl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MultipartResolutionDelegate;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;


/**
 * @author xuhongda on 2021/4/27
 * com.xu.bootweb.resolvers
 * com-boot-ex
 */
@Component
@Slf4j
public class MyArgumentResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        boolean assignableFrom = parameter.getParameterType().isAssignableFrom(Girl.class);
        return assignableFrom;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        String myHeartGirlName = Objects.requireNonNull(parameter.getParameterAnnotation(InMyHeart.class)).name();

        Girl girl = new Girl();
        String age = webRequest.getParameter("age");
        String name = webRequest.getParameter("name");
        girl.setAge(Integer.valueOf(age));
        girl.setName(name);

        Class<?> parameterType = parameter.getParameterType();
        if (parameterType.isAssignableFrom(Girl.class)){
            if (name != null){
                if (myHeartGirlName.contains(name)){
                    girl.setInMyHeart(true);
                    return girl;
                }
            }
        }
        return girl;
    }
}
