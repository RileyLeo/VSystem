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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ComViewPage extends JFrame implements ActionListener {

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
            ComUserField.setText("");
            ComName1Field.setText("");
            ComName2Field.setText("");
            ComEmailField.setText("");
            ComPhoneField.setText("");
            ComNewPassField.setText("");
            ComNewPass2Field.setText("");
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == SaveUpButton) {
            // SAVE ALL CHANGES then back to Committee menu Page
            String a = ComName1Field.getText();
            String b = ComName2Field.getText();
            String c = ComEmailField.getText();
            String d = ComPhoneField.getText();
            if (a.equals("") || b.equals("") || c.equals("") || d.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Information !!!");
            } else if (DataIO.checking8(c) == false) {
                JOptionPane.showMessageDialog(this, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                VSystem.login.setComName1(a);
                VSystem.login.setComName2(b);
                VSystem.login.setComMail(c);
                VSystem.login.setComPhone(d);
                DataIO.write();
                JOptionPane.showMessageDialog(this, "Successfully Updated :)");
            }

        } else if (e.getSource() == ChangePassButton) {
            String f = ComNewPassField.getText();
            String g = ComNewPass2Field.getText();
            int ps1 = f.length();
            int ps2 = g.length();
            if (f.equals("") || g.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Password Field !!!");
            } else if (ps1 < 8 || ps2 < 8) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMinimum Password Length is 8!!!");
            } else if (!f.equals(g)) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMake Sure to Re-Enter Correct Password  !!!");
            } else {
                VSystem.login.setComPass(f);
                DataIO.write();
                ComNewPassField.setText("");
                ComNewPass2Field.setText("");
                JOptionPane.showMessageDialog(this, "Successfully Updated :)");
            }

        } else if (e.getSource() == DisplayButton) {
            ComUserField.setText(VSystem.login.getComUser());
            ComName1Field.setText(VSystem.login.getComName1());
            ComName2Field.setText(VSystem.login.getComName2());
            ComEmailField.setText(VSystem.login.getComMail());
            ComPhoneField.setText(VSystem.login.getComPhone());
        }
    }

    private JPanel contentPane;
    public static JTextField ComUserField, ComName1Field, ComName2Field, ComEmailField, ComPhoneField;
    private JPasswordField ComNewPassField, ComNewPass2Field;
    private JButton BackButton, ExitButton, MinButton, SaveUpButton, ChangePassButton, DisplayButton;
    private int mouseX, mouseY;

    public ComViewPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(725, 225, 460, 580);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 460, 22);
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
        panel_1.setBounds(0, 22, 460, 58);
        contentPane.add(panel_1);

        BackButton = new JButton("");
        BackButton.setIcon(new ImageIcon(ComViewPage.class.getResource("/Image/icons8_previous_25px.png")));
        BackButton.setBorder(null);
        BackButton.setBackground(Color.GRAY);
        BackButton.setBounds(2, 0, 20, 20);
        panel.add(BackButton);
        BackButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComViewPage.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(430, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComViewPage.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(406, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        DisplayButton = new JButton("Refresh");
        DisplayButton.setIcon(new ImageIcon(ComViewPage.class.getResource("/Image/icons8_refresh_25px.png")));
        DisplayButton.setForeground(Color.WHITE);
        DisplayButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DisplayButton.setBorder(null);
        DisplayButton.setBackground(Color.GRAY);
        DisplayButton.setBounds(21, 91, 121, 23);
        contentPane.add(DisplayButton);
        DisplayButton.addActionListener(this);

        SaveUpButton = new JButton("Save & Update");
        SaveUpButton.setForeground(Color.WHITE);
        SaveUpButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SaveUpButton.setBorder(null);
        SaveUpButton.setBackground(Color.GRAY);
        SaveUpButton.setBounds(248, 387, 121, 23);
        contentPane.add(SaveUpButton);
        SaveUpButton.addActionListener(this);

        ComUserField = new JTextField();
        ComUserField.setEditable(false);
        ComUserField.setForeground(Color.WHITE);
        ComUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComUserField.setColumns(10);
        ComUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComUserField.setBackground(Color.DARK_GRAY);
        ComUserField.setBounds(193, 141, 246, 20);
        contentPane.add(ComUserField);

        ComName1Field = new JTextField();
        ComName1Field.setForeground(Color.WHITE);
        ComName1Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComName1Field.setColumns(10);
        ComName1Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComName1Field.setBackground(Color.DARK_GRAY);
        ComName1Field.setBounds(193, 193, 246, 20);
        contentPane.add(ComName1Field);

        ComName2Field = new JTextField();
        ComName2Field.setForeground(Color.WHITE);
        ComName2Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComName2Field.setColumns(10);
        ComName2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComName2Field.setBackground(Color.DARK_GRAY);
        ComName2Field.setBounds(193, 244, 246, 20);
        contentPane.add(ComName2Field);

        ComEmailField = new JTextField();
        ComEmailField.setForeground(Color.WHITE);
        ComEmailField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComEmailField.setColumns(10);
        ComEmailField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComEmailField.setBackground(Color.DARK_GRAY);
        ComEmailField.setBounds(193, 292, 246, 20);
        contentPane.add(ComEmailField);

        ComPhoneField = new JTextField();
        ComPhoneField.setForeground(Color.WHITE);
        ComPhoneField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComPhoneField.setColumns(10);
        ComPhoneField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComPhoneField.setBackground(Color.DARK_GRAY);
        ComPhoneField.setBounds(193, 343, 246, 20);
        contentPane.add(ComPhoneField);
        ComPhoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = ComPhoneField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    ComPhoneField.setEditable(true);
                } else {
                    ComPhoneField.setEditable(false);
                }
            }
        });

        ChangePassButton = new JButton("Change Password");
        ChangePassButton.setForeground(Color.WHITE);
        ChangePassButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        ChangePassButton.setBorder(null);
        ChangePassButton.setBackground(Color.GRAY);
        ChangePassButton.setBounds(242, 534, 140, 23);
        contentPane.add(ChangePassButton);
        ChangePassButton.addActionListener(this);

        ComNewPassField = new JPasswordField();
        ComNewPassField.setForeground(Color.WHITE);
        ComNewPassField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComNewPassField.setEchoChar('*');
        ComNewPassField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComNewPassField.setBackground(Color.DARK_GRAY);
        ComNewPassField.setBounds(193, 437, 246, 20);
        contentPane.add(ComNewPassField);

        ComNewPass2Field = new JPasswordField();
        ComNewPass2Field.setForeground(Color.WHITE);
        ComNewPass2Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComNewPass2Field.setEchoChar('*');
        ComNewPass2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComNewPass2Field.setBackground(Color.DARK_GRAY);
        ComNewPass2Field.setBounds(193, 490, 246, 20);
        contentPane.add(ComNewPass2Field);

        JLabel lblReEnter = new JLabel("Re-Enter New Password");
        lblReEnter.setForeground(Color.WHITE);
        lblReEnter.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblReEnter.setBounds(21, 490, 163, 21);
        contentPane.add(lblReEnter);

        JLabel lblProfile = new JLabel("Profile");
        lblProfile.setForeground(Color.WHITE);
        lblProfile.setFont(new Font("Rockwell", Font.BOLD, 24));
        lblProfile.setBounds(185, 8, 85, 47);
        panel_1.add(lblProfile);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setForeground(Color.WHITE);
        lblNewPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblNewPassword.setBounds(21, 437, 146, 21);
        contentPane.add(lblNewPassword);

        JLabel lbname2c = new JLabel("Last Name");
        lbname2c.setForeground(Color.WHITE);
        lbname2c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname2c.setBounds(21, 244, 146, 21);
        contentPane.add(lbname2c);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblEmail.setBounds(21, 292, 146, 21);
        contentPane.add(lblEmail);

        JLabel lbphone = new JLabel("Phone Number");
        lbphone.setForeground(Color.WHITE);
        lbphone.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbphone.setBounds(21, 343, 146, 21);
        contentPane.add(lbphone);

        JLabel lbname1c = new JLabel("First Name");
        lbname1c.setForeground(Color.WHITE);
        lbname1c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname1c.setBounds(21, 193, 146, 21);
        contentPane.add(lbname1c);

        JLabel lbusername = new JLabel("Username");
        lbusername.setForeground(Color.WHITE);
        lbusername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbusername.setBounds(21, 141, 146, 21);
        contentPane.add(lbusername);

        //setVisible(true);
    }
}
