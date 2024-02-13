import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class Araclar implements IMenu {
    @Override
    public void Arama(String deger,int index) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tablemodel);
        RowFilter<TableModel, Integer> rf = RowFilter.regexFilter(deger, index);
            AracTakip.getjTable1().setRowSorter(tr);
            tr.setRowFilter(rf);
    }

    private static ArrayList<Arac> araclar;
    private static VeriTabani veriTabani;
    private static DefaultTableModel tablemodel;
    private Arac arac;
    private ResultSet rs;

    public Araclar() {

        araclar=new ArrayList<Arac>();
        veriTabani=new VeriTabani();
        tablemodel= (DefaultTableModel) AracTakip.getjTable1().getModel();

        Guncelle();
    }

    public static void Guncelle(){
        tablemodel.setRowCount(0);
        try {
            araclar=Getir();
            for (Arac arac:araclar) {
                Object[] eklenecekler ={arac.getArac_no(),arac.getPlaka(),arac.getMarka(),arac.getModel(),arac.getYil(),arac.getMotorno(),arac.getSasino(),arac.getRuhsat_sahibi(),arac.getArac_tip(),arac.getKasa_tip(),arac.getSanziman(),arac.getRenk(),arac.getMotor_guc(),arac.getMotor_hacim(),arac.getYakit()};
                tablemodel.addRow(eklenecekler);
                tablemodel.fireTableDataChanged();
                AracTakip.getjTable1().repaint();
                AracTakip.getjTable1().revalidate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Arac> Getir() throws SQLException {
        ArrayList<Arac> aracListesi=new ArrayList<>();
        veriTabani=new VeriTabani();
        ResultSet rs=veriTabani.AracCek();
        while (rs.next()){
            id=rs.getInt("arac_no");
            plaka=rs.getString("plaka");
            marka=rs.getString("marka");
            model=rs.getString("model");
            yil=rs.getInt("yil");
            motorno=rs.getString("motor_no");
            sasino=rs.getString("sasi_no");
            ruhsat_sahibi=rs.getString("ruhsat_sahibi");
            arac_tip=rs.getString("arac_tip");
            kasa_tip=rs.getString("kasa_tip");
            sanziman=rs.getString("sanziman");
            renk=rs.getString("renk");
            motor_guc=rs.getDouble("motor_guc");
            motor_hacim=rs.getDouble("motor_hacim");
            yakit=rs.getString("yakit");
            aracListesi.add(new Arac(id,plaka,marka,model,yil,motorno,sasino,ruhsat_sahibi,arac_tip,kasa_tip,sanziman,renk,motor_guc,motor_hacim,yakit));
        }
        return aracListesi;
    }
    public  static String[] MarkaCek(){
        Set<String> markalar=new LinkedHashSet<>();
        try {
            ArrayList<Arac> araclistesi=Getir();
            markalar.add("Tümü");
            for(Arac arac:araclistesi){
                markalar.add(arac.getMarka());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Object[] array=markalar.toArray();
        String[] markaListesi= Arrays.copyOf(array,array.length,String[].class);
        return markaListesi;
    }

    public static String[] ModelCek(){
        Set<String> modeller=new LinkedHashSet<>();
        try {
            ArrayList<Arac> araclistesi=Getir();
            modeller.add("Tümü");
            for(Arac arac:araclistesi){
                modeller.add(arac.getModel());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Object[] array=modeller.toArray();
        String[] modelListesi= Arrays.copyOf(array,array.length,String[].class);
        return modelListesi;
    }

    public static String[] AracTipCek(){
        Set<String> arac_tip=new LinkedHashSet<>();
        try {
            ArrayList<Arac> araclistesi=Getir();
            arac_tip.add("Tümü");
            for(Arac arac:araclistesi){
                arac_tip.add(arac.getArac_tip());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Object[] array=arac_tip.toArray();
        String[] aracTipListesi= Arrays.copyOf(array,array.length,String[].class);
        return aracTipListesi;
    }

    public static String[] kasaTipCek(){
        Set<String> kasa_tipler=new LinkedHashSet<>();
        try {
            ArrayList<Arac> araclistesi=Getir();
            kasa_tipler.add("Tümü");
            for(Arac arac:araclistesi){
                kasa_tipler.add(arac.getKasa_tip());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Object[] array=kasa_tipler.toArray();
        String[] kasaTipListesi= Arrays.copyOf(array,array.length,String[].class);
        return kasaTipListesi;
    }

    @Override
    public  void Ekle() {
        arac=new Arac();
        arac.AracEkle();
        Guncelle();
    }

    @Override
    public void Sil() {
        int selectRow=AracTakip.getjTable1().getSelectedRow();
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
            veriTabani.AracSil(id);
        }
        Guncelle();
    }

    @Override
    public void Duzenle() {
        int selectRow=AracTakip.getjTable1().getSelectedRow();
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
            arac=veriTabani.AracCek(id);
            arac.AracDuzenle(id);
        }
        Guncelle();
    }

    public void BigileriGoster(){
        int selectRow=AracTakip.getjTable1().getSelectedRow();
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
            arac=veriTabani.AracCek(id);
            arac.AracBilgileriGoster(id);
        }
        Guncelle();
    }

    @Override
    public void Yenile() {
        Guncelle();
    }

    public void Goruntule(){
        int selectRow=AracTakip.getjTable1().getSelectedRow();
        if(selectRow!=-1){
            int id= (int) tablemodel.getValueAt(selectRow,0);
            arac=veriTabani.AracCek(id);
            AracTakip.getPlaka_alan().setText(arac.getPlaka());
            AracTakip.getMarka_alan().setText(arac.getMarka());
            AracTakip.getModel_alan().setText(arac.getModel());
            AracTakip.getYil_alan().setText(String.valueOf(arac.getYil()));
            AracTakip.getMotor_no_alan().setText(arac.getMotorno());
            AracTakip.getSasi_alan().setText(arac.getSasino());
            AracTakip.getRuhsat_alan().setText(arac.getRuhsat_sahibi());
            AracTakip.getAractip_alan().setText(arac.getArac_tip());
            AracTakip.getKasa_tip_alan().setText(arac.getKasa_tip());
            AracTakip.getSanziman_alan().setText(arac.getSanziman());
            AracTakip.getRenk_alan().setText(arac.getRenk());
            AracTakip.getMotor_gucualan().setText(String.valueOf(arac.getMotor_guc()));
            AracTakip.getMotor_hacmi_alan().setText(String.valueOf(arac.getMotor_hacim()));
            AracTakip.getYakit_alan().setText(arac.getYakit());
        }
    }

    private static int id;
    private static String plaka;
    private static String marka;
    private static String model;
    private static int yil;
    private static String motorno;
    private static String sasino;
    private static String ruhsat_sahibi;
    private static String arac_tip;
    private static String kasa_tip;
    private static String sanziman;
    private static String renk;
    private static double motor_hacim;
    private static double motor_guc;
    private static String yakit;
}

