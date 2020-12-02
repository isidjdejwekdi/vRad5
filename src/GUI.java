import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private JTable table=null;
    private JButton inputButton;
    private JButton outputButton;

    public GUI(InputButtonListener input, InputButtonListener output) throws HeadlessException {
        setTitle("Game Field");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        table = new JTable();
        add(table);

        inputButton = new JButton("Choose input file");
        inputButton.addActionListener(input);
        inputButton.setLocation(0,0);
        inputButton.setSize(200,20);
        add(inputButton);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setJTable(InputButtonListener input, InputButtonListener output, Integer[][] data) {

        getContentPane().removeAll();
        table = new JTable();
        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[data[0].length]));
        add(table);

        inputButton = new JButton("Choose input file");
        inputButton.addActionListener(input);
        inputButton.setLocation(0,0);
        inputButton.setSize(200,20);
        add(inputButton);

        outputButton = new JButton("Save field to output file");
        outputButton.addActionListener(output);
        outputButton.setLocation(200,0);
        outputButton.setSize(200,20);
        add(outputButton);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        revalidate();
        inputButton.setVisible(false);
        outputButton.setVisible(false);
        inputButton.setVisible(true);
        outputButton.setVisible(true);
    }

    public JTable getTable() {
        return table;
    }
}
