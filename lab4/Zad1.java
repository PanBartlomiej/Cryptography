public class Zad1 {
    public static void main(String[] args) {

        String key="Secret";
        String Plaintext= "Attack at dawn";

        Encrypt(Plaintext,key);
        Encrypt("Plaintext","Key");
        Encrypt("pedia","Wiki");
    }

    public static void Encrypt(String Plaintext,String key){
        char[] resultArray= Stream_Generator(Plaintext,KEY(key.toCharArray()));
        System.out.println("\nPlaintext: "+Plaintext);
        System.out.println("Key: "+key);
        System.out.print("Ciphertext: ");
        for (int x=0; x< Plaintext.length(); x++) {
            String hexString = Integer.toHexString(resultArray[x]);
            System.out.print(hexString.toUpperCase()+ " ");

        }
        System.out.println("\n");
    }

    public static int[] KEY(char[] key){

        int[] S = new int[256];
        for(int i=0; i < 256; i++){
            S[i] =i;
        }
        int j=0;
        for(int i=0; i<256;i++){
            j = (j +S[i]+ key[i%key.length])%256;
            Integer tmp=S[i];
            S[i]=S[j];
            S[j]=tmp.intValue();
        }
        return  S;
    }
    public static char[] Stream_Generator(String Plaintext,int[] S){
     int i=0;
     int j=0;
     int byte_key=0;
     String result_ciphered="";
     char[] charArray1 = Plaintext.toCharArray();
     char[] resultArray = new char[charArray1.length];
     int k=0;
     System.out.print("KeyStream: ");
     while(k<charArray1.length){
         i = (i+1)%256;
         j= (j+S[i])%256;
         Integer tmp=S[i];
         S[i]=S[j];
         S[j]=tmp.intValue();

         byte_key= S[(S[i]+S[j])%256];

         String hexString = Integer.toHexString(byte_key);
         System.out.print(hexString.toUpperCase()+ " ");
         resultArray[k] = (char) (charArray1[k] ^byte_key);
         k++;
     }

        return resultArray;
    }

}