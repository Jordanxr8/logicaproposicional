package ProyectoMIO;

import java.util.Scanner;

public class Fase2Aforo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacidadMaxima = 80;
        int pasajerosActuales = 0;
        int totalSubieron = 0;
        int totalBajaron = 0;
        int paradasRecorridas = 0;
        int paradasConAforo = 0;
        int parada = 1;
        boolean rutaActiva = true;

        while (parada <= 25 && rutaActiva) {

            System.out.println("\n=== PARADA " + parada + " de 25 ===");
            System.out.println("Pasajeros en el bus: " + pasajerosActuales);

            System.out.print("Cuantos SUBEN? (-1 para terminar): ");
            int suben = sc.nextInt();

            if (suben == -1) {
                rutaActiva = false;
            } else {

                System.out.print("Cuantos BAJAN? ");
                int bajan = sc.nextInt();

                if (bajan > pasajerosActuales) {
                    System.out.println("Error: no pueden bajar más de los que hay.");
                    continue;
                }

                if (pasajerosActuales + suben - bajan > capacidadMaxima) {
                    System.out.println("Error: se supera la capacidad máxima del bus.");
                    continue;
                }

                pasajerosActuales = pasajerosActuales + suben - bajan;
                totalSubieron += suben;
                totalBajaron += bajan;

                if (pasajerosActuales == capacidadMaxima) {
                    paradasConAforo++;
                }

                double porcentaje = (pasajerosActuales * 100.0) / capacidadMaxima;
                String estado;

                if (pasajerosActuales == capacidadMaxima) {
                    estado = "AFORO MAXIMO";
                } else if (porcentaje >= 60) {
                    estado = "BUS LLENO";
                } else {
                    estado = "NORMAL";
                }

                System.out.println("Ocupacion: " + (int)porcentaje + "% - Estado: " + estado);

                parada++;
                paradasRecorridas++;
            }
        }

        System.out.println("\n--- RESUMEN DE RUTA ---");
        System.out.println("Paradas recorridas : " + paradasRecorridas);
        System.out.println("Total subieron     : " + totalSubieron);
        System.out.println("Total bajaron      : " + totalBajaron);
        System.out.println("Pasajeros finales  : " + pasajerosActuales);
        System.out.println("Paradas con aforo  : " + paradasConAforo);

        sc.close();
    }
}