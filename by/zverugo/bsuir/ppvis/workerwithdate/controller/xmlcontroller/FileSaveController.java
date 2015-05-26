package by.zverugo.bsuir.ppvis.workerwithdate.controller.xmlcontroller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.model.util.XMLKeys;
import by.zverugo.bsuir.ppvis.workerwithdate.model.xml.FileWriter;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Alex on 25.05.2015.
 */
public class FileSaveController implements ActionListener {

    private JFileChooser fileChooser;
    private TableStorage tableStorage;


    public FileSaveController(TableStorage tableStorage) {
        this.tableStorage = tableStorage;
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(XMLKeys.SAVING_FOLDER));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int result = fileChooser.showDialog(null, WWDKeys.SAVE_ITEM);
        if (result == JFileChooser.APPROVE_OPTION) {
            new FileWriter(tableStorage, fileChooser.getSelectedFile().getPath());
        }
    }
}
