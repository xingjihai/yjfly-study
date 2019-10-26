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
public class ImportSettingsDetail {

    /*
    *  id                   int(11) not null comment 'id',
   import_collection_id int(11) comment '集合id',
   table_name           varchar(255) comment '表名',
   table_field          varchar(255) comment '表字段',
   key                  varchar(255) comment '关键字',
   sheet_num            int(2) comment '标签码',
   type_code            varchar(255) comment '类型代号(字典、部门、日期等)',
   format               varchar(255) comment '类型格式',
   */
    @Id
    @GeneratedValue
    private long id;
    @Column(columnDefinition = "int(11) comment '集合id'")
    private long importCollectionId;
    @Column(columnDefinition = "varchar(255) comment '表名'")
    private String tableName;
    @Column(columnDefinition = "varchar(255) comment '表字段'")
    private String tableField;
    @Column(columnDefinition = "varchar(255) comment '关键字'")
    private String cellKey;
    @Column(columnDefinition = "int(2) comment '标签码'")
    private Integer sheetNum;
    @Column(columnDefinition = "varchar(255) comment '类型代号(字典、部门、日期等)'")
    private String typeCode;
    @Column(columnDefinition = "varchar(255) comment '类型格式'")
    private String format;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getImportCollectionId() {
        return importCollectionId;
    }

    public void setImportCollectionId(long importCollectionId) {
        this.importCollectionId = importCollectionId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableField() {
        return tableField;
    }

    public void setTableField(String tableField) {
        this.tableField = tableField;
    }

    public String getCellKey() {
        return cellKey;
    }

    public void setCellKey(String cellKey) {
        this.cellKey = cellKey;
    }

    public Integer getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(Integer sheetNum) {
        this.sheetNum = sheetNum;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
