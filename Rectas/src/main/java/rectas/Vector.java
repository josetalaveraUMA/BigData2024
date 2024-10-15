package rectas;

public record Vector(Punto extremo) {
    public Vector(double x, double y)
    {
        this(new Punto(x,y));
    }
    public Vector(Punto origen, Punto extremo)
    {
        this(extremo.x() - origen.x(), extremo.y() - origen.y());
    }
}
