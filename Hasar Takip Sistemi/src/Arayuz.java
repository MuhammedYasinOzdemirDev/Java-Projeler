import javax.swing.*;
import java.awt.*;

public class Arayuz {
    private static JFrame frame;
    public Arayuz(){
         frame=new JFrame("Hasar Takip Sistemi");
        JTabbedPane tabbedPane=new JTabbedPane();
        Anasayfa anasayfa=new Anasayfa();
        CariPanel cari=new CariPanel();
        AracTakip aracTakip=new AracTakip();
        tabbedPane.addTab("Anasayfa",anasayfa);
        tabbedPane.addTab("Cari",cari);
        tabbedPane.addTab("Araç Takip",aracTakip);
        frame.setResizable(false);
        frame.setBounds(5,0,1540,910);
        tabbedPane.setBackground(Color.LIGHT_GRAY);
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static JFrame getFrame() {
        return frame;
    }
}
