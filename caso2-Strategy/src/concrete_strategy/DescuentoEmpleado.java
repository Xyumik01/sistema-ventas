package concrete_strategy;

//extra para demostrar extensibilidad

import strategy.EstrategiaDescuento;

public class DescuentoEmpleado implements EstrategiaDescuento {
    private static final double PORCENTAJE = 0.30; // 30%

    @Override
    public double calcularDescuento(double montoBase) {
        return montoBase * PORCENTAJE;
    }
}
