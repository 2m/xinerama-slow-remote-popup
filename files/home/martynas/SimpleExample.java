import java.awt.event.*;
import javax.swing.*;

public class SimpleExample extends JFrame {

    public SimpleExample() {
        
       setTitle("Simple example");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);        

       //Create the menu bar.
       JMenuBar menuBar = new JMenuBar();

       //Build the first menu.
       JMenu menu = new JMenu("A Menu");
       menu.setMnemonic(KeyEvent.VK_A);
       menu.getAccessibleContext().setAccessibleDescription(
        "The only menu in this program that has menu items");
       menuBar.add(menu);

       //a group of JMenuItems
       JMenuItem menuItem = new JMenuItem("A text-only menu item",
                         KeyEvent.VK_T);
       menuItem.setAccelerator(KeyStroke.getKeyStroke(
        KeyEvent.VK_1, ActionEvent.ALT_MASK));
       menuItem.getAccessibleContext().setAccessibleDescription(
        "This doesn't really do anything");
       menu.add(menuItem);

       setJMenuBar(menuBar);
    }
    

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SimpleExample ex = new SimpleExample();
                ex.setVisible(true);
            }
        });
    }
}
