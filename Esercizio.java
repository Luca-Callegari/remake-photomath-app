import javax.swing.*;
import java.util.ArrayList;

public class Esercizio {
    public static double f(double x) {
        return Math.pow(x,2)* 1/(Math.sqrt(x));
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt(JOptionPane.showInputDialog("scegliere funzione: 1.calcola zero " +
          //      "2.calcola integrale definito (metodo rettangoli) 3.calcola integrale definito(metodo trapezi) 4.calcola segno funzione  5.calcola punti stazionari"));

        System.out.println("Funzioni:");
        System.out.println("1.calcolo zero della funzione");
        System.out.println("2.calcolo integrale definito (metodo rettangoli)");
        System.out.println("3.calcolo integrale definito(metodo trapezi)");
        System.out.println("4.calcolo segno funzione");
        System.out.println("5.calcolo punti stazionari");

        int n = Integer.parseInt(JOptionPane.showInputDialog("Inserire numero da 1 a 5 per scegliere dall'elenco"));
        System.out.println();

        if (n == 1) {
            //calcola zero
            double A = Double.parseDouble(JOptionPane.showInputDialog("inserire primo estremo"));
            double B = Double.parseDouble(JOptionPane.showInputDialog("inserire secondo estremo"));
            double a = A;
            double b = B;
            double X;
            double MIN = 0.00001;

            do {
                X = ((A + B) / 2);
                if (f(A) * f(X) < 0) {
                    B = X;
                } else {
                    A = X;
                }

            } while ((f(X) != 0) && ((B - A) > MIN));

            long p = Math.round(X * Math.pow(10, 2));
            p = (long) (p / Math.pow(10, 2));
            if (p == (B)) {
                System.out.println("non esistono zeri");
            } else {
                System.out.println("lo zero della funzione nell'intervallo " + a + " e " + b + " è X=" + X);
            }

        }else if (n == 2) {

            double C = Double.parseDouble(JOptionPane.showInputDialog("inserire primo estremo"));
            double D = Double.parseDouble(JOptionPane.showInputDialog("inserire secondo estremo"));
            double c = C;
            double d = D;
            int N = 1000;
            double h = (d - c) / N;
            double intinf = 0.0;
            for (int i = 0; i <= N - 1; i++) {
                intinf = intinf + h * (f(c + (i * h)));
            }
            double intsup = 0.0;
            for (int j = 1; j <= N; j++) {
                intsup = intsup + h * (f(c + (j * h)));
            }
            double Int = ((intinf + intsup) / 2);
            Int = Math.round(Int * 100);
            Int = Int / 100;

            System.out.println("Il valore dell'integrale definito col metodo dei rettangoli nell'intervallo [" + C + "," + D + "] è uguale a " + Int);
        }else if (n == 3) {

            double E = Double.parseDouble(JOptionPane.showInputDialog("inserire primo estremo"));
            double F = Double.parseDouble(JOptionPane.showInputDialog("inserire secondo estremo"));
            double e = E;
            double f = F;
            int N1 = 1000;
            double h1 = (F - E) / N1;

            double IntT = 0.0;
            for (int i = 1; i <= N1 - 1; i++) {
                IntT = IntT + h1 * f(E + (i * h1));
            }
            IntT = IntT + h1 * ((f(E) + f(F) / 2));


            IntT = Math.round(IntT * 100);
            IntT = IntT / 100;

            System.out.println("Il valore dell'integrale definito col metodo dei trapezi nell'intervallo [" + E + "," + F + "] è uguale a " + IntT);

        }else if (n == 4) {

            double S = Double.parseDouble(JOptionPane.showInputDialog("inserire primo estremo"));
            double T = Double.parseDouble(JOptionPane.showInputDialog("inserire secondo estremo"));
            double A = S;
            double B = T;
            double s = S;
            double t = T;

            //trovare gli zeri della funzione
            /*double X1;
            double MIN1 = 0.00001;

            do {
                X1 = ((S + T) / 2);
                if (f(S) * f(X1) < 0) {
                    T = X1;
                } else {
                    S = X1;
                }

            } while ((f(X1) != 0) && ((T - S) > MIN1));

            System.out.println(X1);*/

            double deltaX = 0.000001;

            ArrayList<Double> zeri = new ArrayList<>();


            for (double i = S; i <= T; i += deltaX) {
                s = i;

                if (f(s) < 0.00001 && f(s) > -0.00001) {
                    if (Math.floor(f(s)) == 0) {
                        zeri.add(s);
                    }
                }
            }
            //System.out.println(zeri);

            for (int i = 0; i < zeri.size(); i++) {
                double k = zeri.get(i);
                for (int j = i + 1; j < zeri.size(); j++) {
                    double k1 = zeri.get(j);
                    if (Math.abs(k - k1) < 0.001) {
                        zeri.remove(j);
                        j = j - 1;

                    }
                }

            }
            //System.out.println(zeri);


            zeri.add(0, A);
            zeri.add(zeri.size(), B);

            //System.out.println(zeri);

            for (int i = 0; i < zeri.size() - 1; i++) {
                double c = zeri.get(i);
                double c1 = zeri.get(i + 1);
                double medio = (c1 + c) / 2;
                if (f(medio) < 0) {
                    System.out.println("Nell'intervallo "+c+" e "+c1+" la funzione è negativa");
                }else if (f(medio)>0){
                    System.out.println("Nell'intervallo "+c+" e "+c1+" la funzione è positiva");
                }
            }



        }else if (n==5){

            double u = Double.parseDouble(JOptionPane.showInputDialog("inserire primo estremo"));
            double v = Double.parseDouble(JOptionPane.showInputDialog("inserire secondo estremo"));

            //trovare i punti stazionari
            double deltaX = 0.1;
            double Z = u + deltaX;
            if (f(u) >= f(Z)) {
                //decrescente
                do {
                    u = u + deltaX;
                    Z = Z + deltaX;

                } while ((f(u) >= f(Z)));
                System.out.println(Z);
            }

            if (f(u) <= f(Z)) {
                //crescente
                do {
                    u = u + deltaX;
                    Z = Z + deltaX;

                } while ((f(u) <= f(Z)));
                System.out.println(Z);
            }

        }else{
            return;
        }

    }
}


