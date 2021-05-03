package com.xu.bootweb.resolvers;

import entity.Account;
import entity.Girl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.reactive.HandlerMapping;


/**
 * @author xuhongda on 2021/4/27
 * com.xu.bootweb.resolvers
 * com-boot-ex
 */
@Component
@Slf4j
public class MyArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * Whether the given {@linkplain MethodParameter method parameter} is
     * supported by this resolver.
     *
     * @param parameter the method parameter to check
     * @return {@code true} if this resolver supports the supplied parameter;
     * {@code false} otherwise
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        Class<?> parameterType = parameter.getParameterType();
        boolean assignableFrom =parameterType.isAssignableFrom(Girl.class)|| parameterType.isAssignableFrom(Account.class);
        return assignableFrom;
    }


    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {



        Class<?> parameterType = parameter.getParameterType();

        if (parameterType.isAssignableFrom(Girl.class)){


            String name = (String)webRequest.getAttribute("name",RequestAttributes.SCOPE_REQUEST);

            if (name != null){
                if ("liu".equals(name)){
                   Girl girl = new Girl();
                   girl.setName("who");
                   girl.setAge(18);
                   return girl;
                }
            }


        }
        return null;
    }
}
