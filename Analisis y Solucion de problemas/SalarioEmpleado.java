import java.util.Scanner;

public class SalarioEmpleado {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        double salarioBruto, deducciones, comision, salarioNeto;

        System.out.print("Ingrese el salario bruto: ");
        salarioBruto = entrada.nextDouble();

        System.out.print("Ingrese las deducciones: ");
        deducciones = entrada.nextDouble();

        System.out.print("Ingrese la comisión: ");
        comision = entrada.nextDouble();

        salarioNeto = (salarioBruto - deducciones) + comision;

        System.out.println("El salario neto es: " + salarioNeto);
    }
}