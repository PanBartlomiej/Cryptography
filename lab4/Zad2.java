public class Zad2 {
    public static void main(String[] args){
        double Pr_a = 0.5;
        double Pr_b = 1.0/3.0;
        double Pr_c = 1.0/6.0;

        double K=1.0/3.0;
//
//        System.out.println(Pr_a);
//        System.out.println(Pr_b);
//        System.out.println(Pr_c);

        double HP = -Pr_a * Math.log(Pr_a)/Math.log(2) - Pr_b * Math.log((Pr_b))/Math.log(2) - Pr_c*Math.log(Pr_c)/Math.log(2);
        double HK = -K * Math.log(K)/Math.log(2) - K * Math.log((K))/Math.log(2) - K*Math.log(K)/Math.log(2);
        System.out.println("H(P)= "+HP);
        System.out.println("H(K)= "+HK);

        double Pr1 = Pr_c*K + Pr_a*K;
        double Pr2 = Pr_b*K+Pr_a*K;
        double Pr3 = Pr_c*K+Pr_b*K+Pr_a*K;
        double Pr4 = Pr_c*K+Pr_b*K;

        System.out.println("Pr[1] = "+Pr1);
        System.out.println("Pr[2] = "+Pr2);
        System.out.println("Pr[3] = "+Pr3);
        System.out.println("Pr[4] = "+Pr4);


        double HC = -Pr1 * Math.log(Pr1)/Math.log(2) - Pr2 * Math.log((Pr2))/Math.log(2) - Pr3*Math.log(Pr3)/Math.log(2)
                - Pr4 * Math.log((Pr4))/Math.log(2);

        System.out.println("H(P)= "+HP);
        System.out.println("H(K)= "+HK);
        System.out.println("H(C)= "+HC);

        double HKC = HK+HP-HC;

        System.out.println("H(K|C)= "+HKC);

        double HPC = HP+ HK- HC;

        System.out.println("H(P|C)= "+HPC);
    }
}
