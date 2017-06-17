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
public class SelectableListBoxModel extends AbstractListModel<String>{
    private ArrayList<String> list = new ArrayList();
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public String getElementAt(int index) {
        return list.get(index);
    }
    
    public void add(String s){
        this.list.add(s);
        this.fireIntervalAdded(this.list, 0, this.getSize());
    }
    
    public String remove(int index){
        int count = this.list.size();
        String s = this.list.remove(index);
        this.fireIntervalRemoved(this.list, 0, count);
        return s;
    }
    
    public ArrayList<String> removeAll(){
        ArrayList<String> copyList = new ArrayList();
        int count = this.list.size();
        for (int i = 0; i < this.list.size(); i++) {
            copyList.add(this.list.get(i));
        }
        this.list.clear();
        this.fireIntervalRemoved(this.list, 0, count);
        return copyList;
    }
    
    public void addAll(ArrayList<String> list){
        this.list.addAll(list);
        this.fireIntervalAdded(list, 0, this.getSize());
    }

    public ArrayList<String> getList() {
        return list;
    }
    
    
    
}
