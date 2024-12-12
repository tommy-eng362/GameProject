import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIframe extends JFrame implements ActionListener {

    public GUIframe(){
        buildFrame();
    }

    public JTextArea textarea;
    private JPanel panel;
    private JLabel label;
    private JTextField textField;
    private JButton button;

    @Override
    public void actionPerformed(ActionEvent event){
        JButton j = (JButton) event.getSource();
        String s = textField.getText();
        Game.processCommand(s);
    }

    private void buildFrame(){
        setTitle("Only ONE Thing Matters.");
        setLayout(new BorderLayout());  // Specifies 3x3 layout
        textarea = new JTextArea();
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        label = new JLabel("What would you like to do?");
        textField = new JTextField();

        button = new JButton("Execute");
        button.addActionListener(this);

        panel.add(label);
        panel.add(textField);
        panel.add(button);
        add(textarea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null); // Center window
        setVisible(true); // Make window appear
    

        

    }

    

}
