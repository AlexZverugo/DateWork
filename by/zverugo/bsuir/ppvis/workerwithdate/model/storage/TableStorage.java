package by.zverugo.bsuir.ppvis.workerwithdate.model.storage;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex on 23.05.2015.
 */
public class TableStorage implements PageChangerConstants{

    private List<Row> tableData;
    private int currentPageFirstRow;
    private int visibleSize;

    public TableStorage() {
        tableData = new LinkedList<Row>();
        currentPageFirstRow = 0;
        visibleSize = 1;
    }


    public int getVisibleSize() {

        return visibleSize;
    }

    public void setVisibleSize(int visibleSize) {
        if (visibleSize <= tableData.size()) {
            this.visibleSize = visibleSize;
        }
        else
            this.visibleSize = tableData.size();
    }

    public List<Row> getTableData() {

        return tableData;
    }

    public void removeAllTable() {
        tableData.removeAll(tableData);
    }

    public void setPerson(Row person) {
        tableData.add(person);
    }

    public void removePerson(Row row) {
        tableData.remove(tableData.indexOf(row));
    }

    public int getCurrentPageFirstRow() {

        return currentPageFirstRow;
    }

    public void setCurrentPageFirstRow(int flag,int value) {
        switch (flag) {
            case FIRST_ROW_ON_NEXT_PAGE:
                currentPageFirstRow += visibleSize;
                if (tableData.size() <= currentPageFirstRow)
                    currentPageFirstRow -= visibleSize;
                break;
            case FIRST_ROW_ON_FIRST_PAGE:
                currentPageFirstRow = 0;
                break;
            case FIRST_ROW_ON_PREV_PAGE:
                currentPageFirstRow -= visibleSize;
                if (currentPageFirstRow < 0)
                    currentPageFirstRow = 0;
                break;
            case FIRST_ROW_ON_LAST_PAGE:
                currentPageFirstRow = value;
        }

    }


    public List<Row> createPageTable(int firstRow) {
        List<Row> pageTable = new LinkedList<Row>();
        if (tableData.size() <= firstRow) {
            return pageTable;
        }
        int lastPage = tableData.size() - firstRow;

        if (lastPage < visibleSize) {
            for (int pageRowIndex = firstRow; pageRowIndex < (firstRow + lastPage); pageRowIndex++) {
                pageTable.add(tableData.get(pageRowIndex));
            }
            return pageTable;
        }

        for (int pageRowIndex = firstRow; pageRowIndex < (firstRow + visibleSize); pageRowIndex++) {
            pageTable.add(tableData.get(pageRowIndex));
        }

        return pageTable;
    }
}
