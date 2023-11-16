public class Zad3 {
    public static void main(String[] args){
        ///rzut monetą
        double H1 = - 1.0/2.0 *Math.log(1.0/2.0)/Math.log(2)- 1.0/2.0 *Math.log(1.0/2.0)/Math.log(2);
        System.out.println("Rzut zwykłą monetą entropia = " +H1);

        double H2 = - 1.0/4.0 *Math.log(1.0/4.0)/Math.log(2)- 3.0/4.0 *Math.log(3.0/4.0)/Math.log(2);
        System.out.println("Rzut monetą 1/4 reszki i 3/4 orła entropia = " +H2);

        double H3 = - 1.0/100.0 *Math.log(1.0/100.0)/Math.log(2)- 99.0/100.0 *Math.log(99.0/100.0)/Math.log(2);
        System.out.println("Rzut monetą 1/100 reszki i 99/100 orła entropia = " +H3);

        System.out.println("Wraz z większającą się różnicą prawdopodobieństw entropia maleje." +
                " Entroipa jest o miara nieuporządkowania. Im mniejsza jest entropia tym coraz bardziej jesteśmy pewni" +
                "jaki wynik wyjdzie.");


    }
}

