package by.zverugo.bsuir.ppvis.workerwithdate.view;

import by.zverugo.bsuir.ppvis.workerwithdate.controller.SearchTableController;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.SearchInputDateController;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;
import by.zverugo.bsuir.ppvis.workerwithdate.view.window.TableAddWindow;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.util.Vector;

/**
 * Created by Alex on 25.05.2015.
 */
public class SearchPanel extends JPanel {

    private static final DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");


    private JButton fullNameAndBirth;
    private JButton yearDayBirth;
    private JButton monthDayBirth;
    private JButton yearDayStart;
    private JButton monthDayStart;
    private JButton yearDayEnd;
    private JButton monthDayEnd;
    private TableAddWindow currentDialogWindow;

    private JTextField surname;
    private JTextField dayDate;
    private JTextField monthDate;
    private JTextField name;
    private JTextField secondName;
    private JFormattedTextField date;
    private JComboBox<Integer> leftBound;
    private JComboBox<Integer> rightBound;

    private SearchTableController searchTableController;




    public SearchPanel(TableAddWindow currentDialogWindow, SearchTableController searchTableController) {
        this.searchTableController = searchTableController;
        this.currentDialogWindow = currentDialogWindow;
        setLayout(new GridBagLayout());
        fullNameAndBirth = new JButton(WWDKeys.FULL_NAME_AND_BIRTH_DATE);
        yearDayBirth = new JButton(WWDKeys.BIRTH_YEAR_AND_DAY);
        monthDayBirth = new JButton(WWDKeys.BIRTH_MONTH_AND_DAY);
        yearDayStart = new JButton(WWDKeys.RECEIVED_YEAR_AND_DAY);
        monthDayStart = new JButton(WWDKeys.RECEIVED_MONTH_AND_DAY);
        yearDayEnd = new JButton(WWDKeys.END_YEAR_AND_DAY);
        monthDayEnd = new JButton(WWDKeys.END_MONTH_AND_DAY);
        addCheckBoxListeners();

        JLabel surnameText = new JLabel(WWDKeys.SURNAME);
        surname = new JTextField("",10);
        JLabel nameText = new JLabel(WWDKeys.NAME);
        name = new JTextField("",10);
        JLabel secondNameText = new JLabel(WWDKeys.SECOND_NAME);
        secondName = new JTextField("",10);

        JLabel dateText = new JLabel("Дата:");
        date = new JFormattedTextField(dateFormat);
        buildDate(date);
        JLabel yearTextLeft = new JLabel("От:");
        JLabel yearTextRight = new JLabel("До:");
        Vector <Integer> vector = new Vector<Integer>();
        for (int yearIndex = 0; yearIndex < 100; yearIndex++) {
            vector.add(1964 + yearIndex);
        }

        dayDate = new JTextField("",2);
        monthDate = new JTextField("",2);

        leftBound = new JComboBox<Integer>(vector);
        rightBound = new JComboBox<Integer>(vector);


        JLabel monthLabel = new JLabel("месяц:");
        JLabel dayLabel = new JLabel("день:");

        add(searchTableController.getTable(), new GridBagConstraints(0, 20, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(fullNameAndBirth, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(yearDayBirth,new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(monthDayBirth,new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(yearDayStart,new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(monthDayStart,new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(yearDayEnd,new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(monthDayEnd,new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(surnameText, new GridBagConstraints(0, 7, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(surname, new GridBagConstraints(0, 8, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(nameText, new GridBagConstraints(0, 9, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(name, new GridBagConstraints(0, 10, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(secondNameText, new GridBagConstraints(0, 11, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(secondName, new GridBagConstraints(0, 12, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(dateText, new GridBagConstraints(0, 13, 1, 1, 0, 0,
                GridBagConstraints.EAST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(date, new GridBagConstraints(0, 14, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(
                1, 1, 1, 1), 0, 0));
        add(yearTextLeft, new GridBagConstraints(0, 15, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(yearTextRight, new GridBagConstraints(0, 15, 1, 1, 0, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(leftBound, new GridBagConstraints(0, 16, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(rightBound, new GridBagConstraints(0, 16, 1, 1, 0, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(dayLabel, new GridBagConstraints(0, 17, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(monthLabel, new GridBagConstraints(0, 17, 1, 1, 0, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(dayDate, new GridBagConstraints(0, 18, 1, 1, 0, 0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));
        add(monthDate, new GridBagConstraints(0, 18, 1, 1, 0, 0,
                GridBagConstraints.LAST_LINE_END, GridBagConstraints.NONE, new Insets(
                1, 1, 1, 1), 0, 0));

    }

    private void addCheckBoxListeners() {
        fullNameAndBirth.addActionListener(new SearchInputDateController(0,this));
        yearDayBirth.addActionListener(new SearchInputDateController(1,this));
        monthDayBirth.addActionListener(new SearchInputDateController(2,this));
        yearDayStart.addActionListener(new SearchInputDateController(3,this));
        monthDayStart.addActionListener(new SearchInputDateController(4,this));
        yearDayEnd.addActionListener(new SearchInputDateController(5,this));
        monthDayEnd.addActionListener(new SearchInputDateController(6,this));

    }

    public SearchTableController getSearchTableController() {
        return searchTableController;
    }

    public JTextField getSurname() {
        return surname;
    }

    public JTextField getPersonName() {
        return name;
    }

    public JTextField getSecondName() {
        return secondName;
    }

    public JFormattedTextField getDate() {
        return date;
    }

    public JComboBox<Integer> getLeftBound() {
        return leftBound;
    }

    public JComboBox<Integer> getRightBound() {
        return rightBound;
    }

    public JTextField getDayDate() {
        return dayDate;
    }

    public JTextField getMonthDate() {
        return monthDate;
    }

    private void buildDate(JFormattedTextField textField) {
        textField.setColumns(10);
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.install(textField);
        } catch (ParseException exc) {
            System.out.println(exc);
        }
    }
}
