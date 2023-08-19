/*Clase de Linda */
import java.util.ArrayList;
import java.util.Random;

public class VentaBoletos {
    private Comprador compradorActual;
    private ArrayList<Localidad> localidades;
    private Random random = new Random();

    public VentaBoletos(ArrayList<Localidad> localidades) {
        this.localidades = localidades;
    }

    public void venderBoletos(Comprador comprador) {
        int boletosDeseados = comprador.getBoletosDeseados();

        if (boletosDeseados > 0 && !localidades.isEmpty()) {
            int localidadesDisponibles = localidades.size();
            int boletosPorLocalidad = boletosDeseados / localidadesDisponibles;

            for (int i = 0; i < localidadesDisponibles; i++) {
                Localidad localidadSeleccionada = localidades.get(i);
                comprador.comprarBoletos(localidadSeleccionada, boletosPorLocalidad);
            }

            // Distribuir boletos adicionales si la división no es exacta.
            int boletosRestantes = boletosDeseados % localidadesDisponibles;
            if (boletosRestantes > 0) {
                for (int i = 0; i < boletosRestantes; i++) {
                    int localidadIndex = random.nextInt(localidadesDisponibles);
                    Localidad localidadSeleccionada = localidades.get(localidadIndex);
                    comprador.comprarBoletos(localidadSeleccionada, 1);
                }
            }
        } else {
            System.out.println("No hay boletos disponibles o localidades para comprar.");
        }
    }

    public void consultarDisponibilidadTotal() {
        for (Localidad localidad : localidades) {
            int boletosDisponibles = localidad.getCapacidad() - localidad.getBoletosVendidos();
            System.out.println("Localidad: " + localidad.getNombre() + " - Boletos Disponibles: " + boletosDisponibles);
        }
    }

    public void consultarDisponibilidadIndividual(String nombreLocalidad) {
        for (Localidad localidad : localidades) {
            if (localidad.getNombre().equalsIgnoreCase(nombreLocalidad)) {
                int boletosDisponibles = localidad.getCapacidad() - localidad.getBoletosVendidos();
                System.out.println("Localidad: " + localidad.getNombre() + " - Boletos Disponibles: " + boletosDisponibles);
                return;
            }
        }
        System.out.println("Localidad no encontrada.");
    }

    public void reporteDeCaja() {
        int totalRecaudado = 0;
        for (Localidad localidad : localidades) {
            int boletosVendidos = localidad.getBoletosVendidos();
            totalRecaudado += boletosVendidos * localidad.getPrecio();
        }
        System.out.println("Total recaudado: $" + totalRecaudado);
    }

    public void venderBoletosEspeciales(int codigoEspecial) {
        if (compradorActual != null) {
            if (compradorActual.esCodigoEspecial(codigoEspecial)) {
                // Encontrar la Localidad 10
                Localidad localidadEspecial = null;
                for (Localidad localidad : localidades) {
                    if (localidad.getNombre().equalsIgnoreCase("Localidad 10")) {
                        localidadEspecial = localidad;
                        break;
                    }
                }
    
                if (localidadEspecial != null) {
                    int precioBoletoEspecial = 20000;
                    int boletosDeseados = compradorActual.getBoletosDeseados();
                    int presupuesto = compradorActual.getPresupuesto();
                    int boletosDisponibles = localidadEspecial.getCapacidad() - localidadEspecial.getBoletosVendidos();
    
                    if (boletosDisponibles > 0 && presupuesto >= precioBoletoEspecial) {
                        int boletosComprar = Math.min(boletosDeseados, boletosDisponibles);
                        int costoTotal = boletosComprar * precioBoletoEspecial;
    
                        localidadEspecial.venderBoletos(boletosComprar);
                        compradorActual.setPresupuesto(presupuesto - costoTotal);
                        System.out.println("Compra exitosa de boletos especiales para " + compradorActual.getNombre() + ". Ha comprado " + boletosComprar + " boletos en la Localidad 10.");
                    } else {
                        System.out.println("No se pueden comprar boletos especiales. Disponibilidad insuficiente o presupuesto insuficiente.");
                    }
                } else {
                    System.out.println("Localidad 10 no encontrada.");
                }
            } else {
                System.out.println("Código especial inválido.");
            }
        } else {
            System.out.println("Debe registrar un comprador primero.");
        }
    }
}
