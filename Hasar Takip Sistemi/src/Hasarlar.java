public class Hasarlar {
    private static  String[]  hasarlar={"Ön Hasar","Arka Hasar","Yan Hasar","Motor Hasar","Jant Hasar","Boya Hasar","Ön Kaput Hasar","Arka Kaput Hasar","İç Hasar","Elektronik Hasar"};
    public static String[] getHasarlar() {
        return hasarlar;
    }
    public Hasar HasarBelirle(Hasar hasar) {

        if (hasar instanceof Hasarlar.OnHasar) {
           Hasarlar.OnHasar h= (OnHasar) hasar;
           return h;
        } else if (hasar instanceof Hasarlar.ArkaHasar) {
            Hasarlar.ArkaHasar h=(Hasarlar.ArkaHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.OnKaputHasar) {
            Hasarlar.OnKaputHasar h= (Hasarlar.OnKaputHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.YanHasar) {
            Hasarlar.YanHasar h= (Hasarlar.YanHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.JantHasar) {
            Hasarlar.JantHasar h= (Hasarlar.JantHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.BoyaHasar) {
           Hasarlar.BoyaHasar h=(Hasarlar.BoyaHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.ArkaKaput) {
            Hasarlar.ArkaKaput h= (Hasarlar.ArkaKaput) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.IcHasar) {
            Hasarlar.IcHasar h= (Hasarlar.IcHasar) hasar;
        } else if (hasar instanceof Hasarlar.ElektronikHasar) {
            Hasarlar.ElektronikHasar h= (Hasarlar.ElektronikHasar) hasar;
            return h;
        } else if (hasar instanceof Hasarlar.MotorHasar) {
            Hasarlar.MotorHasar h=(Hasarlar.MotorHasar) hasar;
            return h;
        }
        return null;
    }
    public Hasar HasarBelirle(int id,String aciklama,double maliyet,double iscilik ,String hasartur,String hasartarih,String hasaryer){
        if(hasartur.equals("Ön Hasar")){
            return new Hasarlar.OnHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Arka Hasar")) {
            return new Hasarlar.ArkaHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Yan Hasar")) {
            return new Hasarlar.YanHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Jant Hasar")) {
            return new Hasarlar.JantHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Boya Hasar")) {
            return new Hasarlar.BoyaHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Ön Kaput Hasar")) {
            return new Hasarlar.OnKaputHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);

        } else if (hasartur.equals("Arka Kaput Hasar")) {
            return new Hasarlar.ArkaKaput(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("İç Hasar")) {
            return new Hasarlar.IcHasar(id,aciklama ,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Elektronik Hasar")) {
            return new Hasarlar.ElektronikHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Motor Hasar")) {
            return new Hasarlar.MotorHasar(id,aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else{
            return null;
        }
    }
    public Hasar HasarBelirle(String hasartur,double maliyet,double iscilik ,String hasartarih,String hasaryer,String aciklama){

        if(hasartur.equals("Ön Hasar")){
            return new Hasarlar.OnHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Arka Hasar")) {
            return new Hasarlar.ArkaHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Yan Hasar")) {
            return new Hasarlar.YanHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Jant Hasar")) {
            return new Hasarlar.JantHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Boya Hasar")) {
            return new Hasarlar.BoyaHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        } else if (hasartur.equals("Ön Kaput Hasar")) {
            return new Hasarlar.OnKaputHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);

        } else if (hasartur.equals("Arka Kaput Hasar")) {
            return new Hasarlar.ArkaKaput(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("İç Hasar")) {
            return new Hasarlar.IcHasar(aciklama ,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Elektronik Hasar")) {
            return new Hasarlar.ElektronikHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else if (hasartur.equals("Motor Hasar")) {
            return new Hasarlar.MotorHasar(aciklama,maliyet,iscilik,hasartur,hasartarih,hasaryer);
        }
        else{
            return null;
        }
    }
    public static class OnHasar extends Hasar{
        public OnHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public OnHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tÖn Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return hasarturu;
        }

    }
    public static class ArkaHasar extends Hasar{


        public ArkaHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public ArkaHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tArka Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Arka Hasar";
        }

    }
    public static class YanHasar extends Hasar{
        public YanHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public YanHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tYan Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Yan Hasar";
        }
    }
    public static class MotorHasar extends Hasar{
        public MotorHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public MotorHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tMotor Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Motor Hasar";
        }

    }
    public static class JantHasar extends Hasar{
        public JantHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public JantHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tJant Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Jant Hasar";
        }
    }
    public static class BoyaHasar extends Hasar{
        public BoyaHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public BoyaHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tBoya Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return 1200;
        }

        @Override
        public double getIscilik() {
            return 350;
        }

        @Override
        public String getHasarturu() {
            return "Boya Hasar";
        }
    }
    public static class OnKaputHasar extends Hasar{
        public OnKaputHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public OnKaputHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tÖn Kaput Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Ön Kaput Hasar";
        }
    }
    public static class ArkaKaput extends Hasar{
        public ArkaKaput(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public ArkaKaput(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tArka Kaput Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return 1400;
        }

        @Override
        public double getIscilik() {
            return 950;
        }

        @Override
        public String getHasarturu() {
            return "Arka Kaput Hasar";
        }
    }
    public static class IcHasar extends Hasar{
        public IcHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public IcHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tİç Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "İç Hasar";
        }
    }
    public static class ElektronikHasar extends Hasar{
        public ElektronikHasar(String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        public ElektronikHasar(int hasarid, String aciklama, double maliyet, double iscilik, String hasarturu, String hasartarih, String hasaryeri) {
            super(hasarid, aciklama, maliyet, iscilik, hasarturu, hasartarih, hasaryeri);
        }

        @Override
        public String getAciklama() {
            return "\tElekronik Hasar\n"+this.aciklama;
        }

        @Override
        public double getMaliyet() {
            return maliyet;
        }

        @Override
        public double getIscilik() {
            return iscilik;
        }

        @Override
        public String getHasarturu() {
            return "Elektronik Hasar";
        }
    }

}
