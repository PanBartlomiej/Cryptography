public class Zad1 {
    public static void main(String[] args){

        int[][] x1={{0,0,0,0},{0,0,0,0},{1,1,1,1},{1,1,1,1}};
        int[][] x2={{0,0,0,0},{1,1,1,1},{0,0,0,0},{1,1,1,1}};
        int[][] x3={{0,0,1,1},{0,0,1,1},{0,0,1,1},{0,0,1,1}};
        int[][] x4={{0,1,0,1},{0,1,0,1},{0,1,0,1},{0,1,0,1}};

        int[][] y1={{1,0,1,0},{0,1,1,1},{0,1,0,1},{0,1,0,0}};
        int[][] y2={{1,1,1,0},{0,1,0,0},{0,0,1,1},{1,0,0,1}};
        int[][] y3={{1,0,0,0},{1,1,1,0},{1,1,1,0},{0,0,0,1}};
        int[][] y4={{0,0,1,1},{0,1,1,0},{1,0,0,0},{1,1,0,1}};
//        int[] x1={0,0,15,15};
//        int[] x2={0,15,0,15};
//        int[] x3={3,3,3,3};
//        int[] x4={5,5,5,5};
//
//        int[] y1={12,7,5,4};
//        int[] y2={14,4,3,9};
//        int[] y3={8,14,14,1};
//        int[] y4={3,6,8,13};

        int count0 =0;
        int count1 =0;
        String xorResult="";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                if(((x1[i][j]^x4[i][j])^y2[i][j] )== 0){
                    count0++;
                    xorResult+="0";
                }
                else {
                    xorResult+="1";
                    count1++;
                }
            }
            xorResult +=" ";

        }
        System.out.println("X1 ⊕ X4 ⊕ Y2 = "+xorResult);

        double Pr_0 = (count0 )/16.0;
        double Pr_1 = (count1 )/16.0;

        double Ep_0 =(count0 -8.0)/16.0;
        double Ep_1 = (count1 -8.0)/16.0;
        System.out.println("\nPr[X1 ⊕ X4 ⊕ Y2 =0] = "+Pr_0);
        System.out.println("Pr[X1 ⊕ X4 ⊕ Y2 =1] = "+Pr_1);
        System.out.println("eps[X1 ⊕ X4 ⊕ Y2 =0] = "+Ep_0);
        System.out.println("eps[X1 ⊕ X4 ⊕ Y2 =1] = "+Ep_1);


        count0 =0;
        count1 =0;
        xorResult="";
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){

                if(((x3[i][j]^x4[i][j])^y1[i][j]^y4[i][j] )== 0){
                    count0++;
                    xorResult+="0";
                }
                else {
                    xorResult+="1";
                    count1++;
                }
            }
            xorResult +=" ";
        }
        System.out.println("\nX3 ⊕ X4 ⊕ Y2 ⊕ Y4 = "+xorResult);
        Pr_0 = (count0 )/16.0;
        Pr_1 = (count1 )/16.0;

        Ep_0 =(count0 -8.0)/16.0;
        Ep_1 = (count1 -8.0)/16.0;
        System.out.println("\nPr[X1 ⊕ X4 ⊕ Y2 =0] = "+Pr_0);
        System.out.println("Pr[X1 ⊕ X4 ⊕ Y2 =1] = "+Pr_1);
        System.out.println("eps[X1 ⊕ X4 ⊕ Y2 =0] = "+Ep_0);
        System.out.println("eps[X1 ⊕ X4 ⊕ Y2 =1] = "+Ep_1);

    }

}
