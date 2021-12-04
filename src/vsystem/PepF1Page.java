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
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PepF1Page extends JFrame implements ActionListener {

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
            DoseField.setText("");
            ddAppField.setText("");
            mmAppField.setText("");
            yyyyAppField.setText("");
            LocField.setText("");
            StatusField.setText("");
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

        } else if (e.getSource() == SubReqButton) {
            //SEND REQ 
            int vx = 10000;
            int vy;
            int idc = 0;
            String a1 = String.valueOf(DataIO.allApp.size() + 10000);
            for (int i = 0; i < DataIO.allApp.size(); i++) {
                for (Appointment ap1 : DataIO.allApp) {
                    String ax = ap1.getaId();
                    vy = Integer.parseInt(ax);
                    if (vy == vx) {
                        idc = 0;
                        break;
                    } else {
                        idc = 1;
                    }
                }
                if (idc == 1) {
                    a1 = String.valueOf(vx);
                    break;
                }
                vx = vx + 1;
            }
            String a2 = VSystem.login1.getPUser();
            String a3 = VSystem.login1.getPName1() + " " + VSystem.login1.getPName2();
            //if else statement for dosage 2 and completed vaccination 
            int c1Size;
            String a7 = "";
            c1Size = VSystem.login1.getmyCerti().size();
            if (c1Size == 0) {
                a7 = "Dose 1";
            } else if (c1Size == 1) {
                a7 = "Dose 2";
            }
            AppStat a8 = AppStat.Pending;
            if (a7.equals("")) {
                JOptionPane.showMessageDialog(this, "You have already finished 2 doses of vaccination!");
            } else {
                Appointment found = DataIO.checking4(a2);
                if (found == null) {
                    Appointment i = new Appointment(a1, a2, a3, "", "", "", "", a7, a8);
                    DataIO.allApp.add(i);
                    DataIO.write();
                    JOptionPane.showMessageDialog(this, "Successfully made an appoinment request!  =)");
                    DoseField.setText(a7);
                    ddAppField.setText("");
                    mmAppField.setText("");
                    yyyyAppField.setText("");
                    LocField.setText("");
                    StatusField.setText(a8.toString());
                } else {
                    JOptionPane.showMessageDialog(this, "You already have an appointment");
                }
            }

        } else if (e.getSource() == ViewReqButton) {
            //DISPLAY
            Appointment found = DataIO.checking4(VSystem.login1.getPUser());
            if (found == null) {
                JOptionPane.showMessageDialog(this, "You do not have an active appointment!");
            } else {
                DoseField.setText(found.getaDos());
                ddAppField.setText(found.getaDate());
                mmAppField.setText(found.getaMonth());
                yyyyAppField.setText(found.getaYear());
                LocField.setText(found.getaLoc());
                StatusField.setText(found.getaStat().toString());
            }

        } else if (e.getSource() == AccDateButton) {
            //CONFIRM REQ
            String a1 = VSystem.login1.getPUser();
            Appointment found = DataIO.checking4(a1);
            if (found == null) {
                JOptionPane.showMessageDialog(this, "You do not have an active appointment!");
            } else if (found.getaStat() == AppStat.Confirmed) {
                JOptionPane.showMessageDialog(this, "The appointment has already been confirmed!");
            } else if (found.getaStat() == AppStat.Pending) {
                JOptionPane.showMessageDialog(this, "The appointment is under review, please be patient");
            } else if (found.getaStat() == AppStat.Accepted) {
                found.setaStat(AppStat.Confirmed);
                DataIO.write();
                String appDate = found.getaDate() + "/" + found.getaMonth() + "/" + found.getaYear();
                StatusField.setText(found.getaStat().toString());
                JOptionPane.showMessageDialog(this, "The appointment has been confirmed! Please be in " + found.getaLoc() + " on " + appDate + "\n Thank you!");
            }

        } else if (e.getSource() == RejectDateButton) {
            //REJECT REQ 
            String a1 = VSystem.login1.getPUser();
            Appointment found = DataIO.checking4(a1);
            if (found == null) {
                JOptionPane.showMessageDialog(this, "You do not have an active appointment!");
            } else if (found.getaStat() == AppStat.Confirmed) {
                JOptionPane.showMessageDialog(this, "You are way to early to reject the appointment >:( ");
            } else if (found.getaStat() == AppStat.Pending) {
                JOptionPane.showMessageDialog(this, "The appointment is under review, please be patient");
            } else if (found.getaStat() == AppStat.Accepted) {
                found.setaStat(AppStat.Rejected);
                DataIO.write();
                StatusField.setText(found.getaStat().toString());
                DoseField.setText("");
                ddAppField.setText("");
                mmAppField.setText("");
                yyyyAppField.setText("");
                LocField.setText("");
                StatusField.setText("");
                JOptionPane.showMessageDialog(this, "Appointment rejected.");
            }

        }

    }

    private JPanel contentPane;
    public static JTextField DoseField, ddAppField, mmAppField, yyyyAppField, LocField, StatusField;
    private JButton BackButton, ExitButton, MinButton, SubReqButton, ViewReqButton, AccDateButton, RejectDateButton;
    private int mouseX, mouseY;

    public PepF1Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(725, 200, 480, 637);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 480, 22);
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
        panel_1.setBounds(0, 22, 480, 58);
        contentPane.add(panel_1);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(46, 139, 87));
        panel_1_1.setBounds(0, 221, 480, 58);
        contentPane.add(panel_1_1);

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
        MinButton.setBounds(435, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(458, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        AccDateButton = new JButton("Confirm Req");
        AccDateButton.setForeground(Color.WHITE);
        AccDateButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        AccDateButton.setBorder(null);
        AccDateButton.setBackground(Color.GRAY);
        AccDateButton.setBounds(55, 585, 121, 23);
        contentPane.add(AccDateButton);
        AccDateButton.addActionListener(this);

        SubReqButton = new JButton("Submit Request");
        SubReqButton.setForeground(Color.WHITE);
        SubReqButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        SubReqButton.setBorder(null);
        SubReqButton.setBackground(Color.GRAY);
        SubReqButton.setBounds(161, 111, 162, 33);
        contentPane.add(SubReqButton);
        SubReqButton.addActionListener(this);

        DoseField = new JTextField();
        DoseField.setEditable(false);
        DoseField.setForeground(Color.WHITE);
        DoseField.setFont(new Font("Rockwell", Font.BOLD, 14));
        DoseField.setColumns(10);
        DoseField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        DoseField.setBackground(Color.DARK_GRAY);
        DoseField.setBounds(193, 292, 246, 22);
        contentPane.add(DoseField);

        RejectDateButton = new JButton("Reject Req");
        RejectDateButton.setForeground(Color.WHITE);
        RejectDateButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        RejectDateButton.setBorder(null);
        RejectDateButton.setBackground(Color.GRAY);
        RejectDateButton.setBounds(314, 584, 121, 23);
        contentPane.add(RejectDateButton);
        RejectDateButton.addActionListener(this);

        ViewReqButton = new JButton("Refresh Status");
        ViewReqButton.setForeground(Color.WHITE);
        ViewReqButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        ViewReqButton.setBorder(null);
        ViewReqButton.setBackground(Color.GRAY);
        ViewReqButton.setBounds(161, 502, 155, 36);
        contentPane.add(ViewReqButton);
        ViewReqButton.addActionListener(this);

        StatusField = new JTextField();
        StatusField.setEditable(false);
        StatusField.setForeground(Color.WHITE);
        StatusField.setFont(new Font("Rockwell", Font.BOLD, 14));
        StatusField.setColumns(10);
        StatusField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        StatusField.setBackground(Color.DARK_GRAY);
        StatusField.setBounds(193, 338, 246, 20);
        contentPane.add(StatusField);

        ddAppField = new JTextField();
        ddAppField.setEditable(false);
        ddAppField.setForeground(Color.WHITE);
        ddAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ddAppField.setColumns(10);
        ddAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ddAppField.setBackground(Color.DARK_GRAY);
        ddAppField.setBounds(191, 429, 76, 20);
        contentPane.add(ddAppField);

        mmAppField = new JTextField();
        mmAppField.setEditable(false);
        mmAppField.setForeground(Color.WHITE);
        mmAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        mmAppField.setColumns(10);
        mmAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        mmAppField.setBackground(Color.DARK_GRAY);
        mmAppField.setBounds(277, 429, 76, 20);
        contentPane.add(mmAppField);

        yyyyAppField = new JTextField();
        yyyyAppField.setEditable(false);
        yyyyAppField.setForeground(Color.WHITE);
        yyyyAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        yyyyAppField.setColumns(10);
        yyyyAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        yyyyAppField.setBackground(Color.DARK_GRAY);
        yyyyAppField.setBounds(363, 429, 76, 20);
        contentPane.add(yyyyAppField);

        LocField = new JTextField();
        LocField.setEditable(false);
        LocField.setForeground(Color.WHITE);
        LocField.setFont(new Font("Rockwell", Font.BOLD, 14));
        LocField.setColumns(10);
        LocField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        LocField.setBackground(Color.DARK_GRAY);
        LocField.setBounds(193, 382, 246, 20);
        contentPane.add(LocField);

        JLabel lblNoteButton = new JLabel("Note : Button to Refresh Current Request Status");
        lblNoteButton.setForeground(Color.WHITE);
        lblNoteButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblNoteButton.setBounds(75, 537, 346, 21);
        contentPane.add(lblNoteButton);

        JLabel lblStatus = new JLabel("Request Status");
        lblStatus.setForeground(Color.WHITE);
        lblStatus.setFont(new Font("Rockwell", Font.BOLD, 24));
        lblStatus.setBounds(150, 8, 191, 47);
        panel_1_1.add(lblStatus);

        JLabel lblStatus_1 = new JLabel("Status");
        lblStatus_1.setForeground(Color.WHITE);
        lblStatus_1.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblStatus_1.setBounds(26, 337, 121, 21);
        contentPane.add(lblStatus_1);

        JLabel lblDose = new JLabel("Dose");
        lblDose.setForeground(Color.WHITE);
        lblDose.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblDose.setBounds(26, 292, 121, 21);
        contentPane.add(lblDose);

        JLabel lbTitle = new JLabel("Appointment Management");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(91, 11, 350, 47);
        panel_1.add(lbTitle);

        JLabel lbLocation = new JLabel("Location");
        lbLocation.setForeground(Color.WHITE);
        lbLocation.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbLocation.setBounds(26, 382, 121, 21);
        contentPane.add(lbLocation);

        JLabel lbAppDate = new JLabel("Date of Appointment");
        lbAppDate.setForeground(Color.WHITE);
        lbAppDate.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbAppDate.setBounds(26, 429, 155, 21);
        contentPane.add(lbAppDate);

        JLabel lbdd = new JLabel("DD");
        lbdd.setForeground(Color.WHITE);
        lbdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbdd.setBounds(191, 460, 58, 21);
        contentPane.add(lbdd);

        JLabel lbmm = new JLabel("MM");
        lbmm.setForeground(Color.WHITE);
        lbmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbmm.setBounds(277, 460, 58, 21);
        contentPane.add(lbmm);

        JLabel lbyyyy = new JLabel("YYYY");
        lbyyyy.setForeground(Color.WHITE);
        lbyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbyyyy.setBounds(363, 460, 58, 21);
        contentPane.add(lbyyyy);

        JLabel lblNoteThis = new JLabel("Note : Button to Submit Vaccination Appoinment Request");
        lblNoteThis.setForeground(Color.WHITE);
        lblNoteThis.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblNoteThis.setBounds(55, 155, 402, 21);
        contentPane.add(lblNoteThis);

        //setVisible(true);
    }
}
