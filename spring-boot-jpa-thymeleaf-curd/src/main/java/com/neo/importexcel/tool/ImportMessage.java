package com.neo.importexcel.tool;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/** 导入信息
 * @author wuyijia
 */
public class ImportMessage {
    private String title="导入信息:";
    private List<String> msgList = new ArrayList<>();

    private List<cellErrorMsg> cellErrorMsgList = new ArrayList<>();

    private List<rowMessage> rowMsgList = new ArrayList<>();
    private int successSaveCount=0;
    private int successUpdateCount=0;
    private List<String> updateCodeList = new ArrayList<>();
    private int i;
    private int j;
    private boolean isError=false;
    public void addMsg(String message){
        String countStr=ExcelFormatTool.excelCount(j+1,"");

        cellErrorMsgList.add( new cellErrorMsg(i+1,countStr,message)  );
        isError=true;
    }



    public void isError(int i){
        rowMsgList.add(new rowMessage(i+1,"未导入成功请重新导入") );
    }
    public void isSuccess(int i,Boolean isSave,String code){
        if(isSave==null){
            return ;
        }
        if(isSave){
            successSaveCount++;
        }else{
            successUpdateCount++;
            if(!StringUtils.isEmpty(code)){
                updateCodeList.add(code);
            }
        }
    }

    public void setIndex(Integer i,Integer j){
        if(i!=null){
            this.i=i;
        }
        if(j!=null){
            this.j=j;
        }

    }

    public int getJ() {
        return j;
    }


    public boolean hasError(){
        if(isError){
            isError=false;
            return true;
        }else{
            return false;
        }
    }

    public List<String> getUpdateCodeList() {
        return updateCodeList;
    }

    public void setUpdateCodeList(List<String> updateCodeList) {
        this.updateCodeList = updateCodeList;
    }




    class rowMessage{
        private Integer row;
        private String rowMsg;

        rowMessage(Integer row,String rowMsg){
            this.row=row;
            this.rowMsg=rowMsg;
        }

        public Integer getRow() {
            return row;
        }

        public void setRow(Integer row) {
            this.row = row;
        }

        public String getRowMsg() {
            return rowMsg;
        }

        public void setRowMsg(String rowMsg) {
            this.rowMsg = rowMsg;
        }
    }

    class cellErrorMsg{
        private Integer i;
        private String j;
        private String errorMsg;

        cellErrorMsg(Integer i,String j,String errorMsg){
            this.i=i;
            this.j=j;
            this.errorMsg=errorMsg;
        }

        public Integer getI() {
            return i;
        }

        public void setI(Integer i) {
            this.i = i;
        }

        public String getJ() {
            return j;
        }

        public void setJ(String j) {
            this.j = j;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }
    }

    public List<String> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<String> msgList) {
        this.msgList = msgList;
    }

    public List<cellErrorMsg> getCellErrorMsgList() {
        return cellErrorMsgList;
    }

    public void setCellErrorMsgList(List<cellErrorMsg> cellErrorMsgList) {
        this.cellErrorMsgList = cellErrorMsgList;
    }

    public List<rowMessage> getRowMsgList() {
        return rowMsgList;
    }

    public void setRowMsgList(List<rowMessage> rowMsgList) {
        this.rowMsgList = rowMsgList;
    }

    public int getSuccessSaveCount() {
        return successSaveCount;
    }

    public void setSuccessSaveCount(int successSaveCount) {
        this.successSaveCount = successSaveCount;
    }

    public int getSuccessUpdateCount() {
        return successUpdateCount;
    }

    public void setSuccessUpdateCount(int successUpdateCount) {
        this.successUpdateCount = successUpdateCount;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
