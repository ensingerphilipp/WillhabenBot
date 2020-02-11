/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;


/**
 * Dialog for editing the server configuration
 * @author Frank Weber
 */
public class EditServerDialog extends javax.swing.JDialog {

    private JIpTextField ipInputField;
    private boolean pressedOK=false;
    private String serverIpAddress;
    /**
     * Creates new form editServerConfig
     */
    public EditServerDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        tfPort.setValue(new Integer(50519));
    }
    
    public boolean pressedOK(){
        return pressedOK;
    }
    
    public String getIpAddress(){
        return tfIP.getText();
    }
    
    public int getPort(){
        return ((Number)tfPort.getValue()).intValue();
    }
    
    public void setIP(String ip){
        tfIP.setText(ip);
    }
    
    public void setPort(int port){
        tfPort.setValue(port);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMain = new javax.swing.JPanel();
        pIPAddress = new javax.swing.JPanel();
        lbIpAddress = new javax.swing.JLabel();
        tfIP = new javax.swing.JTextField();
        pPort = new javax.swing.JPanel();
        lbPort = new javax.swing.JLabel();
        tfPort = new javax.swing.JFormattedTextField();
        pButton = new javax.swing.JPanel();
        btOK = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Server Configuration");

        pMain.setLayout(new java.awt.GridLayout(2, 0));

        lbIpAddress.setText("Server IP Address:");
        pIPAddress.add(lbIpAddress);

        tfIP = new JIpTextField();
        pIPAddress.add(tfIP);

        pMain.add(pIPAddress);

        lbPort.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPort.setIcon(new javax.swing.ImageIcon("C:\\Java\\eclipse\\Willhaben_Searchbot\\src\\media\\red_connection.png")); // NOI18N
        lbPort.setText("Server Port:");
        pPort.add(lbPort);

        tfPort.setColumns(5);
        tfPort.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####0"))));
        pPort.add(tfPort);

        pMain.add(pPort);

        getContentPane().add(pMain, java.awt.BorderLayout.CENTER);

        btOK.setText("OK");
        btOK.setFocusPainted(false);
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBT(evt);
            }
        });
        pButton.add(btOK);

        btCancel.setText("Cancel");
        btCancel.setFocusPainted(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onCancel(evt);
            }
        });
        pButton.add(btCancel);

        getContentPane().add(pButton, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onBT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBT
        if(((Number)tfPort.getValue()).intValue()<65535){
            pressedOK=true;
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Invalid Port!", "Error", JOptionPane.ERROR_MESSAGE);
            tfPort.setValue(50519);
        }
    }//GEN-LAST:event_onBT

    private void onCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onCancel
        dispose();
    }//GEN-LAST:event_onCancel

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditServerDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditServerDialog dialog = new EditServerDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOK;
    private javax.swing.JLabel lbIpAddress;
    private javax.swing.JLabel lbPort;
    private javax.swing.JPanel pButton;
    private javax.swing.JPanel pIPAddress;
    private javax.swing.JPanel pMain;
    private javax.swing.JPanel pPort;
    private javax.swing.JTextField tfIP;
    private javax.swing.JFormattedTextField tfPort;
    // End of variables declaration//GEN-END:variables
}