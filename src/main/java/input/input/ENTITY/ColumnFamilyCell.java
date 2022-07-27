package input.input.ENTITY;


import input.entiy.Restfulentiy;

/**
 * @author : wyy
 * @Date : 2022.7.11
 */
public class ColumnFamilyCell extends Restfulentiy {
    private String cf_name;
    private String type;
    private double min;
    private double max;
    private boolean unique;
    private boolean isNull;
    private int Version;
    private String method;
 }
