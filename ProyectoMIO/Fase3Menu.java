package ProyectoMIO;

import java.util.Scanner;

public class Fase3Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n+------------------------------+");
            System.out.println("|       SISTEMA MIO CALI       |");
            System.out.println("+------------------------------+");
            System.out.println("| 1. Cobrar tarifa             |");
            System.out.println("| 2. Iniciar control de ruta   |");
            System.out.println("| 3. Reporte del dia           |");
            System.out.println("| 0. Salir                     |");
            System.out.println("+------------------------------+");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Ejecutando Fase 1...");
                    break;

                case 2:
                    System.out.println("Ejecutando Fase 2...");
                    break;

                case 3:
                    System.out.println("Disponible en la Fase 4.");
                    break;

                case 0:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        }

        sc.close();
    }
}