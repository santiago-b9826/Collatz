package collatz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Santiago Bedoya Betancur.
 */
public class Arbol {

    private Nodo raiz;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void recorridoPre(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        System.out.println(raiz.getDato());
        recorridoPre(raiz.getIzquierda());
        recorridoPre(raiz.getDerecha());
    }

    public void recorridoIn(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        recorridoIn(raiz.getIzquierda());
        System.out.println(raiz.getDato());
        recorridoIn(raiz.getDerecha());
    }

    public void recorridoPost(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        recorridoPost(raiz.getIzquierda());
        recorridoPost(raiz.getDerecha());
        System.out.println(raiz.getDato());
    }

    public void BFS(Nodo raiz) {
        Cola cola = new Cola();
        cola.encola(raiz);
        while (!cola.vacia()) {
            raiz = cola.desencola();
            System.out.println(raiz.getDato());
            if (raiz != null) {
                if (raiz.getIzquierda() != null) {
                    cola.encola(raiz.getIzquierda());
                }
                if (raiz.getDerecha() != null) {
                    cola.encola(raiz.getDerecha());
                }
            }
        }
    }

    void escribirArchivo(String nomArchivo, Nodo raiz) {
        PrintWriter pw;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(nomArchivo), true)));
            pw.println("digraph try {");
            Cola cola = new Cola();
            cola.encola(raiz);
            while (!cola.vacia()) {
                raiz = cola.desencola();
                if (raiz != null) {
                    if (raiz.getIzquierda() != null) {
                        cola.encola(raiz.getIzquierda());
                        pw.println(raiz.getDato() + "->" + raiz.getIzquierda().getDato() + " [dir=none color=red];");
                    }
                    if (raiz.getDerecha() != null) {
                        cola.encola(raiz.getDerecha());
                        pw.println(raiz.getDato() + "->" + raiz.getDerecha().getDato() + " [dir=none color=red];");
                    }
                }
            }
            pw.println("rankdir=UD;}");
            pw.close();
        } catch (IOException e) {
        }
    }

    public void resetArchivo(String nomArchivo) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nomArchivo));
            bw.write("");
            bw.close();
        } catch (IOException e) {
        }
    }

    public void dibujar() {
        try {
            ProcessBuilder pb;
            pb = new ProcessBuilder("Graphviz2.38\\bin\\dot.exe", "-Tpng", "-o", "src\\grafito.jpg", "ward.txt");
            pb.redirectErrorStream(true);
            pb.start();
        } catch (IOException e) {
        }
    }
}
