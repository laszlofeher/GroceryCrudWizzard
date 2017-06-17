/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.gccw.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author feherl
 */
public class DatabaseTableLister {

    private Connection connection;

    public DatabaseTableLister(Connection connection) {
        this.connection = connection;
    }

    public DatabaseTableLister() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String detectRelationSchip(String tableName) {
        DatabaseMetaData dbmd = null;
        String s = "";
        try {
            if (this.connection != null && tableName != null) {
                dbmd = this.connection.getMetaData();
                ResultSet rs = dbmd.getExportedKeys(null, null, tableName);
                while(rs.next()){
                    s += rs.getString("FKTABLE_NAME")+"."+rs.getString("FKCOLUMN_NAME")+";";
                }
            }
            return s;
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        return s;
    }

    public ArrayList<String> getTables() {
        ArrayList<String> listOfTables = new ArrayList();
        DatabaseMetaData dbmd = null;

        try {
            if (this.connection != null) {
                dbmd = this.connection.getMetaData();

                ResultSet res = dbmd.getTables(null, null, null, new String[]{"TABLE"});
                while (res.next()) {
                    if (res.getString("TABLE_SCHEM") != null) {
                        listOfTables.add(res.getString("TABLE_SCHEM") + "." + res.getString("TABLE_NAME"));
                    } else {
                        listOfTables.add(res.getString("TABLE_NAME"));
                    }
                }
                res.close();
            } else {
                JOptionPane.showMessageDialog(null, "A kapcsolat nem jött létre!", "Hiba", JOptionPane.YES_NO_OPTION);
            }
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        return listOfTables;
    }

    public ArrayList<String> getFields(String tablename) {
        ArrayList<String> listOfFields = new ArrayList();
        try {
            DatabaseMetaData dbmd = this.connection.getMetaData();
            ResultSet res = dbmd.getColumns(null, null, tablename, null);
            while (res.next()) {
                //String name = resultSet.getString("COLUMN_NAME");
                //String type = resultSet.getString("TYPE_NAME");
                //int size = resultSet.getInt("COLUMN_SIZE");
                listOfFields.add(res.getString("COLUMN_NAME"));
            }
            res.close();
        } catch (SQLException ex) {
            Exceptions.printStackTrace(ex);
        }
        return listOfFields;
    }

}
