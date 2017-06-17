/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

/**
 *
 * @author feherl
 */
public class Table {
    private String tableName;
    private String relationFieldName;

    Table(String[] split) {
        if(split != null && split.length == 2){
            this.tableName          = split[0];
            this.relationFieldName  = split[1];
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRelationFieldName() {
        return relationFieldName;
    }

    public void setRelationFieldName(String relationFiledName) {
        this.relationFieldName = relationFiledName;
    }

    @Override
    public String toString() {
        return tableName;
    }
    
    
    
}
