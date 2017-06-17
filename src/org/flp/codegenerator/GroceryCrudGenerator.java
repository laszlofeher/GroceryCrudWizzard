/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.codegenerator;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import org.flp.gccw.GCCWizardIterator;
import org.flp.gccw.model.GroceryCrudObject;
import org.flp.gccw.codegenerator.GroceryCrudCodeGenerator;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.editor.BaseDocument;
import org.netbeans.spi.editor.codegen.CodeGenerator;
import org.netbeans.spi.editor.codegen.CodeGeneratorContextProvider;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.util.Exceptions;
import org.openide.util.ImageUtilities;
import org.openide.util.Lookup;

public class GroceryCrudGenerator implements CodeGenerator {

    JTextComponent textComp;

    /**
     *
     * @param context containing JTextComponent and possibly other items
     * registered by {@link CodeGeneratorContextProvider}
     */
    private GroceryCrudGenerator(Lookup context) { // Good practice is not to save Lookup outside ctor
        textComp = org.netbeans.api.editor.EditorRegistry.lastFocusedComponent();
                
                //context.lookup(JTextComponent.class);
    }

    @MimeRegistration(mimeType = "text/x-php5", service = CodeGenerator.Factory.class)
    public static class Factory implements CodeGenerator.Factory {

        public List<? extends CodeGenerator> create(Lookup context) {
            return Collections.singletonList(new GroceryCrudGenerator(context));
        }
    }

    /**
     * The name which will be inserted inside Insert Code dialog
     */
    public String getDisplayName() {
        return "Grocery Crud generator";
    }

    /**
     * This will be invoked when user chooses this Generator from Insert Code
     * dialog
     */
    public void invoke() {
        WizardDescriptor wiz = new WizardDescriptor(new GCCWizardIterator());
        // {0} will be replaced by WizardDescriptor.Panel.getComponent().getName()
        // {1} will be replaced by WizardDescriptor.Iterator.name()
        wiz.setTitleFormat(new MessageFormat("{0} ({1})"));
        wiz.setTitle("Grocery Crud Code Generator");
        wiz.putProperty(WizardDescriptor.PROP_IMAGE, ImageUtilities.loadImage("org/flp/image/logo.jpg", true)); 
        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
//          ...do something...
            //ide kell beírni, hogy mit csináljon, ha 
            //készen van 
            Document doc = textComp.getDocument();
            try {
                JTextComponent editor = org.netbeans.api.editor.EditorRegistry.lastFocusedComponent();
                BaseDocument document = org.netbeans.editor.Utilities.getDocument(editor);
                
                int lineEnd = org.netbeans.editor.Utilities.getLineOffset(document, editor.getSelectionEnd());
                int lineStart = org.netbeans.editor.Utilities.getLineOffset(document, editor.getSelectionStart());
                int offset = org.netbeans.editor.Utilities.getRowStartFromLineOffset(document, lineStart);
                if (lineEnd == lineStart) {
                    //single line
                    GroceryCrudCodeGenerator codeG = new GroceryCrudCodeGenerator((GroceryCrudObject)wiz.getProperty("GroceryCrudObject"));
                    
                    //System.out.println("currentLine = " + lineStart);
                    document.insertString(offset, codeG.generateCode(), null);
                    /*try {
                        Connection connection = ((Connection)wiz.getProperty("Connection"));
                        if(connection != null){
                            connection.close();
                        }
                    } catch (SQLException ex) {
                    }*/
                } else {
                    //multiple lines
                 }
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }/*else if(DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.CANCEL_OPTION){
            try {
                Connection connection = ((Connection)wiz.getProperty("Connection"));
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException ex) {
                
            }
        }*/
    }
}