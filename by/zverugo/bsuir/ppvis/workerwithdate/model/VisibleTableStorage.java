package by.zverugo.bsuir.ppvis.workerwithdate.model;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Alex on 24.05.2015.
 */
public class VisibleTableStorage {

    private List<Row> rows;

    public VisibleTableStorage(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getVisibleRows() {
        return rows;
    }

    public void addValueToVisibleTable(int place, Object value) {
        rows.add(place,(Row) value);
    }

    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Human.class;
        }
        return GregorianCalendar.class;
    }
}
