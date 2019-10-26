package com.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author duwei
 * @date 2019/8/8
 */
@Entity
public class CaseLitigant {
    @Id
    @GeneratedValue
    private long id;
    @Column(columnDefinition = "int(11) comment '案件id'")
    private long caseId;
    @Column(columnDefinition = "varchar(255) comment '当事人姓名'")
    private String name;
    @Column(columnDefinition = "varchar(255) comment '身份证'")
    private String idNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
