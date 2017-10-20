package br.com.is.View;

import br.com.is.DAO.CidadeDAO;
import br.com.is.DAO.EstadoDAO;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.LogradouroDAO;
import br.com.is.DAO.PaisDAO;
import br.com.is.DAO.TipoEnderecoDAO;
import br.com.is.Entitys.Cidade;
import br.com.is.Entitys.Endereco;
import br.com.is.Entitys.Estado;
import br.com.is.Entitys.Logradouro;
import br.com.is.Entitys.Pais;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.PossuiEndereco;
import br.com.is.Entitys.PossuiEnderecoId;
import br.com.is.Entitys.TipoEndereco;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import utils.ComboItens;

public class Endereco_view extends javax.swing.JInternalFrame {

    TipoEndereco te = new TipoEndereco();
    Logradouro log = new Logradouro();
    Cidade cid = new Cidade();
    Endereco end = new Endereco();
    Pessoa pe;

    public Endereco_view(Pessoa pes) {
        initComponents();
        this.pe = pes;
        new TipoEnderecoDAO(te).popularCombo(cmbTipoEndereco);
        new LogradouroDAO(log).popularCombo(cmbLogradouro);
        new PaisDAO(new Pais()).popularCombo(cmbPais);
        tfdCodigo.setText(String.valueOf(new GenericoDAO<Endereco>(end).ProximoCodigo()));
    }

    public void resetField() {
        tfdEndereco.setText("");
        tfdNum.setText("");
        tfdCep.setText("");
        tfdBairro.setText("");
        tfaComplemento.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdCep = new javax.swing.JTextField();
        tfdBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbPais = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfaComplemento = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        cmbLogradouro = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoEndereco = new javax.swing.JComboBox<>();

        setTitle("Endereço");

        jLabel2.setText("Código");

        tfdCodigo.setEditable(false);

        jLabel1.setText("Rua *");

        tfdEndereco.setName("tfdEndereco"); // NOI18N

        jLabel3.setText("Número *");

        tfdNum.setName("tfdNum"); // NOI18N

        jLabel4.setText("CEP");

        tfdCep.setName("tfdCep"); // NOI18N

        tfdBairro.setName("tfdBairro"); // NOI18N

        jLabel5.setText("Bairro");

        jLabel6.setText("Pais *");

        cmbPais.setName("cmbPais"); // NOI18N
        cmbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaisItemStateChanged(evt);
            }
        });

        jLabel7.setText("Estado *");

        cmbEstado.setName("cmbEstado"); // NOI18N
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });

        jLabel8.setText("Cidade *");

        cmbCidade.setName("cmbCidade"); // NOI18N

        tfaComplemento.setColumns(20);
        tfaComplemento.setRows(5);
        tfaComplemento.setName("tfaComplemento"); // NOI18N
        jScrollPane1.setViewportView(tfaComplemento);

        jLabel9.setText("Complemento");

        btnSalvar.setText("Salvar");
        btnSalvar.setName("btnSalvar"); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnSair.setText("Fechar");
        btnSair.setName("btnSair"); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        cmbLogradouro.setName("cmbLogradouro"); // NOI18N

        jLabel10.setText("Logradouro *");

        jLabel11.setText("Tipo de endereço *");

        cmbTipoEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "1 - Casa", "2 - Trabalho", "3 - Lazer", "4 - Familiar", "5 - Outro" }));
        cmbTipoEndereco.setName("cmbTipoEndereco"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cmbLogradouro, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdNum)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(6, 6, 6)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdCep, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfdBairro))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(cmbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione uma opção");

        if (!tfdEndereco.getText().trim().isEmpty() && !tfdNum.getText().trim().isEmpty()
                && !cmbLogradouro.getSelectedItem().equals(item) && !cmbPais.getSelectedItem().equals(item)
                && !cmbEstado.getSelectedItem().equals(item) && !cmbCidade.getSelectedItem().equals(item)
                && !cmbTipoEndereco.getSelectedItem().equals(item)) {

            ComboItens comboLogradouro = (ComboItens) cmbLogradouro.getSelectedItem();
            String[][] criteriosLogradouro = {{"codigo", String.valueOf(comboLogradouro.getCodigo())}};
            log = (Logradouro) new LogradouroDAO(log).visualizar(criteriosLogradouro);

            ComboItens comboCidade = (ComboItens) cmbLogradouro.getSelectedItem();
            String[][] criteriosCidade = {{"codigo", String.valueOf(comboCidade.getCodigo())}};
            cid = (Cidade) new CidadeDAO(cid).visualizar(criteriosCidade);

            end.setRua(tfdEndereco.getText());
            end.setNumero(tfdNum.getText());
            end.setBairro(tfdBairro.getText());
            end.setCep(tfdCep.getText());
            end.setComplemento(tfaComplemento.getText());
            end.setLogradouro(log);
            end.setCidade(cid);

            String retorno = null;
            String[][] criterios = {{"rua", end.getRua()}, {"cep", end.getCep()}, {"bairro", end.getBairro()}};
            Endereco existe = new GenericoDAO<Endereco>(end).visualizar(criterios);
            if (existe == null) {
                retorno = new GenericoDAO<Endereco>(end).gravar();
                existe = new GenericoDAO<Endereco>(end).visualizar(criterios);
            }

            /**
             * Cadastro do possui endereço
             */
            PossuiEndereco pse = new PossuiEndereco();
            pse.setEndereco(existe);
            pse.setPessoa(pe);
            pse.setId(new PossuiEnderecoId(pe.getCodigo(), end.getCodigo()));

            ComboItens comboTipoEndereco = (ComboItens) cmbTipoEndereco.getSelectedItem();
            String[][] criteriosTipoEndereco = {{"codigo", String.valueOf(comboTipoEndereco.getCodigo())}};
            te = (TipoEndereco) new TipoEnderecoDAO(te).visualizar(criteriosTipoEndereco);
            pse.setTipoEndereco(te);
            retorno = new GenericoDAO<PossuiEndereco>(pse).gravar();

            JOptionPane.showMessageDialog(null, retorno);

        } else {
            JOptionPane.showMessageDialog(null, "Os campos obrigatórios devem estar todos preenchidos!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens comboEstado = (ComboItens) cmbEstado.getSelectedItem();
            String[][] criterio = {{"node", "estado", "e"}, {"equal", "e.codigo", String.valueOf(comboEstado.getCodigo())}};
            new CidadeDAO(new Cidade()).popularCombo(cmbCidade, criterio);
        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void cmbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaisItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens comboPais = (ComboItens) cmbPais.getSelectedItem();
            String[][] criterio = {{"node", "pais", "p"}, {"equal", "p.codigo", String.valueOf(comboPais.getCodigo())}};
            new EstadoDAO(new Estado()).popularCombo(cmbEstado, criterio);
        }
    }//GEN-LAST:event_cmbPaisItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCidade;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbLogradouro;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbTipoEndereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea tfaComplemento;
    private javax.swing.JTextField tfdBairro;
    private javax.swing.JTextField tfdCep;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdEndereco;
    private javax.swing.JTextField tfdNum;
    // End of variables declaration//GEN-END:variables

}
