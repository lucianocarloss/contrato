/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interfaces;

import Ferramenta.ConexaoBD;
import Ferramenta.contrato;
import Model.AutocompletarCliente;
import Model.Logado;
import Model.M_contrato;
import Model.Operaciones;
import java.awt.Desktop;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//replace
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.apache.poi.hwpf.HWPFDocument;

//parcelas


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 *
 * @author Luciano
 */
public class N_Contratos extends javax.swing.JInternalFrame {
    contrato mod = new contrato();
    M_contrato dao = new M_contrato();
   Operaciones operacion = new Operaciones();
       ConexaoBD conex = new ConexaoBD();
       ConexaoBD conexc = new ConexaoBD();
       
           private File inputFile = null;
    private HWPFDocument document = null;
    private HashMap<String, String> replacementText = null;
    private Set<String> keys = null;
    DefaultTableModel Jtabela;
    
    /**
     * Creates new form Cadastro
     */
    public N_Contratos () { 
        
        {
        
        
       initComponents();  
        
                
                      
        
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        jTabbedPane1.setEnabledAt(4, false);
        
        data();
        orcamento();
        
        AutocompletarCliente a = new AutocompletarCliente();
        a.MostrarDados(boxNombre);
        
        
        
        
        
        
        
        
              boxNombre.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
        
            @Override
            public void keyReleased(KeyEvent evt) {

                String cadenaEscrita = boxNombre.getEditor().getItem().toString();

                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                   if(comparar(cadenaEscrita)){// compara si el texto escrito se ecuentra en la lista
                       // busca el texto escrito en la base de datos
 //                      buscar(cadenaEscrita);
                   }else{// en caso contrario toma como default el elemento 0 o sea el primero de la lista y lo busca.
//                    buscar(boxNombre.getItemAt(0).toString());
                    boxNombre.setSelectedIndex(0);
                    }
                }


                if (evt.getKeyCode() >= 65 && evt.getKeyCode() <= 90 || evt.getKeyCode() >= 96 && evt.getKeyCode() <= 105 || evt.getKeyCode() == 8) {
                    boxNombre.setModel(operacion.getLista(cadenaEscrita));
                    if (boxNombre.getItemCount() > 0) {
                        boxNombre.getEditor().setItem(cadenaEscrita);
                        boxNombre.showPopup();                     

                    } else {
                        boxNombre.addItem(cadenaEscrita);
                    }
                }
            }
        });
        

        

        
        
        
        
    }
    
    
    //public InsertText(String filename, HashMap<String, String> replacementText) throws NullPointerException, IllegalArgumentException {

   // N_Contratos() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
         
        // Not strictly necessary as a similar exception will be thrown on
        // instantiation of the File object later. Still like to test the parameters though.
    
    }
    
    private void grava (){
        
        String nfcont = jTn_contrato.getText();
            mod.setClicontrato(jTn_contrato.getText());
            mod.setCliccpf(jTCPF.getText());
            mod.setCliconome(jTEnome.getText());
            mod.setClicrg(jTREGISTRO.getText());
            mod.setClicendereco(jTENDERECO.getText());
            mod.setClicnumero(jTNUMERO.getText());
            mod.setCliccidade(jTCIDADE.getText());
            mod.setClicbairro(jTBAIRRO.getText());
            mod.setCliccep(jFEcep.getText());
            mod.setClicuf(jTUF.getText());
            mod.setCliccomplemento(jTCOMP.getText());
            mod.setClicemail(jTEMAIL.getText());
            mod.setClicfone1(jFFONE1.getText());
            mod.setClicfone2(jFFONE2.getText());
            mod.setClicentrega(jTenderecoe.getText());
            mod.setClicitens(jTmodulos.getText());
            mod.setClicamb1(jTAmbiente1.getText());
            mod.setClicamb2(jTAmbiente2.getText());
            mod.setClicamb3(jTAmbiente3.getText());
            mod.setClicamb4(jTAmbiente4.getText());
            mod.setClicamb5(jTAmbiente5.getText());
            mod.setClicamb6(jTAmbiente6.getText());
            mod.setClicamb7(jTAmbiente7.getText());
            mod.setClicamb8(jTAmbiente8.getText());
            mod.setClicval1(jTAvalor1.getText());
            mod.setClicval2(jTAvalor2.getText());
            mod.setClicval3(jTAvalor3.getText());
            mod.setClicval4(jTAvalor4.getText());
            mod.setClicval5(jTAvalor5.getText());
            mod.setClicval6(jTAvalor6.getText());
            mod.setClicval7(jTAvalor7.getText());
            mod.setClicval8(jTAvalor8.getText());
            mod.setClictotal(jTAtotal.getText());
            mod.setClicdata("2018");
            dao.SalvarC(mod);
            
            JOptionPane.showMessageDialog(null, "DADOS DO CONTRATO "+nfcont+" SALVOS COM SUCESSO!");
            
        //JOptionPane.showMessageDialog(null, "DADOS DO CONTRATO  SALVOS COM SUCESSO!");
        
    }
    
    public void exportarNome(Logado loga){
            
        jTuser.setText(loga.getNome());
    }
    
     
     
     //final aqui
    
        public void buscar(String nombre) {
        String datos[] = operacion.buscar(nombre);

        if (datos[0] != null) {
            jTextField1.setText(datos[0]);
            jTREGISTRO.setText(datos[1]);
            //jTextField3.setText(datos[2]);
            jTentrada.setText(datos[3]);

        } else {

           // JOptionPane.showMessageDialog(rootPane, "No se encontro ningun archivo", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
 
            private boolean comparar(String cadena){
    Object [] lista=boxNombre.getComponents();
    boolean encontrado=false;
        for (Object object : lista) {
            if(cadena.equals(object)){
                encontrado=true;
              break;
            }

        }
       return encontrado;
    }
 
    public void data() {
    
        Date a = new Date();       
a.setDate(a.getDate() + 35);        
 
String formato = "dd/MM/yyyy";
SimpleDateFormat dataFormatada = new SimpleDateFormat(formato); 
jTmontagem.setText(dataFormatada.format(a));
//System.out.println("Daqui há dez dias: " + dataFormatada.format(a));
}
    
    public void orcamento(){
        
        conex.conexao();
        conex.executarSql("Select Top 1 * from contratos Order by id Desc");
       try {
           conex.rs.first();
            Integer id = (conex.rs.getInt("id2"));
            id++;
            String idt = String.valueOf(id);
            jTn_contrato.setText(idt);
       } catch (SQLException ex) {
           Logger.getLogger(N_Contratos.class.getName()).log(Level.SEVERE, null, ex);
       }
       conex.desconecta();
        
    }
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        qdcentro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTREGISTRO = new javax.swing.JTextField();
        jTPESSOA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTCOMP = new javax.swing.JTextField();
        jTNUMERO = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTBAIRRO = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jFCEP = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jFFONE1 = new javax.swing.JFormattedTextField();
        jFFONE2 = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jTENDERECO = new javax.swing.JTextField();
        jTCIDADE = new javax.swing.JTextField();
        jTEMAIL = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTCPF = new javax.swing.JTextField();
        jTUF = new javax.swing.JTextField();
        boxNombre = new javax.swing.JComboBox();
        jLenderecoe = new javax.swing.JLabel();
        jTenderecoe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        qdcentro4 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTmodulos = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jBNext_Itens = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanelJanela4 = new javax.swing.JPanel();
        qdcentro2 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTAmbiente1 = new javax.swing.JTextField();
        jTAvalor1 = new javax.swing.JTextField();
        jTAtotal = new javax.swing.JTextField();
        jTAmbiente2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTAvalor2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTAmbiente3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTAmbiente4 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTAvalor3 = new javax.swing.JTextField();
        jTAvalor4 = new javax.swing.JTextField();
        jTAvalor8 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jTAmbiente7 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTAmbiente8 = new javax.swing.JTextField();
        jTAvalor7 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTAmbiente6 = new javax.swing.JTextField();
        jTAvalor6 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTAvalor5 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTAmbiente5 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jTqtd8 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTqtd7 = new javax.swing.JTextField();
        jTqtd6 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTqtd5 = new javax.swing.JTextField();
        jTqtd4 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jTqtd3 = new javax.swing.JTextField();
        jTqtd2 = new javax.swing.JTextField();
        jTqtd1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jBeditc = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabeljj1 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanelJanela3 = new javax.swing.JPanel();
        qdcentro1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jCCondicao = new javax.swing.JComboBox();
        jCForma = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        MinhaTabela = new javax.swing.JTable();
        jCParcela = new javax.swing.JComboBox();
        jTtotal = new javax.swing.JTextField();
        jTentrada = new javax.swing.JTextField();
        jFdataEn = new javax.swing.JFormattedTextField();
        jTtotal2 = new javax.swing.JTextField();
        jTBCalc = new javax.swing.JButton();
        jBLimpar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabeljj = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        qdcentro3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTn_contrato = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jCEuf = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jTEcomp = new javax.swing.JTextField();
        jTEnumero = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTEbairro = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jFEcep = new javax.swing.JFormattedTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jFEfone1 = new javax.swing.JFormattedTextField();
        jFEfone2 = new javax.swing.JFormattedTextField();
        jLabel44 = new javax.swing.JLabel();
        jTEendereco = new javax.swing.JTextField();
        jTEcidade = new javax.swing.JTextField();
        jTEemail = new javax.swing.JTextField();
        jTmontagem = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTEnome = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jTEenderecoee = new javax.swing.JTextField();
        jLenderecoee = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTuser = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jBEvolta = new javax.swing.JButton();
        jTfcontrato = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(109, 109, 109));
        setClosable(true);
        setIconifiable(true);
        setTitle("CONTRATO");
        setMaximumSize(new java.awt.Dimension(1024, 720));
        setMinimumSize(new java.awt.Dimension(805, 402));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRATO - CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);

        jLabel2.setText("Nome:");

        jLabel3.setText("RG/IE:");

        jTREGISTRO.setEditable(false);
        jTREGISTRO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTREGISTRO.setMaximumSize(new java.awt.Dimension(6, 24));
        jTREGISTRO.setMinimumSize(new java.awt.Dimension(6, 24));
        jTREGISTRO.setName(""); // NOI18N

        jTPESSOA.setEditable(false);
        jTPESSOA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTPESSOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPESSOAActionPerformed(evt);
            }
        });

        jLabel11.setText("Pessoa:");

        jLabel12.setText("UF:");

        jLabel7.setText("Endereço:");

        jLabel14.setText("Complemento:");

        jTCOMP.setEditable(false);
        jTCOMP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTNUMERO.setEditable(false);
        jTNUMERO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel15.setText("Número:");

        jLabel16.setText("Município:");

        jTBAIRRO.setEditable(false);
        jTBAIRRO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel17.setText("Bairro:");

        jLabel18.setText("CEP:");

        jFCEP.setEditable(false);
        try {
            jFCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFCEP.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel19.setText("E-mail:");

        jLabel20.setText("Fone 1:");

        jFFONE1.setEditable(false);
        try {
            jFFONE1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFFONE1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jFFONE2.setEditable(false);
        try {
            jFFONE2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFFONE2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setText("Fone 2:");

        jTENDERECO.setEditable(false);
        jTENDERECO.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTENDERECO.setMaximumSize(new java.awt.Dimension(6, 24));

        jTCIDADE.setEditable(false);
        jTCIDADE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTCIDADE.setMaximumSize(new java.awt.Dimension(6, 24));

        jTEMAIL.setEditable(false);
        jTEMAIL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEMAIL.setMaximumSize(new java.awt.Dimension(6, 24));

        jLabel13.setText("CPF/CNPJ:");

        jTCPF.setEditable(false);
        jTCPF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTCPFFocusLost(evt);
            }
        });
        jTCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCPFActionPerformed(evt);
            }
        });

        jTUF.setEditable(false);
        jTUF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        boxNombre.setEditable(true);
        boxNombre.setToolTipText("CLIENTE");
        boxNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNombreActionPerformed(evt);
            }
        });

        jLenderecoe.setText("Entrega:");

        jTenderecoe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTenderecoe.setMaximumSize(new java.awt.Dimension(6, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTENDERECO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTUF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addGap(6, 6, 6))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTREGISTRO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boxNombre, 0, 271, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTPESSOA, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(jFFONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFFONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTCOMP)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLenderecoe, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTenderecoe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jTREGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTPESSOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTNUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel16)
                        .addComponent(jTCIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jTBAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(jTUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jFCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCOMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFFONE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFFONE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLenderecoe)
                    .addComponent(jTenderecoe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setBackground(new java.awt.Color(0, 204, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextf.png"))); // NOI18N
        jButton1.setToolTipText("SEGUIR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField1.setMaximumSize(new java.awt.Dimension(6, 24));
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(371, 371, 371))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout qdcentroLayout = new javax.swing.GroupLayout(qdcentro);
        qdcentro.setLayout(qdcentroLayout);
        qdcentroLayout.setHorizontalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qdcentroLayout.setVerticalGroup(
            qdcentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentroLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(qdcentro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(qdcentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(89, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Cliente", jPanel3);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRATO - ITENS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel19.setAlignmentX(0.0F);
        jPanel19.setAlignmentY(0.0F);

        jTmodulos.setColumns(5);
        jTmodulos.setRows(20);
        jTmodulos.setText("..:EXEMPLO DE PREENCHIMENTO:..\nSALA DIRETOR:\n01 MESA EM MDF COPENHAGEM COM 02 GAVETAS: 1800MM X 750MM X 600MM\n01 PAINEL DE TV COM NICHO EM MDF PRETO: 1300MM X 1200MM\n01 GAVETEIRO COPENHAGEM COM 02 GAVETAS E 01 PASTA SUSPENSA: 3000MM X 750MM X 500M"); // NOI18N
        jTmodulos.setWrapStyleWord(true);
        jTmodulos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTmodulosFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTmodulos);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel61.setBackground(new java.awt.Color(0, 204, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jBNext_Itens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextf.png"))); // NOI18N
        jBNext_Itens.setToolTipText("SEGUIR");
        jBNext_Itens.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBNext_Itens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNext_ItensActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextb.png"))); // NOI18N
        jButton2.setToolTipText("RETORNAR");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNext_Itens, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(322, 322, 322))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBNext_Itens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentro4Layout = new javax.swing.GroupLayout(qdcentro4);
        qdcentro4.setLayout(qdcentro4Layout);
        qdcentro4Layout.setHorizontalGroup(
            qdcentro4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro4Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(qdcentro4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(74, Short.MAX_VALUE))
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qdcentro4Layout.setVerticalGroup(
            qdcentro4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro4Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(qdcentro4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(qdcentro4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Itens Pedido", jPanel4);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRATO - VALOR AMBIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel22.setAlignmentX(0.0F);
        jPanel22.setAlignmentY(0.0F);

        jLabel5.setText("Ambiente:");

        jLabel25.setText("Valor:");

        jTAmbiente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente1.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente1FocusLost(evt);
            }
        });

        jTAvalor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor1.setText("0");
        jTAvalor1.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTAvalor1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor1FocusLost(evt);
            }
        });
        jTAvalor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor1ActionPerformed(evt);
            }
        });
        jTAvalor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor1KeyTyped(evt);
            }
        });

        jTAtotal.setEditable(false);
        jTAtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAtotal.setToolTipText("VALOR TOTAL.");
        jTAtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAtotalActionPerformed(evt);
            }
        });
        jTAtotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAtotalKeyTyped(evt);
            }
        });

        jTAmbiente2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente2.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente2FocusLost(evt);
            }
        });

        jLabel8.setText("Ambiente:");

        jTAvalor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor2.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor2.setEnabled(false);
        jTAvalor2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTAvalor2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor2FocusLost(evt);
            }
        });
        jTAvalor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor2ActionPerformed(evt);
            }
        });
        jTAvalor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor2KeyTyped(evt);
            }
        });

        jLabel26.setText("Valor:");

        jLabel27.setText("Ambiente:");

        jTAmbiente3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente3.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente3.setEnabled(false);
        jTAmbiente3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente3FocusLost(evt);
            }
        });

        jLabel28.setText("Ambiente:");

        jTAmbiente4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente4.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente4.setEnabled(false);
        jTAmbiente4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente4FocusLost(evt);
            }
        });

        jLabel29.setText("Valor:");

        jLabel30.setText("Valor:");

        jTAvalor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor3.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor3.setEnabled(false);
        jTAvalor3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor3FocusLost(evt);
            }
        });
        jTAvalor3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor3ActionPerformed(evt);
            }
        });
        jTAvalor3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor3KeyTyped(evt);
            }
        });

        jTAvalor4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor4.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor4.setEnabled(false);
        jTAvalor4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor4FocusLost(evt);
            }
        });
        jTAvalor4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor4ActionPerformed(evt);
            }
        });
        jTAvalor4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor4KeyTyped(evt);
            }
        });

        jTAvalor8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor8.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor8.setEnabled(false);
        jTAvalor8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor8FocusLost(evt);
            }
        });
        jTAvalor8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor8ActionPerformed(evt);
            }
        });
        jTAvalor8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor8KeyTyped(evt);
            }
        });

        jLabel31.setText("Ambiente:");

        jLabel32.setText("Ambiente:");

        jTAmbiente7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente7.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente7.setEnabled(false);
        jTAmbiente7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente7FocusLost(evt);
            }
        });

        jLabel33.setText("Valor:");

        jLabel34.setText("Valor:");

        jTAmbiente8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente8.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente8.setEnabled(false);
        jTAmbiente8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente8FocusLost(evt);
            }
        });

        jTAvalor7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor7.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor7.setEnabled(false);
        jTAvalor7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor7FocusLost(evt);
            }
        });
        jTAvalor7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor7ActionPerformed(evt);
            }
        });
        jTAvalor7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor7KeyTyped(evt);
            }
        });

        jLabel47.setText("Ambiente:");

        jTAmbiente6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente6.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente6.setEnabled(false);
        jTAmbiente6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente6FocusLost(evt);
            }
        });

        jTAvalor6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor6.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor6.setEnabled(false);
        jTAvalor6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor6FocusLost(evt);
            }
        });
        jTAvalor6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor6ActionPerformed(evt);
            }
        });
        jTAvalor6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor6KeyTyped(evt);
            }
        });

        jLabel48.setText("Valor:");

        jTAvalor5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAvalor5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTAvalor5.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTAvalor5.setEnabled(false);
        jTAvalor5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAvalor5FocusLost(evt);
            }
        });
        jTAvalor5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAvalor5ActionPerformed(evt);
            }
        });
        jTAvalor5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAvalor5KeyTyped(evt);
            }
        });

        jLabel49.setText("Valor:");

        jTAmbiente5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTAmbiente5.setToolTipText("NOME DO AMBIENTE PROJETADO.");
        jTAmbiente5.setEnabled(false);
        jTAmbiente5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTAmbiente5FocusLost(evt);
            }
        });

        jLabel50.setText("Ambiente:");

        jLabel51.setText("Total:");

        jButton8.setText("Finalizar");
        jButton8.setToolTipText("FINALIZA EDIÇÃO E SOMA VALORES.");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTqtd8.setEditable(false);
        jTqtd8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd8.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd8.setEnabled(false);
        jTqtd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd8ActionPerformed(evt);
            }
        });
        jTqtd8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd8KeyTyped(evt);
            }
        });

        jLabel52.setText("Qtd:");

        jLabel53.setText("Qtd:");

        jTqtd7.setEditable(false);
        jTqtd7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd7.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd7.setEnabled(false);
        jTqtd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd7ActionPerformed(evt);
            }
        });
        jTqtd7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd7KeyTyped(evt);
            }
        });

        jTqtd6.setEditable(false);
        jTqtd6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd6.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd6.setEnabled(false);
        jTqtd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd6ActionPerformed(evt);
            }
        });
        jTqtd6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd6KeyTyped(evt);
            }
        });

        jLabel54.setText("Qtd:");

        jLabel55.setText("Qtd:");

        jTqtd5.setEditable(false);
        jTqtd5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd5.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd5.setEnabled(false);
        jTqtd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd5ActionPerformed(evt);
            }
        });
        jTqtd5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd5KeyTyped(evt);
            }
        });

        jTqtd4.setEditable(false);
        jTqtd4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd4.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd4.setEnabled(false);
        jTqtd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd4ActionPerformed(evt);
            }
        });
        jTqtd4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd4KeyTyped(evt);
            }
        });

        jLabel56.setText("Qtd:");

        jLabel57.setText("Qtd:");

        jTqtd3.setEditable(false);
        jTqtd3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd3.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd3.setEnabled(false);
        jTqtd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd3ActionPerformed(evt);
            }
        });
        jTqtd3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd3KeyTyped(evt);
            }
        });

        jTqtd2.setEditable(false);
        jTqtd2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd2.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd2.setEnabled(false);
        jTqtd2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTqtd2FocusLost(evt);
            }
        });
        jTqtd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd2ActionPerformed(evt);
            }
        });
        jTqtd2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd2KeyTyped(evt);
            }
        });

        jTqtd1.setEditable(false);
        jTqtd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTqtd1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTqtd1.setText("1");
        jTqtd1.setToolTipText("APENAS NUMEROS EX: 1500.");
        jTqtd1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTqtd1FocusLost(evt);
            }
        });
        jTqtd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTqtd1ActionPerformed(evt);
            }
        });
        jTqtd1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTqtd1KeyTyped(evt);
            }
        });

        jLabel58.setText("Qtd:");

        jLabel59.setText("Qtd:");

        jBeditc.setText("Editar");
        jBeditc.setToolTipText("EDITAR VALORES E AMBIENTES");
        jBeditc.setEnabled(false);
        jBeditc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditcActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jBeditc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTAtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente8))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente7))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente6))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente5))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente4))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente3))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente2))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAmbiente1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTqtd8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTAvalor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jTAmbiente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jTAmbiente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(jTAmbiente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)
                            .addComponent(jTAmbiente4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jTAmbiente5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48)
                            .addComponent(jTAmbiente6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(jTAmbiente7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34)
                            .addComponent(jTAmbiente8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTAvalor8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59)
                            .addComponent(jTqtd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel58)
                            .addComponent(jTqtd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jTqtd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(jTqtd4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(jTqtd5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(jTqtd6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(jTqtd7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel52)
                            .addComponent(jTqtd8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTAtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel51))
                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8)
                        .addComponent(jBeditc)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabeljj1.setBackground(new java.awt.Color(0, 204, 255));
        jLabeljj1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeljj1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeljj1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextf.png"))); // NOI18N
        jButton4.setToolTipText("SEGUIR");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextb.png"))); // NOI18N
        jButton7.setToolTipText("RETORNAR");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(356, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentro2Layout = new javax.swing.GroupLayout(qdcentro2);
        qdcentro2.setLayout(qdcentro2Layout);
        qdcentro2Layout.setHorizontalGroup(
            qdcentro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(qdcentro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qdcentro2Layout.setVerticalGroup(
            qdcentro2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro2Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelJanela4Layout = new javax.swing.GroupLayout(jPanelJanela4);
        jPanelJanela4.setLayout(jPanelJanela4Layout);
        jPanelJanela4Layout.setHorizontalGroup(
            jPanelJanela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanelJanela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(qdcentro2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJanela4Layout.setVerticalGroup(
            jPanelJanela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
            .addGroup(jPanelJanela4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelJanela4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(qdcentro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelJanela4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addComponent(jPanelJanela4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Valor Ambientes", jPanel8);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRATO - PAGAMENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel16.setAlignmentX(0.0F);
        jPanel16.setAlignmentY(0.0F);

        jLabel4.setText("Total:");

        jLabel22.setText("Parcelas:");

        jCCondicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Á Vista", "Parcelado" }));
        jCCondicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCondicaoActionPerformed(evt);
            }
        });

        jCForma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Cheque", "Cartão" }));
        jCForma.setEnabled(false);

        MinhaTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        MinhaTabela.setShowHorizontalLines(false);
        MinhaTabela.setShowVerticalLines(false);
        jScrollPane2.setViewportView(MinhaTabela);

        jCParcela.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCParcela.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1X", "2X", "3X", "4X", "5X", "6X", "7X", "8X", "9X", "10X", "..." }));
        jCParcela.setEnabled(false);

        jTtotal.setEditable(false);
        jTtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTentrada.setEditable(false);
        jTentrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTentrada.setText("0");

        jFdataEn.setEditable(false);
        try {
            jFdataEn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTtotal2.setEditable(false);
        jTtotal2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTtotal2.setEnabled(false);
        jTtotal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTtotal2ActionPerformed(evt);
            }
        });

        jTBCalc.setText("Calcular");
        jTBCalc.setEnabled(false);
        jTBCalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBCalcActionPerformed(evt);
            }
        });

        jBLimpar.setText("Limpar");
        jBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimparActionPerformed(evt);
            }
        });

        jLabel9.setText("Hoje:");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFdataEn, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jTtotal, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addComponent(jCCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCParcela, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jBLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jTBCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jCForma, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGap(0, 627, Short.MAX_VALUE)
                        .addComponent(jTtotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(jCCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTBCalc)))
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCForma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBLimpar)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFdataEn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTtotal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabeljj.setBackground(new java.awt.Color(0, 204, 255));
        jLabeljj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeljj, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeljj, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextf.png"))); // NOI18N
        jButton3.setToolTipText("SEGUIR");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextb.png"))); // NOI18N
        jButton6.setToolTipText("RETORNAR");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(338, 338, 338))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentro1Layout = new javax.swing.GroupLayout(qdcentro1);
        qdcentro1.setLayout(qdcentro1Layout);
        qdcentro1Layout.setHorizontalGroup(
            qdcentro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(qdcentro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qdcentro1Layout.setVerticalGroup(
            qdcentro1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro1Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanelJanela3Layout = new javax.swing.GroupLayout(jPanelJanela3);
        jPanelJanela3.setLayout(jPanelJanela3Layout);
        jPanelJanela3Layout.setHorizontalGroup(
            jPanelJanela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanelJanela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(qdcentro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelJanela3Layout.setVerticalGroup(
            jPanelJanela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(jPanelJanela3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelJanela3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(qdcentro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelJanela3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addComponent(jPanelJanela3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jTabbedPane1.addTab("Pagamento", jPanel5);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTRATO - FINALIZAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel9.setAlignmentX(0.0F);
        jPanel9.setAlignmentY(0.0F);

        jLabel10.setText("Contrato Nº:");

        jTn_contrato.setEditable(false);
        jTn_contrato.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTn_contrato.setMaximumSize(new java.awt.Dimension(6, 24));
        jTn_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTn_contratoActionPerformed(evt);
            }
        });

        jLabel35.setText("UF:");

        jCEuf.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCEuf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jCEuf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel36.setText("Endereço:");

        jLabel37.setText("Complemento:");

        jTEcomp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEcomp.setEnabled(false);

        jTEnumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEnumero.setEnabled(false);
        jTEnumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEnumeroKeyTyped(evt);
            }
        });

        jLabel38.setText("Número:");

        jLabel39.setText("Município:");

        jTEbairro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEbairro.setEnabled(false);

        jLabel40.setText("Bairro:");

        jLabel41.setText("CEP:");

        try {
            jFEcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFEcep.setEnabled(false);

        jLabel42.setText("E-mail:");

        jLabel43.setText("Fone 1:");

        try {
            jFEfone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFEfone1.setEnabled(false);

        try {
            jFEfone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFEfone2.setEnabled(false);

        jLabel44.setText("Fone 2:");

        jTEendereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEendereco.setEnabled(false);
        jTEendereco.setMaximumSize(new java.awt.Dimension(6, 24));

        jTEcidade.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEcidade.setEnabled(false);
        jTEcidade.setMaximumSize(new java.awt.Dimension(6, 24));

        jTEemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEemail.setEnabled(false);
        jTEemail.setMaximumSize(new java.awt.Dimension(6, 24));

        jTmontagem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTmontagem.setMaximumSize(new java.awt.Dimension(6, 24));
        jTmontagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTmontagemActionPerformed(evt);
            }
        });

        jLabel23.setText("Prev. de Montagem:");

        jTEnome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEnome.setEnabled(false);
        jTEnome.setMaximumSize(new java.awt.Dimension(6, 24));

        jLabel45.setText("Nome:");

        jTEenderecoee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTEenderecoee.setEnabled(false);
        jTEenderecoee.setMaximumSize(new java.awt.Dimension(6, 24));

        jLenderecoee.setText("Endereço:");

        jLabel1.setText("Vendedor");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jTn_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTmontagem, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(62, 62, 62)
                                .addComponent(jTEnome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(301, 301, 301)
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTEbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41)
                                        .addGap(7, 7, 7)
                                        .addComponent(jFEcep, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel35))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jTEendereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel38)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jCEuf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTEnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTEcomp)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jTEcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jTEemail, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel43)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFEfone1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel44)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFEfone2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLenderecoee)
                                    .addComponent(jLabel1))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTEenderecoee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jTuser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTn_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTmontagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTEnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTEendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jTEnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(jCEuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39)
                        .addComponent(jTEcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel40)
                        .addComponent(jTEbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel41))
                    .addComponent(jFEcep, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFEfone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFEfone1)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTEemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel42)))
                        .addGap(14, 14, 14)))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLenderecoee)
                    .addComponent(jTEenderecoee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel46.setBackground(new java.awt.Color(0, 204, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/titup.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 46, Short.MAX_VALUE)
        );

        jBEvolta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nextb.png"))); // NOI18N
        jBEvolta.setToolTipText("RETORNAR");
        jBEvolta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jBEvolta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEvoltaActionPerformed(evt);
            }
        });

        jTfcontrato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ictrok.jpg"))); // NOI18N
        jTfcontrato.setToolTipText("FINALIZAR CONTRATO");
        jTfcontrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfcontratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBEvolta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfcontrato, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBEvolta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTfcontrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout qdcentro3Layout = new javax.swing.GroupLayout(qdcentro3);
        qdcentro3.setLayout(qdcentro3Layout);
        qdcentro3Layout.setHorizontalGroup(
            qdcentro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(qdcentro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qdcentro3Layout.setVerticalGroup(
            qdcentro3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qdcentro3Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(qdcentro3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(qdcentro3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Finalizar", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Contrato");

        getAccessibleContext().setAccessibleName("Clientes");

        setBounds(0, 0, 946, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void jTPESSOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPESSOAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPESSOAActionPerformed

    private void jTCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCPFActionPerformed

    private void jTn_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTn_contratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTn_contratoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(0, false);
        jTabbedPane1.setEnabledAt(1, true);
        
        //jTabbedPane1.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBNext_ItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNext_ItensActionPerformed
        // TODO add your handling code here:
        int li = jTmodulos.getLineCount();
        int lin = jTmodulos.getRows();
        if(jTmodulos.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "ITENS DO CONTRATO VAZIO!");
            jTabbedPane1.setSelectedIndex(1);
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setEnabledAt(1, true);
            
          }else if (li >= 21) {
          JOptionPane.showMessageDialog(null, "DESCULPA, POR HORA TEMOS O LIMITE DE 20 LINHAS");
          }else{
              //JOptionPane.showMessageDialog(null, "OK!");
            jTabbedPane1.setSelectedIndex(2);
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setEnabledAt(1, false);
            jTabbedPane1.setEnabledAt(2, true);
           // int lin = jTmodulos.getRows();
            int max = 20;
                   int tot = max - lin;
                   //jTmodulos.setRows(tot);
                   
          }
        
        
        
    }//GEN-LAST:event_jBNext_ItensActionPerformed

    private void jTmodulosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTmodulosFocusLost
        // TODO add your handling code here:
        
         if(!jTmodulos.getText().isEmpty()){
              jBNext_Itens.setEnabled(true);
          }else{
              //jButton5.setEnabled(false);
          }
    }//GEN-LAST:event_jTmodulosFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                jTabbedPane1.setSelectedIndex(0);
        jTabbedPane1.setEnabledAt(0, true);
        jTabbedPane1.setEnabledAt(1, false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        jCParcela.setSelectedIndex(10);
        jCCondicao.setSelectedItem("Á Vista");
        
        jTabbedPane1.setSelectedIndex(2);
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setEnabledAt(3, false);
        limpar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jBEvoltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEvoltaActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
        jTabbedPane1.setEnabledAt(3, true);
        jTabbedPane1.setEnabledAt(4, false);
        
            jTEnome.setText("");
            jTEendereco.setText("");
            jTEnumero.setText("");
            jTEcidade.setText("");
            jTEbairro.setText("");
            jFEcep.setText("");
            jCEuf.setSelectedItem("...");
            jTEcomp.setText("");
            jTEemail.setText("");
            jFEfone1.setText("");
            jFEfone2.setText("");
    }//GEN-LAST:event_jBEvoltaActionPerformed

    private void jTfcontratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfcontratoActionPerformed
        // TODO add your handling code here:
        //new InsertText(null ,replacementText);
        //String replacementText;
        //String filename;
       //InsertText in = new InsertText(new (1000));
        String idfinal = null;
        if (JOptionPane.showConfirmDialog(null, "Deseja Finalizar o contrato?", "Pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            
             conexc.conexaon();
        conexc.executarSqln("Select Top 1 * from contratos Order by id Desc");
       try {
           conexc.rsc.first();
            Integer iddb = (conexc.rsc.getInt("id2"));
            //iddb++;
             idfinal = String.valueOf(iddb);
            //jTn_contrato.setText(idt);
             //JOptionPane.showMessageDialog(null, "CONTRATO ENCONTRADO "+iddb );
       } catch (SQLException ex) {
           Logger.getLogger(N_Contratos.class.getName()).log(Level.SEVERE, null, ex);
           //JOptionPane.showMessageDialog(null, "erro no db");
       }
         conexc.desconectan();
       if (jTn_contrato.getText().equals(idfinal)){
          
           
           duplicidade tela = new duplicidade();
           tela.setVisible(true);
           dispose();
           //JOptionPane.showMessageDialog(null, "FUNCIONOU" +idfinal);
           grava();
       }
       
        else{
            
            //orcamento();
            //mudei aqui
            
            //jTmodulos.getRows();
            
            //AQUI TRAVEI GRAVAÇÃO
           /* String nfcont = jTn_contrato.getText();
            mod.setClicontrato(jTn_contrato.getText());
            mod.setCliccpf(jTCPF.getText());
            mod.setCliconome(jTEnome.getText());
            mod.setClicrg(jTREGISTRO.getText());
            mod.setClicendereco(jTENDERECO.getText());
            mod.setClicnumero(jTNUMERO.getText());
            mod.setCliccidade(jTCIDADE.getText());
            mod.setClicbairro(jTBAIRRO.getText());
            mod.setCliccep(jFEcep.getText());
            mod.setClicuf(jTUF.getText());
            mod.setCliccomplemento(jTCOMP.getText());
            mod.setClicemail(jTEMAIL.getText());
            mod.setClicfone1(jFFONE1.getText());
            mod.setClicfone2(jFFONE2.getText());
            mod.setClicentrega(jTenderecoe.getText());
            mod.setClicitens(jTmodulos.getText());
            mod.setClicamb1(jTAmbiente1.getText());
            mod.setClicamb2(jTAmbiente2.getText());
            mod.setClicamb3(jTAmbiente3.getText());
            mod.setClicamb4(jTAmbiente4.getText());
            mod.setClicamb5(jTAmbiente5.getText());
            mod.setClicamb6(jTAmbiente6.getText());
            mod.setClicamb7(jTAmbiente7.getText());
            mod.setClicamb8(jTAmbiente8.getText());
            mod.setClicval1(jTAvalor1.getText());
            mod.setClicval2(jTAvalor2.getText());
            mod.setClicval3(jTAvalor3.getText());
            mod.setClicval4(jTAvalor4.getText());
            mod.setClicval5(jTAvalor5.getText());
            mod.setClicval6(jTAvalor6.getText());
            mod.setClicval7(jTAvalor7.getText());
            mod.setClicval8(jTAvalor8.getText());
            mod.setClictotal(jTAtotal.getText());
            mod.setClicdata("2018");
            dao.SalvarC(mod);
            JOptionPane.showMessageDialog(null, "DADOS DO CONTRATO "+nfcont+" SALVOS COM SUCESSO!");
            */
        //String idtc;
            
       
            String data = "dd/MM/yyyy";
		String hora = "h:mm - a";
		String data1, hora1;
		java.util.Date agora = new java.util.Date();;
		SimpleDateFormat formata = new SimpleDateFormat(data);
		data1 = formata.format(agora);
		formata = new SimpleDateFormat(hora);
		hora1 = formata.format(agora);
                
                Date datae =  new Date();
                Locale local = new Locale("pt","BR");
                DateFormat formato = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy",local);
                System.out.println(formato.format(datae));
           
            //String nomecc = null;
            String nomec = null;
            String enderecocc = null;
            String enderecoc = null;
            String cpfc = null;
            String cpfcc = null;
            String registroc = null;
            String registrocc = null;
            String numeroc = null;
            String numerocc = null;
            String cidadec = null;
            String cidadecc = null;
            String bairroc = null;
            String cepc = null;
            String ufc = null;
            String complementoc = null;
            String emailc = null;
            String emailcc = null;
            String fone1cc = null;
            String fone1c = null;
            String fone2cc = null;
            String fone2c = null;
            String produtosc = null;
            String regc = null;
            String regcc = null;
            String totalc = null;
            String entradac = null;
            String entradacc = null;
            String parcelac = null;
            String parcelacc = null;
            String pagamentoc = null;
            String pagamentocc = null;
            String contratocc = null;
            String moedacc = null;
            String parcela = null;
            String ufcc = null;
            String ncontratocc = null;
            String bairrocc = null;
            String moduloscc = null;
            String moduloscc2 = null;
            String moduloscc3 = null;
            String moduloscc4 = null;
            String moduloscc5 = null;
            String moduloscc6 = null;
            String moduloscc7 = null;
            String moduloscc8 = null;
            String moduloscc9 = null;
            String moduloscc10 = null;
            String moduloscc11 = null;
            String moduloscc12 = null;
            String moduloscc13 = null;
            String moduloscc14 = null;
            String moduloscc15 = null;
            String moduloscc16 = null;
            String moduloscc17 = null;
            String moduloscc18 = null;
            String moduloscc19 = null;
            String moduloscc20 = null;
            String moduloscc21 = null;
            String moduloscc22 = null;
            String moduloscc23 = null;
            String moduloscc24 = null;
            String moduloscc25 = null;
            String moduloscc26 = null;
            String moduloscc27 = null;
            String moduloscc28 = null;
            String moduloscc29 = null;
            String moduloscc30 = null;
            String moduloscc31 = null;
            String moduloscc32 = null;
            String moduloscc33 = null;
            String moduloscc34 = null;
            String moduloscc35 = null;
            String moduloscc36 = null;
            String moduloscc37 = null;
            String moduloscc38 = null;
            String moduloscc39 = null;
            String moduloscc40 = null;
            String montagemcc = null;
            String dataco = null;
            String rgco = null;
            String totalco = null;
            String user1 = null;
            
           
            
            
            
            
            enderecocc = jTENDERECO.getText();
            cpfcc = jTCPF.getText();
            registrocc = jTREGISTRO.getText();
            numerocc = jTNUMERO.getText();
            cidadecc = jTCIDADE.getText();
            fone1cc = jFFONE1.getText();
            fone2cc = jFFONE2.getText();
            ncontratocc = "00"+jTn_contrato.getText();
            bairrocc = jTBAIRRO.getText();
            ufcc = jTUF.getText();
            emailc = jTEMAIL.getText();
            user1 = jTuser.getText();
            String ncont = jTn_contrato.getText();
            
            //MÓDULOS
            
            String ab1 = jTAmbiente1.getText();
            String ab2 = jTAmbiente2.getText();
            String ab3 = jTAmbiente3.getText();
            String ab4 = jTAmbiente4.getText();
            String ab5 = jTAmbiente5.getText();
            String ab6 = jTAmbiente6.getText();
            String ab7 = jTAmbiente7.getText();
            String ab8 = jTAmbiente8.getText();
            String qt1 = "";
            String qt2 = "";
            String qt3 = "";
            String qt4 = "";
            String qt5 = "";
            String qt6 = "";
            String qt7 = "";
            String qt8 = "";
            
            String vt1 = "";
            String vt2 = "";
            String vt3 = "";
            String vt4 = "";
            String vt5 = "";
            String vt6 = "";
            String vt7 = "";
            String vt8 = "";
            
            String vun1 = null;
            String vun2 = null;
            String vun3 = null;
            String vun4 = null;
            String vun5 = null;
            String vun6 = null;
            String vun7 = null;
            String vun8 = null;

            
            
            
            
                qt1 = jTqtd1.getText();
                qt2 = jTqtd2.getText();
                qt3 =  jTqtd3.getText();
                qt4 =  jTqtd4.getText();
                qt5 =  jTqtd5.getText();
                qt6 =  jTqtd6.getText();
                qt7 =  jTqtd7.getText();
                qt8 =  jTqtd8.getText();
                vt1 = jTAvalor1.getText();
                vt2 = jTAvalor2.getText();
                vt3 = jTAvalor3.getText();
                vt4 = jTAvalor4.getText();
                vt5 = jTAvalor5.getText();
                vt6 = jTAvalor6.getText();
                vt7 = jTAvalor7.getText();
                vt8 = jTAvalor8.getText();
            
           // moduloscc = jTmodulos.getText();
            cepc = jFCEP.getText();
            montagemcc = jTmontagem.getText();
            totalc = jTtotal.getText();
            String parc1 = " ";
            String parc2 = " ";
            String parc3 = " ";
            String parc4 = " ";
            String parc5 = " ";
            String parc6 = " ";
            String parc7 = " ";
            String parc8 = " ";
            String parc9 = " ";
            String parc10 = " ";
            
            //num
            
            Integer num1;
            Integer num2;
            Integer num3;
            Integer num4;
            Integer num5;
            Integer num6;
            Integer num7;
            Integer num8;
            Integer num9;
            Integer num10;
            
            //data
            
            String dat1 = null;
            String dat2 = null;
            String dat3 = null;
            String dat4 = null;
            String dat5 = null;
            String dat6 = null;
            String dat7 = null;
            String dat8 = null;
            String dat9 = null;
            String dat10 = null;
            
            
            String datt1 = null;
            String datt2 = null;
            String datt3 = null;
            String datt4 = null;
            String datt5 = null;
            String datt6 = null;
            String datt7 = null;
            String datt8 = null;
            String datt9 = null;
            String datt10 = null;
            
            //obss
            
            String obs1 = null;
            String obs2 = null;
            String obs3 = null;
            String obs4 = null;
            String obs5 = null;
            String obs6 = null;
            String obs7 = null;
            String obs8 = null;
            String obs9 = null;
            String obs10 = null;
            
            
           
           
           
             if (jCParcela.getSelectedIndex() == 1){
                 String entrada = jTentrada.getText();
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 String enderecoee = jTenderecoe.getText();
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 
                 //num2 = (int) MinhaTabela.getValueAt(1, 0);
                 dat1 =  (String) MinhaTabela.getValueAt(0, 2);
                 dat2 =  (String) MinhaTabela.getValueAt(1, 2);
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 String user = jTuser.getText();
                    
                    
                    
                    
                    
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

            
         /*
 linha1 = linhas[0]; 
 linha2 = linhas[1];
 linha3 = linhas[2];
 linha4 = linhas[3];
 linha5 = linhas[4];
 linha6 = linhas[5];
 linha7 = linhas[6];
 linha8 = linhas[7];
 linha9 = linhas[8];
 linha10 = linhas[9];
 linha11 = linhas[10];
 linha12 = linhas[11];
 linha13 = linhas[12];
 linha14 = linhas[13];
 linha15 = linhas[14];
 linha16 = linhas[15];
 linha17 = linhas[16];
 linha18 = linhas[17];
 linha19 = linhas[18];
 linha20 = linhas[19];*/
                    
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            

    //System.out.println(linha2);
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3);
    replacementText.put("%PARCE4%", parc4);
    replacementText.put("%PARCE5%", parc5);
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", parc3);
    replacementText.put("%04%", parc4);
    replacementText.put("%05%", parc5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", parc3);
    replacementText.put("%PDATA4%", parc4);
    replacementText.put("%PDATA5%", parc5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", parc3);
    replacementText.put("%POBS4%", parc4);
    replacementText.put("%POBS5%", parc5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    
    
    
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    JOptionPane.showMessageDialog(null, "passou  "+cpfc );
        }
                 
        
        
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 2){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 String enderecoee = jTenderecoe.getText();
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 String user = jTuser.getText();
                 
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                  
                  
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4);
    replacementText.put("%PARCE5%", parc5);
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", parc4);
    replacementText.put("%05%", parc5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", parc4);
    replacementText.put("%PDATA5%", parc5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", parc4);
    replacementText.put("%POBS5%", parc5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 3){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 String enderecoee = jTenderecoe.getText();
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 String user = jTuser.getText();
                 
 
                    

                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5);
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", parc5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", parc5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", parc5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 4){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 
                 
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 String user = jTuser.getText();
                
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                 
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 5){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 parc6 = (String) MinhaTabela.getValueAt(5, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 num6 = (Integer) MinhaTabela.getValueAt(5, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 String str6 = num6.toString();
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 dat6 = (String) MinhaTabela.getValueAt(5, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 obs6 = (String) MinhaTabela.getValueAt(5, 3);
                 String user = jTuser.getText();
                   
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6+",00");
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", "0"+str6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", dat6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", obs6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 6){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 parc6 = (String) MinhaTabela.getValueAt(5, 1);
                 parc7 = (String) MinhaTabela.getValueAt(6, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 num6 = (Integer) MinhaTabela.getValueAt(5, 0);
                 num7 = (Integer) MinhaTabela.getValueAt(6, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 String str6 = num6.toString();
                 String str7 = num7.toString();
                 
/*                 dat1 = (LocalDate) MinhaTabela.getValueAt(0, 2);
                 dat2 = (LocalDate) MinhaTabela.getValueAt(1, 2);*/
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 dat6 = (String) MinhaTabela.getValueAt(5, 2);
                 dat7 = (String) MinhaTabela.getValueAt(6, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 obs6 = (String) MinhaTabela.getValueAt(5, 3);
                 obs7 = (String) MinhaTabela.getValueAt(6, 3);
                 String user = jTuser.getText();

                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                    
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6+",00");
    replacementText.put("%PARCE7%", parc7+",00");
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", "0"+str6);
    replacementText.put("%07%", "0"+str7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", dat6);
    replacementText.put("%PDATA7%", dat7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", obs6);
    replacementText.put("%POBS7%", obs7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc10);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 7){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 parc6 = (String) MinhaTabela.getValueAt(5, 1);
                 parc7 = (String) MinhaTabela.getValueAt(6, 1);
                 parc8 = (String) MinhaTabela.getValueAt(7, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 num6 = (Integer) MinhaTabela.getValueAt(5, 0);
                 num7 = (Integer) MinhaTabela.getValueAt(6, 0);
                 num8 = (Integer) MinhaTabela.getValueAt(7, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 String str6 = num6.toString();
                 String str7 = num7.toString();
                 String str8 = num8.toString();
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 dat6 = (String) MinhaTabela.getValueAt(5, 2);
                 dat7 = (String) MinhaTabela.getValueAt(6, 2);
                 dat8 = (String) MinhaTabela.getValueAt(7, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 obs6 = (String) MinhaTabela.getValueAt(5, 3);
                 obs7 = (String) MinhaTabela.getValueAt(6, 3);
                 obs8 = (String) MinhaTabela.getValueAt(7, 3);
                 String user = jTuser.getText();

                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                 
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6+",00");
    replacementText.put("%PARCE7%", parc7+",00");
    replacementText.put("%PARCE8%", parc8+",00");
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc9);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", "0"+str6);
    replacementText.put("%07%", "0"+str7);
    replacementText.put("%08%", "0"+str8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc9);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", dat6);
    replacementText.put("%PDATA7%", dat7);
    replacementText.put("%PDATA8%", dat8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc9);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", obs6);
    replacementText.put("%POBS7%", obs7);
    replacementText.put("%POBS8%", obs8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc9);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 8){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 parc6 = (String) MinhaTabela.getValueAt(5, 1);
                 parc7 = (String) MinhaTabela.getValueAt(6, 1);
                 parc8 = (String) MinhaTabela.getValueAt(7, 1);
                 parc9 = (String) MinhaTabela.getValueAt(8, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 num6 = (Integer) MinhaTabela.getValueAt(5, 0);
                 num7 = (Integer) MinhaTabela.getValueAt(6, 0);
                 num8 = (Integer) MinhaTabela.getValueAt(7, 0);
                 num9 = (Integer) MinhaTabela.getValueAt(8, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 String str6 = num6.toString();
                 String str7 = num7.toString();
                 String str8 = num8.toString();
                 String str9 = num9.toString();
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 dat6 = (String) MinhaTabela.getValueAt(5, 2);
                 dat7 = (String) MinhaTabela.getValueAt(6, 2);
                 dat8 = (String) MinhaTabela.getValueAt(7, 2);
                 dat9 = (String) MinhaTabela.getValueAt(8, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 obs6 = (String) MinhaTabela.getValueAt(5, 3);
                 obs7 = (String) MinhaTabela.getValueAt(6, 3);
                 obs8 = (String) MinhaTabela.getValueAt(7, 3);
                 obs9 = (String) MinhaTabela.getValueAt(8, 3);
                 String user = jTuser.getText();
                    
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                 
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6+",00");
    replacementText.put("%PARCE7%", parc7+",00");
    replacementText.put("%PARCE8%", parc8+",00");
    replacementText.put("%PARCE9%", parc9+",00");
    replacementText.put("%PARCE10%", parc10);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", "0"+str6);
    replacementText.put("%07%", "0"+str7);
    replacementText.put("%08%", "0"+str8);
    replacementText.put("%09%", "0"+str9);
    replacementText.put("%10%", parc10);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", dat6);
    replacementText.put("%PDATA7%", dat7);
    replacementText.put("%PDATA8%", dat8);
    replacementText.put("%PDATA9%", dat9);
    replacementText.put("%PDATA10%", parc10);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", obs6);
    replacementText.put("%POBS7%", obs7);
    replacementText.put("%POBS8%", obs8);
    replacementText.put("%POBS9%", obs9);
    replacementText.put("%POBS10%", parc10);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 9){
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 parc3 = (String) MinhaTabela.getValueAt(2, 1);
                 parc4 = (String) MinhaTabela.getValueAt(3, 1);
                 parc5 = (String) MinhaTabela.getValueAt(4, 1);
                 parc6 = (String) MinhaTabela.getValueAt(5, 1);
                 parc7 = (String) MinhaTabela.getValueAt(6, 1);
                 parc8 = (String) MinhaTabela.getValueAt(7, 1);
                 parc9 = (String) MinhaTabela.getValueAt(8, 1);
                 parc10 = (String) MinhaTabela.getValueAt(9, 1);
                 String enderecoee = jTenderecoe.getText();
                 
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 num3 = (Integer) MinhaTabela.getValueAt(2, 0);
                 num4 = (Integer) MinhaTabela.getValueAt(3, 0);
                 num5 = (Integer) MinhaTabela.getValueAt(4, 0);
                 num6 = (Integer) MinhaTabela.getValueAt(5, 0);
                 num7 = (Integer) MinhaTabela.getValueAt(6, 0);
                 num8 = (Integer) MinhaTabela.getValueAt(7, 0);
                 num9 = (Integer) MinhaTabela.getValueAt(8, 0);
                 num10 = (Integer) MinhaTabela.getValueAt(9, 0);
                 
                 Integer v = 2;
                 String vz = v.toString();
                 String entrada = jTentrada.getText();
                 //data
                 String str1 = num1.toString();
                 String str2 = num2.toString();
                 String str3 = num3.toString();
                 String str4 = num4.toString();
                 String str5 = num5.toString();
                 String str6 = num6.toString();
                 String str7 = num7.toString();
                 String str8 = num8.toString();
                 String str9 = num9.toString();
                 String str10 = num10.toString();
                 
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 dat2 = (String) MinhaTabela.getValueAt(1, 2);
                 dat3 = (String) MinhaTabela.getValueAt(2, 2);
                 dat4 = (String) MinhaTabela.getValueAt(3, 2);
                 dat5 = (String) MinhaTabela.getValueAt(4, 2);
                 dat6 = (String) MinhaTabela.getValueAt(5, 2);
                 dat7 = (String) MinhaTabela.getValueAt(6, 2);
                 dat8 = (String) MinhaTabela.getValueAt(7, 2);
                 dat9 = (String) MinhaTabela.getValueAt(8, 2);
                 dat10 = (String) MinhaTabela.getValueAt(9, 2);
                 
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 obs3 = (String) MinhaTabela.getValueAt(2, 3);
                 obs4 = (String) MinhaTabela.getValueAt(3, 3);
                 obs5 = (String) MinhaTabela.getValueAt(4, 3);
                 obs6 = (String) MinhaTabela.getValueAt(5, 3);
                 obs7 = (String) MinhaTabela.getValueAt(6, 3);
                 obs8 = (String) MinhaTabela.getValueAt(7, 3);
                 obs9 = (String) MinhaTabela.getValueAt(8, 3);
                 obs10 = (String) MinhaTabela.getValueAt(9, 3);
                 String user = jTuser.getText();

                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                    
                    
                 
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2+",00");
    replacementText.put("%PARCE3%", parc3+",00");
    replacementText.put("%PARCE4%", parc4+",00");
    replacementText.put("%PARCE5%", parc5+",00");
    replacementText.put("%PARCE6%", parc6+",00");
    replacementText.put("%PARCE7%", parc7+",00");
    replacementText.put("%PARCE8%", parc8+",00");
    replacementText.put("%PARCE9%", parc9+",00");
    replacementText.put("%PARCE10%", parc10+",00");
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", "0"+str2);
    replacementText.put("%03%", "0"+str3);
    replacementText.put("%04%", "0"+str4);
    replacementText.put("%05%", "0"+str5);
    replacementText.put("%06%", "0"+str6);
    replacementText.put("%07%", "0"+str7);
    replacementText.put("%08%", "0"+str8);
    replacementText.put("%09%", "0"+str9);
    replacementText.put("%10%", "0"+str10);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", dat2);
    replacementText.put("%PDATA3%", dat3);
    replacementText.put("%PDATA4%", dat4);
    replacementText.put("%PDATA5%", dat5);
    replacementText.put("%PDATA6%", dat6);
    replacementText.put("%PDATA7%", dat7);
    replacementText.put("%PDATA8%", dat8);
    replacementText.put("%PDATA9%", dat9);
    replacementText.put("%PDATA10%", dat10);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", obs2);
    replacementText.put("%POBS3%", obs3);
    replacementText.put("%POBS4%", obs4);
    replacementText.put("%POBS5%", obs5);
    replacementText.put("%POBS6%", obs6);
    replacementText.put("%POBS7%", obs7);
    replacementText.put("%POBS8%", obs8);
    replacementText.put("%POBS9%", obs9);
    replacementText.put("%POBS10%", obs10);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 10){
                 String enderecoee = jTenderecoe.getText();
                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  //String moduloscc = null;
                  
                  
                  //String texto = jTmodulos.getText();
                 String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
                    String user = jTuser.getText();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }
                  
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
    String avista = "Pagamento à vista.";
    String avista2 = "À Vista";
    String moeda = null;
    if (jCForma.getSelectedIndex() == 0){
        moeda = "DINHEIRO";
    }else if (jCForma.getSelectedIndex() == 1){
        moeda = "CHEQUE";
    }else if (jCForma.getSelectedIndex() == 2){
        moeda = "CARTÃO";
    }
            
               
    
    replacementText.put("que a contratante pagará da seguinte forma:", avista);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("Parcelamento", avista2);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    //replacementText.put("%MOEDA%", moeda);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1);
    replacementText.put("%PARCE2%", parc2);
    replacementText.put("%PARCE3%", parc3);
    replacementText.put("%PARCE4%", parc4);
    replacementText.put("%PARCE5%", parc5);
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc10);
    replacementText.put("%01%", parc1);
    replacementText.put("%02%", parc2);
    replacementText.put("%03%", parc3);
    replacementText.put("%04%", parc4);
    replacementText.put("%05%", parc5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc10);
    replacementText.put("%PDATA1%", parc2);
    replacementText.put("%PDATA2%", parc2);
    replacementText.put("%PDATA3%", parc3);
    replacementText.put("%PDATA4%", parc4);
    replacementText.put("%PDATA5%", parc5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc10);
    replacementText.put("%POBS1%", parc1);
    replacementText.put("%POBS2%", parc2);
    replacementText.put("%POBS3%", parc3);
    replacementText.put("%POBS4%", parc4);
    replacementText.put("%POBS5%", parc5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc10);
    //replacementText.put("%ENTRADA%", entrada+",00");
    //replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
    replacementText.put("%VENDEDOR%", user);
    
    
    
    //•	Entrada no valor de R$%ENTRADA%%ESTENCO2%, o restante será divido em %NPARCELA%x vezes de R$ %VPARCELA% %ESTENCO3%
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
                  
              if (cpfc.equals("CPF")){
                  
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }else if (jCParcela.getSelectedIndex() == 0){
                 String entrada = jTentrada.getText();
                 parc1 = (String) MinhaTabela.getValueAt(0, 1);
                 //parc2 = (String) MinhaTabela.getValueAt(1, 1);
                 num1 = (Integer) MinhaTabela.getValueAt(0, 0);
                 String enderecoee = jTenderecoe.getText();
                 //num2 = (Integer) MinhaTabela.getValueAt(1, 0);
                 Integer v = 2;
                 String vz = v.toString();
                 String str1 = num1.toString();
                 //String str2 = num2.toString();
                 
                 //num2 = (int) MinhaTabela.getValueAt(1, 0);
                 dat1 = (String) MinhaTabela.getValueAt(0, 2);
                 //dat2 = (LocalDate) MinhaTabela.getValueAt(1, 2);
                 obs1 = (String) MinhaTabela.getValueAt(0, 3);
                 //obs2 = (String) MinhaTabela.getValueAt(1, 3);
                 String user = jTuser.getText();   
                    
                    //String linhass[]{"",};
                   //String linha1 = null;
                    
                    String texto = jTmodulos.getText();
                    int nn = jTmodulos.getLineCount();
String linhas[] = texto.split("\n");


String linha1 = ""; 
String linha2 = "";
String linha3 = "";
String linha4 = "";
String linha5 = "";
String linha6 = "";
String linha7 = "";
String linha8 = "";
String linha9 = "";
String linha10 = "";
String linha11 = "";
String linha12 = "";
String linha13 = "";
String linha14 = "";
String linha15 = "";
String linha16 = "";
String linha17 = "";
String linha18 = "";
String linha19 = "";
String linha20 = "";

            if (nn == 1){
               linha1 = linhas[0]; 
            }else if (nn == 2){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
            }else if (nn == 3){
               linha1 = linhas[0]; 
               linha2 = linhas[1];
               linha3 = linhas[2]; 
            }else if (nn == 4){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
            }else if (nn == 5){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4]; 
            }else if (nn == 6){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5]; 
            }else if (nn == 7){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6]; 
            }else if (nn == 8){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7]; 
            }else if (nn == 9){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8]; 
            }else if (nn == 10){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9]; 
            }else if (nn == 11){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10]; 
            }else if (nn == 12){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11]; 
            }else if (nn == 13){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
            }else if (nn == 14){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
            }else if (nn == 15){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
            }else if (nn == 16){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15]; 
            }else if (nn == 17){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16]; 
            }else if (nn == 18){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17]; 
            }else if (nn == 19){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18]; 
            }else if (nn == 20){
               linha1 = linhas[0];
               linha2 = linhas[1];
               linha3 = linhas[2];
               linha4 = linhas[3];
               linha5 = linhas[4];
               linha6 = linhas[5];
               linha7 = linhas[6];
               linha8 = linhas[7];
               linha9 = linhas[8];
               linha10 = linhas[9];
               linha11 = linhas[10];
               linha12 = linhas[11];
               linha13 = linhas[12]; 
               linha14 = linhas[13]; 
               linha15 = linhas[14]; 
               linha16 = linhas[15];
               linha17 = linhas[16];
               linha18 = linhas[17];
               linha19 = linhas[18];
               linha20 = linhas[19]; 
            }

                  try {
                  nomec = (conex.rs.getString("nome"));
                  cpfc = (conex.rs.getString("cpfn"));
                  dataco = "2018";
                  rgco = (conex.rs.getString("registron"));
                  
                  
                  //String moduloscc = null;
                 
    HashMap<String, String> replacementText = new HashMap<String, String>();
      
      
            

    //System.out.println(linha2);
               
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%NOME_DO_CLIENTE%", nomec);
    replacementText.put("%ENDERECO%", enderecocc);
    replacementText.put("%CPF%", cpfcc);
    replacementText.put("%REGISTRO%", registrocc);
    replacementText.put("%NUMERO%", numerocc);
    replacementText.put("%CIDADE%", cidadecc);
    replacementText.put("%UF%", ufcc);
    replacementText.put("%EMAIL%", emailc);
    replacementText.put("%FONE1%", fone1cc);
    replacementText.put("%CONTRATO%", ncontratocc);
    replacementText.put("%MODULOS1%", linha1);
    replacementText.put("%MODULOS2%", linha2);
    replacementText.put("%MODULOS3%", linha3);
    replacementText.put("%MODULOS4%", linha4);
    replacementText.put("%MODULOS5%", linha5);
    replacementText.put("%MODULOS6%", linha6);
    replacementText.put("%MODULOS7%", linha7);
    replacementText.put("%MODULOS8%", linha8);
    replacementText.put("%MODULOS9%", linha9);
    replacementText.put("%MODULOS10%", linha10);
    replacementText.put("%MODULOS11%", linha11);
    replacementText.put("%MODULOS12%", linha12);
    replacementText.put("%MODULOS13%", linha13);
    replacementText.put("%MODULOS14%", linha14);
    replacementText.put("%MODULOS15%", linha15);
    replacementText.put("%MODULOS16%", linha16);
    replacementText.put("%MODULOS17%", linha17);
    replacementText.put("%MODULOS18%", linha18);
    replacementText.put("%MODULOS19%", linha19);
    replacementText.put("%MODULOS20%", linha20);
    
    replacementText.put("%BAIRRO%", bairrocc);
    replacementText.put("%CEP%", cepc);
    replacementText.put("%DATA%", data1);
    replacementText.put("%HORA%", hora1);
    replacementText.put("%MONTAGEM%", montagemcc);
    replacementText.put("%PESSOA%", cpfc);
    replacementText.put("%TREGISTRO%", rgco);
    replacementText.put("%DATAE%", formato.format(datae));
    replacementText.put("%DATAC%", dataco);
    replacementText.put("%TOTAL%", totalc+",00");
    replacementText.put("%PARCE1%", parc1+",00");
    replacementText.put("%PARCE2%", parc2);
    replacementText.put("%PARCE3%", parc3);
    replacementText.put("%PARCE4%", parc4);
    replacementText.put("%PARCE5%", parc5);
    replacementText.put("%PARCE6%", parc6);
    replacementText.put("%PARCE7%", parc7);
    replacementText.put("%PARCE8%", parc8);
    replacementText.put("%PARCE9%", parc9);
    replacementText.put("%PARCE10%", parc10);
    replacementText.put("%01%", "0"+str1);
    replacementText.put("%02%", parc2);
    replacementText.put("%03%", parc3);
    replacementText.put("%04%", parc4);
    replacementText.put("%05%", parc5);
    replacementText.put("%06%", parc6);
    replacementText.put("%07%", parc7);
    replacementText.put("%08%", parc8);
    replacementText.put("%09%", parc9);
    replacementText.put("%10%", parc10);
    replacementText.put("%PDATA1%", dat1);
    replacementText.put("%PDATA2%", parc2);
    replacementText.put("%PDATA3%", parc3);
    replacementText.put("%PDATA4%", parc4);
    replacementText.put("%PDATA5%", parc5);
    replacementText.put("%PDATA6%", parc6);
    replacementText.put("%PDATA7%", parc7);
    replacementText.put("%PDATA8%", parc8);
    replacementText.put("%PDATA9%", parc9);
    replacementText.put("%PDATA10%", parc10);
    replacementText.put("%POBS1%", obs1);
    replacementText.put("%POBS2%", parc2);
    replacementText.put("%POBS3%", parc3);
    replacementText.put("%POBS4%", parc4);
    replacementText.put("%POBS5%", parc5);
    replacementText.put("%POBS6%", parc6);
    replacementText.put("%POBS7%", parc7);
    replacementText.put("%POBS8%", parc8);
    replacementText.put("%POBS9%", parc9);
    replacementText.put("%POBS10%", parc10);
    replacementText.put("%ENTRADA%", entrada+",00");
    replacementText.put("%NPARCELA%", vz);
    replacementText.put("%LOGADO%", user1);
    replacementText.put("%DESCRICAO1%", ab1);
    replacementText.put("%QD1%", qt1);
    replacementText.put("%VTOT1%", vt1);
    replacementText.put("%VU1%", vt1);
    replacementText.put("%DESCRICAO2%", ab2);
    replacementText.put("%QD2%", qt2);
    replacementText.put("%VTOT2%", vt2);
    replacementText.put("%VU2%", vt2);
    replacementText.put("%DESCRICAO3%", ab3);
    replacementText.put("%QD3%", qt3);
    replacementText.put("%VTOT3%", vt3);
    replacementText.put("%VU3%", vt3);
    replacementText.put("%DESCRICAO4%", ab4);
    replacementText.put("%QD4%", qt4);
    replacementText.put("%VTOT4%", vt4);
    replacementText.put("%VU4%", vt4);
    replacementText.put("%DESCRICAO5%", ab5);
    replacementText.put("%QD5%", qt5);
    replacementText.put("%VTOT5%", vt5);
    replacementText.put("%VU5%", vt5);
    replacementText.put("%DESCRICAO6%", ab6);
    replacementText.put("%QD6%", qt6);
    replacementText.put("%VTOT6%", vt6);
    replacementText.put("%VU6%", vt6);
    replacementText.put("%DESCRICAO7%", ab7);
    replacementText.put("%QD7%", qt7);
    replacementText.put("%VTOT7%", vt7);
    replacementText.put("%VU7%", vt7);
    replacementText.put("%DESCRICAO8%", ab8);
    replacementText.put("%QD8%", qt8);
    replacementText.put("%VTOT8%", vt8);
    replacementText.put("%VU8%", vt8);
    replacementText.put("%ENDERECOEE%", enderecoee);
//    replacementText.put("%VENDEDOR%", user);
    
    //(formato.format(datae));
    
    
    
    
    new InsertText("M:\\data\\file\\model\\MODELO.doc", replacementText).processFile();
    //System.out.println("Ok");
      }
    catch(Exception eEx) {
    //System.out.println("Caught an: " + eEx.getClass().getName());
    //System.out.println("Message: " + eEx.getMessage());
    //System.out.println("StackTrace follows:");
    //eEx.printStackTrace(System.out);
    
        }
              if (cpfc.equals("CPF")){
                  JOptionPane.showMessageDialog(null, "CONTRATO DO(A) CLIENTE "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
                  
              }else {
                  JOptionPane.showMessageDialog(null, "CONTRATO DA EMPRESA "+nomec+" CRIADO COM SUCESSO.");
                  imprimir("M:\\data\\file\\files\\CONTRATO "+ncont+".doc");
                  jBEvolta.setEnabled(false);
                  jTfcontrato.setEnabled(false);
                  dispose();
                  grava();
              }
                 
                 
             }
        
         
      
        }
        
        
    }//GEN-LAST:event_jTfcontratoActionPerformed
    }
    public void chama(){
            Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
            
        if (e.getColumn() == 1) {
            double soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Double.parseDouble(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
            //(String.valueOf(T));
        }
    }
});
        }
    public void parcela(){
        
        

        if (jCParcela.getSelectedIndex()== 1){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
         
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
            //(String.valueOf(T));
        }
    }
});
                //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        //LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        //String limpo = " ";
        //LocalDate vazio = LocalDate.parse(limpo);
        //LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        //LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        //LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        //LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    //SimpleDateFormat forma2 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela2 = forma1.format(dateP2);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 2;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                //adicionarRow(3, rss, daquiTesMes, " ");
                
                
        
        //TRES PARCELAS
    }else if (jCParcela.getSelectedIndex()== 2){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        //String limpo = " ";
        //LocalDate vazio = LocalDate.parse(limpo);
        //LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        //LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        //LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        //LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 3;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                
        
    }else if (jCParcela.getSelectedIndex()== 3){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        //LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        //LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        //LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 4;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                
                
    }else if (jCParcela.getSelectedIndex()== 4){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        //LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        //LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
         int valor1;
       int desc;
       //Integer parcela;
      int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 5;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
        
    }else if (jCParcela.getSelectedIndex()== 5){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        //LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
                    
                    LocalDate dataParc6 = daquiSeisMes; // Data atual
                    java.sql.Date dateP6 = java.sql.Date.valueOf(dataParc6);
                    String dataParcela6 = forma1.format(dateP6);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 6;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
                adicionarRow(6, rss, dataParcela6, " ");
                
    }else if (jCParcela.getSelectedIndex()== 6){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        //LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
                    
                    LocalDate dataParc6 = daquiSeisMes; // Data atual
                    java.sql.Date dateP6 = java.sql.Date.valueOf(dataParc6);
                    String dataParcela6 = forma1.format(dateP6);
                    
                    LocalDate dataParc7 = daquiSeteMes; // Data atual
                    java.sql.Date dateP7 = java.sql.Date.valueOf(dataParc7);
                    String dataParcela7 = forma1.format(dateP7);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 7;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
                adicionarRow(6, rss, dataParcela6, " ");
                adicionarRow(7, rss, dataParcela7, " ");
                
    }else if (jCParcela.getSelectedIndex()== 7){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        //LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
                    
                    LocalDate dataParc6 = daquiSeisMes; // Data atual
                    java.sql.Date dateP6 = java.sql.Date.valueOf(dataParc6);
                    String dataParcela6 = forma1.format(dateP6);
                    
                    LocalDate dataParc7 = daquiSeteMes; // Data atual
                    java.sql.Date dateP7 = java.sql.Date.valueOf(dataParc7);
                    String dataParcela7 = forma1.format(dateP7);
                    
                    LocalDate dataParc8 = daquioitoMes; // Data atual
                    java.sql.Date dateP8 = java.sql.Date.valueOf(dataParc8);
                    String dataParcela8 = forma1.format(dateP8);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 8;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
                adicionarRow(6, rss, dataParcela6, " ");
                adicionarRow(7, rss, dataParcela7, " ");
                adicionarRow(8, rss, dataParcela8, " ");
                
    }else if (jCParcela.getSelectedIndex()== 8){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
                    
                    LocalDate dataParc6 = daquiSeisMes; // Data atual
                    java.sql.Date dateP6 = java.sql.Date.valueOf(dataParc6);
                    String dataParcela6 = forma1.format(dateP6);
                    
                    LocalDate dataParc7 = daquiSeteMes; // Data atual
                    java.sql.Date dateP7 = java.sql.Date.valueOf(dataParc7);
                    String dataParcela7 = forma1.format(dateP7);
                    
                    LocalDate dataParc8 = daquioitoMes; // Data atual
                    java.sql.Date dateP8 = java.sql.Date.valueOf(dataParc8);
                    String dataParcela8 = forma1.format(dateP8);
                    
                    LocalDate dataParc9 = daquiNoveMes; // Data atual
                    java.sql.Date dateP9 = java.sql.Date.valueOf(dataParc9);
                    String dataParcela9 = forma1.format(dateP9);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 9;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
                adicionarRow(6, rss, dataParcela6, " ");
                adicionarRow(7, rss, dataParcela7, " ");
                adicionarRow(8, rss, dataParcela8, " ");
                adicionarRow(9, rss, dataParcela9, " ");
                
    }else if (jCParcela.getSelectedIndex()== 9){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
        //sdf.format(daquiUmMes);
        LocalDate daquiDoisMes = hoje.plus(2, ChronoUnit.MONTHS);
        LocalDate daquiTesMes = hoje.plus(3, ChronoUnit.MONTHS);
        LocalDate daquiQuaMes = hoje.plus(4, ChronoUnit.MONTHS);
        LocalDate daquicinMes = hoje.plus(5, ChronoUnit.MONTHS);
        LocalDate daquiSeisMes = hoje.plus(6, ChronoUnit.MONTHS);
        LocalDate daquiSeteMes = hoje.plus(7, ChronoUnit.MONTHS);
        LocalDate daquioitoMes = hoje.plus(8, ChronoUnit.MONTHS);
        LocalDate daquiNoveMes = hoje.plus(9, ChronoUnit.MONTHS);
        LocalDate daquiDezMes = hoje.plus(10, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
                    LocalDate dataParc2 = daquiDoisMes; // Data atual
                    java.sql.Date dateP2 = java.sql.Date.valueOf(dataParc2);
                    String dataParcela2 = forma1.format(dateP2);
                    
                    LocalDate dataParc3 = daquiTesMes; // Data atual
                    java.sql.Date dateP3 = java.sql.Date.valueOf(dataParc3);
                    String dataParcela3 = forma1.format(dateP3);
                    
                    LocalDate dataParc4 = daquiQuaMes; // Data atual
                    java.sql.Date dateP4 = java.sql.Date.valueOf(dataParc4);
                    String dataParcela4 = forma1.format(dateP4);
                    
                    LocalDate dataParc5 = daquicinMes; // Data atual
                    java.sql.Date dateP5 = java.sql.Date.valueOf(dataParc5);
                    String dataParcela5 = forma1.format(dateP5);
                    
                    LocalDate dataParc6 = daquiSeisMes; // Data atual
                    java.sql.Date dateP6 = java.sql.Date.valueOf(dataParc6);
                    String dataParcela6 = forma1.format(dateP6);
                    
                    LocalDate dataParc7 = daquiSeteMes; // Data atual
                    java.sql.Date dateP7 = java.sql.Date.valueOf(dataParc7);
                    String dataParcela7 = forma1.format(dateP7);
                    
                    LocalDate dataParc8 = daquioitoMes; // Data atual
                    java.sql.Date dateP8 = java.sql.Date.valueOf(dataParc8);
                    String dataParcela8 = forma1.format(dateP8);
                    
                    LocalDate dataParc9 = daquiNoveMes; // Data atual
                    java.sql.Date dateP9 = java.sql.Date.valueOf(dataParc9);
                    String dataParcela9 = forma1.format(dateP9);
                    
                    LocalDate dataParc10 = daquiDezMes; // Data atual
                    java.sql.Date dateP10 = java.sql.Date.valueOf(dataParc10);
                    String dataParcela10 = forma1.format(dateP10);
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 10;
       Integer parcela = (int) resultado;
       String rss = parcela.toString();
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       
        
        MinhaTabela.setModel(Jtabela);
                adicionarRow(1, rss, dataParcela1," ");
                adicionarRow(2, rss, dataParcela2, " ");
                adicionarRow(3, rss, dataParcela3, " ");
                adicionarRow(4, rss, dataParcela4, " ");
                adicionarRow(5, rss, dataParcela5, " ");
                adicionarRow(6, rss, dataParcela6, " ");
                adicionarRow(7, rss, dataParcela7, " ");
                adicionarRow(8, rss, dataParcela8, " ");
                adicionarRow(9, rss, dataParcela9, " ");
                adicionarRow(10, rss, dataParcela10, " ");
                
    }else if (jCParcela.getSelectedIndex()== 0){
         Jtabela = new DefaultTableModel(new String[]{"Parcela", "Valor", "Data", "Observação"}, 0);
         
        Jtabela.addTableModelListener(new TableModelListener() {
    public void tableChanged(TableModelEvent e) {
        
        //parcelamento inicio    
        
        if (e.getColumn() == 1) {
            int soma = 0;
            for (int i = 0; i < Jtabela.getRowCount(); i++) {
                // obtém o valor na linha i coluna 2 onde está o valor, o tableModel usa Objects, é mais fácil converter para String inicialmente
                String valor = Jtabela.getValueAt(i, 1).toString();
                // Double.parseDouble converte para double
                soma = soma + Integer.parseInt(valor); 
            }
            jTtotal2.setText(String.valueOf(soma));
        }
    }
});
        //double entrada = 1000;
        //double parcela = 1500;
        String hojeRaw = jFdataEn.getText();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatador2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        LocalDate hoje = LocalDate.parse(hojeRaw, formatador);
        LocalDate daquiUmMes = hoje.plus(1, ChronoUnit.MONTHS);
                    LocalDate dataParc1 = daquiUmMes; // Data atual
                    java.sql.Date dateP1 = java.sql.Date.valueOf(dataParc1);
                    SimpleDateFormat forma1 = new SimpleDateFormat("dd/MM/yyyy");
                    String dataParcela1 = forma1.format(dateP1);
                    
        
         int valor1;
       int desc;
       //Integer parcela;
       int resultado;
       int prod;
       String rs = "R$: ";
       DecimalFormat df = new DecimalFormat("");
       valor1 = Integer.parseInt(jTtotal.getText());
       desc = Integer.parseInt(jTentrada.getText());
       
       prod = valor1 - desc;
       resultado = prod / 1;
       int parcela =  (resultado);
       String rss = String.valueOf(parcela);
       //String rss = totd.toString();
       String sub=df.format( resultado);
       String tot=df.format(valor1);
       String totd=df.format(desc);
       jTentrada.setText(totd);
       jTtotal.setText(tot);
       //String parcela = jTtotal.getText();
       String entrada = jTentrada.getText();
       MinhaTabela.setModel(Jtabela);
               adicionarRow(1, rss, dataParcela1," ");
                
                
        
        //TRES PARCELAS
    } 
    }
     
    public void adicionarRow(int Parcela, String Valor, String Data, String Observação) {
    Object[] row = new Object[4];
    row[0] = Parcela;
    row[1] = Valor;
    row[2] = Data;
    row[3] = Observação;
    Jtabela.addRow(row);
    
}
    
    public void limpar() {
  while (Jtabela.getRowCount() > 0) { // enquanto tiver linhas
    Jtabela.removeRow(0); // remove o primeiro
  }
         }

    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         
        if(jCCondicao.getSelectedIndex()== 0){
        
        jTEenderecoee.setText(jTenderecoe.getText());
        jTabbedPane1.setSelectedIndex(4);
        jTabbedPane1.setEnabledAt(3, false);
        jTabbedPane1.setEnabledAt(4, true);
        
        String nome;
            try {
                nome = (conex.rs.getString("nome"));
                jTEnome.setText(nome);
            } catch (SQLException ex) {

            }
            String ende = jTENDERECO.getText();
            jTEendereco.setText(ende);
            String nume = jTNUMERO.getText();
            jTEnumero.setText(nume);
            String cid = jTCIDADE.getText();
            jTEcidade.setText(cid);
            String bair = jTBAIRRO.getText();
            jTEbairro.setText(bair);
            String cep = jFCEP.getText();
            jFEcep.setText(cep);
            String uf = jTUF.getText();
            jCEuf.setSelectedItem(uf);
            String com = jTCOMP.getText();
            jTEcomp.setText(com);
            String ema = jTEMAIL.getText();
            jTEemail.setText(ema);
            String fon1 = jFFONE1.getText();
            jFEfone1.setText(fon1);
            String fon2 = jFFONE2.getText();
            jFEfone2.setText(fon2);

            jTEnome.setEnabled(false);
            jTEendereco.setEnabled(false);
            jTEnumero.setEnabled(false);
            jTEcidade.setEnabled(false);
            jTEbairro.setEnabled(false);
            jFEcep.setEnabled(false);
            jCEuf.setEnabled(false);
            jTEcomp.setEnabled(false);
            jTEemail.setEnabled(false);
            jFEfone1.setEnabled(false);
            jFEfone2.setEnabled(false);
            jTfcontrato.setEnabled(true);
    }else{
            int total = Integer.parseInt(jTAtotal.getText());
        int total2 = Integer.parseInt(jTtotal2.getText());
        
        if ((total)==(total2)){
        jTEenderecoee.setText(jTenderecoe.getText());
        jTabbedPane1.setSelectedIndex(4);
        jTabbedPane1.setEnabledAt(3, false);
        jTabbedPane1.setEnabledAt(4, true);
        
        String nome;
            try {
                nome = (conex.rs.getString("nome"));
                jTEnome.setText(nome);
            } catch (SQLException ex) {

            }
            String ende = jTENDERECO.getText();
            jTEendereco.setText(ende);
            String nume = jTNUMERO.getText();
            jTEnumero.setText(nume);
            String cid = jTCIDADE.getText();
            jTEcidade.setText(cid);
            String bair = jTBAIRRO.getText();
            jTEbairro.setText(bair);
            String cep = jFCEP.getText();
            jFEcep.setText(cep);
            String uf = jTUF.getText();
            jCEuf.setSelectedItem(uf);
            String com = jTCOMP.getText();
            jTEcomp.setText(com);
            String ema = jTEMAIL.getText();
            jTEemail.setText(ema);
            String fon1 = jFFONE1.getText();
            jFEfone1.setText(fon1);
            String fon2 = jFFONE2.getText();
            jFEfone2.setText(fon1);

            jTEnome.setEnabled(false);
            jTEendereco.setEnabled(false);
            jTEnumero.setEnabled(false);
            jTEcidade.setEnabled(false);
            jTEbairro.setEnabled(false);
            jFEcep.setEnabled(false);
            jCEuf.setEnabled(false);
            jTEcomp.setEnabled(false);
            jTEemail.setEnabled(false);
            jFEfone1.setEnabled(false);
            jFEfone2.setEnabled(false);
            jTfcontrato.setEnabled(true);
            
    }else{
            JOptionPane.showMessageDialog(null, "DESCULPE MAS OS VALORES ESTÃO DIVERGENTES!!");
        }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTmontagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTmontagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTmontagemActionPerformed

    private void boxNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNombreActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(true);
        //JOptionPane.showMessageDialog(null, "teste drive");
        
        String nome_cliente =""+boxNombre.getSelectedItem();
        conex.conexao();
        conex.executarSql("SELECT *FROM client WHERE Nome ='"+nome_cliente+"'");
        //conex.executarSql("SELECT DISTINCT CLIENTES from clientes ='"+nome_cliente+"'");
        try{
         conex.rs.first();
         jTCPF.setText(conex.rs.getString("cpf"));
        jTEMAIL.setText(conex.rs.getString("email"));
        jTREGISTRO.setText(conex.rs.getString("rg"));
        jTNUMERO.setText(conex.rs.getString("numero"));
        jTCIDADE.setText(conex.rs.getString("municipio"));
        jTBAIRRO.setText(conex.rs.getString("bairro"));
        jFCEP.setText(conex.rs.getString("cep"));
        jTCOMP.setText(conex.rs.getString("complemento"));
        jFFONE1.setText(conex.rs.getString("fone1"));
        jFFONE2.setText(conex.rs.getString("fone2"));
        jTPESSOA.setText(conex.rs.getString("pessoa"));
        jTENDERECO.setText(conex.rs.getString("endereco"));
        jTUF.setText(conex.rs.getString("uf"));
        }catch (SQLException ex){
        //JOptionPane.showMessageDialog(null, "Erro ao scarregar dados do cliente!"+ex);
            
       // jButton1.requestFocus();
        
    }
        
        conex.desconecta();
        
          
        
    }//GEN-LAST:event_boxNombreActionPerformed

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        if(!jTextField1.getText().isEmpty()){
            jButton1.setEnabled(true);
        }else{
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1FocusLost

    private void jTCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTCPFFocusLost
        // TODO add your handling code here:
        

        
    }//GEN-LAST:event_jTCPFFocusLost

    private void jTEnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnumeroKeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
        
    }//GEN-LAST:event_jTEnumeroKeyTyped

    private void jTtotal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTtotal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTtotal2ActionPerformed

    private void jTBCalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBCalcActionPerformed
        // TODO add your handling code here:
        //public void tableChange();
        parcela();
        
        //chama();
        
        
    }//GEN-LAST:event_jTBCalcActionPerformed

    private void jTAtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAtotalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jCParcela.setSelectedIndex(10);
         jTabbedPane1.setSelectedIndex(3);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, true);
        jTtotal.setText(jTAtotal.getText());
        jFdataEn.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        //jTentrada.setVisible(false);
        //jFdataEn.setValue(false);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        jTabbedPane1.setEnabledAt(1, true);
        jTabbedPane1.setEnabledAt(2, false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTAvalor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor1ActionPerformed

    private void jTAvalor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor1KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor1KeyTyped

    private void jTAvalor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor2ActionPerformed

    private void jTAvalor2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor2KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor2KeyTyped

    private void jTAvalor3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor3ActionPerformed

    private void jTAvalor3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor3KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor3KeyTyped

    private void jTAvalor4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor4ActionPerformed

    private void jTAvalor4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor4KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor4KeyTyped

    private void jTAvalor8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor8ActionPerformed

    private void jTAvalor8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor8KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor8KeyTyped

    private void jTAvalor7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor7ActionPerformed

    private void jTAvalor7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor7KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor7KeyTyped

    private void jTAvalor6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor6ActionPerformed

    private void jTAvalor6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor6KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor6KeyTyped

    private void jTAvalor5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAvalor5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAvalor5ActionPerformed

    private void jTAvalor5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvalor5KeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTAvalor5KeyTyped

    private void jTAtotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAtotalKeyTyped
        // TODO add your handling code here:
         String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
        
    }//GEN-LAST:event_jTAtotalKeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        jBeditc.setEnabled(true);
        jButton8.setEnabled(false);
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = 0;
        int t5 = 0;
        int t6 = 0;
        int t7 = 0;
        int t8 = 0;
        //jTAmbiente1.setEnabled(false);
        //jTAmbiente2.setEnabled(false);
        //jTAmbiente3.setEnabled(false);
        //jTAmbiente4.setEnabled(false);
        //jTAmbiente5.setEnabled(false);
        //jTAmbiente6.setEnabled(false);
        //jTAmbiente7.setEnabled(false);
        //jTAmbiente8.setEnabled(false);
        //jTAvalor1.setEnabled(false);
        //jTAvalor2.setEnabled(false);
        //jTAvalor3.setEnabled(false);
        //jTAvalor4.setEnabled(false);
        //jTAvalor5.setEnabled(false);
        //jTAvalor6.setEnabled(false);
        //jTAvalor7.setEnabled(false);
        //jTAvalor8.setEnabled(false);
        //t1 =  Integer.parseInt(jTAvalor1.getText());
        //t2 =  Integer.parseInt(jTAvalor2.getText());
        //t3 =  Integer.parseInt(jTAvalor3.getText());
        //t4 =  Integer.parseInt(jTAvalor4.getText());
        //t5 =  Integer.parseInt(jTAvalor5.getText());
        //t6 =  Integer.parseInt(jTAvalor6.getText());
        //t7 =  Integer.parseInt(jTAvalor7.getText());
        //t8 =  Integer.parseInt(jTAvalor8.getText());
        if (jTAmbiente2.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            //JOptionPane.showMessageDialog(null, "SOMOU");
            int T = t1;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor1.setEnabled(false);
        }else if (jTAmbiente3.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            int T = t1+t2;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
        }else if (jTAmbiente4.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            int T = t1+t2+t3;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
        }else if (jTAmbiente5.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            t4 =  Integer.parseInt(jTAvalor4.getText());
            int T = t1+t2+t3+t4;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor4.setText(t4+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
            jTAvalor4.setEnabled(false);
        }else if (jTAmbiente6.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            t4 =  Integer.parseInt(jTAvalor4.getText());
            t5 =  Integer.parseInt(jTAvalor5.getText());
            int T = t1+t2+t3+t4+t5;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor4.setText(t4+",00");
            jTAvalor5.setText(t5+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
            jTAvalor4.setEnabled(false);
            jTAvalor5.setEnabled(false);
        }else if (jTAmbiente7.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            t4 =  Integer.parseInt(jTAvalor4.getText());
            t5 =  Integer.parseInt(jTAvalor5.getText());
            t6 =  Integer.parseInt(jTAvalor6.getText());
            int T = t1+t2+t3+t4+t5+t6;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor4.setText(t4+",00");
            jTAvalor5.setText(t5+",00");
            jTAvalor6.setText(t6+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
            jTAvalor4.setEnabled(false);
            jTAvalor5.setEnabled(false);
            jTAvalor6.setEnabled(false);
        }else if (jTAmbiente8.getText().equals("")){
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            t4 =  Integer.parseInt(jTAvalor4.getText());
            t5 =  Integer.parseInt(jTAvalor5.getText());
            t6 =  Integer.parseInt(jTAvalor6.getText());
            t7 =  Integer.parseInt(jTAvalor7.getText());
            int T = t1+t2+t3+t4+t5+t6+t7;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor4.setText(t4+",00");
            jTAvalor5.setText(t5+",00");
            jTAvalor6.setText(t6+",00");
            jTAvalor7.setText(t7+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
            jTAvalor4.setEnabled(false);
            jTAvalor5.setEnabled(false);
            jTAvalor6.setEnabled(false);
            jTAvalor7.setEnabled(false);
        }else {
            t1 =  Integer.parseInt(jTAvalor1.getText());
            t2 =  Integer.parseInt(jTAvalor2.getText());
            t3 =  Integer.parseInt(jTAvalor3.getText());
            t4 =  Integer.parseInt(jTAvalor4.getText());
            t5 =  Integer.parseInt(jTAvalor5.getText());
            t6 =  Integer.parseInt(jTAvalor6.getText());
            t7 =  Integer.parseInt(jTAvalor7.getText());
            t8 =  Integer.parseInt(jTAvalor8.getText());
            int T = t1+t2+t3+t4+t5+t6+t7+t8;
            jTAtotal.setText(String.valueOf(T));
            jButton4.setEnabled(true);
            jTAvalor1.setText(t1+",00");
            jTAvalor2.setText(t2+",00");
            jTAvalor3.setText(t3+",00");
            jTAvalor4.setText(t4+",00");
            jTAvalor5.setText(t5+",00");
            jTAvalor6.setText(t6+",00");
            jTAvalor7.setText(t7+",00");
            jTAvalor8.setText(t8+",00");
            jTAvalor1.setEnabled(false);
            jTAvalor2.setEnabled(false);
            jTAvalor3.setEnabled(false);
            jTAvalor4.setEnabled(false);
            jTAvalor5.setEnabled(false);
            jTAvalor6.setEnabled(false);
            jTAvalor7.setEnabled(false);
            jTAvalor8.setEnabled(false);
        }
        
        
        //int T = t1+t2+t3+t4+t5+t6+t7+t8;
        //String rs = "R$: ";
      // DecimalFormat df = new DecimalFormat("#,###.00");
       //String rss = T.toString();
       //String rss = totd.toString();
       //String sub=df.format( T);
        //jTAtotal.setText(String.valueOf(T));
        //jButton4.setEnabled(true);
        //JOptionPane.showMessageDialog(null, T);
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jTAmbiente1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente1FocusLost
        // TODO add your handling code here:
        if (jTAmbiente1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "VOCÊ PRECISA DIGITAR O NOME DO AMBIENTE!");
            jTAmbiente1.requestFocus();

        }
    }//GEN-LAST:event_jTAmbiente1FocusLost

    private void jTAvalor1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor1FocusLost
        // TODO add your handling code here:
        if (!jTAvalor1.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }else{
            jButton8.setEnabled(false);
            
            
        }
        if (jTAvalor1.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            jTAvalor1.requestFocus();
        }
        //int q1 =  Integer.parseInt(jTqtd1.getText());
        //int v1 =  Integer.parseInt(jTAvalor1.getText());
        //int tot = q1*v1;
        //jTAvalor1.setText(String.valueOf(tot));
    }//GEN-LAST:event_jTAvalor1FocusLost

    private void jTqtd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd8ActionPerformed

    private void jTqtd8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd8KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd8KeyTyped

    private void jTqtd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd7ActionPerformed

    private void jTqtd7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd7KeyTyped

    private void jTqtd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd6ActionPerformed

    private void jTqtd6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd6KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd6KeyTyped

    private void jTqtd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd5ActionPerformed

    private void jTqtd5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd5KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd5KeyTyped

    private void jTqtd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd4ActionPerformed

    private void jTqtd4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd4KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd4KeyTyped

    private void jTqtd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd3ActionPerformed

    private void jTqtd3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd3KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd3KeyTyped

    private void jTqtd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd2ActionPerformed

    private void jTqtd2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd2KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd2KeyTyped

    private void jTqtd1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTqtd1FocusLost
        // TODO add your handling code here:
        if (jTqtd1.getText().equals("") || jTqtd1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTqtd1.requestFocus();
        }
        int q1 =  Integer.parseInt(jTqtd1.getText());
        int v1 =  Integer.parseInt(jTAvalor1.getText());
        int tot = q1*v1;
        jTAvalor1.setText(String.valueOf(tot));
        
    }//GEN-LAST:event_jTqtd1FocusLost

    private void jTqtd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTqtd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTqtd1ActionPerformed

    private void jTqtd1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTqtd1KeyTyped
        // TODO add your handling code here:
        String caracteres="0987654321";
                if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
                } 
    }//GEN-LAST:event_jTqtd1KeyTyped

    private void jCCondicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCondicaoActionPerformed
        // TODO add your handling code here:
        
        int tipoPg = jCCondicao.getSelectedIndex();
        
        switch(tipoPg){
            case 0:
                //JOptionPane.showMessageDialog(null, "caramba");
            //limpar();
        jCParcela.setEnabled(false);
        //jTentrada.setEnabled(false);
        jTBCalc.setEnabled(false);
        jTtotal2.setEnabled(false);
        //jFdataEn.setEnabled(false);
        //limpar
        jCParcela.setSelectedItem(0);
        jTentrada.setText("0");
        jTBCalc.setEnabled(false);
       jTtotal2.setText("");
       jButton3.setEnabled(true);
        //jFdataEn.setText("");
        //String po = "...";
        //jCParcela.getSelectedItem(po);
       // String var = jTAtotal.getText();
       // jTtotal.getText("");
            break;
            case 1:
                //JOptionPane.showMessageDialog(null, "afff");
            jCParcela.setEnabled(true);
        //jTentrada.setEnabled(true);
        jTBCalc.setEnabled(true);
        jTtotal2.setEnabled(true); 
        //jFdataEn.setEnabled(true);
            break;
        }
        
        
        
    }//GEN-LAST:event_jCCondicaoActionPerformed

    private void jBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimparActionPerformed
        // TODO add your handling code here:
        //limpar();
        //jCParcela.setSelectedIndex(9);
        //jButton3.setEnabled(false);
        jCParcela.setSelectedIndex(10);
        jCCondicao.setSelectedItem("Á Vista");
        
        jTabbedPane1.setSelectedIndex(2);
        jTabbedPane1.setEnabledAt(2, true);
        jTabbedPane1.setEnabledAt(3, false);
        limpar();
    }//GEN-LAST:event_jBLimparActionPerformed

    private void jTAvalor1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor1FocusGained
        // TODO add your handling code here:
        
        jButton8.setEnabled(true);
        jTAvalor1.setText("");
    }//GEN-LAST:event_jTAvalor1FocusGained

    private void jTAvalor2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor2FocusGained
        // TODO add your handling code here:
        jTAvalor2.setText("");
    }//GEN-LAST:event_jTAvalor2FocusGained

    private void jTAvalor2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor2FocusLost
        // TODO add your handling code here:
        if (!jTAvalor2.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor2.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor2.setEditable(false);
            jTAmbiente2.requestFocus();
        }
        
    }//GEN-LAST:event_jTAvalor2FocusLost

    private void jTqtd2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTqtd2FocusLost
        // TODO add your handling code here:
        //int q1 =  Integer.parseInt(jTqtd1.getText());
        //int v1 =  Integer.parseInt(jTAvalor1.getText());
        //int tot = q1*v1;
        //jTAvalor2.setText(String.valueOf(tot));
    }//GEN-LAST:event_jTqtd2FocusLost

    private void jTAmbiente2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente2FocusLost
        // TODO add your handling code here:
        if (jTAmbiente2.getText().equals("")){
            jTqtd2.setEnabled(false);
            jTqtd2.setText("");
            jTAvalor2.setEnabled(false);
            jTAvalor2.setText("");
            jTAmbiente3.setText("");
            jButton8.setEnabled(true);
            jTAmbiente3.setEnabled(false);
        }else{
            jTqtd2.setEnabled(true);
            jTqtd2.setText("1");
            jTAvalor2.setEnabled(true);
            jTAvalor2.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente3.setEnabled(true);
        }
    }//GEN-LAST:event_jTAmbiente2FocusLost

    private void jTAmbiente3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente3FocusLost
        // TODO add your handling code here:
                if (jTAmbiente3.getText().equals("")){
            jTqtd3.setEnabled(false);
            jTqtd3.setText("");
            jTAvalor3.setEnabled(false);
            jTAvalor3.setText("");
            jTAmbiente4.setText("");
            jButton8.setEnabled(true);
            jTAmbiente4.setEnabled(false);
        }else{
            jTqtd3.setEnabled(true);
            jTqtd3.setText("1");
            jTAvalor3.setEnabled(true);
            jTAvalor3.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente4.setEnabled(true);
        }
    }//GEN-LAST:event_jTAmbiente3FocusLost

    private void jTAmbiente4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente4FocusLost
        // TODO add your handling code here:
                if (jTAmbiente4.getText().equals("")){
            jTqtd4.setEnabled(false);
            jTqtd4.setText("");
            jTAvalor4.setEnabled(false);
            jTAvalor4.setText("");
            jTAmbiente5.setText("");
            jButton8.setEnabled(true);
            jTAmbiente5.setEnabled(false);
        }else{
            jTqtd4.setEnabled(true);
            jTqtd4.setText("1");
            jTAvalor4.setEnabled(true);
            jTAvalor4.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente5.setEnabled(true);
        }
    }//GEN-LAST:event_jTAmbiente4FocusLost

    private void jTAmbiente5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente5FocusLost
        // TODO add your handling code here:
                if (jTAmbiente5.getText().equals("")){
            jTqtd5.setEnabled(false);
            jTqtd5.setText("");
            jTAvalor5.setEnabled(false);
            jTAvalor5.setText("");
            jTAmbiente6.setText("");
            jButton8.setEnabled(true);
            jTAmbiente6.setEnabled(false);
        }else{
            jTqtd5.setEnabled(true);
            jTqtd5.setText("1");
            jTAvalor5.setEnabled(true);
            jTAvalor5.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente6.setEnabled(true);
        }
    }//GEN-LAST:event_jTAmbiente5FocusLost

    private void jTAmbiente6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente6FocusLost
        // TODO add your handling code here:
                if (jTAmbiente6.getText().equals("")){
            jTqtd6.setEnabled(false);
            jTqtd6.setText("");
            jTAvalor6.setEnabled(false);
            jTAvalor6.setText("");
            jTAmbiente7.setText("");
            jButton8.setEnabled(true);
            jTAmbiente7.setEnabled(false);
        }else{
            jTqtd6.setEnabled(true);
            jTqtd6.setText("1");
            jTAvalor6.setEnabled(true);
            jTAvalor6.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente7.setEnabled(true);
        }
    }//GEN-LAST:event_jTAmbiente6FocusLost

    private void jTAmbiente7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente7FocusLost
        // TODO add your handling code here:
                if (jTAmbiente7.getText().equals("")){
            jTqtd7.setEnabled(false);
            jTqtd7.setText("");
            jTAvalor7.setEnabled(false);
            jTAvalor7.setText("");
            jTAmbiente8.setText("");
            jButton8.setEnabled(true);
            jTAmbiente8.setEnabled(false);
        }else{
            jTqtd7.setEnabled(true);
            jTqtd7.setText("1");
            jTAvalor7.setEnabled(true);
            jTAvalor7.setText("0");
            jButton8.setEnabled(false);
            jTAmbiente8.setEnabled(true);
            
        }
    }//GEN-LAST:event_jTAmbiente7FocusLost

    private void jTAvalor3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor3FocusLost
        // TODO add your handling code here:
        if (!jTAvalor3.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor3.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor3.setEditable(false);
            jTAmbiente3.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor3FocusLost

    private void jTAvalor4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor4FocusLost
        // TODO add your handling code here:
        if (!jTAvalor4.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor4.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor4.setEditable(false);
            jTAmbiente4.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor4FocusLost

    private void jTAvalor5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor5FocusLost
        // TODO add your handling code here:
        if (!jTAvalor5.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor5.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor5.setEditable(false);
            jTAmbiente5.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor5FocusLost

    private void jTAvalor6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor6FocusLost
        // TODO add your handling code here:
        if (!jTAvalor6.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor6.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor6.setEditable(false);
            jTAmbiente6.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor6FocusLost

    private void jTAvalor7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor7FocusLost
        // TODO add your handling code here:
        if (!jTAvalor7.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor7.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor7.setEditable(false);
            jTAmbiente7.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor7FocusLost

    private void jTAvalor8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAvalor8FocusLost
        // TODO add your handling code here:
        if (!jTAvalor8.getText().equals("")){
            
            jButton8.setEnabled(true);
            
        }
        if (jTAvalor8.getText().equals("") || jTAvalor1.getText().equals("0")) {
            JOptionPane.showMessageDialog(null, "VALOR NAO PODE SER NULO OU 0!");
            //jTAvalor8.setEditable(false);
            jTAmbiente8.requestFocus();
        }
    }//GEN-LAST:event_jTAvalor8FocusLost

    private void jTAmbiente8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTAmbiente8FocusLost
        // TODO add your handling code here:
        if (jTAmbiente8.getText().equals("")){
            jTqtd8.setEnabled(false);
            jTqtd8.setText("");
            jTAvalor8.setEnabled(false);
            jTAvalor8.setText("");
            jTAmbiente8.setText("");
            jButton8.setEnabled(true);
            //jTAmbiente8.setEnabled(false);
        }else{
            jTqtd8.setEnabled(true);
            jTqtd8.setText("1");
            jTAvalor8.setEnabled(true);
            jTAvalor8.setText("0");
            jButton8.setEnabled(false);
            //jTAmbiente8.setEnabled(true);
            
        }
        
    }//GEN-LAST:event_jTAmbiente8FocusLost

    private void jBeditcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditcActionPerformed
        // TODO add your handling code here:
            jButton4.setEnabled(false);
            //jTAvalor1.requestFocus();
            jBeditc.setEnabled(false);
        if (jTAmbiente2.getText().equals("")){
            
            jButton4.setEnabled(false);
            jButton4.setEnabled(true);
            jTAvalor1.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor1.requestFocus();
        }else if (jTAmbiente3.getText().equals("")){
            
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor2.requestFocus();
        }else if (jTAmbiente4.getText().equals("")){
            
            
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor3.requestFocus();
        }else if (jTAmbiente5.getText().equals("")){
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("0");
            jTAvalor4.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor4.setEnabled(true);
            jTAvalor4.requestFocus();
        }else if (jTAmbiente6.getText().equals("")){
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("0");
            jTAvalor4.setText("0");
            jTAvalor5.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor4.setEnabled(true);
            jTAvalor5.setEnabled(true);
            jTAvalor5.requestFocus();
        }else if (jTAmbiente7.getText().equals("")){
            
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("0");
            jTAvalor4.setText("0");
            jTAvalor5.setText("0");
            jTAvalor6.setText("");
            jTAvalor6.requestFocus();
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor4.setEnabled(true);
            jTAvalor5.setEnabled(true);
            jTAvalor6.setEnabled(true);
            jTAvalor6.requestFocus();
        }else if (jTAmbiente8.getText().equals("")){
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("0");
            jTAvalor4.setText("0");
            jTAvalor5.setText("0");
            jTAvalor6.setText("0");
            jTAvalor7.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor4.setEnabled(true);
            jTAvalor5.setEnabled(true);
            jTAvalor6.setEnabled(true);
            jTAvalor7.setEnabled(true);
            jTAvalor7.requestFocus();
        }else {
            
            jButton4.setEnabled(false);
            jTAvalor1.setText("0");
            jTAvalor2.setText("0");
            jTAvalor3.setText("0");
            jTAvalor4.setText("0");
            jTAvalor5.setText("0");
            jTAvalor6.setText("0");
            jTAvalor7.setText("0");
            jTAvalor8.setText("");
            jTAvalor1.setEnabled(true);
            jTAvalor2.setEnabled(true);
            jTAvalor3.setEnabled(true);
            jTAvalor4.setEnabled(true);
            jTAvalor5.setEnabled(true);
            jTAvalor6.setEnabled(true);
            jTAvalor7.setEnabled(true);
            jTAvalor8.setEnabled(true);
            jTAvalor8.requestFocus();
        }
    }//GEN-LAST:event_jBeditcActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MinhaTabela;
    private javax.swing.JComboBox boxNombre;
    private javax.swing.JButton jBEvolta;
    private javax.swing.JButton jBLimpar;
    private javax.swing.JButton jBNext_Itens;
    private javax.swing.JButton jBeditc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jCCondicao;
    private javax.swing.JComboBox jCEuf;
    private javax.swing.JComboBox jCForma;
    private javax.swing.JComboBox jCParcela;
    private javax.swing.JFormattedTextField jFCEP;
    private javax.swing.JFormattedTextField jFEcep;
    private javax.swing.JFormattedTextField jFEfone1;
    private javax.swing.JFormattedTextField jFEfone2;
    private javax.swing.JFormattedTextField jFFONE1;
    private javax.swing.JFormattedTextField jFFONE2;
    private javax.swing.JFormattedTextField jFdataEn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabeljj;
    private javax.swing.JLabel jLabeljj1;
    private javax.swing.JLabel jLenderecoe;
    private javax.swing.JLabel jLenderecoee;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelJanela3;
    private javax.swing.JPanel jPanelJanela4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTAmbiente1;
    private javax.swing.JTextField jTAmbiente2;
    private javax.swing.JTextField jTAmbiente3;
    private javax.swing.JTextField jTAmbiente4;
    private javax.swing.JTextField jTAmbiente5;
    private javax.swing.JTextField jTAmbiente6;
    private javax.swing.JTextField jTAmbiente7;
    private javax.swing.JTextField jTAmbiente8;
    private javax.swing.JTextField jTAtotal;
    private javax.swing.JTextField jTAvalor1;
    private javax.swing.JTextField jTAvalor2;
    private javax.swing.JTextField jTAvalor3;
    private javax.swing.JTextField jTAvalor4;
    private javax.swing.JTextField jTAvalor5;
    private javax.swing.JTextField jTAvalor6;
    private javax.swing.JTextField jTAvalor7;
    private javax.swing.JTextField jTAvalor8;
    private javax.swing.JTextField jTBAIRRO;
    private javax.swing.JButton jTBCalc;
    private javax.swing.JTextField jTCIDADE;
    private javax.swing.JTextField jTCOMP;
    private javax.swing.JTextField jTCPF;
    private javax.swing.JTextField jTEMAIL;
    private javax.swing.JTextField jTENDERECO;
    private javax.swing.JTextField jTEbairro;
    private javax.swing.JTextField jTEcidade;
    private javax.swing.JTextField jTEcomp;
    private javax.swing.JTextField jTEemail;
    private javax.swing.JTextField jTEendereco;
    private javax.swing.JTextField jTEenderecoee;
    private javax.swing.JTextField jTEnome;
    private javax.swing.JTextField jTEnumero;
    private javax.swing.JTextField jTNUMERO;
    private javax.swing.JTextField jTPESSOA;
    private javax.swing.JTextField jTREGISTRO;
    private javax.swing.JTextField jTUF;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTenderecoe;
    private javax.swing.JTextField jTentrada;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jTfcontrato;
    private javax.swing.JTextArea jTmodulos;
    private javax.swing.JTextField jTmontagem;
    private javax.swing.JTextField jTn_contrato;
    private javax.swing.JTextField jTqtd1;
    private javax.swing.JTextField jTqtd2;
    private javax.swing.JTextField jTqtd3;
    private javax.swing.JTextField jTqtd4;
    private javax.swing.JTextField jTqtd5;
    private javax.swing.JTextField jTqtd6;
    private javax.swing.JTextField jTqtd7;
    private javax.swing.JTextField jTqtd8;
    private javax.swing.JTextField jTtotal;
    private javax.swing.JTextField jTtotal2;
    private javax.swing.JTextField jTuser;
    private javax.swing.JPanel qdcentro;
    private javax.swing.JPanel qdcentro1;
    private javax.swing.JPanel qdcentro2;
    private javax.swing.JPanel qdcentro3;
    private javax.swing.JPanel qdcentro4;
    // End of variables declaration//GEN-END:variables
}
