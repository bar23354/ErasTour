/*
 * Clase Roberto generada por ChatGPT: 
 * "Create a class called 'TicketGenerator' that generates random ticket numbers and checks their eligibility for purchasing tickets. The class should have the following methods:
 * generarNumeroDeTicket(): Generates a random number between 1 and 15,000 for a ticket and returns it.
 * esTicketApto(numeroDeTicket, a, b): Checks if a given ticket number is eligible for purchasing tickets. It should take the ticket number, 'a', and 'b' as parameters and return true if the ticket is eligible (i.e., the ticket number falls within the range defined by 'a' and 'b'), or false otherwise."
 */
import java.util.Random;
/**
 * Mira si hay tickets disponibles a comprar.
 */
class TicketGenerator {
    private static Random random = new Random();

    /**
     * 1 a 15,000.
     * @return Numero del ticket
     */
    public static int generarNumeroDeTicket() {
        return random.nextInt(15000) + 1;
    }

    /**
     * Mira si el numero puede ser usado.
     * @param numeroDeTicket Numeroa  revisar.
     * @param a Primer numero.
     * @param b Segundo numero.
     * @return Verdadero si es elegible o falso si no lo es.
     */
    public static boolean esTicketApto(int numeroDeTicket, int a, int b) {
        return numeroDeTicket >= a && numeroDeTicket <= b;
    }
}
