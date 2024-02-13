import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kayit extends JFrame implements ActionListener {
    private JTextField k_adi_alan = new JTextField();
    private JLabel k_adi = new JLabel("Kullanıcı Adı");
    private JPasswordField parola_alan = new JPasswordField();
    private JLabel parola = new JLabel("Parola");
    private JPasswordField tparola_alan = new JPasswordField();
    private JLabel tparola = new JLabel("Tekrar Parola");
    private JTextField ad_alan = new JTextField();
    private JLabel ad = new JLabel("Ad");
    private JTextField soyad_alan = new JTextField();
    private JLabel soyad = new JLabel("Soyad");
    private JTextField telefon_alan = new JTextField();
    private JLabel telefon = new JLabel("Telefon");
    private JTextField email_alan = new JTextField();
    private JLabel email = new JLabel("Email");
    private JButton kaydet = new JButton("Kaydet");
    private JButton iptal = new JButton("İptal");
    private Font font = new Font("Arial", Font.BOLD, 14);
    public Kayit() throws HeadlessException {
        super("Kayıt Ekranı");
        ImageIcon imageIcon = new ImageIcon("1.png");
        JLabel label = new JLabel(imageIcon);
        setContentPane(label);

        ad.setBounds(320, 120, 120, 25);
        ad.setFont(font);
        ad.setForeground(Color.WHITE);
        soyad.setBounds(320, 150, 120, 25);
        soyad.setFont(font);
        soyad.setForeground(Color.WHITE);
        k_adi.setBounds(320, 180, 120, 25);
        k_adi.setFont(font);
        k_adi.setForeground(Color.WHITE);
        telefon.setBounds(320, 210, 120, 25);
        telefon.setFont(font);
        telefon.setForeground(Color.WHITE);
        email.setBounds(320, 240, 120, 25);
        email.setFont(font);
        email.setForeground(Color.WHITE);
        parola.setBounds(320, 270, 120, 25);
        parola.setFont(font);
        parola.setForeground(Color.WHITE);
        tparola.setBounds(320, 300, 120, 25);
        tparola.setFont(font);
        tparola.setForeground(Color.WHITE);

        ad_alan.setBounds(440, 120, 160, 20);
        soyad_alan.setBounds(440, 150, 160, 20);
        k_adi_alan.setBounds(440, 180, 160, 20);
        telefon_alan.setBounds(440, 210, 160, 20);
        email_alan.setBounds(440, 240, 160, 20);
        parola_alan.setBounds(440, 270, 160, 20);
        tparola_alan.setBounds(440, 300, 160, 20);

        kaydet.setBounds(500, 340, 100, 30);
        kaydet.setFont(font);

        kaydet.addActionListener(this);
        iptal.setBounds(380,340,100,30);
        iptal.setFont(font);

        iptal.addActionListener(this);


        add(k_adi);
        add(parola);
        add(ad);
        add(soyad);
        add(telefon);
        add(email);
        add(tparola);
        add(ad_alan);
        add(soyad_alan);
        add(k_adi_alan);
        add(telefon_alan);
        add(email_alan);
        add(parola_alan);
        add(tparola_alan);
        add(kaydet);
        add(iptal);

        setBounds(300, 200, 640, 500);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==kaydet){
            if(String.valueOf(tparola_alan.getPassword()).equals(String.valueOf(parola_alan.getPassword()))){
                VeriTabani veriTabani=new VeriTabani();
                veriTabani.KayitEt(ad_alan.getText(),soyad_alan.getText(),telefon_alan.getText(),email_alan.getText(),k_adi_alan.getText(), String.valueOf(parola_alan.getPassword()));
                JOptionPane.showMessageDialog(this,ad_alan.getText()+" isimli kullanıcı kaydedildi...");
            }
            else{
                JOptionPane.showMessageDialog(this,"Parolo uyumsuz");
            }
        }
        if(e.getSource()==iptal){
            setVisible(false);
        }
    }




}
