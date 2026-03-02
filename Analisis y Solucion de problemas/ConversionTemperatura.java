package Analisis y Solucion de problemas;

public class ConversionTemperatura 
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double celsius, fahrenheit;

        System.out.print("Ingrese la temperatura en grados Celsius: ");
        celsius = entrada.nextDouble();

        fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Equivalente en Fahrenheit: " + fahrenheit);

        System.out.print("Ingrese la temperatura en grados Fahrenheit: ");
        fahrenheit = entrada.nextDouble();

        celsius = (fahrenheit - 32) * 5 / 9;

        System.out.println("Equivalente en Celsius: " + celsius);
    }
}
