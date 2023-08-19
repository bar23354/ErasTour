/*Clase de Linda */
import java.util.Random;

public class Comprador {
    private String nombre;
    private String email;
    private int boletosDeseados;
    private int presupuesto;

    public Comprador(String nombre, String email, int boletosDeseados, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.boletosDeseados = boletosDeseados;
        this.presupuesto = presupuesto;
    }

    public int getBoletosDeseados() {
        return boletosDeseados;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos getter y setter

    // Método para comprar boletos
    public void comprarBoletos(Localidad localidad, int cantidad) {
        int precioTotal = cantidad * localidad.getPrecio();

        if (validarCompra(localidad, cantidad, precioTotal)) {
            localidad.venderBoletos(cantidad);
            this.presupuesto -= precioTotal;
            System.out.println("Compra exitosa para " + this.nombre + ". Ha comprado " + cantidad + " boletos en la localidad " + localidad.getNombre() + ".");
        }
    }

    // Método para validar la compra
    private boolean validarCompra(Localidad localidad, int cantidad, int precioTotal) {
        if (localidad.getBoletosVendidos() + cantidad > localidad.getCapacidad()) {
            System.out.println("No hay suficiente espacio en la localidad " + localidad.getNombre() + " para comprar " + cantidad + " boletos.");
            return false;
        }

        if (precioTotal > this.presupuesto) {
            System.out.println("El precio total de los boletos excede su presupuesto.");
            return false;
        }

        return true;
    }

    public boolean esCodigoEspecial(int codigo) {
        // Verificar si el código pertenece a la secuencia de Fibonacci.
        int a = 0, b = 1;
        while (b < codigo) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == codigo;
    }
}





