/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package teslapowerwallvalidate;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author markvaleri
 */
public class SmallTableModel extends AbstractTableModel {

    private String[] columnNames = null;
    private Object[][] data = null;

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    public String[] getColumnNames() {
        return columnNames;
    }    
    
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    // Tesla Add retrieve ALL column names  - mlv added getter method
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    // Tesla Add Set ALL column names  - mlv added setter method
    public void setColumnNames(String[] names) {
         columnNames = names;
    }    
    
    // Pass data to be displayed
    
    public void setTableData(Object[][] tableData) {
        data = tableData;
    }
    
    public Object[][] getTableData() {
        return data;
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
//        //Note that the data/cell address is constant,
//        //no matter where the cell appears onscreen.
//        if (col < 2) {
//            return false;
//        } else {
//            return true;
//        }
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
//    public void setValueAt(Object value, int row, int col) {
//        data[row][col] = value;
//        fireTableCellUpdated(row, col);
//
//    }
//

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    
}

