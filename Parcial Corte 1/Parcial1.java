import java.util.Scanner;

public class Parcial1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int CLAVE_SISTEMA = 1234;
        final int SALDO_INICIAL = 800000;

        int claveUsuario;
        int retiro;
        int nuevoSaldo;

        System.out.println("Bienvenido al cajero de la Uniajc");
        System.out.print("Digite su clave: ");
        claveUsuario = sc.nextInt();

        if (claveUsuario == CLAVE_SISTEMA) {

            System.out.println("Clave correcta");
            System.out.print("Digite el valor a retirar: ");
            retiro = sc.nextInt();

            int costoTransaccion = (retiro > 200000) ? 2000 : 0;

            if (retiro + costoTransaccion <= SALDO_INICIAL) {

                nuevoSaldo = SALDO_INICIAL - (retiro + costoTransaccion);

                System.out.println("Operación exitosa");
                System.out.println("Costo de transacción: " + costoTransaccion);
                System.out.println("Su saldo actual es: " + nuevoSaldo);

            } else {
                System.out.println("Error: El valor solicitado más el costo supera su saldo.");
            }

        } else {
            System.out.println("Clave incorrecta. Intente nuevamente.");
        }

        sc.close();
    }
}
