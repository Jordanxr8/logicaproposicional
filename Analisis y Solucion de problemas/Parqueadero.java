import java.util.Scanner;

public class Parqueadero {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int horas;
        double subtotal, iva, total;

        final double VALOR_HORA = 2000;
        final double PORCENTAJE_IVA = 0.20;

        System.out.print("Ingrese el número de horas: ");
        horas = entrada.nextInt();

        subtotal = horas * VALOR_HORA;
        iva = subtotal * PORCENTAJE_IVA;
        total = subtotal + iva;

        System.out.println("Subtotal: " + subtotal);
        System.out.println("IVA (20%): " + iva);
        System.out.println("Total a pagar: " + total);
    }
}