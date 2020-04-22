/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class pnAdd extends javax.swing.JPanel implements DocumentListener {

    Validation v = new Validation();
    private Connection con; //Ket noi DB
    private Statement stm; //Thuc hien cau lenh SQL
    private ResultSet rs; //Chua du lieu va xu ly
    DefaultTableModel tblS;
    DefaultTableModel tblT;
    DefaultTableModel tblSu;

    /**
     * Creates new form pnMain
     */
    public pnAdd() {
        initComponents();
        txtCode.getDocument().addDocumentListener(this);
        txtName.getDocument().addDocumentListener(this);
        txtDateBirth.getDocument().addDocumentListener(this);
        txtAddress.getDocument().addDocumentListener(this);
        txtPhone.getDocument().addDocumentListener(this);
        txtEmail.getDocument().addDocumentListener(this);
        txtTerm.getDocument().addDocumentListener(this);
        txtCodeTeacher.getDocument().addDocumentListener(this);
        txtNameTeacher.getDocument().addDocumentListener(this);
        txtDateBirthTeacher.getDocument().addDocumentListener(this);
        txtAddressTeacher.getDocument().addDocumentListener(this);
        txtPhoneTeacher.getDocument().addDocumentListener(this);
        txtEmailTeacher.getDocument().addDocumentListener(this);
        txtSalaryTeacher.getDocument().addDocumentListener(this);
        txtFirstDateTeacher.getDocument().addDocumentListener(this);
        txtCodeSubject.getDocument().addDocumentListener(this);
        txtNameSubject.getDocument().addDocumentListener(this);
        connectDB();
        tblS = (DefaultTableModel) tblStudent.getModel();
        tblS.setRowCount(0);
        tblSu = (DefaultTableModel) tblSubject.getModel();
        tblSu.setRowCount(0);
        tblT = (DefaultTableModel) tblTeacher.getModel();
        tblT.setRowCount(0);
        showStuTable();
        showTeaTable();
        showSubTable();
    }

    public void connectDB() {
        //Nap trinh dieu khien
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Ket noi voi DB
        try {
            String url = "jdbc:sqlserver://DESKTOP-VES4POV\\SQLEXPRESS:1433;databaseName=StudentDatabase";
            String user = "tn512";
            String password = "Ngoc1234";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connect successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStuTable() {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblStudent");
            //Add du lieu vao Frame
            tblS.setRowCount(0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String GT = "";
                if (rs.getInt(3) == 1) {
                    GT = "Nam";
                } else {
                    GT = "Nu";
                }
                String dob = String.valueOf(rs.getDate(4));
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String majors = rs.getString(8);
                String term = rs.getString(9);
                String status = rs.getString(10);

                tblS.insertRow(tblS.getRowCount(), new Object[]{code, name, dob, GT, address, phone, email, majors, term, status});
            }
        } catch (Exception e) {
            System.out.println("Show table: " + e.getMessage());
        }
    }

    public void showTeaTable() {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblTeacher");
            //Add du lieu vao Frame
            tblT.setRowCount(0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String GT = "";
                if (rs.getInt(3) == 1) {
                    GT = "Nam";
                } else {
                    GT = "Nu";
                }
                String dob = String.valueOf(rs.getDate(4));
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String salary = rs.getString(8);
                String firstDay = rs.getString(9);

                tblT.insertRow(tblT.getRowCount(), new Object[]{code, name, dob,
                    GT, address, phone, email, firstDay, salary});
            }
        } catch (Exception e) {
            System.out.println("Show Teacher table: " + e.getMessage());
        }
    }

    public void showSubTable() {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblSubject");
            //Add du lieu vao Frame
            tblSu.setRowCount(0);
            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                tblSu.insertRow(tblSu.getRowCount(), new Object[]{code, name});
            }
        } catch (Exception e) {
            System.out.println("Show Subject table: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtDateBirth = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        cboMajors = new javax.swing.JComboBox<>();
        cboStatus = new javax.swing.JComboBox<>();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTerm = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        rabMale = new javax.swing.JRadioButton();
        rabFemale = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCodeTeacher = new javax.swing.JTextField();
        txtNameTeacher = new javax.swing.JTextField();
        txtDateBirthTeacher = new javax.swing.JTextField();
        txtPhoneTeacher = new javax.swing.JTextField();
        txtEmailTeacher = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSalaryTeacher = new javax.swing.JTextField();
        txtAddressTeacher = new javax.swing.JTextField();
        rabMaleTeacher = new javax.swing.JRadioButton();
        rabFemaleTeacher = new javax.swing.JRadioButton();
        btnAddTeacher = new javax.swing.JButton();
        btnUpdateTeacher = new javax.swing.JButton();
        btnDeleteTeacher = new javax.swing.JButton();
        btnResetTeacher = new javax.swing.JButton();
        btnFindTeacher = new javax.swing.JButton();
        txtFirstDateTeacher = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTeacher = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCodeSubject = new javax.swing.JTextField();
        txtNameSubject = new javax.swing.JTextField();
        btnAddSubject = new javax.swing.JButton();
        btnUpdateSubject = new javax.swing.JButton();
        btnDeleteSubject = new javax.swing.JButton();
        btnResetSubject = new javax.swing.JButton();
        btnFindSubject = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSubject = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu9.setText("jMenu9");

        jMenu10.setText("File");
        jMenuBar5.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar5.add(jMenu11);

        jMenu12.setText("File");
        jMenuBar6.add(jMenu12);

        jMenu13.setText("Edit");
        jMenuBar6.add(jMenu13);

        jMenu14.setText("File");
        jMenuBar7.add(jMenu14);

        jMenu15.setText("Edit");
        jMenuBar7.add(jMenu15);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information of Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Code:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Date Birth:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Gender:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Status:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Majors:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Phone:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Email:");

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDateBirth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cboMajors.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboMajors.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Software Engineering", "Graphic Design", "Multimedia Communication" }));

        cboStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Studying", "Finished", "Reserve" }));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Term:");

        txtTerm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroup1.add(rabMale);
        rabMale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rabMale.setText("Male");

        buttonGroup1.add(rabFemale);
        rabFemale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rabFemale.setText("Female");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setEnabled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setText("RESET");
        btnReset.setEnabled(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFind.setText("FIND");
        btnFind.setEnabled(false);
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4))
                                        .addGap(65, 65, 65)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(26, 26, 26))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(52, 52, 52)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(rabMale)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rabFemale)))))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(68, 68, 68)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(59, 59, 59)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(cboMajors, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(18, 18, 18)
                        .addComponent(btnFind)
                        .addGap(91, 91, 91))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(txtDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMajors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rabMale)
                    .addComponent(rabFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnReset)
                    .addComponent(btnFind))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblStudent.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "DoB", "Gender", "Address", "Phone", "Email", "Majors", "Term", "Status"
            }
        ));
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student", jPanel1);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information of Teacher", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Code:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Date Birth:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Name:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Gender:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Address:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("FirstDate:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("Phone:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Email:");

        txtCodeTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNameTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDateBirthTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtPhoneTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmailTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Salary:");

        txtSalaryTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAddressTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        buttonGroup2.add(rabMaleTeacher);
        rabMaleTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rabMaleTeacher.setText("Male");

        buttonGroup2.add(rabFemaleTeacher);
        rabFemaleTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rabFemaleTeacher.setText("Female");

        btnAddTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddTeacher.setText("ADD");
        btnAddTeacher.setEnabled(false);
        btnAddTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTeacherActionPerformed(evt);
            }
        });

        btnUpdateTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdateTeacher.setText("UPDATE");
        btnUpdateTeacher.setEnabled(false);
        btnUpdateTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTeacherActionPerformed(evt);
            }
        });

        btnDeleteTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteTeacher.setText("DELETE");
        btnDeleteTeacher.setEnabled(false);
        btnDeleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTeacherActionPerformed(evt);
            }
        });

        btnResetTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResetTeacher.setText("RESET");
        btnResetTeacher.setEnabled(false);
        btnResetTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTeacherActionPerformed(evt);
            }
        });

        btnFindTeacher.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFindTeacher.setText("FIND");
        btnFindTeacher.setEnabled(false);
        btnFindTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindTeacherActionPerformed(evt);
            }
        });

        txtFirstDateTeacher.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddressTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel13))
                                        .addGap(65, 65, 65)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtNameTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodeTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addGap(26, 26, 26))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addGap(52, 52, 52)))
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDateBirthTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(rabMaleTeacher)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(rabFemaleTeacher)))))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(68, 68, 68)
                                        .addComponent(txtEmailTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(59, 59, 59)
                                        .addComponent(txtPhoneTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addGap(35, 35, 35)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalaryTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFirstDateTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddTeacher)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateTeacher)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteTeacher)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetTeacher)
                        .addGap(18, 18, 18)
                        .addComponent(btnFindTeacher)
                        .addGap(91, 91, 91))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodeTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtPhoneTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel13)
                    .addComponent(txtNameTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel12)
                    .addComponent(txtDateBirthTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstDateTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel20)
                    .addComponent(txtSalaryTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rabMaleTeacher)
                    .addComponent(rabFemaleTeacher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddressTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTeacher)
                    .addComponent(btnUpdateTeacher)
                    .addComponent(btnDeleteTeacher)
                    .addComponent(btnResetTeacher)
                    .addComponent(btnFindTeacher))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblTeacher.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tblTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "DoB", "Gender", "Address", "Phone", "Email", "FirstDate", "Salary"
            }
        ));
        tblTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTeacherMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTeacher);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Teacher", jPanel2);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information of Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Code:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setText("Name:");

        txtCodeSubject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtNameSubject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAddSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAddSubject.setText("ADD");
        btnAddSubject.setEnabled(false);
        btnAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSubjectActionPerformed(evt);
            }
        });

        btnUpdateSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdateSubject.setText("UPDATE");
        btnUpdateSubject.setEnabled(false);
        btnUpdateSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSubjectActionPerformed(evt);
            }
        });

        btnDeleteSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteSubject.setText("DELETE");
        btnDeleteSubject.setEnabled(false);
        btnDeleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSubjectActionPerformed(evt);
            }
        });

        btnResetSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResetSubject.setText("RESET");
        btnResetSubject.setEnabled(false);
        btnResetSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSubjectActionPerformed(evt);
            }
        });

        btnFindSubject.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnFindSubject.setText("FIND");
        btnFindSubject.setEnabled(false);
        btnFindSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindSubjectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(btnAddSubject)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateSubject)
                .addGap(18, 18, 18)
                .addComponent(btnDeleteSubject)
                .addGap(18, 18, 18)
                .addComponent(btnResetSubject)
                .addGap(18, 18, 18)
                .addComponent(btnFindSubject)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtCodeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(txtNameSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCodeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNameSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddSubject)
                    .addComponent(btnUpdateSubject)
                    .addComponent(btnDeleteSubject)
                    .addComponent(btnResetSubject)
                    .addComponent(btnFindSubject))
                .addGap(0, 37, Short.MAX_VALUE))
        );

        tblSubject.setBackground(new java.awt.Color(240, 240, 240));
        tblSubject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Code", "Name"
            }
        ));
        tblSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSubjectMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSubject);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Subject", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean checkStu(String StuCode) {
        //true - ID ton tai
        //false - ID chua ton tai
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select * from  tblStudent where code = '" + StuCode + "'");
            rs.first();
            String a = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkTeacher(String teacherCode) {
        //true - ID ton tai
        //false - ID chua ton tai
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select * from  tblTeacher where code = '" + teacherCode + "'");
            rs.first();
            String a = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkSub(String subCode) {
        //true - ID ton tai
        //false - ID chua ton tai
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select * from  tblSubject where code = '" + subCode + "'");
            rs.first();
            String a = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        //Check xem subjectID to tai chua
        if (checkStu(txtCode.getText())) {
            JOptionPane.showMessageDialog(null, "Student Code has already existed!");
            return;
        }
        if (!v.validateDate(txtDateBirth.getText())) {
            txtDateBirth.setText("");
            JOptionPane.showMessageDialog(null, "Student Date of Birth have to be MM/DD/YYYY format!");
            return;
        }
        try {
            boolean a;
            if (rabMale.isSelected()) {
                a = true;
            } else {
                a = false;
            }
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strInsert = "Insert into tblStudent values('"
                    + txtCode.getText() + "','" + txtName.getText() + "','"
                    + a + "', '" + txtDateBirth.getText() + "', '"
                    + txtAddress.getText() + "', '" + txtPhone.getText()
                    + "', '" + txtEmail.getText() + "','"
                    + cboMajors.getSelectedItem().toString() + "','"
                    + txtTerm.getText() + "','" + cboStatus.getSelectedItem().toString() + "')";
            stm.execute(strInsert);
            showStuTable();
            JOptionPane.showMessageDialog(null, "Add Successfully!");
        } catch (Exception e) {
            System.out.println("Add: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (!checkStu(txtCode.getText())) {
            JOptionPane.showMessageDialog(null, "Student ID has not existed!");
            return;
        }
        try {
            int row = 0;
            String Name = txtName.getText();
            String Address = txtAddress.getText();
            String DoB = txtDateBirth.getText();
            String Phone = txtPhone.getText();
            String Email = txtEmail.getText();
            String Majors = cboMajors.getSelectedItem().toString();
            String Term = txtTerm.getText();
            String Status = cboStatus.getSelectedItem().toString();
            for (int i = 0; i < tblStudent.getRowCount(); i++) {
                if (txtCode.getText().equalsIgnoreCase((String) tblStudent.getValueAt(i, 0))) {
                    row = i;
                }
            }
            if (txtAddress.getText().isEmpty()) {
                Address = (String) tblStudent.getValueAt(row, 4);
            }
            if (txtName.getText().isEmpty()) {
                Name = (String) tblStudent.getValueAt(row, 1);
            }
            if (txtDateBirth.getText().isEmpty()) {
                DoB = (String) tblStudent.getValueAt(row, 2);
            }
            if (txtPhone.getText().isEmpty()) {
                Phone = (String) tblStudent.getValueAt(row, 5);
            }
            if (txtEmail.getText().isEmpty()) {
                Email = (String) tblStudent.getValueAt(row, 6);
            }
            if (txtTerm.getText().isEmpty()) {
                Term = (String) tblStudent.getValueAt(row, 8);
            }
            boolean a;
            if (rabMale.isSelected()) {
                a = true;
            } else {
                a = false;
            }
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strUpdate = "Update tblStudent set name = '" + Name
                    + "', gender = '" + a + "', address = '" + Address + "', dateBirth = '"
                    + DoB + "', phone = '" + Phone + "', email = '" + Email + "', major = '"
                    + Majors + "', term = '" + Term + "', status = '" + cboStatus.getSelectedItem().toString()
                    + "' where code = '" + txtCode.getText() + "'";
            stm.execute(strUpdate);
            showStuTable();
            JOptionPane.showMessageDialog(null, "Update Successfully!");
        } catch (Exception e) {
            System.out.println("Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtCode.setText("");
        txtName.setText("");
        txtDateBirth.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtTerm.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!checkStu(txtCode.getText())) {
            JOptionPane.showMessageDialog(null, "Subject ID has not existed!");
            return;
        }
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strDeleteTBLStudying = "delete from tblStudying where studentCode = '" + txtCode.getText() + "'";
            stm.execute(strDeleteTBLStudying);
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strDelete = "delete from tblStudent where code = '" + txtCode.getText() + "'";
            stm.execute(strDelete);
            txtCode.setText("");
            txtName.setText("");
            txtDateBirth.setText("");
            txtAddress.setText("");
            txtPhone.setText("");
            txtEmail.setText("");
            txtTerm.setText("");
            showStuTable();
            JOptionPane.showMessageDialog(null, "Delete Successfully!");
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        if (tblStudent.getSelectedRow() != -1) {
            try {
                int row = tblStudent.getSelectedRow();
                txtCode.setText((String) tblStudent.getValueAt(row, 0));
                txtName.setText((String) tblStudent.getValueAt(row, 1));
                txtDateBirth.setText((String) tblStudent.getValueAt(row, 2));
                rabMale.setSelected(((String) tblStudent.getValueAt(row, 3)).equals("Nam"));
                rabFemale.setSelected(((String) tblStudent.getValueAt(row, 3)).equals("Nu"));
                txtAddress.setText((String) tblStudent.getValueAt(row, 4));
                txtPhone.setText((String) tblStudent.getValueAt(row, 5));
                txtEmail.setText((String) tblStudent.getValueAt(row, 6));
                txtTerm.setText((String) tblStudent.getValueAt(row, 8));
                cboMajors.setSelectedItem(tblStudent.getValueAt(row, 7));
                cboStatus.setSelectedItem(tblStudent.getValueAt(row, 9));
            } catch (Exception e) {
                System.out.println("Selected Row: " + e.getMessage());
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblStudent where code = '" + txtCode.getText() + "'");
            while (rs.next()) {
                txtName.setText(rs.getString(2));
                txtDateBirth.setText(rs.getString(4));
                rabMale.setSelected(rs.getString(3).equals("Nam"));
                rabFemale.setSelected(rs.getString(3).equals("Nu"));
                txtAddress.setText(rs.getString(5));
                txtPhone.setText(rs.getString(6));
                txtEmail.setText(rs.getString(7));
                txtTerm.setText(rs.getString(9));
                cboMajors.setSelectedItem(rs.getString(8));
                cboStatus.setSelectedItem(rs.getString(10));
            }
        } catch (Exception e) {
            System.out.println("Find: " + e.getMessage());
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAddTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTeacherActionPerformed
        //Check xem subjectID to tai chua
        if (checkTeacher(txtCodeTeacher.getText())) {
            JOptionPane.showMessageDialog(null, "Teacher Code has already existed!");
            return;
        }
        if (!v.validateDate(txtDateBirthTeacher.getText())) {
            txtDateBirthTeacher.setText("");
            JOptionPane.showMessageDialog(null, "Teacher Date of Birth have to be MM/DD/YYYY format!");
            return;
        }
        try {
            boolean a;
            if (rabMaleTeacher.isSelected()) {
                a = true;
            } else {
                a = false;
            }
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strInsert = "Insert into tblTeacher values('"
                    + txtCodeTeacher.getText() + "','" + txtNameTeacher.getText() + "','"
                    + a + "', '" + txtDateBirthTeacher.getText() + "', '"
                    + txtAddressTeacher.getText() + "', '" + txtPhoneTeacher.getText()
                    + "', '" + txtEmailTeacher.getText() + "',"
                    + txtSalaryTeacher.getText() + ",'" + txtFirstDateTeacher.getText() + "')";
            stm.execute(strInsert);
            showTeaTable();
            JOptionPane.showMessageDialog(null, "Add Successfully!");
        } catch (Exception e) {
            System.out.println("Add: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddTeacherActionPerformed

    private void btnUpdateTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTeacherActionPerformed
        if (!checkTeacher(txtCodeTeacher.getText())) {
            JOptionPane.showMessageDialog(null, "Subject ID has not existed!");
            return;
        }
        try {
            int row = 0;
            String Name = txtNameTeacher.getText();
            String Address = txtAddressTeacher.getText();
            String DoB = txtDateBirthTeacher.getText();
            String Phone = txtPhoneTeacher.getText();
            String Email = txtEmailTeacher.getText();
            String Salary = txtSalaryTeacher.getText();
            String FirstDate = txtFirstDateTeacher.getText();
            for (int i = 0; i < tblTeacher.getRowCount(); i++) {
                if (txtCodeTeacher.getText().equalsIgnoreCase((String) tblTeacher.getValueAt(i, 0))) {
                    row = i;
                }
            }
            if (txtAddressTeacher.getText().isEmpty()) {
                Address = (String) tblTeacher.getValueAt(row, 4);
            }
            if (txtNameTeacher.getText().isEmpty()) {
                Name = (String) tblTeacher.getValueAt(row, 1);
            }
            if (txtDateBirthTeacher.getText().isEmpty()) {
                DoB = (String) tblTeacher.getValueAt(row, 2);
            }
            if (txtPhoneTeacher.getText().isEmpty()) {
                Phone = (String) tblTeacher.getValueAt(row, 5);
            }
            if (txtEmailTeacher.getText().isEmpty()) {
                Email = (String) tblTeacher.getValueAt(row, 6);
            }
            if (txtSalaryTeacher.getText().isEmpty()) {
                Salary = (String) tblTeacher.getValueAt(row, 8);
            }
            if (txtFirstDateTeacher.getText().isEmpty()) {
                FirstDate = (String) tblTeacher.getValueAt(row, 7);
            }
            boolean a;
            if (rabMaleTeacher.isSelected()) {
                a = true;
            } else {
                a = false;
            }
            System.out.println(a + Name + Address + DoB + Email + FirstDate + Phone + Salary);
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strUpdate = "Update tblTeacher set name = '" + Name
                    + "', gender = '" + a + "', address = '" + Address + "', dateBirth = '"
                    + DoB + "', phone = '" + Phone + "', email = '" + Email + "', salary = "
                    + Salary + ", firstDay = '" + FirstDate + "' where code = '" + txtCodeTeacher.getText() + "'";
            stm.execute(strUpdate);
            showTeaTable();
            JOptionPane.showMessageDialog(null, "Update Successfully!");
        } catch (Exception e) {
            System.out.println("Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateTeacherActionPerformed

    private void tblTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTeacherMouseClicked
        if (tblTeacher.getSelectedRow() != -1) {
            try {
                int row = tblTeacher.getSelectedRow();
                txtCodeTeacher.setText((String) tblTeacher.getValueAt(row, 0));
                txtNameTeacher.setText((String) tblTeacher.getValueAt(row, 1));
                txtDateBirthTeacher.setText((String) tblTeacher.getValueAt(row, 2));
                rabMaleTeacher.setSelected(((String) tblTeacher.getValueAt(row, 3)).equals("Nam"));
                rabFemaleTeacher.setSelected(((String) tblTeacher.getValueAt(row, 3)).equals("Nu"));
                txtAddressTeacher.setText((String) tblTeacher.getValueAt(row, 4));
                txtPhoneTeacher.setText((String) tblTeacher.getValueAt(row, 5));
                txtEmailTeacher.setText((String) tblTeacher.getValueAt(row, 6));
                txtSalaryTeacher.setText((String) tblTeacher.getValueAt(row, 8));
                txtFirstDateTeacher.setText((String) tblTeacher.getValueAt(row, 7));

            } catch (Exception e) {
                System.out.println("Selected Teacher Row: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_tblTeacherMouseClicked

    private void btnDeleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTeacherActionPerformed
        if (!checkTeacher(txtCodeTeacher.getText())) {
            JOptionPane.showMessageDialog(null, "Teacher ID has not existed!");
            return;
        }
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strDelete = "delete from tblTeacher where code = '" + txtCodeTeacher.getText() + "'";
            stm.execute(strDelete);
            txtCodeTeacher.setText("");
            txtNameTeacher.setText("");
            txtDateBirthTeacher.setText("");
            txtAddressTeacher.setText("");
            txtPhoneTeacher.setText("");
            txtEmailTeacher.setText("");
            txtSalaryTeacher.setText("");
            txtFirstDateTeacher.setText("");
            showTeaTable();
            JOptionPane.showMessageDialog(null, "Delete Successfully!");
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteTeacherActionPerformed

    private void btnResetTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTeacherActionPerformed
        txtCodeTeacher.setText("");
        txtNameTeacher.setText("");
        txtDateBirthTeacher.setText("");
        txtAddressTeacher.setText("");
        txtPhoneTeacher.setText("");
        txtEmailTeacher.setText("");
        txtSalaryTeacher.setText("");
        txtFirstDateTeacher.setText("");
    }//GEN-LAST:event_btnResetTeacherActionPerformed

    private void btnFindTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindTeacherActionPerformed
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblTeacher where code = '" + txtCodeTeacher.getText() + "'");
            while (rs.next()) {
                txtNameTeacher.setText(rs.getString(2));
                txtDateBirthTeacher.setText(rs.getString(4));
                rabMaleTeacher.setSelected(rs.getString(3).equals("Nam"));
                rabFemaleTeacher.setSelected(rs.getString(3).equals("Nu"));
                txtAddressTeacher.setText(rs.getString(5));
                txtPhoneTeacher.setText(rs.getString(6));
                txtEmailTeacher.setText(rs.getString(7));
                txtSalaryTeacher.setText(rs.getString(8));
                txtFirstDateTeacher.setText(rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println("Find: " + e.getMessage());
        }
    }//GEN-LAST:event_btnFindTeacherActionPerformed

    private void btnAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSubjectActionPerformed
        if (checkSub(txtCodeSubject.getText())) {
            JOptionPane.showMessageDialog(null, "Subject Code has already existed!");
            return;
        }
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strInsert = "Insert into tblSubject values('"
                    + txtCodeSubject.getText() + "','" + txtNameSubject.getText() + "')";
            stm.execute(strInsert);
            showSubTable();
            JOptionPane.showMessageDialog(null, "Add Successfully!");
        } catch (Exception e) {
            System.out.println("Add: " + e.getMessage());
        }
    }//GEN-LAST:event_btnAddSubjectActionPerformed

    private void btnUpdateSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSubjectActionPerformed
        if (!checkSub(txtCodeSubject.getText())) {
            JOptionPane.showMessageDialog(null, "Subject ID has not existed!");
            return;
        }
        try {
            int row = 0;
            String Name = txtNameSubject.getText();
            for (int i = 0; i < tblSubject.getRowCount(); i++) {
                if (txtCodeTeacher.getText().equalsIgnoreCase((String) tblSubject.getValueAt(i, 0))) {
                    row = i;
                }
            }
            if (txtNameSubject.getText().isEmpty()) {
                Name = (String) tblSubject.getValueAt(row, 1);
            }
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strUpdate = "Update tblSubject set name = '" + Name
                    + "' where code = '" + txtCodeSubject.getText() + "'";
            stm.execute(strUpdate);
            showSubTable();
            JOptionPane.showMessageDialog(null, "Update Successfully!");
        } catch (Exception e) {
            System.out.println("Update: " + e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateSubjectActionPerformed

    private void btnDeleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSubjectActionPerformed
        if (!checkSub(txtCodeSubject.getText())) {
            JOptionPane.showMessageDialog(null, "Subject ID has not existed!");
            return;
        }
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String strDelete = "delete from tblSubject where code = '" + txtCodeSubject.getText() + "'";
            stm.execute(strDelete);
            txtCodeSubject.setText("");
            txtNameSubject.setText("");
            showSubTable();
            JOptionPane.showMessageDialog(null, "Delete Successfully!");
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
    }//GEN-LAST:event_btnDeleteSubjectActionPerformed

    private void btnResetSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSubjectActionPerformed
        txtCodeSubject.setText("");
        txtNameSubject.setText("");
    }//GEN-LAST:event_btnResetSubjectActionPerformed

    private void btnFindSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindSubjectActionPerformed
        if (!checkSub(txtCodeSubject.getText())) {
            JOptionPane.showMessageDialog(null, "Subject ID has not existed!");
            return;
        }
        try {
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblSubject where code = '" + txtCodeSubject.getText() + "'");
            while (rs.next()) {
                txtNameSubject.setText(rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("Find: " + e.getMessage());
        }
    }//GEN-LAST:event_btnFindSubjectActionPerformed

    private void tblSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSubjectMouseClicked
        if (tblSubject.getSelectedRow() != -1) {
            try {
                int row = tblSubject.getSelectedRow();
                txtCodeSubject.setText((String) tblSubject.getValueAt(row, 0));
                txtNameSubject.setText((String) tblSubject.getValueAt(row, 1));
            } catch (Exception e) {
                System.out.println("Selected Teacher Row: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_tblSubjectMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddSubject;
    private javax.swing.JButton btnAddTeacher;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteSubject;
    private javax.swing.JButton btnDeleteTeacher;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFindSubject;
    private javax.swing.JButton btnFindTeacher;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetSubject;
    private javax.swing.JButton btnResetTeacher;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateSubject;
    private javax.swing.JButton btnUpdateTeacher;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboMajors;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rabFemale;
    private javax.swing.JRadioButton rabFemaleTeacher;
    private javax.swing.JRadioButton rabMale;
    private javax.swing.JRadioButton rabMaleTeacher;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTable tblSubject;
    private javax.swing.JTable tblTeacher;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAddressTeacher;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCodeSubject;
    private javax.swing.JTextField txtCodeTeacher;
    private javax.swing.JTextField txtDateBirth;
    private javax.swing.JTextField txtDateBirthTeacher;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmailTeacher;
    private javax.swing.JTextField txtFirstDateTeacher;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSubject;
    private javax.swing.JTextField txtNameTeacher;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtPhoneTeacher;
    private javax.swing.JTextField txtSalaryTeacher;
    private javax.swing.JTextField txtTerm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (!txtCode.getText().isEmpty() && !txtName.getText().isEmpty()
                && !txtAddress.getText().isEmpty() && !txtDateBirth.getText().isEmpty()
                && !txtPhone.getText().isEmpty() && !txtEmail.getText().isEmpty()
                && !txtTerm.getText().isEmpty()) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty()) {
            btnDelete.setEnabled(true);
            btnFind.setEnabled(true);
        } else {
            btnDelete.setEnabled(false);
            btnFind.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty() && (!txtName.getText().isEmpty()
                || !txtAddress.getText().isEmpty() || !txtDateBirth.getText().isEmpty()
                || !txtPhone.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtTerm.getText().isEmpty())) {
            btnUpdate.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty() || !txtName.getText().isEmpty() || !txtAddress.getText().isEmpty() || !txtDateBirth.getText().isEmpty()
                || !txtPhone.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtTerm.getText().isEmpty()) {
            btnReset.setEnabled(true);
        } else {
            btnReset.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() && !txtNameTeacher.getText().isEmpty()
                && !txtAddressTeacher.getText().isEmpty() && !txtDateBirthTeacher.getText().isEmpty()
                && !txtPhoneTeacher.getText().isEmpty() && !txtEmailTeacher.getText().isEmpty()
                && !txtSalaryTeacher.getText().isEmpty() && !txtFirstDateTeacher.getText().isEmpty()) {
            btnAddTeacher.setEnabled(true);
        } else {
            btnAddTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty()) {
            btnDeleteTeacher.setEnabled(true);
            btnFindTeacher.setEnabled(true);
        } else {
            btnDeleteTeacher.setEnabled(false);
            btnFindTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() && (!txtNameTeacher.getText().isEmpty()
                || !txtAddressTeacher.getText().isEmpty() || !txtDateBirthTeacher.getText().isEmpty()
                || !txtPhoneTeacher.getText().isEmpty() || !txtEmailTeacher.getText().isEmpty()
                || !txtSalaryTeacher.getText().isEmpty() || !txtFirstDateTeacher.getText().isEmpty())) {
            btnUpdateTeacher.setEnabled(true);
        } else {
            btnUpdateTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() || !txtNameTeacher.getText().isEmpty() || !txtAddressTeacher.getText().isEmpty() || !txtDateBirthTeacher.getText().isEmpty()
                || !txtPhoneTeacher.getText().isEmpty() || !txtEmailTeacher.getText().isEmpty() || !txtSalaryTeacher.getText().isEmpty() || !txtFirstDateTeacher.getText().isEmpty()) {
            btnResetTeacher.setEnabled(true);
        } else {
            btnResetTeacher.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty() && !txtNameSubject.getText().isEmpty()) {
            btnAddSubject.setEnabled(true);
            btnUpdateSubject.setEnabled(true);
        } else {
            btnAddSubject.setEnabled(false);
            btnUpdateSubject.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty()) {
            btnDeleteSubject.setEnabled(true);
            btnFindSubject.setEnabled(true);
        } else {
            btnDeleteSubject.setEnabled(false);
            btnFindSubject.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty() || !txtNameSubject.getText().isEmpty()) {
            btnResetSubject.setEnabled(true);
        } else {
            btnResetSubject.setEnabled(false);
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (!txtCode.getText().isEmpty() && !txtName.getText().isEmpty()
                && !txtAddress.getText().isEmpty() && !txtDateBirth.getText().isEmpty()
                && !txtPhone.getText().isEmpty() && !txtEmail.getText().isEmpty()
                && !txtTerm.getText().isEmpty()) {
            btnAdd.setEnabled(true);
        } else {
            btnAdd.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty()) {
            btnDelete.setEnabled(true);
            btnFind.setEnabled(true);
        } else {
            btnDelete.setEnabled(false);
            btnFind.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty() && (!txtName.getText().isEmpty()
                || !txtAddress.getText().isEmpty() || !txtDateBirth.getText().isEmpty()
                || !txtPhone.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtTerm.getText().isEmpty())) {
            btnUpdate.setEnabled(true);
        } else {
            btnUpdate.setEnabled(false);
        }
        if (!txtCode.getText().isEmpty() || !txtName.getText().isEmpty() || !txtAddress.getText().isEmpty() || !txtDateBirth.getText().isEmpty()
                || !txtPhone.getText().isEmpty() || !txtEmail.getText().isEmpty() || !txtTerm.getText().isEmpty()) {
            btnReset.setEnabled(true);
        } else {
            btnReset.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() && !txtNameTeacher.getText().isEmpty()
                && !txtAddressTeacher.getText().isEmpty() && !txtDateBirthTeacher.getText().isEmpty()
                && !txtPhoneTeacher.getText().isEmpty() && !txtEmailTeacher.getText().isEmpty()
                && !txtSalaryTeacher.getText().isEmpty() && !txtFirstDateTeacher.getText().isEmpty()) {
            btnAddTeacher.setEnabled(true);
        } else {
            btnAddTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty()) {
            btnDeleteTeacher.setEnabled(true);
            btnFindTeacher.setEnabled(true);
        } else {
            btnDeleteTeacher.setEnabled(false);
            btnFindTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() && (!txtNameTeacher.getText().isEmpty()
                || !txtAddressTeacher.getText().isEmpty() || !txtDateBirthTeacher.getText().isEmpty()
                || !txtPhoneTeacher.getText().isEmpty() || !txtEmailTeacher.getText().isEmpty()
                || !txtSalaryTeacher.getText().isEmpty() || !txtFirstDateTeacher.getText().isEmpty())) {
            btnUpdateTeacher.setEnabled(true);
        } else {
            btnUpdateTeacher.setEnabled(false);
        }
        if (!txtCodeTeacher.getText().isEmpty() || !txtNameTeacher.getText().isEmpty() || !txtAddressTeacher.getText().isEmpty() || !txtDateBirthTeacher.getText().isEmpty()
                || !txtPhoneTeacher.getText().isEmpty() || !txtEmailTeacher.getText().isEmpty() || !txtSalaryTeacher.getText().isEmpty() || !txtFirstDateTeacher.getText().isEmpty()) {
            btnResetTeacher.setEnabled(true);
        } else {
            btnResetTeacher.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty() && !txtNameSubject.getText().isEmpty()) {
            btnAddSubject.setEnabled(true);
            btnUpdateSubject.setEnabled(true);
        } else {
            btnAddSubject.setEnabled(false);
            btnUpdateSubject.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty()) {
            btnDeleteSubject.setEnabled(true);
            btnFindSubject.setEnabled(true);
        } else {
            btnDeleteSubject.setEnabled(false);
            btnFindSubject.setEnabled(false);
        }
        if (!txtCodeSubject.getText().isEmpty() || !txtNameSubject.getText().isEmpty()) {
            btnResetSubject.setEnabled(true);
        } else {
            btnResetSubject.setEnabled(false);
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
