/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author feherl
 */
public class RelationListBoxModel extends AbstractListModel<Table>{
    private ArrayList<Table> list = new ArrayList();
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Table getElementAt(int index) {
        return list.get(index);
    }
    
    public void add(Table s){
        this.list.add(s);
        this.fireIntervalAdded(this.list, 0, this.getSize());
    }
    
    public Table remove(int index){
        int count = this.list.size();
        Table s = this.list.remove(index);
        this.fireIntervalRemoved(this.list, 0, count);
        return s;
    }
    
    public ArrayList<Table> removeAll(){
        ArrayList<Table> copyList = new ArrayList();
        int count = this.list.size();
        for (int i = 0; i < this.list.size(); i++) {
            copyList.add(this.list.get(i));
        }
        this.list.clear();
        this.fireIntervalRemoved(this.list, 0, count);
        return copyList;
    }
    
    public void addAll(ArrayList<Table> list){
        this.list.addAll(list);
        this.fireIntervalAdded(list, 0, this.getSize());
    }
    public void addAll(String s){
        String[] ss = s.split(";");
        for (int i = 0; i < ss.length; i++) {
            Table t = new Table(ss[i].split("[.]"));
            this.list.add(t);
        }
        this.fireIntervalAdded(list, 0, this.getSize());
    }

    public ArrayList<Table> getList() {
        return list;
    }
    
    
    
}
