package npi;

import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;

public class NPI {
    private double x,y,z,t;

    public static DoubleBinaryOperator suma = (x,y) -> x+y;
    public static DoubleBinaryOperator resta = (x,y) -> x-y;
    public static DoubleBinaryOperator producto = (x,y) -> x*y;
    public static DoubleBinaryOperator division = (x,y) -> x/y;
    public static DoubleUnaryOperator raiz = x -> Math.sqrt(x);



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

    public void opera1(DoubleUnaryOperator operador)
    {
        double resultado = operador.applyAsDouble(x);
        x = resultado;
    }
    public void opera2(DoubleBinaryOperator operador)
    {
        double resultado = operador.applyAsDouble(y,x);
        x = resultado;
        y = z;
        z = t;
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
