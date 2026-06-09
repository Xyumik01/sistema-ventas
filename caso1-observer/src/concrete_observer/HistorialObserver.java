package concrete_observer;

import observer.Observador;

public class HistorialObserver implements Observador {
    @Override
    public void actualizar(String producto, double precioAnterior, double precioNuevo) {
        System.out.println("[HISTORIAL] Producto: " + producto
                + " | Antes: $" + String.format("%.2f", precioAnterior)
                + " | Ahora: $" + String.format("%.2f", precioNuevo));
    }
}