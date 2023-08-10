package org.example.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author goku
 * @datetime 2023/8/8 2:53 PM
 */
@Documented
@Inherited
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
    // 定义带成员变量的注解。注解中的成员变量也可以有默认值，可使用 default 关键字。
    // 注解中的成员变量以方法的形式来定义，其方法名和返回值定义了该成员变量的名字和类型
    String value() default "";
}
