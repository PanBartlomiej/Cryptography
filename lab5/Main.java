import java.util.BitSet;

public class Main {
    public static void main(String[] args) {

        byte[] Key = {0x3, 0xA, 0x9,0x4,0xD,0x6,0x3,0xF};
        int[] x={2,6,11,7};
        int[] w= {0x2,0x6,0xB,0x7};

        int m=4;
        int[] u= new int[m];
        int[] v= new int[m];
        int N=4;
        int[] PI_S = {0xE,0x4,0xD,0x1,0x2,0xF,0xB,0x8,0x3,0xA,0x6,0xC,0x5,0x9,0x0,0x7};
        int[] PI_P = {1,5,9,13,2,6,10,14,3,7,11,15,4,8,12,16};
        int l=4;
        for( int r=0; r < N-1; r++) {


            System.out.print("\nK" + (r + 1) + ": ");
            for (int j = 0; j < l; j++) { // tu l ?????
                printBits(Key[j+r]);
            }
            System.out.print("\nu" + (r + 1) + ": ");
            for (int j = 0; j < l; j++) { // tu l ?????
                u[j] = w[j] ^ Key[j+r];
                printBits(u[j]);
            }
            System.out.print("\nv" + (r + 1) + ": ");
            for (int i = 0; i < m; i++) {
                v[i] = PI_S[u[i]];
                printBits(v[i]);
            }

            int[] allBits= new int[16];

            System.out.print("\nw"+(r+1)+": ");
            for(int j=0; j< m ;j++) {
                int numBits = 4;
                int[] bits = new int[numBits];

                for (int i = 0; i < 4; i++) {
                    bits[i] = (v[j] >> i) & 1;
                }

                int length = bits.length;
                int[] reversedBits = new int[length];

                for (int i = 0; i < length; i++) {
                    reversedBits[i] = bits[length - i - 1];
                    allBits[j*4+i] = reversedBits[i];
                }
            }
            int[] allBits2 = new int[16];
                for (int j=0;j <16; j++) {
                    allBits2[j] = allBits[(PI_P[j] - 1)];
            }
            for (int j=0; j<4; j++) {
                int result = 0;
                for (int i = 0 ;i < 4; i++) {
                    result = (result << 1) | allBits2[j*4+i];
                }
                w[j] = result;
                printBits(w[j]);
            }
            System.out.println();
        }
        System.out.print("\nK" + (N) + ": ");
        for (int j = 0; j < l; j++) { // tu l ?????
            printBits(Key[j+N-1]);
        }
        System.out.print("\nu" + (N ) + ": ");
        for (int j = 0; j < l; j++) {
            u[j] = w[j] ^ Key[j+N-1];
            printBits(u[j]);
        }
        System.out.print("\nv" + (N ) + ": ");
        for (int i = 0; i < m; i++) {
            v[i] = PI_S[u[i]];
            printBits(v[i]);
        }
        System.out.print("\n\nK" + (N + 1) + ": ");
        for (int j = 0; j < l; j++) { 
            printBits(Key[j+N]);
        }
        System.out.print("\n\ny"  + ": ");
        int[] y = new int[4];
        for (int j = 0; j < l; j++) { 
            y[j] = v[j] ^ Key[j+N];
            printBits(y[j]);
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
