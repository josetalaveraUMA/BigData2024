package coches;

public class Coche {
    /// Constante estática para el porcentaje de IVA
    private static double PIVA = 0.16;

    /// Nombre del coche
    private String nombre;

    /// Precio base del coche sin IVA
    private double precio;

    /// Constructor de la clase Coche que recibe el nombre y el precio del coche
    /// @param n El nombre del coche
    /// @param p El precio base del coche sin IVA
    /// @throws IllegalArgumentException Si el nombre es una cadena vacía o si el precio es negativo
    public Coche(String n, double p)
    {
        /// Validación de nombre vacío
        if(n == "")
            throw new IllegalArgumentException("Nombre de coche inválido");

        /// Validación de precio negativo
        if(p < 0.0)
            throw new IllegalArgumentException("El precio del coche no puede ser negativo");

        /// Asignación de nombre y precio
        nombre = n;
        precio = p;
    }

    /// Metodo para calcular el precio total del coche con IVA
    /// @return El precio total del coche, incluyendo el IVA
    public double precioTotal()
    {
        return precio + precio * PIVA;
    }

    /// Metodo estático para actualizar el valor del IVA
    /// @param nuevoIva El nuevo valor del IVA, debe estar entre 0 y 100
    /// @throws IllegalArgumentException Si el IVA no está entre 0 y 100
    public static void setPiva(double nuevoIva)
    {
        /// Validación del valor del IVA, debe estar entre 0 y 100
        if(nuevoIva < 0.0 || nuevoIva > 100.0)
            throw new IllegalArgumentException("El IVA tiene que ser entre 0 y 100");

        /// Asignación del nuevo valor de IVA
        PIVA = nuevoIva;
    }

    /// Sobrescritura del metodo toString para mostrar la información del coche
    /// @return Una cadena de texto que muestra el nombre del coche y su precio total
    @Override
    public String toString()
    {
        return "<" + nombre + "> -> <" + precioTotal() + ">";
    }
}
