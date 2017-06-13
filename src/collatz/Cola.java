package collatz;

import java.util.ArrayList;

/**
 *
 * @author Santiago Bedoya Betancur.
 */
public class Cola extends ArrayList {

    private ArrayList cola = new ArrayList();

    public Nodo primero() {
        return ((Nodo) cola.get(0));
    }

    public void encola(Nodo nodo) {
        cola.add(nodo);
    }

    public Nodo desencola() {
        return ((Nodo) cola.remove(0));
    }

    public boolean vacia() {
        return (cola.isEmpty());
    }
}
