public interface IIsEmriKontrol {
    boolean TarihKontrol(String tarih);
    boolean SaatKontrol(String saat);
    boolean KmKontrol(String km);
    String[] takipDurumlari={"Başlamadı", "Devam Ediyor", "Tamamlandı", "Beklemede", "Ertelendi", "İptal Edildi"};;
}
