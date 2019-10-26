package com.neo.importexcel.common;

import java.util.List;

/**
 * @author duwei
 * @date 2019/8/8
 */
public interface TableFieldInterface {
    /**
     * 获取实体类
     * @param <T>
     * @return
     */
    <T> T getTableEntity();
    /**
     * 获取组别
     * @param <T>
     * @return
     */
    <T> T getGroup();

    /**
     * 获取关联表
     * @return
     */
    List<TableFieldInterface> getRelatedTableField();
}
