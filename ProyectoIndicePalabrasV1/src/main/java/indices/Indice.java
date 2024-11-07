package indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Indice {
    public List<String> texto;

    public Indice(){
        texto = new ArrayList<>();
    }

    public void agregarLinea(String texto){
        this.texto.addLast(texto);
    }

    public abstract void resolver(String delimitadores, Collection<String> noSignificativas);
    public abstract void presentarIndiceConsola();
}
