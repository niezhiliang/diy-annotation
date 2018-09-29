package com.niezhiliang.diy.annotation.annos;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * 可见@Target 注解只有唯一成员value，类型为ElementType数组。查看ElementType的源码可以发现，ElementType可取的值有：
 *
 * CONSTRUCTOR：用于描述构造器；
 *
 * FIELD：用于描述成员变量；
 *
 * LOCAL_VARIABLE：用于描述局部变量；
 *
 * METHOD：用于描述方法；
 *
 * PACKAGE：用于描述包；
 *
 * PARAMETER：用于描述参数；
 *
 * TYPE：用于描述类、接口(包括注解类型) 或enum声明。
 */
//在运行时有效（即运行时保留）
@Retention(RetentionPolicy.RUNTIME)
//用于描述类
@Target(ElementType.TYPE)
public @interface Table {
    String name();//name用来设置表名
}
