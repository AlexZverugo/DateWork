package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.model.DateWorkLogic;
import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateWorkView;
import by.zverugo.bsuir.ppvis.workerwithdate.view.SearchPanel;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Alex on 25.05.2015.
 */
public class SearchInputDateController implements ActionListener {

    private int state;
    private SearchPanel searchPanel;
    private SearchTableController searchTableController;

    public SearchInputDateController(int state, SearchPanel searchPanel) {
        this.state = state;
        this.searchPanel = searchPanel;
        this.searchTableController = searchPanel.getSearchTableController();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        searchTableController.getTable().setModel(new DateTableModel(
                new DateWorkLogic().deleteTable(searchTableController)));
        searchPanel.repaint();

        if (new DateWorkView().createSearchInputPanels(state,searchPanel)) {
            TableInputController tableInputController = new TableInputController();
            List<Row> foundRows = new DateWorkLogic().createSearchInputPanels(state, searchPanel);

            if (new DateWorkView().showErrorMessage(foundRows)) {
                searchTableController.getTable().setModel(new DateTableModel(
                        new DateWorkLogic().deleteTable(searchTableController)));
                searchPanel.getSearchTableController().getTable().repaint();
                return;
            }

            tableInputController.initVisibleTable(searchTableController.getSearchTableStorage().createPageTable(0));
            DateTableModel tableModel = new DateTableModel(tableInputController);
            searchPanel.getSearchTableController().getTable().setModel(tableModel);
            searchPanel.getSearchTableController().getTable().repaint();
        } else {
            new DateWorkView().showInformationMessage();
        }
    }
}
