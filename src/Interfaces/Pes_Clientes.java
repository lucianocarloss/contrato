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


/**
 *
 * @author Luciano
 */
public class Pes_Clientes extends javax.swing.JInternalFrame {
    
    ConexaoBD conex = new ConexaoBD();
    clientes mod =new clientes();
    M_clientes dao =new M_clientes();
    int flag=0;
    int at=1;
    
    
    /**
     * Creates new form Cadastro
     */
    public Pes_Clientes() {
        initComponents();
         preencherTabela("Select * FROM client");
        
    
    
    
    }
    
    
    public void preencherTabela(String Sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String [] {"Nome","CPF/CNPJ"};
        conex.conexao();
        conex.executarSql(Sql);
        try{
            
            //dados.add(new Object[]{conex.rs.getString("PROJETO")});
            conex.rs.first();
            do{
                dados.add(new Object[]{conex.rs.getString("Nome"),conex.rs.getString("cpf")});
                //conex.rs.next();
            }while(conex.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"ERRO AO PREENCHER LISTA DE USUARIOS"+ex);
            
        }
        TabelasUser modelo = new TabelasUser(dados, colunas);
        jTUsers.setModel(modelo);
        jTUsers.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTUsers.getColumnModel().getColumn(0).setResizable(false);
        jTUsers.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTUsers.getColumnModel().getColumn(1).setResizable(false);
       // jTable_Clientes.getColumnModel().getColumn(2).setPreferredWidth(80);
       // jTable_Clientes.getColumnModel().getColumn(2).setResizable(false);
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
        jLabel9 = new javax.swing.JLabel();
        jTEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTUsers = new javax.swing.JTable();
        jTEcpf = new javax.swing.JTextField();
        jTbairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTDoc = new javax.swing.JTextField();
        jTrg = new javax.swing.JTextField();
        jTDocrg = new javax.swing.JTextField();
        jTnumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jFfone1 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jFfone2 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTCidade = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBSave = new javax.swing.JButton();
        jBEUser = new javax.swing.JButton();

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
        setTitle("Cadastro");
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(805, 402));

        jTUsuario.setBackground(new java.awt.Color(109, 109, 109));

        jPanel3.setBackground(new java.awt.Color(109, 109, 109));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CLIENTES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel2.setText("Nome:");

        jTnome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTnome.setEnabled(false);
        jTnome.setMaximumSize(new java.awt.Dimension(6, 24));
        jTnome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTnomeFocusLost(evt);
            }
        });

        jLabel3.setText("Endereço:");

        jTEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEndereco.setEnabled(false);
        jTEndereco.setMaximumSize(new java.awt.Dimension(6, 24));
        jTEndereco.setMinimumSize(new java.awt.Dimension(6, 24));
        jTEndereco.setName(""); // NOI18N
        jTEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTEnderecoFocusLost(evt);
            }
        });

        jLabel9.setText("Email:");

        jTEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEmail.setEnabled(false);
        jTEmail.setMaximumSize(new java.awt.Dimension(6, 24));
        jTEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTEmailFocusLost(evt);
            }
        });

        jTUsers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF/CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
            jTUsers.getColumnModel().getColumn(0).setPreferredWidth(300);
            jTUsers.getColumnModel().getColumn(1).setResizable(false);
            jTUsers.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jTEcpf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEcpf.setEnabled(false);
        jTEcpf.setMaximumSize(new java.awt.Dimension(6, 24));
        jTEcpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTEcpfFocusLost(evt);
            }
        });
        jTEcpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEcpfActionPerformed(evt);
            }
        });
        jTEcpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEcpfKeyTyped(evt);
            }
        });

        jTbairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTbairro.setEnabled(false);
        jTbairro.setMaximumSize(new java.awt.Dimension(6, 24));
        jTbairro.setMinimumSize(new java.awt.Dimension(6, 24));
        jTbairro.setName(""); // NOI18N

        jLabel10.setText("Fone 1:");

        jLabel6.setText("Cidade:");

        jTDoc.setEditable(false);

        jTrg.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTrg.setEnabled(false);
        jTrg.setMaximumSize(new java.awt.Dimension(6, 24));
        jTrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTrgFocusLost(evt);
            }
        });
        jTrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTrgKeyTyped(evt);
            }
        });

        jTDocrg.setEditable(false);

        jTnumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTnumero.setEnabled(false);
        jTnumero.setMaximumSize(new java.awt.Dimension(6, 24));
        jTnumero.setMinimumSize(new java.awt.Dimension(6, 24));
        jTnumero.setName(""); // NOI18N

        jLabel7.setText("Numero:");

        try {
            jFfone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfone1.setEnabled(false);
        jFfone1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFfone1FocusLost(evt);
            }
        });

        jLabel11.setText("Fone 2:");

        try {
            jFfone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfone2.setEnabled(false);

        jLabel8.setText("Bairro:");

        jTCidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTCidade.setEnabled(false);
        jTCidade.setMaximumSize(new java.awt.Dimension(6, 24));
        jTCidade.setMinimumSize(new java.awt.Dimension(6, 24));
        jTCidade.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTEcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTDocrg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFfone1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jFfone2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 5, Short.MAX_VALUE))
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
                    .addComponent(jTDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTDocrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFfone2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jFfone1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
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

        jBSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        jBSave.setToolTipText("SALVAR");
        jBSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBSave.setEnabled(false);
        jBSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSaveActionPerformed(evt);
            }
        });

        jBEUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/euser.png"))); // NOI18N
        jBEUser.setToolTipText("EDITAR CLIENTE");
        jBEUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEUser.setEnabled(false);
        jBEUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBEUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBSave, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
            .addComponent(jBEUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jPanel3.add(qdcentro, java.awt.BorderLayout.CENTER);

        jTUsuario.addTab("Usuários", jPanel3);

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

        getAccessibleContext().setAccessibleName("Usuários");

        setBounds(0, 0, 1278, 637);
    }// </editor-fold>//GEN-END:initComponents

    private void jTEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTEmailFocusLost
        // TODO add your handling code here:
        if (jTEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O Cadastro deve possuir e-mail!");
            jTEmail.requestFocus();
        }
    }//GEN-LAST:event_jTEmailFocusLost

    private void jTnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnomeFocusLost
        // TODO add your handling code here:
        if (jTnome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O CAMPO NOME NÃO PODE FICAR VAZIO!");
            jTnome.requestFocus();
        }
    }//GEN-LAST:event_jTnomeFocusLost

    private void jTUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsersMouseClicked
        // TODO add your handling code here:
            jTnome.setText("");
            jTrg.setText("");
            jTEcpf.setText("");
            jTEndereco.setText("");
            jTnumero.setText("S/N");
            jTCidade.setText("");
            jTbairro.setText("");
            jTEmail.setText("");
            jFfone1.setText("");
            jFfone2.setText("");      
       
        
        
        jTnome.setEnabled(false);
         jTEmail.setEnabled(false);
        jTEndereco.setEnabled(false);
        jBSave.setEnabled(false);
        jBEUser.setEnabled(true); 
        jTEcpf.setEnabled(false);
        jTrg.setEnabled(false);
        jTCidade.setEnabled(false);
        jTbairro.setEnabled(false);
        jTnumero.setEnabled(false);
        jFfone1.setEnabled(false);
        jFfone2.setEnabled(false);
        
        
        String cpf_cliente =""+jTUsers.getValueAt(jTUsers.getSelectedRow(), 1);
        conex.conexao();
        conex.executarSql("SELECT *FROM client WHERE cpf ='"+cpf_cliente+"'");
        //conex.executarSql("SELECT DISTINCT CLIENTES from clientes ='"+nome_cliente+"'");
        try{
         conex.rs.first();
         jTnome.setText(conex.rs.getString("Nome"));
         jTEcpf.setText(conex.rs.getString("cpf"));
         jTCidade.setText(conex.rs.getString("municipio"));
         jTDoc.setText(conex.rs.getString("cpfn"));
         jTDocrg.setText(conex.rs.getString("registron"));
         jTrg.setText(conex.rs.getString("rg"));
         jTEndereco.setText(conex.rs.getString("endereco"));
         jTbairro.setText(conex.rs.getString("bairro"));
         jTnumero.setText(conex.rs.getString("numero"));
         jTEmail.setText(conex.rs.getString("email"));
         jFfone1.setText(conex.rs.getString("fone1"));
         jFfone2.setText(conex.rs.getString("fone2"));
         //jTusuario.setText(conex.rs.getString("usuario"));
        // jCsexo.setSelectedItem(conex.rs.getString("sexo"));
         //jCocargo.setSelectedItem(conex.rs.getString("cargo"));
        }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao selecionar usuário!"+ex);
       //jTnome.setEnabled(false);
      // jTUsers.setEnabled(false);

         //at=0;
        
        
    }
        
        conex.desconecta();
        
        
    }//GEN-LAST:event_jTUsersMouseClicked

    private void jBEUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEUserActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "Lembrete Luciano: Adicionar chamada de classe para edição");
        jTnome.setEnabled(true);
        jTEcpf.setEnabled(true);
        jTrg.setEnabled(true);
        jTEndereco.setEnabled(true);
        jTCidade.setEnabled(true);
        jTbairro.setEnabled(true);
        jTnumero.setEnabled(true);
        jTEmail.setEnabled(true);
        jFfone1.setEnabled(true);
       jFfone2.setEnabled(true);
       jBEUser.setEnabled(false);
       //jTUsers.setEnabled(false);
       jBSave.setEnabled(true);
    }//GEN-LAST:event_jBEUserActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        // TODO add your handling code here:
               switch(jTnumero.getText()){
            case "":
            JOptionPane.showMessageDialog(rootPane,"ENDEREÇO SEM NUMERO");
            jTnumero.setText("S/N");
            break;
        } 

                if(jTnome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o nome do cliente para continuar");
            jTnome.requestFocus();
        }else if(jTEcpf.getText().isEmpty()){
            if(jTDoc.getText().equals("CPF")){
              JOptionPane.showMessageDialog(null, "Preencha o campo com o CPF do cliente para continuar");  
            }else if(jTDoc.getText().equals("CNPJ")){
                JOptionPane.showMessageDialog(null, "Preencha o campo com o CNPF da empresa para continuar");
            }
            jTEcpf.requestFocus();
        }else if(jTrg.getText().isEmpty()){
            if(jTDocrg.getText().equals("RG")){
              JOptionPane.showMessageDialog(null, "O campo RG não pode ficar vazio!");  
            }else if(jTDocrg.getText().equals("IE")){
                JOptionPane.showMessageDialog(null, "O campo IE não pode ficar vazio!");
            } 
            jTrg.requestFocus();
        }else if(jTEndereco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha um endereço para continuar");
            jTEndereco.requestFocus();
        }else if (flag==0){
            mod.setCliCpf(jTEcpf.getText());
            mod.setCliNome(jTnome.getText());
            mod.setCliRG(jTrg.getText());
            mod.setCliEndereco(jTEndereco.getText());
            mod.setCliNumero(jTnumero.getText());
            mod.setCliBairro(jTbairro.getText());
            mod.setCliMunicipio(jTCidade.getText());
            mod.setCliEmail(jTEmail.getText());
            mod.setCliFone1(jFfone1.getText());
            mod.setCliFone2(jFfone2.getText());
            
            dao.Editar(mod);
            jTnome.setText("");
            jTrg.setText("");
            jTEcpf.setText("");
            jTEndereco.setText("");
            jTnumero.setText("S/N");
            jTCidade.setText("");
            jTbairro.setText("");
            jTEmail.setText("");
            jFfone1.setText("");
            jFfone2.setText("");
            flag  =1;
            jBSave.setEnabled(false);
            jTUsers.setEnabled(true);

            
        }       
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jTEcpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTEcpfFocusLost
        // TODO add your handling code here:
        String cpf = jTEcpf.getText();
        String cnpj = jTEcpf.getText();
        String documento = jTEcpf.getText();
        if (jTEcpf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "ESTE CAMPO NÃO PODE FICAR VAZIO!");
            jTEcpf.requestFocus();
        }
        if(jTDoc.getText()== "CPF"){
            CPF pf = new CPF(documento);
            if(pf.isCPF()){

            }else{
                JOptionPane.showMessageDialog(rootPane,"CPF inválido!");
            }
        }else{
            CNPJ pj = new CNPJ(documento);
            if(pj.isCNPJ()){

            }else{
                JOptionPane.showMessageDialog(rootPane,"CNPJ inválido!");
            }
        }
    }//GEN-LAST:event_jTEcpfFocusLost

    private void jTEcpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEcpfKeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_jTEcpfKeyTyped

    private void jTrgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTrgFocusLost
        // TODO add your handling code here:
        if (jTrg.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O CAMPO REGISTRO NÃO PODE FICAR VAZIO!");
            jTrg.requestFocus();
        }
    }//GEN-LAST:event_jTrgFocusLost

    private void jTrgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTrgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTrgKeyTyped

    private void jTEcpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEcpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEcpfActionPerformed

    private void jTEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTEnderecoFocusLost
        // TODO add your handling code here:
        if (jTEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O CAMPO ENDEREÇO NÃO PODE FICAR VAZIO!");
            jTEndereco.requestFocus();
        }
    }//GEN-LAST:event_jTEnderecoFocusLost

    private void jFfone1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFfone1FocusLost
        // TODO add your handling code here:
        if (jFfone1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "FAVOR INFORMAR AO MENOS UM NUMERO PARA CONTATO!");
            jFfone1.requestFocus();
        }
    }//GEN-LAST:event_jFfone1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEUser;
    private javax.swing.JButton jBSave;
    private javax.swing.JFormattedTextField jFfone1;
    private javax.swing.JFormattedTextField jFfone2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCidade;
    private javax.swing.JTextField jTDoc;
    private javax.swing.JTextField jTDocrg;
    private javax.swing.JTextField jTEcpf;
    private javax.swing.JTextField jTEmail;
    private javax.swing.JTextField jTEndereco;
    private javax.swing.JTable jTUsers;
    private javax.swing.JTabbedPane jTUsuario;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTbairro;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTnumero;
    private javax.swing.JTextField jTrg;
    private javax.swing.JPanel qdcentro;
    // End of variables declaration//GEN-END:variables
}