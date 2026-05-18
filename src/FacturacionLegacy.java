/**
 * Clase Legacy del sistema de facturación.
 * ADVERTENCIA: Código con alta deuda técnica. No modificar la firma del método.
 */
public class FacturacionLegacy {

    private static final double DESCUENTO_VIP = 0.25;
    private static final double DESCUENTO_ESTANDAR = 0.15;
    private static final double DESCUENTO_SECUNDARIO = 0.05;

    private static final int TIPO_CLIENTE_PREMIUM = 1;
    private static final int TIPO_CLIENTE_SECUNDARIO = 2;
    // Añado el JavaDoc del método calcularTotal:
    
    /**
 * Calcula el total a pagar aplicando el descuento correspondiente
 * según el tipo de cliente y si es socio VIP.
 *
 * @param importeBase Importe bruto de la transacción. Debe ser mayor que 0.
 * @param tipoCliente Tipo de cliente: 1 = Premium, 2 = Secundario, otro = Sin descuento.
 * @param esSocioVip true si el cliente tiene la condición de socio VIP.
 * @return Importe final tras aplicar el descuento, o 0 si el importe no es válido.
 */
    
    // Método refactorizado con las nuevas variables declaradas arriba:
    public double calcularTotal(double importeBase, int tipoCliente, boolean esSocioVip) {

        if (importeBase <= 0) return 0;

        if (tipoCliente == TIPO_CLIENTE_PREMIUM) {
            if (esSocioVip) return importeBase - (importeBase * DESCUENTO_VIP);
            return importeBase - (importeBase * DESCUENTO_ESTANDAR);
        }

        if (tipoCliente == TIPO_CLIENTE_SECUNDARIO) {
            return importeBase - (importeBase * DESCUENTO_SECUNDARIO);
        }

        return importeBase;
    }
}
