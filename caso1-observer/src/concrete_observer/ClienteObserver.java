package concrete_observer;

import observer.Observador;

public class ClienteObserver implements Observador {
    private String nombreCliente;

    public ClienteObserver(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void actualizar(String producto, double precioAnterior, double precioNuevo) {
        System.out.println("[CLIENTE " + nombreCliente + "] El producto '" + producto
                + "' ahora cuesta $" + String.format("%.2f", precioNuevo));
    }
}