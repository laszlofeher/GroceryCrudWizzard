/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import org.flp.gccw.sql.DatabaseTableLister;

/**
 *
 * @author feherl
 */
public class ListTablesModel extends DefaultComboBoxModel<String>{
    ArrayList<String> tableList = new ArrayList<String>();

    public ListTablesModel(Connection connection) {
        DatabaseTableLister dT = new DatabaseTableLister(connection);
        this.tableList.addAll(dT.getTables());
        this.fireIntervalAdded(this.tableList, 0, this.tableList.size());
    }

    public ListTablesModel() {
    }
    
    
    
    
    @Override
    public int getSize() {
        return this.tableList.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.tableList.get(index);
    }
    
    public void refresh(Connection connection){
        DatabaseTableLister dT = new DatabaseTableLister(connection);
        this.tableList.addAll(dT.getTables());
        this.fireIntervalAdded(this.tableList, 0, this.tableList.size());
    }
    
}
