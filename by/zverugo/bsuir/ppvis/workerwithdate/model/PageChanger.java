package by.zverugo.bsuir.ppvis.workerwithdate.model;

import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;

import java.util.List;

/**
 * Created by Alex on 23.05.2015.
 */
public class PageChanger implements PageChangerConstants {

    private TableStorage tableStorage;
    private int rowIndex;
    private int value;
    private String flag;

    public PageChanger(int rowIndex, int value, String flag, TableStorage tableStorage) {
        this.tableStorage = tableStorage;
        this.value = value;
        this.flag = flag;
        this.rowIndex = rowIndex;
    }


    public List<Row> getTablePage() {
        tableStorage.setCurrentPageFirstRow(rowIndex,value);
        if (flag.equals(FIRST_PAGE))
            return tableStorage.createPageTable(0);
        else
            return tableStorage.createPageTable(tableStorage.getCurrentPageFirstRow());
    }

}
