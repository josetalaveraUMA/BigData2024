import java.util.*;

/**
 * Clase que representa un club con la restricción de que los amigos invisibles
 * no pueden ser asignados entre parejas o miembros de una familia.
 */
public class ClubParejas extends Club
{
    // Conjunto de parejas o relaciones familiares para evitar asignaciones entre ellos
    protected Set<Pareja> parejas;

    /**
     * Constructor que inicializa el ClubParejas con un conjunto de parejas vacío.
     */
    public ClubParejas() {
        this.parejas = new HashSet<>();
    }

    /**
     * Crea socios a partir de una cadena de texto. Si los nombres están separados por un guion,
     * los considera como miembros de una familia o pareja, y añade todas las combinaciones posibles.
     *
     * @param nombre Cadena de texto que contiene los nombres separados por espacio o guion.
     */
    @Override
    protected void creaSocioDesdeString (String nombre) {
        if (nombre.contains("-")) {
            // Si contiene un guion, lo tratamos como pareja
            String[] nombresPareja = nombre.split("-");
            Persona persona1 = new Persona(nombresPareja[0].trim());
            Persona persona2 = new Persona(nombresPareja[1].trim());
            // Creamos la pareja
            Pareja pareja = new Pareja(persona1, persona2);
            parejas.add(pareja);  // Agregar la pareja al conjunto
            // Agregar personas al conjunto de socios
            socios.add(persona1);
            socios.add(persona2);
        } else {
            // Si no es una pareja, lo tratamos como persona normal
            super.creaSocioDesdeString(nombre);  // Llamamos al metodo de la clase base
        }
    }

    /**
     * Asigna amigos invisibles de forma aleatoria a cada miembro del club,
     * asegurándose de que no sean miembros de la misma pareja o familia.
     */
    @Override
    protected void hacerAmigos() {
        List<Persona> listaPersonas = new ArrayList<>();

        // Llenamos la lista de personas de todas las parejas
        for (Pareja pareja : parejas) {
            listaPersonas.add(pareja.uno());
            listaPersonas.add(pareja.otro());
        }

        // Barajamos la lista de personas aleatoriamente
        Collections.shuffle(listaPersonas);

        // Mapa para asignar amigos invisibles
        Map<Persona, Persona> amigos = new HashMap<>();

        // Creamos un mapa para almacenar las parejas, esto nos ayudará a comprobar rápidamente si dos personas son pareja
        Map<Persona, Set<Persona>> parejasMap = new HashMap<>();
        for (Pareja pareja : parejas) {
            parejasMap.putIfAbsent(pareja.uno(), new HashSet<>());
            parejasMap.putIfAbsent(pareja.otro(), new HashSet<>());
            parejasMap.get(pareja.uno()).add(pareja.otro());
            parejasMap.get(pareja.otro()).add(pareja.uno());
        }

        // Asignamos amigos invisibles asegurándonos de que no sean pareja
        for (int i = 0; i < listaPersonas.size(); i++) {
            Persona socioActual = listaPersonas.get(i);
            Persona amigoInvisible = listaPersonas.get((i + 1) % listaPersonas.size()); // Inicialmente asignamos el siguiente

            // Si el amigo invisible es la pareja del socio actual, lo cambiamos
            while (parejasMap.get(socioActual).contains(amigoInvisible)) {
                amigoInvisible = listaPersonas.get((i + 2) % listaPersonas.size()); // Buscamos otro amigo si es pareja
            }

            amigos.put(socioActual, amigoInvisible);
        }

        for (Map.Entry<Persona, Persona> entry : amigos.entrySet()) {
            entry.getKey().setAmigo(entry.getValue());
        }
    }
}
