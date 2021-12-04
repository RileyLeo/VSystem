package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;

public class RegComPage extends JFrame implements ActionListener {

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
            InputUserC.setText("");
            InputName1C.setText("");
            InputName2C.setText("");
            InputEmailC.setText("");
            InputPhoneC.setText("");
            InputPass1C.setText("");
            InputPass2C.setText("");
            DefaultTableModel tm1 = (DefaultTableModel) ComF1Page.comTable.getModel();
            tm1.setRowCount(0);
            for (int i = 0; i < DataIO.allCom.size(); i++) {
                String c1 = DataIO.allCom.get(i).getComUser();
                String c2 = DataIO.allCom.get(i).getComName1();
                String c3 = DataIO.allCom.get(i).getComName2();
                String c4 = DataIO.allCom.get(i).getComMail();
                String c5 = DataIO.allCom.get(i).getComPhone();
                String comArr[] = {c1, c2, c3, c4, c5};
                tm1.addRow(comArr);
            }

            setVisible(false);
            VSystem.six.setVisible(true);

        } else if (e.getSource() == RegCButton) {
            //REGISTER COMMITTEE THEN BACK TO LOGIN PAGE
            String a = InputUserC.getText();
            String b = InputPass1C.getText();
            String c = InputPass2C.getText();
            String d = InputName1C.getText();
            String f = InputName2C.getText();
            String g = InputEmailC.getText();
            String h = InputPhoneC.getText();
            int b1 = b.length();
            int b2 = c.length();
            if (a.equals("") || b.equals("") || c.equals("") || d.equals("") || f.equals("") || g.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Information !!!");
            } else if (b1 < 8 || b2 < 8) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMinimum Password Length = 8");
            } else if (!b.equals(c)) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMake Sure to Re-Enter Correct Password  !!!");
            } else if (DataIO.checking8(g) == false) {
                JOptionPane.showMessageDialog(this, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Committee found = DataIO.checking(a);
                if (found == null) {
                    InputUserC.setText("");
                    InputName1C.setText("");
                    InputName2C.setText("");
                    InputEmailC.setText("");
                    InputPhoneC.setText("");
                    InputPass1C.setText("");
                    InputPass2C.setText("");
                    Committee i = new Committee(a, b, d, f, g, h);
                    DataIO.allCom.add(i);
                    DataIO.write();
                    //JOptionPane.showMessageDialog(this, "Successfully Registered :)");
                    int opt1 = JOptionPane.showConfirmDialog(this, "Successfully Registered :)\n You want back to Login Page ?", "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (opt1 == JOptionPane.YES_OPTION) {
                        VSystem.login = null;
                        setVisible(false);
                        VSystem.one.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The username has been used!");
                }
            }

        }
    }

    private JPanel contentPane;
    private JTextField InputUserC, InputName1C, InputName2C, InputEmailC, InputPhoneC;
    private JPasswordField InputPass1C, InputPass2C;
    private JButton BackButton, ExitButton, MinButton, RegCButton;
    private int mouseX, mouseY;

    public RegComPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 250, 581, 514);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 581, 21);
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
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 21, 581, 58);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        BackButton = new JButton("");
        BackButton.setIcon(new ImageIcon(RegPeoplePage.class.getResource("/Image/icons8_previous_25px.png")));
        BackButton.setBorder(null);
        BackButton.setBackground(Color.GRAY);
        BackButton.setBounds(2, 0, 20, 20);
        panel.add(BackButton);
        BackButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(RegPeoplePage.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(559, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(RegPeoplePage.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(534, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        RegCButton = new JButton("Register");
        RegCButton.setBackground(Color.GRAY);
        RegCButton.setBorder(null);
        RegCButton.setForeground(Color.WHITE);
        RegCButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        RegCButton.setBounds(243, 459, 89, 23);
        contentPane.add(RegCButton);
        RegCButton.addActionListener(this);

        InputUserC = new JTextField();
        InputUserC.setForeground(Color.WHITE);
        InputUserC.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputUserC.setBackground(Color.DARK_GRAY);
        InputUserC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputUserC.setBounds(296, 119, 246, 20);
        contentPane.add(InputUserC);
        InputUserC.setColumns(10);

        InputName1C = new JTextField();
        InputName1C.setForeground(Color.WHITE);
        InputName1C.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputName1C.setColumns(10);
        InputName1C.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputName1C.setBackground(Color.DARK_GRAY);
        InputName1C.setBounds(296, 259, 246, 20);
        contentPane.add(InputName1C);

        InputName2C = new JTextField();
        InputName2C.setForeground(Color.WHITE);
        InputName2C.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputName2C.setColumns(10);
        InputName2C.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputName2C.setBackground(Color.DARK_GRAY);
        InputName2C.setBounds(296, 308, 246, 20);
        contentPane.add(InputName2C);

        InputEmailC = new JTextField();
        InputEmailC.setForeground(Color.WHITE);
        InputEmailC.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputEmailC.setColumns(10);
        InputEmailC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputEmailC.setBackground(Color.DARK_GRAY);
        InputEmailC.setBounds(296, 355, 246, 20);
        contentPane.add(InputEmailC);

        InputPass1C = new JPasswordField();
        InputPass1C.setBackground(Color.DARK_GRAY);
        InputPass1C.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPass1C.setEchoChar('*');
        InputPass1C.setForeground(Color.WHITE);
        InputPass1C.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPass1C.setBounds(296, 166, 246, 20);
        contentPane.add(InputPass1C);

        InputPass2C = new JPasswordField();
        InputPass2C.setForeground(Color.WHITE);
        InputPass2C.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPass2C.setEchoChar('*');
        InputPass2C.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPass2C.setBackground(Color.DARK_GRAY);
        InputPass2C.setBounds(296, 211, 246, 20);
        contentPane.add(InputPass2C);

        InputPhoneC = new JTextField();
        InputPhoneC.setForeground(Color.WHITE);
        InputPhoneC.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPhoneC.setColumns(10);
        InputPhoneC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPhoneC.setBackground(Color.DARK_GRAY);
        InputPhoneC.setBounds(296, 399, 246, 20);
        contentPane.add(InputPhoneC);
        InputPhoneC.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = InputPhoneC.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    InputPhoneC.setEditable(true);
                } else {
                    InputPhoneC.setEditable(false);
                }
            }
        });

        JLabel lbnamec = new JLabel("Username");
        lbnamec.setForeground(Color.WHITE);
        lbnamec.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbnamec.setBounds(42, 119, 244, 21);
        contentPane.add(lbnamec);
        JLabel lbname1c = new JLabel("First Name");
        lbname1c.setForeground(Color.WHITE);
        lbname1c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname1c.setBounds(42, 259, 244, 21);
        contentPane.add(lbname1c);

        JLabel lbname2c = new JLabel("Last Name");
        lbname2c.setForeground(Color.WHITE);
        lbname2c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname2c.setBounds(42, 308, 244, 21);
        contentPane.add(lbname2c);

        JLabel Title1 = new JLabel("Committee Registration Page");
        Title1.setBounds(103, 8, 374, 47);
        Title1.setForeground(Color.WHITE);
        Title1.setFont(new Font("Rockwell", Font.BOLD, 24));
        panel_1.add(Title1);

        JLabel lbpass1c = new JLabel("Password");
        lbpass1c.setForeground(Color.WHITE);
        lbpass1c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbpass1c.setBounds(42, 166, 244, 21);
        contentPane.add(lbpass1c);

        JLabel lbpass2 = new JLabel("Re-enter Password");
        lbpass2.setForeground(Color.WHITE);
        lbpass2.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbpass2.setBounds(42, 211, 244, 21);
        contentPane.add(lbpass2);

        JLabel lbemailc = new JLabel("E-mail");
        lbemailc.setForeground(Color.WHITE);
        lbemailc.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbemailc.setBounds(42, 355, 244, 21);
        contentPane.add(lbemailc);

        JLabel lblPhoneNumberc = new JLabel("Phone Number");
        lblPhoneNumberc.setForeground(Color.WHITE);
        lblPhoneNumberc.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPhoneNumberc.setBounds(42, 399, 244, 21);
        contentPane.add(lblPhoneNumberc);

        //setVisible(true);
    }
}
