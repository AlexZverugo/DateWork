package by.zverugo.bsuir.ppvis.workerwithdate.controller.xmlcontroller;

import by.zverugo.bsuir.ppvis.workerwithdate.controller.TableInputController;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.model.util.XMLKeys;
import by.zverugo.bsuir.ppvis.workerwithdate.model.xml.FileReader;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Alex on 25.05.2015.
 */
public class FileOpenController implements ActionListener {

    private JFileChooser fileChooser;
    private DateTable table;
    private TableStorage tableStorage;
    private DateTableModel tableModel;

    public FileOpenController(TableStorage tableStorage, DateTableModel tableModel, DateTable table) {
        this.tableStorage = tableStorage;
        this.table = table;
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(XMLKeys.SAVING_FOLDER));
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showDialog(null, WWDKeys.OPEN_ITEM);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().getName().contains(XMLKeys.DOT_XML)) {
                tableStorage.removeAllTable();
                new FileReader(tableStorage,fileChooser.getSelectedFile().getPath());
                createTable();
            }

        }
    }

    private void createTable() {
        if (tableStorage.getTableData().size() != 0) {
            TableInputController tableInputController = new TableInputController();
            tableInputController.initVisibleTable(tableStorage.createPageTable(0));
            tableModel = new DateTableModel(tableInputController);
            table.setModel(tableModel);
        }
    }
}
