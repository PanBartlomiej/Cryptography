public class Zad1 {
    public static void main(String[] args){

        int[] PI_S = {0xE,0x4,0xD,0x1,0x2,0xF,0xB,0x8,0x3,0xA,0x6,0xC,0x5,0x9,0x0,0x7};

        int x_Prime = 11;
        int[] x ={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] x_gwiazda= new int[16];
        for(int i=0; i< x.length;i++){
            x_gwiazda[i] =x[i]^x_Prime;
        }
        int[] y = new int[16];
        int[] y_gwiazda = new int[16];
        int[] y_Prime = new int[16];
        for (int i = 0; i < 16; i++) {
            y[i] = PI_S[x[i]];
             // printBits(y[i]);
        }
        for (int i = 0; i < 16; i++) {
            y_gwiazda[i] = PI_S[x_gwiazda[i]];
            y_Prime[i] = y[i]^y_gwiazda[i];
        }
        int[] XOR =new int[16];
        for(int i=0;i<16;i++)
            XOR[i]=0;
        for(int j=0; j<16;j++)
            for(int i=0;i<16;i++){
                if(y_Prime[j] ==i)
                    XOR[i]++;
        }

        System.out.println("      x|   x*|    y|   y*|  y'");
        for(int i=0; i<16; i++){
            System.out.print(Integer.toHexString(i).toUpperCase()+":");
            printBits(x[i]);
            System.out.print("|");
            printBits(x_gwiazda[i]);

            System.out.print("|");
            printBits(y[i]);

            System.out.print("|");
            printBits(y_gwiazda[i]);

            System.out.print("|");
            printBits(y_Prime[i]);
            System.out.println();
        }

        System.out.println();
        for(int i =0; i<16;i++){
            printBits(i);
        }
        System.out.println();
        for(int i =0; i<16;i++){
            System.out.print("  "+XOR[i]+"  ");
        }
    }
    public static void printBits(int number) {
        int numBits = 4;
        for (int i = numBits - 1; i >= 0; i--) {
            int bit = (number >> i) & 1;
            System.out.print(bit);
        }
        System.out.print(" ");
    }
}
