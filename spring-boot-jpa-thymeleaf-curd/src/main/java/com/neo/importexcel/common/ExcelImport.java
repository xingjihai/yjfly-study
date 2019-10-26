package com.neo.importexcel.common;

import com.neo.importexcel.entity.ImportCollection;
import com.neo.importexcel.entity.ImportSettingsDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author duwei
 * @date 2019/8/8
 */
public abstract class ExcelImport {
    public static Logger logger = LoggerFactory.getLogger(ExcelImport.class);

    @Autowired
    private ApplicationContext applicationContext;

    public void importFile(File file, ImportCollection importCollection) {
        // 获取配置 <Sheet,<key ,ImportSettingsDetail >>
        Map<Integer, Map<String, ImportSettingsDetail>> keySettings = getSettings(importCollection);
        //解析文件
        Map<Integer, List<String[]>> excelMap = analysisFile(file);
        //模板校验
        checkFile(excelMap, keySettings);
        // 循环配置填充
        fillField(excelMap, keySettings, importCollection);
        // 判空和去除无需插入的对象
        // 批量插入和插入前后的事件触发

        // 返回导入信息
    }

    private Map<Integer, Map<String, ImportSettingsDetail>> getSettings(ImportCollection importCollection) {
        return null;
    }

    /**
     * 循环配置填充
     *
     * @param excelMap
     * @param keySettings
     */
    private void fillField(Map<Integer, List<String[]>> excelMap, Map<Integer, Map<String, ImportSettingsDetail>> keySettings,ImportCollection importCollection) {
        Iterator<Map.Entry<Integer, List<String[]>>> iterator = excelMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<String[]>> entry = iterator.next();
            // 标签
            Integer sheet = entry.getKey();
            // 内容
            List<String[]> sheetList = entry.getValue();
            // 配置
            Map<String, ImportSettingsDetail> sheetKeySettings = keySettings.get(sheet);
            // 头部 TODO 多个sheet 头部不一样
            Integer headLineNum = importCollection.getHeadLineNum();

            String[] headArr = new String[0];
            if(sheetList.size() < headLineNum){
                logger.error("获取头部异常");
                // TODO 异常抛出
            } else {
                headArr = sheetList.get(headLineNum);
            }
            // 遍历每行
            for (int i = 0; i < sheetList.size(); i++) {
                String[] data = sheetList.get(i);

                // TODO headArr sheetList 数组集合长度判断
                // 字段填充
                ImportSettingsDetail importSettingsDetail = sheetKeySettings.get(headArr[i]);

                // 获取配置类

                // 查找与表字段匹配的类,填充进类中.

            }
        }
    }

    public void getBeans(){
        Map<String, TableFieldInterface> map = applicationContext.getBeansOfType(TableFieldInterface.class);
    }
    /**
     * 模板校验
     *
     * @param excelMap
     * @param keySettings
     */
    private void checkFile(Map<Integer, List<String[]>> excelMap, Map<Integer, Map<String, ImportSettingsDetail>> keySettings) {
    }

    /**
     * 解析文件
     *
     * @param file
     * @return
     */
    private Map<Integer, List<String[]>> analysisFile(File file) {
        return null;
    }

}
