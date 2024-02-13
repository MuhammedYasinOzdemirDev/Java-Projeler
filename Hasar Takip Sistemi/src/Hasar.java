import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class Hasar {
    protected String aciklama;
    protected double maliyet;
    protected String hasartarih;
    protected String hasaryeri;
    protected double iscilik;
    protected  String hasarturu;
    protected int hasarid;
    protected int aracid=-1;
    public Hasar(String aciklama, double maliyet,double iscilik,String hasarturu ,String hasartarih, String hasaryeri) {
        this.aciklama = aciklama;
        this.maliyet = maliyet;
        this.hasartarih = hasartarih;
        this.hasaryeri = hasaryeri;
        this.iscilik=iscilik;
        this.hasarturu=hasarturu;
    }
    public Hasar(int hasarid,String aciklama, double maliyet,double iscilik,String hasarturu ,String hasartarih, String hasaryeri) {
        this.hasarid=hasarid;
        this.aciklama = aciklama;
        this.maliyet = maliyet;
        this.hasartarih = hasartarih;
        this.hasaryeri = hasaryeri;
        this.iscilik=iscilik;
        this.hasarturu=hasarturu;
    }
    public abstract String getAciklama();
    public abstract double getMaliyet();
    public abstract double getIscilik();
    public abstract  String getHasarturu();


    public String getHasartarih() {
        return hasartarih;
    }

    public void setHasartarih(String hasartarih) {
        this.hasartarih = hasartarih;
    }

    public String getHasaryeri() {
        return hasaryeri;
    }

    public void setHasaryeri(String hasaryeri) {
        this.hasaryeri = hasaryeri;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public void setMaliyet(double maliyet) {
        this.maliyet = maliyet;
    }

    public void setIscilik(double iscilik) {
        this.iscilik = iscilik;
    }

    public void setHasarturu(String hasarturu) {
        this.hasarturu = hasarturu;
    }

    public int getHasarid() {
        return hasarid;
    }

    public void setHasarid(int hasarid) {
        this.hasarid = hasarid;
    }

    public int getAracid() {
        return aracid;
    }

    public void setAracid(int aracid) {
        this.aracid = aracid;
    }
}
