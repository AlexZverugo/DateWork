package by.zverugo.bsuir.ppvis.workerwithdate.view.builder.impl;


import by.zverugo.bsuir.ppvis.workerwithdate.view.builder.Builder;
import by.zverugo.bsuir.ppvis.workerwithdate.view.util.WWDKeys;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by Alex on 23.05.2015.
 */
public class MenuBuilder implements Builder {

    public static final int FILE_MENU = 0;
    public static final int EDIT_MENU = 1;


    private JFrame mainFrame;
    private JMenu menu;
    private String menuName;
    private Integer type;

    private JMenuItem openItem;
    private JMenuItem exitItem;
    private JMenuItem saveItem;
    private JMenuItem addItem;
    private JMenuItem searchItem;
    private JMenuItem removeItem;

    public MenuBuilder mainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;

        return this;
    }

    public MenuBuilder menuName(String menuName) {
        this.menuName = menuName;

        return this;
    }

    public MenuBuilder type(int type) {
        this.type = type;

        return this;
    }

    public MenuBuilder openItem() {
        JMenuItem openItem = new JMenuItem(WWDKeys.OPEN_ITEM);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        this.openItem = openItem;

        return this;
    }

    public MenuBuilder saveItem() {
        JMenuItem saveItem = new JMenuItem(WWDKeys.SAVE_ITEM);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
        this.saveItem = saveItem;

        return this;
    }

    public MenuBuilder exitItem() {
        JMenuItem closeItem = new JMenuItem(WWDKeys.EXIT_ITEM);
        closeItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,InputEvent.CTRL_MASK));
        this.exitItem = closeItem;

        return this;
    }

    public MenuBuilder addItem() {
        JMenuItem addItem = new JMenuItem(WWDKeys.ADD_ITEM);
        this.addItem = addItem;

        return this;
    }

    public MenuBuilder searchItem() {
        JMenuItem searchItem = new JMenuItem(WWDKeys.SEARCH_ITEM);
        this.searchItem = searchItem;

        return this;
    }

    public MenuBuilder removeItem() {
        JMenuItem removeItem = new JMenuItem(WWDKeys.REMOVE_ITEM);
        this.removeItem = removeItem;

        return this;
    }

    @Override
    public JMenu build() {
        validateRequiredParams();
        menu = new JMenu();
        menu.setText(menuName);

        switch (type) {
            case FILE_MENU:
                addMenuItem(openItem);
                addMenuItem(saveItem);
                menu.addSeparator();
                addMenuItem(exitItem);
                break;
            case EDIT_MENU:
                addMenuItem(addItem);
                addMenuItem(removeItem);
                addMenuItem(searchItem);
                break;

        }

        return menu;
    }

    private void addMenuItem(JMenuItem menuItem) {
        if (menuItem != null) {
            menu.add(menuItem);
        }
    }

    private void validateRequiredParams() {
        if (mainFrame == null) {
            throw new IllegalStateException(WWDKeys.FRAME_NOT_NULL_MSG);
        }
        if (menuName == null) {
            throw new IllegalStateException(WWDKeys.MENU_NAME_NOT_NULL_MSG);
        }
        if (type == null) {
            throw new IllegalStateException(WWDKeys.TYPE_NOT_NULL_MSG);
        }
    }

    public void reset() {
        mainFrame = null;
        menuName = null;
        openItem = null;
        exitItem = null;
        saveItem = null;
        removeItem = null;
        addItem = null;
        searchItem = null;
    }

    public JMenuItem getAddItem() {
        return addItem;
    }

    public JMenuItem getSearchItem() {
        return searchItem;
    }

    public JMenuItem getRemoveItem() {
        return removeItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JMenuItem getOpenItem() {
        return openItem;
    }
}
