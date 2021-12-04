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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComF3_3Page extends JFrame implements ActionListener {

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
            IDField.setText("");
            SearchAppDateField.setText("");
            ddAppField.setText("");
            mmAppField.setText("");
            yyyyAppField.setText("");
            CentreCombobox.setSelectedIndex(0);
            setVisible(false);
            VSystem.eight.setVisible(true);

        } else if (e.getSource() == SearchAppDateButton) {
            //SEARCH APPOINTMENT DATE BASED ON USERNAAME
            String s5 = SearchAppDateField.getText();
            if (s5.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill the Information :/!!!");
            } else {
                DefaultTableModel tm3 = (DefaultTableModel) appTable.getModel();
                tm3.setRowCount(0);
                for (int i = 0; i < DataIO.allApp.size(); i++) {
                    if (s5.equals(DataIO.allApp.get(i).getaUser()) || DataIO.allApp.get(i).getaUser().contains(s5) || DataIO.allApp.get(i).getaName().contains(s5)
                            || DataIO.allApp.get(i).getaDos().contains(s5) || DataIO.allApp.get(i).getaStat().toString().contains(s5) || DataIO.allApp.get(i).getaId().contains(s5)) {
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

                }
            }
        } else if (e.getSource() == UpdateAppDateButton) {
            //UPATE APPOINTMENT DATE
            String a1 = IDField.getText();
            String a2 = ddAppField.getText();
            String a3 = mmAppField.getText();
            String a4 = yyyyAppField.getText();
            String a5 = CentreCombobox.getSelectedItem().toString();
            Appointment found = DataIO.checking5(a1);
            String pdate1 = a2 + "/" + a3 + "/" + a4;
            DateChecker x = new DateChecker();
            boolean x1 = x.CheckDate(pdate1);
            boolean x2 = x.CheckDate2(pdate1);
            if (a1.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Select Appointment ID and Fill All Information!!!");
            } else if (found.getaStat() == AppStat.Pending) {
                JOptionPane.showMessageDialog(this, "Pending appointments needs to be managed in Manage Appointment Date ");
            } else if (found.getaStat() == AppStat.Rejected) {
                JOptionPane.showMessageDialog(this, "Rejected appointments cannot be changed ");
            } else if (found.getaStat() == AppStat.Completed) {
                JOptionPane.showMessageDialog(this, "Completed appointments cannot be changed ");
            } else if (a2.equals("") || a3.equals("") || a4.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill All Information :/ ");
            } else if (x2 == false || x1 == false) {
                JOptionPane.showMessageDialog(this, "Invalid Date :/");
            } else if (found == null) {
                JOptionPane.showMessageDialog(this, "Appointment ID not found!");
            } else {
                found.setaDate(a2);
                found.setaMonth(a3);
                found.setaYear(a4);
                found.setaLoc(a5);
                found.setaStat(AppStat.Accepted);
                JOptionPane.showMessageDialog(this, "Appointment Updated!");
                String n1 = found.getaUser();
                People found2 = DataIO.checking1(n1);
                if (found2 != null) {
                    found2.setPNot("on");
                    found2.setPRes("Your appointment has been modified!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error! Notification not sent!");
                }
                DataIO.write();

                DefaultTableModel tm3 = (DefaultTableModel) appTable.getModel();
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
                IDField.setText("");
                ddAppField.setText("");
                mmAppField.setText("");
                yyyyAppField.setText("");
                SearchAppDateField.setText("");
                CentreCombobox.setSelectedIndex(0);
            }

        } else if (e.getSource() == DeleteAppDateButton) {
            //DELETE can detele accepted, confirmed, rejected
            String a1 = IDField.getText();
            Appointment found = DataIO.checking5(a1);
            if (a1.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Select Appoinment ID First !!!");
            } else if (found == null) {
                JOptionPane.showMessageDialog(this, "Appointment ID not found!");
            } else if (found.getaStat() == AppStat.Completed || found.getaStat() == AppStat.Pending) {
                JOptionPane.showMessageDialog(this, "Completed and pending appointments cannot be deleted!");
            } else {
                int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this appointment?", "Delete Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (opt == JOptionPane.YES_OPTION) {
                    ArrayList<Appointment> temp3 = new ArrayList<Appointment>();
                    for (Appointment app1 : DataIO.allApp) {
                        if (!app1.getaId().equals(found.getaId())) {
                            String d0 = app1.getaId();
                            String d1 = app1.getaUser();
                            String d2 = app1.getaName();
                            String d3 = app1.getaDate();
                            String d4 = app1.getaMonth();
                            String d5 = app1.getaYear();
                            String d6 = app1.getaLoc();
                            String d7 = app1.getaDos();
                            AppStat d8 = app1.getaStat();
                            Appointment dx = new Appointment(d0, d1, d2, d3, d4, d5, d6, d7, d8);
                            temp3.add(dx);
                        }
                    }
                    DataIO.allApp = temp3;
                    DataIO.write();

                    DefaultTableModel tm3 = (DefaultTableModel) appTable.getModel();
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

                    IDField.setText("");
                    ddAppField.setText("");
                    mmAppField.setText("");
                    yyyyAppField.setText("");
                    CentreCombobox.setSelectedIndex(0);
                    SearchAppDateField.setText("");
                    JOptionPane.showMessageDialog(this, "Appointment Deleted!");
                    String n1 = found.getaUser();
                    People found2 = DataIO.checking1(n1);
                    if (found2 != null) {
                        if (found.getaStat() != AppStat.Rejected) {
                            found2.setPNot("on");
                            found2.setPRes("Your appointment has been deleted!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Error! Notification not sent!");
                    }
                    DataIO.write();
                }
            }

        } else if (e.getSource() == refButton) {
            DefaultTableModel tm3 = (DefaultTableModel) appTable.getModel();
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

        }
    }

    private JPanel contentPane;
    private JTextField SearchAppDateField, ddAppField, mmAppField, yyyyAppField, IDField;
    private JButton BackButton, ExitButton, MinButton, SearchAppDateButton, UpdateAppDateButton, DeleteAppDateButton, refButton;
    public static JComboBox CentreCombobox;
    public static JTable appTable;
    private int mouseX, mouseY;

    public ComF3_3Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 800, 22);
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
        panel_1.setBounds(0, 22, 800, 58);
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
        MinButton.setBounds(753, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(778, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        refButton = new JButton("Refresh");
        refButton.setIcon(new ImageIcon(ComF3_3Page.class.getResource("/Image/icons8_refresh_25px.png")));
        refButton.setForeground(Color.WHITE);
        refButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        refButton.setBorder(null);
        refButton.setBackground(Color.GRAY);
        refButton.setBounds(693, 437, 97, 28);
        contentPane.add(refButton);
        refButton.addActionListener(this);

        JScrollPane scrollTable = new JScrollPane();
        scrollTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        scrollTable.setBackground(Color.DARK_GRAY);
        scrollTable.setBounds(10, 138, 780, 288);
        contentPane.add(scrollTable);

        appTable = new JTable();
        appTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                IDField.setText(appTable.getValueAt(appTable.getSelectedRow(), 0).toString());
                ddAppField.setText(appTable.getValueAt(appTable.getSelectedRow(), 3).toString());
                mmAppField.setText(appTable.getValueAt(appTable.getSelectedRow(), 4).toString());
                yyyyAppField.setText(appTable.getValueAt(appTable.getSelectedRow(), 5).toString());
                String cens = (appTable.getValueAt(appTable.getSelectedRow(), 6).toString());
                if (cens.equals("Centre 2")) {
                    CentreCombobox.setSelectedIndex(1);
                } else if (cens.equals("Centre 3")) {
                    CentreCombobox.setSelectedIndex(2);
                } else if (cens.equals("Centre 4")) {
                    CentreCombobox.setSelectedIndex(3);
                } else if (cens.equals("Centre 5")) {
                    CentreCombobox.setSelectedIndex(4);
                } else {
                    CentreCombobox.setSelectedIndex(0);
                }
            }
        });
        appTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Username", "Name", "Date", "Month", "Year", "Location", "Dose", "Status"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        appTable.setSelectionForeground(Color.WHITE);
        appTable.setSelectionBackground(new Color(0, 128, 0));
        appTable.setGridColor(Color.LIGHT_GRAY);
        appTable.setForeground(Color.WHITE);
        appTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        appTable.setBackground(Color.DARK_GRAY);
        appTable.getTableHeader().setReorderingAllowed(false);
        scrollTable.setViewportView(appTable);

        CentreCombobox = new JComboBox();
        CentreCombobox.setModel(new DefaultComboBoxModel());
        CentreCombobox.setForeground(Color.WHITE);
        CentreCombobox.setFont(new Font("Rockwell", Font.BOLD, 14));
        CentreCombobox.setBackground(Color.GRAY);
        CentreCombobox.setBounds(200, 551, 249, 22);
        contentPane.add(CentreCombobox);

        SearchAppDateButton = new JButton("Search");
        SearchAppDateButton.setForeground(Color.WHITE);
        SearchAppDateButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchAppDateButton.setBorder(null);
        SearchAppDateButton.setBackground(Color.GRAY);
        SearchAppDateButton.setBounds(676, 95, 114, 22);
        contentPane.add(SearchAppDateButton);
        SearchAppDateButton.addActionListener(this);

        DeleteAppDateButton = new JButton("Delete");
        DeleteAppDateButton.setForeground(Color.WHITE);
        DeleteAppDateButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DeleteAppDateButton.setBorder(null);
        DeleteAppDateButton.setBackground(Color.GRAY);
        DeleteAppDateButton.setBounds(501, 513, 121, 31);
        contentPane.add(DeleteAppDateButton);
        DeleteAppDateButton.addActionListener(this);

        UpdateAppDateButton = new JButton("Save & Update");
        UpdateAppDateButton.setForeground(Color.WHITE);
        UpdateAppDateButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        UpdateAppDateButton.setBorder(null);
        UpdateAppDateButton.setBackground(Color.GRAY);
        UpdateAppDateButton.setBounds(501, 447, 121, 31);
        contentPane.add(UpdateAppDateButton);
        UpdateAppDateButton.addActionListener(this);

        SearchAppDateField = new JTextField();
        SearchAppDateField.setForeground(Color.WHITE);
        SearchAppDateField.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchAppDateField.setColumns(10);
        SearchAppDateField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        SearchAppDateField.setBackground(Color.DARK_GRAY);
        SearchAppDateField.setBounds(10, 95, 656, 22);
        contentPane.add(SearchAppDateField);

        IDField = new JTextField();
        IDField.setEditable(false);
        IDField.setForeground(Color.WHITE);
        IDField.setFont(new Font("Rockwell", Font.BOLD, 14));
        IDField.setColumns(10);
        IDField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        IDField.setBackground(Color.DARK_GRAY);
        IDField.setBounds(200, 453, 248, 20);
        contentPane.add(IDField);

        ddAppField = new JTextField();
        ddAppField.setForeground(Color.WHITE);
        ddAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ddAppField.setColumns(10);
        ddAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ddAppField.setBackground(Color.DARK_GRAY);
        ddAppField.setBounds(200, 487, 76, 20);
        contentPane.add(ddAppField);
        ddAppField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = ddAppField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    ddAppField.setEditable(true);
                } else {
                    ddAppField.setEditable(false);
                }
            }
        });

        mmAppField = new JTextField();
        mmAppField.setForeground(Color.WHITE);
        mmAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        mmAppField.setColumns(10);
        mmAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        mmAppField.setBackground(Color.DARK_GRAY);
        mmAppField.setBounds(286, 487, 76, 20);
        contentPane.add(mmAppField);
        mmAppField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = mmAppField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    mmAppField.setEditable(true);
                } else {
                    mmAppField.setEditable(false);
                }
            }
        });

        yyyyAppField = new JTextField();
        yyyyAppField.setForeground(Color.WHITE);
        yyyyAppField.setFont(new Font("Rockwell", Font.BOLD, 14));
        yyyyAppField.setColumns(10);
        yyyyAppField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        yyyyAppField.setBackground(Color.DARK_GRAY);
        yyyyAppField.setBounds(372, 487, 76, 20);
        contentPane.add(yyyyAppField);
        yyyyAppField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String dmy = yyyyAppField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    yyyyAppField.setEditable(true);
                } else {
                    yyyyAppField.setEditable(false);
                }
            }
        });
        JLabel lbTitle = new JLabel("Search & Modify Appointment");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(191, 8, 418, 47);
        panel_1.add(lbTitle);

        JLabel lbLocation = new JLabel("Location");
        lbLocation.setForeground(Color.WHITE);
        lbLocation.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbLocation.setBounds(25, 552, 121, 21);
        contentPane.add(lbLocation);

        JLabel lbAppDate = new JLabel("Date of Appointment");
        lbAppDate.setForeground(Color.WHITE);
        lbAppDate.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbAppDate.setBounds(25, 487, 155, 21);
        contentPane.add(lbAppDate);

        JLabel lbdd = new JLabel("DD");
        lbdd.setForeground(Color.WHITE);
        lbdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbdd.setBounds(200, 509, 58, 21);
        contentPane.add(lbdd);

        JLabel lbmm = new JLabel("MM");
        lbmm.setForeground(Color.WHITE);
        lbmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbmm.setBounds(286, 509, 58, 21);
        contentPane.add(lbmm);

        JLabel lbyyyy = new JLabel("YYYY");
        lbyyyy.setForeground(Color.WHITE);
        lbyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbyyyy.setBounds(372, 509, 58, 21);
        contentPane.add(lbyyyy);

        JLabel lbID = new JLabel("ID");
        lbID.setForeground(Color.WHITE);
        lbID.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbID.setBounds(25, 447, 155, 21);
        contentPane.add(lbID);

//        setVisible(true);
    }

}
