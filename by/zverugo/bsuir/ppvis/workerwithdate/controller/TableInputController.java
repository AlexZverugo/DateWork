package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.model.VisibleTableStorage;

import java.util.List;

/**
 * Created by Alex on 24.05.2015.
 */
public class TableInputController {

    private VisibleTableStorage visibleTableStorage;

    public void initVisibleTable(List<Row> rows) {
        visibleTableStorage = new VisibleTableStorage(rows);
    }

    public List<Row> getVisibleTable() {

        return visibleTableStorage.getVisibleRows();
    }

    public void addValueToVisibleTable(int place, Object value) {
        visibleTableStorage.addValueToVisibleTable(place,value);
    }

    public Class<?> getColumnClass(int columnIndex) {
        return visibleTableStorage.getColumnClass(columnIndex);
    }
}
