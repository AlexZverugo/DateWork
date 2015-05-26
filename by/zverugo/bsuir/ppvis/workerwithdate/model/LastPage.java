package by.zverugo.bsuir.ppvis.workerwithdate.model;

import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;

import java.util.List;

/**
 * Created by Alex on 24.05.2015.
 */
public class LastPage {
    private TableStorage tableStorage;
    private int rowIndex;
    private String flag;

    public LastPage(int rowIndex, String flag, TableStorage tableStorage) {
        this.tableStorage = tableStorage;
        this.flag = flag;
        this.rowIndex = rowIndex;
    }

    public List<Row> getTablePage() {
        int tableRowsSize = tableStorage.getTableData().size();
        int visibleSize = tableStorage.getVisibleSize();
        int firstRowOnLastPage = tableRowsSize - (tableRowsSize % visibleSize);
        if (firstRowOnLastPage == tableRowsSize)
            return new PageChanger(
                    rowIndex,tableRowsSize - visibleSize,flag,tableStorage).getTablePage();
        else
            return new PageChanger(rowIndex,firstRowOnLastPage, flag,tableStorage).getTablePage();

    }
}
