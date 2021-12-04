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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import static vsystem.ComF1Page.comTable;

public class ComF2Page extends JFrame implements ActionListener {

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
            SearchPepField.setText("");
            PepTypeField.setText("");
            PepName1Field.setText("");
            PepName2Field.setText("");
            PepGenField.setText("");
            PepEmailField.setText("");
            PepPhoneField.setText("");
            PepMonthField.setText("");
            PepYearField.setText("");
            PepPassField.setText("");
            PepAddressField.setText("");
            PepDateField.setText("");
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == RegPepButton) {
            setVisible(false);
            VSystem.two.setVisible(true);

        } else if (e.getSource() == SearchPepButton) {
            //Committee s1 = DataIO.checking(SearchComField.getText());
            String s2 = SearchPepField.getText();
            if (s2.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill the Search Field :/ !!!");

            } else {
                DefaultTableModel tm2 = (DefaultTableModel) pepTable.getModel();
                tm2.setRowCount(0);
                for (int i = 0; i < DataIO.allPep.size(); i++) {
                    if (s2.equals(DataIO.allPep.get(i).getPUser()) || DataIO.allPep.get(i).getPUser().contains(s2) || DataIO.allPep.get(i).getPName1().contains(s2)
                            || DataIO.allPep.get(i).getPType().contains(s2) || DataIO.allPep.get(i).getPVac().contains(s2)) {
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
                }

            }

        } else if (e.getSource() == refButton) {
            DefaultTableModel tm2 = (DefaultTableModel) pepTable.getModel();
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

        } else if (e.getSource() == SavePepButton) {
            People s3 = DataIO.checking1(PepUserField.getText());
            if (PepUserField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Must Select People Information :/!!!");
            } else if (s3 != null) {
                String a1 = PepName1Field.getText();
                String a2 = PepName2Field.getText();
                String a3 = PepGenField.getText();
                String a4 = PepEmailField.getText();
                String a5 = PepPhoneField.getText();
                String a6 = PepDateField.getText();
                String a7 = PepMonthField.getText();
                String a8 = PepYearField.getText();
                String a9 = PepAddressField.getText();
                String a10 = PepPassField.getText();
                int a10a = a10.length();
                String pdate1 = a6 + "/" + a7 + "/" + a8;
                DateChecker x = new DateChecker();
                boolean x1 = x.CheckDate(pdate1);
                boolean x2 = x.CheckDate1(pdate1);
                if (a1.equals("") || a2.equals("") || a3.equals("") || a4.equals("") || a5.equals("") || a6.equals("")
                        || a7.equals("") || a8.equals("") || a9.equals("") || a10.equals("")) {
                    JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In All Information !!!");
                } else if (a10a < 8) {
                    JOptionPane.showMessageDialog(this, "Try Again !!!\nMinimum Password Length = 8");
                } else if (!"Male".equals(a3) && !"Female".equals(a3)) {
                    JOptionPane.showMessageDialog(this, "Try Again !!!\nGender = Male or Female !!!");
                } else if (DataIO.checking8(a4) == false) {
                    JOptionPane.showMessageDialog(this, "Please input a legitimate email!", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (x2 == false || x1 == false) {
                    JOptionPane.showMessageDialog(this, "Invalid Date :/");
                } else {
                    PepUserField.setText("");
                    PepTypeField.setText("");
                    PepName1Field.setText("");
                    PepName2Field.setText("");
                    PepGenField.setText("");
                    PepEmailField.setText("");
                    PepPhoneField.setText("");
                    PepMonthField.setText("");
                    PepYearField.setText("");
                    PepPassField.setText("");
                    PepAddressField.setText("");
                    PepDateField.setText("");
                    s3.setPName1(a1);
                    s3.setPName2(a2);
                    s3.setPGen(a3);
                    s3.setPMail(a4);
                    s3.setPPhone(a5);
                    s3.setPDate(a6);
                    s3.setPMonth(a7);
                    s3.setPYear(a8);
                    s3.setPAdd(a9);
                    s3.setPPass(a10);
                    People.PepChange();
                    DataIO.write();
                    DefaultTableModel tm2 = (DefaultTableModel) pepTable.getModel();
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
                    JOptionPane.showMessageDialog(this, "Successfully Updated");
                }
            }

        } else if (e.getSource() == DeletePepButton) {
            People s3 = DataIO.checking1(PepUserField.getText());
            if (PepUserField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Must Select the People Information :/!!!");
            } else if (s3 != null) {
                ArrayList<People> temp2 = new ArrayList<People>();
                ArrayList<Certificate> temp5 = new ArrayList<Certificate>();
                ArrayList<Appointment> temp6 = new ArrayList<Appointment>();
                for (People pep1 : DataIO.allPep) {
                    if (!pep1.getPUser().equals(s3.getPUser())) {
                        String d0 = pep1.getPType();
                        String d1 = pep1.getPUser();
                        String d2 = pep1.getPPass();
                        String d3 = pep1.getPName1();
                        String d4 = pep1.getPName2();
                        String d5 = pep1.getPGen();
                        String d6 = pep1.getPMail();
                        String d7 = pep1.getPPhone();
                        String d8 = pep1.getPDate();
                        String d9 = pep1.getPMonth();
                        String d10 = pep1.getPYear();
                        String d11 = pep1.getPAdd();
                        String d12 = pep1.getPNot();
                        String d13 = pep1.getPRes();
                        String d13x = pep1.getPVac();
                        ArrayList<Certificate> d14 = pep1.getmyCerti();
                        if (d14.size() != 0) {
                            for (Certificate dxx : pep1.getmyCerti()) {
                                String d15 = dxx.getCpDose();
                                String d16 = dxx.getCpLoc();
                                String d17 = dxx.getCpDate();
                                String d18 = dxx.getCpMonth();
                                String d19 = dxx.getCpYear();
                                String d20 = dxx.getCpVac();
                                People d21 = dxx.getOwner();
                                Certificate dxx1 = new Certificate(d15, d16, d17, d18, d19, d20, d21);
                                temp5.add(dxx1);
                            }
                        }
                        People dx = new People(d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d13x);
                        temp2.add(dx);
                    }

                }
                for (Appointment app1 : DataIO.allApp) {
                    if (!app1.getaUser().equals(s3.getPUser())) {
                        String d22 = app1.getaId();
                        String d23 = app1.getaUser();
                        String d24 = app1.getaName();
                        String d25 = app1.getaDate();
                        String d26 = app1.getaMonth();
                        String d27 = app1.getaYear();
                        String d28 = app1.getaLoc();
                        String d29 = app1.getaDos();
                        AppStat d30 = app1.getaStat();
                        Appointment dxx1 = new Appointment(d22, d23, d24, d25, d26, d27, d28, d29, d30);
                        temp6.add(dxx1);
                    }
                }
                DataIO.allPep = temp2;
                DataIO.allApp = temp6;
                DataIO.allCerti = temp5;
                DataIO.write();
                //temp2 = null;
                DefaultTableModel tm2 = (DefaultTableModel) pepTable.getModel();
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
                    String comArr[] = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12};
                    tm2.addRow(comArr);
                }
                PepUserField.setText("");
                PepUserField.setText("");
                PepTypeField.setText("");
                PepName1Field.setText("");
                PepName2Field.setText("");
                PepGenField.setText("");
                PepEmailField.setText("");
                PepPhoneField.setText("");
                PepMonthField.setText("");
                PepYearField.setText("");
                PepPassField.setText("");
                PepAddressField.setText("");
                PepDateField.setText("");
                JOptionPane.showMessageDialog(this, "Deleted :)");

            }
        }
    }

    private JPanel contentPane;
    private JButton BackButton, ExitButton, MinButton, RegPepButton, SearchPepButton, SavePepButton, refButton, DeletePepButton;
    private JTextField SearchPepField, PepTypeField, PepName1Field, PepName2Field, PepGenField, PepEmailField, PepPhoneField, PepMonthField, PepYearField, PepAddressField, PepUserField, PepDateField;
    private JPasswordField PepPassField;
    public static JTable pepTable;
    private int mouseX, mouseY;

    public ComF2Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(475, 175, 1050, 750);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 1050, 22);
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
        panel_1.setBounds(0, 21, 1050, 58);
        contentPane.add(panel_1);

        BackButton = new JButton("");
        BackButton
                .setIcon(new ImageIcon(ComF2Page.class
                        .getResource("/Image/icons8_previous_25px.png")));
        BackButton.setBorder(null);
        BackButton.setBackground(Color.GRAY);
        BackButton.setBounds(2, 0, 20, 20);
        panel.add(BackButton);
        BackButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton
                .setIcon(new ImageIcon(ComF2Page.class
                        .getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(1028, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton
                .setIcon(new ImageIcon(ComF2Page.class
                        .getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(1006, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        JLabel lbTitle = new JLabel("Manage People Accounts");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(369, 8, 299, 47);
        panel_1.add(lbTitle);

        RegPepButton = new JButton("Register ");
        RegPepButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_people_50px.png")));
        RegPepButton.setForeground(Color.WHITE);
        RegPepButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        RegPepButton.setBorder(null);
        RegPepButton.setBackground(Color.GRAY);
        RegPepButton.setBounds(20, 488, 155, 46);
        contentPane.add(RegPepButton);
        RegPepButton.addActionListener(this);

        refButton = new JButton("Refresh");
        refButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_refresh_25px.png")));
        refButton.setForeground(Color.WHITE);
        refButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        refButton.setBorder(null);
        refButton.setBackground(Color.GRAY);
        refButton.setBounds(943, 497, 97, 28);
        contentPane.add(refButton);
        refButton.addActionListener(this);

        SearchPepButton = new JButton("Search");
        SearchPepButton.setForeground(Color.WHITE);
        SearchPepButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchPepButton.setBorder(null);
        SearchPepButton.setBackground(Color.GRAY);
        SearchPepButton.setBounds(919, 90, 121, 23);
        contentPane.add(SearchPepButton);
        SearchPepButton.addActionListener(this);

        SavePepButton = new JButton("Save & Update");
        SavePepButton.setForeground(Color.WHITE);
        SavePepButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SavePepButton.setBorder(null);
        SavePepButton.setBackground(Color.GRAY);
        SavePepButton.setBounds(456, 498, 134, 28);
        contentPane.add(SavePepButton);
        SavePepButton.addActionListener(this);

        DeletePepButton = new JButton("Delete");
        DeletePepButton.setForeground(Color.WHITE);
        DeletePepButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DeletePepButton.setBorder(null);
        DeletePepButton.setBackground(Color.GRAY);
        DeletePepButton.setBounds(641, 498, 134, 28);
        contentPane.add(DeletePepButton);
        DeletePepButton.addActionListener(this);

        JScrollPane scrollTable = new JScrollPane();
        scrollTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        scrollTable.setBackground(Color.DARK_GRAY);
        scrollTable.setBounds(10, 135, 1030, 342);
        contentPane.add(scrollTable);

        pepTable = new JTable();
        pepTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                PepTypeField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 0).toString());
                PepUserField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 1).toString());
                PepName1Field.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 2).toString());
                PepName2Field.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 3).toString());
                PepGenField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 4).toString());
                PepEmailField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 5).toString());
                PepPhoneField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 6).toString());
                PepDateField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 7).toString());
                PepMonthField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 8).toString());
                PepYearField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 9).toString());
                PepAddressField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 10).toString());
                PepPassField.setText(pepTable.getValueAt(pepTable.getSelectedRow(), 11).toString());
            }
        });

        pepTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Type", "Username", "First Name", "Last Name", "Gender", "E-Mail", "Phone Number", "Date", "Month", "Year", "Address", "Password", "Vaccinated"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        pepTable.setSelectionForeground(Color.WHITE);
        pepTable.setSelectionBackground(new Color(0, 128, 0));
        pepTable.setGridColor(Color.LIGHT_GRAY);
        pepTable.setForeground(Color.WHITE);
        pepTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        pepTable.setBackground(Color.DARK_GRAY);
        pepTable.getTableHeader().setReorderingAllowed(false);
        scrollTable.setViewportView(pepTable);

        SearchPepField = new JTextField();
        SearchPepField.setForeground(Color.WHITE);
        SearchPepField.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchPepField.setColumns(10);
        SearchPepField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        SearchPepField.setBackground(Color.DARK_GRAY);
        SearchPepField.setBounds(10, 90, 899, 22);
        contentPane.add(SearchPepField);

        PepPhoneField = new JTextField();
        PepPhoneField.setForeground(Color.WHITE);
        PepPhoneField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepPhoneField.setColumns(10);
        PepPhoneField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepPhoneField.setBackground(Color.DARK_GRAY);
        PepPhoneField.setBounds(682, 591, 246, 20);
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

        PepDateField = new JTextField();
        PepDateField.setForeground(Color.WHITE);
        PepDateField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepDateField.setColumns(10);
        PepDateField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepDateField.setBackground(Color.DARK_GRAY);
        PepDateField.setBounds(682, 623, 76, 20);
        contentPane.add(PepDateField);
        PepDateField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = PepDateField.getText();
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
        PepMonthField.setBounds(768, 623, 76, 20);
        contentPane.add(PepMonthField);
        PepMonthField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = PepMonthField.getText();
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
        PepYearField.setBounds(854, 623, 76, 20);
        contentPane.add(PepYearField);
        PepYearField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String phn = PepYearField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    PepYearField.setEditable(true);
                } else {
                    PepYearField.setEditable(false);
                }
            }
        });

        PepPassField = new JPasswordField();
        PepPassField.setForeground(Color.WHITE);
        PepPassField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepPassField.setEchoChar('*');
        PepPassField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepPassField.setBackground(Color.DARK_GRAY);
        PepPassField.setBounds(682, 705, 246, 20);
        contentPane.add(PepPassField);

        PepEmailField = new JTextField();
        PepEmailField.setForeground(Color.WHITE);
        PepEmailField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepEmailField.setColumns(10);
        PepEmailField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepEmailField.setBackground(Color.DARK_GRAY);
        PepEmailField.setBounds(682, 557, 246, 20);
        contentPane.add(PepEmailField);

        PepName2Field = new JTextField();
        PepName2Field.setForeground(Color.WHITE);
        PepName2Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepName2Field.setColumns(10);
        PepName2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepName2Field.setBackground(Color.DARK_GRAY);
        PepName2Field.setBounds(151, 669, 246, 20);
        contentPane.add(PepName2Field);

        PepTypeField = new JTextField();
        PepTypeField.setEditable(false);
        PepTypeField.setForeground(Color.WHITE);
        PepTypeField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepTypeField.setColumns(10);
        PepTypeField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepTypeField.setBackground(Color.DARK_GRAY);
        PepTypeField.setBounds(151, 557, 246, 20);
        contentPane.add(PepTypeField);

        PepGenField = new JTextField();
        PepGenField.setForeground(Color.WHITE);
        PepGenField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepGenField.setColumns(10);
        PepGenField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepGenField.setBackground(Color.DARK_GRAY);
        PepGenField.setBounds(151, 705, 246, 20);
        contentPane.add(PepGenField);

        PepAddressField = new JTextField();
        PepAddressField.setForeground(Color.WHITE);
        PepAddressField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepAddressField.setColumns(10);
        PepAddressField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepAddressField.setBackground(Color.DARK_GRAY);
        PepAddressField.setBounds(682, 669, 246, 20);
        contentPane.add(PepAddressField);

        PepUserField = new JTextField();
        PepUserField.setEditable(false);
        PepUserField.setForeground(Color.WHITE);
        PepUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepUserField.setColumns(10);
        PepUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepUserField.setBackground(Color.DARK_GRAY);
        PepUserField.setBounds(151, 591, 246, 20);
        contentPane.add(PepUserField);

        PepName1Field = new JTextField();
        PepName1Field.setForeground(Color.WHITE);
        PepName1Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        PepName1Field.setColumns(10);
        PepName1Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        PepName1Field.setBackground(Color.DARK_GRAY);
        PepName1Field.setBounds(151, 634, 246, 20);
        contentPane.add(PepName1Field);

        JLabel lblPepType = new JLabel("People Type");
        lblPepType.setForeground(Color.WHITE);
        lblPepType.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPepType.setBounds(20, 557, 121, 21);
        contentPane.add(lblPepType);

        JLabel lblFirstName = new JLabel("First Name");
        lblFirstName.setForeground(Color.WHITE);
        lblFirstName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblFirstName.setBounds(20, 634, 97, 22);
        contentPane.add(lblFirstName);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblLastName.setBounds(20, 669, 97, 21);
        contentPane.add(lblLastName);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblEmail.setBounds(456, 557, 121, 21);
        contentPane.add(lblEmail);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setForeground(Color.WHITE);
        lblGender.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblGender.setBounds(20, 705, 97, 21);
        contentPane.add(lblGender);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPhoneNumber.setBounds(456, 591, 121, 21);
        contentPane.add(lblPhoneNumber);

        JLabel lblDateOfBirth = new JLabel("Date of Birth (dd-mm-yyyy)");
        lblDateOfBirth.setForeground(Color.WHITE);
        lblDateOfBirth.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblDateOfBirth.setBounds(456, 623, 198, 21);
        contentPane.add(lblDateOfBirth);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblAddress.setBounds(456, 668, 121, 21);
        contentPane.add(lblAddress);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPassword.setBounds(456, 705, 121, 21);
        contentPane.add(lblPassword);

        JLabel lbdd = new JLabel("DD");
        lbdd.setForeground(Color.WHITE);
        lbdd.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbdd.setBounds(682, 641, 58, 21);
        contentPane.add(lbdd);

        JLabel lbmm = new JLabel("MM");
        lbmm.setForeground(Color.WHITE);
        lbmm.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbmm.setBounds(768, 641, 58, 21);
        contentPane.add(lbmm);

        JLabel lbyyyy = new JLabel("YYYY");
        lbyyyy.setForeground(Color.WHITE);
        lbyyyy.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbyyyy.setBounds(854, 641, 58, 21);
        contentPane.add(lbyyyy);

        JLabel lbUser = new JLabel("Username");
        lbUser.setForeground(Color.WHITE);
        lbUser.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUser.setBounds(20, 595, 121, 21);
        contentPane.add(lbUser);

        //setVisible(true);
    }
}
