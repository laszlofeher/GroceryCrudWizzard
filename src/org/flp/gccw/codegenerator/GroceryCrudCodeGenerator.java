/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.codegenerator;

import org.flp.gccw.model.FieldObject;
import org.flp.gccw.model.GroceryCrudObject;
import org.flp.gccw.model.Table;

/**
 *
 * @author feherl
 */
public class GroceryCrudCodeGenerator {
    private String code = "";
    private GroceryCrudObject gco;

    public GroceryCrudCodeGenerator(GroceryCrudObject gco) {
        this.gco = gco;
    }
    
    public String generateCode(){
        if(this.gco!= null){
            
            
            
            //Create crud 
            this.code += "$crud = new grocery_CRUD();"+System.getProperty("line.separator");
            //set table
            this.code += "$crud->set_table('"+this.gco.getTableName()+"');"+System.getProperty("line.separator");
            //set subject
            this.code += "$crud->set_subject('"+this.gco.getTableText()+"');"+System.getProperty("line.separator");
            // set theme
            this.code += "$crud->set_theme('"+this.gco.getTableTheme()+"');"+System.getProperty("line.separator");
            // set columns
            int counter = 0;
            this.code += "$crud->columns(";
            for (String columnText : this.gco.getColumnsList()) {
                if(counter++ != this.gco.getColumnsList().size()-1){
                    this.code += "'"+columnText+"',";
                }else{
                    this.code += "'"+columnText+"'";
                }
                
            }
            this.code += ");"+System.getProperty("line.separator");
            //set fields
            //some code
            counter = 0;
            this.code += "$crud->fields(";
            for (FieldObject field : this.gco.getFieldsList()) {
                if(counter++ != this.gco.getFieldsList().size()-1){
                    this.code += "'"+field.getFieldName()+"',";
                }else{
                    this.code += "'"+field.getFieldName()+"'";
                }
            }
            this.code += ");"+System.getProperty("line.separator");
            //set 1-n relation
            for (Table table : this.gco.getRelationShipTables()) {
                if(table.getRelationFieldName() != null){
                    this.code += "$crud->set_relation('"+table.getRelationFieldName()+"','"+table.getTableName()+"',null /*please write default fieldname*/);"+System.getProperty("line.separator");
                }
            }
            
            /*
            unset functions, without fields list
            */
            
            if(this.gco.isUnsetAdd()){
                this.code += "$crud->unset_add();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetBackToList()){
                this.code += "$crud->unset_back_to_list();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetBootstrap()){
                this.code += "$crud->unset_bootstrap();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetDelete()){
                this.code += "$crud->unset_delete();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetEdit()){
                this.code += "$crud->unset_edit();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetExport()){
                this.code += "$crud->unset_export();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetJquery()){
                this.code += "$crud->unset_jquery();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetJqueryUI()){
                this.code += "$crud->unset_jquery_ui();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetList()){
                this.code += "$crud->unset_list();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetOperations()){
                this.code += "$crud->unset_operations();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetPrint()){
                this.code += "$crud->unset_print();"+System.getProperty("line.separator");
            }
            
            if(this.gco.isUnsetRead()){
                this.code += "$crud->unset_read();"+System.getProperty("line.separator");
            }

            this.code += "$output = $crud->render();";
        }
        return this.code;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
