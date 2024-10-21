package coches;

public class CocheImportado extends Coche {
    /// Precio de homologación para el coche importado
    private double homologacion;

    /// Constructor de la clase CocheImportado que recibe el nombre, precio y homologación del coche
    /// @param n El nombre del coche
    /// @param p El precio base del coche sin IVA
    /// @param h El costo de la homologación del coche
    /// @throws IllegalArgumentException Si el costo de la homologación es negativo
    public CocheImportado(String n, double p, double h) {
        /// Llama al constructor de la clase padre (Coche) con el nombre y precio
        super(n, p);

        /// Validación de precio de homologación negativo
        if(h < 0.0)
            throw new IllegalArgumentException("El precio de la homologación no puede ser negativo");

        /// Asignación del valor de homologación
        homologacion = h;
    }

    /// Metodo para calcular el precio total del coche con IVA y el costo de homologación
    /// @return El precio total del coche, incluyendo el IVA y la homologación
    @Override
    public double precioTotal() {
        return super.precioTotal() + homologacion;
    }
}
