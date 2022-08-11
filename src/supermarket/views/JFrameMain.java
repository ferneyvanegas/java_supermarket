/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supermarket.views;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import supermarket.classes.TextPrompt;



/**
 *
 * @author fercho
 */
public class JFrameMain extends javax.swing.JFrame {

    /**
     * Creates new form JFrameMain
     */
    public JFrameMain() {
        initComponents();
        // ================================
        // PLACEHOLDERS
        // ================================
        // Customer
        TextPrompt pHolderDocument = new TextPrompt("Número. Ej: 123456", this.jTxtDocument);
        TextPrompt pHolderName = new TextPrompt("Máximo 100 caracteres", this.jTxtFName);
        TextPrompt pHolderSName = new TextPrompt("Máximo 100 caracteres", this.jTxtFSurname);
        TextPrompt pHolderNum = new TextPrompt("Menor que 1000", this.jTxtAddrNum);
        TextPrompt pHolderWard = new TextPrompt("Máximo 100 caracteres", this.jTxtAddrWard);
        // Dealer
        TextPrompt pHolderNit = new TextPrompt("Máximo 15 caracteres", this.jTxtNit);
        TextPrompt pHolderRName = new TextPrompt("Máximo 100 caracteres", this.jTxtRName);
        TextPrompt pHolderEmail = new TextPrompt("Máximo 100 caracteres", this.jTxtEmail);
        TextPrompt pHolderAgent = new TextPrompt("Máximo 100 caracteres", this.jTxtAgent);
        TextPrompt pHolderWebSite = new TextPrompt("Máximo 100 caracteres", this.jTxtWebSite);
        TextPrompt pHolderNumDeal = new TextPrompt("Menor que 1000", this.jTxtAddrNumDeal);
        TextPrompt pHolderWardDeal = new TextPrompt("Máximo 100 caracteres", this.jTxtAddrWardDeal);
        // Sales
        TextPrompt pHolderSaleDescount = new TextPrompt("Ej: 10", this.jTxtSaleDiscount);
        
        // ================================
        // ESCONDIDOS
        // ================================
        // Cusomer
        this.jLbPhone.setVisible(false);
        this.jLbIdAddress.setVisible(false);
        this.jLbIdCustomer.setVisible(false);
        // Dealer
        this.jLbIdDealer.setVisible(false);
        this.jLbIdAddressDeal.setVisible(false);
        
        // ================================
        // IMAGENES
        // ================================
        // Customer 
        this.setImageButton(this.jBtnCustomerSave, "src/supermarket/views/images/plus.png");
        this.setImageButton(this.jBtnCustomerSearch, "src/supermarket/views/images/loupe.png");
        this.setImageButton(this.jBtnCustomerEdit, "src/supermarket/views/images/pencil.png");
        this.setImageButton(this.jBtnCustomerDelete, "src/supermarket/views/images/x-button.png");
        this.setImageButton(this.jBtnCustomerClear, "src/supermarket/views/images/cleaning.png");
        this.setImageButton(this.jBtnAddPhone, "src/supermarket/views/images/plus.png");
        this.setImageButton(this.jBtnQuitPhone, "src/supermarket/views/images/x-button.png");
        // Dealer
        this.setImageButton(this.jBtnDealerSave, "src/supermarket/views/images/plus.png");
        this.setImageButton(this.jBtnDealerSearch, "src/supermarket/views/images/loupe.png");
        this.setImageButton(this.jBtnDealerEdit, "src/supermarket/views/images/pencil.png");
        this.setImageButton(this.jBtnDealerDelete, "src/supermarket/views/images/x-button.png");
        this.setImageButton(this.jBtnDealerClear, "src/supermarket/views/images/cleaning.png");
        // Categories
        this.setImageButton(this.jBtnAddCategory, "src/supermarket/views/images/plus.png");
        this.setImageButton(this.jBtnDelCategory, "src/supermarket/views/images/x-button.png");
        // Products
        this.setImageButton(this.jBtnProductAdd, "src/supermarket/views/images/plus.png");
        this.setImageButton(this.jBtnProductEdit, "src/supermarket/views/images/pencil.png");
        this.setImageButton(this.jBtnProductDelete, "src/supermarket/views/images/x-button.png");
        this.setImageButton(this.jBtnProductClear, "src/supermarket/views/images/cleaning.png");
        // Sales
        this.setImageButton(this.jBtnSaleQuitProduct, "src/supermarket/views/images/x-button.png");
        // Repors
        this.setImageButton(this.jBtnReportCheck, "src/supermarket/views/images/loupe.png");
        // ================================
        this.setLocationRelativeTo(null); // Centrar el Formulario
    }
    
    // Método para ajustar la imagen al Button
    private void setImageButton(JButton jButton, String path){
        ImageIcon image = new ImageIcon(path);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_DEFAULT));
        jButton.setIcon(icon);
        this.repaint();
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
        jPanel1 = new javax.swing.JPanel();
        jBtnCustomerSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTxtSSurname = new javax.swing.JTextField();
        jTxtFSurname = new javax.swing.JTextField();
        jTxtSName = new javax.swing.JTextField();
        jTxtFName = new javax.swing.JTextField();
        jTxtDocument = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jCmbStreet = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTxtAddrNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtAddrWard = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jCmbCity = new javax.swing.JComboBox<>();
        jBtnAddPhone = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLstPhones = new javax.swing.JList<>();
        jBtnQuitPhone = new javax.swing.JButton();
        jBtnCustomerSave = new javax.swing.JButton();
        jBtnCustomerEdit = new javax.swing.JButton();
        jLbIdCustomer = new javax.swing.JLabel();
        jLbIdAddress = new javax.swing.JLabel();
        jLbPhone = new javax.swing.JLabel();
        jBtnCustomerDelete = new javax.swing.JButton();
        jBtnCustomerClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTxtWebSite = new javax.swing.JTextField();
        jTxtAgent = new javax.swing.JTextField();
        jTxtEmail = new javax.swing.JTextField();
        jTxtRName = new javax.swing.JTextField();
        jTxtNit = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jCmbStreetDeal = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jTxtAddrNumDeal = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTxtAddrWardDeal = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jCmbCityDeal = new javax.swing.JComboBox<>();
        jBtnDealerSave = new javax.swing.JButton();
        jBtnDealerSearch = new javax.swing.JButton();
        jBtnDealerEdit = new javax.swing.JButton();
        jBtnDealerDelete = new javax.swing.JButton();
        jBtnDealerClear = new javax.swing.JButton();
        jLbIdDealer = new javax.swing.JLabel();
        jLbIdAddressDeal = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jCmbCategory = new javax.swing.JComboBox<>();
        jBtnAddCategory = new javax.swing.JButton();
        jBtnDelCategory = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTxtProductName = new javax.swing.JTextField();
        jTxtProductPrice = new javax.swing.JTextField();
        jChkStock = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListDealers = new javax.swing.JList<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblProducts = new javax.swing.JTable();
        jBtnProductAdd = new javax.swing.JButton();
        jBtnProductDelete = new javax.swing.JButton();
        jBtnProductEdit = new javax.swing.JButton();
        jBtnProductClear = new javax.swing.JButton();
        jLbIdProduct = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jCmbSaleCustomer = new javax.swing.JComboBox<>();
        jLbSaleTotal = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSaleProductsGroup = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListSaleProducts = new javax.swing.JList<>();
        jLabel33 = new javax.swing.JLabel();
        jCmbSaleStrategy = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        jLbSaleInterest = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jBtnSaleRegister = new javax.swing.JButton();
        jBtnSaleQuitProduct = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jTxtSaleDiscount = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jCmbReportCustomer = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListReportSales = new javax.swing.JList<>();
        jBtnReportCheck = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jBtnCustomerSearch.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCustomerSearch.setBorder(null);
        jBtnCustomerSearch.setBorderPainted(false);
        jBtnCustomerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCustomerSearch);
        jBtnCustomerSearch.setBounds(230, 280, 40, 40);

        jLabel6.setFont(new java.awt.Font("Dyuthi", 1, 18)); // NOI18N
        jLabel6.setText("Dirección");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(380, 10, 120, 19);

        jLabel12.setFont(new java.awt.Font("Dyuthi", 1, 18)); // NOI18N
        jLabel12.setText("Datos personales");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 10, 125, 19);

        jLabel8.setText("__________________________________________________________________________________________________________________");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 20, 700, 15);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTxtSSurname.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jTxtSSurname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSSurnameActionPerformed(evt);
            }
        });

        jTxtFSurname.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtSName.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtFName.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtDocument.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel1.setText("Documento *");

        jLabel2.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel2.setText("Primer Nombre *");

        jLabel3.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel3.setText("Segundo Nombre");

        jLabel4.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel4.setText("Primer Apellido *");

        jLabel5.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel5.setText("Segundo Apellido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtSName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(47, 47, 47)
                                        .addComponent(jTxtSSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(48, 48, 48)
                                        .addComponent(jTxtFSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtFSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtSSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 50, 340, 220);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel7.setText("Calle *");

        jCmbStreet.setBackground(new java.awt.Color(255, 255, 255));
        jCmbStreet.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jCmbStreet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle", "Carrera" }));

        jLabel13.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel13.setText("Número *");

        jTxtAddrNum.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel9.setText("Barrio *");

        jTxtAddrWard.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel10.setText("Ciudad *");

        jLabel11.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel11.setText("Telefono *");

        jCmbCity.setBackground(new java.awt.Color(255, 255, 255));
        jCmbCity.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jCmbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bogotá", "Medellín", "Villavicencio" }));

        jBtnAddPhone.setBorder(null);
        jBtnAddPhone.setBorderPainted(false);

        jScrollPane3.setViewportView(jLstPhones);

        jBtnQuitPhone.setBorder(null);
        jBtnQuitPhone.setBorderPainted(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jBtnAddPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnQuitPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtAddrWard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtAddrNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmbStreet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCmbCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(278, 278, 278))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTxtAddrNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTxtAddrWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jCmbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAddPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnQuitPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(380, 50, 320, 220);

        jBtnCustomerSave.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCustomerSave.setBorder(null);
        jBtnCustomerSave.setBorderPainted(false);
        jBtnCustomerSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCustomerSave);
        jBtnCustomerSave.setBounds(120, 280, 40, 40);

        jBtnCustomerEdit.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCustomerEdit.setBorder(null);
        jBtnCustomerEdit.setBorderPainted(false);
        jBtnCustomerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerEditActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCustomerEdit);
        jBtnCustomerEdit.setBounds(340, 280, 40, 40);

        jLbIdCustomer.setText("idCustomer");
        jPanel1.add(jLbIdCustomer);
        jLbIdCustomer.setBounds(160, 10, 100, 15);

        jLbIdAddress.setText("idAddress");
        jPanel1.add(jLbIdAddress);
        jLbIdAddress.setBounds(500, 10, 80, 15);

        jLbPhone.setText("actualPhone");
        jPanel1.add(jLbPhone);
        jLbPhone.setBounds(600, 10, 100, 15);

        jBtnCustomerDelete.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCustomerDelete.setBorder(null);
        jBtnCustomerDelete.setBorderPainted(false);
        jBtnCustomerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCustomerDelete);
        jBtnCustomerDelete.setBounds(450, 280, 40, 40);

        jBtnCustomerClear.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCustomerClear.setBorder(null);
        jBtnCustomerClear.setBorderPainted(false);
        jBtnCustomerClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCustomerClearActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnCustomerClear);
        jBtnCustomerClear.setBounds(550, 280, 40, 40);

        jTabbedPane1.addTab("Clientes", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Dyuthi", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("Datos de Proveedor");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(20, 10, 170, 19);

        jLabel15.setText("__________________________________________________________________________________________________________________");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(20, 20, 700, 15);

        jLabel16.setFont(new java.awt.Font("Dyuthi", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 204));
        jLabel16.setText("Dirección");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(380, 10, 120, 19);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTxtWebSite.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jTxtWebSite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtWebSiteActionPerformed(evt);
            }
        });

        jTxtAgent.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtEmail.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtRName.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTxtNit.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel17.setText("Nit*");

        jLabel18.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel18.setText("Razón Social*");

        jLabel19.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel19.setText("Email*");

        jLabel20.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel20.setText("Representante Legal*");

        jLabel21.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel21.setText("Sitio Web*");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtRName, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNit, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtRName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 50, 340, 220);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel22.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel22.setText("Calle *");

        jCmbStreetDeal.setBackground(new java.awt.Color(255, 255, 255));
        jCmbStreetDeal.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jCmbStreetDeal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Calle", "Carrera" }));

        jLabel23.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel23.setText("Número *");

        jTxtAddrNumDeal.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel24.setText("Barrio *");

        jTxtAddrWardDeal.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel25.setText("Ciudad *");

        jCmbCityDeal.setBackground(new java.awt.Color(255, 255, 255));
        jCmbCityDeal.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jCmbCityDeal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bogotá", "Medellín", "Villavicencio" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtAddrWardDeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtAddrNumDeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmbStreetDeal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jCmbCityDeal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(278, 278, 278))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCmbStreetDeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jTxtAddrNumDeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jTxtAddrWardDeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jCmbCityDeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6);
        jPanel6.setBounds(380, 50, 320, 220);

        jBtnDealerSave.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDealerSave.setBorder(null);
        jBtnDealerSave.setBorderPainted(false);
        jBtnDealerSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDealerSaveActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnDealerSave);
        jBtnDealerSave.setBounds(120, 280, 40, 40);

        jBtnDealerSearch.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDealerSearch.setBorder(null);
        jBtnDealerSearch.setBorderPainted(false);
        jBtnDealerSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDealerSearchActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnDealerSearch);
        jBtnDealerSearch.setBounds(230, 280, 40, 40);

        jBtnDealerEdit.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDealerEdit.setBorder(null);
        jBtnDealerEdit.setBorderPainted(false);
        jBtnDealerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDealerEditActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnDealerEdit);
        jBtnDealerEdit.setBounds(340, 280, 40, 40);

        jBtnDealerDelete.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDealerDelete.setBorder(null);
        jBtnDealerDelete.setBorderPainted(false);
        jBtnDealerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDealerDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnDealerDelete);
        jBtnDealerDelete.setBounds(450, 280, 40, 40);

        jBtnDealerClear.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDealerClear.setBorder(null);
        jBtnDealerClear.setBorderPainted(false);
        jBtnDealerClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDealerClearActionPerformed(evt);
            }
        });
        jPanel2.add(jBtnDealerClear);
        jBtnDealerClear.setBounds(550, 280, 40, 40);

        jLbIdDealer.setText("idDealer");
        jPanel2.add(jLbIdDealer);
        jLbIdDealer.setBounds(180, 10, 100, 15);

        jLbIdAddressDeal.setText("idAddressDeal");
        jPanel2.add(jLbIdAddressDeal);
        jLbIdAddressDeal.setBounds(520, 10, 120, 15);

        jTabbedPane1.addTab("Proveedores", jPanel2);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(null);

        jCmbCategory.setBackground(new java.awt.Color(255, 255, 255));
        jCmbCategory.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel7.add(jCmbCategory);
        jCmbCategory.setBounds(10, 30, 120, 25);

        jBtnAddCategory.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAddCategory.setFont(new java.awt.Font("Dyuthi", 1, 12)); // NOI18N
        jBtnAddCategory.setBorder(null);
        jBtnAddCategory.setBorderPainted(false);
        jPanel7.add(jBtnAddCategory);
        jBtnAddCategory.setBounds(140, 30, 20, 20);

        jBtnDelCategory.setBackground(new java.awt.Color(255, 255, 255));
        jBtnDelCategory.setFont(new java.awt.Font("Dyuthi", 1, 12)); // NOI18N
        jBtnDelCategory.setBorder(null);
        jBtnDelCategory.setBorderPainted(false);
        jPanel7.add(jBtnDelCategory);
        jBtnDelCategory.setBounds(170, 30, 20, 20);

        jLabel27.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel27.setText("Categoría*");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(10, 10, 80, 15);

        jLabel28.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel28.setText("Proveedores");
        jPanel7.add(jLabel28);
        jLabel28.setBounds(410, 10, 80, 15);

        jLabel29.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel29.setText("Producto*");
        jPanel7.add(jLabel29);
        jLabel29.setBounds(220, 10, 80, 15);

        jLabel30.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel30.setText("Precio*");
        jPanel7.add(jLabel30);
        jLabel30.setBounds(220, 60, 80, 15);

        jTxtProductName.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel7.add(jTxtProductName);
        jTxtProductName.setBounds(220, 30, 170, 23);

        jTxtProductPrice.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel7.add(jTxtProductPrice);
        jTxtProductPrice.setBounds(220, 80, 170, 23);

        jChkStock.setBackground(new java.awt.Color(255, 255, 255));
        jChkStock.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jChkStock.setText("Stock");
        jPanel7.add(jChkStock);
        jChkStock.setBounds(10, 70, 107, 24);

        jListDealers.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jListDealers);

        jPanel7.add(jScrollPane1);
        jScrollPane1.setBounds(410, 30, 210, 80);

        jPanel8.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jTblProducts.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jTblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Item", "Producto", "Precio", "Categoría", "Stock"
            }
        ));
        jScrollPane2.setViewportView(jTblProducts);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Productos", jPanel8);

        jPanel7.add(jTabbedPane2);
        jTabbedPane2.setBounds(10, 120, 700, 200);

        jBtnProductAdd.setBackground(new java.awt.Color(255, 255, 255));
        jBtnProductAdd.setBorder(null);
        jBtnProductAdd.setBorderPainted(false);
        jPanel7.add(jBtnProductAdd);
        jBtnProductAdd.setBounds(640, 20, 30, 30);

        jBtnProductDelete.setBackground(new java.awt.Color(255, 255, 255));
        jBtnProductDelete.setBorder(null);
        jBtnProductDelete.setBorderPainted(false);
        jPanel7.add(jBtnProductDelete);
        jBtnProductDelete.setBounds(680, 70, 30, 30);

        jBtnProductEdit.setBackground(new java.awt.Color(255, 255, 255));
        jBtnProductEdit.setBorder(null);
        jBtnProductEdit.setBorderPainted(false);
        jPanel7.add(jBtnProductEdit);
        jBtnProductEdit.setBounds(680, 20, 30, 30);

        jBtnProductClear.setBackground(new java.awt.Color(255, 255, 255));
        jBtnProductClear.setBorder(null);
        jBtnProductClear.setBorderPainted(false);
        jPanel7.add(jBtnProductClear);
        jBtnProductClear.setBounds(640, 70, 30, 30);

        jLbIdProduct.setText("idCustomer");
        jPanel7.add(jLbIdProduct);
        jLbIdProduct.setBounds(290, 10, 100, 15);

        jTabbedPane1.addTab("Productos", jPanel7);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel31.setText("Cliente");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(10, 10, 80, 15);

        jCmbSaleCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jCmbSaleCustomer.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel9.add(jCmbSaleCustomer);
        jCmbSaleCustomer.setBounds(10, 30, 120, 25);

        jLbSaleTotal.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLbSaleTotal.setText("$");
        jPanel9.add(jLbSaleTotal);
        jLbSaleTotal.setBounds(630, 270, 80, 15);

        jListSaleProductsGroup.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(jListSaleProductsGroup);

        jPanel9.add(jScrollPane4);
        jScrollPane4.setBounds(390, 70, 320, 190);

        jListSaleProducts.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jScrollPane5.setViewportView(jListSaleProducts);

        jPanel9.add(jScrollPane5);
        jScrollPane5.setBounds(10, 70, 320, 190);

        jLabel33.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel33.setText("Fijar pago");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(170, 10, 80, 15);

        jCmbSaleStrategy.setBackground(new java.awt.Color(255, 255, 255));
        jCmbSaleStrategy.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel9.add(jCmbSaleStrategy);
        jCmbSaleStrategy.setBounds(170, 30, 120, 25);

        jLabel34.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel34.setText("%");
        jPanel9.add(jLabel34);
        jLabel34.setBounds(520, 270, 20, 15);

        jLbSaleInterest.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLbSaleInterest.setText(" ");
        jPanel9.add(jLbSaleInterest);
        jLbSaleInterest.setBounds(390, 30, 80, 15);

        jLabel36.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel36.setText("Interés");
        jPanel9.add(jLabel36);
        jLabel36.setBounds(390, 10, 80, 15);

        jBtnSaleRegister.setText("REGISTRAR VENTA");
        jPanel9.add(jBtnSaleRegister);
        jBtnSaleRegister.setBounds(390, 300, 320, 31);

        jBtnSaleQuitProduct.setBackground(new java.awt.Color(255, 255, 255));
        jBtnSaleQuitProduct.setBorder(null);
        jBtnSaleQuitProduct.setBorderPainted(false);
        jPanel9.add(jBtnSaleQuitProduct);
        jBtnSaleQuitProduct.setBounds(680, 40, 30, 30);

        jLabel35.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel35.setText("TOTAL $");
        jPanel9.add(jLabel35);
        jLabel35.setBounds(570, 270, 70, 15);

        jTxtSaleDiscount.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jPanel9.add(jTxtSaleDiscount);
        jTxtSaleDiscount.setBounds(460, 263, 50, 23);

        jLabel37.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel37.setText("Descuento");
        jPanel9.add(jLabel37);
        jLabel37.setBounds(390, 270, 70, 15);

        jTabbedPane1.addTab("Ventas", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel32.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jLabel32.setText("Cliente");

        jCmbReportCustomer.setBackground(new java.awt.Color(255, 255, 255));
        jCmbReportCustomer.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N

        jListReportSales.setFont(new java.awt.Font("Dyuthi", 0, 14)); // NOI18N
        jScrollPane6.setViewportView(jListReportSales);

        jBtnReportCheck.setBackground(new java.awt.Color(255, 255, 255));
        jBtnReportCheck.setBorder(null);
        jBtnReportCheck.setBorderPainted(false);

        jLabel26.setFont(new java.awt.Font("Dyuthi", 1, 14)); // NOI18N
        jLabel26.setText("Descripción");

        jLabel38.setFont(new java.awt.Font("Dyuthi", 2, 14)); // NOI18N
        jLabel38.setText("Todos los productos adquiridos por este cliente");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCmbReportCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jBtnReportCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(5, 5, 5)
                            .addComponent(jCmbReportCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel38)))
                    .addComponent(jBtnReportCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informe de Productos", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnCustomerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCustomerSearchActionPerformed

    private void jTxtSSurnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSSurnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtSSurnameActionPerformed

    private void jBtnCustomerSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCustomerSaveActionPerformed

    private void jBtnCustomerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCustomerEditActionPerformed

    private void jBtnCustomerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCustomerDeleteActionPerformed

    private void jBtnCustomerClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCustomerClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnCustomerClearActionPerformed

    private void jTxtWebSiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtWebSiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtWebSiteActionPerformed

    private void jBtnDealerSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDealerSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDealerSaveActionPerformed

    private void jBtnDealerSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDealerSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDealerSearchActionPerformed

    private void jBtnDealerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDealerEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDealerEditActionPerformed

    private void jBtnDealerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDealerDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDealerDeleteActionPerformed

    private void jBtnDealerClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDealerClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnDealerClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnAddCategory;
    public javax.swing.JButton jBtnAddPhone;
    public javax.swing.JButton jBtnCustomerClear;
    public javax.swing.JButton jBtnCustomerDelete;
    public javax.swing.JButton jBtnCustomerEdit;
    public javax.swing.JButton jBtnCustomerSave;
    public javax.swing.JButton jBtnCustomerSearch;
    public javax.swing.JButton jBtnDealerClear;
    public javax.swing.JButton jBtnDealerDelete;
    public javax.swing.JButton jBtnDealerEdit;
    public javax.swing.JButton jBtnDealerSave;
    public javax.swing.JButton jBtnDealerSearch;
    public javax.swing.JButton jBtnDelCategory;
    public javax.swing.JButton jBtnProductAdd;
    public javax.swing.JButton jBtnProductClear;
    public javax.swing.JButton jBtnProductDelete;
    public javax.swing.JButton jBtnProductEdit;
    public javax.swing.JButton jBtnQuitPhone;
    public javax.swing.JButton jBtnReportCheck;
    public javax.swing.JButton jBtnSaleQuitProduct;
    public javax.swing.JButton jBtnSaleRegister;
    public javax.swing.JCheckBox jChkStock;
    public javax.swing.JComboBox<String> jCmbCategory;
    public javax.swing.JComboBox<String> jCmbCity;
    public javax.swing.JComboBox<String> jCmbCityDeal;
    public javax.swing.JComboBox<String> jCmbReportCustomer;
    public javax.swing.JComboBox<String> jCmbSaleCustomer;
    public javax.swing.JComboBox<String> jCmbSaleStrategy;
    public javax.swing.JComboBox<String> jCmbStreet;
    public javax.swing.JComboBox<String> jCmbStreetDeal;
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
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JLabel jLbIdAddress;
    public javax.swing.JLabel jLbIdAddressDeal;
    public javax.swing.JLabel jLbIdCustomer;
    public javax.swing.JLabel jLbIdDealer;
    public javax.swing.JLabel jLbIdProduct;
    public javax.swing.JLabel jLbPhone;
    public javax.swing.JLabel jLbSaleInterest;
    public javax.swing.JLabel jLbSaleTotal;
    public javax.swing.JList<String> jListDealers;
    public javax.swing.JList<String> jListReportSales;
    public javax.swing.JList<String> jListSaleProducts;
    public javax.swing.JList<String> jListSaleProductsGroup;
    public javax.swing.JList<String> jLstPhones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jTblProducts;
    public javax.swing.JTextField jTxtAddrNum;
    public javax.swing.JTextField jTxtAddrNumDeal;
    public javax.swing.JTextField jTxtAddrWard;
    public javax.swing.JTextField jTxtAddrWardDeal;
    public javax.swing.JTextField jTxtAgent;
    public javax.swing.JTextField jTxtDocument;
    public javax.swing.JTextField jTxtEmail;
    public javax.swing.JTextField jTxtFName;
    public javax.swing.JTextField jTxtFSurname;
    public javax.swing.JTextField jTxtNit;
    public javax.swing.JTextField jTxtProductName;
    public javax.swing.JTextField jTxtProductPrice;
    public javax.swing.JTextField jTxtRName;
    public javax.swing.JTextField jTxtSName;
    public javax.swing.JTextField jTxtSSurname;
    public javax.swing.JTextField jTxtSaleDiscount;
    public javax.swing.JTextField jTxtWebSite;
    // End of variables declaration//GEN-END:variables
}
