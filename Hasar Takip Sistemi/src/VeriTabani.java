import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VeriTabani implements IVeriTabani {
    private Connection con = null;
    private PreparedStatement preparedStatement;

    public VeriTabani() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + db_ismi;
        try {
            con = DriverManager.getConnection(url, k_adi, sifre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean adminKontrol(String kullanici_adi, String parola) {
        try {
            preparedStatement = con.prepareStatement("Select * From users where k_adi=? and parola=?");
            preparedStatement.setString(1, kullanici_adi);
            preparedStatement.setString(2, parola);
            ResultSet rs = preparedStatement.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String YetkiliCek(String kullanici_adi) {
        try {
            preparedStatement = con.prepareStatement("Select * From users where k_adi=?");
            preparedStatement.setString(1, kullanici_adi);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                return rs.getString("ad")+" "+rs.getString("soyad");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void KayitEt(String ad, String soyad, String telefon, String email, String k_adi, String parola) {
        String sorgu = "Insert Into users (ad,soyad,telefon,email,k_adi,parola) Values(?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, telefon);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, k_adi);
            preparedStatement.setString(6, parola);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AracEkle(String plaka, String marka, String model, int yil, String motor_no, String sasi, String ruhsat, String arac_tip, String kasa_tip, String sanziman, String renk, double motor_gucu, double motor_hacmi, String yakit) {
        String sorgu = "Insert Into araclar (plaka,marka,model,yil,motor_no,sasi_no,ruhsat_sahibi,arac_tip,kasa_tip,sanziman,renk,motor_guc,motor_hacim,yakit) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, plaka);
            preparedStatement.setString(2, marka);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, yil);
            preparedStatement.setString(5, motor_no);
            preparedStatement.setString(6, sasi);
            preparedStatement.setString(7, ruhsat);
            preparedStatement.setString(8, arac_tip);
            preparedStatement.setString(9, kasa_tip);
            preparedStatement.setString(10, sanziman);
            preparedStatement.setString(11, renk);
            preparedStatement.setDouble(12, motor_gucu);
            preparedStatement.setDouble(13, motor_hacmi);
            preparedStatement.setString(14, yakit);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AracDuzenle(int id, String plaka, String marka, String model, int yil, String motor_no, String sasi, String ruhsat, String arac_tip, String kasa_tip, String sanziman, String renk, double motor_gucu, double motor_hacmi, String yakit) {
        String sorgu = "Update araclar Set plaka=?,marka=?,model=?,yil=?,motor_no=?,sasi_no=?,ruhsat_sahibi=?,arac_tip=?,kasa_tip=?,sanziman=?,renk=?,motor_guc=?,motor_hacim=?,yakit=? Where arac_no=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, plaka);
            preparedStatement.setString(2, marka);
            preparedStatement.setString(3, model);
            preparedStatement.setInt(4, yil);
            preparedStatement.setString(5, motor_no);
            preparedStatement.setString(6, sasi);
            preparedStatement.setString(7, ruhsat);
            preparedStatement.setString(8, arac_tip);
            preparedStatement.setString(9, kasa_tip);
            preparedStatement.setString(10, sanziman);
            preparedStatement.setString(11, renk);
            preparedStatement.setDouble(12, motor_gucu);
            preparedStatement.setDouble(13, motor_hacmi);
            preparedStatement.setString(14, yakit);
            preparedStatement.setInt(15, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet AracCek() {
        String sorgu = "Select * From araclar";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Arac AracCek(int id) {
        String sorgu = "Select * From araclar where arac_no=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return new Arac(rs.getInt("arac_no"), rs.getString("plaka"), rs.getString("marka"), rs.getString("model"), rs.getInt("yil"), rs.getString("motor_no"), rs.getString("sasi_no"), rs.getString("ruhsat_sahibi"), rs.getString("arac_tip"), rs.getString("kasa_tip"), rs.getString("sanziman"), rs.getString("renk"), rs.getDouble("motor_guc"), rs.getDouble("motor_hacim"), rs.getString("yakit"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void AracSil(int id) {
        String sorgu = "Delete From araclar where arac_no=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] IlCek() {
        String sorgu = "Select * From iller";
        ArrayList<String> iller = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                iller.add(rs.getString("sehiradi"));
            }
            Object[] array = iller.toArray();
            String[] illerarray = Arrays.copyOf(array, array.length, String[].class);
            return illerarray;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] IlceCek(int id) {
        String sorgu = "Select * From ilceler where sehirid=?";
        ArrayList<String> ilceler = new ArrayList<>();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ilceler.add(rs.getString("ilceadi"));
            }
            Object[] array = ilceler.toArray();
            String[] ilcelerarray = Arrays.copyOf(array, array.length, String[].class);
            return ilcelerarray;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CariEkle(String musteriadi, String cariTip, String cariNo, String yetkili, String vade, String vergiNo, String vergiDairesi, String cepTel, String email, String fax, String webSitesi, String il, String ilce, String meslek, double indirimOrani, String tc) {
        String sorgu = "Insert Into cariler (musteriadi,caritip,carino,yetkili,vergino,vergidairesi,ceptel,email,fax,websitesi,il,ilce,meslek,indirimOran,vade,tc) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, musteriadi);
            preparedStatement.setString(2, cariTip);
            preparedStatement.setString(3, cariNo);
            preparedStatement.setString(4, yetkili);
            preparedStatement.setString(5, vergiNo);
            preparedStatement.setString(6, vergiDairesi);
            preparedStatement.setString(7, cepTel);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, fax);
            preparedStatement.setString(10, webSitesi);
            preparedStatement.setString(11, il);
            preparedStatement.setString(12, ilce);
            preparedStatement.setString(13, meslek);
            preparedStatement.setDouble(14, indirimOrani);
            preparedStatement.setString(15, vade);
            preparedStatement.setString(16, tc);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CariDuzenle(int id, String musteriadi, String cariTip, String cariNo, String yetkili, String vade, String vergiNo, String vergiDairesi, String cepTel, String email, String fax, String webSitesi, String il, String ilce, String meslek, double indirimOrani, String tc) {
        String sorgu = "Update cariler Set musteriadi=?,caritip=?,carino=?,yetkili=?,vergino=?,vergidairesi=?,ceptel=?,email=?,fax=?,websitesi=?,il=?,ilce=?,meslek=?,indirimOran=?,vade=?,tc=? where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, musteriadi);
            preparedStatement.setString(2, cariTip);
            preparedStatement.setString(3, cariNo);
            preparedStatement.setString(4, yetkili);
            preparedStatement.setString(5, vergiNo);
            preparedStatement.setString(6, vergiDairesi);
            preparedStatement.setString(7, cepTel);
            preparedStatement.setString(8, email);
            preparedStatement.setString(9, fax);
            preparedStatement.setString(10, webSitesi);
            preparedStatement.setString(11, il);
            preparedStatement.setString(12, ilce);
            preparedStatement.setString(13, meslek);
            preparedStatement.setDouble(14, indirimOrani);
            preparedStatement.setString(15, vade);
            preparedStatement.setString(16, tc);
            preparedStatement.setInt(17, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CariSil(int id) {
        String sorgu = "Delete  From cariler where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet CariCek() {
        String sorgu = "Select * From cariler";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cari CariCek(int id) {
        String sorgu = "Select * From cariler where id=?";
        System.out.println(id);
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new Cari(rs.getInt("id"), rs.getString("musteriadi"), rs.getString("caritip"), String.valueOf(rs.getString("carino")), rs.getString("yetkili"), rs.getString("vade"), String.valueOf(rs.getString("vergino")), rs.getString("vergidairesi"), String.valueOf(rs.getString("ceptel")), rs.getString("email"), String.valueOf(rs.getString("fax")), rs.getString("websitesi"), rs.getString("il"), rs.getString("ilce"), rs.getString("meslek"), rs.getDouble("indirimOran"), rs.getString("tc"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void IsEmriEkle(int aracId, int cariId, String isemriNO, String aracTeslimEden, String aracTeslimAlan, double girisKm, String takipDurum, String sorumluPersonel, String tarih, String saat, String aracSikayet) {
        String sorgu = "Insert Into isemirleri (aracid,cariid,isemrino,aracteslim,aracalan,giriskm,takipdurum,sorumlupersonel,tarih,saat,aracsikayet) Values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, aracId);
            preparedStatement.setInt(2, cariId);
            preparedStatement.setString(3, isemriNO);
            preparedStatement.setString(4, aracTeslimEden);
            preparedStatement.setString(5, aracTeslimAlan);
            preparedStatement.setDouble(6, girisKm);
            preparedStatement.setString(7, takipDurum);
            preparedStatement.setString(8, sorumluPersonel);
            preparedStatement.setString(9, tarih);
            preparedStatement.setString(10, saat);
            preparedStatement.setString(11, aracSikayet);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void IsEmriDuzenle(int id, int aracId, int cariId, String isemriNO, String aracTeslimEden, String aracTeslimAlan, double girisKm, String takipDurum, String sorumluPersonel, String tarih, String saat, String aracSikayet) {
        String sorgu = "Update isemirleri Set aracid=?,cariid=?,isemrino=?,aracteslim=?,aracalan=?,giriskm=?,takipdurum=?,sorumlupersonel=?,tarih=?,saat=?,aracsikayet=? where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(1, aracId);
            preparedStatement.setInt(2, cariId);
            preparedStatement.setString(3, isemriNO);
            preparedStatement.setString(4, aracTeslimEden);
            preparedStatement.setString(5, aracTeslimAlan);
            preparedStatement.setDouble(6, girisKm);
            preparedStatement.setString(7, takipDurum);
            preparedStatement.setString(8, sorumluPersonel);
            preparedStatement.setString(9, tarih);
            preparedStatement.setString(10, saat);
            preparedStatement.setString(11, aracSikayet);
            preparedStatement.setInt(12, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void TakipDuzenle(int id,String takipd){
        String sorgu = "Update isemirleri Set takipdurum=? where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, takipd);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void IsEmriSil(int id) {
        String sorgu = "Delete  From isemirleri where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet IsEmirleriCek() {
        String sorgu = "Select * From isemirleri";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            ResultSet rs = preparedStatement.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public IsEmri IsEmriCek(int id) {
        String sorgu = "Select * From isemirleri where id=?";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                return new IsEmri(rs.getInt("id"), rs.getInt("aracid"), rs.getInt("cariid"), rs.getString("isemrino"), rs.getString("aracteslim"), rs.getString("aracalan"), rs.getDouble("giriskm"), rs.getString("takipdurum"), rs.getString("sorumlupersonel"), rs.getString("tarih"), rs.getString("saat"), rs.getString("aracsikayet"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void HasarEkle(int aracid, Hasar hasar) {
        Hasarlar hasarlar=new Hasarlar();
        Hasar arachasar = hasarlar.HasarBelirle(hasar);
        String sorgu = "Insert Into hasarlar (aracid,hasartur,maliyet,iscilik,hasartarih,hasaryer,aciklama) Values(?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, aracid);
            preparedStatement.setString(2, arachasar.getHasarturu());
            preparedStatement.setDouble(3, arachasar.getMaliyet());
            preparedStatement.setDouble(4, arachasar.getIscilik());
            preparedStatement.setString(5, arachasar.getHasartarih());
            preparedStatement.setString(6, arachasar.getHasaryeri());
            preparedStatement.setString(7, arachasar.getAciklama());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void HasarDuzenle(int hasarid , Hasar hasar) {
     Hasarlar hasarlar=new Hasarlar();
    Hasar arachasar = hasarlar.HasarBelirle(hasar);
    String sorgu = "Update hasarlar Set hasartur=?,maliyet=?,iscilik=?,hasartarih=?,hasaryer=?,aciklama=? Where hasarid=?";
        try
    {   preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setString(1, arachasar.getHasarturu());
        preparedStatement.setDouble(2, arachasar.getMaliyet());
        preparedStatement.setDouble(3, arachasar.getIscilik());
        preparedStatement.setString(4, arachasar.getHasartarih());
        preparedStatement.setString(5, arachasar.getHasartarih());
        preparedStatement.setString(6, arachasar.getAciklama());
        preparedStatement.setInt(7,HasarPanel.getHasarid());
        preparedStatement.executeUpdate();
    } catch(SQLException e)
    {
        throw new RuntimeException(e);
    }
}

public void HasarSil(int hasarid){
    String sorgu = "Delete  From hasarlar where hasarid=?";
    try {
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setInt(1, hasarid);
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }

public ResultSet HasarlariCek(int id){
    String sorgu = "Select * From hasarlar where aracid=?";
    try {
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setInt(1,id);
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

public Hasar HasarCek(int hasarid){
        Hasarlar hasarlar=new Hasarlar();
    String sorgu = "Select * From hasarlar where hasarid=?";
    try {
        preparedStatement = con.prepareStatement(sorgu);
        preparedStatement.setInt(1, hasarid);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            return  hasarlar.HasarBelirle(rs.getInt("hasarid"),rs.getString("aciklama"),rs.getDouble("maliyet"),rs.getDouble("iscilik"),rs.getString("hasartur"),rs.getString("hasartarih"),rs.getString("hasaryer"));
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return null;
  }
}
