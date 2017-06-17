/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author feherl
 */
public class TableThemeModel extends DefaultComboBoxModel<String>{
    private String[] tableTypesArray = {"datatables","flexigrid"};
    @Override
    public String getElementAt(int index) {
        return tableTypesArray[index]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        return 2; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
