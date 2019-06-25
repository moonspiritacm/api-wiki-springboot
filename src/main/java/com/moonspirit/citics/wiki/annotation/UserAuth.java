package com.moonspirit.citics.wiki.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName      UserAuth
 * @Description    只有文章/项目创建者方可访问
 * @author         moonspirit
 * @date           2019年6月24日 下午5:20:50
 * @version        1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAuth {
}
