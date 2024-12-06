import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIframe extends JFrame implements ActionListener {

    public GUIframe(){
        buildFrame();
    }

    JTextField textfield =  new JTextField();
    static JTextArea textarea = new JTextArea();

    private void buildFrame(){
        setTitle("A Very Random Game");
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3,1)); 
        JLabel label = new JLabel("What would you like to do?");
        JButton button = new JButton("Execute");

        panel.add(label);
        panel.add(textfield);
        panel.add(button);

        add(textarea,BorderLayout.CENTER);
        add(panel,BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent thing){
        JButton b = (JButton) thing.getSource();
        String s = textfield.getText();
        Game.processCommand(s);
    }
}
