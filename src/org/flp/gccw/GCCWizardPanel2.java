/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw;

import java.sql.Connection;
import javax.swing.event.ChangeListener;
import org.flp.gccw.model.GroceryCrudObject;
import org.flp.gccw.sql.DatabaseTableLister;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

public class GCCWizardPanel2 implements WizardDescriptor.Panel<WizardDescriptor> {
    
    /**
     * GroceryCrudObject 
     */
    private GroceryCrudObject gco;
    
    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private GCCVisualPanel2 component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public GCCVisualPanel2 getComponent() {
        if (component == null) {
            component = new GCCVisualPanel2();
        }
        return component;
    }

    @Override
    public HelpCtx getHelp() {
        // Show no Help button for this panel:
        return HelpCtx.DEFAULT_HELP;
        // If you have context help:
        // return new HelpCtx("help.key.here");
    }

    @Override
    public boolean isValid() {
        // If it is always OK to press Next or Finish, then:
        return true;
        // If it depends on some condition (form filled out...) and
        // this condition changes (last form field filled in...) then
        // use ChangeSupport to implement add/removeChangeListener below.
        // WizardDescriptor.ERROR/WARNING/INFORMATION_MESSAGE will also be useful.
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override
    public void readSettings(WizardDescriptor wiz) {
        // use wiz.getProperty to retrieve previous panel state
        this.gco = (GroceryCrudObject)wiz.getProperty("GroceryCrudObject");
        Connection connection = (Connection)wiz.getProperty("Connection");
        DatabaseTableLister dtl = null;
        if(this.component != null && connection != null && !wiz.getProperties().containsKey("columnsettings")){
            dtl = new DatabaseTableLister(connection);
            this.component.setFieldsList(dtl.getFields(this.gco.getTableName()));
        }        
        /* only test
        InputOutput io = IOProvider.getDefault().getIO("Element Output", null);
        try {
            IOColorLines.println(io, "Tábla név "+this.gco.getTableName(), Color.GREEN);
            IOColorLines.println(io, "Component is null "+this.component != null ? "Nem" : "Igen", Color.GREEN);
            for(String e : dtl.getFields(this.gco.getTableName())){
                 IOColorLines.println(io, e, Color.GREEN);
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }*/
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
        wiz.putProperty("columnsettings", this.component.getSelectedFields());
        if(this.gco != null){
            this.gco.setColumnsList(this.component.getSelectedFields());
            wiz.putProperty("GroceryCrudObject", this.gco);
        }
    }

}
