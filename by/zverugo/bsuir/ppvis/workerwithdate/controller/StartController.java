package by.zverugo.bsuir.ppvis.workerwithdate.controller;

import by.zverugo.bsuir.ppvis.workerwithdate.common.DateWorkKeys;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.xmlcontroller.FileOpenController;
import by.zverugo.bsuir.ppvis.workerwithdate.controller.xmlcontroller.FileSaveController;
import by.zverugo.bsuir.ppvis.workerwithdate.view.builder.impl.MenuBuilder;
import by.zverugo.bsuir.ppvis.workerwithdate.view.builder.impl.ToolBarBuilder;
import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;
import by.zverugo.bsuir.ppvis.workerwithdate.model.storage.TableStorage;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;


/**
 * Created by Alex on 23.05.2015.
 */
public class StartController implements PageChangerConstants {

    private JFrame mainFrame;
    private JToolBar workToolBar;
    private JToolBar pageToolBar;
    private DateTableModel tableModel;
    private DateTable table;
    private TableStorage tableStorage;

    public StartController() {
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUpWindowSize();
        buildTable();
        buildScroll(table);
        buildToolBars();
        buildMenu();
        mainFrame.setVisible(true);
    }

    private void buildMenu() {
        JMenuBar mainMenu = new JMenuBar();

        MenuBuilder menuBuilder = new MenuBuilder();

        JMenu fileMenu = menuBuilder.mainFrame(mainFrame).menuName(WWDKeys.FILE).type(MenuBuilder.FILE_MENU)
                .openItem().saveItem().exitItem().build();
        initFileMenuControllers(menuBuilder);
        menuBuilder.reset();

        JMenu editMenu = menuBuilder.menuName(WWDKeys.EDIT).mainFrame(mainFrame).type(MenuBuilder.EDIT_MENU)
                .addItem().removeItem().searchItem().build();
        initEditMenuControllers(menuBuilder);
        menuBuilder.reset();

        mainMenu.add(fileMenu);
        mainMenu.add(editMenu);

        mainFrame.add(mainMenu,BorderLayout.NORTH);
    }

    private void initFileMenuControllers(MenuBuilder menuBuilder) {
        menuBuilder.getExitItem().addActionListener(new ExitController());
        menuBuilder.getSaveItem().addActionListener(new FileSaveController(tableStorage));
        menuBuilder.getOpenItem().addActionListener(new FileOpenController(tableStorage,tableModel,table));
    }

    private void initEditMenuControllers(MenuBuilder menuBuilder) {
        menuBuilder.getAddItem().addActionListener(new AddRowController(tableStorage,table));
        menuBuilder.getSearchItem().addActionListener(new SearchTableController(
                DateWorkKeys.SEARCH,tableStorage,mainFrame));
        menuBuilder.getRemoveItem().addActionListener(new SearchTableController(
                DateWorkKeys.REMOVE,tableStorage,mainFrame));
    }

    private void buildTable(){
        tableStorage = new TableStorage();
        TableInputController tableInputController = new TableInputController();
        tableInputController.initVisibleTable(tableStorage.createPageTable(0));
        tableModel = new DateTableModel(tableInputController);
        table = new DateTable(tableModel);
        table.setPreferredSize(new Dimension(1000,1000));
    }

    private void buildScroll(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        mainFrame.add(scrollPane);
    }

    private void buildToolBars() {
        ToolBarBuilder toolBarBuilder = new ToolBarBuilder();
        workToolBar = toolBarBuilder.mainFrame(mainFrame).flotation(false)
                .table(table).type(ToolBarBuilder.WORK_TOOL_BAR).orientation(SwingConstants.VERTICAL)
                .addButton().removeButton().searchButton().saveButton().openButton().build();

        initWorkToolBarControllers(toolBarBuilder);
        toolBarBuilder.reset();

        pageToolBar = toolBarBuilder.mainFrame(mainFrame).flotation(false).table(table)
                .type(ToolBarBuilder.PAGE_TOOL_BAR).orientation(SwingConstants.HORIZONTAL)
                .firstButton().lastButton().prevButton().nextButton().comboBox().build();
        initPageToolBarControllers(toolBarBuilder);
        toolBarBuilder.reset();

        mainFrame.add(workToolBar, BorderLayout.WEST);
        mainFrame.add(pageToolBar,BorderLayout.SOUTH);
    }


    private void initWorkToolBarControllers(ToolBarBuilder toolBarBuilder) {
        toolBarBuilder.getAddButton().addActionListener(new AddRowController(tableStorage,table));
        toolBarBuilder.getSearchButton().addActionListener(new SearchTableController(
                DateWorkKeys.SEARCH,tableStorage,mainFrame));
        toolBarBuilder.getRemoveButton().addActionListener(new SearchTableController(
                DateWorkKeys.REMOVE,tableStorage,mainFrame));
        toolBarBuilder.getSaveButton().addActionListener(new FileSaveController(tableStorage));
        toolBarBuilder.getOpenButton().addActionListener(new FileOpenController(tableStorage,tableModel,table));
    }

    private void initPageToolBarControllers(ToolBarBuilder toolBarBuilder) {
        toolBarBuilder.getNextButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_NEXT_PAGE, NULL_VALUE, NOT_FIRST_PAGE, tableStorage, table));
        toolBarBuilder.getFirstButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_FIRST_PAGE, NULL_VALUE,FIRST_PAGE,tableStorage,table));
        toolBarBuilder.getPrevButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_PREV_PAGE, NULL_VALUE, NOT_FIRST_PAGE,tableStorage,table));
        toolBarBuilder.getLastButton().addActionListener(new ChangePageController(
                FIRST_ROW_ON_LAST_PAGE,0, LAST_PAGE,tableStorage,table));
        toolBarBuilder.getComboBox().addActionListener(new VisibleTableController(
                tableStorage,toolBarBuilder.getComboBox(),table));
    }

    private void setUpWindowSize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        mainFrame.setSize(screenHeight / 2, screenWidth / 3);
        mainFrame.setLocationRelativeTo(null);
    }

}
