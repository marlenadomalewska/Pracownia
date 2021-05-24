/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipracownia;

import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Men Kowalski
 */
public class FormMain extends javax.swing.JFrame {

        /**
         * Creates new form FormMain
         */
         Pracownia p;
         FormAbout about;
         DefaultTableModel model;
         
         
    public FormMain() {
        initComponents();
        //this.p = new Pracownia();
        TextFieldLimit.setEnabled(true);
        ButtonLimit.setEnabled(true);
        ButtonDodaj.setEnabled(false);
        ButtonUsun.setEnabled(false);
       
        this.model = (DefaultTableModel) Tabela.getModel();
        model.setRowCount(0);
        this.TextFieldCena.setEnabled(false);
        this.TextFieldZasilanie.setEnabled(false);
        this.TextFieldProducent.setEnabled(false);
        this.TextFieldMonitor.setEnabled(false);
        this.ButtonRefresh.setEnabled(false);
        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        ButtonDodaj = new javax.swing.JButton();
        ButtonUsun = new javax.swing.JButton();
        TextFieldProducent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ButtonLimit = new javax.swing.JButton();
        TextFieldLimit = new javax.swing.JTextField();
        TextFieldZasilanie = new javax.swing.JTextField();
        TextFieldCena = new javax.swing.JTextField();
        TextFieldMonitor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ButtonRefresh = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuNew = new javax.swing.JMenuItem();
        MenuLoad = new javax.swing.JMenuItem();
        MenuLoadSer = new javax.swing.JMenuItem();
        MenuSave = new javax.swing.JMenuItem();
        MenuSaveSer = new javax.swing.JMenuItem();
        MenuAbout = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pracownia");
        setIconImage(
            new javax.swing.ImageIcon(getClass().getResource("/Images/iconimg.png")).getImage());
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        jLabel1.setText("PRACOWNIA");

        Tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nr", "Producent", "Monitor", "Zasilanie", "Cena"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabela.setRowHeight(20);
        Tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabela);
        Tabela.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Tabela.getColumnModel().getColumnCount() > 0) {
            Tabela.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        ButtonDodaj.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonDodaj.setText("Dodaj stanowisko");
        ButtonDodaj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonDodajMouseClicked(evt);
            }
        });

        ButtonUsun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ButtonUsun.setText("Usuń stanowisko");
        ButtonUsun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonUsunMouseClicked(evt);
            }
        });

        TextFieldProducent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Limit stanowisk:");

        ButtonLimit.setText("✓");
        ButtonLimit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonLimitMouseClicked(evt);
            }
        });

        TextFieldLimit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextFieldZasilanie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextFieldCena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        TextFieldMonitor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Producent:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Rozdzielczość:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Zasilanie:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cena:");

        ButtonRefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonRefresh.setText("Odśwież");
        ButtonRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonRefreshMouseClicked(evt);
            }
        });

        MenuFile.setText("File");

        MenuNew.setText("New");
        MenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuNewActionPerformed(evt);
            }
        });
        MenuFile.add(MenuNew);

        MenuLoad.setText("Load");
        MenuLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLoadActionPerformed(evt);
            }
        });
        MenuFile.add(MenuLoad);

        MenuLoadSer.setText("Load (Serialized)");
        MenuLoadSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLoadSerActionPerformed(evt);
            }
        });
        MenuFile.add(MenuLoadSer);

        MenuSave.setText("Save");
        MenuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSaveActionPerformed(evt);
            }
        });
        MenuFile.add(MenuSave);

        MenuSaveSer.setText("Save (Serialize)");
        MenuSaveSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSaveSerActionPerformed(evt);
            }
        });
        MenuFile.add(MenuSaveSer);

        MenuBar.add(MenuFile);

        MenuAbout.setText("About");
        MenuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAboutMouseClicked(evt);
            }
        });
        MenuBar.add(MenuAbout);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtonDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ButtonUsun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldLimit, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ButtonLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TextFieldProducent)
                                    .addComponent(TextFieldMonitor)
                                    .addComponent(TextFieldZasilanie)
                                    .addComponent(TextFieldCena, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(ButtonRefresh)))))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(449, 449, 449))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonLimit)
                            .addComponent(TextFieldLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ButtonDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonUsun)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldProducent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldZasilanie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextFieldCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonRefresh)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLoadActionPerformed
        try{
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            j.setFileFilter(filter);
            j.showOpenDialog(null);
            this.p = new Pracownia();
            this.p.wczytaj(j.getSelectedFile().toString());
            TextFieldLimit.setText(Integer.toString(this.p.getLimitStanowisk())); 
            TextFieldLimit.setEnabled(false);
            ButtonLimit.setEnabled(false);
            ButtonDodaj.setEnabled(true);
            ButtonUsun.setEnabled(true);

            model.setRowCount(p.getLimitStanowisk());
            for(int i=0; i<p.getLimitStanowisk(); i++){
                Object[] dane = {i+1, 
                    p.getStanowisko(i).getProducent(),
                    p.getStanowisko(i).getMonitorRozdzielczosc(),
                    p.getStanowisko(i).getZasilanie(),
                    p.getStanowisko(i).getCena()
                }; 
                model.insertRow(i, dane);
                model.setRowCount(p.getLimitStanowisk());
                //model.addRow(dane);

            }
            this.TextFieldCena.setText("");
            this.TextFieldMonitor.setText("");
            this.TextFieldProducent.setText("");
            this.TextFieldZasilanie.setText("");
        }
        catch(Exception ex){
            
        }
        
        
        
        
        
    }//GEN-LAST:event_MenuLoadActionPerformed

    private void MenuLoadSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLoadSerActionPerformed
        try{
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
            j.setFileFilter(filter);
            j.showOpenDialog(null);
            this.p = new Pracownia();
            this.p.wczytajSerial(j.getSelectedFile().toString());
            TextFieldLimit.setText(Integer.toString(this.p.getLimitStanowisk()));
            TextFieldLimit.setEnabled(false);
            ButtonLimit.setEnabled(false);
            ButtonDodaj.setEnabled(true);
            ButtonUsun.setEnabled(true);

            model.setRowCount(p.getLimitStanowisk());
            for(int i=0; i<p.getLimitStanowisk(); i++){
                Object[] dane = {i+1, 
                    p.getStanowisko(i).getProducent(),
                    p.getStanowisko(i).getMonitorRozdzielczosc(),
                    p.getStanowisko(i).getZasilanie(),
                    p.getStanowisko(i).getCena()
                }; 
                model.insertRow(i, dane);
                model.setRowCount(p.getLimitStanowisk());
                //model.addRow(dane);

            }
            this.TextFieldCena.setText("");
            this.TextFieldMonitor.setText("");
            this.TextFieldProducent.setText("");
            this.TextFieldZasilanie.setText("");
        }
        catch(Exception ex){
            
        }

    }//GEN-LAST:event_MenuLoadSerActionPerformed

    private void MenuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAboutMouseClicked

        
        if(this.about == null){
            this.about = new FormAbout();
            this.about.setVisible(true);
        }
        else{
            //this.about = null;
            this.about.dispose();
            this.about = new FormAbout();
            this.about.setVisible(true);
        }
    }//GEN-LAST:event_MenuAboutMouseClicked

    private void MenuSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSaveActionPerformed
        //this.p.zapisz(plik);
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        j.setFileFilter(filter);
        j.showSaveDialog(null);

        try {
            String nazwa = "";
            for(int i = j.getSelectedFile().toString().length()-4; i<j.getSelectedFile().toString().length(); i++)
            {
                nazwa += j.getSelectedFile().toString().charAt(i);
            }
            if(nazwa.equalsIgnoreCase(".txt")){
                this.p.zapisz(j.getSelectedFile().toString());
            }
            else{
                this.p.zapisz(j.getSelectedFile().toString()+".txt");
            }
            
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            
        }
  
    }//GEN-LAST:event_MenuSaveActionPerformed

    private void MenuSaveSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSaveSerActionPerformed
        //this.p.zapiszSerial(plik);
        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        j.setFileFilter(filter);
        j.showSaveDialog(null);

        
        try {
        String nazwa = "";
        for(int i = j.getSelectedFile().toString().length()-4; i<j.getSelectedFile().toString().length(); i++)
        {
            nazwa += j.getSelectedFile().toString().charAt(i);
        }
        if(nazwa.equalsIgnoreCase(".txt")){
            this.p.zapiszSerial(j.getSelectedFile().toString());
        }
        else{
            this.p.zapiszSerial(j.getSelectedFile().toString()+".txt");
        }

        } catch (Exception ex) {
            //Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MenuSaveSerActionPerformed

    private void ButtonLimitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonLimitMouseClicked
        if(isInteger(TextFieldLimit.getText()) && Integer.parseInt(TextFieldLimit.getText())>0){

            this.p = new Pracownia(Integer.parseInt(TextFieldLimit.getText()));
            TextFieldLimit.setEnabled(false);
            ButtonLimit.setEnabled(false);
            
            ButtonDodaj.setEnabled(true);
            ButtonUsun.setEnabled(true);
            //model.setRowCount(p.getLimitStanowisk());
            for(int i=0; i<p.getLimitStanowisk(); i++){
                Object[] dane = {i+1, 
                    p.getStanowisko(i).getProducent(),
                    p.getStanowisko(i).getMonitorRozdzielczosc(),
                    p.getStanowisko(i).getZasilanie(),
                    p.getStanowisko(i).getCena()
                }; 
                model.insertRow(i, dane);
                model.setRowCount(p.getLimitStanowisk());
                //model.addRow(dane);
            
            }
            this.TextFieldCena.setEnabled(true);
            this.TextFieldZasilanie.setEnabled(true);
            this.TextFieldProducent.setEnabled(true);
            this.TextFieldMonitor.setEnabled(true);
            this.ButtonRefresh.setEnabled(true);
        }
        else{
            
        }
    }//GEN-LAST:event_ButtonLimitMouseClicked

    private void MenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuNewActionPerformed
        this.p = new Pracownia();
        TextFieldLimit.setEnabled(true);
        ButtonLimit.setEnabled(true);
        ButtonDodaj.setEnabled(false);
        ButtonUsun.setEnabled(false);
        TextFieldLimit.setText(Integer.toString(this.p.getLimitStanowisk())); 
        this.TextFieldCena.setEnabled(false);
        this.TextFieldZasilanie.setEnabled(false);
        this.TextFieldProducent.setEnabled(false);
        this.TextFieldMonitor.setEnabled(false);
        this.ButtonRefresh.setEnabled(false);
        model.setRowCount(0);
    }//GEN-LAST:event_MenuNewActionPerformed

    private void ButtonDodajMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDodajMouseClicked
        //p.dodajStanowisko(new Desktop(1000, 2000, new Monitor(1920),"Dell"));
        String producent = "null";
        Monitor monitor = new Monitor();
        float zasilanie = 0;
        double cena = 0;
        boolean correctNumber1, correctNumber2, correctMonitor, correctProducent;
        correctNumber1 = correctNumber2 = correctMonitor = correctProducent = false;
        if(!this.TextFieldProducent.getText().equals("")){
            producent = this.TextFieldProducent.getText();
            correctProducent = true;
            if(isInteger(this.TextFieldMonitor.getText())){
                monitor = new Monitor(Integer.parseInt(this.TextFieldMonitor.getText()));
                correctMonitor = true;
                try{
                    zasilanie = Float.parseFloat(this.TextFieldZasilanie.getText());
                    correctNumber1 = true;
                }
                catch(NumberFormatException ex){
                    correctNumber1 = false;
                }
                
                try{
                    cena = Double.parseDouble(this.TextFieldCena.getText());
                    correctNumber2 = true;
                }
                catch(NumberFormatException ex){
                    correctNumber2 = false;
                }
            }
        }
       
        if(correctMonitor == true && correctNumber1 == true && correctNumber2 == true && correctProducent == true){
            p.dodajStanowisko(new Desktop(zasilanie,cena,monitor,producent));
            for(int i=0; i<p.getLimitStanowisk(); i++){
                Object[] dane = {i+1, 
                    p.getStanowisko(i).getProducent(),
                    p.getStanowisko(i).getMonitorRozdzielczosc(),
                    p.getStanowisko(i).getZasilanie(),
                    p.getStanowisko(i).getCena()
                }; 
                model.insertRow(i, dane);
                model.setRowCount(p.getLimitStanowisk());
            }
        
            this.TextFieldCena.setText("");
            this.TextFieldMonitor.setText("");
            this.TextFieldProducent.setText("");
            this.TextFieldZasilanie.setText("");
            
        }

        
    }//GEN-LAST:event_ButtonDodajMouseClicked

    private void ButtonUsunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonUsunMouseClicked
        try{
            p.usunStanowisko(Tabela.getSelectedRow());

            for(int i=0; i<p.getLimitStanowisk(); i++){
                Object[] dane = {i+1, 
                    p.getStanowisko(i).getProducent(),
                    p.getStanowisko(i).getMonitorRozdzielczosc(),
                    p.getStanowisko(i).getZasilanie(),
                    p.getStanowisko(i).getCena()
                }; 
                model.insertRow(i, dane);
                model.setRowCount(p.getLimitStanowisk());
                //model.addRow(dane);

            }
        }
        catch(Exception ex){
            
        }
        
    }//GEN-LAST:event_ButtonUsunMouseClicked

    private void ButtonRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonRefreshMouseClicked
        for(int i=0; i<p.getLimitStanowisk(); i++){
            Object[] dane = {i+1, 
                p.getStanowisko(i).getProducent(),
                p.getStanowisko(i).getMonitorRozdzielczosc(),
                p.getStanowisko(i).getZasilanie(),
                p.getStanowisko(i).getCena()
            }; 
            model.insertRow(i, dane);
            model.setRowCount(p.getLimitStanowisk());
            //model.addRow(dane);
            
        }
    }//GEN-LAST:event_ButtonRefreshMouseClicked

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
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDodaj;
    private javax.swing.JButton ButtonLimit;
    private javax.swing.JButton ButtonRefresh;
    private javax.swing.JButton ButtonUsun;
    private javax.swing.JMenu MenuAbout;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuLoad;
    private javax.swing.JMenuItem MenuLoadSer;
    private javax.swing.JMenuItem MenuNew;
    private javax.swing.JMenuItem MenuSave;
    private javax.swing.JMenuItem MenuSaveSer;
    private javax.swing.JTable Tabela;
    private javax.swing.JTextField TextFieldCena;
    private javax.swing.JTextField TextFieldLimit;
    private javax.swing.JTextField TextFieldMonitor;
    private javax.swing.JTextField TextFieldProducent;
    private javax.swing.JTextField TextFieldZasilanie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }



}
