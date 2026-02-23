import java.util.Scanner;

public class Ejercicio41a {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Pedir el angulo por parte del usuario
        System.out.println("Digite el angulo:");
        int angulo = sc.nextInt();
        // Condicional
        if (angulo == 0) {
            System.out.println("El angulo es recto");
        } else {
            System.out.println("El angulo no es recto");
        }
        sc.close();
    }
}