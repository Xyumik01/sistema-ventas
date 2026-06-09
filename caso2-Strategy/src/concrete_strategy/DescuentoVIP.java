package concrete_strategy;

import strategy.EstrategiaDescuento;

public class DescuentoVIP implements EstrategiaDescuento {
    private static final double PORCENTAJE = 0.15; // 15%

    @Override
    public double calcularDescuento(double montoBase) {
        return montoBase * PORCENTAJE;
    }
}
