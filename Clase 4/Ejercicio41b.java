import java.util.Scanner;

public class Ejercicio41b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Si la temperatura esta por encima de 100 subr el punto de ebullicion
        System.out.println("Digite la temperatura");
        int temp = sc.nextInt();
        if (temp >= 100){
            System.out.println("punto de ebullicion");
        }else{
            System.out.println("No esta en punto de ebullicion");
        }
        sc.close();
    }
}
