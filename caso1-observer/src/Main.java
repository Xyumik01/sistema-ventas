import concrete_observer.ClienteObserver;
import concrete_observer.HistorialObserver;
import concrete_observer.MarketingObserver;
import subject.Producto;

/**
 * PATRÓN ELEGIDO: Observer (comportamiento)
 * JUSTIFICACIÓN: El patrón Observer permite que el Producto (sujeto) notifique
 * automáticamente a múltiples observadores (clientes, historial, marketing)
 * cuando su precio cambia, sin que el producto necesite conocer los detalles
 * internos de cada observador, cumpliendo el principio de bajo acoplamiento.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE ALERTAS DE PRECIOS - TIENDA ONLINE ===\n");

        // Crear producto (sujeto)
        Producto laptop = new Producto("Laptop Gaming X", 1000.00);
        System.out.println("Producto creado: " + laptop.getNombre()
                + " - Precio inicial: $" + laptop.getPrecio() + "\n");

        // Crear observadores concretos
        ClienteObserver cliente1 = new ClienteObserver("Alan García");
        ClienteObserver cliente2 = new ClienteObserver("Carlos Espá");
        HistorialObserver historial = new HistorialObserver();
        MarketingObserver marketing = new MarketingObserver();

        // Registrar observadores en el sujeto
        laptop.registrarObservador(cliente1);
        laptop.registrarObservador(cliente2);
        laptop.registrarObservador(historial);
        laptop.registrarObservador(marketing);

        System.out.println("=== SUSCRIPCIONES REGISTRADAS ===");
        System.out.println("- Cliente: Alan García");
        System.out.println("- Cliente: Carlos Espá");
        System.out.println("- Historial de precios");
        System.out.println("- Marketing (alertas flash)\n");

        // Simular cambios de precio
        System.out.println("=== CAMBIO 1: Aumento de precio (sin bajada) ===\n");
        laptop.setPrecio(1200.00);

        System.out.println("\n=== CAMBIO 2: Pequeña bajada (menor al 20%) ===\n");
        laptop.setPrecio(1100.00);

        System.out.println("\n=== CAMBIO 3: Gran bajada (mayor al 20%) ===\n");
        laptop.setPrecio(800.00);

    }
}