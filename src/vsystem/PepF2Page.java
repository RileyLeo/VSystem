package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class PepF2Page extends JFrame implements ActionListener {

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
            NameField.setText("");
            UserField.setText("");
            Dose1Area.setText("");
            Dose2Area.setText("");
            String notif = VSystem.login1.getPNot();
            if (notif.equals("on")) {
                PepPage.labelNotif.setVisible(true);
                PepPage.labelNotif1.setVisible(true);
                PepPage.labelNotif1.setText(VSystem.login1.getPRes());
            } else {
                PepPage.labelNotif.setVisible(false);
                PepPage.labelNotif1.setVisible(false);
            }
            setVisible(false);
            VSystem.fifteen.setVisible(true);

        } else if (e.getSource() == SearchDoseButton) {
            

            //SEARCH & DISPLAY SEARCHED DOSE
        }
    }

    private JPanel contentPane;
    public static JTextField NameField, UserField;
    public static JTextArea Dose1Area, Dose2Area;
    private JButton BackButton, ExitButton, MinButton, SearchDoseButton;
    private int mouseX, mouseY;

    public PepF2Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 225, 515, 550);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 515, 22);
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
        panel_1.setBounds(0, 21, 515, 58);
        contentPane.add(panel_1);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(102, 205, 170));
        panel_1_1.setBounds(0, 181, 515, 39);
        contentPane.add(panel_1_1);

        JPanel panel_1_1_1 = new JPanel();
        panel_1_1_1.setLayout(null);
        panel_1_1_1.setBackground(new Color(102, 205, 170));
        panel_1_1_1.setBounds(0, 358, 515, 39);
        contentPane.add(panel_1_1_1);

        BackButton = new JButton("");
        BackButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_previous_25px.png")));
        BackButton.setBorder(null);
        BackButton.setBackground(Color.GRAY);
        BackButton.setBounds(2, 0, 20, 20);
        panel.add(BackButton);
        BackButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(492, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(470, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 231, 495, 116);
        contentPane.add(scrollPane);

        Dose1Area = new JTextArea();
        scrollPane.setViewportView(Dose1Area);
        Dose1Area.setEditable(false);
        Dose1Area.setAutoscrolls(false);
        Dose1Area.setForeground(Color.WHITE);
        Dose1Area.setFont(new Font("Rockwell", Font.BOLD, 14));
        Dose1Area.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Dose1Area.setBackground(Color.DARK_GRAY);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 408, 495, 126);
        contentPane.add(scrollPane_1);

        Dose2Area = new JTextArea();
        scrollPane_1.setViewportView(Dose2Area);
        Dose2Area.setForeground(Color.WHITE);
        Dose2Area.setFont(new Font("Rockwell", Font.BOLD, 14));
        Dose2Area.setEditable(false);
        Dose2Area.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Dose2Area.setBackground(Color.DARK_GRAY);


        UserField = new JTextField();
        UserField.setEditable(false);
        UserField.setForeground(Color.WHITE);
        UserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        UserField.setColumns(10);
        UserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        UserField.setBackground(Color.DARK_GRAY);
        UserField.setBounds(243, 138, 249, 20);
        contentPane.add(UserField);

        NameField = new JTextField();
        NameField.setEditable(false);
        NameField.setForeground(Color.WHITE);
        NameField.setFont(new Font("Rockwell", Font.BOLD, 14));
        NameField.setColumns(10);
        NameField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        NameField.setBackground(Color.DARK_GRAY);
        NameField.setBounds(243, 100, 249, 20);
        contentPane.add(NameField);


        JLabel lbTitle = new JLabel("Digital Certificate");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(147, 11, 225, 47);
        panel_1.add(lbTitle);


        JLabel lbUsername = new JLabel("IC Number / Passport Number");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUsername.setBounds(10, 138, 223, 21);
        contentPane.add(lbUsername);

        JLabel lblDose = new JLabel("Dose 1");
        lblDose.setForeground(Color.WHITE);
        lblDose.setFont(new Font("Rockwell", Font.BOLD, 20));
        lblDose.setBounds(211, 0, 83, 36);
        panel_1_1.add(lblDose);

        JLabel PepName = new JLabel("Name");
        PepName.setForeground(Color.WHITE);
        PepName.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepName.setBounds(10, 100, 205, 21);
        contentPane.add(PepName);

        JLabel lblDose_2 = new JLabel("Dose 2");
        lblDose_2.setForeground(Color.WHITE);
        lblDose_2.setFont(new Font("Rockwell", Font.BOLD, 20));
        lblDose_2.setBounds(211, 0, 83, 36);
        panel_1_1_1.add(lblDose_2);
        //setVisible(true);
    }
}
