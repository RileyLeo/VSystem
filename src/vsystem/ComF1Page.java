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
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class ComF1Page extends JFrame implements ActionListener {

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
            SearchComField.setText("");
            ComName1Field.setText("");
            ComName2Field.setText("");
            ComEmailField.setText("");
            ComPhoneField.setText("");
            ComUserField.setText("");
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == RegNewComButton) {
            SearchComField.setText("");
            ComName1Field.setText("");
            ComName2Field.setText("");
            ComEmailField.setText("");
            ComPhoneField.setText("");
            ComUserField.setText("");
            setVisible(false);
            VSystem.three.setVisible(true);

        } else if (e.getSource() == SearchComButton) {
            //Committee s1 = DataIO.checking(SearchComField.getText());
            String s1 = SearchComField.getText();
            if (s1.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill the Information :/!!!");
            } else {
                DefaultTableModel tm1 = (DefaultTableModel) comTable.getModel();
                tm1.setRowCount(0);
                for (int i = 0; i < DataIO.allCom.size(); i++) {
                    if (s1.equals(DataIO.allCom.get(i).getComUser()) || DataIO.allCom.get(i).getComUser().contains(s1) || DataIO.allCom.get(i).getComName1().contains(s1)) {
                        String c1 = DataIO.allCom.get(i).getComUser();
                        String c2 = DataIO.allCom.get(i).getComName1();
                        String c3 = DataIO.allCom.get(i).getComName2();
                        String c4 = DataIO.allCom.get(i).getComMail();
                        String c5 = DataIO.allCom.get(i).getComPhone();
                        String comArr[] = {c1, c2, c3, c4, c5};
                        tm1.addRow(comArr);
                    }
                }
            }

        } else if (e.getSource() == DeleteComButton) {
            //DELETE THE SEARCHED COMMITTEE
            Committee s1 = DataIO.checking(ComUserField.getText());
            if (ComUserField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Must Select Committee Information :/!!!");
            } else if (ComUserField.getText().equals(VSystem.login.getComUser())) {
                JOptionPane.showMessageDialog(this, "Hi There...\nYou Can't Delete Yourself !!!");
            } else if (s1 != null) {
                ArrayList<Committee> temp1 = new ArrayList<Committee>();
                for (Committee com1 : DataIO.allCom) {
                    if (!com1.getComUser().equals(s1.getComUser())) {
                        String d1 = com1.getComUser();
                        String d2 = com1.getComPass();
                        String d3 = com1.getComName1();
                        String d4 = com1.getComName2();
                        String d5 = com1.getComMail();
                        String d6 = com1.getComPhone();
                        Committee dx = new Committee(d1, d2, d3, d4, d5, d6);
                        temp1.add(dx);
                    }
                }
                DataIO.allCom = temp1;
                DataIO.write();
                //temp1=null
                DefaultTableModel tm1 = (DefaultTableModel) comTable.getModel();
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

                ComUserField.setText("");
                SearchComField.setText("");
                ComName1Field.setText("");
                ComName2Field.setText("");
                ComEmailField.setText("");
                ComPhoneField.setText("");
                JOptionPane.showMessageDialog(this, "Deleted :)");

            } else {
                JOptionPane.showMessageDialog(this, "Not Found \nCommittee Not-Exist !!!");
            }
            
            
        } else if (e.getSource() == refButton) {
            DefaultTableModel tm1 = (DefaultTableModel) comTable.getModel();
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
        }
    }

    private JPanel contentPane;
    private JTextField SearchComField, ComUserField, ComName1Field, ComName2Field, ComEmailField, ComPhoneField;
    private JButton BackButton, ExitButton, MinButton, RegNewComButton, SearchComButton, DeleteComButton, refButton;
    private int mouseX, mouseY;
    public static JTable comTable;

    public ComF1Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(675, 200, 700, 650);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 700, 22);
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
        panel_1.setBounds(0, 22, 700, 58);
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
        MinButton.setBounds(654, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        ExitButton = new JButton("");
        ExitButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_close_window_25px.png")));
        ExitButton.setBorder(null);
        ExitButton.setBackground(Color.GRAY);
        ExitButton.setBounds(678, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        RegNewComButton = new JButton("New Committee");
        RegNewComButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_people_50px.png")));
        RegNewComButton.setForeground(Color.WHITE);
        RegNewComButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        RegNewComButton.setBorder(null);
        RegNewComButton.setBackground(Color.GRAY);
        RegNewComButton.setBounds(457, 487, 212, 47);
        contentPane.add(RegNewComButton);
        RegNewComButton.addActionListener(this);

        refButton = new JButton("Refresh");
        refButton.setIcon(new ImageIcon(ComF1Page.class.getResource("/Image/icons8_refresh_25px.png")));
        refButton.setForeground(Color.WHITE);
        refButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        refButton.setBorder(null);
        refButton.setBackground(Color.GRAY);
        refButton.setBounds(590, 441, 100, 28);
        contentPane.add(refButton);
        refButton.addActionListener(this);

        DeleteComButton = new JButton("Delete");
        DeleteComButton.setForeground(Color.WHITE);
        DeleteComButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DeleteComButton.setBorder(null);
        DeleteComButton.setBackground(Color.GRAY);
        DeleteComButton.setBounds(205, 608, 121, 23);
        contentPane.add(DeleteComButton);
        DeleteComButton.addActionListener(this);

        SearchComButton = new JButton("Search");
        SearchComButton.setForeground(Color.WHITE);
        SearchComButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchComButton.setBorder(null);
        SearchComButton.setBackground(Color.GRAY);
        SearchComButton.setBounds(569, 91, 121, 23);
        contentPane.add(SearchComButton);
        SearchComButton.addActionListener(this);

        JScrollPane scrollTable = new JScrollPane();
        scrollTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        scrollTable.setBackground(Color.DARK_GRAY);
        scrollTable.setBounds(10, 125, 680, 305);
        contentPane.add(scrollTable);

        comTable = new JTable();
        comTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                ComUserField.setText(comTable.getValueAt(comTable.getSelectedRow(), 0).toString());
                ComName1Field.setText(comTable.getValueAt(comTable.getSelectedRow(), 1).toString());
                ComName2Field.setText(comTable.getValueAt(comTable.getSelectedRow(), 2).toString());
                ComEmailField.setText(comTable.getValueAt(comTable.getSelectedRow(), 3).toString());
                ComPhoneField.setText(comTable.getValueAt(comTable.getSelectedRow(), 4).toString());
            }
        });
        //comTable.setSelectionModel(ListSelectionModel.SINGLE_SELECTION);
        comTable.setSelectionForeground(Color.WHITE);
        comTable.setSelectionBackground(new Color(0, 128, 0));
        comTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Username", "First Name", "Last Name", "E-Mail", "Phone Number"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        comTable.setGridColor(Color.LIGHT_GRAY);
        comTable.setForeground(Color.WHITE);
        comTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        comTable.setBackground(Color.DARK_GRAY);
        comTable.getTableHeader().setReorderingAllowed(false);
        scrollTable.setViewportView(comTable);

        SearchComField = new JTextField();
        SearchComField.setForeground(Color.WHITE);
        SearchComField.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchComField.setColumns(10);
        SearchComField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        SearchComField.setBackground(Color.DARK_GRAY);
        SearchComField.setBounds(10, 91, 549, 22);
        contentPane.add(SearchComField);

        ComName1Field = new JTextField();
        ComName1Field.setEditable(false);
        ComName1Field.setForeground(Color.WHITE);
        ComName1Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComName1Field.setColumns(10);
        ComName1Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComName1Field.setBackground(Color.DARK_GRAY);
        ComName1Field.setBounds(151, 481, 270, 20);
        contentPane.add(ComName1Field);

        ComUserField = new JTextField();
        ComUserField.setEditable(false);
        ComUserField.setForeground(Color.WHITE);
        ComUserField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComUserField.setColumns(10);
        ComUserField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComUserField.setBackground(Color.DARK_GRAY);
        ComUserField.setBounds(151, 449, 270, 20);
        contentPane.add(ComUserField);

        ComName2Field = new JTextField();
        ComName2Field.setEditable(false);
        ComName2Field.setForeground(Color.WHITE);
        ComName2Field.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComName2Field.setColumns(10);
        ComName2Field.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComName2Field.setBackground(Color.DARK_GRAY);
        ComName2Field.setBounds(151, 513, 270, 20);
        contentPane.add(ComName2Field);

        ComEmailField = new JTextField();
        ComEmailField.setEditable(false);
        ComEmailField.setForeground(Color.WHITE);
        ComEmailField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComEmailField.setColumns(10);
        ComEmailField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComEmailField.setBackground(Color.DARK_GRAY);
        ComEmailField.setBounds(151, 545, 270, 20);
        contentPane.add(ComEmailField);

        ComPhoneField = new JTextField();
        ComPhoneField.setEditable(false);
        ComPhoneField.setForeground(Color.WHITE);
        ComPhoneField.setFont(new Font("Rockwell", Font.BOLD, 14));
        ComPhoneField.setColumns(10);
        ComPhoneField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        ComPhoneField.setBackground(Color.DARK_GRAY);
        ComPhoneField.setBounds(151, 577, 270, 20);
        contentPane.add(ComPhoneField);

        JLabel lblLastName = new JLabel("Last Name");
        lblLastName.setForeground(Color.WHITE);
        lblLastName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblLastName.setBounds(20, 513, 121, 21);
        contentPane.add(lblLastName);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblEmail.setBounds(20, 545, 121, 21);
        contentPane.add(lblEmail);

        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblPhoneNumber.setBounds(20, 577, 121, 21);
        contentPane.add(lblPhoneNumber);

        JLabel lbUser = new JLabel("Username");
        lbUser.setForeground(Color.WHITE);
        lbUser.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUser.setBounds(20, 449, 121, 21);
        contentPane.add(lbUser);

        JLabel lbTitle = new JLabel("Manage Committee Accounts");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(173, 8, 363, 47);
        panel_1.add(lbTitle);

        JLabel lbname1c = new JLabel("First Name");
        lbname1c.setForeground(Color.WHITE);
        lbname1c.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbname1c.setBounds(20, 481, 121, 21);
        contentPane.add(lbname1c);

        //setVisible(true);
    }

}
