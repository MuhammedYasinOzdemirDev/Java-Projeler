import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IsEmri implements ActionListener, KeyListener, IIsEmriKontrol {
    private JFrame jframe;
    private VeriTabani veriTabani;
    private static Cari cari=null;
    private static Arac arac=null;
    private int kontrol;
    private int isEmriId;
    private static int aracId;
    private static int cariId;
    private String isemriNO;
    private String aracTeslimEden;
    private String aracTeslimAlan;
    private double girisKm;
    private String takipDurum;
    private String sorumluPersonel;
    private String tarih;
    private String saat;
    private String aracSikayet;
    private String[] personeller;




    @Override
    public void actionPerformed(ActionEvent e) {
        if(aracSec_button==e.getSource()){
            IsEmriIslemler.AracSecFrame();
        }
        if(cariSec_button==e.getSource()){
            IsEmriIslemler.CariSecFrame();
        }
        if(aracDuzenle_button==e.getSource()){
            HataYakalayici hataYakalayici =new HataYakalayici();
            if(arac.getArac_no()==0){
                try {
                    throw new HataYakalayici("Lütfen Araç Şeçiniz");
                } catch (HataYakalayici ex) {
                    JOptionPane.showMessageDialog(jframe,ex.getMessage());
                }
            }
            else{
                arac.AracDuzenle(arac.getArac_no());
                setMarka_alan(arac.getMarka());
                setModel_alan(arac.getModel());
                setPlaka_alan(arac.getPlaka());
                setRuhsatSahibi_alan(arac.getRuhsat_sahibi());
                setModelYil_alan(String.valueOf(arac.getYil()));
            }
        }
        if(cariDuzenle_button==e.getSource()){
            HataYakalayici hataYakalayici =new HataYakalayici();
            if(cari.getCariId()==0){
                try {
                    throw new HataYakalayici("Lütfen Cari Şeçiniz");
                } catch (HataYakalayici ex) {
                    JOptionPane.showMessageDialog(jframe,ex.getMessage());
                }
            }
            else{
                cari.CariDuzenle(cari.getCariId());
                setCariAd_alan(cari.getMusteriadi());
                setCariNo_alan(cari.getCariNo());
                setCariTip_alan(cari.getCariTip());
                setCepTel_alan(cari.getCepTel());
                setYetkili_alan(cari.getYetkili());
            }
        }
        if (iptal_button == e.getSource()) {
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jframe.dispose();
        }
        if(emirOlustur_button==e.getSource()){
            if(kontrol==0){
            IsEmriIslemler.Guncelle();
            kontrol=2;
            jframe.setVisible(false);
            IsEmriPanel();
            }
            else {
                try{
                VeriTabani veriTabani = new VeriTabani();
                HataYakalayici hataYakalayici = new HataYakalayici();
                if(aracTeslimAlan_alan.getText().trim().equals("") || aracTeslimEden_alan.getText().trim().equals("") ||girissKm_alan.getText().trim().equals("")|| takipDurum_combo.getSelectedItem().toString().trim().equals("")|| sorumluPersonel_combo.getSelectedItem().toString().trim().equals("") || aracTeslimAlan_alan.getText().trim().equals("")){
                    hataYakalayici.getMesajlar().add("Boş Eleman Bırakılamaz...");
                }
                try{
                    girisKm= Double.parseDouble(girissKm_alan.getText());}
                catch (NumberFormatException ex) {
                    hataYakalayici.getMesajlar().add("Lütfen Km'yi Sayı Olarak Giriniz ...");
                }

                if(aracId==0){
                    hataYakalayici.getMesajlar().add("Lütfen Araç Seçiniz ...");
                 }
                if(cariId==0){
                    hataYakalayici.getMesajlar().add("Cari Seçiniz...");
                }
                    if(hataYakalayici.getMesajlar().size()>0){
                        throw new HataYakalayici(hataYakalayici.Getir());
                    }
                if(kontrol==1){
                    veriTabani.IsEmriEkle(arac.getArac_no(),cari.getCariId(),isEmriNo_alan.getText(),aracTeslimEden_alan.getText(),aracTeslimAlan_alan.getText(), Double.parseDouble(girissKm_alan.getText()),takipDurum_combo.getSelectedItem().toString(),sorumluPersonel_combo.getSelectedItem().toString(),tarih_alan.getText(),saat_alan.getText(),aracSikayet_area.getText());
                    JOptionPane.showMessageDialog(jframe, "İş Emri eklendi...");
                    IsEmriIslemler.Guncelle();
                    jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jframe.dispose();
                } else if (kontrol==2) {
                    veriTabani.IsEmriDuzenle(isEmriId,arac.getArac_no(),cari.getCariId(),isEmriNo_alan.getText(),aracTeslimEden_alan.getText(),aracTeslimAlan_alan.getText(), Double.parseDouble(girissKm_alan.getText()),takipDurum_combo.getSelectedItem().toString(),sorumluPersonel_combo.getSelectedItem().toString(),tarih_alan.getText(),saat_alan.getText(),aracSikayet_area.getText());
                    IsEmriIslemler.Guncelle();
                    JOptionPane.showMessageDialog(jframe, "İş Emri Düzenlendi...");
                    jframe.setVisible(false);
                }
                }
                catch (HataYakalayici ex){
                    JOptionPane.showMessageDialog(jframe, ex.getMessage());
                }
            }

        }
    }

    @Override
    public boolean TarihKontrol(String tarih) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(tarih);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean SaatKontrol(String saat) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);
        try {
            Date time = timeFormat.parse(saat);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean KmKontrol(String km) {
        try{
            Double.parseDouble(km);
            return true;
        }
        catch (Exception e)
        {
            return false;
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
        if(girissKm_alan==e.getSource()){
            if(KmKontrol((girissKm_alan.getText()))){
                Border border = new LineBorder(Color.gray, 1);
                girissKm_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                girissKm_alan.setBorder(border);
            }
        }
        if(tarih_alan==e.getSource()){
            if(TarihKontrol((tarih_alan.getText()))){
                Border border = new LineBorder(Color.gray, 1);
                tarih_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                tarih_alan.setBorder(border);
            }
        }
        if(saat_alan==e.getSource()){
            if(SaatKontrol((saat_alan.getText()))){
                Border border = new LineBorder(Color.gray, 1);
                saat_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                saat_alan.setBorder(border);
            }
        }
    }

    public IsEmri() {
        veriTabani=new VeriTabani();
        kontrol=1;

        personeller=new String[]{"Ahmet","Mehmet"};
    }

    public IsEmri(int isEmriId, int aracId, int cariId, String isemriNO, String aracTeslimEden, String aracTeslimAlan, double girisKm, String takipDurum, String sorumluPersonel, String tarih, String saat, String aracSikayet) {
        this.isEmriId = isEmriId;
        this.aracId = aracId;
        this.cariId = cariId;
        this.isemriNO = isemriNO;
        this.aracTeslimEden = aracTeslimEden;
        this.aracTeslimAlan = aracTeslimAlan;
        this.girisKm = girisKm;
        this.takipDurum = takipDurum;
        this.sorumluPersonel = sorumluPersonel;
        this.tarih = tarih;
        this.saat = saat;
        this.aracSikayet = aracSikayet;
    }
    public void Duzenle(int id){
        isEmriId=id;
        kontrol=2;
        IsEmriPanel();
    }
    public void Ekle(){
        kontrol=1;
        IsEmriPanel();
    }
    public void Kontrol(){

        if(kontrol==0) {
            jLabel16.setText("İş Emri Bilgileri");
            aracTeslimEden_alan = new javax.swing.JTextField(aracTeslimEden);
            aracTeslimEden_alan.setEditable(false);
            aracTeslimAlan_alan = new javax.swing.JTextField(aracTeslimAlan);
            aracTeslimAlan_alan.setEditable(false);
            girissKm_alan = new javax.swing.JTextField(String.valueOf(girisKm));
            girissKm_alan.setEditable(false);
            aracSikayet_area = new javax.swing.JTextArea(aracSikayet);
            aracSikayet_area.setEditable(false);
            saat_alan = new javax.swing.JTextField(saat);
            saat_alan.setEditable(false);
            tarih_alan = new javax.swing.JTextField(tarih);
            tarih_alan.setEditable(false);
            takipDurum_combo = new javax.swing.JComboBox<>(new String[]{takipDurum});
            takipDurum_combo.setEditable(false);
            sorumluPersonel_combo = new javax.swing.JComboBox<>(new String[]{sorumluPersonel});
            sorumluPersonel_combo.setEditable(false);
            isEmriNo_alan = new javax.swing.JTextField(isemriNO);
            emirOlustur_button.setText("İş Emri Düzenle");
        }
        else if (kontrol==1){
            IsEmriIslemler isEmriIslemler=new IsEmriIslemler();
            jLabel16.setText("İş Emri Kayıt");
            aracTeslimEden_alan = new javax.swing.JTextField();
            aracTeslimAlan_alan = new javax.swing.JTextField();
            girissKm_alan = new javax.swing.JTextField();
            aracSikayet_area = new javax.swing.JTextArea();
            saat_alan = new javax.swing.JTextField();
            tarih_alan = new javax.swing.JTextField();
            takipDurum_combo = new javax.swing.JComboBox<>(takipDurumlari);
            sorumluPersonel_combo = new javax.swing.JComboBox<>(personeller);
            isEmriNo_alan = new javax.swing.JTextField(isEmriIslemler.IsEmriNoAta());
            emirOlustur_button.setText("İş Emri Oluştur");

        }
        else if (kontrol==2){
            jLabel16.setText("İş Emri Düzenleme ");
            VeriTabani veriTabani=new VeriTabani();
            arac=veriTabani.AracCek(aracId);
            cari=veriTabani.CariCek(cariId);
            IsEmri.setMarka_alan(arac.getMarka());
            IsEmri.setModel_alan(arac.getModel());
            IsEmri.setPlaka_alan(arac.getPlaka());
            IsEmri.setRuhsatSahibi_alan(arac.getRuhsat_sahibi());
            IsEmri.setModelYil_alan(String.valueOf(arac.getYil()));
            IsEmri.setCariAd_alan(cari.getMusteriadi());
            IsEmri.setCariNo_alan(cari.getCariNo());
            IsEmri.setCariTip_alan(cari.getCariTip());
            IsEmri.setCepTel_alan(cari.getCepTel());
            IsEmri.setYetkili_alan(cari.getYetkili());
            aracTeslimEden_alan = new javax.swing.JTextField(aracTeslimEden);
            aracTeslimAlan_alan = new javax.swing.JTextField(aracTeslimAlan);
            girissKm_alan = new javax.swing.JTextField(String.valueOf(girisKm));
            aracSikayet_area = new javax.swing.JTextArea(aracSikayet);
            saat_alan = new javax.swing.JTextField(saat);
            tarih_alan = new javax.swing.JTextField(tarih);
            takipDurum_combo = new javax.swing.JComboBox<>(takipDurumlari);
            takipDurum_combo.setSelectedItem(takipDurum);
            sorumluPersonel_combo = new javax.swing.JComboBox<>(personeller);
            sorumluPersonel_combo.setSelectedItem(sorumluPersonel);
            isEmriNo_alan = new javax.swing.JTextField(isemriNO);
            emirOlustur_button.setText("İş Emri Kaydet");

        }
        if(kontrol==1 ||kontrol==2){
            aracTeslimEden_alan.setEditable(true);
            aracTeslimAlan_alan.setEditable(true);
            girissKm_alan.setEditable(true);
            aracSikayet_area.setEditable(true);
            saat_alan.setEditable(true);
            tarih_alan.setEditable(true);
            takipDurum_combo.setEditable(true);
            takipDurum_combo.setEditable(true);
            sorumluPersonel_combo.setEditable(true);
        }

        isEmriNo_alan.setEditable(false);
    }
    public void IsEmriPanel(){
        personeller=new String[]{"Ahmet","Mehmet"};
        jframe=new JFrame();
        buttonGroup1 = new ButtonGroup();
        jPanel2 = new JPanel();
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jPanel3 = new JPanel();
        jLabel5 = new JLabel();
        marka_alan = new JTextField();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        model_alan = new JTextField();
        plaka_alan = new JTextField();
        modelYil_alan = new JTextField();
        ruhsatSahibi_alan = new JTextField();
        aracDuzenle_button = new JButton();
        aracSec_button = new JButton();
        jPanel6 = new JPanel();
        jPanel7 = new JPanel();
        jLabel3 = new JLabel();
        jPanel8 = new JPanel();
        jLabel6 = new JLabel();
        cariAd_alan = new JTextField();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        cariTip_alan = new JTextField();
        cariNo_alan = new JTextField();
        cepTel_alan = new JTextField();
        yetkili_alan = new JTextField();
        cariDuzenle_button = new JButton();
        cariSec_button = new JButton();
        jPanel10 = new JPanel();
        jPanel9 = new JPanel();
        jLabel16 = new JLabel();
        jPanel11 = new JPanel();
        jLabel18 = new JLabel();

        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();

        jLabel23 = new JLabel();
        jScrollPane1 = new JScrollPane();

        jLabel24 = new JLabel();
        jLabel25 = new JLabel();

        iptal_button = new JButton();
        emirOlustur_button = new JButton();
        arac=new Arac();
        arac.setArac_no(0);
        cari=new Cari();
        cari.setCariId(0);

         Kontrol();


        jPanel2.setBackground(new Color(0, 153, 153));
        jPanel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel2.setPreferredSize(new Dimension(320, 300));

        jPanel1.setBackground(new Color(255, 255, 255));

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Araç Bilgileri");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new Color(204, 255, 102));
        jPanel3.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jLabel5.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel5.setText("Marka");
        jLabel5.setAutoscrolls(true);

        marka_alan.setEditable(false);
        jLabel8.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel8.setText("Model");
        jLabel8.setAutoscrolls(true);

        jLabel9.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel9.setText("Plaka No");
        jLabel9.setAutoscrolls(true);

        jLabel10.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel10.setText("Ruhsat Sahibi");
        jLabel10.setAutoscrolls(true);

        jLabel11.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel11.setText("Model Yılı");
        jLabel11.setAutoscrolls(true);

        model_alan.setEditable(false);


        plaka_alan.setEditable(false);


        modelYil_alan.setEditable(false);


        ruhsatSahibi_alan.setEditable(false);


        aracDuzenle_button.setText("Düzenle");

        aracSec_button.setText("Araç Seç");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(marka_alan))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel9, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(plaka_alan))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(model_alan))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ruhsatSahibi_alan))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel11, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(modelYil_alan))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(aracDuzenle_button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                                .addComponent(aracSec_button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(marka_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(model_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(plaka_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(ruhsatSahibi_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(modelYil_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(aracSec_button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(aracDuzenle_button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new Color(0, 153, 153));
        jPanel6.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel6.setPreferredSize(new Dimension(320, 300));

        jPanel7.setBackground(new Color(255, 255, 255));

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Cari Bilgileri");

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new Color(255, 204, 0));
        jPanel8.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jLabel6.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel6.setText("Cari Adı");
        jLabel6.setAutoscrolls(true);

        cariAd_alan.setEditable(false);


        jLabel12.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel12.setText("Cari Tipi");
        jLabel12.setAutoscrolls(true);

        jLabel13.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel13.setText("Cari No");
        jLabel13.setAutoscrolls(true);

        jLabel14.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel14.setText("Yetkili");
        jLabel14.setAutoscrolls(true);

        jLabel15.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel15.setText("Cep Telefonu");
        jLabel15.setAutoscrolls(true);

        cariTip_alan.setEditable(false);

        cariNo_alan.setEditable(false);


        cepTel_alan.setEditable(false);


        yetkili_alan.setEditable(false);

        cariDuzenle_button.setText("Düzenle");

        cariSec_button.setText("Cari Seç");

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cariAd_alan))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel13, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cariNo_alan))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel12, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cariTip_alan))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(yetkili_alan))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel15, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cepTel_alan))
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(cariDuzenle_button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                                .addComponent(cariSec_button, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)))
                                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(cariAd_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(cariTip_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(cariNo_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel14)
                                        .addComponent(yetkili_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel15)
                                        .addComponent(cepTel_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cariSec_button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cariDuzenle_button, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new Color(0, 153, 153));
        jPanel10.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        jPanel10.setPreferredSize(new Dimension(621, 700));

        jPanel9.setBackground(new Color(255, 255, 255));

        jLabel16.setBackground(new Color(255, 255, 255));
        jLabel16.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(SwingConstants.CENTER);


        GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new Color(0, 204, 153));
        jPanel11.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

        jLabel18.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel18.setText("İş Emri No");
        jLabel18.setAutoscrolls(true);

        isEmriNo_alan.setBackground(new Color(255, 51, 51));


        jLabel19.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel19.setText("Aracı Teslim Eden");
        jLabel19.setAutoscrolls(true);

        jLabel20.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel20.setText("Aracı Teslim Alan");
        jLabel20.setAutoscrolls(true);

        jLabel21.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel21.setText("Servise Giriş Km");
        jLabel21.setAutoscrolls(true);

        jLabel22.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel22.setText("Sorumlu Personel");
        jLabel22.setAutoscrolls(true);



        jLabel23.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel23.setText("Takip Durum");
        jLabel23.setAutoscrolls(true);

        aracSikayet_area.setColumns(20);
        aracSikayet_area.setRows(5);
        aracSikayet_area.setPreferredSize(new Dimension(200, 84));
        jScrollPane1.setViewportView(aracSikayet_area);

        jLabel24.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel24.setText("Araç Şikayet");
        jLabel24.setAutoscrolls(true);

        jLabel25.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(SwingConstants.RIGHT);
        jLabel25.setText("Kabul Tarihi / Saat");
        jLabel25.setAutoscrolls(true);





        iptal_button.setText("İptal");



        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel20, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel18, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel19, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                                        .addComponent(jLabel21, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(aracTeslimAlan_alan, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                                .addComponent(aracTeslimEden_alan, GroupLayout.Alignment.LEADING)
                                                                                .addComponent(isEmriNo_alan, GroupLayout.Alignment.LEADING))
                                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                                .addComponent(girissKm_alan, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(takipDurum_combo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                        .addComponent(jLabel22, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(sorumluPersonel_combo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel25, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel24, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                                        .addComponent(tarih_alan, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(saat_alan, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))))))
                                .addGap(135, 135, 135))
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iptal_button, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(emirOlustur_button, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel18)
                                        .addComponent(isEmriNo_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel19)
                                        .addComponent(aracTeslimEden_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel20)
                                        .addComponent(aracTeslimAlan_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21)
                                        .addComponent(girissKm_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23)
                                        .addComponent(takipDurum_combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(sorumluPersonel_combo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(saat_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel25)
                                        .addComponent(tarih_alan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(emirOlustur_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iptal_button, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
        );

        GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(jframe.getContentPane());
        jframe.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, 631, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(12, Short.MAX_VALUE))
        );



        emirOlustur_button.addActionListener(this);
        iptal_button.addActionListener(this);
        aracSec_button.addActionListener(this);
        aracDuzenle_button.addActionListener(this);
        cariSec_button.addActionListener(this);
        cariDuzenle_button.addActionListener(this);
        tarih_alan.addKeyListener(this);
        plaka_alan.addKeyListener(this);
        saat_alan.addKeyListener(this);
        jframe.setLocation(240,18);
        jframe.pack();
        jframe.setResizable(false);
        jframe.setVisible(true);

    }
    private javax.swing.JButton aracDuzenle_button;
    private javax.swing.JButton aracSec_button;
    private javax.swing.JTextArea aracSikayet_area;
    private javax.swing.JTextField aracTeslimAlan_alan;
    private javax.swing.JTextField aracTeslimEden_alan;
    private javax.swing.ButtonGroup buttonGroup1;
    private static javax.swing.JTextField cariAd_alan;
    private javax.swing.JButton cariDuzenle_button;
    private static javax.swing.JTextField cariNo_alan;
    private javax.swing.JButton cariSec_button;
    private static javax.swing.JTextField cariTip_alan;
    private static javax.swing.JTextField cepTel_alan;
    private javax.swing.JButton emirOlustur_button;
    private javax.swing.JTextField girissKm_alan;
    private javax.swing.JButton iptal_button;
    private javax.swing.JTextField isEmriNo_alan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextField plaka_alan;
    private static JTextField marka_alan;
    private  static javax.swing.JTextField modelYil_alan;
    private static javax.swing.JTextField model_alan;
    private static javax.swing.JTextField ruhsatSahibi_alan;
    private javax.swing.JTextField saat_alan;
    private javax.swing.JComboBox<String> sorumluPersonel_combo;
    private javax.swing.JComboBox<String> takipDurum_combo;
    private javax.swing.JTextField tarih_alan;
    private static javax.swing.JTextField yetkili_alan;

    public static void setArac(Arac arac) {
        IsEmri.arac = arac;
    }

    public static void setPlaka_alan(String plaka_alan) {
        IsEmri.plaka_alan .setText(plaka_alan);
    }

    public static void setMarka_alan(String marka_alan) {
        IsEmri.marka_alan.setText( marka_alan);
    }

    public static void setModelYil_alan(String modelYil_alan) {
        IsEmri.modelYil_alan .setText(modelYil_alan);
    }

    public static void setModel_alan(String model_alan) {
        IsEmri.model_alan.setText( model_alan);
    }

    public static void setRuhsatSahibi_alan(String ruhsatSahibi_alan) {
        IsEmri.ruhsatSahibi_alan .setText( ruhsatSahibi_alan);
    }

    public static void setCari(Cari cari) {
        IsEmri.cari = cari;
    }

    public static void setCariAd_alan(String  cariAd_alan) {
        IsEmri.cariAd_alan .setText( cariAd_alan);
    }

    public static void setCariTip_alan(String cariTip_alan) {
        IsEmri.cariTip_alan .setText(cariTip_alan);
    }

    public static void setCepTel_alan(String cepTel_alan) {
        IsEmri.cepTel_alan.setText(cepTel_alan);
    }

    public static void setYetkili_alan(String yetkili_alan) {
        IsEmri.yetkili_alan .setText(yetkili_alan);
    }

    public static void setCariNo_alan(String cariNo_alan) {
        IsEmri.cariNo_alan .setText(cariNo_alan);
    }

    public int getIsEmriId() {
        return isEmriId;
    }

    public static Cari getCari() {
        return cari;
    }

    public static Arac getArac() {
        return arac;
    }

    public int getKontrol() {
        return kontrol;
    }

    public  int getAracId() {
        return aracId;
    }

    public static int getCariId() {
        return cariId;
    }

    public String getIsemriNO() {
        return isemriNO;
    }

    public String getAracTeslimEden() {
        return aracTeslimEden;
    }

    public String getAracTeslimAlan() {
        return aracTeslimAlan;
    }

    public double getGirisKm() {
        return girisKm;
    }

    public String getTakipDurum() {
        return takipDurum;
    }

    public String getSorumluPersonel() {
        return sorumluPersonel;
    }

    public String getTarih() {
        return tarih;
    }

    public String getSaat() {
        return saat;
    }

    public String getAracSikayet() {
        return aracSikayet;
    }

    public  static void setCariId(int cariId) {
        IsEmri.cariId = cariId;
    }

    public  static void setAracId(int aracId) {
        IsEmri.aracId = aracId;
    }

    public void setTakipDurum(String takipDurum) {
        this.takipDurum = takipDurum;
    }
}
