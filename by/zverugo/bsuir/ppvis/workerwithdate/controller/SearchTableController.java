package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.model.Row;
import by.zverugo.bsuir.ppvis.workerwithdate.view.SearchPanel;
import by.zverugo.bsuir.ppvis.workerwithdate.view.builder.impl.ToolBarBuilder;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.view.window.TableAddWindow;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Alex on 24.05.2015.
 */
public class SearchTableController implements ActionListener,PageChangerConstants{

    private DateTable table;
    private JFrame mainFrame;
    private TableStorage tableStorage;
    private TableStorage searchTableStorage;
    private TableAddWindow searchFrame;
    private int choice;

    public SearchTableController(int choice, TableStorage tableStorage, JFrame mainFrame) {
        this.choice = choice;
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(new ArrayList<Row>());
        searchTableStorage = new TableStorage();
        this.mainFrame = mainFrame;
        this.tableStorage = tableStorage;
    }

    public TableStorage getTableStorage() {
        return tableStorage;
    }

    public int getChoice() {
        return choice;
    }

    public DateTable getTable() {
        return table;
    }

    public TableStorage getSearchTableStorage() {
        return searchTableStorage;
    }

    private void buildToolBar() {
        ToolBarBuilder toolBarBuilder = new ToolBarBuilder();

       searchFrame.add(toolBarBuilder.mainFrame(mainFrame).flotation(false).table(table)
               .type(ToolBarBuilder.PAGE_TOOL_BAR).orientation(SwingConstants.HORIZONTAL)
               .firstButton().lastButton().prevButton().nextButton().comboBox().build(), BorderLayout.SOUTH);
        initPageToolBarControllers(toolBarBuilder);
        toolBarBuilder.reset();
    }

    private void initPageToolBarControllers(ToolBarBuilder toolBarBuilder) {
        toolBarBuilder.getNextButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_NEXT_PAGE, NULL_VALUE, NOT_FIRST_PAGE, searchTableStorage, table));
        toolBarBuilder.getFirstButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_FIRST_PAGE, NULL_VALUE,FIRST_PAGE, searchTableStorage,table));
        toolBarBuilder.getPrevButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_PREV_PAGE, NULL_VALUE, NOT_FIRST_PAGE, searchTableStorage,table));
        toolBarBuilder.getLastButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_LAST_PAGE,0, LAST_PAGE, searchTableStorage,table));
        toolBarBuilder.getComboBox().addActionListener(new VisibleTableController(
                searchTableStorage,toolBarBuilder.getComboBox(),table));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(new ArrayList<Row>());
        table = new DateTable(new DateTableModel(tableInputController));
        searchFrame = (new TableAddWindow().getAddWindow());
        SearchPanel searchPanel = new SearchPanel(searchFrame,this);
        searchFrame.add(searchPanel);
        searchFrame.repaint();
        buildToolBar();
    }
}
