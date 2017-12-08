package br.com.is.View;

import br.com.is.DAO.Generico;
import br.com.is.DAO.QueryCriteria;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.Usuario;
import static br.com.is.View.JanelaPrincipal.jDesktopPane;
import br.com.is.utils.Support;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoa_usuario_view extends javax.swing.JInternalFrame {

    Pessoa pe = new Pessoa();
    Usuario user;

    public Pessoa_usuario_view(Pessoa pe) {
        initComponents();
        this.pe = pe;
        this.setEnabled(true);

        List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
        listCriterias.add(new QueryCriteria("node", "pessoa1", "pe"));
        listCriterias.add(new QueryCriteria("equal", "pe.codigo", String.valueOf(pe.getCodigo())));
        user = new Generico<Usuario>(new Usuario()).Visualizar(listCriterias);
        System.out.println(user);
        if (user != null) {
            tfdLogin.setText(user.getLogin());
            cmbStatus.setSelectedItem(user.getStatus());
        } else {
            pwfAtual.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfdLogin = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        pwfAtual = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        pwfNova = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        pwfRepita = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setTitle("Login");

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Login *");

        jLabel7.setText("Senha atual *");

        jLabel8.setText("Nova senha *");

        jLabel9.setText("Repita senha *");

        jLabel1.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Ativo", "2 - Bloqueado", "3 - Pendente" }));

        jButton1.setText("Permissões");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdLogin)
                    .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pwfNova, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pwfAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 119, Short.MAX_VALUE))
                            .addComponent(pwfRepita)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pwfAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwfNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwfRepita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        user = new Usuario(pe.getCodigo(), tfdLogin.getText());
        user.setPessoa1(pe);
        if (pwfAtual.isEnabled()) {
            user.setSenha(Support.md5Criptor(String.valueOf(pwfRepita.getPassword())));
        } else {
            user.setSenha(Support.md5Criptor(String.valueOf(pwfRepita.getPassword())));
        }
        user.setStatus(cmbStatus.getSelectedItem().toString().charAt(0));
        user.setUltimoAcesso(new Date(new Date().getTime()));
        new Generico<Usuario>(user).Gravar();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pessoa_usuario_permissao_view pupv = new Pessoa_usuario_permissao_view(user);
        Support.centralizar(jDesktopPane.add(pupv));
        pupv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField pwfAtual;
    private javax.swing.JPasswordField pwfNova;
    private javax.swing.JPasswordField pwfRepita;
    private javax.swing.JFormattedTextField tfdLogin;
    // End of variables declaration//GEN-END:variables
}
