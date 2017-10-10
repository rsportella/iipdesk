package br.com.is.View;

import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.GerenciarPermissao;
import br.com.is.DAO.TipoContatoDAO;
import br.com.is.Entitys.TipoContato;
import javax.swing.JOptionPane;
import br.com.is.utils.Formatacao;

public class TipoContato_view extends javax.swing.JInternalFrame {

    TipoContato tc = new TipoContato();

    public TipoContato_view() {
        initComponents();
        Formatacao.reformatarSigla(tfdSigla);
        resetField();
        GerenciarPermissao.sweepComponents(tipocontatoView, "Tipo Contato");
    }

    public void resetField() {
        tfdSigla.setText("");
        tfdTitulo.setText("");
        tfdBuscar.setText("");
        tfdSigla.requestFocus(true);
        tc = new TipoContato();
        tfdCodigo.setText(String.valueOf(new GenericoDAO<TipoContato>(tc).ProximoCodigo()));
        new TipoContatoDAO(tc).PopulaTabela(tblConsulta, null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipocontatoView = new javax.swing.JPanel();
        tfdCodigo = new javax.swing.JTextField();
        tfdTitulo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfdSigla = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tfdBuscar = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();

        setTitle("Tipo de contatos");

        tfdCodigo.setEditable(false);

        jLabel6.setText("Sigla *");

        tfdSigla.setName("inpSigla"); // NOI18N

        jLabel2.setText("Código");

        jLabel4.setText("Titulo *");

        jLabel5.setText("Descrição");

        txaDescricao.setColumns(20);
        txaDescricao.setRows(5);
        jScrollPane2.setViewportView(txaDescricao);

        jLabel1.setText("Procurar");

        btnBusca.setText("Buscar");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblConsulta);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

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

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tipocontatoViewLayout = new javax.swing.GroupLayout(tipocontatoView);
        tipocontatoView.setLayout(tipocontatoViewLayout);
        tipocontatoViewLayout.setHorizontalGroup(
            tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipocontatoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(tfdTitulo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tipocontatoViewLayout.createSequentialGroup()
                        .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tipocontatoViewLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 106, Short.MAX_VALUE))
                            .addComponent(tfdSigla)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tipocontatoViewLayout.createSequentialGroup()
                        .addComponent(tfdBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca))
                    .addGroup(tipocontatoViewLayout.createSequentialGroup()
                        .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addGroup(tipocontatoViewLayout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair))
                            .addGroup(tipocontatoViewLayout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tipocontatoViewLayout.setVerticalGroup(
            tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tipocontatoViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tipocontatoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tipocontatoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tipocontatoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblConsulta.getSelectedRow() != -1) {
            String[][] criterios = {{"codigo", String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0))}};
            tc = (TipoContato) new GenericoDAO<TipoContato>(tc)
                    .visualizar(criterios);
            tfdCodigo.setText(String.valueOf(tc.getCodigo()));
            tfdTitulo.setText(tc.getNome());
            tfdSigla.setText(tc.getSigla());
            txaDescricao.setText(tc.getDescricao());
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para efetuar a ação!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        resetField();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        String[][] criterio = {{"contain", "nome", "%" + tfdBuscar.getText() + "%"}};
        new TipoContatoDAO(tc).PopulaTabela(tblConsulta, criterio);
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!tfdTitulo.getText().trim().equals("") && !tfdSigla.getText().trim().equals("__")) {

            tc.setNome(tfdTitulo.getText());
            tc.setSigla(tfdSigla.getText());
            tc.setDescricao(txaDescricao.getText());

            JOptionPane.showMessageDialog(null, new GenericoDAO<TipoContato>(tc).gravar());

            resetField();
        } else {
            JOptionPane.showMessageDialog(null, "Os campos obrigatórios devem estar todos preenchidos!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField tfdBuscar;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JFormattedTextField tfdSigla;
    private javax.swing.JTextField tfdTitulo;
    private javax.swing.JPanel tipocontatoView;
    private javax.swing.JTextArea txaDescricao;
    // End of variables declaration//GEN-END:variables
}
