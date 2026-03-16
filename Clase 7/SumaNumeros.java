import java.util.Scanner;

public class SumaNumeros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num;
        int suma = 0;

        System.out.println("Ingrese un numero (0 para terminar):");
        num = sc.nextInt();

        while (num != 0) {

            suma += num;  // acumulador

            System.out.println("Ingrese otro numero (0 para terminar):");
            num = sc.nextInt();
        }

        System.out.println("La suma total es: " + suma);

        sc.close();
    }
}