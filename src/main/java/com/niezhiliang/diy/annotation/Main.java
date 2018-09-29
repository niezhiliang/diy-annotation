package com.niezhiliang.diy.annotation;

import com.niezhiliang.diy.annotation.pojo.Student;
import com.niezhiliang.diy.annotation.utils.AnnoUtils;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(AnnoUtils.createTable(Student.class));
    }
}
