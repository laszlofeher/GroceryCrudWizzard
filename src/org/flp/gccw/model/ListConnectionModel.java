/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import org.netbeans.api.db.explorer.ConnectionManager;
import org.netbeans.api.db.explorer.DatabaseConnection;

/**
 *
 * @author feherl
 */
public class ListConnectionModel extends DefaultComboBoxModel<String>{
    private ArrayList<DatabaseConnection> dbConnectionList = new ArrayList();
    private ArrayList<String> dbConnectionNameList = new ArrayList();

    public ListConnectionModel() {
        this.dbConnectionList.clear();
        this.dbConnectionNameList.clear();
        this.dbConnectionList.addAll(Arrays.asList(ConnectionManager.getDefault().getConnections()));
        this.dbConnectionNameList.add("New database connection ...");
        for (DatabaseConnection dbConnection : dbConnectionList) {
            this.dbConnectionNameList.add(dbConnection.getDisplayName());
        }
        
        this.fireIntervalAdded(this.dbConnectionNameList, 0, this.dbConnectionNameList.size());
    }
    
    
    @Override
    public int getSize() {
        return this.dbConnectionNameList.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.dbConnectionNameList.get(index);
    }
    
    
    public void refresh(){
        this.dbConnectionList.clear();
        this.dbConnectionNameList.clear();
        this.dbConnectionList.addAll(Arrays.asList(ConnectionManager.getDefault().getConnections()));
        this.dbConnectionNameList.add("New database connection ...");
        for (DatabaseConnection dbConnection : dbConnectionList) {
            this.dbConnectionNameList.add(dbConnection.getDisplayName());
        }
        
        this.fireIntervalAdded(this, 0, this.dbConnectionNameList.size());
    }
    
    /**
     * Az indexből minusz egyet levonunk, mert ne a "new connection create" 
     * re hivatkozzunk.
     * 
     * @param index
     * @return 
     */
    
    
    public DatabaseConnection getDbConnection(int index){
        if(index>0){
            return this.dbConnectionList.get(index-1);
        }else{
            return null;
        }
    }
    
    
    
    
}
