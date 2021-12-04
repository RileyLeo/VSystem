package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PepViewPage extends JFrame implements ActionListener {

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
            PepUserField.setText("");
            PepName1Field.setText("");
            PepName2Field.setText("");
            PepGenField.setText("");
            PepEmailField.setText("");
            PepPhoneField.setText("");
            PepMonthField.setText("");
            PepYearField.setText("");
            PepTypeField.setText("");
            PepDateField.setText("");
            PepPassField2.setText("");
            passwordField.setText("");
            PepAddField.setText("");
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

        } else if (e.getSource() == SavePepButton) {
            //String a1 = PepTypeField.getText();
            //String a1 = PepUserField.getText();
            String a1 = PepName1Field.getText();
            String a2 = PepName2Field.getText();
            String a3 = PepGenField.getText();
            String a4 = PepEmailField.getText();
            String a5 = PepPhoneField.getText();
            String a6 = PepDateField.getText();
            String a7 = PepMonthField.getText();
            String a8 = PepYearField.getText();
            String a9 = PepAddField.getText();

            String pdate1 = a6 + "/" + a7 + "/" + a8;
            DateChecker x = new DateChecker();
            boolean x1 = x.CheckDate(pdate1);
            boolean x2 = x.CheckDate1(pdate1);
            if (a1.equals("") || a2.equals("") || a3.equals("") || a4.equals("") || a5.equals("") || a6.equals("")
                    || a7.equals("") || a8.equals("") || a9.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Information !!!");
            } else if (!"Male".equals(a3) && !"Female".equals(a3)) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nGender = Male or Female !!!");
            } else if (DataIO.checking8(a4) == false) {
                JOptionPane.showMessageDialog(this, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (x1 == false || x2 == false) {
                JOptionPane.showMessageDialog(this, "Invalid Date :/");
            } else {
                VSystem.login1.setPName1(a1);
                VSystem.login1.setPName2(a2);
                VSystem.login1.setPGen(a3);
                VSystem.login1.setPMail(a4);
                VSystem.login1.setPPhone(a5);
                VSystem.login1.setPDate(a6);
                VSystem.login1.setPMonth(a7);
                VSystem.login1.setPYear(a8);
                VSystem.login1.setPAdd(a9);
                People.PepChange();
                DataIO.write();
                JOptionPane.showMessageDialog(this, "Successfully Updated");
            }

        } else if (e.getSource() == ChangePassButton) {
            //CHANGE PASS THEN BACK TO PREVOUS MENU PAGE
            String a10 = PepPassField2.getText();
            String a11 = passwordField.getText();
            int a10a = a10.length();
            int a10b = a11.length();
            if (a10.equals("") || a11.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill all Password Field");
            } else if (a10a < 8 || a10b < 8) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMinimum Password Length = 8");
            } else if (!a10.equals(a11)) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMake Sure to Re-Enter Correct Password  !!!");
            } else {
                VSystem.login1.setPPass(a10);
                DataIO.write();
                PepPassField2.setText("");
                passwordField.setText("");
                JOptionPane.showMessageDialog(this, "Successfully Changed");

            }

        } else if (e.getSource() == DisplayButton) {
            //DISPLAY
            PepTypeField.setText(VSystem.login1.getPType());
            PepUserField.setText(VSystem.login1.getPUser());
            PepName1Field.setText(VSystem.login1.getPName1());
            PepName2Field.setText(VSystem.login1.getPName2());
            PepGenField.setText(VSystem.login1.getPGen());
            PepEmailField.setText(VSystem.login1.getPMail());
            PepPhoneField.setText(VSystem.login1.getPPhone());
            PepDateField.setText(VSystem.login1.getPDate());
            PepMonthField.setText(VSystem.login1.getPMonth());
            PepYearField.setText(VSystem.login1.getPYear());
            PepAddField.setText(VSystem.login1.getPAdd());

        }
    }
    private JPanel contentPane;
    public static JTextField PepUserField, PepName1Field, PepName2Field, PepGenField, PepEmailField, PepPhoneField, PepMonthField, PepYearField, PepTypeField, PepDateField, PepAddField;
    private JPasswordField PepPassField2, passwordField;
    private JButton BackButton, ExitButton, MinButton, SavePepButton, ChangePassButton, DisplayButton;
    private int mouseX, mouseY;

    public PepViewPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(725, 150, 520, 755);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 520, 22);
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
        panel_1.setBounds(0, 22, 520, 58);
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
        MinButton.setBounds(474, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(497, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        DisplayButton = new JButton("Refresh");
        DisplayButton.setIcon(new ImageIcon(PepViewPage.class.getResource("/Image/icons8_refresh_25px.png")));
        DisplayButton.setForeground(Color.WHITE);
        DisplayButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DisplayButton.setBorder(null);
        DisplayButton.setBackground(Color.GRAY);
        DisplayButton.setBounds(24, 102, 121, 23);
        contentPane.add(DisplayButton);
        DisplayButton.addActionListener(this);

        ChangePassButton = new JButton("Change Password");
        ChangePassButton.setForeground(Color.WHITE);
        ChangePassButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        ChangePassButton.setBorder(null);
        ChangePassButton.setBackground(Color.GRAY);
        ChangePassButton.setBounds(301, 708, 140, 23);
        contentPane.add(ChangePassButton);
        ChangePassButton.addActionListener(this);

        SavePepButton = new JButton("Save & Update");
        SavePepButton.setForeground(Color.WHITE);
        SavePepButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SavePepButton.setBorder(null);
        SavePepButton.setBackground(Color.GRAY);
        SavePepButton.setBounds(301, 568, 121, 23);
        contentPane.add(SavePepButton);
        SavePepButton.addActionListener(this);

        PepUserField = new JTextField();
        PepUserField.setEditable(false);
        PepUserField.setForeground(Color.WHITE);
        PepUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepUserField.setColumns(10);
        PepUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepUserField.setBackground(Color.DARK_GRAY);
        PepUserField.setBounds(249, 186, 246, 20);
        contentPane.add(PepUserField);

        PepAddField = new JTextField();
        PepAddField.setForeground(Color.WHITE);
        PepAddField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepAddField.setColumns(10);
        PepAddField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepAddField.setBackground(Color.DARK_GRAY);
        PepAddField.setBounds(249, 519, 246, 20);
        contentPane.add(PepAddField);

        PepName1Field = new JTextField();
        PepName1Field.setForeground(Color.WHITE);
        PepName1Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepName1Field.setColumns(10);
        PepName1Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepName1Field.setBackground(Color.DARK_GRAY);
        PepName1Field.setBounds(249, 232, 246, 20);
        contentPane.add(PepName1Field);

        PepName2Field = new JTextField();
        PepName2Field.setForeground(Color.WHITE);
        PepName2Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepName2Field.setColumns(10);
        PepName2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepName2Field.setBackground(Color.DARK_GRAY);
        PepName2Field.setBounds(249, 279, 246, 20);
        contentPane.add(PepName2Field);

        PepGenField = new JTextField();
        PepGenField.setForeground(Color.WHITE);
        PepGenField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepGenField.setColumns(10);
        PepGenField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepGenField.setBackground(Color.DARK_GRAY);
        PepGenField.setBounds(249, 328, 246, 20);
        contentPane.add(PepGenField);

        PepEmailField = new JTextField();
        PepEmailField.setForeground(Color.WHITE);
        PepEmailField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepEmailField.setColumns(10);
        PepEmailField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepEmailField.setBackground(Color.DARK_GRAY);
        PepEmailField.setBounds(249, 376, 246, 20);
        contentPane.add(PepEmailField);

        PepPhoneField = new JTextField();
        PepPhoneField.setForeground(Color.WHITE);
        PepPhoneField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepPhoneField.setColumns(10);
        PepPhoneField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepPhoneField.setBackground(Color.DARK_GRAY);
        PepPhoneField.setBounds(249, 425, 246, 20);
        contentPane.add(PepPhoneField);
        PepPhoneField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = PepPhoneField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    PepPhoneField.setEditable(true);
                } else {
                    PepPhoneField.setEditable(false);
                }
            }
        });

        PepPassField2 = new JPasswordField();
        PepPassField2.setForeground(Color.WHITE);
        PepPassField2.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepPassField2.setEchoChar('*');
        PepPassField2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepPassField2.setBackground(Color.DARK_GRAY);
        PepPassField2.setBounds(249, 667, 246, 20);
        contentPane.add(PepPassField2);

        PepDateField = new JTextField();
        PepDateField.setForeground(Color.WHITE);
        PepDateField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepDateField.setColumns(10);
        PepDateField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepDateField.setBackground(Color.DARK_GRAY);
        PepDateField.setBounds(249, 473, 76, 20);
        contentPane.add(PepDateField);
        PepDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = PepDateField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    PepDateField.setEditable(true);
                } else {
                    PepDateField.setEditable(false);
                }
            }
        });

        PepMonthField = new JTextField();
        PepMonthField.setForeground(Color.WHITE);
        PepMonthField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepMonthField.setColumns(10);
        PepMonthField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepMonthField.setBackground(Color.DARK_GRAY);
        PepMonthField.setBounds(334, 473, 76, 20);
        contentPane.add(PepMonthField);
        PepMonthField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = PepMonthField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    PepMonthField.setEditable(true);
                } else {
                    PepMonthField.setEditable(false);
                }
            }
        });

        PepYearField = new JTextField();
        PepYearField.setForeground(Color.WHITE);
        PepYearField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepYearField.setColumns(10);
        PepYearField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepYearField.setBackground(Color.DARK_GRAY);
        PepYearField.setBounds(419, 473, 76, 20);
        contentPane.add(PepYearField);
        PepYearField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = PepYearField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    PepYearField.setEditable(true);
                } else {
                    PepYearField.setEditable(false);
                }
            }
        });

        passwordField = new JPasswordField();
        passwordField.setForeground(Color.WHITE);
        passwordField.setFont(new Font("Rockwell", Font.BOLD, 14));
        passwordField.setEchoChar('*');
        passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setBounds(249, 624, 246, 20);
        contentPane.add(passwordField);

        PepTypeField = new JTextField();
        PepTypeField.setEditable(false);
        PepTypeField.setForeground(Color.WHITE);
        PepTypeField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepTypeField.setColumns(10);
        PepTypeField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepTypeField.setBackground(Color.DARK_GRAY);
        PepTypeField.setBounds(249, 139, 246, 20);
        contentPane.add(PepTypeField);

        JLabel lblPeopleType = new JLabel("People Type");
        lblPeopleType.setForeground(Color.WHITE);
        lblPeopleType.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPeopleType.setBounds(24, 138, 198, 21);
        contentPane.add(lblPeopleType);

        JLabel lbTitle = new JLabel("Profile");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(218, 8, 85, 47);
        panel_1.add(lbTitle);

        JLabel lblUsername = new JLabel("IC Number / Passport");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblUsername.setBounds(24, 186, 198, 21);
        contentPane.add(lblUsername);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setForeground(Color.WHITE);
        lblFirstName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblFirstName.setBounds(24, 231, 121, 21);
        contentPane.add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblLastName.setBounds(24, 278, 121, 21);
        contentPane.add(lblLastName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setForeground(Color.WHITE);
        lblGender.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblGender.setBounds(24, 327, 121, 21);
        contentPane.add(lblGender);

        JLabel lblNewPass = new JLabel("New Password");
        lblNewPass.setForeground(Color.WHITE);
        lblNewPass.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblNewPass.setBounds(24, 624, 177, 21);
        contentPane.add(lblNewPass);

        JLabel lblPassword2 = new JLabel("Re-Enter New Password");
        lblPassword2.setForeground(Color.WHITE);
        lblPassword2.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPassword2.setBounds(24, 667, 177, 21);
        contentPane.add(lblPassword2);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblEmail.setBounds(24, 375, 121, 21);
        contentPane.add(lblEmail);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPhoneNumber.setBounds(24, 425, 121, 21);
        contentPane.add(lblPhoneNumber);

        JLabel lblDateOfBirth = new JLabel("Date of Birth (dd-mm-yyyy)");
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblDateOfBirth.setBounds(24, 472, 198, 21);
        contentPane.add(lblDateOfBirth);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblAddress.setBounds(24, 518, 121, 21);
        contentPane.add(lblAddress);

        //setVisible(true);
    }
}
