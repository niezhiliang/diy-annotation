package com.niezhiliang.diy.annotation.annos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    //用来设置字段的名称
    String name() default "";

    //用来设置字段的长度
    int length() default 0;

    //用来设置字段的默认值
    String defaultValue() default "";
}
