package com.moonspirit.citics.wiki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName      LoginAuth
 * @Description    只有登录用户方可访问
 * @author         moonspirit
 * @date           2019年6月25日 上午9:02:58
 * @version        1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginAuth {
}
