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
import javax.swing.table.DefaultTableModel;
import static vsystem.ComF2Page.pepTable;

public class ComMenuPage extends JFrame implements ActionListener {

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

        } else if (e.getSource() == ComOutButton) {
            //SET TO NULL ==> THE USERNAME
            VSystem.login = null;
            setVisible(false);
            VSystem.one.setVisible(true);

        } else if (e.getSource() == ComViewButton) {
            //TO COMMITTEE PROFILE PAGE... MUST BRING THE USERNAME
            ComViewPage.ComUserField.setText(VSystem.login.getComUser());
            ComViewPage.ComName1Field.setText(VSystem.login.getComName1());
            ComViewPage.ComName2Field.setText(VSystem.login.getComName2());
            ComViewPage.ComEmailField.setText(VSystem.login.getComMail());
            ComViewPage.ComPhoneField.setText(VSystem.login.getComPhone());
            setVisible(false);
            VSystem.five.setVisible(true);

        } else if (e.getSource() == ComF1Button) {
            //TO COM F1 PAGE
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
            VSystem.six.setVisible(true);
            setVisible(false);

        } else if (e.getSource() == ComF2Button) {
            DefaultTableModel tm2 = (DefaultTableModel) ComF2Page.pepTable.getModel();
            tm2.setRowCount(0);
            for (int i = 0; i < DataIO.allPep.size(); i++) {
                String p1 = DataIO.allPep.get(i).getPType();
                String p2 = DataIO.allPep.get(i).getPUser();
                String p3 = DataIO.allPep.get(i).getPName1();
                String p4 = DataIO.allPep.get(i).getPName2();
                String p5 = DataIO.allPep.get(i).getPGen();
                String p6 = DataIO.allPep.get(i).getPMail();
                String p7 = DataIO.allPep.get(i).getPPhone();
                String p8 = DataIO.allPep.get(i).getPDate();
                String p9 = DataIO.allPep.get(i).getPMonth();
                String p10 = DataIO.allPep.get(i).getPYear();
                String p11 = DataIO.allPep.get(i).getPAdd();
                String p12 = DataIO.allPep.get(i).getPPass();
                String p13 = DataIO.allPep.get(i).getPVac();
                String comArr[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13};
                tm2.addRow(comArr);
            }

            setVisible(false);
            VSystem.seven.setVisible(true);

        } else if (e.getSource() == ComF3Button) {
            //TO COM F3 PAGE
            setVisible(false);
            VSystem.eight.setVisible(true);

        } else if (e.getSource() == ComF4Button) {
            //TO COM F4 PAGE
            ComF4Page.CentreCombobox.setModel(VSystem.dm1);
            DefaultTableModel tm4 = (DefaultTableModel) ComF4Page.vacTable.getModel();
            tm4.setRowCount(0);
            for (int i = 0; i < DataIO.allVac.size(); i++) {
                String va1 = DataIO.allVac.get(i).getvCode();
                String va2 = DataIO.allVac.get(i).getvName();
                String va3 = String.valueOf(DataIO.allVac.get(i).getcen1Qty());
                String va4 = String.valueOf(DataIO.allVac.get(i).getcen2Qty());
                String va5 = String.valueOf(DataIO.allVac.get(i).getcen3Qty());
                String va6 = String.valueOf(DataIO.allVac.get(i).getcen4Qty());
                String va7 = String.valueOf(DataIO.allVac.get(i).getcen5Qty());
                String vax[] = {va1, va2, va3, va4, va5, va6, va7};
                tm4.addRow(vax);

            }
            setVisible(false);
            VSystem.twelve.setVisible(true);

        } else if (e.getSource() == ComF5Button) {
            //TO COM F5 PAGE
            ComF5Page.ReportCombobox.setModel(VSystem.rp1);
            setVisible(false);
            Report.AllPepRep();
            VSystem.fourteen.setVisible(true);

        }

    }

    private JPanel contentPane;
    private JButton ExitButton, MinButton, ComViewButton, ComOutButton, ComF1Button, ComF2Button, ComF3Button, ComF4Button, ComF5Button;
    private int mouseX, mouseY;

    public ComMenuPage() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(750, 225, 447, 576);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 447, 22);
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
        panel_1.setBounds(0, 21, 447, 58);
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

        ComF1Button = new JButton("Manage Committee Account");
        ComF1Button.setForeground(Color.WHITE);
        ComF1Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComF1Button.setBorder(null);
        ComF1Button.setBackground(Color.GRAY);
        ComF1Button.setBounds(93, 165, 267, 47);
        contentPane.add(ComF1Button);
        ComF1Button.addActionListener(this);

        ComF2Button = new JButton("Manage People Account");
        ComF2Button.setForeground(Color.WHITE);
        ComF2Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComF2Button.setBorder(null);
        ComF2Button.setBackground(Color.GRAY);
        ComF2Button.setBounds(93, 245, 267, 47);
        contentPane.add(ComF2Button);
        ComF2Button.addActionListener(this);

        ComF3Button = new JButton("Appoinment Management");
        ComF3Button.setForeground(Color.WHITE);
        ComF3Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComF3Button.setBorder(null);
        ComF3Button.setBackground(Color.GRAY);
        ComF3Button.setBounds(93, 326, 267, 47);
        contentPane.add(ComF3Button);
        ComF3Button.addActionListener(this);

        ComF5Button = new JButton("Statistical Report");
        ComF5Button.setForeground(Color.WHITE);
        ComF5Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComF5Button.setBorder(null);
        ComF5Button.setBackground(Color.GRAY);
        ComF5Button.setBounds(93, 495, 267, 47);
        contentPane.add(ComF5Button);
        ComF5Button.addActionListener(this);

        ComViewButton = new JButton("View Profile");
        ComViewButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_user_50px.png")));
        ComViewButton.setForeground(Color.WHITE);
        ComViewButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComViewButton.setBorder(null);
        ComViewButton.setBackground(Color.GRAY);
        ComViewButton.setBounds(10, 90, 164, 47);
        contentPane.add(ComViewButton);
        ComViewButton.addActionListener(this);

        ComOutButton = new JButton("Log Out");
        ComOutButton.setIcon(new ImageIcon(ComMenuPage.class.getResource("/Image/icons8_logout_rounded_up_40px.png")));
        ComOutButton.setForeground(Color.WHITE);
        ComOutButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComOutButton.setBorder(null);
        ComOutButton.setBackground(new Color(178, 34, 34));
        ComOutButton.setBounds(273, 90, 164, 47);
        contentPane.add(ComOutButton);
        ComOutButton.addActionListener(this);

        ComF4Button = new JButton("Vaccine Management");
        ComF4Button.setForeground(Color.WHITE);
        ComF4Button.setFont(new Font("Rockwell", Font.BOLD, 16));
        ComF4Button.setBorder(null);
        ComF4Button.setBackground(Color.GRAY);
        ComF4Button.setBounds(93, 409, 267, 47);
        contentPane.add(ComF4Button);
        ComF4Button.addActionListener(this);

        JLabel Title = new JLabel("Committee Menu");
        Title.setForeground(Color.WHITE);
        Title.setFont(new Font("Rockwell", Font.BOLD, 24));
        Title.setBounds(125, 8, 216, 47);
        panel_1.add(Title);

        //setVisible(true);
    }
}
