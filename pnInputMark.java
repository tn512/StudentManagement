package studentmanagementsystem;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phans
 */
public class pnInputMark extends javax.swing.JPanel {

    private Connection con; //Ket noi DB
    private Statement stm; //Thuc hien cau lenh SQL
    private ResultSet rs; //Chua du lieu va xu ly
    DefaultTableModel tblS;

    /**
     * Creates new form PRJ
     */
    public pnInputMark() {
        initComponents();
        connectDB();

        tblS = (DefaultTableModel) tblStudent.getModel();

        cboSubject.removeAllItems();
        showTable();
        int count = tblS.getRowCount();

        for (int i = 0; i < count; i++) {

            cboSubject.addItem(tblS.getValueAt(i, 1).toString());
        }
        tblS.setRowCount(0);

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

    public void showTable() {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblStudying");
            //Add du lieu vao Frame
            tblS.setRowCount(0);
            while (rs.next()) {
                String studentCode = rs.getString(1);
                String subjectCode = rs.getString(2);
                String teacherCode = String.valueOf(rs.getString(3));
                String term = rs.getString(4);
                String clas = rs.getString(5);
                String place = rs.getString(6);
                String mark = String.valueOf(rs.getFloat(7));
                String slot = String.valueOf(rs.getInt(8));

                tblS.insertRow(tblS.getRowCount(), new Object[]{studentCode, subjectCode, clas, mark});
            }
        } catch (Exception e) {
            System.out.println("Show table: " + e.getMessage());
        }
    }

    public void showTable2(String a) {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblStudying " + a + "");
            //Add du lieu vao Frame
            tblS.setRowCount(0);
            while (rs.next()) {
                String studentCode = rs.getString(1);
                String subjectCode = rs.getString(2);
                String teacherCode = String.valueOf(rs.getString(3));
                String term = rs.getString(4);
                String clas = rs.getString(5);
                String place = rs.getString(6);
                String mark = String.valueOf(rs.getFloat(7));
                String slot = String.valueOf(rs.getInt(8));

                tblS.insertRow(tblS.getRowCount(), new Object[]{studentCode, subjectCode, clas, mark});
            }
        } catch (Exception e) {
            System.out.println("Show table: " + e.getMessage());
        }
    }

    public void showTableWhere(String col, String value) {
        try {
            //Select du lieu trong bang tblSubject
            stm = con.createStatement();
            rs = stm.executeQuery("Select * from tblStudying where " + col + " = '" + value + "' ");
            //Add du lieu vao Frame
            tblS.setRowCount(0);
            while (rs.next()) {
                String studentCode = rs.getString(1);
                String subjectCode = rs.getString(2);
                String teacherCode = String.valueOf(rs.getString(3));
                String term = rs.getString(4);
                String clas = rs.getString(5);
                String place = rs.getString(6);
                String mark = String.valueOf(rs.getFloat(7));
                String slot = String.valueOf(rs.getInt(8));

                tblS.insertRow(tblS.getRowCount(), new Object[]{studentCode, subjectCode, term, clas, place, mark, slot});
            }
        } catch (Exception e) {
            System.out.println("Show table: " + e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cboSubject = new javax.swing.JComboBox<>();
        txtClass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INPUT MARK");

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Code", "Subject Code", "Class", "Mark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblStudent);

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Input mark:");

        cboSubject.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboSubject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        txtClass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Class:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Subject:");

        txtInput.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInputActionPerformed(evt);
            }
        });

        btnEnter.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnEnter.setText("Update");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel5.setText("Select student(s) from table above");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSearch))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEnter)))
                        .addContainerGap(39, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cboSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassActionPerformed

    private void txtInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInputActionPerformed
    public boolean checkExistClass(String Class) {
        //true - ID ton tai
        //false - ID chua ton tai
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select * from  tblStudying where class = '" + Class + "' ");
            rs.first();
            String a = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkExistClassandSub(String Class, String sub) {
        //true - ID ton tai
        //false - ID chua ton tai
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("select * from  tblStudying where class = '" + Class + "' and subjectCode = '" + sub + "' ");
            rs.first();
            String a = rs.getString(1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:

        if (checkExistClass(txtClass.getText())) {
            if (cboSubject.getSelectedItem() != null) {

                if (checkExistClassandSub(txtClass.getText(), cboSubject.getSelectedItem().toString())) {
                    tblS.setRowCount(0);
                    try {
                        //check tính hợp lệ của người dùng
                        String teacherId = JOptionPane.showInputDialog("Enter Teacher ID");
                        if (teacherId.equals(rs.getString(3))) {
                            tblS.setRowCount(0);
                            showTable2("where class = '" + txtClass.getText() + "' and subjectCode ='" + cboSubject.getSelectedItem().toString() + "' ");
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "You don't have access to this, go away creep");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(pnInputMark.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "This class doesn't study this subject");
                    tblS.setRowCount(0);
                }

            } else {
                JOptionPane.showMessageDialog(this, "No subject found");
            }

        } else {
            JOptionPane.showMessageDialog(this, "No class found");
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        try {
            
            stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery("update tblStudyding set mark = "+Integer.parseInt(txtInput.getText())+" where (class = '"+txtClass.getText()+ "' and subject = "+cboSubject.getSelectedItem().toString()+")");
            showTable2("where class = '" + txtClass.getText() + "' and subjectCode ='" + cboSubject.getSelectedItem().toString() + "' ");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Redo please");
        }
    }//GEN-LAST:event_btnEnterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cboSubject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtClass;
    private javax.swing.JTextField txtInput;
    // End of variables declaration//GEN-END:variables

}
