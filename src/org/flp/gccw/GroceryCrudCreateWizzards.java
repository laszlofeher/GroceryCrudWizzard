/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
package org.flp.gccw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;

@ActionID(
        category = "Tools",
        id = "org.flp.gccw.GroceryCrudCreateWizzards"
)
@ActionRegistration(
        displayName = "#CTL_GroceryCrudCreateWizzards"
)
@ActionReference(path = "Menu/Tools", position = 0, separatorAfter = 50)
//@Messages("CTL_GroceryCrudCreateWizzards=GroceryCrudCreateWizzards")

public final class GroceryCrudCreateWizzards implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        WizardDescriptor wiz = new WizardDescriptor(new GCCWizardIterator());
                 // {0} will be replaced by WizardDescriptor.Panel.getComponent().getName()
                 // {1} will be replaced by WizardDescriptor.Iterator.name()
                 wiz.setTitleFormat(new MessageFormat("{0} ({1})"));
                 wiz.setTitle("...dialog title...");
                 if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
    //                 ...do something...
                 }
    }
}
*/