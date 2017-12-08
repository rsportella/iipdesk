package br.com.is.View;

import br.com.is.DAO.AmortizacaoDAO;
import br.com.is.DAO.EquipesDAO;
import br.com.is.DAO.EventoDAO;
import br.com.is.DAO.Generico;
import br.com.is.DAO.GenericoDAO;
import br.com.is.DAO.QueryCriteria;
import br.com.is.DAO.RealizacaoDAO;
import br.com.is.DAO.ResponsavelDAO;
import br.com.is.DAO.ServicoDAO;
import br.com.is.DAO.ServicoPertenceEventoDAO;
import br.com.is.DAO.TipoEventoDAO;
import br.com.is.Entitys.Amortizacao;
import br.com.is.Entitys.Equipe;
import br.com.is.Entitys.Evento;
import br.com.is.Entitys.Pagamento;
import br.com.is.Entitys.Realizacao;
import br.com.is.Entitys.Responsavel;
import br.com.is.Entitys.ResponsavelPK;
import br.com.is.Entitys.Servico;
import br.com.is.Entitys.ServicoPertenceEvento;
import br.com.is.Entitys.ServicoPertenceEventoPK;
import br.com.is.Entitys.TipoEvento;
import static br.com.is.View.JanelaPrincipal.jDesktopPane;
import br.com.is.utils.ComboItens;
import br.com.is.utils.ConexaoBD;
import static br.com.is.utils.Funcoes.geraParcelas;
import br.com.is.utils.Layouts;
import br.com.is.utils.Support;
import java.awt.event.ItemEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Evento_view extends javax.swing.JInternalFrame {

    Evento evento = new Evento();
    Pagamento pag = new Pagamento();
    Amortizacao amorTemp;

    public Evento_view() {
        initComponents();
        tbpEvento.setEnabledAt(1, false);
        tbpEvento.setEnabledAt(2, false);
        tbpEvento.setEnabledAt(3, false);
        new TipoEventoDAO(new TipoEvento()).popularCombo(cmbTipoEvento);
        tfdCodigo.setText(String.valueOf(new Generico<Evento>(new Evento()).ProximoCodigo()));
    }

    public Evento_view(Evento evt) {
        initComponents();
        this.evento = evt;

        tbpEvento.setEnabledAt(1, false);
        tbpEvento.setEnabledAt(2, false);
        tbpEvento.setEnabledAt(3, false);

        new TipoEventoDAO(new TipoEvento()).popularCombo(cmbTipoEvento);
        new RealizacaoDAO(new Realizacao()).PopulaTabela(tblRealizacoes, evento.getCodigo());

        tfdCodigo.setText(String.valueOf(evt.getCodigo()));
        tfdTitulo.setText(evt.getTitulo());
        txaDescricao.setText(evt.getDescricao());

        ComboItens tipoEvento = new ComboItens();
        tipoEvento.setCodigo(evt.getTipoEvento().getCodigo());
        tipoEvento.setDescricao(evt.getTipoEvento().getNome());
        new ComboItens().definirItemCombo(cmbTipoEvento, tipoEvento);

        List<QueryCriteria> criterios = new ArrayList<>();
        criterios.add(new QueryCriteria("node", "evento1", "ev"));
        criterios.add(new QueryCriteria("equal", "ev.codigo", String.valueOf(evento.getCodigo())));
//        Tela de responsaveis
        if (new Generico<Responsavel>(new Responsavel()).Listar(criterios).size() > 0) {
            new ResponsavelDAO(new Responsavel()).PopulaTabela(tblContratantes, evento.getCodigo());
            btnAvanca1.setEnabled(true);
            btnAvanca2.setEnabled(true);
            tbpEvento.setEnabledAt(1, true);
        }
//        Tela de Serviços
        List<ServicoPertenceEvento> servicos = new Generico<ServicoPertenceEvento>(new ServicoPertenceEvento()).Listar(criterios);
        if (servicos.size() > 0) {
            new EquipesDAO(new Equipe()).popularCombo(cmbEquipes);
            btnAvancar3.setEnabled(true);
            tbpEvento.setEnabledAt(2, true);
            new ServicoPertenceEventoDAO(new ServicoPertenceEvento()).PopulaTabela(tblServicoAdd, evento);
//        Tela de pagamento
            tbpEvento.setEnabledAt(3, true);
            BigDecimal totalContrato = new BigDecimal(0);
            for (ServicoPertenceEvento servico : servicos) {
                totalContrato = totalContrato.add(servico.getValorFinal());
            }
            lblTotal.setText(Layouts.setMonetario(totalContrato));
            this.pag = new Generico<Pagamento>(new Pagamento()).Visualizar(criterios);
            if (pag != null) {
                cmmDesconto.setValue(pag.getValorTotal());
                spnParcelas.setValue(pag.getQuantidadeParcela());
                dcsInicial.setDate(pag.getDataInicial());
                cmbFormaPagamento.setSelectedItem(pag.getFormaPagamento());
                new AmortizacaoDAO(new Amortizacao()).PopulaTabela(jTable1, evento.getCodigo());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        tbpEvento = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnAvanca1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbTipoEvento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfdCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdTitulo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        cmbStatus = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRealizacoes = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContratantes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAvanca2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbEquipes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblServicos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblServicoAdd = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        btnAvancar3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblTotal = new br.com.is.utils.CampoMoeda();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cmbFormaPagamento = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        spnParcelas = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        dcsInicial = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        cmmDesconto = new br.com.is.utils.CampoMoeda();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        cmmValorDebi = new br.com.is.utils.CampoMoeda();
        jLabel23 = new javax.swing.JLabel();
        cmbPagamentoFormaPagamento = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        dcsData = new com.toedter.calendar.JDateChooser();
        jLabel25 = new javax.swing.JLabel();
        cmbPagamentoSatus = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setTitle("Evento");
        setName(""); // NOI18N

        btnSair.setText("Fechar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnAvanca1.setText("Avançar");
        btnAvanca1.setEnabled(false);
        btnAvanca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanca1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Tipo evento");

        cmbTipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Código");

        tfdCodigo.setEditable(false);

        jLabel7.setText("Título *");

        jLabel8.setText("Descrição");

        txaDescricao.setColumns(20);
        txaDescricao.setRows(5);
        jScrollPane5.setViewportView(txaDescricao);

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Ativo", "2 - Aguardando aprovação", "3 - Em andamento", "4 - Cancelado", "5 - Finalizado" }));

        jLabel9.setText("Status");

        tblRealizacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane6.setViewportView(tblRealizacoes);

        jButton9.setText("Adicionar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Remover");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("* Nesta tela o botão avançar atualiza seus dados.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAvanca1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addComponent(jLabel6)
                            .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(tfdTitulo)
                            .addComponent(jScrollPane5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(cmbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbTipoEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvanca1)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        tbpEvento.addTab("Evento", jPanel1);

        jPanel3.setEnabled(false);

        tblContratantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblContratantes);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAvanca2.setText("Avançar");
        btnAvanca2.setEnabled(false);
        btnAvanca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvanca2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addComponent(btnAvanca2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAvanca2)
                .addContainerGap())
        );

        tbpEvento.addTab("Contratante", jPanel3);

        jPanel2.setEnabled(false);

        jLabel3.setText("Equipe");

        cmbEquipes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEquipesItemStateChanged(evt);
            }
        });

        jLabel4.setText("Serviço");

        tblServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblServicos);

        jButton6.setText("Adicionar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEquipes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jButton6))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEquipes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Serviços", jPanel5);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Serviços adicionados"));

        tblServicoAdd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tblServicoAdd);

        jButton7.setText("Remover");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAvancar3.setText("Avançar");
        btnAvancar3.setEnabled(false);
        btnAvancar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane2)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAvancar3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAvancar3)
                .addContainerGap())
        );

        tbpEvento.addTab("Equipes", jPanel2);

        jPanel4.setEnabled(false);

        lblTotal.setEditable(false);
        lblTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setText("Total do contrato");

        jLabel11.setText("Forma de pagamento");

        cmbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione uma opção --", "1 - Presencial", "2 - Cartão de crédito", "3 - Depósito bancário", "4 - Boleto", "5 - Cheque" }));
        cmbFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFormaPagamentoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane7.setViewportView(jTable1);

        jButton4.setText("Gerar parcelas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton11.setText("Contrato");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel13.setText("Número de parcelas");

        jLabel14.setText("Data inicial");

        jLabel15.setText("Desconto");

        jButton12.setText("Editar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Remover");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel22.setText("Valor a debitar");

        cmmValorDebi.setEnabled(false);

        jLabel23.setText("Forma de pagamento");

        cmbPagamentoFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione uma opção --", "1 - Presencial", "2 - Cartão de crédito", "3 - Depósito bancário", "4 - Boleto", "5 - Cheque" }));
        cmbPagamentoFormaPagamento.setEnabled(false);
        cmbPagamentoFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPagamentoFormaPagamentoActionPerformed(evt);
            }
        });

        jLabel24.setText("Data de pagamento");

        dcsData.setEnabled(false);

        jLabel25.setText("Forma de pagamento");

        cmbPagamentoSatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selecione uma opção --", "1 - Quitado", "2 - Reagendado" }));
        cmbPagamentoSatus.setEnabled(false);
        cmbPagamentoSatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPagamentoSatusActionPerformed(evt);
            }
        });

        jButton3.setText("Debitar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(cmmValorDebi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(cmbPagamentoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE))))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(cmmDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addComponent(cmbFormaPagamento, 0, 212, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addComponent(dcsInicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton11))
                                .addGap(0, 281, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(dcsData, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(cmbPagamentoSatus, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmmDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spnParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcsInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmmValorDebi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbPagamentoFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(26, 26, 26))
                                    .addComponent(dcsData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPagamentoSatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13))
                .addContainerGap())
        );

        tbpEvento.addTab("Financeiro", jPanel4);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbpEvento)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbpEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnAvanca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanca1ActionPerformed
        tbpEvento.setEnabledAt(1, true);
        tbpEvento.setSelectedIndex(1);
    }//GEN-LAST:event_btnAvanca1ActionPerformed

    private void btnAvanca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanca2ActionPerformed
        tbpEvento.setEnabledAt(2, true);
        tbpEvento.setSelectedIndex(2);

        new EquipesDAO(new Equipe()).popularCombo(cmbEquipes);
    }//GEN-LAST:event_btnAvanca2ActionPerformed

    private void btnAvancar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancar3ActionPerformed
        tbpEvento.setEnabledAt(3, true);
        tbpEvento.setSelectedIndex(3);
        List<QueryCriteria> criterios = new ArrayList<>();
        criterios.add(new QueryCriteria("node", "evento1", "ev"));
        criterios.add(new QueryCriteria("equal", "ev.codigo", String.valueOf(evento.getCodigo())));
        List<ServicoPertenceEvento> servicos = new Generico<ServicoPertenceEvento>(new ServicoPertenceEvento()).Listar(criterios);
        BigDecimal totalContrato = new BigDecimal(0);
        for (ServicoPertenceEvento servico : servicos) {
            totalContrato = totalContrato.add(servico.getValorFinal());
        }
        lblTotal.setText(Layouts.setMonetario(totalContrato));
    }//GEN-LAST:event_btnAvancar3ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        evento.setTitulo(tfdTitulo.getText());
        evento.setDescricao(txaDescricao.getText());

        List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
        TipoEvento tev = new TipoEvento();
        ComboItens comboTipos = (ComboItens) cmbTipoEvento.getSelectedItem();
        listCriterias.add(new QueryCriteria("equal", "codigo", String.valueOf(comboTipos.getCodigo())));
        tev = new Generico<TipoEvento>(new TipoEvento()).Visualizar(listCriterias);
        listCriterias.removeAll(listCriterias);

        evento.setTipoEvento(tev);
        evento.setStatus(cmbStatus.getSelectedItem().toString());

        new GenericoDAO<Evento>(evento).gravar();

        listCriterias.add(new QueryCriteria("equal", "titulo", evento.getTitulo()));
        evento = new Generico<Evento>(new Evento()).Visualizar(listCriterias);
        Realizacao_view rv = new Realizacao_view(evento);
        Support.centralizar(jDesktopPane.add(rv));
        rv.setVisible(true);
        new EventoDAO(new Evento()).PopulaTabela(jTable1, new QueryCriteria("contain", "status", "1 - Ativo"));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Pessoa_listar_view plv = new Pessoa_listar_view("evento", evento);
        Support.centralizar(jDesktopPane.add(plv));
        plv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tblContratantes.getSelectedRow() != -1) {
            if (JOptionPane.showInternalConfirmDialog(this, "Deseja remover este contato?",
                    "O endereço selecionado será definitivamente removido.",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

                List<QueryCriteria> criterios = new ArrayList<QueryCriteria>();
                criterios.add(new QueryCriteria("equal", "codigo", String.valueOf(tblContratantes.getValueAt(tblContratantes.getSelectedRow(), 0))));
                criterios.add(new QueryCriteria("equal", "codigo", String.valueOf(tblContratantes.getValueAt(tblContratantes.getSelectedRow(), 0))));

                Responsavel resp = new Responsavel();
                resp.setResponsavelPK(new ResponsavelPK(evento.getCodigo(), (int) tblContratantes.getValueAt(tblContratantes.getSelectedRow(), 0)));
                new Generico<Responsavel>(resp).Excluir();

                new ResponsavelDAO(new Responsavel()).PopulaTabela(tblContratantes, evento.getCodigo());

            }
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para edição!");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmbFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFormaPagamentoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (tblServicoAdd.getSelectedRow() != -1) {
            List<QueryCriteria> listCriterias = new ArrayList<QueryCriteria>();
            listCriterias.add(new QueryCriteria("node", "servico1", "sv"));
            listCriterias.add(new QueryCriteria("node", "evento1", "ev"));
            listCriterias.add(new QueryCriteria("equal", "ev.codigo", String.valueOf(evento.getCodigo())));
            listCriterias.add(new QueryCriteria("equal", "sv.titulo", (String) tblServicoAdd.getValueAt(tblServicoAdd.getSelectedRow(), 0)));
            ServicoPertenceEvento spe = new ServicoPertenceEvento();
            new Generico<ServicoPertenceEvento>(
                    new Generico<ServicoPertenceEvento>(spe)
                            .Visualizar(listCriterias))
                    .Excluir();
            new ServicoPertenceEventoDAO(spe).PopulaTabela(tblServicoAdd, evento);
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para edição!");
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Pagamento pag = new Pagamento();
        pag.setDesconto(cmmDesconto.getValue());
        pag.setEvento(evento.getCodigo());
        pag.setEvento1(evento);
        String totals = lblTotal.getText().replace("R$ ", "").replace(".", "").replace(",", ".");
        BigDecimal total = new BigDecimal(totals);
        pag.setValorTotal(total);
        pag.setQuantidadeParcela((Integer) spnParcelas.getValue());
        pag.setDataInicial(dcsInicial.getDate());
        pag.setFormaPagamento(cmbFormaPagamento.getSelectedItem().toString());
        pag.setDataContrato(new Date(System.currentTimeMillis()));
        pag.setStatus('A');

        new Generico<Pagamento>(pag).Gravar();

        List<QueryCriteria> criterios = new ArrayList<QueryCriteria>();
        criterios.add(new QueryCriteria("node", "pagamento", "pag"));
        criterios.add(new QueryCriteria("equal", "pag.evento", String.valueOf(evento.getCodigo())));
        List<Amortizacao> amors = new Generico<Amortizacao>(new Amortizacao()).Listar(criterios);

        for (Amortizacao amor : amors) {
            new Generico<Amortizacao>(amor).Excluir();
        }

        TreeMap<Date, BigDecimal> parcelamento = geraParcelas(dcsInicial.getDate(), pag.getValorTotal(), (Integer) spnParcelas.getValue());
        for (Date date : parcelamento.keySet()) {
            Amortizacao amor = new Amortizacao();
            amor.setData(date);
            amor.setFormaPagamento(cmbFormaPagamento.getSelectedItem().toString());
            amor.setValor(parcelamento.get(date));
            amor.setPagamento(pag);
            amor.setStatus("A - Aberto");
            new Generico<Amortizacao>(amor).Gravar();
        }
        new AmortizacaoDAO(new Amortizacao()).PopulaTabela(jTable1, evento.getCodigo());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            if (JOptionPane.showInternalConfirmDialog(this, "Deseja remover este contato?",
                    "O valor selecionado será definitivamente removido.",
                    JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

                List<QueryCriteria> criterios = new ArrayList<QueryCriteria>();
                criterios.add(new QueryCriteria("equal", "codigo", String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0))));

                Amortizacao amor = new Generico<Amortizacao>(new Amortizacao()).Visualizar(criterios);
                new Generico<Responsavel>(amor).Excluir();
                new AmortizacaoDAO(new Amortizacao()).PopulaTabela(jTable1, evento.getCodigo());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para edição!");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (tblServicos.getSelectedRow() != -1) {
            ServicoPertenceEvento spe = new ServicoPertenceEvento();
            spe.setStatus('A');
            String valor = tblServicos.getValueAt(tblServicos.getSelectedRow(), 2).toString().replace("R$ ", "");
            System.out.println(valor);
            BigDecimal total = new BigDecimal(valor);
            System.out.println(total);
            spe.setValorFinal(total);
            spe.setValorOriginal(total);
            spe.setServicoPertenceEventoPK(new ServicoPertenceEventoPK(evento.getCodigo(),
                    (int) tblServicos.getValueAt(tblServicos.getSelectedRow(), 0)));
            new Generico<ServicoPertenceEvento>(spe).Gravar();
            new ServicoPertenceEventoDAO(spe).PopulaTabela(tblServicoAdd, evento);
            btnAvancar3.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Uma linha da tabela deve estar selecionada para edição!");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cmbEquipesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEquipesItemStateChanged
        ComboItens comboEquipe = (ComboItens) cmbEquipes.getSelectedItem();
        if (evt.getStateChange() == ItemEvent.SELECTED && comboEquipe.getCodigo() != 0) {

            List<QueryCriteria> criteriosEquipe = new ArrayList<QueryCriteria>();
            criteriosEquipe.add(new QueryCriteria("equal", "codigo", String.valueOf(comboEquipe.getCodigo())));
            Equipe equipe = new Generico<Equipe>(new Equipe()).Visualizar(criteriosEquipe);

            new ServicoDAO(new Servico()).PopulaTabela(tblServicos, equipe);
        }
    }//GEN-LAST:event_cmbEquipesItemStateChanged

    private void cmbPagamentoFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPagamentoFormaPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPagamentoFormaPagamentoActionPerformed

    private void cmbPagamentoSatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPagamentoSatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPagamentoSatusActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            List<QueryCriteria> criterias = new ArrayList<QueryCriteria>();
            criterias.add(new QueryCriteria("equal", "codigo", String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0))));
            amorTemp = new Generico<Amortizacao>(new Amortizacao()).Visualizar(criterias);
            cmmValorDebi.setValue(amorTemp.getValor());
            cmmValorDebi.setEnabled(true);
            dcsData.setDate(amorTemp.getData());
            dcsData.setEnabled(true);
            cmbPagamentoFormaPagamento.setSelectedItem(amorTemp.getFormaPagamento());
            cmbPagamentoFormaPagamento.setEnabled(true);
            cmbPagamentoSatus.setSelectedItem(amorTemp.getStatus());
            cmbPagamentoSatus.setEnabled(true);
        } else {

        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        amorTemp.setData(dcsData.getDate());
        amorTemp.setValor(cmmValorDebi.getValue());
        amorTemp.setStatus(cmbPagamentoSatus.getSelectedItem().toString());
        amorTemp.setFormaPagamento(cmbPagamentoFormaPagamento.getSelectedItem().toString());
        new Generico<Amortizacao>(amorTemp).Gravar();
        new AmortizacaoDAO(new Amortizacao()).PopulaTabela(jTable1, evento.getCodigo());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            File arq = new File("C:\\Projeto\\news\\iipdesk\\src\\main\\java\\br\\com\\is\\View\\report\\contrato.jrxml");
            JasperReport relatorio = JasperCompileManager.compileReport(arq.getPath());
            Map parametros = new HashMap();
            parametros.put("evento", evento.getCodigo());
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    public static javax.swing.JButton btnAvanca1;
    public static javax.swing.JButton btnAvanca2;
    private javax.swing.JButton btnAvancar3;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbEquipes;
    private javax.swing.JComboBox<String> cmbFormaPagamento;
    private javax.swing.JComboBox<String> cmbPagamentoFormaPagamento;
    private javax.swing.JComboBox<String> cmbPagamentoSatus;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbTipoEvento;
    private br.com.is.utils.CampoMoeda cmmDesconto;
    private br.com.is.utils.CampoMoeda cmmValorDebi;
    private com.toedter.calendar.JDateChooser dcsData;
    private com.toedter.calendar.JDateChooser dcsInicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private br.com.is.utils.CampoMoeda lblTotal;
    private javax.swing.JSpinner spnParcelas;
    public static javax.swing.JTable tblContratantes;
    public static javax.swing.JTable tblRealizacoes;
    private javax.swing.JTable tblServicoAdd;
    private javax.swing.JTable tblServicos;
    private javax.swing.JTabbedPane tbpEvento;
    private javax.swing.JTextField tfdCodigo;
    private javax.swing.JTextField tfdTitulo;
    private javax.swing.JTextArea txaDescricao;
    // End of variables declaration//GEN-END:variables
}
