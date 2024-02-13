import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HasarTakipSistemi extends JFrame implements ActionListener {
    private JLabel k_adi;
    private JLabel passaword;
    private JButton giris;
    private JButton register;
    private JTextField k_adi_alan;
    private JPasswordField passaword_alan;
    private static String yetkili;
//kullanıcı adı:admin
    //Paralo:admin
    public HasarTakipSistemi(String title) throws HeadlessException {
        super(title);
        String resim_yolu="1.png";
        ImageIcon arkaplan=new ImageIcon(resim_yolu);
        JLabel label=new JLabel(arkaplan);
        setContentPane(label);
        k_adi=new JLabel("Kullanıcı Adı");
        k_adi.setBounds(320,200,120,30);
        k_adi.setForeground(Color.WHITE);
        k_adi.setFont(new Font("Arial",Font.BOLD,16));
        passaword=new JLabel("Parola");
        passaword.setBounds(320,230,120,30);
        passaword.setForeground(Color.WHITE);
        passaword.setFont(new Font("Arial",Font.BOLD,16));
        k_adi_alan=new JTextField();
        k_adi_alan.setBounds(430,208,150,20);
        passaword_alan=new JPasswordField();
        passaword_alan.setBounds(430,238,150,20);
        giris=new JButton("Giriş Yap");
        giris.setBounds(340,280,100,30);
        giris.setFont(new Font("Arial",Font.BOLD,14));
        giris.addActionListener(this);
        setBounds(250,80,640,500);
        register=new JButton("Kayıt Et");
        register.setBounds(460,280,100,30);
        register.setFont(new Font("Arial",Font.BOLD,14));
        register.addActionListener(this);


        add(k_adi);add(passaword);add(k_adi_alan);add(passaword_alan);add(giris);add(register);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        VeriTabani veriTabani=new VeriTabani();
        if(e.getSource()==giris){
            if(veriTabani.adminKontrol(k_adi_alan.getText(), String.valueOf(passaword_alan.getPassword()))){
                JOptionPane.showMessageDialog(this,"Giriş Başaralı");
                yetkili=veriTabani.YetkiliCek(k_adi_alan.getText());
                setVisible(false);
                new Arayuz();
            }
            else{
                JOptionPane.showMessageDialog(this,"Giriş Başarısız...");
            }
        }
        if(e.getSource()==register){
            new Kayit();

        }


        k_adi_alan.setText("");
        passaword_alan.setText("");
    }

    public static void main(String[] args){
        new HasarTakipSistemi("Hasar Takip Sistemi");
    }

    public static String getYetkili() {
        return yetkili;
    }
}
