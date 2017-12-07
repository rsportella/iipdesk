package br.com.is.View;

import br.com.is.DAO.CidadeDAO;
import br.com.is.DAO.EnderecosDAO;
import br.com.is.DAO.EstadoDAO;
import br.com.is.DAO.Generico;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.LogradouroDAO;
import br.com.is.DAO.PaisDAO;
import br.com.is.DAO.QueryCriteria;
import br.com.is.DAO.TipoEnderecoDAO;
import br.com.is.Entitys.Cidade;
import br.com.is.Entitys.Endereco;
import br.com.is.Entitys.Estado;
import br.com.is.Entitys.Logradouro;
import br.com.is.Entitys.Pais;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.PossuiEndereco;
import br.com.is.Entitys.PossuiEnderecoPK;
import br.com.is.Entitys.TipoEndereco;
import static br.com.is.View.Pessoa_view.tblEnderecos;
import br.com.is.utils.ComboItens;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Endereco_view extends javax.swing.JInternalFrame {

    TipoEndereco te = new TipoEndereco();
    Logradouro log = new Logradouro();
    Cidade cid = new Cidade();
    Endereco end = new Endereco();
    Pessoa pe;

    public Endereco_view(Pessoa pes) {
        initComponents();
        System.out.println(pes);
        this.pe = pes;
        System.out.println(pe);
        new TipoEnderecoDAO(te).popularCombo(cmbTipoEndereco);
        new LogradouroDAO(log).popularCombo(cmbLogradouro);
        new PaisDAO(new Pais()).popularCombo(cmbPais);
        tfdCodigo.setText(String.valueOf(new GenericoDAO<Endereco>(end).ProximoCodigo()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbTipoEndereco = new javax.swing.JComboBox<>();
        tfdEndereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfdNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdCep = new javax.swing.JTextField();
        tfdBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setTitle("Endereço");

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

        jLabel2.setText("Código");

        jLabel10.setText("Logradouro *");

        tfdCodigo.setEditable(false);

        jLabel1.setText("Endereco *");

        jLabel11.setText("Tipo de endereço *");

        cmbTipoEndereco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "1 - Casa", "2 - Trabalho", "3 - Lazer", "4 - Familiar", "5 - Outro" }));
        cmbTipoEndereco.setName("cmbTipoEndereco"); // NOI18N

        tfdEndereco.setName("tfdEndereco"); // NOI18N

        jLabel3.setText("Número *");

        tfdNum.setName("tfdNum"); // NOI18N

        jLabel4.setText("CEP");

        tfdCep.setName("tfdCep"); // NOI18N

        tfdBairro.setName("tfdBairro"); // NOI18N

        jLabel5.setText("Bairro");

        jLabel6.setText("Pais *");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipoEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdNum)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdCep)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdBairro)))
                    .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(6, 6, 6)
                        .addComponent(btnSair))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(cmbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione uma opção");

        List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();

        if (!tfdEndereco.getText().trim().isEmpty() && !tfdNum.getText().trim().isEmpty()
                && !cmbLogradouro.getSelectedItem().equals(item) && !cmbPais.getSelectedItem().equals(item)
                && !cmbEstado.getSelectedItem().equals(item) && !cmbCidade.getSelectedItem().equals(item)
                && !cmbTipoEndereco.getSelectedItem().equals(item)) {

            ComboItens comboLogradouro = (ComboItens) cmbLogradouro.getSelectedItem();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboLogradouro.getCodigo())));
            log = new Generico<Logradouro>(new Logradouro()).Visualizar(listCriterias);
            listCriterias.removeAll(listCriterias);

            ComboItens comboCidade = (ComboItens) cmbCidade.getSelectedItem();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboCidade.getCodigo())));
            cid = new Generico<Cidade>(new Cidade()).Visualizar(listCriterias);
            listCriterias.removeAll(listCriterias);

            end.setRua(tfdEndereco.getText());
            end.setNumero(tfdNum.getText());
            end.setBairro(tfdBairro.getText());
            end.setCep(tfdCep.getText());
            end.setComplemento(tfaComplemento.getText());
            end.setLogradouro(log);
            end.setCidade(cid);

            listCriterias.add(new QueryCriteria("equal", "rua", end.getRua()));
            listCriterias.add(new QueryCriteria("equal", "cep", end.getCep()));
            listCriterias.add(new QueryCriteria("equal", "bairro", end.getBairro()));
            Endereco existe = new Generico<Endereco>(new Endereco()).Visualizar(listCriterias);

            if (existe == null) {
                new Generico<Endereco>(end).Gravar();
                existe = new Generico<Endereco>(new Endereco()).Visualizar(listCriterias);
            }
            listCriterias.removeAll(listCriterias);

            /**
             * Cadastro do possui endereço
             */
            PossuiEndereco pse = new PossuiEndereco();
            pse.setEndereco1(existe);
            pse.setPessoa(pe);
            pse.setPossuiEnderecoPK(new PossuiEnderecoPK(pe.getCodigo(), end.getCodigo()));

            ComboItens comboTipoEndereco = (ComboItens) cmbTipoEndereco.getSelectedItem();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboTipoEndereco.getCodigo())));
            te = new Generico<TipoEndereco>(new TipoEndereco()).Visualizar(listCriterias);
            pse.setTipoendereco(te);
            new Generico<PossuiEndereco>(pse).Gravar();

            new EnderecosDAO(new PossuiEndereco()).PopulaTabela(tblEnderecos, pe.getCodigo());

            dispose();

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
    private javax.swing.JPanel background;
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
