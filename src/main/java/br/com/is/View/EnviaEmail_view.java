package br.com.is.View;

import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.GerenciarPermissao;
import br.com.is.DAO.LogradouroDAO;
import br.com.is.Entitys.EnviaEmail;
import br.com.is.Entitys.SocketServidor;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class EnviaEmail_view extends javax.swing.JInternalFrame {

    JFileChooser chooser = new JFileChooser();
    File file = null;

    public EnviaEmail_view() {
        initComponents();
        resetField();
        //GerenciarPermissao.sweepComponents(telaalertasView, "Tela de Suporte");
    }

    public void resetField() {
        jtaMensagem.setText("");
        jtaMensagem.requestFocus(true);
        jlArquivo.setText("Nenhum arquivo anexado");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        telaalertasView = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMensagem = new javax.swing.JTextArea();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        combotipo = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jlArquivo = new javax.swing.JLabel();

        setTitle("Enviar email para Suporte");
        setName("logradouroView"); // NOI18N

        telaalertasView.setName("TelaAlertasView"); // NOI18N

        jLabel1.setText("Mensagem");

        jtaMensagem.setColumns(20);
        jtaMensagem.setRows(5);
        jScrollPane1.setViewportView(jtaMensagem);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
        );

        btnEnviar.setText("Enviar");
        btnEnviar.setName("btnEnviar"); // NOI18N
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo *");

        combotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugestão", "Problema" }));
        combotipo.setToolTipText("");
        combotipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combotipoActionPerformed(evt);
            }
        });

        jButton1.setText("Anexar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlArquivo.setText("Nenhum arquivo anexado");

        javax.swing.GroupLayout telaalertasViewLayout = new javax.swing.GroupLayout(telaalertasView);
        telaalertasView.setLayout(telaalertasViewLayout);
        telaalertasViewLayout.setHorizontalGroup(
            telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaalertasViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(telaalertasViewLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(telaalertasViewLayout.createSequentialGroup()
                        .addGroup(telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(telaalertasViewLayout.createSequentialGroup()
                                .addComponent(btnEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair))
                            .addComponent(jLabel4)
                            .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        telaalertasViewLayout.setVerticalGroup(
            telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaalertasViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(telaalertasViewLayout.createSequentialGroup()
                        .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1))
                    .addComponent(jlArquivo))
                .addGap(18, 18, 18)
                .addGroup(telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaalertasView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(telaalertasView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        String attachment = file.getAbsolutePath();

        String toAddress = "jones@no2l.com.br";
        String ccAddress = "iipenvio@no2l.com.br";
        String fromAddress = "iipenvio@no2l.com.br";
        String message = jtaMensagem.getText();

        String attachments[] = attachment.split(" ");

        String Tipo = combotipo.getSelectedItem().toString();

        String titulo = "[IIP suporte]";
        String subject = titulo.concat(" - ").concat(Tipo);

        String authenticationPassword = "Chuv@100!";

        String receipients = toAddress + "," + ccAddress;
        String[] receipientsList = receipients.split(",");

        EnviaEmail mailUsingAuthentication
                = new EnviaEmail();
        try {
            //   mailUsingAuthentication.postMail(receipientsList, subject, message, fromAddress, authenticationPassword, attachments);
            mailUsingAuthentication.postMail(receipientsList, subject, message, fromAddress, authenticationPassword, attachments);
            JOptionPane.showMessageDialog(null, "Email enviado com sucesso!");
            resetField();

        } catch (MessagingException messagingException) {
            messagingException.printStackTrace();
            JOptionPane.showMessageDialog(null, "Problemas ao enviar o email.\nTente novamente mais tarde!\n");

        }

    }//GEN-LAST:event_btnEnviarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        chooser.setMultiSelectionEnabled(false);
        chooser.showOpenDialog(jFileChooser1);
        file = chooser.getSelectedFile();
        //File[] files = chooser.getSelectedFiles();        // TODO add your handling code here:
        jlArquivo.setText(file.getName());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combotipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combotipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> combotipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlArquivo;
    private javax.swing.JTextArea jtaMensagem;
    private javax.swing.JPanel telaalertasView;
    // End of variables declaration//GEN-END:variables
}
