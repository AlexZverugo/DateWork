package by.zverugo.bsuir.ppvis.workerwithdate.view.window;

import javax.swing.JDialog;
import javax.swing.WindowConstants;

/**
 * Created by Alex on 24.05.2015.
 */
public class TableAddWindow extends JDialog {


    public TableAddWindow() {
        setSize(400,650);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public TableAddWindow getAddWindow() {

        return this;
    }

}
