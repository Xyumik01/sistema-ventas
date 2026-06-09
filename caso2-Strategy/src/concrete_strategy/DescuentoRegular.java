package concrete_strategy;

import strategy.EstrategiaDescuento;

public class DescuentoRegular implements EstrategiaDescuento {
    private static final double PORCENTAJE = 0.05; // 5%

    @Override
    public double calcularDescuento(double montoBase) {
        return montoBase * PORCENTAJE;
    }
}
