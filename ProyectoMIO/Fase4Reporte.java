package ProyectoMIO;

import java.util.Scanner;

public class Fase4Reporte {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalPasajerosDia = 0;
        double totalRecaudoDia = 0;
        int totalVueltas = 0;

        int maxPasajeros = 0;
        int minPasajeros = Integer.MAX_VALUE;

        String rutaMasConcurrida = "";
        String rutaMenosConcurrida = "";

        double maxRecaudo = 0;
        String rutaMayorRecaudo = "";

        for (int ruta = 1; ruta <= 3; ruta++) {

            String nombreRuta;

            if (ruta == 1) {
                nombreRuta = "T31";
            } else if (ruta == 2) {
                nombreRuta = "A10";
            } else {
                nombreRuta = "P22A";
            }

            System.out.println("\n--- Datos para ruta: " + nombreRuta + " ---");

            System.out.print("Pasajeros transportados: ");
            int pasajeros = sc.nextInt();

            System.out.print("Numero de vueltas: ");
            int vueltas = sc.nextInt();

            System.out.print("Porcentaje de pasajeros normales: ");
            int pctNormal = sc.nextInt();

            int pctEstudiante = 100 - pctNormal;

            double recaudo = pasajeros * (
                    (pctNormal / 100.0) * 3000 +
                    (pctEstudiante / 100.0) * 1500
            );

            // ACUMULADORES
            totalPasajerosDia += pasajeros;
            totalRecaudoDia += recaudo;
            totalVueltas += vueltas;

            // MAYOR PASAJEROS
            if (pasajeros > maxPasajeros) {
                maxPasajeros = pasajeros;
                rutaMasConcurrida = nombreRuta;
            }

            // MENOR PASAJEROS
            if (pasajeros < minPasajeros) {
                minPasajeros = pasajeros;
                rutaMenosConcurrida = nombreRuta;
            }

            // MAYOR RECAUDO
            if (recaudo > maxRecaudo) {
                maxRecaudo = recaudo;
                rutaMayorRecaudo = nombreRuta;
            }

            System.out.println("Recaudo de la ruta: $" + recaudo);
        }

        double promedio = totalPasajerosDia / 3.0;

        // REPORTE FINAL
        System.out.println("\n===== REPORTE FINAL =====");
        System.out.println("Total pasajeros: " + totalPasajerosDia);
        System.out.println("Total recaudo: $" + totalRecaudoDia);
        System.out.println("Total vueltas: " + totalVueltas);

        System.out.println("Ruta mas concurrida: " 
                + rutaMasConcurrida + " (" + maxPasajeros + ")");

        System.out.println("Ruta menos concurrida: " 
                + rutaMenosConcurrida + " (" + minPasajeros + ")");

        System.out.println("Ruta mayor recaudo: " 
                + rutaMayorRecaudo + " ($" + maxRecaudo + ")");

        System.out.println("Promedio pasajeros: " + promedio);

        sc.close();
    }
}