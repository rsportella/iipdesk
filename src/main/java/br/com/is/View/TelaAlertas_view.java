package br.com.is.View;

import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.GerenciarPermissao;
import br.com.is.DAO.LogradouroDAO;
import br.com.is.Entitys.SocketServidor;
import javax.swing.JOptionPane;

public class TelaAlertas_view extends javax.swing.JInternalFrame {

    SocketServidor servidor = null;
    String senha = "axy9b10";

    public TelaAlertas_view() {
        initComponents();
        resetField();
        GerenciarPermissao.sweepComponents(telaalertasView, "Tela de Alertas");
    }

    public void resetField() {
        inpMensagem.setText("");
        inpMensagem.requestFocus(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaalertasView = new javax.swing.JPanel();
        tfdIp = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inpMensagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        combotipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setTitle("Enviar Mensagem/Alerta");
        setName("logradouroView"); // NOI18N

        telaalertasView.setName("TelaAlertasView"); // NOI18N

        tfdIp.setText("10.2.2.2");

        jLabel1.setText("Mensagem");

        jLabel4.setText("Tipo *");

        combotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aviso", "Alerta" }));
        combotipo.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inpMensagem)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inpMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("IP de destino");

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

        javax.swing.GroupLayout telaalertasViewLayout = new javax.swing.GroupLayout(telaalertasView);
        telaalertasView.setLayout(telaalertasViewLayout);
        telaalertasViewLayout.setHorizontalGroup(
            telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaalertasViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(telaalertasViewLayout.createSequentialGroup()
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair))
                    .addComponent(tfdIp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        telaalertasViewLayout.setVerticalGroup(
            telaalertasViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telaalertasViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
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

        servidor = new SocketServidor(tfdIp.getText(), 5500, null);
        servidor.start();

        String Tipo = combotipo.getSelectedItem().toString();
        String Mensagem = inpMensagem.getText();

        String MensagemCompleta = senha.concat("|").concat(Tipo).concat("|").concat(Mensagem);

        servidor.definirMensagem(MensagemCompleta);
        servidor.definirEnvio(true);

        inpMensagem.setText("");
        inpMensagem.requestFocus();
        //}
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> combotipo;
    private javax.swing.JTextField inpMensagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel telaalertasView;
    private javax.swing.JFormattedTextField tfdIp;
    // End of variables declaration//GEN-END:variables
}
