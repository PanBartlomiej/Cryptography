import java.util.Random;

public class Zad3 {
    public static void main(String[] args){
        int[] L1={0,0,0,0};
        int[] L2={0,0,0,0};
        int[][] count = new int[16][16];
        for(int i=0; i<16; i++ ){
            for(int j=0;j<16;j++){
                count[i][j]=0;
            }
        }
        Random random = new Random();
        byte[] Key = {0x3, 0xA, 0x9, 0x4, 0xD, 0x6, 0x3, 0xF};
        int[][][] x= new int[8000][4][4];
        int xTmp;
        int[] xTmpTab = new int[4];
        int[][] y= new int[8000][4];
        for(int i=0; i<8000; i++){
            for(int j=0; j<4; j++){
                xTmp = (random.nextInt()%16+16)%16;
                x[i][j]= intToBitArray(xTmp);
                xTmpTab[j] = xTmp;
            }
            y[i] = Encrypt(Key, xTmpTab);
        }
       int[] PI_S = {0xE,3,4,8,1,0xC,0xA,0xF,7,0xD,9,6,0xB,2,0,5};


        int[] v4 = {0,0,0,0};
        int[] v2 = {0,0,0,0};
        int[] u2 = {0,0,0,0};
        int[] u4 = {0,0,0,0};
        int z=0;


        String strA = "0";
        String strB = "0";
        int v2Temp =0;
        int v4Temp =0;
        for(int r=0; r<8000;r++) {
            strB="0";
            for (int l = 0; l < 16; l++) {

                strA = "0";
                L1 = intToBitArray(Integer.parseInt(strB));
                for(int k=0; k<16;k++) {
                    //System.out.println(strB+"   "+strA);
                    L2 = intToBitArray(Integer.parseInt(strA));

                    int[] yTempo1 = intToBitArray(y[r][1]);
                    int[] yTempo2 = intToBitArray(y[r][3]);

                    for (int j = 0; j < 4; j++) {
                        v2[j] = L1[j] ^ yTempo1[j];
                        v4[j] = L2[j] ^ yTempo2[j];
                    }
                  //  System.out.println();
                    v2Temp=bitArrayToInt(v2);
                    v4Temp=bitArrayToInt(v4);
                    int u2Temp = PI_S[v2Temp];
                    int u4Temp = PI_S[v4Temp];
                     //   System.out.println(u2Temp);
                    u2=intToBitArray(u2Temp);
                    u4=intToBitArray(u4Temp);
                   // System.out.println(x[r][1][0]+"  "+x[r][1][2]+"  "+x[r][1][3]+"  "+u2[1]+"  "+u4[1]);
                    z = (x[r][1][0] ^ x[r][1][2] )^( x[r][1][3] ^ u2[1]) ^ u2[3] ^ u4[1] ^ u4[3];
                    if (z == 0) {
                        count[l][k] ++;
                       // System.out.println(strB+" "+ strA);
                    }
                    strA = "" + (Integer.parseInt(strA) + 1);
                }
                strB = "" + (Integer.parseInt(strB) + 1);

            }
        }
        int max=-1;
        int maxL1 = 0;
        int maxL2 = 0;
        for(int i=0; i<16; i++) {
            for (int j = 0; j < 16; j++) {
                count[i][j] = Math.abs(count[i][j] - 8000 / 2);
                if(count[i][j]>max) {
                    max = count[i][j];
                    maxL1= i;
                    maxL2 = j;
                   // System.out.println(max);

                }
            }
        }
       // System.out.println("max count="+max);
        System.out.println("Znalezione fragmenty klucza: ");
        int[] tmp =intToBitArray(maxL1);
        int[] tmp2 = intToBitArray(maxL2);
        for(int i=0; i<4 ;i++){
            System.out.print(tmp[i]);
        }
        System.out.print(" ");
        for(int i=0; i<4 ;i++){
            System.out.print(tmp2[i]);
        }

    }
    public static int bitArrayToInt(int[] bitArray) {
        int result = 0;
        for (int bit : bitArray) {
            //System.out.print(bit);
            result = (result << 1) | bit;
        }
      //  System.out.println();
        return result;
    }
    public static int[] intToBitArray(int number) {
        int[] bitArray = new int[4];
        for (int i = 3; i >= 0; i--) {
            bitArray[i] = (number & 1);
            number >>= 1;
        }
        return bitArray;
    }
    public static int[] Encrypt(byte[] Key_, int[] x){
      //  System.out.println();
        byte[] Key = new byte[Key_.length];

        for (int i = 0; i < Key_.length; i++) {
            Key[i] = Key_[i];
        }
        int[] w = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            w[i] = x[i];
        }
        int m=4;
        int[] u= new int[m];
        int[] v= new int[m];
        int N=4;
        int[] PI_S = {0xE,0x4,0xD,0x1,0x2,0xF,0xB,0x8,0x3,0xA,0x6,0xC,0x5,0x9,0x0,0x7};
        int[] PI_P = {1,5,9,13,2,6,10,14,3,7,11,15,4,8,12,16};
        int l=4;
//        System.out.print("x: ");
//        for(int i=0;i<x.length;i++)
//            printBits(x[i]);
        for( int r=0; r < N-1; r++) {
            //  System.out.print("\nK" + (r + 1) + ": ");
            for (int j = 0; j < l; j++) { // tu l ?????
                //       printBits(Key[j+r]);
            }
            //System.out.print("\nu" + (r + 1) + ": ");
            for (int j = 0; j < l; j++) { // tu l ?????
                u[j] = w[j] ^ Key[j+r];
                //     printBits(u[j]);
            }
            // System.out.print("\nv" + (r + 1) + ": ");
            for (int i = 0; i < m; i++) {
                v[i] = PI_S[u[i]];
                //   printBits(v[i]);
            }

            int[] allBits= new int[16];

            //System.out.print("\nw"+(r+1)+": ");
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
                //  printBits(w[j]);
            }
            //   System.out.println();
        }
        //     System.out.print("\nK" + (N) + ": ");
        for (int j = 0; j < l; j++) { // tu l ?????
            //     printBits(Key[j+N-1]);
        }
        //     System.out.print("\nu" + (N ) + ": ");
        for (int j = 0; j < l; j++) { // tu l ?????
            u[j] = w[j] ^ Key[j+N-1];
            //   printBits(u[j]);
        }
        //   System.out.print("\nv" + (N ) + ": ");
        for (int i = 0; i < m; i++) {
            v[i] = PI_S[u[i]];
            //  printBits(v[i]);
        }
        // System.out.print("\n\nK" + (N + 1) + ": ");
        for (int j = 0; j < l; j++) { // tu l ?????
            //  printBits(Key[j+N]);
        }

      //  System.out.println();
      //  System.out.print("y"  + ": ");
        int[] y = new int[4];
        for (int j = 0; j < l; j++) { // tu l ?????
            y[j] = v[j] ^ Key[j+N];
        //    printBits(y[j]);
        }
     //   System.out.println();
        return y;
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
