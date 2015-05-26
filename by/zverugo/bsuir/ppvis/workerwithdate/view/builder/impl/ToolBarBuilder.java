package by.zverugo.bsuir.ppvis.workerwithdate.view.builder.impl;

import by.zverugo.bsuir.ppvis.workerwithdate.view.builder.Builder;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTable;
import by.zverugo.bsuir.ppvis.workerwithdate.view.DateTableModel;


import by.zverugo.bsuir.ppvis.workerwithdate.common.PageChangerConstants;
import by.zverugo.bsuir.ppvis.workerwithdate.common.StaticResource;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Vector;

/**
 * Created by Alex on 23.05.2015.
 */
public class ToolBarBuilder implements Builder, PageChangerConstants {

    public static final int WORK_TOOL_BAR = 0;
    public static final int PAGE_TOOL_BAR = 1;


    private JFrame mainFrame;
    private JToolBar toolBar;
    private Integer orientation;
    private Boolean flotation;
    private Integer type;
    private DateTable table;

    private JComboBox comboBox;
    private JButton searchButton;
    private JButton removeButton;
    private JButton addButton;
    private JButton saveButton;
    private JButton openButton;
    private JButton nextButton;
    private JButton prevButton;
    private JButton lastButton;
    private JButton firstButton;


    public ToolBarBuilder mainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;

        return this;
    }

    public ToolBarBuilder table(DateTable table) {
        this.table = table;

        return this;
    }

    public ToolBarBuilder orientation(int orientation) {
        this.orientation = orientation;

        return this;
    }

    public ToolBarBuilder flotation(boolean flotation) {
        this.flotation = flotation;

        return this;
    }

    public ToolBarBuilder type(int type) {
        this.type = type;

        return this;
    }

    public ToolBarBuilder comboBox() {
        Vector comboBoxContents = new Vector();

        for (int comboBoxIndex = 1; comboBoxIndex < 21; comboBoxIndex++)
            comboBoxContents.add(comboBoxIndex);

        comboBox = new JComboBox(comboBoxContents);
        comboBox.setMaximumSize(new Dimension(40, 25));

        return this;
    }



    public ToolBarBuilder saveButton() {
        saveButton = new JButton(new ImageIcon(StaticResource.SAVE_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder openButton() {
        openButton = new JButton(new ImageIcon(StaticResource.OPEN_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder addButton() {
        addButton = new JButton(new ImageIcon(StaticResource.ADD_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder searchButton() {
        searchButton = new JButton(new ImageIcon(StaticResource.SEARCH_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder removeButton() {
        removeButton = new JButton(new ImageIcon(StaticResource.REMOVE_IMAGE.path()));

        return this;
    }



    public ToolBarBuilder nextButton() {
        nextButton = new JButton(new ImageIcon(StaticResource.NEXT_IMAGE.path()));


        return this;
    }

    public ToolBarBuilder lastButton() {
        lastButton = new JButton(new ImageIcon(StaticResource.LAST_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder firstButton() {
        firstButton = new JButton(new ImageIcon(StaticResource.FIRST_IMAGE.path()));

        return this;
    }

    public ToolBarBuilder prevButton() {
        prevButton = new JButton(new ImageIcon(StaticResource.PREV_IMAGE.path()));

        return this;
    }

    @Override
    public JToolBar build() {
        validateRequiredParams();
        toolBar = new JToolBar();
        toolBar.setOrientation(orientation);
        toolBar.setFloatable(flotation);

        switch (type) {
            case WORK_TOOL_BAR:
                addToolBarComponent(addButton);
                addToolBarComponent(removeButton);
                addToolBarComponent(searchButton);
                toolBar.addSeparator();
                addToolBarComponent(saveButton);
                addToolBarComponent(openButton);
                break;
            case PAGE_TOOL_BAR:
                addToolBarComponent(firstButton);
                addToolBarComponent(prevButton);
                addToolBarComponent(nextButton);
                addToolBarComponent(lastButton);
                toolBar.addSeparator(new Dimension(36,36));
                addToolBarComponent(comboBox);
        }

        return toolBar;
    }

    private void addToolBarComponent(Component button) {
        if (button != null) {
            toolBar.add(button);
        }
    }

    private void validateRequiredParams() {
        if (mainFrame == null) {
            throw new IllegalStateException(WWDKeys.FRAME_NOT_NULL_MSG);
        }
        if (orientation == null) {
            throw new IllegalStateException(WWDKeys.ORIENTATION_NOT_NULL_MSG);
        }
        if (flotation == null) {
            throw new IllegalStateException(WWDKeys.FLOTATION_NOT_NULL_MSG);
        }
        if (type == null) {
            throw new IllegalStateException(WWDKeys.TYPE_NOT_NULL_MSG);
        }
        if (table == null) {
            throw new IllegalStateException(WWDKeys.TABLE_NOT_NULL_MSG);
        }
    }

    public void reset() {
//        mainFrame = null;
        orientation = null;
        flotation = null;
        addButton = null;
        removeButton = null;
        searchButton = null;
        saveButton = null;
        openButton = null;
        nextButton = null;
        prevButton = null;
        firstButton = null;
        lastButton = null;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getPrevButton() {
        return prevButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getFirstButton() {
        return firstButton;
    }

    public JButton getLastButton() {
        return lastButton;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getRemoveButton() {
        return removeButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}
