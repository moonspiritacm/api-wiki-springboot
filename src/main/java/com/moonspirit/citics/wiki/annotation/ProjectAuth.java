package com.moonspirit.citics.wiki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName      OwnerAuth
 * @Description    只有项目组成员方可访问
 * @author         moonspirit
 * @date           2019年6月24日 下午5:20:50
 * @version        1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProjectAuth {
}
