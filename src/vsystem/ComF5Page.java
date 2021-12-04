package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.print.*;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ComF5Page extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ExitButton) {
            int opt = JOptionPane.showConfirmDialog(this, "You want to Exit ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (e.getSource() == MinButton) {
            this.setState(JFrame.ICONIFIED);

        } else if (e.getSource() == BackButton) {
            ViewReportArea.setText("");
            ReportCombobox.setSelectedIndex(0);
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == ReportCombobox) {
            switch (ReportCombobox.getSelectedIndex()) {
                case 0:
                    ViewReportArea.setText("");
                    Report.AllPepRep();
                    break;
                case 1:
                    ViewReportArea.setText("");
                    Report.CitRep();
                    break;
                case 2:
                    ViewReportArea.setText("");
                    Report.NonCitRep();
                    break;
                case 3:

                    ViewReportArea.setText("");
                    break;
                case 4:

                    ViewReportArea.setText("");
                    break;
                case 5:

                    ViewReportArea.setText("");
                    break;
                case 6:
                    ViewReportArea.setText("");

                    break;
            }
        } else if (e.getSource() == printButton) {
            if (ViewReportArea.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Select a report!");
            } else {            
                try {
                    //print report
                    ViewReportArea.setForeground(Color.BLACK);
                    ViewReportArea.print();
                    ViewReportArea.setForeground(Color.WHITE);
                } catch (PrinterException ex) {
                    Logger.getLogger(ComF5Page.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    private JPanel contentPane;
    public static JTextArea ViewReportArea;
    public static JComboBox ReportCombobox;
    private JButton BackButton, ExitButton, MinButton, printButton;
    private int mouseX, mouseY;

    public ComF5Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750, 200, 450, 620);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 450, 22);
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        contentPane.add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 22, 450, 58);
        contentPane.add(panel_1);

        BackButton = new JButton("");
        BackButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_previous_25px.png")));
        BackButton.setBorder(null);
        BackButton.setBackground(Color.GRAY);
        BackButton.setBounds(2, 0, 20, 20);
        panel.add(BackButton);
        BackButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(405, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(428, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        printButton = new JButton(" Print");
        printButton.setIcon(new ImageIcon(ComF5Page.class.getResource("/Image/icons8_print_30px.png")));
        printButton.setForeground(Color.WHITE);
        printButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        printButton.setBorder(null);
        printButton.setBackground(Color.GRAY);
        printButton.setBounds(160, 577, 120, 32);
        contentPane.add(printButton);
        printButton.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 144, 430, 420);
        contentPane.add(scrollPane);

        ViewReportArea = new JTextArea();
        scrollPane.setViewportView(ViewReportArea);
        ViewReportArea.setFont(new Font("Rockwell", Font.BOLD, 14));
        ViewReportArea.setForeground(Color.WHITE);
        ViewReportArea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ViewReportArea.setEditable(false);
        ViewReportArea.setBackground(Color.DARK_GRAY);

        ReportCombobox = new JComboBox();
        ReportCombobox.setModel(new DefaultComboBoxModel());
        ReportCombobox.setForeground(Color.WHITE);
        ReportCombobox.setFont(new Font("Rockwell", Font.BOLD, 14));
        ReportCombobox.setBackground(Color.GRAY);
        ReportCombobox.setBounds(179, 101, 249, 22);
        contentPane.add(ReportCombobox);
        ReportCombobox.addActionListener(this);

        JLabel lblSelect = new JLabel("Select Report");
        lblSelect.setForeground(Color.WHITE);
        lblSelect.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblSelect.setBounds(22, 102, 134, 21);
        contentPane.add(lblSelect);

        JLabel lbTitle = new JLabel("Statistical Report");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(125, 8, 217, 47);
        panel_1.add(lbTitle);

        //setVisible(true);
    }
}
