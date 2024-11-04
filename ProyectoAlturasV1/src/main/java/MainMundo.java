import alturas.*;

import java.io.IOException;
import java.util.List;

public class MainMundo {
    public static void main(String[] args) throws IOException {
        try {
            Mundo mundo = new Mundo();
            mundo.leePaises("alturas.txt");

            // Seleccionar países con altura mayor o igual a 1.77
            List<Pais> mayoresQue = mundo.selecciona(new MayoresQue(1.77));
            System.out.println("Países con altura mayor o igual a 1.77:");
            for (Pais pais : mayoresQue) {
                System.out.println(pais);
            }

            // Seleccionar países con altura menor que 1.77
            List<Pais> menoresQue = mundo.selecciona(new MenoresQue(1.77));
            System.out.println("\nPaíses con altura menor que 1.77:");
            for (Pais pais : menoresQue) {
                System.out.println(pais);
            }

            // Seleccionar países del continente Europa
            List<Pais> enEuropa = mundo.selecciona(new EnContinente("Europe"));
            System.out.println("\nPaíses en Europa:");
            for (Pais pais : enEuropa) {
                System.out.println(pais);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
