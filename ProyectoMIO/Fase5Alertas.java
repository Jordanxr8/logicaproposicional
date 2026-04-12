package ProyectoMIO;

import java.util.Scanner;

public class Fase5Alertas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rutasConAlerta = 0;

        for (int ruta = 1; ruta <= 3; ruta++) {

            String nombreRuta;

            if (ruta == 1) {
                nombreRuta = "T31";
            } else if (ruta == 2) {
                nombreRuta = "A10";
            } else {
                nombreRuta = "P22A";
            }

            System.out.println("\n--- Analisis de ruta: " + nombreRuta + " ---");

            System.out.print("Pasajeros del dia: ");
            int pasajeros = sc.nextInt();

            System.out.print("Vueltas realizadas: ");
            int vueltas = sc.nextInt();

            System.out.print("Minutos de retraso: ");
            int retraso = sc.nextInt();

            System.out.print("Recaudo del dia: ");
            double recaudo = sc.nextDouble();

            // ALERTAS
            boolean alertaDemanda = (pasajeros < 500);
            boolean alertaVueltas = (vueltas > 20);
            boolean alertaRetraso = (retraso > 90);
            boolean alertaRecaudo = (recaudo < (pasajeros * 1500 * 0.70));

            // SI CUALQUIERA FALLA → ALERTA
            boolean tieneAlerta = alertaDemanda || alertaVueltas || alertaRetraso || alertaRecaudo;

            if (!tieneAlerta) {
                System.out.println("Ruta " + nombreRuta + ": OK - Sin irregularidades");
            } else {

                rutasConAlerta++;

                System.out.print("Ruta " + nombreRuta + ": ALERTA -> ");

                if (alertaDemanda) {
                    System.out.print("Baja demanda | ");
                }
                if (alertaVueltas) {
                    System.out.print("Exceso de vueltas | ");
                }
                if (alertaRetraso) {
                    System.out.print("Retraso alto | ");
                }
                if (alertaRecaudo) {
                    System.out.print("Recaudo bajo | ");
                }

                System.out.println();
            }
        }

        // DIAGNÓSTICO GLOBAL
        System.out.println("\nRutas con alertas: " + rutasConAlerta + " de 3");

        if (rutasConAlerta == 0) {
            System.out.println("Operacion del dia: NORMAL");
        } else if (rutasConAlerta == 1) {
            System.out.println("Operacion del dia: REVISION MENOR");
        } else if (rutasConAlerta == 2) {
            System.out.println("Operacion del dia: REVISION URGENTE");
        } else {
            System.out.println("Operacion del dia: CRITICA - Notificar a Movilidad");
        }

        sc.close();
    }
}