/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package banking;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JFrame;
/**
 *
 * @author USER
 */
public final class CheckSaving extends javax.swing.JFrame {
    private int accno;
    /**
     * Creates new form CheckSaving
     * @param acc_no
     * @throws java.sql.SQLException
     */
    public CheckSaving(int acc_no) throws SQLException {
        initComponents();
        this.setTitle("Checking Saving Account");
        this.accno = acc_no;
        
                    txtSavingAccNo.setEditable(false);
                    txtInitialAm.setEditable(false);
                    txtOpenDate.setEditable(false);
                    txtDuration.setEditable(false);
                    txtSavingAccNo.setEditable(false);
                    txtInterest.setEditable(false);
                    txtCloseDate.setEditable(false);
                    txtExpect.setEditable(false);
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=PRESENT;user=sa;password=sa;encrypt=true;trustServerCertificate=true";
        
        String sql = "SELECT TOP 1 [Saving_Acc_id], [inititial_Amount], [open_date], [Duration], [Account_No] FROM [dbo].[SavingAccount] WHERE [Account_No] =?";
        System.out.println(sql);
            try (Connection connection = DriverManager.getConnection(jdbcUrl);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, acc_no);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                    int savingAccountId = resultSet.getInt("Saving_Acc_id");
                    double initialAmount = resultSet.getDouble("inititial_Amount");
                    java.sql.Date openDate = resultSet.getDate("open_date");
                    int durationMonth = resultSet.getInt("Duration");
                    int accountNo = resultSet.getInt("Account_No");

                    // Assuming you have JTextFields named txtSavingAccNo and txtOpenDate
                    txtSavingAccNo.setText(String.valueOf(savingAccountId));
                    txtInitialAm.setText(String.valueOf(initialAmount));
                    txtOpenDate.setText(openDate.toString());
                    txtDuration.setText(String.valueOf(durationMonth));
                    txtSavingAccNo.setText(String.valueOf(accountNo));
                    
                     txtSavingAccNo.setEditable(false);
                    txtInitialAm.setEditable(false);
                    txtOpenDate.setEditable(false);
                    txtDuration.setEditable(false);
                    txtSavingAccNo.setEditable(false);
                    
                        double interestRate = calculateInterestRate(initialAmount, durationMonth);
                        txtInterest.setText(String.valueOf(interestRate));
                        txtInterest.setEditable(false);
                        LocalDate openLocalDate = openDate.toLocalDate();
                        LocalDate calculatedCloseDate = CloseDateCalculator(openLocalDate, durationMonth);
                        txtCloseDate.setText(calculatedCloseDate.toString());
                        txtCloseDate.setEditable(false);
                        double expect =  calculateExpectedBalance(initialAmount, interestRate, durationMonth);
                        txtExpect.setText(String.valueOf(expect));
                        txtExpect.setEditable(false);
                }

            } catch (SQLException e) {
                    
            }
                   
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

        jLabel4 = new javax.swing.JLabel();
        txtSavingAccNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtOpenDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtInterest = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtInitialAm = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtExpect = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCloseDate = new javax.swing.JTextField();
        txtDuration = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("Saving Account No");

        txtSavingAccNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSavingAccNo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Open Date");

        txtOpenDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOpenDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 0));
        jLabel2.setText("Saving Account");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 0));
        jLabel5.setText("Close Date");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 0));
        jLabel7.setText("Interest rate");

        txtInterest.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInterest.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("Initial Amount");

        txtInitialAm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtInitialAm.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 0));
        jLabel9.setText("Expected Amount");

        txtExpect.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtExpect.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("months");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 0));
        jLabel10.setText("Duration");

        txtCloseDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtCloseDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtDuration.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDuration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDuration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDurationActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 153, 0));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSavingAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtExpect)
                                    .addComponent(txtOpenDate)
                                    .addComponent(txtInitialAm, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCloseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)))
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSavingAccNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOpenDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel3)
                        .addComponent(txtCloseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtInitialAm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExpect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Account_Information acc = new Account_Information(accno);
        acc.setVisible(true);
        acc.setLocationRelativeTo(null);
        acc.setTitle("Account Information");
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtDurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDurationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDurationActionPerformed
private double calculateInterestRate(double initialAmount, int durationMonth) {
        // Predefined interest rates for 3, 6, and 12 months
        double interestRate;
        
        interestRate = switch (durationMonth) {
            case 3 -> 3.0;
            case 6 -> 6.0;
            case 12 -> 9.0;
            default -> 0.0;
        }; 
        // Replace with your actual interest rate for 3 months
        // Replace with your actual interest rate for 6 months
        // Replace with your actual interest rate for 12 months
        // Default interest rate if duration is not 3, 6, or 12 months
        return interestRate;
}        
      
    
private double calculateExpectedBalance(double initialAmount, double interestRate, int durationMonth) {
        // Assuming interestRate is in percentage (e.g., 5 for 5%)
        double interestRateDecimal = interestRate / 100.0;
        
        // Calculate expected balance
        double expectedBalance = initialAmount + (initialAmount * interestRateDecimal * durationMonth / 12.0);
        
        return expectedBalance;
    }
public LocalDate CloseDateCalculator(LocalDate openDate, int Duration) {
        // Thời gian muốn tính 6 tháng
        Period duration = Period.ofMonths(Duration);
        // Tính close date
        return openDate.plus(duration);

}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCloseDate;
    private javax.swing.JTextField txtDuration;
    private javax.swing.JTextField txtExpect;
    private javax.swing.JTextField txtInitialAm;
    private javax.swing.JTextField txtInterest;
    private javax.swing.JTextField txtOpenDate;
    private javax.swing.JTextField txtSavingAccNo;
    // End of variables declaration//GEN-END:variables
}