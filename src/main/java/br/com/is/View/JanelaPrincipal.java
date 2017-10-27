/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.is.View;

import br.com.is.utils.GerenciamentoBD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import utils.Support;

/**
 *
 * @author RSPortella <rodolfosportella@gmail.com>
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    //initializing the logger
//    static final Logger log4j = Logger.getLogger(JanelaPrincipal.class);
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        initComponents();
//        log4j.info("#######################################################################################");
//        log4j.info("########## IPP - INICIANDO...##########################################################");
//        log4j.info("#######################################################################################");
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
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("ALERTAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jDesktopPane.add(jButton1);
        jButton1.setBounds(10, 10, 170, 130);

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

        mitCliente.setText("Cliente");
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
        Equipe_view eqv = new Equipe_view();
        Support.centralizar(jDesktopPane.add(eqv));
        eqv.setVisible(true);
    }//GEN-LAST:event_mitEquipeServicoActionPerformed

    private void mitPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPacoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitPacoteActionPerformed

    private void mitEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitEventoActionPerformed
        Evento_view evv = new Evento_view();
        Support.centralizar(jDesktopPane.add(evv));
        evv.setVisible(true);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
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
