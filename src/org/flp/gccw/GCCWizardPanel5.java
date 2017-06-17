/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw;

import java.sql.Connection;
import javax.swing.event.ChangeListener;
import org.flp.gccw.model.GroceryCrudObject;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

public class GCCWizardPanel5 implements WizardDescriptor.Panel<WizardDescriptor> {
    /**
     * GroceryCrudObject 
     */
    private GroceryCrudObject gco;
    
    /**
     * The visual component that displays this panel. If you need to access the
     * component from this class, just use getComponent().
     */
    private GCCVisualPanel5 component;

    // Get the visual component for the panel. In this template, the component
    // is kept separate. This can be more efficient: if the wizard is created
    // but never displayed, or not all panels are displayed, it is better to
    // create only those which really need to be visible.
    @Override
    public GCCVisualPanel5 getComponent() {
        if (component == null) {
            component = new GCCVisualPanel5();
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
    }

    @Override
    public void storeSettings(WizardDescriptor wiz) {
        // use wiz.putProperty to remember current panel state
        wiz.putProperty("unsetAdd",         this.component.getUnsetAddJCombo());
        wiz.putProperty("unsetBackToList",  this.component.getUnsetBackToListJCombo());
        wiz.putProperty("unsetBootstrap",   this.component.getUnsetBootstrapJCombo());
        wiz.putProperty("unsetDelete",      this.component.getUnsetDeleteJCombo());
        wiz.putProperty("unsetEdit",        this.component.getUnsetEditJCombo());
        wiz.putProperty("unsetExport",      this.component.getUnsetExportJCombo());
        wiz.putProperty("unsetJquery",      this.component.getUnsetJquery());
        wiz.putProperty("unsetJqueryUI",    this.component.getUnsetJqueryUI());
        wiz.putProperty("unsetList",        this.component.getUnsetListJCombo());
        wiz.putProperty("unsetOperations",  this.component.getUnsetOperationsJCombo());
        wiz.putProperty("unsetRead",        this.component.getUnsetReadJCombo());
        wiz.putProperty("unsetPrint",       this.component.getUnsetPrintJCombo());
        this.gco.setUnsetAdd(this.component.getUnsetAddJCombo());
        this.gco.setUnsetBackToList(this.component.getUnsetBackToListJCombo());
        this.gco.setUnsetBootstrap(this.component.getUnsetBootstrapJCombo());
        this.gco.setUnsetDelete(this.component.getUnsetDeleteJCombo());
        this.gco.setUnsetEdit(this.component.getUnsetEditJCombo());
        this.gco.setUnsetExport(this.component.getUnsetExportJCombo());
        this.gco.setUnsetJquery(this.component.getUnsetJquery());
        this.gco.setUnsetJqueryUI(this.component.getUnsetJqueryUI());
        this.gco.setUnsetList(this.component.getUnsetListJCombo());
        this.gco.setUnsetOperations(this.component.getUnsetOperationsJCombo());
        this.gco.setUnsetRead(this.component.getUnsetReadJCombo());
        this.gco.setUnsetPrint(this.component.getUnsetPrintJCombo());

    }
}