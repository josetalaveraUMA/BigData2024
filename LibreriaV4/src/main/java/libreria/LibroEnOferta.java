package libreria;

public class LibroEnOferta extends Libro{
    private double porDescuento;

    public LibroEnOferta(String au, String ti, double pb, double pd)
    {
        super(au,ti,pb);
        porDescuento = pd;
    }

    public double getDescuento()
    {
        return porDescuento;
    }

    @Override
    public double getPrecioFinal()
    {
        double pf = super.getPrecioFinal();
        return pf- pf*porDescuento/100;
    }



    @Override
    public String toString()
    {
        return "(" + getAutor() + ";"
                + getTitulo() + ";"
                + getPrecioBase() + ";"
                + porDescuento + "%;"
                + (getPrecioBase()*porDescuento/100) + ";"
                + IVA + "%;"
                + getPrecioFinal() + ")";
    }
}
