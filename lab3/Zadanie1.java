import java.util.ArrayList;

public class Zadanie1 {

    public static void main(String[] args){

        int max=18;
        int[][] initialVectors = {
                {0, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 1, 1},
                {0, 1, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 1, 1}
        };

        for( int k=0; k<16; k++) {
            ArrayList<Integer> keyStream = new ArrayList<>();
            // for(int j=0; j<16;j++){
            keyStream.add(initialVectors[k][0]);
            keyStream.add(initialVectors[k][1]);
            keyStream.add(initialVectors[k][2]);
            keyStream.add(initialVectors[k][3]);
            //}
            for (int i = 4; i < 50; i++) {
                keyStream.add((keyStream.get(i - 4) + keyStream.get(i - 3) + keyStream.get(i - 2) + keyStream.get(i - 1)) % 2);
            }
            String str = "";
            for (Integer i : keyStream) {
                str = str + i;
            }
            for (int i = 1; i < max; i++) {
                String perdiodStr = str.substring(0, i);
                String subStr = str.substring(i, str.length());
                if (czyCykliczny(str, perdiodStr)) {
                    System.out.println("P("+initialVectors[k][0]+initialVectors[k][1]+initialVectors[k][2]+initialVectors[k][3]
                            +")="+ i);
                    break;
                }
            }
        }
        ///B
        System.out.println("Podpunkt B");
        for( int k=0; k<16; k++) {
            ArrayList<Integer> keyStream = new ArrayList<>();
            // for(int j=0; j<16;j++){
            keyStream.add(initialVectors[k][0]);
            keyStream.add(initialVectors[k][1]);
            keyStream.add(initialVectors[k][2]);
            keyStream.add(initialVectors[k][3]);
            //}
            for (int i = 4; i < 45; i++) {
                keyStream.add((keyStream.get(i - 4)  + keyStream.get(i - 1)) % 2);
            }
            String str = "";
            for (Integer i : keyStream) {
                str = str + i;
            }
            for (int i = 1; i < max; i++) {
                String perdiodStr = str.substring(0, i);
                String subStr = str.substring(i, str.length());
                if (czyCykliczny(str, perdiodStr)) {
                    System.out.println("P("+initialVectors[k][0]+initialVectors[k][1]+initialVectors[k][2]+initialVectors[k][3]
                            +")="+ i);
                    break;
                }
            }
        }
    }

    static boolean czyCykliczny(String str,String perdiodStr){
        for (int j = 0; j < str.length(); j += perdiodStr.length()) {
            String podnapis = str.substring(j, j + perdiodStr.length());
            if (!podnapis.equals(perdiodStr)) {
                return false;
            }
        }
        return true;
    }
}
