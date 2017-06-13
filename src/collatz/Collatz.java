package collatz;

/**
 *
 * @author Santiago Bedoya Betancur.
 */
public class Collatz {

    public Arbol CollatzI(int n, int altura) {
        Nodo nodo = new Nodo(n);
        Nodo cero = new Nodo(0);
        Nodo aux;
        Arbol arbol = new Arbol(nodo);
        Cola colaNo = new Cola();
        colaNo.encola(nodo);
        colaNo.encola(cero);
        for (int i = 0; i < altura - 1; i++) {
            while (!colaNo.primero().equals(cero)) {
                aux = (Nodo) colaNo.desencola();
                n = aux.getDato();

                if (n != 1 && n != 4 && n % 2 == 0 && (n - 1) % 3 == 0) {
                    Nodo nodoIz = new Nodo((n - 1) / 3);
                    colaNo.encola(nodoIz);
                    aux.setIzquierda(nodoIz);
                }

                Nodo nodoDer = new Nodo(2 * n);
                colaNo.encola(nodoDer);
                aux.setDerecha(nodoDer);
            }
            colaNo.encola(colaNo.desencola());
        }
        return arbol;
    }
}
