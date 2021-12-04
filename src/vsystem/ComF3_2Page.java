package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ComF3_2Page extends JFrame implements ActionListener {

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
            AppIdField.setText("");
            AppDateField.setText("");
            AppUserField.setText("");
            AppMonthField.setText("");
            AppYearField.setText("");
            CentreCombobox.setSelectedIndex(0);
            setVisible(false);
            VSystem.eight.setVisible(true);

        } else if (e.getSource() == RejectAppButton) {
            //REJECT THE REQ
            Appointment found = DataIO.checking5(AppIdField.getText());
            if (AppIdField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again\nMust Select Appointment !!!");
            } else if (found != null) {
                found.setaStat(AppStat.Rejected);
                JOptionPane.showMessageDialog(this, "Appointment Rejected!");
                String n1 = found.getaUser();
                People found2 = DataIO.checking1(n1);
                if (found2 != null) {
                    found2.setPNot("on");
                    found2.setPRes("Your appointment has been rejected!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error! Notification not sent!");
                }
                DataIO.write();
                DefaultTableModel model = (DefaultTableModel) Ftable.getModel();
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

                DefaultTableModel model1 = (DefaultTableModel) Stable.getModel();
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
                AppIdField.setText("");
                AppDateField.setText("");
                AppUserField.setText("");
                AppMonthField.setText("");
                AppYearField.setText("");
                CentreCombobox.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "Appointment ID not found!");
            }
        } else if (e.getSource() == SendAppDateButton) {
            //ACCEPT & SEND DATE 
            // need more validation
            Appointment found = DataIO.checking5(AppIdField.getText());
            String pdate1 = AppDateField.getText() + "/" + AppMonthField.getText() + "/" + AppYearField.getText();
            DateChecker x = new DateChecker();
            boolean x1 = x.CheckDate(pdate1);
            boolean x2 = x.CheckDate2(pdate1);
            if (AppIdField.getText().equals("") || AppDateField.getText().equals("") || AppMonthField.getText().equals("") || AppYearField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again\nMust Select Appointment and Fill the Appointment Date !!!");
            } else if (x2 == false || x1 == false) {
                JOptionPane.showMessageDialog(this, "Invalid Date :/");
            } else if (found == null) {
                JOptionPane.showMessageDialog(this, "Appointment ID not found!");
            } else {
                found.setaLoc(CentreCombobox.getSelectedItem().toString());
                found.setaDate(AppDateField.getText());
                found.setaMonth(AppMonthField.getText());
                found.setaYear(AppYearField.getText());
                found.setaStat(AppStat.Accepted);
                JOptionPane.showMessageDialog(this, "Appointment Accepted!");
                String n1 = found.getaUser();
                People found2 = DataIO.checking1(n1);
                if (found2 != null) {
                    found2.setPNot("on");
                    found2.setPRes("Your appointment has been Accepted!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error! Notification not sent!");
                }
                DataIO.write();
                DefaultTableModel model = (DefaultTableModel) Ftable.getModel();
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

                DefaultTableModel model1 = (DefaultTableModel) Stable.getModel();
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
                AppIdField.setText("");
                AppDateField.setText("");
                AppUserField.setText("");
                AppMonthField.setText("");
                AppYearField.setText("");
                CentreCombobox.setSelectedIndex(0);
            }

        } else if (e.getSource() == DisplayButton) {
            //DISPLAY DATA TO TEXTAREA
            DefaultTableModel model = (DefaultTableModel) Ftable.getModel();
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

            DefaultTableModel model1 = (DefaultTableModel) Stable.getModel();
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
        }
    }

    private JPanel contentPane;
    private JTextField AppDateField, AppUserField, AppMonthField, AppYearField, AppIdField;
    private JTextArea ViewReqArea, VacDose1Area;
    private JButton BackButton, ExitButton, MinButton, RejectAppButton, SendAppDateButton, DisplayButton;
    public static JComboBox CentreCombobox;
    public static JTable Ftable, Stable;
    private int mouseX, mouseY;

    public ComF3_2Page() {

        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 885, 750);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 885, 22);
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

        JPanel panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBackground(Color.GRAY);
        panel_2.setBounds(432, 21, 20, 389);
        contentPane.add(panel_2);

        JPanel panel_2_1 = new JPanel();
        panel_2_1.setLayout(null);
        panel_2_1.setBackground(new Color(46, 139, 87));
        panel_2_1.setBounds(0, 410, 885, 22);
        contentPane.add(panel_2_1);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(46, 139, 87));
        panel_1.setBounds(0, 21, 434, 58);
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
        ExitButton.setBounds(864, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(842, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        RejectAppButton = new JButton("Reject");
        RejectAppButton.setForeground(Color.WHITE);
        RejectAppButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        RejectAppButton.setBorder(null);
        RejectAppButton.setBackground(Color.GRAY);
        RejectAppButton.setBounds(37, 506, 134, 32);
        contentPane.add(RejectAppButton);
        RejectAppButton.addActionListener(this);

        DisplayButton = new JButton("Refresh");
        DisplayButton.setIcon(new ImageIcon(ComF3_2Page.class.getResource("/Image/icons8_refresh_25px.png")));
        DisplayButton.setBounds(757, 443, 117, 32);
        DisplayButton.setForeground(Color.WHITE);
        DisplayButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        DisplayButton.setBorder(null);
        DisplayButton.setBackground(Color.GRAY);
        contentPane.add(DisplayButton);
        DisplayButton.addActionListener(this);

        CentreCombobox = new JComboBox();
        CentreCombobox.setModel(new DefaultComboBoxModel());
        CentreCombobox.setForeground(Color.WHITE);
        CentreCombobox.setFont(new Font("Rockwell", Font.BOLD, 14));
        CentreCombobox.setBackground(Color.GRAY);
        CentreCombobox.setBounds(203, 572, 249, 22);
        contentPane.add(CentreCombobox);

        SendAppDateButton = new JButton("Send");
        SendAppDateButton.setForeground(Color.WHITE);
        SendAppDateButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        SendAppDateButton.setBorder(null);
        SendAppDateButton.setBackground(Color.GRAY);
        SendAppDateButton.setBounds(37, 684, 134, 32);
        contentPane.add(SendAppDateButton);
        SendAppDateButton.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 90, 412, 309);
        scrollPane.setBackground(Color.DARK_GRAY);
        contentPane.add(scrollPane);

        Ftable = new JTable();
        Ftable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AppIdField.setText(Ftable.getValueAt(Ftable.getSelectedRow(), 0).toString());
                AppUserField.setText(Ftable.getValueAt(Ftable.getSelectedRow(), 1).toString());
            }
        });
        Ftable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Ftable.setFont(new Font("Rockwell", Font.PLAIN, 13));
        Ftable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "IC/Passport No.", "Name"
                }) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        Ftable.getColumnModel().getColumn(0).setPreferredWidth(59);
        Ftable.getColumnModel().getColumn(1).setPreferredWidth(150);
        Ftable.getColumnModel().getColumn(1).setMinWidth(150);
        Ftable.getColumnModel().getColumn(2).setPreferredWidth(200);
        Ftable.getColumnModel().getColumn(2).setMinWidth(200);
        Ftable.getTableHeader().setReorderingAllowed(false);
        scrollPane.setViewportView(Ftable);

        JScrollPane scrollPane1 = new JScrollPane();
        scrollPane1.setBounds(460, 90, 414, 309);
        contentPane.add(scrollPane1);

        Stable = new JTable();
        Stable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AppIdField.setText(Stable.getValueAt(Stable.getSelectedRow(), 0).toString());
                AppUserField.setText(Stable.getValueAt(Stable.getSelectedRow(), 1).toString());
            }
        });
        Stable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Stable.setFont(new Font("Rockwell", Font.PLAIN, 13));
        Stable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "IC/Passport No.", "Name"
                }) {
            boolean[] columnEditables = new boolean[]{
                false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        Stable.getColumnModel().getColumn(0).setPreferredWidth(59);
        Stable.getColumnModel().getColumn(1).setPreferredWidth(150);
        Stable.getColumnModel().getColumn(1).setMinWidth(150);
        Stable.getColumnModel().getColumn(2).setPreferredWidth(200);
        Stable.getColumnModel().getColumn(2).setMinWidth(200);
        Stable.getTableHeader().setReorderingAllowed(false);
        scrollPane1.setViewportView(Stable);

        AppDateField = new JTextField();
        AppDateField.setForeground(Color.WHITE);
        AppDateField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AppDateField.setColumns(10);
        AppDateField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AppDateField.setBackground(Color.DARK_GRAY);
        AppDateField.setBounds(203, 624, 76, 20);
        contentPane.add(AppDateField);
        AppDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = AppDateField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    AppDateField.setEditable(true);
                } else {
                    AppDateField.setEditable(false);
                }
            }
        });

        AppMonthField = new JTextField();
        AppMonthField.setForeground(Color.WHITE);
        AppMonthField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AppMonthField.setColumns(10);
        AppMonthField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AppMonthField.setBackground(Color.DARK_GRAY);
        AppMonthField.setBounds(289, 624, 76, 20);
        contentPane.add(AppMonthField);
        AppMonthField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = AppMonthField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    AppMonthField.setEditable(true);
                } else {
                    AppMonthField.setEditable(false);
                }
            }
        });

        AppYearField = new JTextField();
        AppYearField.setForeground(Color.WHITE);
        AppYearField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AppYearField.setColumns(10);
        AppYearField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AppYearField.setBackground(Color.DARK_GRAY);
        AppYearField.setBounds(375, 624, 76, 20);
        contentPane.add(AppYearField);
        AppYearField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = AppYearField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    AppYearField.setEditable(true);
                } else {
                    AppYearField.setEditable(false);
                }
            }
        });

        AppIdField = new JTextField();
        AppIdField.setEditable(false);
        AppIdField.setForeground(Color.WHITE);
        AppIdField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AppIdField.setColumns(10);
        AppIdField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AppIdField.setBackground(Color.DARK_GRAY);
        AppIdField.setBounds(203, 443, 125, 20);
        contentPane.add(AppIdField);

        AppUserField = new JTextField();
        AppUserField.setForeground(Color.WHITE);
        AppUserField.setEditable(false);
        AppUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        AppUserField.setColumns(10);
        AppUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        AppUserField.setBackground(Color.DARK_GRAY);
        AppUserField.setBounds(203, 474, 249, 20);
        contentPane.add(AppUserField);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setLayout(null);
        panel_1_1.setBackground(new Color(46, 139, 87));
        panel_1_1.setBounds(450, 21, 435, 58);
        contentPane.add(panel_1_1);

        JLabel lbTitle_1 = new JLabel("2nd Dose Request List");
        lbTitle_1.setForeground(Color.WHITE);
        lbTitle_1.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle_1.setBounds(71, 8, 295, 47);
        panel_1_1.add(lbTitle_1);

        JLabel lbdd = new JLabel("DD");
        lbdd.setForeground(Color.WHITE);
        lbdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbdd.setBounds(203, 648, 58, 21);
        contentPane.add(lbdd);

        JLabel lbmm = new JLabel("MM");
        lbmm.setForeground(Color.WHITE);
        lbmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbmm.setBounds(289, 648, 58, 21);
        contentPane.add(lbmm);

        JLabel lbyyyy = new JLabel("YYYY");
        lbyyyy.setForeground(Color.WHITE);
        lbyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbyyyy.setBounds(375, 648, 58, 21);
        contentPane.add(lbyyyy);

        JLabel lblId = new JLabel("ID");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblId.setBounds(37, 443, 101, 21);
        contentPane.add(lblId);

        JLabel lbTitle = new JLabel("1st Dose Request List");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(100, 8, 295, 47);
        panel_1.add(lbTitle);

        JLabel lbAppDate = new JLabel("Date of Appoinment");
        lbAppDate.setForeground(Color.WHITE);
        lbAppDate.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbAppDate.setBounds(37, 624, 150, 21);
        contentPane.add(lbAppDate);

        JLabel lblSelectCentre = new JLabel("Select Centre");
        lblSelectCentre.setForeground(Color.WHITE);
        lblSelectCentre.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblSelectCentre.setBounds(37, 573, 134, 21);
        contentPane.add(lblSelectCentre);

        JLabel lbUsername = new JLabel("Username");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUsername.setBounds(37, 474, 101, 21);
        contentPane.add(lbUsername);

//        setVisible(true);
    }

}
