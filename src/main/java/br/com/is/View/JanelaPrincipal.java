/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.is.View;

import br.com.is.DAO.EventoDAO;
import br.com.is.DAO.Generico;
import br.com.is.DAO.QueryCriteria;
import br.com.is.Entitys.Evento;
import br.com.is.Entitys.Pessoa;
import br.com.is.utils.GerenciamentoBD;
import br.com.is.utils.Grafico;
import br.com.is.utils.Support;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
//import DAO.WebService;

/**
 *
 * @author RSPortella <rodolfosportella@gmail.com>
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    //initializing the logger
    static org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(JanelaPrincipal.class);

    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() throws IOException {
        initComponents();

        new EventoDAO(new Evento()).PopulaTabela(jTable1, new QueryCriteria("contain", "status", "1 - Ativo"));

        String URL_WEBSERVICE = "http://api.promasters.net.br/cotacao/v1/valores?moedas=USD&alt=json";

        URL url = new URL(URL_WEBSERVICE);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuffer dadosUrl = new StringBuffer();
        String dado = "";
        while (null != ((dado = br.readLine()))) {
            dadosUrl.append(dado);
        }
        br.close();

        labDolar.setText(dadosUrl.toString().substring(61, 65));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labDolar = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mitBackup = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mitSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mitCliente = new javax.swing.JMenuItem();
        mitEvento = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        mitPEC = new javax.swing.JMenuItem();
        mitLogradouro = new javax.swing.JMenuItem();
        mitTipoEndereco = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mitTipoEvento = new javax.swing.JMenuItem();
        mitTipoContato = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mitEquipeServico = new javax.swing.JMenuItem();
        mitPacote = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IIP - Sistema");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jDesktopPane.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("ALERTAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("SUPORTE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Cotação Dólar:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Eventos ativos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Eventos abertos");

        labDolar.setText("ERRO");

        jButton3.setText("GRÁFICO");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jDesktopPane.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(labDolar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jDesktopPaneLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labDolar)
                        .addGap(157, 157, 157))))
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(labDolar))
                    .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jDesktopPane);

        jMenu1.setText("Arquivo");

        mitBackup.setText("Backup");
        mitBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitBackupActionPerformed(evt);
            }
        });
        jMenu1.add(mitBackup);
        jMenu1.add(jSeparator4);

        mitSair.setText("Sair");
        jMenu1.add(mitSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Apoio");

        mitCliente.setText("Pessoa");
        mitCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitClienteActionPerformed(evt);
            }
        });
        jMenu2.add(mitCliente);

        mitEvento.setText("Evento");
        mitEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEventoActionPerformed(evt);
            }
        });
        jMenu2.add(mitEvento);
        jMenu2.add(jSeparator1);

        jMenu3.setText("Apoio");

        mitPEC.setText("Pais/estado/cidade");
        mitPEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPECActionPerformed(evt);
            }
        });
        jMenu3.add(mitPEC);

        mitLogradouro.setText("Logradouro");
        mitLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitLogradouroActionPerformed(evt);
            }
        });
        jMenu3.add(mitLogradouro);

        mitTipoEndereco.setText("Tipo de endereço");
        mitTipoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTipoEnderecoActionPerformed(evt);
            }
        });
        jMenu3.add(mitTipoEndereco);
        jMenu3.add(jSeparator2);

        mitTipoEvento.setText("Tipo de evento");
        mitTipoEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTipoEventoActionPerformed(evt);
            }
        });
        jMenu3.add(mitTipoEvento);

        mitTipoContato.setText("Tipo contato");
        mitTipoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitTipoContatoActionPerformed(evt);
            }
        });
        jMenu3.add(mitTipoContato);
        jMenu3.add(jSeparator3);

        mitEquipeServico.setText("Equipe/Serviços");
        mitEquipeServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitEquipeServicoActionPerformed(evt);
            }
        });
        jMenu3.add(mitEquipeServico);

        mitPacote.setText("Pacotes");
        mitPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPacoteActionPerformed(evt);
            }
        });
        jMenu3.add(mitPacote);

        jMenu2.add(jMenu3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitPECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPECActionPerformed
        Pais_view pv = new Pais_view();
        Support.centralizar(jDesktopPane.add(pv));
        pv.setVisible(true);
    }//GEN-LAST:event_mitPECActionPerformed

    private void mitLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitLogradouroActionPerformed
        Logradouro_view logv = new Logradouro_view();
        Support.centralizar(jDesktopPane.add(logv));
        logv.setVisible(true);
    }//GEN-LAST:event_mitLogradouroActionPerformed

    private void mitTipoEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTipoEventoActionPerformed
        TipoEvento_view tev = new TipoEvento_view();
        Support.centralizar(jDesktopPane.add(tev));
        tev.setVisible(true);
    }//GEN-LAST:event_mitTipoEventoActionPerformed

    private void mitTipoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTipoContatoActionPerformed
        TipoContato_view tcv = new TipoContato_view();
        Support.centralizar(jDesktopPane.add(tcv));
        tcv.setVisible(true);
    }//GEN-LAST:event_mitTipoContatoActionPerformed

    private void mitTipoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitTipoEnderecoActionPerformed
        TipoEndereco_view tev = new TipoEndereco_view();
        Support.centralizar(jDesktopPane.add(tev));
        tev.setVisible(true);
    }//GEN-LAST:event_mitTipoEnderecoActionPerformed

    private void mitClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitClienteActionPerformed
        Pessoa_listar_view plv = new Pessoa_listar_view();
        Support.centralizar(jDesktopPane.add(plv));
        plv.setVisible(true);
    }//GEN-LAST:event_mitClienteActionPerformed

    private void mitEquipeServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEquipeServicoActionPerformed
        Equipe_listar_view eqv = new Equipe_listar_view();
        Support.centralizar(jDesktopPane.add(eqv));
        eqv.setVisible(true);
    }//GEN-LAST:event_mitEquipeServicoActionPerformed

    private void mitPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPacoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitPacoteActionPerformed

    private void mitEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEventoActionPerformed
        Evento_listar_view evl = new Evento_listar_view();
        Support.centralizar(jDesktopPane.add(evl));
        evl.setVisible(true);
    }//GEN-LAST:event_mitEventoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaAlertas_view tav = new TelaAlertas_view();
        Support.centralizar(jDesktopPane.add(tav));
        tav.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mitBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitBackupActionPerformed
        try {
            GerenciamentoBD.realizaBackup();
        } catch (IOException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mitBackupActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EnviaEmail_view tav = new EnviaEmail_view();
        Support.centralizar(jDesktopPane.add(tav));
        tav.setVisible(true);
//        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TreeMap<String, Integer> dados = new TreeMap<String, Integer>();
        List pessoas = new Generico<Pessoa>(new Pessoa()).Listar(null);

        dados.put("Masculino", 0);
        dados.put("Feminino", 0);
        for (Object p : pessoas) {
            Pessoa ps = (Pessoa) p;
            if (ps.getGenero().equals('M')) {
                dados.put("Masculino", (dados.get("Masculino") + 1));
            } else {
                dados.put("Feminino", (dados.get("Feminino") + 1));
            }
        }
        Grafico gpd = new Grafico("Porcentagem de pessoas cadastradas", dados);
        gpd.gerarGrafico("Porcentagem de pessoas cadastradas", dados);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labDolar;
    private javax.swing.JMenuItem mitBackup;
    private javax.swing.JMenuItem mitCliente;
    private javax.swing.JMenuItem mitEquipeServico;
    private javax.swing.JMenuItem mitEvento;
    private javax.swing.JMenuItem mitLogradouro;
    private javax.swing.JMenuItem mitPEC;
    private javax.swing.JMenuItem mitPacote;
    private javax.swing.JMenuItem mitSair;
    private javax.swing.JMenuItem mitTipoContato;
    private javax.swing.JMenuItem mitTipoEndereco;
    private javax.swing.JMenuItem mitTipoEvento;
    // End of variables declaration//GEN-END:variables
}
