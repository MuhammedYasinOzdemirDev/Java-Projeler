import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HasarPanel extends JFrame implements ActionListener, KeyListener,IHasarPanelKontrol {
    private int kontrol;
    private static Hasar hasar;
    private Hasarlar hasarlar;
    private int aracId=-1;
    private VeriTabani veriTabani;
    private static int hasarid;

    public static int getHasarid() {
        return hasarid;
    }

    public static void setHasarid(int hasarid) {
        HasarPanel.hasarid = hasarid;
    }

    public static void setHasar(Hasar hasar) {
        HasarPanel.hasar = hasar;
    }

    public void HasarBelirle(String hasartur, double fiyat , String hasartarih, String hasaryer){
        if(hasartur.equals("Ön Hasar")){
            hasar= new Hasarlar.OnHasar("Ön kısmının hasar görmesi\nÇarpışma sonucunda ön tamponun deforme olması\nveya farların kırılması.",fiyat,fiyat/4,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Arka Hasar")) {
            hasar=new Hasarlar.ArkaHasar("Arka kısmının hasar görmesi\nÇarpışma sonucunda arka tamponun deforme olması\nveya arka farların kırılması.",fiyat,fiyat/3.2,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Yan Hasar")) {
            hasar=new Hasarlar.YanHasar("Yan kısmının hasar görmesi\nÇarpışma sonucunda kapıların deforme olması \nveya camların kırılması.",fiyat,fiyat/5,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Jant Hasar")) {
            hasar=new Hasarlar.JantHasar("Jantların hasar görmesi\nÇarpışma sonucunda jantların deforme olması \nveya düşük hızlarda çukur girmesi sonucu jantın deforme olması.",fiyat,fiyat/4.8,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Boya Hasar")) {
            hasar=new Hasarlar.BoyaHasar("Boya tabakasının hasar görmesi\nÇarpışma sonucu boya tabakasının çatlaması \nveya düşük hızlarda çizikler oluşması.",fiyat,fiyat/7.4,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Ön Kaput Hasar")) {
            hasar=new Hasarlar.OnKaputHasar("Ön kaputun hasar görmesi.\nÇarpışma sonucunda ön kaputun deforme olması \nveya düşük hızlarda çizikler oluşması.",fiyat,fiyat/5.1,hasartur,hasartarih,hasaryer);

        } else if (hasartur.equals("Arka Kaput Hasar")) {
            hasar=new Hasarlar.ArkaKaput(" Arka kaputun hasar görmesi\nÇarpışma sonucunda arka kaputun deforme olması \nveya düşük hızlarda çizikler oluşması..",fiyat,fiyat/2.7,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("İç Hasar")) {
            hasar=new Hasarlar.IcHasar("Aracın iç kısmının hasar görmesi. \nÇarpışma sonucunda direksiyon simidinin deforme olması \nveya koltukların deforme olması.\n" +
                    "\n",fiyat,fiyat/4.5,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Elektronik Hasar")) {
            hasar=new Hasarlar.ElektronikHasar("Elektronik sistemlerin hasar görmesi\nÇarpışma sonucumda arabanın elektrik sistemlerinin bozulması veya\ndüşük hızlarda elektronik parçaların deforme olması.",fiyat,fiyat/1.8,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Motor Hasar")) {
            hasar=new Hasarlar.MotorHasar("Motorun hasar görmesi.\nÇarpışma sonucuna motorun deforme olması veya\nparçalarının kırılması.",fiyat,fiyat/2.4,hasartur,hasartarih,hasaryer);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==hasarTur_alan) {
            if (!(hasarTarih_alan.getText().trim().equals("") || hasarFiyat_alan.getText().trim().equals("") || hasarYer_alan.getText().trim().equals(""))) {
                HasarBelirle(hasarTur_alan.getSelectedItem().toString(), Double.parseDouble(hasarFiyat_alan.getText()), hasarTarih_alan.getText(), hasarYer_alan.getText());
                aciklama_alan.setText(hasar.getAciklama());
            }
        }
            if(kaydet_button==e.getSource()){
                if(aracId!=-1){

                        if (kontrol == 0) {
                            veriTabani.HasarEkle(aracId, hasar);
                            JOptionPane.showMessageDialog(this, "Hasar eklendi...");
                            ServisIslemler.Guncelle();
                            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            dispose();
                        } else if (kontrol==1) {
                            veriTabani.HasarDuzenle(hasar.getHasarid(),hasar);
                            JOptionPane.showMessageDialog(this, "Hasar Düzenlendi...");
                            ServisIslemler.Guncelle();
                            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            dispose();
                        }


                }
        }
            if(iptal_button==e.getSource()) {
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dispose();
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
        if(!(hasarTarih_alan.getText().trim().equals("") || hasarFiyat_alan.getText().trim().equals("") || hasarYer_alan.getText().trim().equals(""))) {
            HasarBelirle(hasarTur_alan.getSelectedItem().toString(), Double.parseDouble(hasarFiyat_alan.getText()), hasarTarih_alan.getText(), hasarYer_alan.getText());
            aciklama_alan.setText(hasar.getAciklama());
        }

    }

    @Override
    public boolean FiyatKontrol(String fiyat) {
        try{
            Double.parseDouble(fiyat);
            return true;
        }
      catch (Exception e){
            return  false;
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

    public HasarPanel(String title, int kontrol, int aracid) throws HeadlessException {
        super(title);
        this.kontrol=kontrol;
        this.aracId=aracid;
        veriTabani=new VeriTabani();

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        if(kontrol==0){
            hasarTur_alan = new javax.swing.JComboBox<String>(Hasarlar.getHasarlar());
            hasarFiyat_alan = new javax.swing.JTextField();
            hasarTarih_alan = new javax.swing.JTextField();
            hasarYer_alan = new javax.swing.JTextField();
            jLabel15.setText("Hasar Ekleme Ekranı");
            aciklama_alan = new javax.swing.JTextArea();
        }
        else {
            jLabel15.setText("Hasar Düzenleme Ekranı");
            hasarTur_alan = new javax.swing.JComboBox<String>(Hasarlar.getHasarlar());
            hasarTur_alan.setSelectedItem(hasar.getHasarturu());
            hasarFiyat_alan = new javax.swing.JTextField(String.valueOf(hasar.getIscilik()+hasar.getMaliyet()));
            hasarTarih_alan = new javax.swing.JTextField(hasar.getHasartarih());
            hasarYer_alan = new javax.swing.JTextField(hasar.getHasaryeri());
            aciklama_alan = new javax.swing.JTextArea(hasar.getAciklama());
        }
        hasarYer_alan.addKeyListener(this);
        hasarFiyat_alan.addKeyListener(this);
        hasarTarih_alan.addKeyListener(this);
        hasarTur_alan.addActionListener(this);
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kaydet_button = new javax.swing.JButton();
        iptal_button = new javax.swing.JButton();



        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);


        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Hasar Türü");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Hasar Tarih");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Hasar Fiyat");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Hasar Yer");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Açıklama");

        aciklama_alan.setEditable(false);
        aciklama_alan.setColumns(20);
        aciklama_alan.setRows(5);
        aciklama_alan.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jScrollPane1.setViewportView(aciklama_alan);

        kaydet_button.setText("Kaydet");

        iptal_button.setText("İptal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(iptal_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(kaydet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(hasarYer_alan, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(hasarFiyat_alan))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(hasarTarih_alan))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(hasarTur_alan)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(hasarTur_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(hasarFiyat_alan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(hasarTarih_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(hasarYer_alan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(kaydet_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iptal_button, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        kaydet_button.addActionListener(this);
        iptal_button.addActionListener(this);
        setLocation(320,100);
        setVisible(true);
        setResizable(false);
        pack();
    }
    public static void main(String[] args){
    }
    private javax.swing.JTextArea aciklama_alan;

    private javax.swing.JTextField hasarFiyat_alan;
    private javax.swing.JTextField hasarTarih_alan;
    private javax.swing.JComboBox<String> hasarTur_alan;
    private javax.swing.JTextField hasarYer_alan;
    private javax.swing.JButton iptal_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kaydet_button;

    public static Hasar getHasar() {
        return hasar;
    }
}
