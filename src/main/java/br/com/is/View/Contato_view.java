package br.com.is.View;

import br.com.is.DAO.ContatoDAOs;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.GerenciarPermissao;
import br.com.is.DAO.TipoContatoDAO;
import br.com.is.Entitys.Contato;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.PossuiContato;
import br.com.is.Entitys.PossuiContatoId;
import br.com.is.Entitys.TipoContato;
import javax.swing.JOptionPane;
import utils.ComboItens;

public class Contato_view extends javax.swing.JInternalFrame {

    TipoContato tc = new TipoContato();
    Contato ctt = new Contato();
    Pessoa pe;

    public Contato_view(Pessoa pes) {
        initComponents();
        this.pe = pes;
        resetField();
        GerenciarPermissao.sweepComponents(contatoView, "Contato");
        new TipoContatoDAO(tc).popularCombo(cmbTipo);
    }

    public void resetField() {
        inpContato.setText("");
        inpDescricao.setText("");
        inpContato.requestFocus(true);
        ctt = new Contato();
        tfdCodigo.setText(String.valueOf(new GenericoDAO<Contato>(ctt).ProximoCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contatoView = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inpContato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        inpDescricao = new javax.swing.JTextArea();
        cmbTipo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Contato");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel12.setText("Contato *");

        jLabel13.setText("Descrição");

        inpDescricao.setColumns(20);
        inpDescricao.setRows(5);
        jScrollPane1.setViewportView(inpDescricao);

        jLabel11.setText("Tipo de contato *");

        tfdCodigo.setEditable(false);

        jLabel2.setText("Código");

        javax.swing.GroupLayout contatoViewLayout = new javax.swing.GroupLayout(contatoView);
        contatoView.setLayout(contatoViewLayout);
        contatoViewLayout.setHorizontalGroup(
            contatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contatoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipo, 0, 297, Short.MAX_VALUE)
                    .addComponent(inpContato)
                    .addComponent(jScrollPane1)
                    .addGroup(contatoViewLayout.createSequentialGroup()
                        .addGroup(contatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addGroup(contatoViewLayout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(6, 6, 6)
                                .addComponent(btnSair))
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contatoViewLayout.setVerticalGroup(
            contatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contatoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inpContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contatoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contatoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!inpContato.getText().trim().equals("")) {
            ctt.setContato(inpContato.getText());
            ctt.setDescricao(inpDescricao.getText());
            
            String retorno;
            String[][] criterios = {{"contato", ctt.getContato()}};
            Contato existe = new GenericoDAO<Contato>(ctt).visualizar(criterios);
            if (existe == null) {
                retorno = new GenericoDAO<Contato>(ctt).gravar();
                existe = new GenericoDAO<Contato>(ctt).visualizar(criterios);
            }

            PossuiContato pc = new PossuiContato();
            pc.setId(new PossuiContatoId(pe.getCodigo(), existe.getCodigo()));
            pc.setContato(existe);
            pc.setPessoa(pe);

            ComboItens comboTipoContato = (ComboItens) cmbTipo.getSelectedItem();
            String[][] criteriosTipoContato = {{"codigo", String.valueOf(comboTipoContato.getCodigo())}};
            tc = (TipoContato) new ContatoDAOs(tc).visualizar(criteriosTipoContato);

            pc.setTipoContato(tc);
            retorno = new GenericoDAO<PossuiContato>(pc).gravar();

            JOptionPane.showMessageDialog(null, null);

            resetField();
        } else {
            JOptionPane.showMessageDialog(null, "Os campos obrigatórios devem estar todos preenchidos!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JPanel contatoView;
    private javax.swing.JTextField inpContato;
    private javax.swing.JTextArea inpDescricao;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdCodigo;
    // End of variables declaration//GEN-END:variables
}
