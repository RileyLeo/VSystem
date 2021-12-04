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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vsystem.ComF3_2Page.Ftable;
import static vsystem.ComF3_2Page.Stable;

public class ComF3Page extends JFrame implements ActionListener {

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
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == UpVacStatButton) {
            //COM F3_1 PAGE
            setVisible(false);
            VSystem.nine.setVisible(true);

        } else if (e.getSource() == AddAppButton) {
            //COM F3_2 PAGE
            ComF3_2Page.CentreCombobox.setModel(VSystem.dm2);
            DefaultTableModel model = (DefaultTableModel) ComF3_2Page.Ftable.getModel();
            model.setRowCount(0);
            for (int i = 0; i < DataIO.allApp.size(); i++) {
                if (DataIO.allApp.get(i).getaStat() == AppStat.Pending && DataIO.allApp.get(i).getaDos().equals("Dose 1")) {
                    String aId = DataIO.allApp.get(i).getaId();
                    String aUser = DataIO.allApp.get(i).getaUser();
                    String aName = DataIO.allApp.get(i).getaName();
                    String FDosArray[] = {aId, aUser, aName};
                    model.addRow(FDosArray);
                }
            }

            DefaultTableModel model1 = (DefaultTableModel) ComF3_2Page.Stable.getModel();
            model1.setRowCount(0);
            for (int i = 0; i < DataIO.allApp.size(); i++) {
                if (DataIO.allApp.get(i).getaStat() == AppStat.Pending && DataIO.allApp.get(i).getaDos().equals("Dose 2")) {
                    String aId = DataIO.allApp.get(i).getaId();
                    String aUser = DataIO.allApp.get(i).getaUser();
                    String aName = DataIO.allApp.get(i).getaName();
                    String SDosArray[] = {aId, aUser, aName};
                    model1.addRow(SDosArray);
                }
            }

            setVisible(false);
            VSystem.ten.setVisible(true);

        } else if (e.getSource() == mVButton) {
            //COM F3_3 PAGE
            ComF3_3Page.CentreCombobox.setModel(VSystem.dm2);
            DefaultTableModel tm3 = (DefaultTableModel) ComF3_3Page.appTable.getModel();
            tm3.setRowCount(0);
            for (int i = 0; i < DataIO.allApp.size(); i++) {
                String ap1 = DataIO.allApp.get(i).getaId();
                String ap2 = DataIO.allApp.get(i).getaUser();
                String ap3 = DataIO.allApp.get(i).getaName();
                String ap4 = DataIO.allApp.get(i).getaDate();
                String ap5 = DataIO.allApp.get(i).getaMonth();
                String ap6 = DataIO.allApp.get(i).getaYear();
                String ap7 = DataIO.allApp.get(i).getaLoc();
                String ap8 = DataIO.allApp.get(i).getaDos();
                String ap9 = DataIO.allApp.get(i).getaStat().toString();
                String apx[] = {ap1, ap2, ap3, ap4, ap5, ap6, ap7, ap8, ap9};
                tm3.addRow(apx);

            }
            setVisible(false);
            VSystem.eleven.setVisible(true);

        }
    }

    private JPanel contentPane;
    private JButton BackButton, ExitButton, MinButton, AddAppButton, UpVacStatButton, mVButton, ViewAppButton;
    private int mouseX, mouseY;

    public ComF3Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(800, 350, 390, 330);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 390, 22);
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
        panel_1.setBounds(0, 21, 390, 58);
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
        ExitButton.setBounds(370, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(347, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        UpVacStatButton = new JButton("Update Vaccination Status");
        UpVacStatButton.setForeground(Color.WHITE);
        UpVacStatButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        UpVacStatButton.setBorder(null);
        UpVacStatButton.setBackground(Color.GRAY);
        UpVacStatButton.setBounds(63, 99, 267, 47);
        contentPane.add(UpVacStatButton);
        UpVacStatButton.addActionListener(this);

        mVButton = new JButton("Manage Appointment");
        mVButton.setForeground(Color.WHITE);
        mVButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        mVButton.setBorder(null);
        mVButton.setBackground(Color.GRAY);
        mVButton.setBounds(63, 247, 267, 47);
        contentPane.add(mVButton);
        mVButton.addActionListener(this);

        AddAppButton = new JButton("Add Appointment Date");
        AddAppButton.setForeground(Color.WHITE);
        AddAppButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        AddAppButton.setBorder(null);
        AddAppButton.setBackground(Color.GRAY);
        AddAppButton.setBounds(63, 171, 267, 47);
        contentPane.add(AddAppButton);
        AddAppButton.addActionListener(this);

        JLabel lbTitle = new JLabel("Appoinment Menu");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(85, 8, 232, 47);
        panel_1.add(lbTitle);

        //setVisible(true);
    }
}
