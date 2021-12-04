package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;

public class ComF3_1Page extends JFrame implements ActionListener {

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
            UVCUserField.setText("");
            UVCVaccField.setText("");
            setVisible(false);
            VSystem.eight.setVisible(true);

        } else if (e.getSource() == UpdateDose1Button) {
            //UPDATE FOR DOSE 1
            String appID = UVCUserField.getText();
            String vacCode = UVCVaccField.getText();
            Vaccine check = DataIO.checking2(vacCode);
            Appointment found = DataIO.checking6(appID);
            Appointment found2 = DataIO.checking7(appID);
            if (UVCUserField.getText().equals("") || UVCVaccField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\n Must Fill All Information !!!");
            } else if (found != null) {
                if (check != null) {
                    String vack = check.getvCode();
                    String loc = found.getaLoc();
                    boolean vq1 = Vaccine.CheckQV(vack, loc);
                    if (vq1 == true) {
                        found.setaStat(AppStat.Completed);
                        String c1 = "Dose 1";
                        String c2 = found.getaLoc();
                        String c3 = found.getaDate();
                        String c4 = found.getaMonth();
                        String c5 = found.getaYear();
                        String c6 = check.getvCode();
                        People c7 = DataIO.checking1(found.getaUser());
                        c7.setPVac("1");
                        Certificate cx = new Certificate(c1, c2, c3, c4, c5, c6, c7);
                        DataIO.allCerti.add(cx);
                        c7.getmyCerti().add(cx);
                        String cx1 = found.getaLoc();
                        if (cx1.equals("Centre 1")) {
                            check.setcen1Qty(check.getcen1Qty() - 1);
                        } else if (cx1.equals("Centre 2")) {
                            check.setcen2Qty(check.getcen2Qty() - 1);
                        } else if (cx1.equals("Centre 3")) {
                            check.setcen3Qty(check.getcen3Qty() - 1);
                        } else if (cx1.equals("Centre 4")) {
                            check.setcen4Qty(check.getcen4Qty() - 1);
                        } else if (cx1.equals("Centre 5")) {
                            check.setcen5Qty(check.getcen5Qty() - 1);
                        }
                        DataIO.write();
                        JOptionPane.showMessageDialog(this, "Update Dose 1");
                    } else {
                        JOptionPane.showMessageDialog(this, "Not Enough Vaccine Quantity");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vaccine code not found!");
                }
            } else if (found2 != null) {
                if (check != null) {
                    String vack = check.getvCode();
                    String loc = found2.getaLoc();
                    boolean vq1 = Vaccine.CheckQV(vack, loc);
                    if (vq1 == true) {
                        found2.setaStat(AppStat.Completed);
                        String c1 = "Dose 2";
                        String c2 = found2.getaLoc();
                        String c3 = found2.getaDate();
                        String c4 = found2.getaMonth();
                        String c5 = found2.getaYear();
                        String c6 = check.getvCode();
                        People c7 = DataIO.checking1(found2.getaUser());
                        c7.setPVac("2");
                        Certificate cy = new Certificate(c1, c2, c3, c4, c5, c6, c7);
                        DataIO.allCerti.add(cy);
                        c7.getmyCerti().add(cy);
                        String cx2 = found2.getaLoc();
                        if (cx2.equals("Centre 1")) {
                            check.setcen1Qty(check.getcen1Qty() - 1);
                        } else if (cx2.equals("Centre 2")) {
                            check.setcen2Qty(check.getcen2Qty() - 1);
                        } else if (cx2.equals("Centre 3")) {
                            check.setcen3Qty(check.getcen3Qty() - 1);
                        } else if (cx2.equals("Centre 4")) {
                            check.setcen4Qty(check.getcen4Qty() - 1);
                        } else if (cx2.equals("Centre 5")) {
                            check.setcen5Qty(check.getcen5Qty() - 1);
                        }
                        DataIO.write();
                        JOptionPane.showMessageDialog(this, "Update Dose 2");
                    } else {
                        JOptionPane.showMessageDialog(this, "Not Enough Vaccine Quantity");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Vaccine code not found!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Appointment not found! Please check if appointment ID is valid!");
            }

        }
    }

    private JPanel contentPane;
    private JTextField UVCUserField, UVCVaccField;
    private JButton BackButton, ExitButton, MinButton, DisplayButton, UpdateDose1Button;
    private int mouseX, mouseY;

    public ComF3_1Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(700, 400, 515, 250);
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

        UpdateDose1Button = new JButton("Update Certificate");
        UpdateDose1Button.setForeground(Color.WHITE);
        UpdateDose1Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        UpdateDose1Button.setBorder(null);
        UpdateDose1Button.setBackground(Color.GRAY);
        UpdateDose1Button.setBounds(175, 190, 160, 32);
        contentPane.add(UpdateDose1Button);
        UpdateDose1Button.addActionListener(this);

        UVCUserField = new JTextField();
        UVCUserField.setForeground(Color.WHITE);
        UVCUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        UVCUserField.setColumns(10);
        UVCUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        UVCUserField.setBackground(Color.DARK_GRAY);
        UVCUserField.setBounds(256, 97, 249, 20);
        contentPane.add(UVCUserField);

        UVCVaccField = new JTextField();
        UVCVaccField.setForeground(Color.WHITE);
        UVCVaccField.setFont(new Font("Rockwell", Font.BOLD, 14));
        UVCVaccField.setColumns(10);
        UVCVaccField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        UVCVaccField.setBackground(Color.DARK_GRAY);
        UVCVaccField.setBounds(256, 145, 249, 20);
        contentPane.add(UVCVaccField);

        JLabel lbUsername = new JLabel("Appointment ID");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUsername.setBounds(10, 97, 223, 21);
        contentPane.add(lbUsername);

        JLabel lblVaccineCode = new JLabel("Vaccine Code");
        lblVaccineCode.setForeground(Color.WHITE);
        lblVaccineCode.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblVaccineCode.setBounds(10, 144, 205, 21);
        contentPane.add(lblVaccineCode);

        JLabel lbTitle = new JLabel("Update Vaccination Status");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(112, 8, 315, 47);
        panel_1.add(lbTitle);

//        setVisible(true);
    }
}
