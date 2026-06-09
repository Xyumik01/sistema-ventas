import concrete_strategy.DescuentoEmpleado;
import concrete_strategy.DescuentoPromocion;
import concrete_strategy.DescuentoRegular;
import concrete_strategy.DescuentoVIP;
import context.Venta;

/**
     * PATRÓN ELEGIDO: Strategy (comportamiento)
     *
     * JUSTIFICACIÓN: El patrón Strategy permite encapsular diferentes algoritmos
     * de descuento en clases separadas e intercambiables, permitiendo que la clase
     * Venta delegue el cálculo sin conocer los detalles internos de cada estrategia,
     * facilitando agregar nuevos tipos de descuento sin modificar el código existente.
     */
    public class Main {
        public static void main(String[] args) {
            System.out.println("=== SISTEMA DE DESCUENTOS - PLATAFORMA DE VENTAS ===\n");

            // Demostración 1: Diferentes ventas con diferentes estrategias
            System.out.println("--- DEMOSTRACIÓN 1: VENTAS CON ESTRATEGIAS FIJAS ---\n");

            // Venta con cliente regular (5% descuento)
            Venta venta1 = new Venta("Laptop HP", 1000.00, new DescuentoRegular());
            venta1.calcularTotal();

            // Venta con cliente VIP (15% descuento)
            Venta venta2 = new Venta("Smartphone Samsung", 800.00, new DescuentoVIP());
            venta2.calcularTotal();

            // Venta en promoción (descuento fijo S/20)
            Venta venta3 = new Venta("Auriculares Sony", 150.00, new DescuentoPromocion());
            venta3.calcularTotal();

            // Venta con descuento de empleado (30% - nuevo tipo)
            Venta venta4 = new Venta("Tablet iPad", 600.00, new DescuentoEmpleado());
            venta4.calcularTotal();

            // Demostración 2: Cambio de estrategia en tiempo de ejecución
            System.out.println("\n--- DEMOSTRACIÓN 2: CAMBIO DE ESTRATEGIA EN TIEMPO DE EJECUCIÓN ---\n");

            Venta ventaDinamica = new Venta("Smartwatch Garmin", 500.00, new DescuentoRegular());
            System.out.println("*** Venta inicial con estrategia REGULAR (5%) ***");
            ventaDinamica.calcularTotal();

            System.out.println("\n*** Cambiando a estrategia VIP (15%) en tiempo de ejecución ***");
            ventaDinamica.setEstrategiaDescuento(new DescuentoVIP());
            ventaDinamica.calcularTotal();

            System.out.println("\n*** Cambiando a estrategia PROMOCIÓN (S/20 fijo) en tiempo de ejecución ***");
            ventaDinamica.setEstrategiaDescuento(new DescuentoPromocion());
            ventaDinamica.calcularTotal();

            System.out.println("\n*** Cambiando a estrategia EMPLEADO (30%) en tiempo de ejecución ***");
            ventaDinamica.setEstrategiaDescuento(new DescuentoEmpleado());
            ventaDinamica.calcularTotal();

            // Demostración 3: Misma venta con diferentes estrategias
            System.out.println("\n--- DEMOSTRACIÓN 3: COMPARACIÓN DE ESTRATEGIAS PARA EL MISMO PRODUCTO ---\n");

            double montoEjemplo = 200.00;
            System.out.println("Producto: Teclado Mecánico (S/" + montoEjemplo + ")\n");

            Venta ventaComparacion = new Venta("Teclado Mecánico", montoEjemplo, new DescuentoRegular());
            System.out.println("Con descuento REGULAR (5%):");
            ventaComparacion.calcularTotal();

            ventaComparacion.setEstrategiaDescuento(new DescuentoVIP());
            System.out.println("Con descuento VIP (15%):");
            ventaComparacion.calcularTotal();

            ventaComparacion.setEstrategiaDescuento(new DescuentoPromocion());
            System.out.println("Con descuento PROMOCIÓN (S/20 fijo):");
            ventaComparacion.calcularTotal();

            ventaComparacion.setEstrategiaDescuento(new DescuentoEmpleado());
            System.out.println("Con descuento EMPLEADO (30%):");
            ventaComparacion.calcularTotal();

        }
    }
