import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class IsEmriIslemler implements IMenu {
    private static ArrayList<IsEmri> emirler;
    private static VeriTabani veriTabani;
    private static DefaultTableModel tablemodel;
    private static ResultSet rs;
    private IsEmri emir;

    public IsEmriIslemler() {
        emirler=new ArrayList<>();
        veriTabani=new VeriTabani();
        tablemodel= (DefaultTableModel) Anasayfa.getEmirTable().getModel();
        emir=new IsEmri();
        Guncelle();
    }
    public static void Guncelle(){
        tablemodel.setRowCount(0);
        Arac arac=null;
        Cari cari=null;
        IsEmri tempemir;
        try {
            emirler=Getir();
            for (IsEmri emir:emirler) {
                tempemir=veriTabani.IsEmriCek(emir.getIsEmriId());
                arac=veriTabani.AracCek(tempemir.getAracId());
                cari=veriTabani.CariCek(tempemir.getCariId());
                Object[] eklenecekler={emir.getIsEmriId(),arac.getPlaka(), emir.getIsemriNO(),arac.getMarka(),arac.getModel(),cari.getMusteriadi(),arac.getRuhsat_sahibi(),emir.getSorumluPersonel(),emir.getGirisKm(),emir.getTakipDurum(),emir.getTarih()};
                tablemodel.addRow(eklenecekler);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void Ekle() {
        emir=new IsEmri();
        emir.Ekle();
        Guncelle();
    }

    @Override
    public void Sil() {
        int selectRow=Anasayfa.getEmirTable().getSelectedRow();
        if(selectRow==-1){
            if(tablemodel.getRowCount()==0){
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Tablo Boş...");
            }
            else{
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Lütfen Eleman Seciniz...");
            }
        }
        else{
            int id= (int) tablemodel.getValueAt(selectRow,0);
            veriTabani.IsEmriSil(id);
        }
        Guncelle();
    }

    @Override
    public void Duzenle() {
        int selectRow=Anasayfa.getEmirTable().getSelectedRow();
        if(selectRow==-1){
            if(tablemodel.getRowCount()==0){
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Tablo Boş...");
            }
            else{
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Lütfen Eleman Seciniz...");
            }
        }
        else{
            int id= (int) tablemodel.getValueAt(selectRow,0);
            emir=veriTabani.IsEmriCek(id);
            emir.Duzenle(id);
        }
        Guncelle();
    }
public void Servis(){
    int selectRow=Anasayfa.getEmirTable().getSelectedRow();
    if(selectRow==-1){
        if(tablemodel.getRowCount()==0){
            JOptionPane.showMessageDialog(Arayuz.getFrame(),"Tablo Boş...");
        }
        else{
            JOptionPane.showMessageDialog(Arayuz.getFrame(),"Lütfen Eleman Seciniz...");
        }
    }
    else{
        int id= (int) tablemodel.getValueAt(selectRow,0);
        emir=veriTabani.IsEmriCek(id);
        ServisPanel servisPanel=new ServisPanel(emir.getAracId());

    }
    Guncelle();
}
    public static String[] TakipDurumlariCek(){
        Set<String> takipdurumlar=new LinkedHashSet<>();
        try {
            ArrayList<IsEmri> emirler=Getir();
            takipdurumlar.add("Tümü");
            for(IsEmri emir:emirler){
                takipdurumlar.add(emir.getTakipDurum());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Object[] array=takipdurumlar.toArray();
        String[] takiptipListee= Arrays.copyOf(array,array.length,String[].class);
        return takiptipListee;
    }
    public void TakipDurumlariGuncelle(){
        int selectRow=Anasayfa.getEmirTable().getSelectedRow();
        if(selectRow!=-1){
            int id=(int) tablemodel.getValueAt(selectRow,0);
            emir=veriTabani.IsEmriCek(id);
            Arac arac=veriTabani.AracCek(emir.getAracId());
            Cari cari=veriTabani.CariCek(emir.getCariId());
         veriTabani.TakipDuzenle(id,Anasayfa.getDurum_combo().getSelectedItem().toString());
         Guncelle();
        }

    }
    public void Goruntule(){
        int selectRow=Anasayfa.getEmirTable().getSelectedRow();
        if(selectRow!=-1){
            int id=(int) tablemodel.getValueAt(selectRow,0);
            emir=veriTabani.IsEmriCek(id);
            Arac arac=veriTabani.AracCek(emir.getAracId());
            Cari cari=veriTabani.CariCek(emir.getCariId());
            Anasayfa.getEmir_tarih_alan().setText(emir.getTarih());
            Anasayfa.getPlaka_alan().setText(arac.getPlaka());
            Anasayfa.getCariAdi_alan().setText(cari.getMusteriadi());
            Anasayfa.getEmirAlanPersonel().setText(emir.getSorumluPersonel());
            Anasayfa.getGelisKm_alan().setText(String.valueOf(emir.getGirisKm()));
            Anasayfa.getModel_alan().setText(arac.getModel());
            Anasayfa.getYil_alan().setText(String.valueOf(arac.getYil()));
            Anasayfa.getMotorNo_alan().setText(arac.getMotorno());
            Anasayfa.getSasiNo_alan().setText(arac.getSasino());
            Anasayfa.getAracSikayet_area().setText(emir.getAracSikayet());
            Anasayfa.getDurum_combo().setSelectedItem(emir.getTakipDurum());
            Anasayfa.getMusteriAd_alan().setText(cari.getMusteriadi());
            Anasayfa.getPlakaAd_alan().setText(arac.getPlaka());
            Anasayfa.getDurum_combo().setSelectedItem(emir.getTakipDurum());
        }

    }

    @Override
    public void Yenile() {
        Guncelle();
    }

    @Override
    public void Arama(String deger, int index) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tablemodel);
        RowFilter<TableModel, Integer> rf = RowFilter.regexFilter(deger, index);
        Anasayfa.getEmirTable().setRowSorter(tr);
        tr.setRowFilter(rf);
    }
    public static ArrayList<IsEmri> Getir() throws SQLException {
        ArrayList<IsEmri> emirListesi=new ArrayList<>();
        veriTabani=new VeriTabani();
        rs=veriTabani.IsEmirleriCek();
        while (rs.next()){
            isEmriId=rs.getInt("id");
            aracId=rs.getInt("aracid");
            cariId=rs.getInt("cariid");
            isemriNO=rs.getString("isemrino");
            aracTeslimEden=rs.getString("aracteslim");
            aracTeslimAlan=rs.getString("aracalan");
            girisKm=rs.getDouble("giriskm");
            takipDurum=rs.getString("takipdurum");
            sorumluPersonel=rs.getString("sorumlupersonel");
            tarih=rs.getString("tarih");
            saat=rs.getString("saat");

            aracSikayet=rs.getString("aracsikayet");
            emirListesi.add(new IsEmri( isEmriId,  aracId,  cariId,  isemriNO,  aracTeslimEden,  aracTeslimAlan,  girisKm,  takipDurum,  sorumluPersonel,  tarih,  saat,  aracSikayet));

        }
        return emirListesi;
    }
    public String IsEmriNoAta(){
        int id;
        try {
            ArrayList<IsEmri> emirler=Getir();
            id=emirler.get(emirler.size()-1).getIsEmriId()+1;
        }
        catch (IndexOutOfBoundsException e)
        {
            id=1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sira=String.valueOf(id);
        int uzunluk=sira.length();
        String isemrino="IE";
        for(int i=0;i<7-uzunluk;i++)
            isemrino+="0";
        isemrino+=id;
        return isemrino;
    }
    public static void AracSecFrame(){
        JFrame jFrame=new JFrame("Araç Seç");
        jFrame.setVisible(true);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "id", "Plaka No", "Marka", "Model", "Yıl", "Arac Tipi"
                }
        ));

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(72);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        try {
            model.setRowCount(0);
            for (Arac arac:Araclar.Getir()) {
                Object[] eklenecekler = {arac.getArac_no(), arac.getPlaka(), arac.getMarka(), arac.getModel(), arac.getYil(),arac.getArac_tip()};
                model.addRow(eklenecekler);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jButton1.setText("Vazgeç");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrame.setVisible(false);
            }
        });

        jButton2.setText("Araç Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Arac arac=new Arac();
                arac.AracEkle();
            }
        });
        jTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
                RowFilter<TableModel, Integer> rf = RowFilter.regexFilter(jTextField1.getText(), 1);
                tr.setRowFilter(rf);
                jTable1.setRowSorter(tr);
            }
        });
        jTable1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectrow=jTable1.getSelectedRow();
                if(selectrow!=-1){
                    DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                    int id= (int) model.getValueAt(selectrow,0);
                    VeriTabani veriTabani=new VeriTabani();
                    Arac arac=veriTabani.AracCek(id);
                    IsEmri.setArac(arac);
                    IsEmri.setAracId(id);
                    IsEmri.setMarka_alan(arac.getMarka());
                    IsEmri.setModel_alan(arac.getModel());
                    IsEmri.setPlaka_alan(arac.getPlaka());
                    IsEmri.setRuhsatSahibi_alan(arac.getRuhsat_sahibi());
                    IsEmri.setModelYil_alan(String.valueOf(arac.getYil()));
                    jFrame.setVisible(false);

                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Plaka No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(19, 19, 19)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
        );
        jFrame.setLocation(400,150);
        jFrame.pack();
        jFrame.setResizable(false);

    }
    public static void CariSecFrame(){
        JFrame jFrame=new JFrame("Cari Seç");
        jFrame.setVisible(true);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "id", "Cari No", "Cari Adı", "Cari Tipi", "Yetkili", "Cep Telefonu"
                }
        ));

        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(140);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        try {
            model.setRowCount(0);
            for (Cari cari:Cariler.Getir()) {
                Object[] eklenecekler = {cari.getCariId(),cari.getCariNo(),cari.getMusteriadi(),cari.getCariTip(),cari.getYetkili(),cari.getCepTel()};
                model.addRow(eklenecekler);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jButton1.setText("Vazgeç");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFrame.setVisible(false);
            }
        });

        jButton2.setText("Cari Ekle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cari cari=new Cari();
                cari.CariEkle();
            }
        });
        jTable1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectrow=jTable1.getSelectedRow();
                if(selectrow!=-1){
                    DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                    int id= (int) model.getValueAt(selectrow,0);
                    VeriTabani veriTabani=new VeriTabani();
                    Cari cari=veriTabani.CariCek(id);
                    IsEmri.setCari(cari);
                    IsEmri.setCariId(id);
                    IsEmri.setCariAd_alan(cari.getMusteriadi());
                    IsEmri.setCariNo_alan(cari.getCariNo());
                    IsEmri.setCariTip_alan(cari.getCariTip());
                    IsEmri.setCepTel_alan(cari.getCepTel());
                    IsEmri.setYetkili_alan(cari.getYetkili());
                    jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    jFrame.dispose();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        jTextField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
                TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
                RowFilter<TableModel, Integer> rf = RowFilter.regexFilter(jTextField1.getText(), 1);
                tr.setRowFilter(rf);
                jTable1.setRowSorter(tr);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Cari No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(19, 19, 19)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(12, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
        );
        jFrame.setLocation(400,150);
        jFrame.pack();
        jFrame.setResizable(false);
    }

    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JLabel jLabel1;
    private static javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    private static javax.swing.JTextField jTextField1;
    private static int isEmriId;
    private static int aracId;
    private static int cariId;
    private static String isemriNO;
    private static String aracTeslimEden;
    private static String aracTeslimAlan;
    private static double girisKm;
    private static String takipDurum;
    private static String sorumluPersonel;
    private static String tarih;
    private static String saat;
    private static String aracSikayet;
}
