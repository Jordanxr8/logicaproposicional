import java.util.Scanner;

public class MediaNumeros {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double num;
        double suma = 0;
        int contador = 0;
        double media;

        System.out.println("Ingrese un numero positivo (numero no positivo para terminar):");
        num = sc.nextDouble();

        while (num > 0) {

            suma = suma + num;
            contador++;

            System.out.println("Ingrese otro numero positivo:");
            num = sc.nextDouble();
        }

        if (contador > 0) {
            media = suma / contador;

            System.out.println("Suma total: " + suma);
            System.out.println("Cantidad de numeros: " + contador);

            System.out.printf("La media es: %.2f\n", media);
        } else {
            System.out.println("No se ingresaron numeros positivos");
        }

        sc.close();
    }
}