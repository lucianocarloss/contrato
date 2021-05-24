/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Ferramenta.ConexaoBD;
import Ferramenta.Usuarios;
import Model.M_usuarios;
import Model.TabelasUser;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


/**
 *
 * @author Luciano
 */
public class Cad_Usuario extends javax.swing.JInternalFrame {
    
    ConexaoBD conex = new ConexaoBD();
    Usuarios mod =new Usuarios();
    M_usuarios dao =new M_usuarios();
    int flag=0;
    int at=1;
    
    
    /**
     * Creates new form Cadastro
     */
    public Cad_Usuario() {
        initComponents();
         preencherTabela("Select * FROM user");
        
    
    
    
    }
    
    
    public void preencherTabela(String Sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String [] {"Nome","cargo"};
        conex.conexao();
        conex.executarSql(Sql);
        try{
            
            //dados.add(new Object[]{conex.rs.getString("PROJETO")});
            conex.rs.first();
            do{
                dados.add(new Object[]{conex.rs.getString("Nome"),conex.rs.getString("cargo")});
                //conex.rs.next();
            }while(conex.rs.next());
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"ERRO AO PREENCHER LISTA DE USUARIOS"+ex);
            
        }
        TabelasUser modelo = new TabelasUser(dados, colunas);
        jTUsers.setModel(modelo);
        jTUsers.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTUsers.getColumnModel().getColumn(0).setResizable(false);
        jTUsers.getColumnModel().getColumn(1).setPreferredWidth(80);
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
        jTemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jCsexo = new javax.swing.JComboBox();
        jCocargo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFfone1 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jTusuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTUsers = new javax.swing.JTable();
        jConivel = new javax.swing.JComboBox();
        jPcad_senha = new javax.swing.JPasswordField();
        jPconf_senha = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBSave = new javax.swing.JButton();
        jBEUser = new javax.swing.JButton();
        jBnovo = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CADASTRO DE USUÁRIOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
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

        jLabel3.setText("E-mail:");

        jTemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTemail.setEnabled(false);
        jTemail.setMaximumSize(new java.awt.Dimension(6, 24));
        jTemail.setMinimumSize(new java.awt.Dimension(6, 24));
        jTemail.setName(""); // NOI18N

        jLabel4.setText("Sexo:");

        jLabel5.setText("Cargo:");

        jCsexo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCsexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "Masculino", "Feminino" }));
        jCsexo.setEnabled(false);

        jCocargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCocargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "Financeiro", "Vendas", "Diretor", "Projetista", "Gerente" }));
        jCocargo.setEnabled(false);

        jLabel9.setText("Usuário:");

        jLabel17.setText("Senha:");

        jLabel20.setText("Fone 1:");

        try {
            jFfone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFfone1.setEnabled(false);
        jFfone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFfone1ActionPerformed(evt);
            }
        });

        jLabel21.setText("Nivel:");

        jTusuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTusuario.setEnabled(false);
        jTusuario.setMaximumSize(new java.awt.Dimension(6, 24));
        jTusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTusuarioFocusLost(evt);
            }
        });

        jTUsers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cargo"
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
            jTUsers.getColumnModel().getColumn(1).setResizable(false);
        }

        jConivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jConivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "Administrador", "Usuário" }));
        jConivel.setEnabled(false);

        jPcad_senha.setEnabled(false);
        jPcad_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPcad_senhaActionPerformed(evt);
            }
        });

        jPconf_senha.setEnabled(false);
        jPconf_senha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPconf_senhaFocusLost(evt);
            }
        });

        jLabel18.setText("Confirmação:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCocargo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFfone1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel21)
                                        .addGap(13, 13, 13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPcad_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jPconf_senha))
                                    .addComponent(jConivel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jCsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCocargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20)
                    .addComponent(jFfone1)
                    .addComponent(jConivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPcad_senha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jTusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jPconf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jBEUser.setToolTipText("EDITAR USUÁRIO");
        jBEUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEUser.setEnabled(false);
        jBEUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEUserActionPerformed(evt);
            }
        });

        jBnovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/suser.png"))); // NOI18N
        jBnovo.setToolTipText("NOVO USUÁRIO");
        jBnovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(jBnovo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBEUser, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBEUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jBnovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentroLayout = new javax.swing.GroupLayout(qdcentro);
        qdcentro.setLayout(qdcentroLayout);
        qdcentroLayout.setHorizontalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        qdcentroLayout.setVerticalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

        setBounds(0, 0, 946, 553);
    }// </editor-fold>//GEN-END:initComponents

    private void jFfone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFfone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFfone1ActionPerformed

    private void jTusuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTusuarioFocusLost
        // TODO add your handling code here:
        if (jTusuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VOCÊ PRECISA UM USUARIO P/ LOGAR!");

        }
    }//GEN-LAST:event_jTusuarioFocusLost

    private void jTnomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTnomeFocusLost
        // TODO add your handling code here:
        if (jTnome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VOCÊ PRECISA DIGITAR O NOME DO USUÁRIO!");

        }
    }//GEN-LAST:event_jTnomeFocusLost

    private void jTUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsersMouseClicked
        // TODO add your handling code here:
      
       
        
        jCocargo.setEnabled(false);
        jTnome.setEnabled(false);
         jTusuario.setEnabled(false);
        jPcad_senha.setEnabled(false);
        jTemail.setEnabled(false);
        jCsexo.setEnabled(false);
        jFfone1.setEnabled(false);
        jConivel.setEnabled(false);
        jBSave.setEnabled(false);
        jBEUser.setEnabled(true);       
        String nome_cliente =""+jTUsers.getValueAt(jTUsers.getSelectedRow(), 0);
        conex.conexao();
        conex.executarSql("SELECT *FROM user WHERE Nome ='"+nome_cliente+"'");
        //conex.executarSql("SELECT DISTINCT CLIENTES from clientes ='"+nome_cliente+"'");
        try{
         conex.rs.first();
         jTnome.setText(conex.rs.getString("Nome"));
         jTemail.setText(conex.rs.getString("email"));
         jTusuario.setText(conex.rs.getString("usuario"));
         jFfone1.setText(conex.rs.getString("fone"));
         jPcad_senha.setText(conex.rs.getString("senha"));
         jCsexo.setSelectedItem(conex.rs.getString("sexo"));
         jConivel.setSelectedItem(conex.rs.getString("nivel"));
         jCocargo.setSelectedItem(conex.rs.getString("cargo"));
        }catch (SQLException ex){
        JOptionPane.showMessageDialog(null, "Erro ao selecionar usuário!"+ex);
        jBnovo.setEnabled(true);
       //jTnome.setEnabled(false);
      // jTUsers.setEnabled(false);

         //at=0;
        
        
    }
        
        conex.desconecta();
        
        
    }//GEN-LAST:event_jTUsersMouseClicked

    private void jBnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnovoActionPerformed
        // TODO add your handling code here:
        at=1;
            jTusuario.setText("");
            jTemail.setText("");
            jPcad_senha.setText("");
            jTnome.setText("");
            jFfone1.setText("");
            jTusuario.setEnabled(false);
            jTemail.setEnabled(false);
            jPcad_senha.setEnabled(false);
            jTnome.setEnabled(false);
            jFfone1.setEnabled(false);
            jCocargo.setSelectedIndex(0);
            jConivel.setSelectedIndex(0);
            jCsexo.setSelectedIndex(0);
            flag  =1;
        jTnome.setEnabled(true);
        jTUsers.setEnabled(true);
        jTusuario.setEnabled(true);
        jPcad_senha.setEnabled(true);
        jTemail.setEnabled(true);
        jCocargo.setEnabled(true);
        jCsexo.setEnabled(true);
        jFfone1.setEnabled(true);
        jConivel.setEnabled(true);
        jBSave.setEnabled(true);
        jBnovo.setEnabled(false);

        
    }//GEN-LAST:event_jBnovoActionPerformed

    private void jBEUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEUserActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Lembrete Luciano: Adicionar chamada de classe para edição");
        //jTnome.setEnabled(true);
        //jTUsers.setEnabled(true);
        //jTusuario.setEnabled(true);
        //jPcad_senha.setEnabled(true);
        //jTemail.setEnabled(true);
        //jCocargo.setEnabled(true);
        //jCsexo.setEnabled(true);
        //jFfone1.setEnabled(true);
        //jConivel.setEnabled(true);
       // jBEUser.setEnabled(false);
       // jBSave.setEnabled(true);
    }//GEN-LAST:event_jBEUserActionPerformed

    private void jBSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSaveActionPerformed
        // TODO add your handling code here:
        if(jTusuario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha um nome de usuário para continuar");
            jTUsuario.requestFocus();
        }else if(jTnome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha um nome de nome para continuar");
            jTnome.requestFocus();
        }else if(jConivel.getSelectedItem().equals("...")){
            JOptionPane.showMessageDialog(null, "Voce deve definir o nível de acesso para continuar");
            jConivel.requestFocus();
        }else if (flag==1){
            mod.setUsuNome(jTnome.getText());
            mod.setUsuEmail(jTemail.getText());
            mod.setUsuFone(jFfone1.getText());
            mod.setUsuUsuario(jTusuario.getText());
            mod.setUsuSenha(jPcad_senha.getText());
            mod.setUsuSexo((String) jCsexo.getSelectedItem());
            mod.setUsuCargo((String) jCocargo.getSelectedItem());
            mod.setUsuNivel((String) jConivel.getSelectedItem());
            dao.Salvar(mod);
            jTusuario.setText("");
            jTemail.setText("");
            jPcad_senha.setText("");
            jTnome.setText("");
            jFfone1.setText("");
            jTusuario.setEnabled(false);
            jTemail.setEnabled(false);
            jPcad_senha.setEnabled(false);
            jTnome.setEnabled(false);
            jFfone1.setEnabled(false);
            jCocargo.setSelectedIndex(0);
            jConivel.setSelectedIndex(0);
            jCsexo.setSelectedIndex(0);
            jCocargo.setEnabled(false);
            jConivel.setEnabled(false);
            jCsexo.setEnabled(false);
            preencherTabela("Select * FROM user");
            
        }
    }//GEN-LAST:event_jBSaveActionPerformed

    private void jPconf_senhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPconf_senhaFocusLost
        // TODO add your handling code here:
        if (!jPcad_senha.getText().equals(jPconf_senha)){
        JOptionPane.showMessageDialog(null, "AS SENHAS ESTÃO DIFERENTES!!");
        jPconf_senha.requestFocus();
       
    }
        
    }//GEN-LAST:event_jPconf_senhaFocusLost

    private void jPcad_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPcad_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPcad_senhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEUser;
    private javax.swing.JButton jBSave;
    private javax.swing.JButton jBnovo;
    private javax.swing.JComboBox jCocargo;
    private javax.swing.JComboBox jConivel;
    private javax.swing.JComboBox jCsexo;
    private javax.swing.JFormattedTextField jFfone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPcad_senha;
    private javax.swing.JPasswordField jPconf_senha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTUsers;
    private javax.swing.JTabbedPane jTUsuario;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTemail;
    private javax.swing.JTextField jTnome;
    private javax.swing.JTextField jTusuario;
    private javax.swing.JPanel qdcentro;
    // End of variables declaration//GEN-END:variables
}
