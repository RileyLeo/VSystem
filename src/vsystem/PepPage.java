package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PepPage extends JFrame implements ActionListener {

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

        } else if (e.getSource() == PepOutButton) {
            VSystem.login1 = null;
            setVisible(false);
            VSystem.one.setVisible(true);

        } else if (e.getSource() == PepViewButton) {
            //TO VIEW PROFILE PAGE
            PepViewPage.PepTypeField.setText(VSystem.login1.getPType());
            PepViewPage.PepUserField.setText(VSystem.login1.getPUser());
            PepViewPage.PepName1Field.setText(VSystem.login1.getPName1());
            PepViewPage.PepName2Field.setText(VSystem.login1.getPName2());
            PepViewPage.PepGenField.setText(VSystem.login1.getPGen());
            PepViewPage.PepEmailField.setText(VSystem.login1.getPMail());
            PepViewPage.PepPhoneField.setText(VSystem.login1.getPPhone());
            PepViewPage.PepDateField.setText(VSystem.login1.getPDate());
            PepViewPage.PepMonthField.setText(VSystem.login1.getPMonth());
            PepViewPage.PepYearField.setText(VSystem.login1.getPYear());
            PepViewPage.PepAddField.setText(VSystem.login1.getPAdd());
            setVisible(false);
            VSystem.sixteen.setVisible(true);

        } else if (e.getSource() == PepF1Button) {
            //TO F1 PAGE
            Appointment found = DataIO.checking4(VSystem.login1.getPUser());
            if (found != null) { // maybe can put say something like no valid appointment please request one
                PepF1Page.DoseField.setText(found.getaDos());
                PepF1Page.ddAppField.setText(found.getaDate());
                PepF1Page.mmAppField.setText(found.getaMonth());
                PepF1Page.yyyyAppField.setText(found.getaYear());
                PepF1Page.LocField.setText(found.getaLoc());
                PepF1Page.StatusField.setText(found.getaStat().toString());
            }
            VSystem.login1.setPNot("off");
            VSystem.login1.setPRes("");
            PepPage.labelNotif1.setText("");
            DataIO.write();
            setVisible(false);
            VSystem.seventeen.setVisible(true);

        } else if (e.getSource() == PepF2Button) {
            //TO F2 PAGE
            PepF2Page.UserField.setText(VSystem.login1.getPUser());
            PepF2Page.NameField.setText(VSystem.login1.getPName1() + " " + VSystem.login1.getPName2());
            int cvi = VSystem.login1.getmyCerti().size();
            if (cvi == 0) {
                PepF2Page.Dose1Area.setText("You haven't Vaccinated Dose 1");
                PepF2Page.Dose2Area.setText("You haven't Vaccinated Dose 2");
            } else {
                for (Certificate ct1 : VSystem.login1.getmyCerti()) {
                    if (ct1.getCpDose().equals("Dose 1")) {
                        PepF2Page.Dose1Area.append(
                                "Location\t\t: " + ct1.getCpLoc() + "\nDate of Vaccination\t: " + ct1.getCpDate() + "/" + ct1.getCpMonth() + "/"
                                + ct1.getCpYear() + "\nVaccine Code\t\t: " + ct1.getCpVac());
                    } else if (ct1.getCpDose().equals("Dose 2")) {
                        PepF2Page.Dose2Area.append(
                                "Location\t\t: " + ct1.getCpLoc() + "\nDate of Vaccination\t: " + ct1.getCpDate() + "/" + ct1.getCpMonth() + "/"
                                + ct1.getCpYear() + "\nVaccine Code\t\t: " + ct1.getCpVac());
                    }
                }
            }
            setVisible(false);
            VSystem.eighteen.setVisible(true);
        }
    }

    private JPanel contentPane;
    private JButton ExitButton, MinButton, PepOutButton, PepViewButton, PepF1Button, PepF2Button;
    private int mouseX, mouseY;
    public static JLabel labelNotif, labelNotif1;

    public PepPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 300, 450, 380);
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
        panel_1.setBounds(0, 21, 450, 87);
        contentPane.add(panel_1);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(425, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(402, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        PepF1Button = new JButton("Appoinment Management");
        PepF1Button.setForeground(Color.WHITE);
        PepF1Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        PepF1Button.setBorder(null);
        PepF1Button.setBackground(Color.GRAY);
        PepF1Button.setBounds(93, 207, 267, 47);
        contentPane.add(PepF1Button);
        PepF1Button.addActionListener(this);

        PepViewButton = new JButton("View Profile");
        PepViewButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_user_50px.png")));
        PepViewButton.setForeground(Color.WHITE);
        PepViewButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        PepViewButton.setBorder(null);
        PepViewButton.setBackground(Color.GRAY);
        PepViewButton.setBounds(10, 119, 164, 47);
        contentPane.add(PepViewButton);
        PepViewButton.addActionListener(this);

        PepOutButton = new JButton("Log Out");
        PepOutButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_logout_rounded_up_40px.png")));
        PepOutButton.setForeground(Color.WHITE);
        PepOutButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        PepOutButton.setBorder(null);
        PepOutButton.setBackground(new Color(178, 34, 34));
        PepOutButton.setBounds(273, 119, 164, 47);
        contentPane.add(PepOutButton);
        PepOutButton.addActionListener(this);

        PepF2Button = new JButton("Vaccination Details");
        PepF2Button.setForeground(Color.WHITE);
        PepF2Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        PepF2Button.setBorder(null);
        PepF2Button.setBackground(Color.GRAY);
        PepF2Button.setBounds(93, 294, 267, 47);
        contentPane.add(PepF2Button);
        PepF2Button.addActionListener(this);

        JLabel Title = new JLabel("PeopleMenu");
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Rockwell", Font.BOLD, 24));
        Title.setBounds(143, 11, 156, 47);
        panel_1.add(Title);

        JLabel Title_1 = new JLabel("Please select following options to proceed");
        Title_1.setForeground(Color.WHITE);
        Title_1.setFont(new Font("Rockwell", Font.BOLD, 15));
        Title_1.setBounds(68, 49, 317, 38);
        panel_1.add(Title_1);

        labelNotif = new JLabel("");
        labelNotif.setIcon(new ImageIcon(PepPage.class.getResource("/Image/icons8_notification_35px_9.png")));
        labelNotif.setForeground(Color.WHITE);
        labelNotif.setBounds(362, 187, 41, 38);
        labelNotif.setFont(new Font("Rockwell", Font.BOLD, 15));
        contentPane.add(labelNotif);
        //labelNotif.setVisible(false);

        labelNotif1 = new JLabel("");
        labelNotif1.setForeground(Color.WHITE);
        labelNotif1.setFont(new Font("Rockwell", Font.BOLD, 15));
        labelNotif1.setBounds(93, 248, 346, 22);
        contentPane.add(labelNotif1);
        //labelNotif1.setVisible(false);
        //labelNotif1.setText("hello");

        //setVisible(true);
    }
}
