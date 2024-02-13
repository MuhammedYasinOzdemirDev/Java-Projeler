import java.util.ArrayList;

public class HataYakalayici extends  Exception{
    private static ArrayList<String> mesajlar;
    private static String m;
    public HataYakalayici(String s) {
        super(s);
    }

    public HataYakalayici() {
        mesajlar=new ArrayList<>();
    }

    public static String Getir(){

        m="";
        for(String mesaj:mesajlar){
            m+=mesaj+"\n";
        }
        return m;
    }

    public static ArrayList<String> getMesajlar() {
        return mesajlar;
    }
}
