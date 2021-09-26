package com.lviv.task.models;

public enum Color{
    WHITE("#ffffff"),
    BLACK("#000000"),
    RED("#FF0000"),
    BLUE("#0000FF"),
    GREEN("#00FF00");
    private String code;
    Color(String code){
        this.code = code;
    }
    public String getCode(){ return code;}
}
