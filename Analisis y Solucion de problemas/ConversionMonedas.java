import java.util.Scanner;

public class ConversionMonedas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double pesos, dolares, euros;

        final double VALOR_DOLAR = 4000;  // Puedes ajustar
        final double VALOR_EURO = 4500;   // Puedes ajustar

        System.out.print("Ingrese la cantidad en pesos: ");
        pesos = entrada.nextDouble();

        dolares = pesos / VALOR_DOLAR;
        euros = pesos / VALOR_EURO;

        System.out.println("Equivalente en dólares: " + dolares);
        System.out.println("Equivalente en euros: " + euros);
    }
}
