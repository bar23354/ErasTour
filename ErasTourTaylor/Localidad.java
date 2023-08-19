/**
 * Clase Robertototo
 * Represents a locality in the concert venue.
 */
class Localidad {
    private String nombre;
    private int precio;
    private int capacidad;
    private int boletosVendidos;

    public Localidad(String nombre, int precio, int capacidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    /**
     * Te da el precio de la localidad.
     * @return El precio de la historia.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Capacidad de la localidad.
     * @return Capacidad.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Da el numero de tickets vendidos en una localidad.
     * @return Numero de tickets vendidos.
     */
    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    /**
     * @param cantidad El numero de tickets a vender.
     */
    public void venderBoletos(int cantidad) {
        this.boletosVendidos += cantidad;
    }

    /**
     * Nombre de la localidad.
     * @return Nombre de la localidad.
     */
    public String getNombre() {
        return nombre;
    }

}