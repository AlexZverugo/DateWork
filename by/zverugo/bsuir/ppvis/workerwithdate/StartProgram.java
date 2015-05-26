package by.zverugo.bsuir.ppvis.workerwithdate;

import by.zverugo.bsuir.ppvis.workerwithdate.controller.StartController;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Created by Alex on 23.05.2015.
 */
public class StartProgram {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                new StartController();
            }
        });
    }
}
