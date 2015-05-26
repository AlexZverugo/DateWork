package by.zverugo.bsuir.ppvis.workerwithdate.model;

import by.zverugo.bsuir.ppvis.workerwithdate.common.DateWorkKeys;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.AddRowController;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.SearchTableController;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.TableInputController;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.view.SearchPanel;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Alex on 24.05.2015.
 */
public class DateWorkLogic {

    public void setVisibleTableSize(TableStorage tableStorage,int flag, int value, int visibleSize) {
        tableStorage.setCurrentPageFirstRow(flag,value);
        tableStorage.setVisibleSize(visibleSize);
    }

    public boolean initTableRow(JTextField surname, JTextField name,
                             JTextField secondName, JFormattedTextField birthDate,
                             JFormattedTextField receiptDate, JFormattedTextField endDate,
                             AddRowController addRowController) {

        if (surname.getText().equals("") || name.getText().equals("") || secondName.getText().equals("")
                || surname.getText() == null || name.getText() == null || secondName.getText() == null
                || birthDate.getText().equals("") || receiptDate.getText().equals("") || endDate.getText().equals("")
                || birthDate.getText() == null || receiptDate.getText() == null || endDate.getText() == null ) {
            return false;
        }
        Human person = new Human(surname.getText(),name.getText(),secondName.getText());
        int day;
        int month;
        int year;
        GregorianCalendar birth;
        GregorianCalendar receipt;
        GregorianCalendar end;

        try {
            if (!birthDate.getText(0,2).equals("  ") && !birthDate.getText(3,2).equals("  ")
                    && !birthDate.getText(6,4).equals("   ")) {
                day = Integer.valueOf(birthDate.getText(0, 2));
                month = Integer.valueOf(birthDate.getText(3, 2));
                year = Integer.valueOf(birthDate.getText(6, 4));
                birth = new GregorianCalendar(year, month, day);
            }
            else {
                return false;
            }


            if (!receiptDate.getText(0,2).equals("  ") && !receiptDate.getText(3,2).equals("  ")
                    && !receiptDate.getText(6,4).equals("    ")) {
                day = Integer.valueOf(receiptDate.getText(0, 2));
                month = Integer.valueOf(receiptDate.getText(3, 2));
                year = Integer.valueOf(receiptDate.getText(6, 4));
                receipt = new GregorianCalendar(year, month, day);
            } else {
                return false;
            }

            if (!endDate.getText(0,2).equals("  ") && !endDate.getText(3,2).equals("  ")
                    && !endDate.getText(6,4).equals("    ")) {
                day = Integer.valueOf(endDate.getText(0, 2));
                month = Integer.valueOf(endDate.getText(3, 2));
                year = Integer.valueOf(endDate.getText(6, 4));
                end = new GregorianCalendar(year, month, day);
            } else {
                return false;
            }

            Row row = new Row(person,birth,receipt,end);
            addRowController.setRow(row);

            return true;
        } catch (BadLocationException exc) {
            System.out.println(exc);
        }
        return false;
    }

    public List<Row> createSearchInputPanels(int state, SearchPanel searchPanel) {
        switch (state) {
            case  0: {
                    ArrayList<Row> foundRow = new ArrayList<Row>();
                    TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                    for (Row row : tableStorage.getTableData()) {
                        if (row.getFullName().getName().equals(searchPanel.getPersonName().getText())
                                && row.getFullName().getSurname().equals(searchPanel.getSurname().getText())
                                && row.getFullName().getSecondName().equals(searchPanel.getSecondName().getText())
                                && row.buildFullDate(row.getBirthDate()).equals(searchPanel.getDate().getText())) {
                            foundRow.add(row);
                            searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                        }
                    }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }



                    if (foundRow.size() == 0) {
                        return null;
                    } else {
                        return foundRow;
                    }
                }
            case  1:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                        if (row.getBirthDate().get(GregorianCalendar.DAY_OF_MONTH)
                                == Integer.valueOf(searchPanel.getDayDate().getText())
                                && row.getBirthDate().get(GregorianCalendar.YEAR)
                                > (Integer)searchPanel.getLeftBound().getSelectedItem()
                                &&  row.getBirthDate().get(GregorianCalendar.YEAR)
                                < (Integer)searchPanel.getRightBound().getSelectedItem()) {
                            foundRow.add(row);
                            searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                        }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
            case  2:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                    if (row.getBirthDate().get(GregorianCalendar.DAY_OF_MONTH)
                            == Integer.valueOf(searchPanel.getDayDate().getText())
                            && row.getBirthDate().get(GregorianCalendar.MONTH)
                            == Integer.valueOf(searchPanel.getMonthDate().getText())) {
                        foundRow.add(row);
                        searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                    }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
            case  3:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                    if (row.getReceiptDate().get(GregorianCalendar.DAY_OF_MONTH)
                            == Integer.valueOf(searchPanel.getDayDate().getText())
                            && row.getReceiptDate().get(GregorianCalendar.YEAR)
                            > (Integer)searchPanel.getLeftBound().getSelectedItem()
                            &&  row.getReceiptDate().get(GregorianCalendar.YEAR)
                            < (Integer)searchPanel.getRightBound().getSelectedItem()) {
                        foundRow.add(row);
                        searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                    }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
            case  4:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                    if (row.getReceiptDate().get(GregorianCalendar.DAY_OF_MONTH)
                            == Integer.valueOf(searchPanel.getDayDate().getText())
                            && row.getReceiptDate().get(GregorianCalendar.MONTH)
                            == Integer.valueOf(searchPanel.getMonthDate().getText())) {
                        foundRow.add(row);
                        searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                    }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
            case  5:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                    if (row.getEndDate().get(GregorianCalendar.DAY_OF_MONTH)
                            == Integer.valueOf(searchPanel.getDayDate().getText())
                            && row.getEndDate().get(GregorianCalendar.YEAR)
                            > (Integer)searchPanel.getLeftBound().getSelectedItem()
                            &&  row.getEndDate().get(GregorianCalendar.YEAR)
                            < (Integer)searchPanel.getRightBound().getSelectedItem()) {
                        foundRow.add(row);
                        searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                    }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
            case  6:
            {
                ArrayList<Row> foundRow = new ArrayList<Row>();
                TableStorage tableStorage = searchPanel.getSearchTableController().getTableStorage();
                for (Row row : tableStorage.getTableData()) {
                    if (row.getEndDate().get(GregorianCalendar.DAY_OF_MONTH)
                            == Integer.valueOf(searchPanel.getDayDate().getText())
                            && row.getEndDate().get(GregorianCalendar.MONTH)
                            == Integer.valueOf(searchPanel.getMonthDate().getText())) {
                        foundRow.add(row);
                        searchPanel.getSearchTableController().getSearchTableStorage().getTableData().add(row);
                    }
                }

                if (searchPanel.getSearchTableController().getChoice() == DateWorkKeys.REMOVE) {
                    removeData(foundRow,searchPanel);
                }

                if (foundRow.size() == 0) {
                    return null;
                }
                else {
                    return  foundRow;
                }
            }
                default: return null;
        }
    }



    public TableInputController deleteTable(SearchTableController searchTableController) {
        TableStorage searchTableStorage = searchTableController.getSearchTableStorage();
        searchTableStorage.removeAllTable();
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(new ArrayList<Row>());
        return tableInputController;
    }


    private void removeData(List<Row> rows, SearchPanel searchPanel){
        for (Row row : rows) {
            searchPanel.getSearchTableController().getTableStorage().removePerson(row);
        }
    }
}
