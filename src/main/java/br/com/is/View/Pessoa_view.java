package br.com.is.View;

import br.com.is.DAO.ContatosDAO;
import br.com.is.DAO.EnderecosDAO;
import br.com.is.DAO.Generico;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.QueryCriteria;
import br.com.is.Entitys.Contato;
import br.com.is.Entitys.Endereco;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.PossuiContato;
import br.com.is.Entitys.PossuiContatoPK;
import br.com.is.Entitys.PossuiEndereco;
import br.com.is.Entitys.PossuiEnderecoPK;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.is.utils.Formatacao;
import static br.com.is.View.JanelaPrincipal.jDesktopPane;
import br.com.is.utils.Support;
import java.util.ArrayList;
import java.util.List;

public class Pessoa_view extends javax.swing.JInternalFrame {

    Pessoa pe = new Pessoa();

    public Pessoa_view() {
        initComponents();

        Formatacao.reformatarCpf(ftfCpf);
        Formatacao.reformatarData(ftfNascimento);
        resetField();
    }

    public Pessoa_view(Pessoa pes) {
        initComponents();
        Formatacao.reformatarCpf(ftfCpf);
        Formatacao.reformatarData(ftfNascimento);
        this.pe = pes;

        tfdCodigo.setText(String.valueOf(pes.getCodigo()));
        tfdNome.setText(pes.getNome());
        tfdApelido.setText(pes.getApelido());
        tfdRG.setText(pes.getRg());
        ftfCpf.setText(pes.getCpf());
        ftfNascimento.setText(Formatacao.ajustaDataDMA(String.valueOf(pes.getNascimento())));
        tfdExpedidor.setText(pes.getOrgexp());
        if (pes.getGenero() == 'M') {
            rbtM.setSelected(true);
        } else {
            rbtF.setSelected(true);
        }

        btnAdicionaContato.setEnabled(true);
        btnAdicionaEndereco.setEnabled(true);
        btnRemoveContato.setEnabled(true);
        btnRemoveEndereco.setEnabled(true);
        btnLogin.setEnabled(true);

        new ContatosDAO(new PossuiContato()).PopulaTabela(tblContatos, pe.getCodigo());
        new EnderecosDAO(new PossuiEndereco()).PopulaTabela(tblEnderecos, pe.getCodigo());
    }

    public void resetField() {
        tfdCodigo.setText(String.valueOf(new GenericoDAO<Pessoa>(pe).ProximoCodigo()));
        tfdNome.setText("");
        tfdApelido.setText("");
        tfdRG.setText("");
        ftfCpf.setText("");
        ftfNascimento.setText("");
        tfdExpedidor.setText("");
        rbtM.setSelected(true);

        btnAdicionaContato.setEnabled(false);
        btnAdicionaEndereco.setEnabled(false);
        btnRemoveContato.setEnabled(false);
        btnRemoveEndereco.setEnabled(false);
        btnLogin.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnGrupo = new javax.swing.ButtonGroup();
        btnSalvar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNome1 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        lblNascimento = new javax.swing.JLabel();
        ftfNascimento = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        ftfCpf = new javax.swing.JFormattedTextField();
        lblGenero = new javax.swing.JLabel();
        rbtF = new javax.swing.JRadioButton();
        rbtM = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lblApelido = new javax.swing.JLabel();
        tfdApelido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfdRG = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdExpedidor = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContatos = new javax.swing.JTable();
        btnAdicionaContato = new javax.swing.JButton();
        btnRemoveContato = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblEnderecos = new javax.swing.JTable();
        btnAdicionaEndereco = new javax.swing.JButton();
        btnRemoveEndereco = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();

        setTitle("Pessoa");
        setToolTipText("");

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

        lblNome1.setText("Código");

        tfdCodigo.setEnabled(false);

        lblNome.setText("Nome *");

        lblNascimento.setText("Data de nascimento *");

        lblCPF.setText("CPF");

        lblGenero.setText("Gênero");

        btnGrupo.add(rbtF);
        rbtF.setText("F - Feminino");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrupo, org.jdesktop.beansbinding.ELProperty.create("F"), rbtF, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        btnGrupo.add(rbtM);
        rbtM.setSelected(true);
        rbtM.setText("M - Masculino");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, btnGrupo, org.jdesktop.beansbinding.ELProperty.create("F"), rbtM, org.jdesktop.beansbinding.BeanProperty.create("actionCommand"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfNascimento)
                    .addComponent(tfdNome)
                    .addComponent(tfdCodigo)
                    .addComponent(ftfCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(lblCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rbtF)
                        .addGap(18, 18, 18)
                        .addComponent(rbtM))
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNome1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftfNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCPF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtF)
                    .addComponent(rbtM))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        lblApelido.setText("Apelido");

        jLabel1.setText("RG");

        jLabel5.setText("Orgão expedidor (RG)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfdRG)
                    .addComponent(tfdApelido)
                    .addComponent(tfdExpedidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApelido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblApelido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfdApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfdRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(26, 26, 26))
                    .addComponent(tfdExpedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        jLabel3.setText("Contato");

        tblContatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblContatos);

        btnAdicionaContato.setText("Adicionar");
        btnAdicionaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaContatoActionPerformed(evt);
            }
        });

        btnRemoveContato.setText("Remover");
        btnRemoveContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveContatoActionPerformed(evt);
            }
        });

        jLabel6.setText("Endereço");

        tblEnderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblEnderecos);

        btnAdicionaEndereco.setText("Adicionar");
        btnAdicionaEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaEnderecoActionPerformed(evt);
            }
        });

        btnRemoveEndereco.setText("Remover");
        btnRemoveEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdicionaContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveContato))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAdicionaEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveEndereco))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdicionaContato)
                        .addComponent(btnRemoveContato))
                    .addComponent(btnAdicionaEndereco)
                    .addComponent(btnRemoveEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnSair)
                    .addComponent(btnListar)
                    .addComponent(btnLogin))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveEnderecoActionPerformed
        if (tblEnderecos.getSelectedRow() != -1) {
            if (JOptionPane.showInternalConfirmDialog(this, "Deseja remover este endereço?",
                    "O endereço selecionado será definitivamente removido.",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                String[] endereco = tblEnderecos.getValueAt(tblEnderecos.getSelectedRow(), 0).toString().split(", ");

                List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
                listCriterias.add(new QueryCriteria("equal", "rua", endereco[0]));
                listCriterias.add(new QueryCriteria("equal", "numero", endereco[1]));
                Endereco end = new Generico<Endereco>(new Endereco()).Visualizar(listCriterias);

                PossuiEndereco pse = new PossuiEndereco(new PossuiEnderecoPK(pe.getCodigo(), end.getCodigo()));
                new Generico<PossuiEndereco>(pse).Excluir();
                new EnderecosDAO(new PossuiEndereco()).PopulaTabela(tblEnderecos, pe.getCodigo());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para efetuar a ação!");
        }
    }//GEN-LAST:event_btnRemoveEnderecoActionPerformed

    private void btnRemoveContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveContatoActionPerformed
        if (tblContatos.getSelectedRow() != -1) {
            if (JOptionPane.showInternalConfirmDialog(this, "Deseja remover este contato?",
                    "O endereço selecionado será definitivamente removido.",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                String[] contato = tblContatos.getValueAt(tblContatos.getSelectedRow(), 0).toString().split(", ");

                List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
                listCriterias.add(new QueryCriteria("equal", "contato", String.valueOf(tblContatos.getValueAt(tblContatos.getSelectedRow(), 1))));
                Contato cont = new Generico<Contato>(new Contato()).Visualizar(listCriterias);

                PossuiContato psc = new PossuiContato(new PossuiContatoPK(pe.getCodigo(), cont.getCodigo()));
                new Generico<PossuiContato>(psc).Excluir();
                new ContatosDAO(new PossuiContato()).PopulaTabela(tblContatos, pe.getCodigo());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para efetuar a ação!");
        }

    }//GEN-LAST:event_btnRemoveContatoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (!tfdCodigo.getText().trim().isEmpty() && !tfdNome.getText().trim().isEmpty()
                && !Formatacao.removerFormatacao(ftfNascimento.getText()).trim().isEmpty()) {

            try {
                pe.setNome(tfdNome.getText());
                pe.setApelido(tfdApelido.getText());
                pe.setCpf(Formatacao.removerFormatacao(ftfCpf.getText()));
                pe.setRg(tfdRG.getText());
                pe.setNascimento(Formatacao.formataDataSql(ftfNascimento.getText()));
                pe.setOrgexp(tfdExpedidor.getText());
                pe.setGenero((rbtM.isSelected()) ? 'M' : 'F');

                new Generico<Pessoa>(pe).Gravar();

                btnAdicionaContato.setEnabled(true);
                btnAdicionaEndereco.setEnabled(true);
                btnRemoveContato.setEnabled(true);
                btnRemoveEndereco.setEnabled(true);
            } catch (Exception ex) {
                Logger.getLogger(Pessoa_view.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Os campos obrigatórios devem estar todos preenchidos!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAdicionaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaContatoActionPerformed
        Contato_view conv = new Contato_view(pe);
        Support.centralizar(jDesktopPane.add(conv));
        conv.setVisible(true);
    }//GEN-LAST:event_btnAdicionaContatoActionPerformed

    private void btnAdicionaEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaEnderecoActionPerformed
        Endereco_view endv = new Endereco_view(pe);
        Support.centralizar(jDesktopPane.add(endv));
        endv.setVisible(true);
    }//GEN-LAST:event_btnAdicionaEnderecoActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        Pessoa_listar_view peliv = new Pessoa_listar_view();
        Support.centralizar(jDesktopPane.add(peliv));
        peliv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Pessoa_usuario_view usuv = new Pessoa_usuario_view(pe);
        System.out.println(pe);
        Support.centralizar(jDesktopPane.add(usuv));
        usuv.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionaContato;
    private javax.swing.JButton btnAdicionaEndereco;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRemoveContato;
    private javax.swing.JButton btnRemoveEndereco;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblApelido;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome1;
    private javax.swing.JRadioButton rbtF;
    private javax.swing.JRadioButton rbtM;
    public static javax.swing.JTable tblContatos;
    public static javax.swing.JTable tblEnderecos;
    private javax.swing.JTextField tfdApelido;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdExpedidor;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdRG;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
