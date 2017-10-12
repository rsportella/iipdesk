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
        // GerenciarPermissao.sweepComponents(telaAlertasView, "Logradouro");
    }

    public void resetField() {
        //tfdIp.setText("");
        tfdMensagem.setText("");
        tfdMensagem.requestFocus(true);
        //tfdIp.requestFocus(true);
        //log = new Logradouro();
        // tfdCodigo.setText(String.valueOf(new GenericoDAO<Logradouro>(log).ProximoCodigo()));
        // new LogradouroDAO(log).PopulaTabela(tblConsulta, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logradouroView = new javax.swing.JPanel();
        tfdIp = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdMensagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcombotipo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setTitle("Enviar Mensagem/Alerta");
        setName("logradouroView"); // NOI18N

        logradouroView.setName("TelaAlertasView"); // NOI18N

        tfdIp.setText("10.2.2.2");

        jLabel1.setText("Mensagem");

        jLabel4.setText("Tipo *");

        jcombotipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aviso", "Alerta" }));
        jcombotipo.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfdMensagem)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jcombotipo, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcombotipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        javax.swing.GroupLayout logradouroViewLayout = new javax.swing.GroupLayout(logradouroView);
        logradouroView.setLayout(logradouroViewLayout);
        logradouroViewLayout.setHorizontalGroup(
            logradouroViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logradouroViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(logradouroViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(logradouroViewLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(logradouroViewLayout.createSequentialGroup()
                        .addGroup(logradouroViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(logradouroViewLayout.createSequentialGroup()
                                .addComponent(btnEnviar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair))
                            .addComponent(tfdIp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        logradouroViewLayout.setVerticalGroup(
            logradouroViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logradouroViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(logradouroViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logradouroView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logradouroView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        //if (!tfdNome.getText().trim().equals("") && !tfdSigla.getText().trim().equals("__")) {
        //   log.setNome(tfdNome.getText());
        //   log.setSigla(tfdSigla.getText());

        //  JOptionPane.showMessageDialog(null, new GenericoDAO<Logradouro>(log).gravar());
        //    resetField();
        //  } else {
        //    JOptionPane.showMessageDialog(null, "Os campos obrigatórios devem estar todos preenchidos!");
        //  }
        //  if (rbtServidor.isSelected()) {
        servidor = new SocketServidor(tfdIp.getText(), 5500, null);
        servidor.start();

        String Tipo = jcombotipo.getSelectedItem().toString();
        String Mensagem = tfdMensagem.getText();

        String MensagemCompleta = senha.concat("|").concat(Tipo).concat("|").concat(Mensagem);

        servidor.definirMensagem(MensagemCompleta);
        servidor.definirEnvio(true);

        tfdMensagem.setText("");
        tfdMensagem.requestFocus();
        //}
    }//GEN-LAST:event_btnEnviarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcombotipo;
    private javax.swing.JPanel logradouroView;
    private javax.swing.JFormattedTextField tfdIp;
    private javax.swing.JTextField tfdMensagem;
    // End of variables declaration//GEN-END:variables
}
