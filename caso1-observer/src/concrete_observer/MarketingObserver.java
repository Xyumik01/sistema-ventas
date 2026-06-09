package concrete_observer;

import observer.Observador;

public class MarketingObserver implements Observador {
    @Override
    public void actualizar(String producto, double precioAnterior, double precioNuevo) {
        double porcentajeBajada = ((precioAnterior - precioNuevo) / precioAnterior) * 100;

        if (porcentajeBajada > 20) {
            System.out.println(" OFERTA FLASH: producto " + producto
                    + " bajo un " + String.format("%.1f", porcentajeBajada) + "% ");
        }
    }
}