package by.zverugo.bsuir.ppvis.workerwithdate.view;

import by.zverugo.bsuir.ppvis.workerwithdate.controller.TableInputController;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 23.05.2015.
 */
public class DateTableModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private TableInputController tableInputController;
    private boolean flag;

    public DateTableModel(TableInputController tableInputController) {
        this.tableInputController = tableInputController;
        flag = true;
    }


    public void addTableModelListener(TableModelListener listener) {
        listeners.add(listener);
    }

    public void removeTableModelListener(TableModelListener listener) {
        listeners.remove(listener);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return tableInputController.getColumnClass(columnIndex);
    }

    public int getColumnCount() {
        return 4;
    }

    public int getRowCount() {

        return tableInputController.getVisibleTable().size();
    }


    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "ФИО";
            case 1:
                return "Дата рождения";
            case 2:
                return "Дата поступления в вуз";
            case 3:
                return "Дата окончания вуза";
            default:
                return "";
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return tableInputController.getVisibleTable().get(rowIndex).buildFullName();
            case 1:
                return tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getBirthDate());
            case 2:
                return tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getReceiptDate());
            case 3:
                return tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getEndDate());
            default:
                return "";
        }
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        tableInputController.addValueToVisibleTable(rowIndex,value);
        switch (columnIndex) {
            case 0:
                tableInputController.getVisibleTable().get(rowIndex).buildFullName();
            case 1:
                tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getBirthDate());
            case 2:
                tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getReceiptDate());
            case 3:
                tableInputController.getVisibleTable().get(rowIndex).buildFullDate(
                        tableInputController.getVisibleTable().get(rowIndex).getEndDate());
        }
    }

}
