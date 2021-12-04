package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JOptionPane;

public class LoginPage extends JFrame implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ExitButton) {
            int opt = JOptionPane.showConfirmDialog(this, "You want to Exit ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (opt == JOptionPane.YES_OPTION) {
                DataIO.write();
                System.exit(0);
            }

        } else if (e.getSource() == MinButton) {
            this.setState(JFrame.ICONIFIED);

        } else if (e.getSource() == RegButton) {
            setVisible(false);
            VSystem.two.setVisible(true);

        } else if (e.getSource() == LoginButton) {
            //FUNCTIONAL PAGE
            String a = UserTxtFd.getText();
            String b = PassFd.getText();
            if (a.equals("") || b.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill all Information !!!");

            } else {
                Committee found = DataIO.checking(a);
                People found1 = DataIO.checking1(a);
                if (found != null) {
                    if (b.equals(found.getComPass())) {
                        UserTxtFd.setText("Username");
                        PassFd.setText("Password");
                        VSystem.login = found;
                        setVisible(false);
                        VSystem.four.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password !!!");
                    }
                } else if (found1 != null) {
                    if (b.equals(found1.getPPass())) {
                        UserTxtFd.setText("Username");
                        PassFd.setText("Password");
                        VSystem.login1 = found1;
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
                    } else {
                        JOptionPane.showMessageDialog(this, "Wrong password !!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "You haven't registered :(");
                }
            }

        }
    }

    private JPanel contentPane;
    private JTextField UserTxtFd;
    private JPasswordField PassFd;
    private JButton ExitButton, MinButton, LoginButton, RegButton;
    private int mouseX, mouseY;

    public LoginPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 250, 849, 526);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 849, 21);
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
        panel.setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setFont(new Font("Rockwell", Font.PLAIN, 14));
        panel_2.setBackground(Color.DARK_GRAY);
        panel_2.setBounds(380, 21, 469, 505);
        contentPane.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 21, 381, 505);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        ExitButton = new JButton("");
        ExitButton.setBounds(825, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBorder(null);
        ExitButton.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setBounds(800, 0, 20, 20);
        panel.add(MinButton);
        MinButton.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.addActionListener(this);

        LoginButton = new JButton("Log In");
        LoginButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        LoginButton.setBorderPainted(false);
        LoginButton.setBackground(Color.GRAY);
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setBorder(new CompoundBorder());
        LoginButton.setBounds(208, 287, 89, 23);
        panel_2.add(LoginButton);
        LoginButton.addActionListener(this);

        RegButton = new JButton("Create an account");
        RegButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        RegButton.setBackground(Color.DARK_GRAY);
        RegButton.setBorder(null);
        RegButton.setForeground(Color.WHITE);
        RegButton.setBounds(186, 337, 142, 20);
        panel_2.add(RegButton);
        RegButton.addActionListener(this);

        JSeparator DecoSep1 = new JSeparator();
        DecoSep1.setBounds(141, 167, 237, 7);
        panel_2.add(DecoSep1);

        JSeparator DecoSep2 = new JSeparator();
        DecoSep2.setBounds(141, 236, 237, 7);
        panel_2.add(DecoSep2);

        JSeparator DecoSep3 = new JSeparator();
        DecoSep3.setBounds(186, 357, 142, 7);
        panel_2.add(DecoSep3);

        UserTxtFd = new JTextField();
        UserTxtFd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                UserTxtFd.setText("");
            }
        });
        UserTxtFd.setText("Username");
        UserTxtFd.setFont(new Font("Rockwell", Font.BOLD, 14));
        UserTxtFd.setForeground(Color.WHITE);
        UserTxtFd.setBorder(null);
        UserTxtFd.setBackground(Color.DARK_GRAY);
        UserTxtFd.setBounds(141, 147, 237, 20);
        panel_2.add(UserTxtFd);
        UserTxtFd.setColumns(10);

        PassFd = new JPasswordField();
        PassFd.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                PassFd.setText("");
            }
        });
        PassFd.setEchoChar('*');
        PassFd.setText("Password");
        PassFd.setToolTipText("");
        PassFd.setForeground(Color.WHITE);
        PassFd.setFont(new Font("Rockwell", Font.BOLD, 14));
        PassFd.setBackground(Color.DARK_GRAY);
        PassFd.setBorder(null);
        PassFd.setBounds(141, 216, 237, 20);
        panel_2.add(PassFd);

        JLabel DecoV1n2 = new JLabel("");
        DecoV1n2.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px.png")));
        DecoV1n2.setBounds(233, 376, 50, 51);
        panel_1.add(DecoV1n2);

        JLabel DecoV1n3 = new JLabel("");
        DecoV1n3.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px.png")));
        DecoV1n3.setBounds(294, 75, 50, 51);
        panel_1.add(DecoV1n3);

        JLabel DecoV2n1 = new JLabel("");
        DecoV2n1.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px.png")));
        DecoV2n1.setBounds(63, 348, 50, 51);
        panel_1.add(DecoV2n1);

        JLabel DecoV2n2 = new JLabel("");
        DecoV2n2.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px.png")));
        DecoV2n2.setBounds(315, 213, 50, 51);
        panel_1.add(DecoV2n2);

        JLabel DecoV2n3 = new JLabel("");
        DecoV2n3.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px.png")));
        DecoV2n3.setBounds(23, 151, 50, 51);
        panel_1.add(DecoV2n3);

        JLabel DecoUser = new JLabel("");
        DecoUser.setBounds(96, 134, 35, 40);
        panel_2.add(DecoUser);
        DecoUser.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_user_35px.png")));

        JLabel DecoLock = new JLabel("");
        DecoLock.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_lock_35px.png")));
        DecoLock.setBounds(96, 203, 35, 40);
        panel_2.add(DecoLock);

        JLabel DecoV3n1 = new JLabel("");
        DecoV3n1.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px_1.png")));
        DecoV3n1.setBounds(28, 54, 50, 51);
        panel_2.add(DecoV3n1);

        JLabel DecoV3n3 = new JLabel("");
        DecoV3n3.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px_1.png")));
        DecoV3n3.setBounds(409, 95, 50, 51);
        panel_2.add(DecoV3n3);

        JLabel DecoV3n2 = new JLabel("");
        DecoV3n2.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px_1.png")));
        DecoV3n2.setBounds(190, 425, 50, 51);
        panel_2.add(DecoV3n2);

        JLabel DecoV4n1 = new JLabel("");
        DecoV4n1.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px_1.png")));
        DecoV4n1.setBounds(46, 281, 50, 51);
        panel_2.add(DecoV4n1);

        JLabel DecoV4n3 = new JLabel("");
        DecoV4n3.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px_1.png")));
        DecoV4n3.setBounds(393, 356, 50, 51);
        panel_2.add(DecoV4n3);

        JLabel DecoV4n2 = new JLabel("");
        DecoV4n2.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_virus_50px_1.png")));
        DecoV4n2.setBounds(212, 27, 50, 51);
        panel_2.add(DecoV4n2);

        JLabel DecoNames = new JLabel("By : Kevin Ahmadiputra & Leo Wai Yei");
        DecoNames.setForeground(Color.WHITE);
        DecoNames.setFont(new Font("Rockwell", Font.BOLD, 12));
        DecoNames.setBounds(3, 491, 230, 14);
        panel_1.add(DecoNames);

        JLabel DecoSystemName = new JLabel("Vaccination System");
        DecoSystemName.setFont(new Font("Rockwell", Font.BOLD, 22));
        DecoSystemName.setForeground(Color.WHITE);
        DecoSystemName.setBounds(96, 266, 217, 50);
        panel_1.add(DecoSystemName);

        JLabel DecoLogo = new JLabel("");
        DecoLogo.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_syringe_120px.png")));
        DecoLogo.setBounds(133, 137, 128, 131);
        panel_1.add(DecoLogo);

        JLabel DecoV1n1 = new JLabel("");
        DecoV1n1.setIcon(new ImageIcon(LoginPage.class.getResource("/Image/icons8_coronavirus_50px.png")));
        DecoV1n1.setBounds(63, 33, 50, 51);
        panel_1.add(DecoV1n1);

        setVisible(true);

    }
}
