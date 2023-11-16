import javax.swing.*;
import java.util.ArrayList;

public class Zadanie2 {
    public static void main(String[] args){
        String PlainText="011001111111000";
        ArrayList<Integer> keyStream = new ArrayList<>();
        // for(int j=0; j<16;j++){
        keyStream.add(1);
        keyStream.add(1);
        keyStream.add(0);
        keyStream.add(1);
        keyStream.add(0);
        //}
        for (int i = 5; i < PlainText.length(); i++) {
            keyStream.add((keyStream.get(i - 5) + keyStream.get(i - 3)) % 2);
        }
        String key = "";
        for (Integer i : keyStream) {
            key = key + i;
        }
        System.out.println("Encryption");

        System.out.println("PlainText: "+PlainText);
        System.out.println("KeyStream: "+ key);

        String Cryphertext="";



        for(int i=0;i<PlainText.length();i++){

            Cryphertext +=  (PlainText.charAt(i)-48 +  keyStream.get(i))%2;
        }
        System.out.println("Cryphertext: "+Cryphertext)
        ;
        System.out.println("Decryption");


        String P2 ="";


        for(int i=0;i<PlainText.length();i++){

            P2 +=  ((PlainText.charAt(i)-48 -  keyStream.get(i))%2+2)%2;
        }

        System.out.println("Cryphertext: "+Cryphertext);
        System.out.println("KeyStream: "+ key);
        System.out.println("PlainText: "+P2);




    }
}
