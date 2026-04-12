package ProyectoMIO;

import java.util.Scanner;

public class Fase1Tarifa {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la hora (0-23): ");
        int hora = sc.nextInt();

        System.out.println("Tipo de pasajero:");
        System.out.println("1. Normal");
        System.out.println("2. Estudiante");
        System.out.println("3. Adulto mayor");
        System.out.println("4. Discapacitado");
        System.out.print("Seleccione: ");
        int tipo = sc.nextInt();

        double tarifaBase = 0;
        double descuento = 0;
        double totalPagar = 0;
        String nombreTipo = "Desconocido";

        boolean esHoraValle = (hora >= 9 && hora <= 16);

        switch (tipo) {
            case 1:
                nombreTipo = "Normal";
                tarifaBase = 3000;
                break;

            case 2:
                nombreTipo = "Estudiante";
                tarifaBase = 1500;
                if (esHoraValle) {
                    descuento = tarifaBase * 0.10;
                }
                break;

            case 3:
                nombreTipo = "Adulto mayor";
                tarifaBase = 0;
                break;

            case 4:
                nombreTipo = "Discapacitado";
                tarifaBase = 0;
                break;

            default:
                System.out.println("Tipo de pasajero invalido.");
                sc.close();
                return;
        }

        totalPagar = tarifaBase - descuento;

        System.out.println("\n--- TIQUETE MIO - CALI ---");
        System.out.println("Hora de abordaje : " + hora + ":00");
        System.out.println("Tipo de usuario  : " + nombreTipo);
        System.out.println("Tarifa base      : $" + tarifaBase);
        System.out.println("Descuento        : $" + descuento);
        System.out.println("TOTAL A PAGAR    : $" + totalPagar);

        sc.close();
    }
}