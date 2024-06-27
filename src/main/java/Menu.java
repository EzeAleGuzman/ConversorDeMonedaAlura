import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {

    public void Barra(){
        System.out.println("*".repeat(100));
    }
    private final String monedasDisponibles = """
                USD --- Dólar Estadounidense
                ARS --- Peso Argentino
                BRL --- Real Brasileño
                COP --- Peso Colombiano
                EUR --- Euro""";

    public void mostrarMenuPrincipal(){
        Barra();
        System.out.println("Por Favor Elije una opcion: \n");
        String menuPrincipal = """
                1) Realizar una conversión
                2) Consultar historial de Cambios.
                3) Salir""";
        System.out.println(menuPrincipal);
    }

    public int leerOpcionPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println("Elija una opción válida");
        Barra();
        return lectura.nextInt();
    }

    public void mostrarMenuMonedas(String denominacion){
        Barra();
        System.out.println("Seleccione la denominación " + denominacion + ": \n");
        System.out.println(monedasDisponibles);
        Barra();
    }

    public String leerOpcionMoneda(){
        Scanner lectura = new Scanner(System.in);
        String opcion = lectura.nextLine().toLowerCase();
        while (!monedasDisponibles.toLowerCase().contains(opcion)) {
            System.out.println("La opción elegida no está disponible");
            System.out.println("Elija una opción válida");
            Barra();
            opcion = lectura.nextLine().toLowerCase();
        }
        return opcion.toUpperCase();
    }

    public Double leerCantidadACambiar(){
        Barra();
        System.out.println("Seleccione la cantidad que desea cambiar: \n");
        Barra();
        Scanner lectura = new Scanner(System.in);
        double cantidad;
        while (!lectura.hasNextDouble()) {
            Barra();
            System.out.println("La cantidad digitada no es un número válido");
            System.out.println("Ingrese una cantidad válida");
            Barra();
            lectura.nextLine();
        }
        cantidad = lectura.nextDouble();
        lectura.nextLine();
        return cantidad;
    }

    public Double cantidadObtenida(String monedaBase, Double cantidadCambiar, Double tasaDeConversion, String monedaFinal){
        Double resultado = cantidadCambiar * tasaDeConversion;
        Barra();
        System.out.println(cantidadCambiar + " " + monedaBase + " equivalen a: " + resultado + " " + monedaFinal);
        return resultado;
    }

    public void imprimirConversiones(ArrayList<Conversion> listaDeConversiones) {
        if (listaDeConversiones.isEmpty()) {
            System.out.println("No se han realizado conversiones.");
        } else {
            System.out.println("Historial de conversiones:");
            System.out.println("-----------------------------------------");
            for (int i = 0; i < listaDeConversiones.size(); i++) {
                Conversion conversion = listaDeConversiones.get(i);
                System.out.println("Conversión " + (i + 1) + ":");
                System.out.println("Cambio: " + conversion.getMonedaInicio() +" -->" +conversion.getMonedaFinal());
                System.out.println("Cantidad a cambiar: $" + conversion.getCantidadInicio());
                System.out.println("Cantidad obtenida: $" + conversion.getCantidadFinal());
                System.out.println("Fecha y hora: " + formatDateTime(conversion.getTiempo()));
                System.out.println("-----------------------------------------");
            }
        }
    }

    private String formatDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }
}