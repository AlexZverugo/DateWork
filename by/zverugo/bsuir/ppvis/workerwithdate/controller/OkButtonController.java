package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.DateWorkLogic;
import by.zverugo.bsuir.ppvis.workerwithdate.view.window.TableAddWindow;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alex on 24.05.2015.
 */
public class OkButtonController implements ActionListener {

    private JTextField surname;
    private JTextField name;
    private JTextField secondName;
    private JFormattedTextField birthDate;
    private JFormattedTextField receiptDate;
    private JFormattedTextField endDate;
    private TableAddWindow addFrame;
    private AddRowController addRowController;


    public OkButtonController(JTextField surname, JTextField name,
                              JTextField secondName, JFormattedTextField birthDate,
                              JFormattedTextField receiptDate, JFormattedTextField endDate,
                              TableAddWindow addFrame, AddRowController addRowController) {
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.receiptDate = receiptDate;
        this. endDate = endDate;
        this.addFrame = addFrame;
        this.addRowController = addRowController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (new DateWorkLogic().initTableRow(surname,name,secondName,birthDate,receiptDate,endDate, addRowController)) {
            addFrame.dispose();
        }
    }
}
