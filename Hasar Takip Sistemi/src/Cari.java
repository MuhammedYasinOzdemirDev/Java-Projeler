import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cari implements ActionListener, KeyListener,ICariKontrol {
    private JDialog jframe;
    private VeriTabani veriTabani;
    private String[] iller;
    private String[] cariTipleri;
    private int cariId;
    private String musteriadi;
    private String cariTip;
    private String cariNo;
    private String yetkili;
    private String vade;
    private String vergiNo;
    private String vergiDairesi;
    private String cepTel;
    private String email;
    private String fax;
    private String webSitesi;
    private String il;
    private String ilce;
    private String meslek;
    private String tcno;
    private double indirimOrani;
    private int kontrol;


    public Cari(int cariId, String musteriadi, String cariTip, String cariNo, String yetkili, String vade, String vergiNo, String vergiDairesi, String cepTel, String email, String fax, String webSitesi, String il, String ilce, String meslek, double indirimOrani,String tcno) {
        this.cariId = cariId;
        this.musteriadi = musteriadi;
        this.cariTip = cariTip;
        this.cariNo = cariNo;
        this.yetkili = yetkili;
        this.vade = vade;
        this.vergiNo = vergiNo;
        this.vergiDairesi = vergiDairesi;
        this.cepTel = cepTel;
        this.email = email;
        this.fax = fax;
        this.webSitesi = webSitesi;
        this.il = il;
        this.ilce = ilce;
        this.meslek = meslek;
        this.indirimOrani = indirimOrani;
        this.tcno=tcno;
        veriTabani=new VeriTabani();
        iller=veriTabani.IlCek();
    }

    public Cari() {
        veriTabani=new VeriTabani();
        iller=veriTabani.IlCek();
        kontrol=1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        VeriTabani veriTabani = new VeriTabani();
        HataYakalayici hataYakalayici =new HataYakalayici();
        if (e.getSource() == il_alan) {
            String select = il_alan.getSelectedItem().toString();
            il_alan.setModel(new javax.swing.DefaultComboBoxModel<>(iller));
            il_alan.setSelectedItem(select);
            ilce_alan.setModel(new javax.swing.DefaultComboBoxModel<>(veriTabani.IlceCek((Arrays.asList(iller).indexOf(il_alan.getSelectedItem().toString())) + 1)));
        }
        if (iptal_button == e.getSource()) {
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jframe.dispose();
        } else if (kaydet_button==e.getSource()){
            if (kontrol == 0) {
                Cariler.Guncelle();
                kontrol = 2;
                jframe.setVisible(false);
                CariPanel();
            } else {
                try {
                    if(!CariNoKontrol(cariNo_alan.getText())){
                        hataYakalayici.getMesajlar().add("Cari No Hatali...");
                    }
                    if(!TcKimlikKontrol(TcNo_alan.getText())){
                        hataYakalayici.getMesajlar().add("Tc No Hatali...");
                    }
                    if(!EmailKontrol(email_alan.getText())){
                        hataYakalayici.getMesajlar().add("Email Hatali...");
                    }
                    if(!FaxKontrol(fax_alan.getText())){
                        hataYakalayici.getMesajlar().add("Fax Numarası Hatali...");
                    }
                    if(!TelefonKontrol(cepTel_alan.getText())){
                        hataYakalayici.getMesajlar().add("Cep Telefonu Hatali...");
                    }
                    if(!VergiNumarasiKontrol(vergiNo_alan.getText())){
                        hataYakalayici.getMesajlar().add("Vergi numarası Hatali...");
                    }
                    try{
                        indirimOrani= Double.parseDouble(indirimOrani_alan.getText());}
                    catch (NumberFormatException ex) {
                        hataYakalayici.getMesajlar().add("İndirim Oranı Hatalı ...");
                    }
                    try{
                        int vadee=Integer.parseInt(vadeGunu_alan.getText());
                    }
                    catch (NumberFormatException ex) {
                        hataYakalayici.getMesajlar().add("Vade Günü Hatalı ...");
                    }
                    if(hataYakalayici.getMesajlar().size()>0){
                         throw new HataYakalayici(hataYakalayici.Getir());
                    }
                    if (kontrol == 1) {
                        veriTabani.CariEkle(musteriAdi.getText(),cariTip_alan.getSelectedItem().toString(),cariNo_alan.getText(), HasarTakipSistemi.getYetkili(), vadeGunu_alan.getText(),vergiNo_alan.getText(),vergiDairesi_alan.getText(),cepTel_alan.getText(),email_alan.getText(),fax_alan.getText(),webSitesi_alan.getText(),il_alan.getSelectedItem().toString(),ilce_alan.getSelectedItem().toString(),meslek_alan.getText(),Double.parseDouble(indirimOrani_alan.getText()),TcNo_alan.getText());
                        JOptionPane.showMessageDialog(jframe, "Cari eklendi...");
                        Cariler.Guncelle();
                        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        jframe.dispose();
                    } else {
                        veriTabani.CariDuzenle(cariId,musteriAdi.getText(),cariTip_alan.getSelectedItem().toString(),cariNo_alan.getText(), HasarTakipSistemi.getYetkili(),vadeGunu_alan.getText(),vergiNo_alan.getText(),vergiDairesi_alan.getText(),cepTel_alan.getText(),email_alan.getText(),fax_alan.getText(),webSitesi_alan.getText(),il_alan.getSelectedItem().toString(),ilce_alan.getSelectedItem().toString(),meslek_alan.getText(),Double.parseDouble(indirimOrani_alan.getText()),TcNo_alan.getText());
                        musteriadi=musteriAdi.getText();
                        cariTip=cariTip_alan.getSelectedItem().toString();yetkili= HasarTakipSistemi.getYetkili();
                        vade= vadeGunu_alan.getText();
                        vergiNo=vergiNo_alan.getText();
                        vergiDairesi=vergiDairesi_alan.getText();
                        cepTel=cepTel_alan.getText();
                        email=email_alan.getText();
                        fax=fax_alan.getText();
                        webSitesi=webSitesi_alan.getText();
                        il=il_alan.getSelectedItem().toString();
                        ilce=ilce_alan.getSelectedItem().toString();
                        meslek=meslek_alan.getText();
                        tcno=TcNo_alan.getText();

                        JOptionPane.showMessageDialog(jframe, "Cari Düzenlendi...");
                        Cariler.Guncelle();
                        jframe.setVisible(false);
                        kontrol=0;
                        CariPanel();
                    }
                }
                catch (HataYakalayici x) {
                    JOptionPane.showMessageDialog(jframe, x.getMessage());
                }
                catch (Exception x) {
                    JOptionPane.showMessageDialog(jframe, "Hata");
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if ( vergiNo_alan== e.getSource()) {

            if(VergiNumarasiKontrol(vergiNo_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                vergiNo_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                vergiNo_alan.setBorder(border);
            }
        }
        if ( TcNo_alan== e.getSource()) {

            if(TcKimlikKontrol(TcNo_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                TcNo_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                TcNo_alan.setBorder(border);
            }
        }
        if ( email_alan== e.getSource()) {

            if(EmailKontrol(email_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                email_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                email_alan.setBorder(border);
            }
        }
        if ( cepTel_alan== e.getSource()) {

            if(TelefonKontrol(cepTel_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                cepTel_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                cepTel_alan.setBorder(border);
            }
        }
        if(cariNo_alan==e.getSource()){
            if(CariNoKontrol(cariNo_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                cariNo_alan.setBorder(border);
            }
            else{
                Border border = new LineBorder(Color.red, 2);
                cariNo_alan.setBorder(border);
            }
        }
        if(fax_alan==e.getSource()){
            if(FaxKontrol(fax_alan.getText())){
                Border border = new LineBorder(Color.gray, 1);
                fax_alan.setBorder(border);
            }
            else{
                Border border = new LineBorder(Color.red, 2);
                fax_alan.setBorder(border);
            }
        }
    }

    public void CariBilgileriGoster() {
        kontrol=0;
        CariPanel();

    }

    public void CariEkle() {
        kontrol=1;
        CariPanel();
    }

    public void CariDuzenle(int id){
        cariId=id;
        kontrol=2;
        CariPanel();
    }

    public void Kontrol(){
        if(kontrol==0) {
            baslikLabel.setText("Cari Bilgi Ekranı");
            musteriAdi = new javax.swing.JTextField(musteriadi);
            musteriAdi.setEditable(false);
            cariNo_alan = new javax.swing.JTextField(cariNo);
            cariNo_alan.setEditable(false);
            cariTip_alan = new javax.swing.JComboBox<>(new String[]{cariTip});
            cariTip_alan.setEditable(false);
            vadeGunu_alan = new javax.swing.JTextField(vade);
            vadeGunu_alan.setEditable(false);
            vergiDairesi_alan = new javax.swing.JTextField(vergiDairesi);
            vergiDairesi_alan.setEditable(false);
            email_alan = new javax.swing.JTextField(email);
            email_alan.setEditable(false);
            vergiNo_alan = new javax.swing.JTextField(vergiNo);
            vergiNo_alan.setEditable(false);
            cepTel_alan = new javax.swing.JTextField(cepTel);
            cepTel_alan.setEditable(false);
            TcNo_alan = new javax.swing.JTextField(tcno);
            vergiNo_alan.setEditable(false);
            webSitesi_alan = new javax.swing.JTextField(webSitesi);
            webSitesi_alan.setEditable(false);
            fax_alan = new javax.swing.JTextField(fax);
            fax_alan.setEditable(false);
            meslek_alan = new javax.swing.JTextField(meslek);
            meslek_alan.setEditable(false);
            indirimOrani_alan = new javax.swing.JTextField(String.valueOf(indirimOrani));
            indirimOrani_alan.setEditable(false);
            il_alan = new javax.swing.JComboBox<>(new String[]{il});
            il_alan.setEditable(false);
            ilce_alan = new javax.swing.JComboBox<>(new String[]{ilce});
            ilce_alan.setEditable(false);
            TcNo_alan=new JTextField(tcno);
            TcNo_alan.setEditable(false);
            kaydet_button.setText("Düzenle");
        } else if (kontrol==1) {
            baslikLabel.setText("Cari Ekleme Ekranı");
            musteriAdi = new javax.swing.JTextField();
            cariNo_alan = new javax.swing.JTextField();
            cariTip_alan = new javax.swing.JComboBox<>(cariTipleri);
            vadeGunu_alan = new javax.swing.JTextField();
            vergiDairesi_alan = new javax.swing.JTextField();
            email_alan = new javax.swing.JTextField();
            vergiNo_alan = new javax.swing.JTextField();
            cepTel_alan = new javax.swing.JTextField();
            TcNo_alan = new javax.swing.JTextField();
            webSitesi_alan = new javax.swing.JTextField();
            fax_alan = new javax.swing.JTextField();
            meslek_alan = new javax.swing.JTextField();
            indirimOrani_alan = new javax.swing.JTextField();
            il_alan = new javax.swing.JComboBox<>(iller);
            ilce_alan = new javax.swing.JComboBox<>(veriTabani.IlceCek((Arrays.asList(iller).indexOf(il_alan.getSelectedItem().toString()))+1));
        } else if (kontrol==2) {
            baslikLabel.setText("Cari Düzenleme Ekranı");
            musteriAdi = new javax.swing.JTextField(musteriadi);
            cariNo_alan = new javax.swing.JTextField(cariNo);
            cariTip_alan = new javax.swing.JComboBox<>(cariTipleri);
            cariTip_alan.setSelectedItem(cariTip);
            vadeGunu_alan = new javax.swing.JTextField(vade);
            vergiDairesi_alan = new javax.swing.JTextField(vergiDairesi);
            email_alan = new javax.swing.JTextField(email);
            vergiNo_alan = new javax.swing.JTextField(vergiNo);
            cepTel_alan = new javax.swing.JTextField(cepTel);
            TcNo_alan = new javax.swing.JTextField(tcno);
            webSitesi_alan = new javax.swing.JTextField(webSitesi);
            fax_alan = new javax.swing.JTextField(fax);
            meslek_alan = new javax.swing.JTextField(meslek);
            indirimOrani_alan = new javax.swing.JTextField(String.valueOf(indirimOrani));
            il_alan = new javax.swing.JComboBox<>(iller);
            il_alan.setSelectedItem(il);
            ilce_alan = new javax.swing.JComboBox<>(veriTabani.IlceCek((Arrays.asList(iller).indexOf(il_alan.getSelectedItem().toString()))+1));
            ilce_alan.setSelectedItem(ilce);
        }
        if(kontrol==1 ||kontrol==2){
            musteriAdi.setEditable(true);
            cariTip_alan.setEditable(true);
            cariNo_alan.setEditable(true);
            vadeGunu_alan.setEditable(true);
            vergiDairesi_alan.setEditable(true);
            email_alan.setEditable(true);
            vergiNo_alan.setEditable(true);
            cepTel_alan.setEditable(true);
            vergiNo_alan.setEditable(true);
            meslek_alan.setEditable(true);
            indirimOrani_alan.setEditable(true);
            il_alan.setEditable(true);
            ilce_alan.setEditable(true);
            fax_alan.setEditable(true);
            kaydet_button.setText("Kaydet");
        }
    }

    public boolean EmailKontrol(String email) {
        // e-posta adresinin doğruluğunu test etmek için bir regex oluştur
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean VergiNumarasiKontrol(String taxNumber) {
        // vergi numarasının doğruluğunu test etmek için bir regex oluştur
        String regex = "^[0-9]{11}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(taxNumber);
        return matcher.matches(); // vergi numarasının regex'e uygun olup olmadığını kontrol eder
    }
    public  boolean TcKimlikKontrol(String idNumber) {
        // TC kimlik numarasının doğruluğunu test etmek için bir regex oluştur
        String regex = "^[1-9][0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(idNumber);
        return matcher.matches(); // TC kimlik
    }

    public  boolean TelefonKontrol(String phoneNumber) {
        // cep telefonu numarasının doğruluğunu test etmek için bir regex oluştur
        String regex = "^[0][2-8][0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches(); // cep telefonu numarasının regex'e uygun olup olmadığını kontrol eder
    }

    public  boolean CariNoKontrol(String cariNo) {
        // cari no'nun doğruluğunu test etmek için bir regex oluştur
        String regex = "^[1-9][0-9]{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cariNo);
        return matcher.matches(); // cari no'nun regex'e uygun olup olmadığını kontrol eder
    }

    public  boolean FaxKontrol(String faxNumber) {
        // fax numarasının doğruluğunu test etmek için bir regex oluştur
        String regex = "^[0][0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(faxNumber);
        return matcher.matches(); // fax numarasının regex'e uygun olup olmadığını kontrol eder
    }

    public void CariPanel() {
        jframe=new JDialog();
        veriTabani=new VeriTabani();
        cariTipleri = new String[]{"Müşteri", "Tedarikçi", "Firma", "Kişi", "Kurum", "Özel Sektör", "Kamu Kurumu", "Bireysel Müşteri", "Ticari Müşteri","Diğer"};
        jPanel1 = new javax.swing.JPanel();
        baslikLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        kaydet_button = new javax.swing.JButton();
        iptal_button = new javax.swing.JButton();

        Kontrol();

        jPanel1.setPreferredSize(new java.awt.Dimension(642, 438));

        baslikLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Müşteri Adı / Cari");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cari Tipi");


        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Cari No");


        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Vergi No");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tc Kimlik No");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Cep Telefon");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Vade Günü");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Vergi Dairesi");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Email");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Fax");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Web Sitesi");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("İl");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("İlçe");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("İndirim Oranı");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Meslek");

        il_alan.addActionListener(this);

        iptal_button.setText("İptal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(baslikLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(4, 4, 4)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(il_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cariTip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(vergiNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(30, 30, 30)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addComponent(cariNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(vadeGunu_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(vergiDairesi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(email_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(indirimOrani_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(kaydet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(38, 38, 38)
                                                                                .addComponent(iptal_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(ilce_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(webSitesi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addComponent(musteriAdi)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(4, 4, 4)
                                                        .addComponent(TcNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(4, 4, 4)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(meslek_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                        .addComponent(fax_alan)
                                                                        .addComponent(cepTel_alan, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))))))
                                .addGap(0, 25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(baslikLabel)
                                .addGap(12, 12, 12)

                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(musteriAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cariTip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cariNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(vadeGunu_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(vergiNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(vergiDairesi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TcNo_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10)
                                        .addComponent(email_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cepTel_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(webSitesi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fax_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(il_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ilce_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(meslek_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(indirimOrani_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kaydet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iptal_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jframe.getContentPane());
        jframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kaydet_button.addActionListener(this);
        iptal_button.addActionListener(this);
        vergiNo_alan.addKeyListener(this);
        cariNo_alan.addKeyListener(this);
        TcNo_alan.addKeyListener(this);
        cepTel_alan.addKeyListener(this);
        fax_alan.addKeyListener(this);
        email_alan.addKeyListener(this);
        jframe.setBounds(300,100,650,480);
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    private javax.swing.JLabel baslikLabel;

    private javax.swing.JTextField cariNo_alan;
    private javax.swing.JComboBox<String> cariTip_alan;
    private javax.swing.JTextField cepTel_alan;
    private javax.swing.JTextField email_alan;
    private javax.swing.JTextField fax_alan;
    private javax.swing.JComboBox<String> il_alan;
    private javax.swing.JComboBox<String> ilce_alan;
    private javax.swing.JTextField indirimOrani_alan;
    private javax.swing.JButton iptal_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kaydet_button;
    private javax.swing.JTextField meslek_alan;
    private javax.swing.JTextField musteriAdi;
    private javax.swing.JTextField vadeGunu_alan;
    private javax.swing.JTextField vergiDairesi_alan;
    private javax.swing.JTextField TcNo_alan;
    private javax.swing.JTextField vergiNo_alan;
    private javax.swing.JTextField webSitesi_alan;

    public int getCariId() {
        return cariId;
    }

    public String getMusteriadi() {
        return musteriadi;
    }

    public String getCariTip() {
        return cariTip;
    }

    public String getCariNo() {
        return cariNo;
    }

    public String getYetkili() {
        return yetkili;
    }

    public String getVade() {
        return vade;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public String getVergiDairesi() {
        return vergiDairesi;
    }

    public String getCepTel() {
        return cepTel;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getWebSitesi() {
        return webSitesi;
    }

    public String getIl() {
        return il;
    }

    public String getIlce() {
        return ilce;
    }

    public String getMeslek() {
        return meslek;
    }

    public double getIndirimOrani() {
        return indirimOrani;
    }

    public void setCariId(int cariId) {
        this.cariId = cariId;
    }
}
