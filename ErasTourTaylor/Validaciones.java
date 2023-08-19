/*
 * Clase Roberto
 */
class Validaciones {
    /**
     * Validar espacio.
     * @param localidad Localidad a revisar.
     * @return Si hay espacio es verdadero, sino es falso.
     */
    public static boolean validarEspacio(Localidad localidad) {
        return localidad.getBoletosVendidos() < localidad.getCapacidad();
    }

    public static boolean validarDisponibilidad(Localidad localidad, int boletosDeseados) {
        return localidad.getBoletosVendidos() + boletosDeseados <= localidad.getCapacidad();
    }

    /**
     * Ve si el consumidor puede pagar.
     * @param localidad Localidad.
     * @param presupuesto Presupuesto.
     * @return Si hay presupuesto es verdadero, sino es falso.
     */
    public static boolean validarPrecio(Localidad localidad, int presupuesto) {
        return localidad.getPrecio() <= presupuesto;
    }
}

