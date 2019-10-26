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
public class CaseLitigantAddress {
    @Id
    @GeneratedValue
    private long id;
    @Column(columnDefinition = "int(11) comment '案件id'")
    private long caseId;
    @Column(columnDefinition = "int(11) comment '案件当事人id'")
    private long caseLitigantId;
    @Column(columnDefinition = "varchar(255) comment '地址'")
    private String address;

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

    public long getCaseLitigantId() {
        return caseLitigantId;
    }

    public void setCaseLitigantId(long caseLitigantId) {
        this.caseLitigantId = caseLitigantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
