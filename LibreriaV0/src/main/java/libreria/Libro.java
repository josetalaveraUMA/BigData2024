package libreria;

/// @author José Talavera
/// @version 1.0
///
public class Libro {
    public String titulo;
    public String autor;
    private double precioBase;
    private static double IVA = 10;

    /// Crea un libro
    /// @param au autor
    /// @param ti titulo
    /// @param pb precio base
    public Libro(String au, String ti, double pb)
    {
        autor = au;
        titulo = ti;
        precioBase = pb;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal()
    {
        return precioBase + precioBase*IVA/100;
    }

    @Override
    public String toString()
    {
        return "(" + autor + ";" + titulo + ";" + precioBase + ";" + IVA + ";" + getPrecioFinal() + ")";
    }
}