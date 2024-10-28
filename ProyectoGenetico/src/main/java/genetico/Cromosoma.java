package genetico;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que representa un cromosoma en un algoritmo genético.
 */
public class Cromosoma {
    protected int[] datos; // Array que contiene los genes del cromosoma
    protected static final int GEN_POR_DEFECTO = 0; // Valor por defecto para los genes
    protected Random gna = new Random(); // Generador de números aleatorios

    /**
     * Constructor que inicializa el cromosoma con un número específico de genes.
     * @param ngenes Número de genes que tendrá el cromosoma.
     * @param valor Si es verdadero, asigna valores aleatorios (0 o 1) a los genes; de lo contrario, los inicializa a 0.
     * @throws IllegalArgumentException si ngenes es menor que 1.
     */
    public Cromosoma(int ngenes, boolean valor){
        if(ngenes < 1)
            throw new IllegalArgumentException("El número de genes no puede ser ni 0 ni negativo");

        datos = new int[ngenes]; // Inicializa el array de genes

        if(valor)  // Se asigna de forma aleatoria un 0 ó un 1 al valor de cada gen
            for(int i = 0; i < ngenes; i++)
                datos[i] = gna.nextInt(2);
        else  // Se asignan todos los genes a 0
            for(int i = 0; i < ngenes; i++)
                datos[i] = GEN_POR_DEFECTO;
    }

    /**
     * Constructor de copia que crea una nueva instancia de Cromosoma a partir de otro.
     * @param c El cromosoma a copiar.
     * @throws IllegalArgumentException si el objeto Cromosoma pasado es null.
     */
    public Cromosoma(Cromosoma c){
        if (c == null)
            throw new IllegalArgumentException("El objeto Cromosoma no puede ser null");

        datos = new int[c.getLongitud()]; // Inicializa el array con la longitud del cromosoma a copiar
        for(int i = 0; i < datos.length; i++)
            datos[i] = c.getGen(i); // Copia los valores de cada gen
    }

    /**
     * Establece el valor de un gen específico.
     * @param ngen Índice del gen a modificar.
     * @param valor Nuevo valor para el gen (debe ser 0 o 1).
     * @throws IllegalArgumentException si ngen está fuera de los límites del array o si valor no es 0 o 1.
     */
    public void setGen(int ngen, int valor){
        if(ngen < 0 || ngen >= datos.length)
            throw new IllegalArgumentException("El número de gen tiene que estar comprendido entre 0 y la longitud del cromosoma");

        if(valor != 0 && valor != 1)
            throw new IllegalArgumentException("El valor del gen no puede ser distinto de 0 ó 1");

        datos[ngen] = valor; // Asigna el nuevo valor al gen
    }

    /**
     * Obtiene el valor de un gen específico.
     * @param ngen Índice del gen a obtener.
     * @return El valor del gen en la posición especificada.
     * @throws IllegalArgumentException si ngen está fuera de los límites del array.
     */
    public int getGen(int ngen){
        if(ngen < 0 || ngen >= datos.length)
            throw new IllegalArgumentException("El número de gen tiene que estar comprendido entre 0 y la longitud del cromosoma");

        return datos[ngen]; // Devuelve el valor del gen
    }

    /**
     * Obtiene la longitud del array de genes.
     * @return Longitud del array de genes.
     */
    public int getLongitud(){
        return datos.length; // Devuelve la longitud del array de genes
    }

    /**
     * Mutación del cromosoma, cambia el valor de los genes
     * según una probabilidad especificada.
     * @param probabilidadCambio Probabilidad de que un gen cambie de valor.
     */
    public void mutar(double probabilidadCambio){
        for(int i = 0; i < datos.length; i++)
            if(gna.nextDouble() < probabilidadCambio) // Genera un número aleatorio y verifica la probabilidad
                // Cambia el valor en la posición i
                datos[i] = (datos[i] == 0) ? 1 : 0; // Cambia 0 por 1 y viceversa
    }

    /**
     * Metodo toString que devuelve una representación en cadena del cromosoma.
     * @return Representación en cadena del cromosoma.
     */
    @Override
    public String toString(){
        return "Cromosoma: " + Arrays.toString(datos); // Devuelve los datos del cromosoma en formato de cadena
    }
}
