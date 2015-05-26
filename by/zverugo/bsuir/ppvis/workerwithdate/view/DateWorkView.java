package by.zverugo.bsuir.ppvis.workerwithdate.view;


import by.zverugo.bsuir.ppvis.workerwithdate.controller.TableInputController;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.text.BadLocationException;
import java.awt.Dimension;

/**
 * Created by Alex on 25.05.2015.
 */
public class DateWorkView {

    public int getVisibleSize(JComboBox comboBox) {

        return (Integer) comboBox.getSelectedItem();
    }

    public boolean createSearchInputPanels(int state, SearchPanel searchPanel) {
        switch (state) {
            case  0:
                try {
                if (searchPanel.getPersonName().getText().equals("")
                        || searchPanel.getSurname().getText().equals("")
                        || searchPanel.getSecondName().getText().equals("")
                        || searchPanel.getDate().getText(0,2).equals("  ")
                        || searchPanel.getDate().getText(3,2).equals("  ")
                        || searchPanel.getDate().getText(6,4).equals("    ")) {

                    return false;
                }


                } catch (BadLocationException exc) {
                    System.out.println(exc);
                }

                return true;
            case  1:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31) {

                    return false;
                }
                return true;
            case  2:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31
                        || searchPanel.getMonthDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getMonthDate().getText()) > 12) {

                    return false;
                }
                return true;
            case  3:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31) {

                    return false;
                }
                return true;
            case  4:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31
                        || searchPanel.getMonthDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getMonthDate().getText()) > 12) {

                    return false;
                }

                return true;
            case  5:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31) {

                    return false;
                }

                return true;
            case  6:
                if (searchPanel.getDayDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getDayDate().getText()) > 31
                        || searchPanel.getMonthDate().getText().equals("")
                        || Integer.valueOf(searchPanel.getMonthDate().getText()) > 12) {

                    return false;
                }

                return true;
            default: return false;
        }
    }



    public boolean showErrorMessage(Object list) {
        if (list == null) {
            JOptionPane.showMessageDialog(null, WWDKeys.NOT_FOUND_ROW_MSG);
            return true;
        }
        else {
            return false;
        }
    }

    public void showInformationMessage() {
            JOptionPane.showMessageDialog(null,WWDKeys.EXPLAIN_SPECIAL_SITUATION_MSG);
    }

    public void showLastPage(TableStorage tableStorage, JTable table) {
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(tableStorage.createPageTable(tableStorage.getTableData().size() - 1));
        table.setModel(new DateTableModel(tableInputController));
    }
}
