import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda = ");

        System.out.println("""
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) PEso colombiano =>> Dólar
                7) Salir
                Elija una opción válida: 
                """);
        System.out.println("********************************************");
    }
}
