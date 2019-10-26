package com.neo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author duwei
 * @date 2019/8/8
 */
@Entity
public class JudicialCase {
    @Id
    @GeneratedValue
    private long id;
    @Column(columnDefinition = "varchar(255) comment '案号'")
    private String caseCode;
    @Column(columnDefinition = "varchar(255) comment '案号年份'")
    private String caseCodeYear;
    @Column(columnDefinition = "varchar(255) comment '审判字号'")
    private String caseCodeWord;
    @Column(columnDefinition = "varchar(255) comment '案号流水号'")
    private String caseCodeSn;
    @Column(columnDefinition = "int(11) comment  '承办部门id'")
    private long deptId;
    @Column(columnDefinition = "varchar(255) comment '承办部门名称'")
    private String deptName;
    @Column(columnDefinition = "int(11) comment  '案由id'")
    private long caseCauseId;
    @Column(columnDefinition = "varchar(255) comment '案由名称'")
    private String caseCauseName;
    @Column(columnDefinition = "datetime comment '立案日期'")
    private Date registerDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseCodeYear() {
        return caseCodeYear;
    }

    public void setCaseCodeYear(String caseCodeYear) {
        this.caseCodeYear = caseCodeYear;
    }

    public String getCaseCodeWord() {
        return caseCodeWord;
    }

    public void setCaseCodeWord(String caseCodeWord) {
        this.caseCodeWord = caseCodeWord;
    }

    public String getCaseCodeSn() {
        return caseCodeSn;
    }

    public void setCaseCodeSn(String caseCodeSn) {
        this.caseCodeSn = caseCodeSn;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public long getCaseCauseId() {
        return caseCauseId;
    }

    public void setCaseCauseId(long caseCauseId) {
        this.caseCauseId = caseCauseId;
    }

    public String getCaseCauseName() {
        return caseCauseName;
    }

    public void setCaseCauseName(String caseCauseName) {
        this.caseCauseName = caseCauseName;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
