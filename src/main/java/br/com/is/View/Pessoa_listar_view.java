package br.com.is.View;

import br.com.is.DAO.Generico;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.PessoaDAO;
import br.com.is.Entitys.Pessoa;
import br.com.is.utils.Wrapper;
import javax.swing.JOptionPane;
import br.com.is.utils.Formatacao;
import utils.Support;
import static br.com.is.View.JanelaPrincipal.jDesktopPane;
import br.com.is.utils.Serializacao;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Pessoa_listar_view extends javax.swing.JInternalFrame {

    Pessoa pe = new Pessoa();

    public Pessoa_listar_view() {
        initComponents();
        new PessoaDAO(pe).PopulaTabela(tblConsulta, null);
        ftfBusca.requestFocus(true);
        btnSelecionar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        background = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnBloquear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        rbtNome = new javax.swing.JRadioButton();
        rbtCpf = new javax.swing.JRadioButton();
        btnLocalizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        ftfBusca = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnSelecionar1 = new javax.swing.JButton();
        btnSelecionar2 = new javax.swing.JButton();

        setTitle("Listar pessoas");
        setToolTipText("");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnBloquear.setText("Bloquear");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");

        jLabel1.setText("Buscar");

        btnGrupo.add(rbtNome);
        rbtNome.setSelected(true);
        rbtNome.setText("Nome");
        rbtNome.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtNomeItemStateChanged(evt);
            }
        });

        btnGrupo.add(rbtCpf);
        rbtCpf.setText("CPF");
        rbtCpf.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtCpfItemStateChanged(evt);
            }
        });

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
            }
        });

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblConsulta);

        btnSelecionar1.setText("Exportar");
        btnSelecionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionar1ActionPerformed(evt);
            }
        });

        btnSelecionar2.setText("Importar");
        btnSelecionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(rbtNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtCpf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftfBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocalizar))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSair)
                            .addComponent(jLabel1)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(btnAdicionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBloquear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelecionar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSelecionar2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtNome)
                    .addComponent(rbtCpf)
                    .addComponent(btnLocalizar)
                    .addComponent(ftfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnBloquear)
                    .addComponent(btnEditar)
                    .addComponent(btnSelecionar)
                    .addComponent(btnSelecionar1)
                    .addComponent(btnSelecionar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        if (rbtCpf.isSelected()) {
            String[][] criterios = {{"equal", "cpf", Formatacao.removerFormatacao(ftfBusca.getText())}};
            new PessoaDAO(pe).PopulaTabela(tblConsulta, criterios);
        } else {
            String[][] criterios = {{"contain", "nome", "%" + ftfBusca.getText() + "%"}};
            new PessoaDAO(pe).PopulaTabela(tblConsulta, criterios);
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void rbtCpfItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtCpfItemStateChanged
        if (this.isSelected()) {
            Formatacao.reformatarCpf(ftfBusca);
        }
    }//GEN-LAST:event_rbtCpfItemStateChanged

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Pessoa_view pev = new Pessoa_view();
        Support.centralizar(jDesktopPane.add(pev));
        pev.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblConsulta.getSelectedRow() != -1) {
            String[][] criterios = {{"codigo", String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0))}};
            this.pe = (Pessoa) new GenericoDAO<Pessoa>(pe).visualizar(criterios);

            Pessoa_view pev = new Pessoa_view(this.pe);
            Support.centralizar(jDesktopPane.add(pev));
            pev.setVisible(true);

            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para efetuar a ação!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void rbtNomeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtNomeItemStateChanged
        if (this.isSelected) {
            ftfBusca.setFormatterFactory(null);
        }
    }//GEN-LAST:event_rbtNomeItemStateChanged

    private void btnSelecionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionar1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
                "Arquivos XML  (*.xml)", "xml");
        fileChooser.setDialogTitle("Salvar arquivo .XML");
        fileChooser.setFileFilter(xmlfilter);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String arquivo = fileChooser.getSelectedFile() + ".xml";
// salvar   
            try {
                List<Pessoa> pessoas = new Generico<Pessoa>(new Pessoa()).Listar(null);
                JAXBContext jc = JAXBContext.newInstance(Wrapper.class, Pessoa.class);

                // Marshal
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                Serializacao.FileGerator(marshaller, pessoas, "pessoas", arquivo);

            } catch (JAXBException ex) {
                Logger.getLogger(Pessoa_listar_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSelecionar1ActionPerformed

    private void btnSelecionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionar2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
                "Arquivos XML  (*.xml)", "xml");
        fileChooser.setDialogTitle("Abrir arquivo .XML");
        fileChooser.setFileFilter(xmlfilter);
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(false);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                JAXBContext jc = JAXBContext.newInstance(Wrapper.class, Pessoa.class);
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                List<Pessoa> pessoas = Serializacao.FileLoger(unmarshaller,
                        Pessoa.class, fileChooser.getSelectedFile().getAbsolutePath());
                for (Pessoa ps : pessoas) {
                    new Generico<Pessoa>(ps).Gravar();
                }

            } catch (JAXBException ex) {
                Logger.getLogger(Pessoa_listar_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSelecionar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnSelecionar1;
    private javax.swing.JButton btnSelecionar2;
    private javax.swing.JFormattedTextField ftfBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbtCpf;
    private javax.swing.JRadioButton rbtNome;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
