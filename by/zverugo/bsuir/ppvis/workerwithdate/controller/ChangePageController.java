package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.LastPage;
import by.zverugo.bsuir.ppvis.workerwithdate.model.PageChanger;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24.05.2015.
 */
public class ChangePageController implements ActionListener,PageChangerConstants {

    private DateTable table;
    private TableStorage tableStorage;
    private int rowIndex;
    private int value;
    private String flag;

    public ChangePageController(int rowIndex, int value, String flag, TableStorage tableStorage, DateTable table) {
        this.table = table;
        this.tableStorage = tableStorage;
        this.rowIndex = rowIndex;
        this.value = value;
        this.flag = flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (flag.equals(LAST_PAGE)) {
            TableInputController tableInputController = new TableInputController();
            tableInputController.initVisibleTable(new LastPage(rowIndex,flag,tableStorage).getTablePage());
            table.setModel(new DateTableModel(tableInputController));
        } else {
            TableInputController tableInputController = new TableInputController();
            tableInputController.initVisibleTable(new PageChanger(rowIndex,value,flag,tableStorage).getTablePage());
            table.setModel(new DateTableModel(tableInputController));
        }
    }
}
