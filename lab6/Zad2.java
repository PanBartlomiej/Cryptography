public class Zad2 {
    public static void main(String[] args) {
        int[][] x1 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        int[][] x2 = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}};
        int[][] x3 = {{0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        int[][] x4 = {{0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 1}, {0, 1, 0, 1}};

        int[][] y1={{1,0,1,0},{0,1,1,1},{0,1,0,1},{0,1,0,0}};
        int[][] y2={{1,1,1,0},{0,1,0,0},{0,0,1,1},{1,0,0,1}};
        int[][] y3={{1,0,0,0},{1,1,1,0},{1,1,1,0},{0,0,0,1}};
        int[][] y4={{0,0,1,1},{0,1,1,0},{1,0,0,0},{1,1,0,1}};
        int[][][] X = {x1, x2, x3, x4};


        int[] A = {0, 0, 0, 0};
        int[] B = {0, 0, 0, 0};
        int[][] NL= new int[16][16];
        for(int i=0; i<16; i++)
            for(int j=0;j<16;j++){
                NL[i][j]=0;
            }
        String strA = "0";
        String strB = "0";
        for(int l=0; l<16; l++) {
            strA = "0";
            B = intToBitArray(Integer.parseInt(strB));
            for (int k = 0; k < 16; k++) {
                A = intToBitArray(Integer.parseInt(strA));
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if ((((A[0] * x1[i][j]) ^ (A[1] * x2[i][j]) ^ (A[2] * x3[i][j]) ^ (A[3] * x4[i][j])) ^
                                ((B[0] * y1[i][j]) ^ (B[1] * y2[i][j]) ^ (B[2] * y3[i][j]) ^ (B[3] * y4[i][j])))
                                == 0) {
                            NL[l][k] = NL[l][k] +1;
                        }
                    }
                }
                strA = "" + (Integer.parseInt(strA) + 1);
            }
            strB = "" + (Integer.parseInt(strB) + 1);
        }
        for(int i=0; i<16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.printf("%2d ",NL[j][i]);
            }
            System.out.println();
        }
        double[][] Ep_0 = new double[16][16];
        for(int i=0; i<16; i++) {
            for (int j = 0; j < 16; j++) {
                Ep_0[j][i] =(NL[j][i] -8.0)/16.0;
            }
        }
        System.out.println();
        for(int i=0; i<16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.printf("%+.3f ",Ep_0[j][i]);
            }
            System.out.println();
        }
    }
    public static int[] intToBitArray(int number) {
        int[] bitArray = new int[4];
        for (int i = 3; i >= 0; i--) {
            bitArray[i] = (number & 1);
            number >>= 1;
        }
        return bitArray;
    }
}
