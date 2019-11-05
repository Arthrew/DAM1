package examenprogramacion1;

import java.util.Scanner;

/**
 *
 * @author lopez
 */
public class ExamenProgramacion1 {

    public static void main(String[] args) {
        String cadena;
        Scanner sc = new Scanner(System.in);

        while (true) {

            cadena = sc.nextLine().toUpperCase();
            if (cadena.equals("JJJ-99999")) {
                break;
            }
            String[] partes = cadena.split("-");
            String parte1 = partes[0];
            String parte2 = partes[1];
            comprobacion(parte2);
            letra(parte1);
            Integer valor = Integer.parseInt(parte2);
            sumanum(valor);

            if (comprobacion(parte2) == false || comprobacion2(parte1) == false || comprobacion3(parte1) == false) {
                System.out.println("INVÁLIDO");

            } else {

                letra(parte1);
                if (sumanum(valor) == 00000) {

                    System.out.printf("%s-%05d %n", letra(parte1), sumanum(valor));

                } else {
                    System.out.printf("%s-%05d %n", parte1.toUpperCase(), sumanum(valor));
                }
            }
        }
    }

    public static boolean comprobacion(String cad_num) {

        if (cad_num.length() != 5) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean comprobacion2(String cad_letra) {

        if (cad_letra.length() != 3) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean comprobacion3(String c_letras) {

        String letra1 = c_letras.substring(0, 1);
        char letra01 = letra1.charAt(0);
        String letra2 = c_letras.substring(1, 2);
        char letra02 = letra2.charAt(0);
        String letra3 = c_letras.substring(2, 3);
        char letra03 = letra3.charAt(0);

        if (letra01 == 65 || letra01 == 66 || letra01 == 67 || letra01 == 68 || letra01 == 69 || letra01 == 70 || letra01 == 71 || letra01 == 72 || letra01 == 73 || letra01 == 74) {
            if (letra02 == 65 || letra02 == 66 || letra02 == 67 || letra02 == 68 || letra02 == 69 || letra02 == 70 || letra02 == 71 || letra02 == 72 || letra02 == 73 || letra02 == 74) {
                if (letra03 == 65 || letra03 == 66 || letra03 == 67 || letra03 == 68 || letra03 == 69 || letra03 == 70 || letra03 == 71 || letra03 == 72 || letra03 == 73 || letra03 == 74) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static int sumanum(int suma) {
        if (suma == 99999) {
            suma = 00000;
        } else {
            suma = suma + 1;
        }
        return suma;
    }

    public static String letra(String letras) {

        String letra1 = letras.substring(0, 1).toUpperCase();
        char letra01 = letra1.charAt(0);
        String letra2 = letras.substring(1, 2).toUpperCase();
        char letra02 = letra2.charAt(0);
        String letra3 = letras.substring(2, 3).toUpperCase();
        char letra03 = letra3.charAt(0);

        letra03 += 1;

        if (letra03 == 75) {
            letra03 = 65;
            letra02 += 1;
        }
        if (letra02 == 75) {
            letra02 = 65;
            letra01 += 1;
        }
        String letra001 = Character.toString(letra01);
        String letra002 = Character.toString(letra02);
        String letra003 = Character.toString(letra03);

        letras = letra001 + letra002 + letra003;

        return letras;
    }

}
