import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServisIslemler {
    private static ArrayList<Hasar> hasarlar;
    private static VeriTabani veriTabani;
    private static DefaultTableModel tableModel;
    private static ResultSet rs;
    private Hasar hasar;

    public ServisIslemler() {
        hasarlar=new ArrayList<>();
        veriTabani=new VeriTabani();
        tableModel= (DefaultTableModel) ServisPanel.getHasarTable().getModel();
        Guncelle();
    }

    public void Ekle() {
        HasarPanel hasarPanel=new HasarPanel("Hasar Ekleme Ekranı",0,ServisPanel.getAracid());
        Guncelle();
    }

    public void Sil() {
        int selectRow=ServisPanel.getHasarTable().getSelectedRow();
        if(selectRow==-1){
            if(tableModel.getRowCount()==0){
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Tablo Boş...");
            }
            else{
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Lütfen Eleman Seciniz...");
            }
        }
        else{
            int id= (int) tableModel.getValueAt(selectRow,0);
            veriTabani.HasarSil(id);
        }
        Guncelle();
    }

    public void Duzenle() {
        int selectRow=ServisPanel.getHasarTable().getSelectedRow();
        if(selectRow==-1){
            if(tableModel.getRowCount()==0){
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Tablo Boş...");
            }
            else{
                JOptionPane.showMessageDialog(Arayuz.getFrame(),"Lütfen Eleman Seciniz...");
            }
        }
        else{
            int id= (int) tableModel.getValueAt(selectRow,0);
            Hasar hasar= veriTabani.HasarCek(id);
            HasarPanel.setHasar(hasar);
            HasarPanel.setHasarid(id);
            HasarPanel hasarPanel=new HasarPanel("Hasar Düzenleme Ekranı",1,ServisPanel.getAracid());
        }
        Guncelle();
    }
    public void Yenile() {
        Guncelle();
    }
    public static void Guncelle(){
        tableModel.setRowCount(0);
        hasarlar=Getir();
        for(Hasar hasar:hasarlar){
            Object[] eklenecekler={hasar.getHasarid(),hasar.getHasarturu(),(hasar.getMaliyet()+hasar.getIscilik()),hasar.getHasartarih(),hasar.getHasaryeri(),hasar.getAciklama()};
            tableModel.addRow(eklenecekler);
            tableModel.fireTableDataChanged();
            ServisPanel.getHasarTable().repaint();
            ServisPanel.getHasarTable().revalidate();
        }
}

public static ArrayList<Hasar> Getir(){
        veriTabani=new VeriTabani();
        ArrayList<Hasar> hasarListesi=new ArrayList<>();
        rs=veriTabani.HasarlariCek(ServisPanel.getAracid());
        Hasarlar hasarlar=new Hasarlar();
        try{
            while (rs.next()){
                hasarListesi.add(hasarlar.HasarBelirle(rs.getInt("hasarid"),rs.getString("aciklama"),rs.getDouble("maliyet"),rs.getDouble("iscilik"),rs.getString("hasartur"),rs.getString("hasartarih"),rs.getString("hasaryer")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return hasarListesi;
}

public void Goruntule(){
    int selectRow=ServisPanel.getHasarTable().getSelectedRow();
    if(selectRow!=-1){
        int id= (int) tableModel.getValueAt(selectRow,0);
        hasar= veriTabani.HasarCek(id);
        ServisPanel.getHasarAciklama_area().setText(hasar.getAciklama());
        ServisPanel.getHasarfiyat_alan().setText(String.valueOf(hasar.getMaliyet()+hasar.getIscilik()));
        ServisPanel.getHasarTur_alan().setText(hasar.getHasarturu());
        ServisPanel.getHasarTarih_alan().setText(hasar.getHasartarih());
        ServisPanel.getHasarYer_button().setText(hasar.getHasaryeri());
    }
}

}
