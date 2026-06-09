package subject;

import observer.Observador;
import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private List<Observador> observadores;

    public Producto(String nombre, double precioInicial) {
        this.nombre = nombre;
        this.precio = precioInicial;
        this.observadores = new ArrayList<>();
    }

    public void registrarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setPrecio(double nuevoPrecio) {
        double precioAnterior = this.precio;
        this.precio = nuevoPrecio;
        notificarObservadores(precioAnterior, nuevoPrecio);
    }

    private void notificarObservadores(double precioAnterior, double precioNuevo) {
        for (Observador observador : observadores) {
            observador.actualizar(this.nombre, precioAnterior, precioNuevo);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}