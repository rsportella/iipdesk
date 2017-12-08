package br.com.is.View;

import br.com.is.DAO.CidadeDAO;
import br.com.is.DAO.EstadoDAO;
import br.com.is.DAO.Generico;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.LogradouroDAO;
import br.com.is.DAO.PaisDAO;
import br.com.is.DAO.QueryCriteria;
import br.com.is.DAO.RealizacaoDAO;
import br.com.is.DAO.SubTipoEventoDAO;
import br.com.is.DAO.TipoEnderecoDAO;
import br.com.is.Entitys.Cidade;
import br.com.is.Entitys.Endereco;
import br.com.is.Entitys.Estado;
import br.com.is.Entitys.Evento;
import br.com.is.Entitys.Logradouro;
import br.com.is.Entitys.Pais;
import br.com.is.Entitys.Realizacao;
import br.com.is.Entitys.RealizacaoPK;
import br.com.is.Entitys.SubTipoEvento;
import br.com.is.Entitys.TipoEndereco;
import static br.com.is.View.Evento_view.tblRealizacoes;
import br.com.is.utils.ComboItens;
import br.com.is.utils.Formatacao;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import static br.com.is.View.Evento_view.btnAvanca1;

public class Realizacao_view extends javax.swing.JInternalFrame {

    Endereco end = new Endereco();
    Evento evento = new Evento();

    public Realizacao_view(Evento evento) {
        initComponents();
        this.evento = evento;

        new TipoEnderecoDAO(new TipoEndereco()).popularCombo(cmbTipoEndereco);
        new LogradouroDAO(new Logradouro()).popularCombo(cmbLogradouro);
        new PaisDAO(new Pais()).popularCombo(cmbPais);
        new SubTipoEventoDAO(new SubTipoEvento(), evento.getTipoEvento().getCodigo()).popularCombo(cmbSubTipoEvento);

        Formatacao.reformatarHora(tftHoraI);
        Formatacao.reformatarHora(tftHoraT);

        tfdCodigo.setText(String.valueOf(new GenericoDAO<Realizacao>(new Realizacao()).ProximoCodigo()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tftHoraI = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        tftHoraT = new javax.swing.JFormattedTextField();
        cmbSubTipoEvento = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCidade = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfaComplemento = new javax.swing.JTextArea();
        cmbTipoEndereco = new javax.swing.JComboBox<>();
        tfdEndereco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfdNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbLogradouro = new javax.swing.JComboBox<>();
        tfdCep = new javax.swing.JTextField();
        cmbPais = new javax.swing.JComboBox<>();
        tfdBairro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        dtcData = new com.toedter.calendar.JDateChooser();

        setTitle("Realização");
        setName(""); // NOI18N

        jLabel9.setText("Código");

        tfdCodigo.setEditable(false);

        jLabel11.setText("Descrição *");

        txaDescricao.setColumns(20);
        txaDescricao.setRows(5);
        jScrollPane6.setViewportView(txaDescricao);

        jLabel12.setText("Data *");

        jLabel13.setText("Hora de início*");

        jLabel14.setText("Hora de término *");

        jLabel15.setText("Subtipo de evento *");

        jLabel1.setText("Status");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Ativo", "2 - Aguardando aprovação", "3 - Em andamento", "4 - Cancelado", "5 - Finalizado" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setText("Cidade *");

        jLabel2.setText("Endereço *");

        cmbCidade.setName("cmbCidade"); // NOI18N

        jLabel17.setText("Local *");

        tfaComplemento.setColumns(20);
        tfaComplemento.setRows(5);
        tfaComplemento.setName("tfaComplemento"); // NOI18N
        jScrollPane1.setViewportView(tfaComplemento);

        cmbTipoEndereco.setName("cmbTipoEndereco"); // NOI18N

        tfdEndereco.setName("tfdEndereco"); // NOI18N

        jLabel18.setText("Complemento");

        jLabel3.setText("Número *");

        tfdNum.setName("tfdNum"); // NOI18N

        jLabel4.setText("CEP");

        cmbLogradouro.setName("cmbLogradouro"); // NOI18N

        tfdCep.setName("tfdCep"); // NOI18N

        cmbPais.setName("cmbPais"); // NOI18N
        cmbPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPaisItemStateChanged(evt);
            }
        });

        tfdBairro.setName("tfdBairro"); // NOI18N

        jLabel19.setText("Estado *");

        jLabel20.setText("Logradouro *");

        jLabel5.setText("Bairro");

        cmbEstado.setName("cmbEstado"); // NOI18N
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });

        jLabel21.setText("Pais *");

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

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel9)
                                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel12)
                                .addComponent(jLabel15)
                                .addComponent(jScrollPane6)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tftHoraI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(tftHoraT, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(cmbSubTipoEvento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(dtcData, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbLogradouro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfdEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(6, 6, 6)
                        .addComponent(btnSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(6, 6, 6)
                        .addComponent(cmbTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
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
                            .addComponent(jLabel21)
                            .addComponent(jLabel20))
                        .addGap(6, 6, 6)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(6, 6, 6)
                                .addComponent(cmbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dtcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tftHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tftHoraT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbSubTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1)))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair))
                .addContainerGap(15, Short.MAX_VALUE))
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

    private void cmbPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPaisItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens comboPais = (ComboItens) cmbPais.getSelectedItem();
            String[][] criterio = {{"node", "pais", "p"}, {"equal", "p.codigo", String.valueOf(comboPais.getCodigo())}};
            new EstadoDAO(new Estado()).popularCombo(cmbEstado, criterio);
        }
    }//GEN-LAST:event_cmbPaisItemStateChanged

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            ComboItens comboEstado = (ComboItens) cmbEstado.getSelectedItem();
            String[][] criterio = {{"node", "estado", "e"}, {"equal", "e.codigo", String.valueOf(comboEstado.getCodigo())}};
            new CidadeDAO(new Cidade()).popularCombo(cmbCidade, criterio);
        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();

        Realizacao rea = new Realizacao();
        rea.setDescricao(txaDescricao.getText());
        rea.setData(dtcData.getDate());
        rea.setHoraInicio(tftHoraI.getText());
        rea.setHoraTermino(tftHoraT.getText());
        rea.setStatus(cmbSubTipoEvento.getSelectedItem().toString());

        ComboItens comboSubTipo = (ComboItens) cmbSubTipoEvento.getSelectedItem();
        listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboSubTipo.getCodigo())));
        SubTipoEvento sub = new Generico<SubTipoEvento>(new SubTipoEvento()).Visualizar(listCriterias);
        listCriterias.removeAll(listCriterias);
        rea.setSubTipoEvento1(sub);

        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione uma opção");

        if (!tfdEndereco.getText().trim().isEmpty() && !tfdNum.getText().trim().isEmpty()
                && !cmbLogradouro.getSelectedItem().equals(item) && !cmbPais.getSelectedItem().equals(item)
                && !cmbEstado.getSelectedItem().equals(item) && !cmbCidade.getSelectedItem().equals(item)
                && !cmbTipoEndereco.getSelectedItem().equals(item)) {

            ComboItens comboLogradouro = (ComboItens) cmbLogradouro.getSelectedItem();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboLogradouro.getCodigo())));
            Logradouro log = new Generico<Logradouro>(new Logradouro()).Visualizar(listCriterias);
            listCriterias.removeAll(listCriterias);

            ComboItens comboCidade = (ComboItens) cmbLogradouro.getSelectedItem();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboCidade.getCodigo())));
            Cidade cid = new Generico<Cidade>(new Cidade()).Visualizar(listCriterias);
            listCriterias.removeAll(listCriterias);

            end.setRua(tfdEndereco.getText());
            end.setNumero(tfdNum.getText());
            end.setBairro(tfdBairro.getText());
            end.setCep(tfdCep.getText());
            end.setComplemento(tfaComplemento.getText());
            end.setLogradouro(log);
            end.setCidade(cid);

            listCriterias.add(new QueryCriteria("equal", "rua", end.getRua()));
            listCriterias.add(new QueryCriteria("equal", "bairro", end.getBairro()));

            Endereco existe = new Generico<Endereco>(end).Visualizar(listCriterias);
            if (existe == null) {
                new Generico<Endereco>(end).Gravar();
                existe = new Generico<Endereco>(end).Visualizar(listCriterias);
            }
            rea.setEndereco1(existe);
            System.out.println(rea);
            rea.setRealizacaoPK(new RealizacaoPK(evento.getCodigo(), existe.getCodigo(), sub.getCodigo()));
            new GenericoDAO<Realizacao>(rea).gravar();

            new RealizacaoDAO(new Realizacao()).PopulaTabela(tblRealizacoes, evento.getCodigo());

            dispose();
            btnAvanca1.setEnabled(true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbCidade;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbLogradouro;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbSubTipoEvento;
    private javax.swing.JComboBox<String> cmbTipoEndereco;
    private com.toedter.calendar.JDateChooser dtcData;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea tfaComplemento;
    private javax.swing.JTextField tfdBairro;
    private javax.swing.JTextField tfdCep;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdEndereco;
    private javax.swing.JTextField tfdNum;
    private javax.swing.JFormattedTextField tftHoraI;
    private javax.swing.JFormattedTextField tftHoraT;
    private javax.swing.JTextArea txaDescricao;
    // End of variables declaration//GEN-END:variables
}
