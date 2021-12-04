package vsystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ComF4Page extends JFrame implements ActionListener {

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
            VacCodeField.setText("");
            VacNameField.setText("");
            VacQField.setText("");
            SearchVacField.setText("");
            setVisible(false);
            VSystem.four.setVisible(true);

        } else if (e.getSource() == AddVacButton) {
            String v1 = VacCodeField.getText();
            String v2 = VacNameField.getText();
            double v3 = 0;
            double v4 = 0;
            double v5 = 0;
            double v6 = 0;
            double v7 = 0;
            if (v1.equals("") || v2.equals("")) {
                JOptionPane.showMessageDialog(this, "Try Again !!!\nMust Fill In Vaccine Code & Vaccine Name !!!");
            } else {
                Vaccine found3 = DataIO.checking2(v1);
                if (found3 == null) {
                    Vaccine vt = new Vaccine(v1, v2, v3, v4, v5, v6, v7);
                    DataIO.allVac.add(vt);
                    DataIO.write();                  
                    JOptionPane.showMessageDialog(this, "Successfully Added :)\n[Quantity of Newly Added Vaccine will be 0 in All Center]");      
                    DefaultTableModel tm4 = (DefaultTableModel) vacTable.getModel();
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
                } else {
                    JOptionPane.showMessageDialog(this, "The Vaccine Code Exist!");
                }
            }

        } else if (e.getSource() == SearchVacButton) {
            String v5 = SearchVacField.getText();
            if (v5.equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill Information to Search :/!!!");
            } else {
                DefaultTableModel tm4 = (DefaultTableModel) vacTable.getModel();
                tm4.setRowCount(0);
                for (int i = 0; i < DataIO.allVac.size(); i++) {
                    if (v5.equals(DataIO.allVac.get(i).getvCode()) || DataIO.allVac.get(i).getvCode().contains(v5) || DataIO.allVac.get(i).getvName().contains(v5)) {
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

                }
            }

        } else if (e.getSource() == SaveVacButton) {
            Vaccine s5 = DataIO.checking2(VacCodeField.getText());
            String con1 = VacQField.getText();
            String con2 = VacNameField.getText();
            if (VacCodeField.getText().equals("") || VacQField.getText().equals("") || VacNameField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill the Vaccine Quantity and Vaccine Code (Select from Table) :/!!!");
            } else if (s5 != null) {
                s5.setvName(con2);
                double d1 = Double.parseDouble(con1);
                switch (CentreCombobox.getSelectedIndex()) {
                    case 0:
                        s5.setcen1Qty(d1);
                        s5.setcen2Qty(d1);
                        s5.setcen3Qty(d1);
                        s5.setcen4Qty(d1);
                        s5.setcen5Qty(d1);
                        DataIO.write();
                        break;
                    case 1:
                        s5.setcen1Qty(d1);
                        DataIO.write();
                        break;
                    case 2:
                        s5.setcen2Qty(d1);
                        DataIO.write();
                        break;
                    case 3:
                        s5.setcen3Qty(d1);
                        DataIO.write();
                        break;
                    case 4:
                        s5.setcen4Qty(d1);
                        DataIO.write();
                        break;
                    case 5:
                        s5.setcen5Qty(d1);
                        DataIO.write();
                        break;
                }
                SearchVacField.setText("");
                VacQField.setText("");
                VacCodeField.setText("");
                VacNameField.setText("");
                CentreCombobox.setSelectedIndex(0);
                DefaultTableModel tm4 = (DefaultTableModel) vacTable.getModel();
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
                JOptionPane.showMessageDialog(this, "Succesfully Updated :)");
            } else {
                JOptionPane.showMessageDialog(this, "Not Found \nVaccine Code Not Exist !!!");
            }

        } else if (e.getSource() == DeleteVacButton) {
            Vaccine s5 = DataIO.checking2(VacCodeField.getText());
            if (VacCodeField.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Must Fill the Vaccine Code or Select Vaccine from Table :/!!!");
            } else if (s5 != null) {
                ArrayList<Vaccine> temp3 = new ArrayList<Vaccine>();
                for (Vaccine vac1 : DataIO.allVac) {
                    if (!vac1.getvCode().equals(s5.getvCode())) {
                        String vac2 = vac1.getvCode();
                        String vac3 = vac1.getvName();
                        double vac4 = vac1.getcen1Qty();
                        double vac5 = vac1.getcen2Qty();
                        double vac6 = vac1.getcen3Qty();
                        double vac7 = vac1.getcen4Qty();
                        double vac8 = vac1.getcen5Qty();
                        Vaccine vacx = new Vaccine(vac2, vac3, vac4, vac5, vac6, vac7, vac8);
                        temp3.add(vacx);
                    }
                }
                DataIO.allVac = temp3;
                DataIO.write();
                //temp3 = null;
                SearchVacField.setText("");
                VacQField.setText("");
                VacCodeField.setText("");
                VacNameField.setText("");
                CentreCombobox.setSelectedIndex(0);
                DefaultTableModel tm4 = (DefaultTableModel) vacTable.getModel();
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
                JOptionPane.showMessageDialog(this, "Deleted :)");

            } else {
                JOptionPane.showMessageDialog(this, "Not Found \nVaccine Code Not-Exist !!!");
            }

        } else if (e.getSource() == refButton) {
            DefaultTableModel tm4 = (DefaultTableModel) vacTable.getModel();
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

        }
    }

    private JPanel contentPane;
    private JTextField VacCodeField, VacNameField, VacQField, SearchVacField;
    public static JTable vacTable;
    private JButton BackButton, ExitButton, MinButton, AddVacButton, SaveVacButton, DeleteVacButton, refButton, SearchVacButton;
    public static JComboBox CentreCombobox;
    private int mouseX, mouseY;

    public ComF4Page() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 180, 900, 630);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 900, 22);
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
        panel_1.setBounds(0, 21, 900, 58);
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
        ExitButton.setBounds(878, 0, 20, 20);
        panel.add(ExitButton);
        ExitButton.addActionListener(this);

        MinButton = new JButton("");
        MinButton.setIcon(new ImageIcon(ComF2Page.class.getResource("/Image/icons8_minimize_window_25px.png")));
        MinButton.setBorder(null);
        MinButton.setBackground(Color.GRAY);
        MinButton.setBounds(854, 0, 20, 20);
        panel.add(MinButton);
        MinButton.addActionListener(this);

        AddVacButton = new JButton("Add");
        AddVacButton.setIcon(new ImageIcon(ComF4Page.class.getResource("/Image/icons8_syringe_35px.png")));
        AddVacButton.setForeground(Color.WHITE);
        AddVacButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        AddVacButton.setBorder(null);
        AddVacButton.setBackground(Color.GRAY);
        AddVacButton.setBounds(20, 566, 134, 42);
        contentPane.add(AddVacButton);
        AddVacButton.addActionListener(this);

        DeleteVacButton = new JButton("Delete");
        DeleteVacButton.setForeground(Color.WHITE);
        DeleteVacButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        DeleteVacButton.setBorder(null);
        DeleteVacButton.setBackground(Color.GRAY);
        DeleteVacButton.setBounds(758, 585, 121, 23);
        contentPane.add(DeleteVacButton);
        DeleteVacButton.addActionListener(this);

        SaveVacButton = new JButton("Save & Update");
        SaveVacButton.setForeground(Color.WHITE);
        SaveVacButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SaveVacButton.setBorder(null);
        SaveVacButton.setBackground(Color.GRAY);
        SaveVacButton.setBounds(609, 585, 121, 23);
        contentPane.add(SaveVacButton);
        SaveVacButton.addActionListener(this);

        SearchVacButton = new JButton("Search");
        SearchVacButton.setForeground(Color.WHITE);
        SearchVacButton.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchVacButton.setBorder(null);
        SearchVacButton.setBackground(Color.GRAY);
        SearchVacButton.setBounds(769, 102, 110, 22);
        contentPane.add(SearchVacButton);
        SearchVacButton.addActionListener(this);

        refButton = new JButton("Refresh");
        refButton.setIcon(new ImageIcon(ComF4Page.class.getResource("/Image/icons8_refresh_25px.png")));
        refButton.setForeground(Color.WHITE);
        refButton.setFont(new Font("Rockwell", Font.BOLD, 16));
        refButton.setBorder(null);
        refButton.setBackground(Color.GRAY);
        refButton.setBounds(776, 419, 110, 25);
        contentPane.add(refButton);
        refButton.addActionListener(this);

        JScrollPane scrollTable = new JScrollPane();
        scrollTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        scrollTable.setBackground(Color.DARK_GRAY);
        scrollTable.setBounds(10, 135, 880, 280);
        contentPane.add(scrollTable);

        vacTable = new JTable();
        vacTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                VacCodeField.setText(vacTable.getValueAt(vacTable.getSelectedRow(), 0).toString());
                VacNameField.setText(vacTable.getValueAt(vacTable.getSelectedRow(), 1).toString());
            }
        });
        vacTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Vaccine Code", "Vaccine Name", "Centre 1", "Centre 2", "Centre 3", "Centre 4", "Centre 5"
                }
        ) {
            boolean[] columnEditables = new boolean[]{
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        vacTable.setSelectionForeground(Color.WHITE);
        vacTable.setSelectionBackground(new Color(0, 128, 0));
        vacTable.setGridColor(Color.LIGHT_GRAY);
        vacTable.setForeground(Color.WHITE);
        vacTable.setFont(new Font("Rockwell", Font.BOLD, 14));
        vacTable.setBackground(Color.DARK_GRAY);
        vacTable.getTableHeader().setReorderingAllowed(false);
        scrollTable.setViewportView(vacTable);

        VacQField = new JTextField();
        VacQField.setForeground(Color.WHITE);
        VacQField.setFont(new Font("Rockwell", Font.BOLD, 14));
        VacQField.setColumns(10);
        VacQField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        VacQField.setBackground(Color.DARK_GRAY);
        VacQField.setBounds(630, 513, 249, 20);
        contentPane.add(VacQField);
        VacQField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent k) {
                String qty = VacQField.getText();
                if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9' || k.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    VacQField.setEditable(true);
                } else {
                    VacQField.setEditable(false);
                }
            }
        });

        CentreCombobox = new JComboBox();
        CentreCombobox.setModel(new DefaultComboBoxModel());
        CentreCombobox.setForeground(Color.WHITE);
        CentreCombobox.setFont(new Font("Rockwell", Font.BOLD, 14));
        CentreCombobox.setBackground(Color.GRAY);
        CentreCombobox.setBounds(630, 473, 249, 22);
        contentPane.add(CentreCombobox);

        SearchVacField = new JTextField();
        SearchVacField.setForeground(Color.WHITE);
        SearchVacField.setFont(new Font("Rockwell", Font.BOLD, 14));
        SearchVacField.setColumns(10);
        SearchVacField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        SearchVacField.setBackground(Color.DARK_GRAY);
        SearchVacField.setBounds(24, 102, 735, 22);
        contentPane.add(SearchVacField);

        VacCodeField = new JTextField();
        VacCodeField.setForeground(Color.WHITE);
        VacCodeField.setFont(new Font("Rockwell", Font.BOLD, 14));
        VacCodeField.setColumns(10);
        VacCodeField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        VacCodeField.setBackground(Color.DARK_GRAY);
        VacCodeField.setBounds(167, 474, 249, 20);
        contentPane.add(VacCodeField);

        VacNameField = new JTextField();
        VacNameField.setForeground(Color.WHITE);
        VacNameField.setFont(new Font("Rockwell", Font.BOLD, 14));
        VacNameField.setColumns(10);
        VacNameField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        VacNameField.setBackground(Color.DARK_GRAY);
        VacNameField.setBounds(167, 513, 249, 20);
        contentPane.add(VacNameField);

        JLabel lbTitle = new JLabel("Manage Vaccine");
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Rockwell", Font.BOLD, 24));
        lbTitle.setBounds(351, 8, 223, 47);
        panel_1.add(lbTitle);

        JLabel lblSelectCentre = new JLabel("Select Centre");
        lblSelectCentre.setForeground(Color.WHITE);
        lblSelectCentre.setFont(new Font("Rockwell", Font.BOLD, 14));
        lblSelectCentre.setBounds(470, 474, 134, 21);
        contentPane.add(lblSelectCentre);

        JLabel lbQuantity = new JLabel("Quantity");
        lbQuantity.setForeground(Color.WHITE);
        lbQuantity.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbQuantity.setBounds(470, 513, 134, 21);
        contentPane.add(lbQuantity);

        JLabel lbVaccineName = new JLabel("Vaccine Name");
        lbVaccineName.setForeground(Color.WHITE);
        lbVaccineName.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbVaccineName.setBounds(20, 513, 101, 21);
        contentPane.add(lbVaccineName);

        JLabel lbUsername = new JLabel("Vaccine Code");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setFont(new Font("Rockwell", Font.BOLD, 14));
        lbUsername.setBounds(20, 474, 101, 21);
        contentPane.add(lbUsername);

        //setVisible(true);
    }
}
