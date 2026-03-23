import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner input = new Scanner (System.in);
        CaesarCipher myCipher = new CaesarCipher("Rahasia", 3);
        

        System.out.println("==Selamat Datang Di Secret Diary==");
        System.out.println("1. Rahasiakan Diaryku");
        System.out.println("2. Baca Diaryku");
        String pilihan = input.nextLine();

        System.out.println("Langsung copas text yang kamu ingin rahasiakan atau ingin baca ya <3\n");
        String text = input.nextLine();
       
        if (pilihan.equals("1")){
            myCipher.process(text);
            String encrypted = myCipher.encrypt(text);
            System.out.println("\nBerhasil merahasiakan diarymu: \n" + encrypted);
        }else if (pilihan.equals("2")){
            myCipher.process(text);
            String decrypted = myCipher.decrypt(text);
            System.out.println("\nBerhasil mengconversi diarymu: \n" + decrypted);
        }else {
            System.out.println("Kamu salah input");
            System.out.println("Pilih yang bener sayang <3");
        }
        input.close();

    }
}

abstract class Encryption{
    protected String name;
    protected encryptionProcess encryptionProcess;
    protected basicEnrypt basicEnrypt = new basicEnrypt();

    public Encryption(String n){
        this.name = n;
        this.encryptionProcess = new basicEnrypt();
    }

    public String getName(){
        return name;
    }
    public void process(String text){
        encryptionProcess.process(text);
    }

    abstract String encrypt(String text);
    abstract String decrypt(String text);



}

interface encryptionProcess {
    void process(String text);
}

class basicEnrypt implements encryptionProcess {
    @Override
    public void process(String text){
        System.out.println("Processing text: " + text);
    }
}

class CaesarCipher extends Encryption {
    private int shift;

    public CaesarCipher(String name, int shift){
        super(name);
        this.shift = shift;
    }

    @Override
    String encrypt(String text){
        String hasil = "";

        for(int i = 0; i < text.length(); i++){
            hasil += (char)(text.charAt(i) + shift);
        }
        return hasil;
    }

    @Override
    String decrypt(String text){
        String hasil = "";

        for(int i = 0; i < text.length(); i++){
            hasil += (char)(text.charAt(i) - shift);
        }
        return hasil;
    }
}
