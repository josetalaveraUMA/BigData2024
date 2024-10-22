package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex{
    private double porDescuento;
    private String[] autores;

    public OfertaAutor(double pd, String[] au)
    {
        porDescuento = pd;
        autores = au;
    }

    public double getDescuento(Libro libro)
    {
        String autor = libro.getAutor();
        int pos = 0;

        while (pos < autores.length
                && !autores[pos].equalsIgnoreCase(autor))
            pos++;

        return pos < autores.length ? porDescuento:0;
    }

    @Override
    public String toString()
    {
        String salida = porDescuento + "%";
        for(int pos = 0; pos < autores.length; pos++)
        {
            salida += autores[pos];
            if(pos < autores.length - 1)
                salida += ";";
        }

        // Si la salida fuese con , en lugar de ; sería tal que así:
        //return porDescuento+"%"+ Arrays.toString(autores);
        return salida + "]";
    }
}
