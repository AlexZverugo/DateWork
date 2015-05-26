package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.DateWorkLogic;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateWorkView;

import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24.05.2015.
 */
public class VisibleTableController implements ActionListener,PageChangerConstants {

    private TableStorage tableStorage;
    private JComboBox comboBox;
    private DateTable table;

    public VisibleTableController(TableStorage tableStorage, JComboBox comboBox, JTable table) {
        this.tableStorage = tableStorage;
        this.comboBox = comboBox;
        this.table = (DateTable)table;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new DateWorkLogic().setVisibleTableSize(tableStorage,FIRST_ROW_ON_FIRST_PAGE,
                NULL_VALUE, new DateWorkView().getVisibleSize(comboBox));
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(tableStorage.createPageTable(0));
        table.setModel(new DateTableModel(tableInputController));
        table.repaint();
    }
}
