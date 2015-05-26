package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.view.AddedPanel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateWorkView;
import by.zverugo.bsuir.ppvis.workerwithdate.view.window.TableAddWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24.05.2015.
 */
public class AddRowController implements ActionListener,PageChangerConstants {

    private TableAddWindow addWindow;
    private Row row;
    private TableStorage tableStorage;
    private DateTable table;

    public AddRowController(TableStorage tableStorage, DateTable table) {
        this.tableStorage = tableStorage;
        this.table = table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        addWindow = (new TableAddWindow().getAddWindow());
        AddedPanel addedPanel = new AddedPanel(addWindow, this);
        addWindow.add(addedPanel);
    }

    public void setRow(Row row) {
        this.row = row;
        tableStorage.setPerson(row);
        new DateWorkView().showLastPage(tableStorage,table);
    }
}
