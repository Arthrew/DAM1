package mastermind;

import java.util.Formatter;
import java.util.Scanner;

public class MasterMind {

    public static void main(String[] args) {
        String numero, minumero;
        int heridos = 0, muertos = 0, contador = 0;
        int aleatorio, aleatorio2, aleatorio3, aleatorio4;

        Scanner sc = new Scanner(System.in);
        Formatter fmt = new Formatter();
        Formatter fms = new Formatter();

        aleatorio = (int) (Math.random() * 10);

        do {
            aleatorio2 = (int) (Math.random() * 10);
        } while (aleatorio2 == aleatorio);

        do {
            aleatorio3 = (int) (Math.random() * 10);
        } while (aleatorio3 == aleatorio || aleatorio3 == aleatorio2);

        do {
            aleatorio4 = (int) (Math.random() * 10);
        } while (aleatorio4 == aleatorio || aleatorio4 == aleatorio2 || aleatorio4 == aleatorio3);

        String aleatorio00 = String.valueOf(aleatorio);
        String aleatorio02 = String.valueOf(aleatorio2);
        String aleatorio03 = String.valueOf(aleatorio3);
        String aleatorio04 = String.valueOf(aleatorio4);

        minumero = aleatorio00 + aleatorio02 + aleatorio03 + aleatorio04;

        //System.out.println(minumero);
        System.out.println("Intenta acertar el numero de 4 cifras: ");

        while (true) {
            numero = sc.nextLine();

            if (minumero.equals(numero)) {
                System.out.println("ENHORABUENA HAS GANADO");
                System.out.println(minumero + " era el numero secreto");
                System.exit(0);
            }

            for (int i = 0; i < minumero.length(); i++) {

                for (int j = 0; j < minumero.length(); j++) {

                    if (minumero.charAt(i) == numero.charAt(j)) {
                        if (i == j) {
                            muertos++;
                            continue;

                        }
                        heridos++;
                        continue;

                    }
                }

            }
            System.out.println("Muertos: " + muertos);
            System.out.println("Heridos: " + heridos);

            heridos = 0;
            muertos = 0;
            contador++;

            if (contador == 10) {
                System.out.println("HAS PERDIDO, TE HAS QUEDADO SIN OPORTUNIDADES");
                System.exit(0);

            }

        }
    }

}
