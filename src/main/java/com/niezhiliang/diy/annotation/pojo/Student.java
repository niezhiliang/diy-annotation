package com.niezhiliang.diy.annotation.pojo;


import com.niezhiliang.diy.annotation.annos.Column;
import com.niezhiliang.diy.annotation.annos.Table;

import java.util.Date;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@Table(name = "Student")
public class Student {

    @Column(name = "name",length = 10)
    private String name;

    @Column(name = "sex",length = 2)
    private String sex;

    @Column(name = "birthday", defaultValue = "CURRENT_TIMESTAMP")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
