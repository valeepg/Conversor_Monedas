package conversormoneda;

import java.io.IOException;
import java.util.Scanner;

public class Conversor {

    private static final String API_KEY = "a8a5dc41e0e0fba1fe8992cb";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void eleccionUserMenu() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> convertir("USD", "ARS");
                case 2 -> convertir("ARS", "USD");
                case 3 -> convertir("USD", "BRL");
                case 4 -> convertir("BRL", "USD");
                case 5 -> convertir("USD", "COP");
                case 6 -> convertir("COP", "USD");
                case 7 -> convertir("USD", "PEN");
                case 8 -> convertir("PEN", "USD");
                case 0 -> System.out.println("Saliendo del conversor... ¡Hasta pronto!");
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);
    }
    private static void mostrarMenu(){
        System.out.println("====================================");
        System.out.println("      Conversor de Monedas   ");
        System.out.println("====================================");
        System.out.println("Seleccione una opción:");
        System.out.println("1. USD → ARS (Peso argentino)");
        System.out.println("2. ARS → USD");
        System.out.println("3. USD → BRL (Real brasileño)");
        System.out.println("4. BRL → USD");
        System.out.println("5. USD → COP (Peso colombiano)");
        System.out.println("6. COP → USD");
        System.out.println("7. USD → PEN (Soles peruanos)");
        System.out.println("8. PEN → USD");
        System.out.println("0. Salir");
        System.out.println("------------------------------------");
        System.out.print("Opción: ");

    }

    private static void convertir(String monedaBase, String monedaDestino) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Ingrese monto en %s: ", monedaBase);
        double monto = scanner.nextDouble();

        String url = BASE_URL + API_KEY + "/pair/" + monedaBase + "/" + monedaDestino;
        double tasa = ConversorApp.obtenerTasa(url);

        double resultado = monto * tasa;
        System.out.printf("-> %.2f %s = %.2f %s (Tasa: %.4f)\n\n",
                monto, monedaBase, resultado, monedaDestino, tasa);

        while (true) {
            System.out.println("\n¿Qué desea hacer ahora?");
            System.out.println("1. Convertir otro monto");
            System.out.println("2. Volver al menú principal");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                convertir(monedaBase, monedaDestino); // volver a pedir monto
                return;
            } else if (opcion == 2) {
                return; // regresa al menú principal
            } else if (opcion == 3) {
                System.out.println("¡Gracias por usar el conversor!...Espero vuelva pronto");
                System.exit(0);
            } else {
                System.out.println("⚠ Opción no válida.");
            }
        }
    }
}
