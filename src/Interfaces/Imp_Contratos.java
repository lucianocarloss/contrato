/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Ferramenta.ConexaoBD;
import Ferramenta.clientes;
import Model.CNPJ;
import Model.CPF;
import Model.M_clientes;
import Model.TabelasUser;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import Interfaces.Principal;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


/**
 *
 * @author Luciano
 */
public class Imp_Contratos extends javax.swing.JInternalFrame {
    
    ConexaoBD conex = new ConexaoBD();
    clientes mod =new clientes();
    M_clientes dao =new M_clientes();
    int flag=0;
    int at=1;
    
             public void imprimir(String pCaminhoDoarquivo){
        
        Desktop desktop = Desktop.getDesktop();
        
       
        try {
            File arquivoAImprimir = new File(pCaminhoDoarquivo);
            desktop.print(arquivoAImprimir);
            
        }catch (IOException ex){
                
                ex.printStackTrace();
        
        }
        
    }
    /**
     * Creates new form Cadastro
     */
    public Imp_Contratos() {
        initComponents();
         preencherTabela("Select * FROM contratos");
        
    
    
    
    }
    
    
    public void preencherTabela(String Sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String [] {"Contrato","Nome","CPF/CNPJ"};
        conex.conexao();
        conex.executarSql(Sql);
        try{
            
            //dados.add(new Object[]{conex.rs.getString("PROJETO")});
            conex.rs.first();
            do{
                dados.add(new Object[]{conex.rs.getString("id2"),conex.rs.getString("cliente"),conex.rs.getString("cpf")});
                //conex.rs.next();
            }while(conex.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"ERRO AO PREENCHER LISTA DE USUARIOS"+ex);
            
        }
        TabelasUser modelo = new TabelasUser(dados, colunas);
        jTUsers.setModel(modelo);
        jTUsers.getColumnModel().getColumn(0).setPreferredWidth(10);
        jTUsers.getColumnModel().getColumn(0).setResizable(false);
        jTUsers.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTUsers.getColumnModel().getColumn(1).setResizable(false);
        jTUsers.getColumnModel().getColumn(2).setPreferredWidth(20);
        jTUsers.getColumnModel().getColumn(2).setResizable(false);
        //jTable_Clientes.getColumnModel().getColumn(3).setPreferredWidth(80);
        //jTable_Clientes.getColumnModel().getColumn(3).setResizable(false);
       // jTable_Clientes.getTableHeader().setReorderingAllowed(false);
        //jTable_Clientes.setAutoResizeMode(jTable_Clientes.AUTO_RESIZE_OFF);
        jTUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conex.desconecta();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTUsuario = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        qdcentro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTEndereco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTUsers = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTNContrato = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBImprimir = new javax.swing.JButton();

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

        setClosable(true);
        setIconifiable(true);
        setTitle("Contrato - Imprimir");
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(805, 402));

        jTUsuario.setBackground(new java.awt.Color(109, 109, 109));

        jPanel3.setBackground(new java.awt.Color(109, 109, 109));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IMPRIMIR CONTRATO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel2.setText("Contrato:");

        jTnome.setEditable(false);
        jTnome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTnome.setMaximumSize(new java.awt.Dimension(6, 24));
        jTnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTnomeFocusLost(evt);
            }
        });

        jLabel3.setText("Total:");

        jTEndereco.setEditable(false);
        jTEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEndereco.setMaximumSize(new java.awt.Dimension(6, 24));
        jTEndereco.setMinimumSize(new java.awt.Dimension(6, 24));
        jTEndereco.setName(""); // NOI18N

        jTUsers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Contrato", "Cliente", "CPF / CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTUsers.setShowHorizontalLines(false);
        jTUsers.setShowVerticalLines(false);
        jTUsers.getTableHeader().setReorderingAllowed(false);
        jTUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTUsers);
        if (jTUsers.getColumnModel().getColumnCount() > 0) {
            jTUsers.getColumnModel().getColumn(0).setResizable(false);
            jTUsers.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTUsers.getColumnModel().getColumn(1).setResizable(false);
            jTUsers.getColumnModel().getColumn(1).setPreferredWidth(300);
            jTUsers.getColumnModel().getColumn(2).setResizable(false);
            jTUsers.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        jLabel4.setText("Nome:");

        jTNContrato.setEditable(false);
        jTNContrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTNContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTNContrato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(0, 204, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jBImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/imp.png"))); // NOI18N
        jBImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentroLayout = new javax.swing.GroupLayout(qdcentro);
        qdcentro.setLayout(qdcentroLayout);
        qdcentroLayout.setHorizontalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addGroup(qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        qdcentroLayout.setVerticalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        jPanel3.add(qdcentro, java.awt.BorderLayout.CENTER);

        jTUsuario.addTab("", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTUsuario)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getAccessibleContext().setAccessibleName("Usu??rios");

        setBounds(0, 0, 1278, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void jTUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsersMouseClicked
        // TODO add your handling code here:
        jTnome.setText("");
        jTEndereco.setText("");
        

        //jTnome.setEnabled(false);
        //jTEndereco.setEnabled(false);

        String cpf_cliente =""+jTUsers.getValueAt(jTUsers.getSelectedRow(), 0);
        conex.conexao();
        conex.executarSql("SELECT *FROM contratos WHERE id2 ='"+cpf_cliente+"'");
        //conex.executarSql("SELECT DISTINCT CLIENTES from clientes ='"+nome_cliente+"'");
        try{
            conex.rs.first();
            jTnome.setText(conex.rs.getString("cliente"));
            jTEndereco.setText(conex.rs.getString("total"));
            jTNContrato.setText(conex.rs.getString("id2"));
            // jCsexo.setSelectedItem(conex.rs.getString("sexo"));
            //jCocargo.setSelectedItem(conex.rs.getString("cargo"));
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao selecionar usu??rio!"+ex);
            //jTnome.setEnabled(false);
            // jTUsers.setEnabled(false);

            //at=0;

        }

        conex.desconecta();

    }//GEN-LAST:event_jTUsersMouseClicked

    private void jTnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnomeFocusLost
        // TODO add your handling code here:
        if (jTnome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VOC?? PRECISA DIGITAR O NOME DO USU??RIO!");

        }
    }//GEN-LAST:event_jTnomeFocusLost

    private void jBImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirActionPerformed
        // TODO add your handling code here:
        
        //VD
                if (JOptionPane.showConfirmDialog(null, "Deseja Re-Imprimir o contrato "+ jTNContrato.getText() +" contrato?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    
                    String ncont = jTNContrato.getText();
                    imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                    JOptionPane.showMessageDialog(null, "Ok, aguarde a finaliza????o da impress??o !");
                    //jBImprimir.setEnabled(false);
                    dispose();
                }
        
    }//GEN-LAST:event_jBImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTEndereco;
    private javax.swing.JTextField jTNContrato;
    private javax.swing.JTable jTUsers;
    private javax.swing.JTabbedPane jTUsuario;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTnome;
    private javax.swing.JPanel qdcentro;
    // End of variables declaration//GEN-END:variables
}
