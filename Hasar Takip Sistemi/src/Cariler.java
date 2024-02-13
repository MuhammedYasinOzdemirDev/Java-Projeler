import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Cariler implements IMenu{
    private static ArrayList<Cari> cariler;
    private static VeriTabani veriTabani;
    private static DefaultTableModel tablemodel;
    private Cari cari;
    private static ResultSet rs;

    public Cariler() {
        cariler=new ArrayList<>();
        veriTabani=new VeriTabani();
        tablemodel= (DefaultTableModel) CariPanel.getCariTable().getModel();
        Guncelle();
    }

    @Override
    public void Ekle() {
        cari=new Cari();
        cari.CariEkle();
        Guncelle();
    }

    @Override
    public void Sil() {
        int selectRow=CariPanel.getCariTable().getSelectedRow();
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
            veriTabani.CariSil(id);
        }
        Guncelle();
    }

    @Override
    public void Duzenle() {
        int selectRow=CariPanel.getCariTable().getSelectedRow();
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
            cari=veriTabani.CariCek(id);
            cari.CariDuzenle(id);
        }
        Guncelle();
    }

    @Override
    public void Yenile() {
        Guncelle();
    }

    @Override
    public void Arama(String deger, int index) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tablemodel);
        RowFilter<TableModel, Integer> rf = RowFilter.regexFilter(deger, index);
        CariPanel.getCariTable().setRowSorter(tr);
        tr.setRowFilter(rf);
    }

    public static void Guncelle(){
        tablemodel.setRowCount(0);
        try {
            cariler=Getir();
            for (Cari cari:cariler) {
                Object[] eklenecekler={cari.getCariId(),cari.getMusteriadi(),cari.getCariNo(),cari.getYetkili(),cari.getVergiNo(),cari.getVergiDairesi(),cari.getEmail(),cari.getCepTel(),cari.getIl(),cari.getIlce(),cari.getCariTip()};
                tablemodel.addRow(eklenecekler);
                tablemodel.fireTableDataChanged();
                CariPanel.getCariTable().repaint();
                CariPanel.getCariTable().revalidate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Cari> Getir() throws SQLException {
        ArrayList<Cari> cariListesi=new ArrayList<>();
        veriTabani=new VeriTabani();
         rs=veriTabani.CariCek();
        while (rs.next()){
            cariId=rs.getInt("id");
            musteriadi=rs.getString("musteriadi");
            cariTip=rs.getString("caritip");
            cariNo= (rs.getString("cariNo"));
            yetkili=rs.getString("yetkili");
            vergiNo= (rs.getString("vergino"));
            vergiDairesi=rs.getString("vergiDairesi");
            cepTel=(rs.getString( "ceptel"));
            email=rs.getString("email");
            fax= (rs.getString( "fax"));
            webSitesi=rs.getString("websitesi");
            il=rs.getString("il");
            ilce=rs.getString("ilce");
            meslek=rs.getString("meslek");
            indirimOrani=rs.getDouble("indirimOran");
            vade=rs.getString("vade");
            cariId=rs.getInt("id");
            tc=rs.getString("tc");
            cariListesi.add(new Cari( cariId,  musteriadi,   cariTip,  cariNo,  yetkili,  vade,  vergiNo,  vergiDairesi,  cepTel,  email,  fax,  webSitesi,  il,  ilce,  meslek,  indirimOrani,tc));
        }
        return cariListesi;
    }
    public void Goruntule(){
        int selectRow=CariPanel.getCariTable().getSelectedRow();
        if(selectRow!=-1){
            int id= (int) tablemodel.getValueAt(selectRow,0);
            cari=veriTabani.CariCek(id);
           CariPanel.getCari_ad_alan().setText(cari.getMusteriadi());
           CariPanel.getCari_tip_alan().setText(cari.getCariTip());
           CariPanel.getCari_kod_alan().setText(cari.getCariNo());
           CariPanel.getVade_gun_alan().setText(String.valueOf(cari.getVade()));
           CariPanel.getYetkili_alan().setText(cari.getYetkili());
           CariPanel.getVergi_no_alan().setText(cari.getVergiNo());
           CariPanel.getvergiDairesi().setText(cari.getVergiDairesi());
           CariPanel.getTelefon2_alan().setText(cari.getCepTel());
           CariPanel.getEmail_adresi_alan().setText(cari.getEmail());
           CariPanel.getWeb_sitesi_alan().setText(cari.getWebSitesi());
           CariPanel.getFax_alan().setText(cari.getFax());
           CariPanel.getIl_alan().setText(cari.getIl());
           CariPanel.getIlce_alan().setText(cari.getIlce());
           CariPanel.getMeslek_alan().setText(cari.getMeslek());
           CariPanel.getIndirim_alan().setText(String.valueOf(cari.getIndirimOrani()));
        }
    }
    public static String[] CariTipCek(){
        Set<String> cariTipler=new LinkedHashSet<>();
        try {
            ArrayList<Cari> carilistesi=Getir();
            cariTipler.add("Tümü");
            for(Cari cari:carilistesi){
                cariTipler.add(cari.getCariTip());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Object[] array=cariTipler.toArray();
        String[] caritipListee= Arrays.copyOf(array,array.length,String[].class);
        return caritipListee;
    }
    public void MesajGonder(){
        String mail = null;
        try {
            int selectRow=CariPanel.getCariTable().getSelectedRow();
            if(selectRow!=-1){
                int id= (int) tablemodel.getValueAt(selectRow,0);
                cari=veriTabani.CariCek(id);
                mail=cari.getEmail();

                Desktop.getDesktop().browse(new URI("mailto:" +mail + "?body=" + "Test"));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    private static int cariId;
    private static String musteriadi;
    private static String cariTip;
    private static String cariNo;
    private static String yetkili;
    private static String vade;
    private static String vergiNo;
    private static String vergiDairesi;
    private static String cepTel;
    private static String email;
    private static String fax;
    private static String webSitesi;
    private static String il;
    private static String ilce;
    private static String meslek;
    private static double indirimOrani;
    private static String tc;
}
