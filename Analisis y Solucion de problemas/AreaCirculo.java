import java.util.Scanner;

public class AreaCirculo {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double radio, area;

        System.out.print("Ingrese el radio del círculo: ");
        radio = entrada.nextDouble();

        area = Math.PI * Math.pow(radio, 2);

        System.out.println("El área del círculo es: " + area);
    }
}
