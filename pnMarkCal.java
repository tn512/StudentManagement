/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Preortor
 */
public class pnMarkCal extends javax.swing.JPanel {

    DefaultTableModel tb;//Khai bao
    private Connection con;//Ket noi DB
    private Statement stm; //Thuc hien cau lenh SQL
    private ResultSet rs; //Chua du lieu va xu li

    /**
     * Creates new form MarkCalc
     */
    public pnMarkCal() {
        initComponents();
        connectDB();
        tb = (DefaultTableModel) tblMark.getModel();
        tb.setRowCount(0);
    }

   public void connectDB() {
        //Lap trinh dieu khien driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String url = "jdbc:sqlserver://localhost:1433;databasename=StudentDatabase";
            String user = "tn512";
            String password = "Ngoc1234";
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connect success");
        } catch (SQLException e) {
            System.out.println("Connect not success");
        }
    }

    public boolean checkCode(String code) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select studentCode from tblStudying where studentCode='" + code + "'");
            rs.first();
            String id = String.valueOf(rs.getInt(1));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean checkStudentCode(String code) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select code from tblStudent where code='" + code + "'");
            rs.first();
            String id = String.valueOf(rs.getInt(1));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean checkSubjectCode(String code) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select code from tblSubject where code='" + code + "'");
            rs.first();
            String id = String.valueOf(rs.getInt(1));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean checkTeacherCode(String code) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select code from tblTeacher where code='" + code + "'");
            rs.first();
            String id = String.valueOf(rs.getInt(1));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean checkTerm(String code) {
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select term from tblStudent where code='" + code + "'");
            rs.first();
            String id = String.valueOf(rs.getInt(1));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void showTable() {
        try {
            stm = con.createStatement();
            String strInsert = "select ts.studentCode,tst.name,ts.subjectCode,ts.term,ts.mark from tblStudying ts,tblStudent tst where ts.studentCode=tst.code and ts.studentCode ='" + txtID.getText() + "'";
            rs = stm.executeQuery(strInsert);
            //Show table
            tb.setRowCount(0);

            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                String subjectId = rs.getString(3);
                String term = rs.getString(4);
                float mark = rs.getFloat(5);
                String status = "";
                if (mark >= 5) {
                    status = "Passed";
                } else {
                    status = "Not Passed";
                }

                tb.insertRow(tb.getRowCount(), new Object[]{code, name, subjectId, term, mark, status});
            }

        } catch (Exception e) {
            System.out.println("Search" + e.getMessage());
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

        jDialog1 = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtUpdateMark = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUpdateUpdate = new javax.swing.JButton();
        btnResetUpdate = new javax.swing.JButton();
        btnCancelUpdate = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        jDialog2 = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        txtAddClass = new javax.swing.JTextField();
        lblAddID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAddSlot = new javax.swing.JTextField();
        btnUpdateUpdate1 = new javax.swing.JButton();
        btnResetUpdate1 = new javax.swing.JButton();
        btnCancelUpdate1 = new javax.swing.JButton();
        txtAddTCode = new javax.swing.JTextField();
        lblAddID1 = new javax.swing.JLabel();
        txtAddSCode = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtAddPlace = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtAddMark = new javax.swing.JTextField();
        lblAddID2 = new javax.swing.JLabel();
        txtAddTerm = new javax.swing.JTextField();
        lblIDAdd = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMark = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Student ID:");

        txtUpdateMark.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUpdateMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUpdateMarkActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Subject Code:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Input Mark:");

        btnUpdateUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdateUpdate.setText("Update");
        btnUpdateUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUpdateActionPerformed(evt);
            }
        });

        btnResetUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnResetUpdate.setText("Reset");
        btnResetUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUpdateActionPerformed(evt);
            }
        });

        btnCancelUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelUpdate.setText("Cancel");
        btnCancelUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdateActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblID.setText("ID");

        lblCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCode.setText("Code");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(lblID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCode))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(txtUpdateMark, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btnResetUpdate)))
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelUpdate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(lblID)
                    .addComponent(lblCode)
                    .addComponent(btnUpdateUpdate))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtUpdateMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResetUpdate)
                    .addComponent(btnCancelUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Student ID:");

        txtAddClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddClassActionPerformed(evt);
            }
        });

        lblAddID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddID.setText("Subject Code:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Class:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Slot:");

        txtAddSlot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddSlot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddSlotActionPerformed(evt);
            }
        });

        btnUpdateUpdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdateUpdate1.setText("Add");
        btnUpdateUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUpdate1ActionPerformed(evt);
            }
        });

        btnResetUpdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnResetUpdate1.setText("Reset");
        btnResetUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUpdate1ActionPerformed(evt);
            }
        });

        btnCancelUpdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelUpdate1.setText("Cancel");
        btnCancelUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUpdate1ActionPerformed(evt);
            }
        });

        txtAddTCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblAddID1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddID1.setText("Teacher Code:");

        txtAddSCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Place:");

        txtAddPlace.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddPlaceActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Mark:");

        txtAddMark.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddMarkActionPerformed(evt);
            }
        });

        lblAddID2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddID2.setText("Term:");

        txtAddTerm.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblIDAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jDialog2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(92, 92, 92)
                            .addComponent(txtAddSlot, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog2Layout.createSequentialGroup()
                            .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel10))
                            .addGap(82, 82, 82)
                            .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAddPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAddClass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAddMark, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(lblAddID1)
                            .addComponent(lblAddID2))
                        .addGap(14, 14, 14)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddTCode, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtAddTerm)))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAddID)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAddSCode, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(lblIDAdd))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnUpdateUpdate1)
                .addGap(166, 166, 166)
                .addComponent(btnResetUpdate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addComponent(btnCancelUpdate1)
                .addGap(116, 116, 116))
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddSCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddID))
                .addGap(9, 9, 9)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddTCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddID1))
                .addGap(9, 9, 9)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddID2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtAddPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtAddMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtAddSlot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateUpdate1)
                    .addComponent(btnResetUpdate1)
                    .addComponent(btnCancelUpdate1))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Mark Report"));

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Enter Student ID:");

        btnReset.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblMark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Student Name", "Subject ID", "Term", "Mark", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblMark);

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(btnReset)
                    .addComponent(btnEdit)
                    .addComponent(btnExit))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Do you want to exit(Y/N)?", "Alert!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtID.setText("");
        tb.setRowCount(0);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (!checkCode(txtID.getText())) {
            JOptionPane.showMessageDialog(null, "Student ID is not existed!");
            return;
        }
        showTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtUpdateMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUpdateMarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUpdateMarkActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (tblMark.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Please choose one row in the table!");
            return;
        }
        jDialog1.setVisible(true);
        jDialog1.pack();
        lblID.setText((String) tb.getValueAt(tblMark.getSelectedRow(), 0));
        lblCode.setText((String) tb.getValueAt(tblMark.getSelectedRow(), 2));
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnUpdateUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUpdateActionPerformed
        try {
            Double.parseDouble(txtUpdateMark.getText());
            if (Double.parseDouble(txtUpdateMark.getText()) > 10 || Double.parseDouble(txtUpdateMark.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Mark must be between 0 and 10!");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mark must be number!");
            return;
        }
        try {
            stm = con.createStatement();
            String strInsert = "update tblStudying set mark='" + txtUpdateMark.getText() + "' where studentCode='" + lblID.getText() + "' and subjectCode='" + lblCode.getText() + "' ";
            stm.execute(strInsert);
            JOptionPane.showMessageDialog(null, "Update success!");
            showTable();
            pnMarkCal mc = new pnMarkCal();
            jDialog1.setVisible(false);
            mc.setVisible(true);

            return;
        } catch (Exception e) {
            System.out.println("Add" + e.getMessage());
        }

    }//GEN-LAST:event_btnUpdateUpdateActionPerformed

    private void txtAddClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddClassActionPerformed

    private void txtAddSlotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddSlotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddSlotActionPerformed

    private void btnUpdateUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUpdate1ActionPerformed
        if (txtAddClass.getText().isEmpty() || txtAddMark.getText().isEmpty() || txtAddPlace.getText().isEmpty() || txtAddSCode.getText().isEmpty() || txtAddSlot.getText().isEmpty() || txtAddTCode.getText().isEmpty() || txtAddTerm.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all information!");
            return;
        }
        if (!checkStudentCode(lblIDAdd.getText())) {
            JOptionPane.showMessageDialog(null, "No student ID found!");
            return;
        }
        if (!checkSubjectCode(txtAddSCode.getText())) {
            JOptionPane.showMessageDialog(null, "No suitable subject!");
            return;
        }
        if (!checkTeacherCode(txtAddTCode.getText())) {
            JOptionPane.showMessageDialog(null, "No suitable teacher code!");
            return;
        }
        if (!checkTerm(lblIDAdd.getText())) {
            JOptionPane.showMessageDialog(null, "Student's term is wrong!");
            return;
        }

//Thêm check class và check place ở đây
        try {
            stm = con.createStatement();
            String strInsert = "insert into tblStudying values('" + lblIDAdd.getText() + "','" + txtAddSCode.getText() + "','" + txtAddTCode.getText() + "','" + txtAddTerm.getText() + "','" + txtAddClass.getText() + "','" + txtAddPlace.getText() + "','" + Float.parseFloat(txtAddMark.getText()) + "','" + Integer.parseInt(txtAddSlot.getText()) + "')";
            stm.execute(strInsert);
            JOptionPane.showMessageDialog(null, "Insert success!");
            showTable();
            pnMarkCal mc = new pnMarkCal();
            jDialog1.setVisible(false);
            mc.setVisible(true);
        } catch (Exception e) {
            System.out.println("Add" + e.getMessage());
        }

    }//GEN-LAST:event_btnUpdateUpdate1ActionPerformed

    private void btnResetUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUpdate1ActionPerformed
        txtAddSCode.setText("");
        txtAddTCode.setText("");
        txtAddClass.setText("");
        txtAddMark.setText("");
        txtAddPlace.setText("");
        txtAddSlot.setText("");
        txtAddTerm.setText("");


    }//GEN-LAST:event_btnResetUpdate1ActionPerformed

    private void txtAddPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddPlaceActionPerformed

    private void txtAddMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddMarkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddMarkActionPerformed

    private void btnCancelUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUpdate1ActionPerformed

        pnMarkCal mc = new pnMarkCal();
        jDialog1.setVisible(false);
        mc.setVisible(true);
    }//GEN-LAST:event_btnCancelUpdate1ActionPerformed

    private void btnCancelUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUpdateActionPerformed
        pnMarkCal mc = new pnMarkCal();
        jDialog1.setVisible(false);
        mc.setVisible(true);

    }//GEN-LAST:event_btnCancelUpdateActionPerformed

    private void btnResetUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUpdateActionPerformed
        txtUpdateMark.setText("");
        
    }//GEN-LAST:event_btnResetUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelUpdate;
    private javax.swing.JButton btnCancelUpdate1;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetUpdate;
    private javax.swing.JButton btnResetUpdate1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateUpdate;
    private javax.swing.JButton btnUpdateUpdate1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddID;
    private javax.swing.JLabel lblAddID1;
    private javax.swing.JLabel lblAddID2;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblID;
    private javax.swing.JTextField lblIDAdd;
    private javax.swing.JTable tblMark;
    private javax.swing.JTextField txtAddClass;
    private javax.swing.JTextField txtAddMark;
    private javax.swing.JTextField txtAddPlace;
    private javax.swing.JTextField txtAddSCode;
    private javax.swing.JTextField txtAddSlot;
    private javax.swing.JTextField txtAddTCode;
    private javax.swing.JTextField txtAddTerm;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUpdateMark;
    // End of variables declaration//GEN-END:variables
}
