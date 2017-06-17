/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

import java.util.ArrayList;

/**
 *
 * @author feherl
 */
public class GroceryCrudObject {
    private String tableName;
    private String tableTheme;
    private String tableText;
    private ArrayList<FieldObject>  fieldsList;
    private ArrayList<String>       columnsList;
    private ArrayList<Table>        relationShipTables;
    private boolean unsetAdd;
    private boolean unsetBackToList;
    private boolean unsetBootstrap;
    private boolean unsetDelete;
    private boolean unsetEdit;
    private boolean unsetExport;
    private boolean unsetJquery;
    private boolean unsetJqueryUI;
    private boolean unsetList;
    private boolean unsetOperations;
    private boolean unsetRead;
    private boolean unsetPrint;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableTheme() {
        return tableTheme;
    }

    public void setTableTheme(String tableTheme) {
        this.tableTheme = tableTheme;
    }

    public String getTableText() {
        return tableText;
    }

    public void setTableText(String tableText) {
        this.tableText = tableText;
    }

    public boolean isUnsetAdd() {
        return unsetAdd;
    }

    public void setUnsetAdd(boolean unsetAdd) {
        this.unsetAdd = unsetAdd;
    }

    public boolean isUnsetDelete() {
        return unsetDelete;
    }

    public void setUnsetDelete(boolean unsetDelete) {
        this.unsetDelete = unsetDelete;
    }

    public boolean isUnsetRead() {
        return unsetRead;
    }

    public void setUnsetRead(boolean unsetRead) {
        this.unsetRead = unsetRead;
    }

    public boolean isUnsetEdit() {
        return unsetEdit;
    }

    public void setUnsetEdit(boolean unsetEdit) {
        this.unsetEdit = unsetEdit;
    }

    public boolean isUnsetPrint() {
        return unsetPrint;
    }

    public void setUnsetPrint(boolean unsetPrint) {
        this.unsetPrint = unsetPrint;
    }

    public boolean isUnsetBackToList() {
        return unsetBackToList;
    }

    public void setUnsetBackToList(boolean unsetBackToList) {
        this.unsetBackToList = unsetBackToList;
    }

    public boolean isUnsetBootstrap() {
        return unsetBootstrap;
    }

    public void setUnsetBootstrap(boolean unsetBootstrap) {
        this.unsetBootstrap = unsetBootstrap;
    }

    public boolean isUnsetExport() {
        return unsetExport;
    }

    public void setUnsetExport(boolean unsetExport) {
        this.unsetExport = unsetExport;
    }

    public boolean isUnsetJquery() {
        return unsetJquery;
    }

    public void setUnsetJquery(boolean unsetJquery) {
        this.unsetJquery = unsetJquery;
    }

    public boolean isUnsetJqueryUI() {
        return unsetJqueryUI;
    }

    public void setUnsetJqueryUI(boolean unsetJqueryUI) {
        this.unsetJqueryUI = unsetJqueryUI;
    }

    public boolean isUnsetList() {
        return unsetList;
    }

    public void setUnsetList(boolean unsetList) {
        this.unsetList = unsetList;
    }

    public boolean isUnsetOperations() {
        return unsetOperations;
    }

    public void setUnsetOperations(boolean unsetOperations) {
        this.unsetOperations = unsetOperations;
    }
    
    public ArrayList<FieldObject> getFieldsList() {
        return fieldsList;
    }

    public ArrayList<String> getColumnsList() {
        return columnsList;
    }

    public void setFieldsList(ArrayList<FieldObject> fieldsList) {
        this.fieldsList = fieldsList;
    }

    public void setColumnsList(ArrayList<String> columnsList) {
        this.columnsList = columnsList;
    }

    public ArrayList<Table> getRelationShipTables() {
        return relationShipTables;
    }

    public void setRelationShipTables(ArrayList<Table> relationShipTables) {
        this.relationShipTables = relationShipTables;
    }
}