package br.com.is.View;

import br.com.is.DAO.Generico;
import br.com.is.DAO.PessoaDAO;
import br.com.is.DAO.QueryCriteria;
import br.com.is.DAO.ResponsavelDAO;
import br.com.is.Entitys.Evento;
import br.com.is.Entitys.Pessoa;
import br.com.is.Entitys.Responsavel;
import br.com.is.Entitys.ResponsavelPK;
import static br.com.is.View.Evento_view.tblContratantes;
import br.com.is.utils.Wrapper;
import javax.swing.JOptionPane;
import static br.com.is.View.JanelaPrincipal.jDesktopPane;
import br.com.is.utils.Serializacao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import static br.com.is.View.Evento_view.btnAvanca2;
import br.com.is.utils.Support;

public class Pessoa_listar_view extends javax.swing.JInternalFrame {

    Pessoa pe = new Pessoa();
    private String frame;
    private Evento evento;
    QueryCriteria criterio = new QueryCriteria("contain", "nome", "%%");

    public Pessoa_listar_view() {
        initComponents();
        new PessoaDAO(pe).PopulaTabela(tblConsulta, criterio);
        jTextField2.requestFocus(true);
        btnSelecionar.setEnabled(false);
    }

    public Pessoa_listar_view(String frame) {
        initComponents();
        new PessoaDAO(pe).PopulaTabela(tblConsulta, criterio);
        jTextField2.requestFocus(true);
        btnSelecionar.setEnabled(true);
        this.frame = frame;
    }

    public Pessoa_listar_view(String frame, Evento evento) {
        initComponents();
        new PessoaDAO(pe).PopulaTabela(tblConsulta, criterio);
        jTextField2.requestFocus(true);
        btnSelecionar.setEnabled(true);
        this.frame = frame;
        this.evento = evento;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupo = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        background = new javax.swing.JPanel();
        btnAdicionar = new javax.swing.JButton();
        btnBloquear = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSelecionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLocalizar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnExportar = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

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
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar");

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

        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnImportar.setText("Importar");
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addComponent(btnExportar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnImportar)))
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
                    .addComponent(btnLocalizar)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnBloquear)
                    .addComponent(btnEditar)
                    .addComponent(btnSelecionar)
                    .addComponent(btnExportar)
                    .addComponent(btnImportar))
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
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        QueryCriteria criterio = new QueryCriteria("contain", "nome", "%" + jTextField2.getText() + "%");
        new PessoaDAO(pe).PopulaTabela(tblConsulta, criterio);
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Pessoa_view pev = new Pessoa_view();
        Support.centralizar(jDesktopPane.add(pev));
        pev.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tblConsulta.getSelectedRow() != -1) {
            List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
            listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0))));

            this.pe = new Generico<Pessoa>(new Pessoa()).Visualizar(listCriterias);
            Pessoa_view pev = new Pessoa_view(this.pe);
            Support.centralizar(jDesktopPane.add(pev));
            pev.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para efetuar a ação!");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
                "Arquivos XML  (*.xml)", "xml");
        fileChooser.setDialogTitle("Salvar arquivo .XML");
        fileChooser.setFileFilter(xmlfilter);
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String arquivo = fileChooser.getSelectedFile() + ".xml";
            try {
                List<Pessoa> pessoas = new Generico<Pessoa>(new Pessoa()).Listar(null);
                JAXBContext jc = JAXBContext.newInstance(Wrapper.class, Pessoa.class);
                Marshaller marshaller = jc.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                Serializacao.FileGerator(marshaller, pessoas, "pessoas", arquivo);
            } catch (JAXBException ex) {
                Logger.getLogger(Pessoa_listar_view.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
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
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        List<QueryCriteria> criterios = new ArrayList<QueryCriteria>();
        criterios.add(new QueryCriteria("equal", "codigo", String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0))));
        pe = (Pessoa) new Generico<Pessoa>(pe).Visualizar(criterios);
        switch (frame) {
            case "equipe":
                Equipe_view.ps = pe;
                Equipe_view.ftfCpf.setText(pe.getCpf());
                Equipe_view.tfdNome.setText(pe.getNome());
                dispose();
                break;
            case "evento":
                Responsavel resp = new Responsavel();
                resp.setEvento1(this.evento);
                resp.setPessoa(this.pe);
                resp.setTipo("");
                resp.setResponsavelPK(new ResponsavelPK(evento.getCodigo(), pe.getCodigo()));
                new Generico<Responsavel>(resp).Gravar();

                new ResponsavelDAO(new Responsavel()).PopulaTabela(tblContratantes, evento.getCodigo());

                btnAvanca2.setEnabled(true);
                dispose();
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBloquear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExportar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tblConsulta;
    // End of variables declaration//GEN-END:variables
}
