package context;

import strategy.EstrategiaDescuento;

public class Venta {
    private String concepto;
    private double montoBase;
    private EstrategiaDescuento estrategiaDescuento;

    // Constructor con estrategia inyectada
    public Venta(String concepto, double montoBase, EstrategiaDescuento estrategiaDescuento) {
        this.concepto = concepto;
        this.montoBase = montoBase;
        this.estrategiaDescuento = estrategiaDescuento;
    }

    // Setter para cambiar estrategia en tiempo de ejecución
    public void setEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    // Método para calcular el total aplicando la estrategia actual
    public void calcularTotal() {
        double descuento = estrategiaDescuento.calcularDescuento(montoBase);
        double total = montoBase - descuento;

        System.out.println("Venta: " + concepto);
        System.out.println("  Subtotal: S/" + String.format("%.2f", montoBase));
        System.out.println("  Descuento: S/" + String.format("%.2f", descuento));
        System.out.println("  Total: S/" + String.format("%.2f", total));
        System.out.println("  (Estrategia: " + estrategiaDescuento.getClass().getSimpleName() + ")");
        System.out.println("-----------------------------------");
    }

    // Getters opcionales
    public double getMontoBase() {
        return montoBase;
    }

    public String getConcepto() {
        return concepto;
    }
}