package by.zverugo.bsuir.ppvis.workerwithdate.view;

import by.zverugo.bsuir.ppvis.workerwithdate.controller.AddRowController;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.OkButtonController;
import by.zverugo.bsuir.ppvis.workerwithdate.view.window.TableAddWindow;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Alex on 24.05.2015.
 */
public class AddedPanel extends JPanel {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");

    public AddedPanel(TableAddWindow addFrame, AddRowController addRowController) {
            setLayout(new GridBagLayout());
            JLabel surnameText = new JLabel("Фамилия:");
            JTextField surname = new JTextField("",10);
            JLabel nameText = new JLabel("Имя:");
            JTextField name = new JTextField("",10);
            JLabel secondNameText = new JLabel("Отчество:");
            JTextField secondName = new JTextField("",10);

            JLabel birthDateText = new JLabel("Дата рождения:");
            JFormattedTextField birthDate = new JFormattedTextField(dateFormat);
            buildDate(birthDate);

            JLabel receiptDateText = new JLabel("Дата поступления:");
            JFormattedTextField receiptDate = new JFormattedTextField(dateFormat);
            buildDate(receiptDate);

            JLabel endDateText = new JLabel("Дата окончания:");
            JFormattedTextField endDate = new JFormattedTextField(dateFormat);
            buildDate(endDate);

            JButton enterButton = new JButton("ОК");
            enterButton.addActionListener(new OkButtonController(surname,name,secondName,
                birthDate,receiptDate,endDate,addFrame, addRowController));


            add(surnameText, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(surname,new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                    1, 1, 1, 1), 0, 0));
            add(nameText,new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(name,new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(secondNameText,new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(secondName,new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(birthDateText,new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(birthDate,new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(receiptDateText,new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(receiptDate,new GridBagConstraints(0, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(endDateText,new GridBagConstraints(0, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(endDate,new GridBagConstraints(0, 11, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
            add(enterButton,new GridBagConstraints(0, 16, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
    }


    private void buildDate(JFormattedTextField textField) {
        textField.setColumns(20);
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(textField);
        } catch (ParseException exc) {
            System.out.println(exc);
        }
    }

}
