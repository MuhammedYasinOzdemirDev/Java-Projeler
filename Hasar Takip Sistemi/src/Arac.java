import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

public  class Arac implements ActionListener, KeyListener,IAracKontrol {
    private javax.swing.JComboBox<String> arac_tip_alan;
    private javax.swing.JLabel baslik;
    private javax.swing.JButton iptal;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField model_alan;
    private javax.swing.JComboBox<String> kasa_tip_alan;
    private javax.swing.JButton kaydet;
    private javax.swing.JTextField marka_alan;
    private javax.swing.JTextField motor_guc_alan;
    private javax.swing.JTextField motor_hacim_alan;
    private javax.swing.JTextField motor_no_alan;
    private javax.swing.JTextField plaka_alan;
    private javax.swing.JTextField renk_alan;
    private javax.swing.JTextField ruhsat_sahibi_alan;
    private javax.swing.JComboBox<String> sanziman_alan;
    private javax.swing.JTextField sasi_no_alan;
    private javax.swing.JComboBox<String > yakit_alan;
    private javax.swing.JComboBox<Integer> yil_alan;
    private String plaka;
    private String marka;
    private String model;
    private int yil;
    private String motorno;
    private String sasino;
    private String ruhsat_sahibi;
    private String arac_tip;
    private String kasa_tip;
    private String sanziman;
    private String renk;
    private double motor_hacim;
    private double motor_guc;
    private String yakit;
    private int arac_no;
    private String[] arac_tipleri;
    private String[] kasa_tipleri;
    private String[] sanziman_turleri;
    private String[] yakit_turleri;
    private Integer[] yillar;
    private JDialog jFrame;
    private int kontrol;

    public Arac(int arac_no,String plaka, String marka, String model, int yil, String motorno, String sasino, String ruhsat_sahibi, String arac_tip, String kasa_tip, String sanziman, String renk, double motor_hacim, double motor_guc, String yakit) {
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.motorno = motorno;
        this.sasino = sasino;
        this.ruhsat_sahibi = ruhsat_sahibi;
        this.arac_tip = arac_tip;
        this.kasa_tip = kasa_tip;
        this.sanziman = sanziman;
        this.renk = renk;
        this.motor_hacim = motor_hacim;
        this.motor_guc = motor_guc;
        this.yakit = yakit;
        this.arac_no=arac_no;
    }

    public Arac() {
    }

    public int getArac_no() {
        return arac_no;
    }

    public void aracPanel() {
        arac_tipleri=new String[]{"Otomobil","Ticari Araç","Motosiklet","Arazi Aracı","Traktör","Diğer"};
        kasa_tipleri=new String[]{"Hatchback","Sedan","Station Wagon","Minivan","Cabrio","Coupe","SUV","Jeep","Cross","Pick Up","Kamyon","Kamyonet","Traktör","Minubüs","MPV","MINIVAN","Panelvan","Atv","MotorBisiklet","Scooter","Diğer"};
        sanziman_turleri=new String[]{"Manuel Şanzıman","Otomatik Şanzıman","Yarı Otomatik Şanzıman","Diğer"};
        yakit_turleri=new String[]{"Dizel","Benzinli","LPG","Elektirikli","Hybrid","Benzinli/LPG","Diger"};
        int yil=Calendar.getInstance().get(Calendar.YEAR);
        yillar= new Integer[yil - 1969];
        for(int i=yil;i>=1970;i--)
            yillar[yil-i]=i;
        jFrame = new JDialog();
        jPanel1 = new javax.swing.JPanel();
        baslik = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel("Plaka");

        jLabel3 = new javax.swing.JLabel("Marka");

        jLabel4 = new javax.swing.JLabel("Model");

        jLabel5 = new javax.swing.JLabel("Model Yılı");

        jLabel6 = new javax.swing.JLabel("Motor No");

        jLabel7 = new javax.swing.JLabel("Şaşi No");

        jLabel8 = new javax.swing.JLabel("Ruhsat Sahibi");

        jLabel9 = new javax.swing.JLabel("Kasa Tip");

        jLabel10 = new javax.swing.JLabel("Şanzıman");

        jLabel11 = new javax.swing.JLabel("Araç Tip");

        jLabel12 = new javax.swing.JLabel("Renk");

        jLabel13 = new javax.swing.JLabel("Motor Güç");

        jLabel14 = new javax.swing.JLabel("Motor Hacim");

        jLabel15 = new javax.swing.JLabel("Yakıt");

        kaydet = new javax.swing.JButton();
        iptal = new javax.swing.JButton("İptal");

        Kontrol();

        kaydet.addActionListener(this);
        iptal.addActionListener(this);

        baslik.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N


        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(baslik))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(sasi_no_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(marka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(plaka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(model_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(yil_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                        .addComponent(motor_no_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(arac_tip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(kasa_tip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(sanziman_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(renk_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(motor_guc_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(motor_hacim_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(ruhsat_sahibi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(24, 24, 24)
                                                                                .addComponent(iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(yakit_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(baslik)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(plaka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11)
                                        .addComponent(arac_tip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(marka_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(model_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel9)
                                                        .addComponent(kasa_tip_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel10)
                                                        .addComponent(sanziman_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(yil_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(renk_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(motor_no_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(motor_guc_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(sasi_no_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(motor_hacim_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(ruhsat_sahibi_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15)
                                        .addComponent(yakit_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iptal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        motor_hacim_alan.addKeyListener(this);
        motor_guc_alan.addKeyListener(this);
        plaka_alan.addKeyListener(this);
        motor_no_alan.addKeyListener(this);
        sasi_no_alan.addKeyListener(this);

        jFrame.setBounds(200,50,800,420);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    public void AracBilgileriGoster(int id) {
        arac_no=id;
        kontrol=0;
        aracPanel();

    }

    public void AracEkle() {
        kontrol=1;
        aracPanel();
    }
    public void AracDuzenle(int id){
        arac_no=id;
        kontrol=2;
        aracPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        HataYakalayici hataYakalayici =new HataYakalayici();
        if(iptal==e.getSource()){
            jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jFrame.dispose();
        }
        else if (kaydet==e.getSource()) {
            if (kontrol == 0) {
                Araclar.Guncelle();
                kontrol = 2;
                jFrame.setVisible(false);
                aracPanel();
            } else {
                VeriTabani veriTabani = new VeriTabani();
                try {
                    if(!PlakaKontrol(plaka_alan.getText())){
                        hataYakalayici.getMesajlar().add("Plaka No Hatali...");
                    }
                    if(!MotorNoKontrol(motor_no_alan.getText())){
                        hataYakalayici.getMesajlar().add("Motor No Hatali...");
                    }
                    if(!SasiKontrol(sasi_no_alan.getText())){
                        hataYakalayici.getMesajlar().add("Şaşi No  Hatali...");
                    }
                    if(!MotorHacmiKontrol(motor_hacim_alan.getText())){
                        hataYakalayici.getMesajlar().add("Motor Hacmi  Hatali...");
                    }
                    if(!MotorGucuKonrol(motor_guc_alan.getText())){
                        hataYakalayici.getMesajlar().add("Motor Gücü  Hatali...");
                    }
                    if(hataYakalayici.getMesajlar().size()>0){
                        throw new HataYakalayici(hataYakalayici.Getir());
                    }
                    if(kontrol==1){
                        veriTabani.AracEkle(plaka_alan.getText(),marka_alan.getText(), model_alan.getText(), Integer.parseInt(yil_alan.getSelectedItem().toString()), motor_no_alan.getText(), sasi_no_alan.getText(), ruhsat_sahibi_alan.getText(),arac_tip_alan.getSelectedItem().toString(),kasa_tip_alan.getSelectedItem().toString(),sanziman_alan.getSelectedItem().toString(),renk_alan.getText() ,Double.parseDouble(motor_guc_alan.getText()), Double.parseDouble(motor_hacim_alan.getText()), yakit_alan.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(jFrame, "Araç eklendi...");

                        Araclar.Guncelle();

                        jFrame.setVisible(false);
                    }
                    else {
                        plaka=plaka_alan.getText();
                        marka=marka_alan.getText();
                        model=model_alan.getText();
                        yil=Integer.parseInt(yil_alan.getSelectedItem().toString());
                        motorno=motor_no_alan.getText();
                        sasino=sasi_no_alan.getText();
                        ruhsat_sahibi=ruhsat_sahibi_alan.getText();
                        arac_tip=arac_tip_alan.getSelectedItem().toString();
                        kasa_tip=kasa_tip_alan.getSelectedItem().toString();
                        sanziman=sanziman_alan.getSelectedItem().toString();
                        motor_guc=Double.parseDouble(motor_guc_alan.getText());
                        motor_hacim=Double.parseDouble(motor_hacim_alan.getText());
                        yakit=yakit_alan.getSelectedItem().toString();
                        veriTabani.AracDuzenle(arac_no,plaka_alan.getText(),marka_alan.getText(), model_alan.getText(), Integer.parseInt(yil_alan.getSelectedItem().toString()), motor_no_alan.getText(), sasi_no_alan.getText(), ruhsat_sahibi_alan.getText(),arac_tip_alan.getSelectedItem().toString(),kasa_tip_alan.getSelectedItem().toString(),sanziman_alan.getSelectedItem().toString(),renk_alan.getText() ,Double.parseDouble(motor_guc_alan.getText()), Double.parseDouble(motor_hacim_alan.getText()), yakit_alan.getSelectedItem().toString());
                        JOptionPane.showMessageDialog(jFrame, "Araç Düzenlendi...");
                        Araclar.Guncelle();
                        jFrame.setVisible(false);
                        kontrol=0;
                        aracPanel();
                    }
                }
                catch (HataYakalayici x) {
                    JOptionPane.showMessageDialog(jFrame, x.getMessage());
                }
                catch (Exception x) {
                    JOptionPane.showMessageDialog(jFrame, "Hata");
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
        if(motor_guc_alan == e.getSource()){
            if(MotorGucuKonrol(motor_guc_alan.getText())) {
                Border border = new LineBorder(Color.gray, 1);
                motor_guc_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                motor_guc_alan.setBorder(border);
            }
        }
        if(motor_hacim_alan == e.getSource()){
            if(MotorHacmiKontrol(motor_hacim_alan.getText())){
                Border border=new LineBorder(Color.gray,1);
                motor_hacim_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                motor_hacim_alan.setBorder(border);
            }
        }
        if(plaka_alan==e.getSource()){
            if(PlakaKontrol(plaka_alan.getText())){
                Border border=new LineBorder(Color.gray,1);
                plaka_alan.setBorder(border);
            }
            else {
                Border border=new LineBorder(Color.red,2);
                plaka_alan.setBorder(border);
            }
        }
        if(motor_no_alan==e.getSource()) {
            if (MotorNoKontrol(motor_no_alan.getText())) {
                Border border=new LineBorder(Color.gray,1);
                motor_no_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                motor_no_alan.setBorder(border);
            }
        }
        if(sasi_no_alan==e.getSource()) {
            if (SasiKontrol(sasi_no_alan.getText())) {
                Border border=new LineBorder(Color.gray,1);
                sasi_no_alan.setBorder(border);
            }
            else{
                Border border=new LineBorder(Color.red,2);
                sasi_no_alan.setBorder(border);
            }
        }
    }

    @Override
    public boolean PlakaKontrol(String plaka) {
        return plaka.toUpperCase().matches("^(?:[0-9]{2} [A-Z]{2} [0-9]{4}|[A-Z]{2} [0-9]{2} [A-Z]{3}|[0-9]{2} [A-Z]{3} [0-9]{5})$");
    }

    @Override
    public boolean MotorNoKontrol(String motorNo) {
        return motorNo.matches("^[A-Z]{2}[0-9]{6}$");
    }

    @Override
    public boolean SasiKontrol(String sasiNo) {
        return sasiNo.matches("^[A-Z0-9]{17}$");
    }

    @Override
    public boolean MotorHacmiKontrol(String motorHacmi) {
        try{
            Double.parseDouble(motorHacmi);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean MotorGucuKonrol(String motorGucu) {
        try{
            Double.parseDouble(motorGucu);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public void Kontrol(){
        if(kontrol==0){

            baslik.setText("Araç Bilgi Ekranı");

            plaka_alan = new javax.swing.JTextField(plaka);
            plaka_alan.setEditable(false);

            marka_alan = new javax.swing.JTextField(marka);
            marka_alan.setEditable(false);

            model_alan = new javax.swing.JTextField(model);
            model_alan.setEditable(false);

            yil_alan = new javax.swing.JComboBox<Integer>(new Integer[]{yil});
            yil_alan.setEditable(false);


            motor_no_alan = new javax.swing.JTextField(motorno);
            motor_no_alan.setEditable(false);

            sasi_no_alan = new javax.swing.JTextField(sasino);
            sasi_no_alan.setEditable(false);

            ruhsat_sahibi_alan = new javax.swing.JTextField(ruhsat_sahibi);
            ruhsat_sahibi_alan.setEditable(false);

            kasa_tip_alan = new javax.swing.JComboBox<String>(new String[]{kasa_tip});
            kasa_tip_alan.setEditable(false);


            sanziman_alan = new javax.swing.JComboBox<String>(new String[]{sanziman});
            sanziman_alan.setEditable(false);


            arac_tip_alan = new javax.swing.JComboBox<String>(new String[]{arac_tip});
            arac_tip_alan.setEditable(false);

            renk_alan = new javax.swing.JTextField(renk);
            renk_alan.setEditable(false);

            motor_guc_alan = new javax.swing.JTextField(String.valueOf(motor_guc));
            motor_guc_alan.setEditable(false);

            motor_hacim_alan = new javax.swing.JTextField(String.valueOf(motor_hacim));
            motor_hacim_alan.setEditable(false);
            yakit_alan = new javax.swing.JComboBox<String>(new String[]{yakit});
            yakit_alan.setEditable(false);

            kaydet.setText("Düzenle");
        }
        else if (kontrol==1){
            baslik.setText("Araç Ekleme Ekranı");
            plaka_alan = new javax.swing.JTextField();

            marka_alan = new javax.swing.JTextField();

            model_alan = new javax.swing.JTextField();

            yil_alan = new javax.swing.JComboBox<Integer>(yillar);

            motor_no_alan = new javax.swing.JTextField();

            sasi_no_alan = new javax.swing.JTextField();

            ruhsat_sahibi_alan = new javax.swing.JTextField();

            kasa_tip_alan = new javax.swing.JComboBox<String >(kasa_tipleri);

            sanziman_alan = new javax.swing.JComboBox<String>(sanziman_turleri);

            arac_tip_alan = new javax.swing.JComboBox<String>(arac_tipleri);

            renk_alan = new javax.swing.JTextField();

            motor_guc_alan = new javax.swing.JTextField();

            motor_hacim_alan = new javax.swing.JTextField();

            yakit_alan = new javax.swing.JComboBox<String>(yakit_turleri);

            kaydet.setText("Kaydet");
        } else if (kontrol==2) {
            baslik.setText("Araç Düzenleme Ekranı");
            plaka_alan = new javax.swing.JTextField(plaka);

            marka_alan = new javax.swing.JTextField(marka);

            model_alan = new javax.swing.JTextField(model);

            yil_alan = new javax.swing.JComboBox<Integer>(yillar);
            yil_alan.setSelectedItem(yil);

            motor_no_alan = new javax.swing.JTextField(motorno);

            sasi_no_alan = new javax.swing.JTextField(sasino);

            ruhsat_sahibi_alan = new javax.swing.JTextField(ruhsat_sahibi);

            kasa_tip_alan = new javax.swing.JComboBox<String>(kasa_tipleri);
            kasa_tip_alan.setSelectedItem(kasa_tip);

            sanziman_alan = new javax.swing.JComboBox<String>(sanziman_turleri);
            sanziman_alan.setSelectedItem(sanziman);

            arac_tip_alan = new javax.swing.JComboBox<String>(arac_tipleri);
            arac_tip_alan.setSelectedItem(arac_tip);

            renk_alan = new javax.swing.JTextField(renk);

            motor_guc_alan = new javax.swing.JTextField(String.valueOf(motor_guc));

            motor_hacim_alan = new javax.swing.JTextField(String.valueOf(motor_hacim));

            yakit_alan = new javax.swing.JComboBox<String>(yakit_turleri);
            yakit_alan.setSelectedItem(yakit);

            kaydet.setText("Kaydet");
        }
        if(kontrol==1 || kontrol==2){
            plaka_alan.setEditable(true);
            marka_alan.setEditable(true);
            model_alan.setEditable(true);
            yil_alan.setEditable(true);
            motor_no_alan.setEditable(true);
            sasi_no_alan.setEditable(true);
            ruhsat_sahibi_alan.setEditable(true);
            kasa_tip_alan.setEditable(true);
            sanziman_alan.setEditable(true);
            arac_tip_alan.setEditable(true);
            renk_alan.setEditable(true);
            motor_guc_alan.setEditable(true);
            motor_hacim_alan.setEditable(true);
            yakit_alan.setEditable(true);
        }
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public String getMotorno() {
        return motorno;
    }

    public void setMotorno(String motorno) {
        this.motorno = motorno;
    }

    public String getSasino() {
        return sasino;
    }

    public void setSasino(String sasino) {
        this.sasino = sasino;
    }

    public String getRuhsat_sahibi() {
        return ruhsat_sahibi;
    }

    public void setRuhsat_sahibi(String ruhsat_sahibi) {
        this.ruhsat_sahibi = ruhsat_sahibi;
    }

    public String getArac_tip() {
        return arac_tip;
    }

    public void setArac_tip(String arac_tip) {
        this.arac_tip = arac_tip;
    }

    public String getKasa_tip() {
        return kasa_tip;
    }

    public void setKasa_tip(String kasa_tip) {
        this.kasa_tip = kasa_tip;
    }

    public String getSanziman() {
        return sanziman;
    }

    public void setSanziman(String sanziman) {
        this.sanziman = sanziman;
    }

    public String getRenk() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }

    public double getMotor_hacim() {
        return motor_hacim;
    }

    public void setMotor_hacim(double motor_hacim) {
        this.motor_hacim = motor_hacim;
    }

    public double getMotor_guc() {
        return motor_guc;
    }

    public void setMotor_guc(double motor_guc) {
        this.motor_guc = motor_guc;
    }

    public String getYakit() {
        return yakit;
    }

    public void setArac_no(int arac_no) {
        this.arac_no = arac_no;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }
}