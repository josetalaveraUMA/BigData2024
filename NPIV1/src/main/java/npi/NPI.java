package npi;

public class NPI {
    private double x,y,z,t;

    public NPI()
    {
        t = 0.0;
        z = 0.0;
        y = 0.0;
        x = 0.0;
    }

    public void entra(double valor)
    {
        t = z;
        z = y;
        y = x;
        x = valor;
    }
    public void suma()
    {
        x = y + x;
        y = z;
        z = t;
    }
    public void resta()
    {
        x = y - x;
        y = z;
        z = t;
    }
    public void multiplica()
    {
        x = y * x;
        y = z;
        z = t;
    }
    public void divide()
    {
        x = y / x;
        y = z;
        z = t;
    }
    public double getResultado()
    {
        return x;
    }

    @Override
    public String toString()
    {
        return "NPI(x="+x+",y="+y+",z="+z+",t="+t+")";
    }
}
