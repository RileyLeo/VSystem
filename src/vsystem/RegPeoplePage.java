package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegPeoplePage extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == PTcombobox) {
            switch (PTcombobox.getSelectedIndex()) {
                case 0:
                    PTusername.setText("IC Number");
                    break;
                case 1:
                    PTusername.setText("Passport Number");
                    break;
            }

        } else if (e.getSource() == ExitButton) {
            int opt = JOptionPane.showConfirmDialog(this, "You want to Exit ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (e.getSource() == MinButton) {
            this.setState(JFrame.ICONIFIED);

        } else if (e.getSource() == BackButton) {
            InputUser.setText("");
            InputName1.setText("");
            InputName2.setText("");
            InputEmail.setText("");
            InputPhone.setText("");
            Inputdd.setText("");
            Inputmm.setText("");
            Inputyyyy.setText("");
            AddressField.setText("");
            InputPass1.setText("");
            InputPass2.setText("");
            GenderComboBox.setSelectedIndex(0);
            PTcombobox.setSelectedIndex(0);
            PTusername.setText("Username (IC No / Passport No) ");
            setVisible(false);
            if (VSystem.login == null) {
                VSystem.one.setVisible(true);
            } else {
                VSystem.seven.setVisible(true);
            }

        } else if (e.getSource() == RegButton) {
            //REGISTER PEOPLE THEN BACK TO LOGIN PAGE
            String p1 = PTcombobox.getSelectedItem().toString();
            String p2 = InputUser.getText();
            String p3 = InputPass1.getText();
            String p4 = InputPass2.getText();
            String p5 = InputName1.getText();
            String p6 = InputName2.getText();
            String p7 = GenderComboBox.getSelectedItem().toString();
            String p8 = InputEmail.getText();
            String p9 = InputPhone.getText();
            String p10 = Inputdd.getText();
            String p11 = Inputmm.getText();
            String p12 = Inputyyyy.getText();
            String p13 = AddressField.getText();
            String p14 = "off";
            String p15 = "";
            String p16 = "0";
            int p3a = p3.length();
            int p3b = p4.length();
            String pdate = p10 + "/" + p11 + "/" + p12;
            DateChecker x = new DateChecker();
            boolean x1 = x.CheckDate(pdate);
            boolean x2 = x.CheckDate1(pdate);
            if (p2.equals("") || p3.equals("") || p4.equals("") || p5.equals("") || p6.equals("") || p8.equals("")
                    || p9.equals("") || p10.equals("") || p11.equals("") || p12.equals("") || p13.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Information !!!");
            } else if (p3a < 8 || p3b < 8) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMinimum Password Length = 8");
            } else if (!p3.equals(p4)) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMake Sure to Re-Enter Correct Password  !!!");
            } else if (DataIO.checking8(p8) == false) {
                JOptionPane.showMessageDialog(this, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (x2 == false || x1 == false) {
                JOptionPane.showMessageDialog(this, "Invalid Date :/");
            } else {
                People found = DataIO.checking1(p2);
                if (found == null) {
                    InputUser.setText("");
                    InputName1.setText("");
                    InputName2.setText("");
                    InputEmail.setText("");
                    InputPhone.setText("");
                    Inputdd.setText("");
                    Inputmm.setText("");
                    Inputyyyy.setText("");
                    AddressField.setText("");
                    InputPass1.setText("");
                    InputPass2.setText("");
                    GenderComboBox.setSelectedIndex(0);
                    PTcombobox.setSelectedIndex(0);
                    PTusername.setText("Username (IC No / Passport No) ");
                    People i = new People(p1, p2, p3, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16);
                    DataIO.allPep.add(i);
                    DataIO.write();
                    //JOptionPane.showMessageDialog(this, "Successfully Registered :)");
                    int opt = JOptionPane.showConfirmDialog(this, "Successfully Registered :)\n You want back to Previous Page ?", "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (opt == JOptionPane.YES_OPTION) {
                        setVisible(false);
                        if (VSystem.login == null){
                        VSystem.one.setVisible(true);
                        } else {                         
                        VSystem.seven.setVisible(true);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "The username has been used!");
                }
            }
        }
    }

    private JPanel contentPane;
    private JTextField PTusername, InputUser, InputName1, InputName2, InputEmail, InputPhone, Inputdd, Inputmm, Inputyyyy, AddressField;
    private JPasswordField InputPass1, InputPass2;
    private JComboBox PTcombobox, GenderComboBox;
    private JButton ExitButton, MinButton, BackButton, RegButton;
    private int mouseX, mouseY;

    public RegPeoplePage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(650, 120, 580, 725);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 580, 21);
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
        panel_1.setBounds(0, 21, 580, 58);
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
        ExitButton.setBounds(557, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(RegPeoplePage.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(534, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        RegButton = new JButton("Register");
        RegButton.setBackground(Color.GRAY);
        RegButton.setBorder(null);
        RegButton.setForeground(Color.WHITE);
        RegButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        RegButton.setBounds(238, 682, 89, 23);
        contentPane.add(RegButton);
        RegButton.addActionListener(this);

        PTcombobox = new JComboBox();
        PTcombobox.setModel(new DefaultComboBoxModel(new String[]{"Citizen", "Non-Citizen"}));
        PTcombobox.setForeground(Color.WHITE);
        PTcombobox.setBackground(Color.GRAY);
        PTcombobox.setFont(new Font("Rockwell", Font.BOLD, 14));
        PTcombobox.setBounds(296, 106, 246, 22);
        contentPane.add(PTcombobox);
        PTcombobox.addActionListener(this);

        GenderComboBox = new JComboBox();
        GenderComboBox.setModel(new DefaultComboBoxModel(new String[]{"Male", "Female"}));
        GenderComboBox.setForeground(Color.WHITE);
        GenderComboBox.setFont(new Font("Rockwell", Font.BOLD, 14));
        GenderComboBox.setBackground(Color.GRAY);
        GenderComboBox.setBounds(296, 405, 246, 22);
        contentPane.add(GenderComboBox);

        PTusername = new JTextField();
        PTusername.setBorder(null);
        PTusername.setEditable(false);
        PTusername.setForeground(Color.WHITE);
        PTusername.setFont(new Font("Rockwell", Font.BOLD, 14));
        PTusername.setBackground(Color.DARK_GRAY);
        PTusername.setText("Username (IC No / Passport No) ");
        PTusername.setBounds(42, 159, 249, 20);
        contentPane.add(PTusername);
        PTusername.setColumns(10);

        InputUser = new JTextField();
        InputUser.setForeground(Color.WHITE);
        InputUser.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputUser.setBackground(Color.DARK_GRAY);
        InputUser.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputUser.setBounds(296, 159, 246, 20);
        contentPane.add(InputUser);
        InputUser.setColumns(10);

        InputName1 = new JTextField();
        InputName1.setForeground(Color.WHITE);
        InputName1.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputName1.setColumns(10);
        InputName1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputName1.setBackground(Color.DARK_GRAY);
        InputName1.setBounds(296, 308, 246, 20);
        contentPane.add(InputName1);

        InputName2 = new JTextField();
        InputName2.setForeground(Color.WHITE);
        InputName2.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputName2.setColumns(10);
        InputName2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputName2.setBackground(Color.DARK_GRAY);
        InputName2.setBounds(296, 357, 246, 20);
        contentPane.add(InputName2);

        InputEmail = new JTextField();
        InputEmail.setForeground(Color.WHITE);
        InputEmail.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputEmail.setColumns(10);
        InputEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputEmail.setBackground(Color.DARK_GRAY);
        InputEmail.setBounds(296, 450, 246, 20);
        contentPane.add(InputEmail);

        InputPhone = new JTextField();
        InputPhone.setForeground(Color.WHITE);
        InputPhone.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPhone.setColumns(10);
        InputPhone.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPhone.setBackground(Color.DARK_GRAY);
        InputPhone.setBounds(296, 496, 246, 20);
        contentPane.add(InputPhone);
        InputPhone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = InputPhone.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    InputPhone.setEditable(true);
                } else {
                    InputPhone.setEditable(false);
                }
            }
        });

        AddressField = new JTextField();
        AddressField.setForeground(Color.WHITE);
        AddressField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AddressField.setColumns(10);
        AddressField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AddressField.setBackground(Color.DARK_GRAY);
        AddressField.setBounds(296, 620, 246, 20);
        contentPane.add(AddressField);

        InputPass1 = new JPasswordField();
        InputPass1.setBackground(Color.DARK_GRAY);
        InputPass1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPass1.setEchoChar('*');
        InputPass1.setForeground(Color.WHITE);
        InputPass1.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPass1.setBounds(296, 211, 246, 20);
        contentPane.add(InputPass1);

        InputPass2 = new JPasswordField();
        InputPass2.setForeground(Color.WHITE);
        InputPass2.setFont(new Font("Rockwell", Font.BOLD, 14));
        InputPass2.setEchoChar('*');
        InputPass2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        InputPass2.setBackground(Color.DARK_GRAY);
        InputPass2.setBounds(296, 261, 246, 20);
        contentPane.add(InputPass2);

        Inputdd = new JTextField();
        Inputdd.setForeground(Color.WHITE);
        Inputdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        Inputdd.setColumns(10);
        Inputdd.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Inputdd.setBackground(Color.DARK_GRAY);
        Inputdd.setBounds(296, 544, 76, 20);
        contentPane.add(Inputdd);
        Inputdd.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = Inputdd.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    Inputdd.setEditable(true);
                } else {
                    Inputdd.setEditable(false);
                }
            }
        });

        Inputmm = new JTextField();
        Inputmm.setForeground(Color.WHITE);
        Inputmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        Inputmm.setColumns(10);
        Inputmm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Inputmm.setBackground(Color.DARK_GRAY);
        Inputmm.setBounds(382, 544, 76, 20);
        contentPane.add(Inputmm);
        Inputmm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = Inputmm.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    Inputmm.setEditable(true);
                } else {
                    Inputmm.setEditable(false);
                }
            }
        });

        Inputyyyy = new JTextField();
        Inputyyyy.setForeground(Color.WHITE);
        Inputyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        Inputyyyy.setColumns(10);
        Inputyyyy.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        Inputyyyy.setBackground(Color.DARK_GRAY);
        Inputyyyy.setBounds(468, 544, 76, 20);
        contentPane.add(Inputyyyy);
        Inputyyyy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = Inputyyyy.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    Inputyyyy.setEditable(true);
                } else {
                    Inputyyyy.setEditable(false);
                }
            }
        });

        JLabel lbpass1 = new JLabel("Password");
        lbpass1.setForeground(Color.WHITE);
        lbpass1.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbpass1.setBounds(42, 210, 244, 21);
        contentPane.add(lbpass1);

        JLabel lbpass2 = new JLabel("Re-enter Password");
        lbpass2.setForeground(Color.WHITE);
        lbpass2.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbpass2.setBounds(42, 260, 244, 21);
        contentPane.add(lbpass2);

        JLabel lbgender = new JLabel("Gender");
        lbgender.setForeground(Color.WHITE);
        lbgender.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbgender.setBounds(42, 405, 244, 21);
        contentPane.add(lbgender);

        JLabel lbemail = new JLabel("E-mail");
        lbemail.setForeground(Color.WHITE);
        lbemail.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbemail.setBounds(42, 450, 244, 21);
        contentPane.add(lbemail);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPhoneNumber.setBounds(42, 496, 244, 21);
        contentPane.add(lblPhoneNumber);

        JLabel lbdd = new JLabel("DD");
        lbdd.setForeground(Color.WHITE);
        lbdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbdd.setBounds(296, 572, 58, 21);
        contentPane.add(lbdd);

        JLabel lbmm = new JLabel("MM");
        lbmm.setForeground(Color.WHITE);
        lbmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbmm.setBounds(382, 572, 58, 21);
        contentPane.add(lbmm);

        JLabel lbyyyy = new JLabel("YYYY");
        lbyyyy.setForeground(Color.WHITE);
        lbyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbyyyy.setBounds(468, 572, 58, 21);
        contentPane.add(lbyyyy);

        JLabel SelectType = new JLabel("Select Type");
        SelectType.setForeground(Color.WHITE);
        SelectType.setFont(new Font("Rockwell", Font.BOLD, 14));
        SelectType.setBounds(42, 107, 244, 21);
        contentPane.add(SelectType);

        JLabel lbname1 = new JLabel("First Name");
        lbname1.setForeground(Color.WHITE);
        lbname1.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname1.setBounds(42, 308, 244, 21);
        contentPane.add(lbname1);

        JLabel lbname2 = new JLabel("Last Name");
        lbname2.setForeground(Color.WHITE);
        lbname2.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname2.setBounds(42, 357, 244, 21);
        contentPane.add(lbname2);

        JLabel Title1 = new JLabel("Registration Page");
        Title1.setBounds(194, 8, 220, 47);
        Title1.setForeground(Color.WHITE);
        Title1.setFont(new Font("Rockwell", Font.BOLD, 24));
        panel_1.add(Title1);

        JLabel lblDateOfBirth = new JLabel("Date of Birth (dd-mm-yyyy)");
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblDateOfBirth.setBounds(42, 543, 244, 21);
        contentPane.add(lblDateOfBirth);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblAddress.setBounds(42, 619, 244, 21);
        contentPane.add(lblAddress);

        //setVisible(true);
    }

}
