import java.util.Scanner;

public class AreaCuadrado {

    public static void main(String[] args) {

        try (Scanner entrada = new Scanner(System.in)) {
            double lado, area;

            System.out.print("Ingrese el lado del cuadrado: ");
            lado = entrada.nextDouble();

            area = lado * lado;
        }

        System.out.println("El área del cuadrado es: " + area);
    }
}
