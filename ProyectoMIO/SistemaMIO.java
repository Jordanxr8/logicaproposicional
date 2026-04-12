package ProyectoMIO;

import java.util.Scanner;

public class SistemaMIO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== SISTEMA MIO CALI =====");
            System.out.println("1. Cobrar tarifa");
            System.out.println("2. Control de ruta");
            System.out.println("3. Reporte + Alertas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                // =========================
                // FASE 1
                // =========================
                case 1:

                    System.out.print("Ingrese la hora (0-23): ");
                    int hora = sc.nextInt();

                    System.out.print("Tipo (1 Normal, 2 Estudiante, 3 Adulto, 4 Discapacitado): ");
                    int tipo = sc.nextInt();

                    double tarifaBase = 0;
                    double descuento = 0;
                    String nombre = "Desconocido";

                    boolean esHoraValle = (hora >= 9 && hora <= 16);

                    switch (tipo) {
                        case 1:
                            nombre = "Normal";
                            tarifaBase = 3000;
                            break;

                        case 2:
                            nombre = "Estudiante";
                            tarifaBase = 1500;
                            if (esHoraValle) {
                                descuento = tarifaBase * 0.10;
                            }
                            break;

                        case 3:
                            nombre = "Adulto mayor";
                            tarifaBase = 0;
                            break;

                        case 4:
                            nombre = "Discapacitado";
                            tarifaBase = 0;
                            break;

                        default:
                            System.out.println("Tipo invalido");
                    }

                    double total = tarifaBase - descuento;

                    System.out.println("Tipo: " + nombre);
                    System.out.println("TOTAL: $" + total);

                    break;

                // =========================
                // FASE 2
                // =========================
                case 2:

                    int capacidad = 80;
                    int pasajeros = 0;
                    int parada = 1;
                    boolean activa = true;

                    while (parada <= 25 && activa) {

                        System.out.println("\nParada " + parada);
                        System.out.println("Pasajeros actuales: " + pasajeros);

                        System.out.print("Suben (-1 salir): ");
                        int suben = sc.nextInt();

                        if (suben == -1) {
                            activa = false;
                        } else {

                            System.out.print("Bajan: ");
                            int bajan = sc.nextInt();

                            if (bajan > pasajeros) {
                                System.out.println("Error: bajan más de los que hay");
                                continue;
                            }

                            if (pasajeros + suben - bajan > capacidad) {
                                System.out.println("Error: supera capacidad");
                                continue;
                            }

                            pasajeros = pasajeros + suben - bajan;

                            double porcentaje = (pasajeros * 100.0) / capacidad;

                            if (pasajeros == capacidad) {
                                System.out.println("AFORO MAXIMO");
                            } else if (porcentaje >= 60) {
                                System.out.println("BUS LLENO");
                            } else {
                                System.out.println("NORMAL");
                            }

                            parada++;
                        }
                    }

                    break;

                // =========================
                // FASE 4 + 5
                // =========================
                case 3:

                    int totalPasajeros = 0;
                    double totalRecaudo = 0;
                    int rutasConAlerta = 0;

                    for (int i = 1; i <= 3; i++) {

                        String ruta;

                        if (i == 1) ruta = "T31";
                        else if (i == 2) ruta = "A10";
                        else ruta = "P22A";

                        System.out.println("\n--- Ruta: " + ruta + " ---");

                        System.out.print("Pasajeros: ");
                        int p = sc.nextInt();

                        System.out.print("Vueltas: ");
                        int v = sc.nextInt();

                        System.out.print("Retraso (min): ");
                        int r = sc.nextInt();

                        System.out.print("Recaudo: ");
                        double rec = sc.nextDouble();

                        totalPasajeros += p;
                        totalRecaudo += rec;

                        boolean alertaDemanda = (p < 500);
                        boolean alertaVueltas = (v > 20);
                        boolean alertaRetraso = (r > 90);
                        boolean alertaRecaudo = (rec < (p * 1500 * 0.70));

                        boolean tieneAlerta = alertaDemanda || alertaVueltas || alertaRetraso || alertaRecaudo;

                        if (tieneAlerta) {
                            rutasConAlerta++;

                            System.out.print("ALERTA: ");

                            if (alertaDemanda) System.out.print("Baja demanda | ");
                            if (alertaVueltas) System.out.print("Exceso vueltas | ");
                            if (alertaRetraso) System.out.print("Mucho retraso | ");
                            if (alertaRecaudo) System.out.print("Recaudo bajo | ");

                            System.out.println();
                        } else {
                            System.out.println("OK");
                        }
                    }

                    System.out.println("\n===== RESUMEN =====");
                    System.out.println("Total pasajeros: " + totalPasajeros);
                    System.out.println("Total recaudo: $" + totalRecaudo);
                    System.out.println("Rutas con alerta: " + rutasConAlerta);

                    if (rutasConAlerta == 0) {
                        System.out.println("Operacion: NORMAL");
                    } else if (rutasConAlerta == 1) {
                        System.out.println("Operacion: REVISION MENOR");
                    } else if (rutasConAlerta == 2) {
                        System.out.println("Operacion: REVISION URGENTE");
                    } else {
                        System.out.println("Operacion: CRITICA");
                    }

                    break;

                case 0:
                    System.out.println("Sistema cerrado.");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }
        }

        sc.close();
    }
}