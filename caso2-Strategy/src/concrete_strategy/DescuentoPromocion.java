package concrete_strategy;

import strategy.EstrategiaDescuento;

public class DescuentoPromocion implements EstrategiaDescuento {
    private static final double DESCUENTO_FIJO = 20.00;

    @Override
    public double calcularDescuento(double montoBase) {
        // El descuento no puede hacer que el monto sea negativo
        return Math.min(DESCUENTO_FIJO, montoBase);
    }
}