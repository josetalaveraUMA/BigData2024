package libreria;

import java.lang.reflect.Array;
import java.util.Arrays;

///@author José Talavera
/// @version 1.0
/// Esta version guarda los libros en un array. En un futuro veremos otras
/// estructuras de dato mas eficientes para ello
public class Libreria {
    private Libro[] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;

    public Libreria(int tam)
    {
        libros = new Libro[tam];
        numLibros = 0;
    }

    public Libreria()
    {
        this(TAM_DEFECTO);
    }

    public void addLibro(String autor, String titulo, double precioBase)
    {
        Libro libro = new Libro(autor, titulo, precioBase);
        addLibro(libro);
    }

    private void addLibro(Libro libro) {
        int pos = posicionLibro(libro);
        if(pos < 0)
        {
            // El libro no está
            aseguraQueCabe();
            libros[numLibros] = libro;
            numLibros++;
        }else
        {
            libros[pos] = libro;
        }
    }

    private void aseguraQueCabe() {
        if(numLibros == libros.length)

            libros = Arrays.copyOf(libros, numLibros*2);

    }

    private int posicionLibro(String autor, String titulo)
    {
        int pos = 0;
        while (pos < numLibros &&
                !libros[pos].getTitulo().equalsIgnoreCase(titulo) ||
                !libros[pos].getAutor().equalsIgnoreCase(autor))
            pos++;

        return (pos==numLibros)? -1 : pos;
    }

    public double getPrecioBase(String autor, String titulo)
    {
        int pos = posicionLibro(autor,titulo);
        return (pos < 0)? 0: libros[pos].getPrecioBase();
    }

    public double getPrecioFinal(String autor, String titulo)
    {
        int pos = posicionLibro(autor,titulo);
        return (pos < 0)? 0: libros[pos].getPrecioFinal();
    }

    public void remLibro(String autor, String titulo)
    {
        // El libro está
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0)
        {
            for(int i = pos; i < numLibros - 1; i++)
                libros[i] = libros[i+1];
            numLibros--;
            libros[numLibros] = null;

        }
    }

    // todo hacer el override del toString()

}
