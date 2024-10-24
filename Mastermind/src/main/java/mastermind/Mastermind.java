package mastermind;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mastermind {
    public static final int TAMANO_POR_DEFECTO = 4;
    private String combinacionSecreta;
    private Random alea = new Random();

    public Mastermind()
    {
        this(TAMANO_POR_DEFECTO);
    }

    public Mastermind(int tam)
    {

       if(tam < 1 || tam > 10)
           throw new MastermindException("Tamaño "+ tam + " no valido");

       generaCombinacionSecreta(tam);
    }

    private void generaCombinacionSecreta(int tam)
    {
        combinacionSecreta = "";
        while(combinacionSecreta.length() < tam)
        {
            String n = Integer.toString(alea.nextInt(10));
            if(combinacionSecreta.indexOf(n) < 0)
                combinacionSecreta += n;
        }
    }

    public int getLongitud()
    {
        return combinacionSecreta.length();
    }

    // Una cadena es un movimiento válido si tiene la longitud correcta, es decir, las
    //cifras que exige el juego, todos los caracteres son números y no contiene cifras
    //repetidas
    private boolean validaCombinacion(String cifras)
    {
        boolean valida = cifras.matches("\\d{"+combinacionSecreta.length()+"}");
        if(valida)
        {
            int pos = 0;
            while(valida && pos < cifras.length()-1)
            {
                valida = cifras.substring(pos+1)
                        .indexOf(cifras.charAt(pos)) < 0;
                pos++;
            }
        }
        return valida;
    }

    public Movimiento intento(String cifras)
    {
        if(!validaCombinacion(cifras)) throw new MastermindException("Cifras no válidas : " + cifras);
        // El intento es bueno
        int col = 0;
        int des = 0;

        for(int pos = 0; pos < cifras.length(); pos++)
        {
            if(combinacionSecreta.charAt(pos) == cifras.charAt(pos))
                des++;
            else if(combinacionSecreta.indexOf(cifras.charAt(pos)) >= 0)
                col++;
        }

        return new Movimiento(cifras,col,des);
    }

    public String getSecreto()
    {
        return combinacionSecreta;
    }


}
