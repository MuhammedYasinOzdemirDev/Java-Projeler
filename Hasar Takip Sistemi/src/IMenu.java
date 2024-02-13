import java.sql.SQLException;

public interface IMenu {
    void Ekle();
    void Sil();
    void Duzenle();
    void Yenile ();
    void Arama(String deger,int index);
    default void Kapat() {
        System.exit(0);
    }
}
