package com.neo.importexcel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author duwei
 * @date 2019/8/8
 */
@Entity
public class ImportCollection {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(columnDefinition = "int comment '头部所在的行数'")
    private Integer headLineNum;
    @Column(columnDefinition = "varchar(255) comment '组'")
    private String group;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHeadLineNum() {
        return headLineNum;
    }

    public void setHeadLineNum(Integer headLineNum) {
        this.headLineNum = headLineNum;
    }
}
