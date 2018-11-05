/**.
 * Imports iterator packge
 */
import java.util.Iterator;
/**.
 * Imports NoSuchElementException package.
 */
import java.util.NoSuchElementException;
/**.
 * Class for graph.
 */
public class Graph {
    /**.
     * Variable NEWLINE of type string.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * { vertices of type int}.
     */
    private final int vertices;
    /**.
     * { edges of type int }.
     */
    private int edges;
    /**.
     * { adj 2D matrix of type boolean.
     */
    private boolean[][] adj;
    /**
     * Constructs the object for graph.
     *
     * @param      ver1    { vertices }
     */
    public Graph(final int ver1) {
        if (ver1 < 0) {
            throw new IllegalArgumentException("Too few vertices");
        }
        this.vertices = ver1;
        this.edges = 0;
        this.adj = new boolean[vertices][vertices];
    }
    /**
     * {no.of vertices}.
     * Time complexity is constant as it executes only once.
     * @return {returns count of vertices }
     */
    public int numberofVertices() {
        return vertices;
    }
    /**
     * { no of edges }.
     *  Time complexity is constant as it executes only once.
     * @return returns count of edges.
     */
    public int numberofEdges() {
        return edges;
    }
    /**
     * Adds an edge between two vertices.
     * Time complexity is constant as it executes only once.
     * @param      v     { v }
     * @param      w     { w }
     */
    public void addEdge(final int v, final int w) {
        if (!adj[v][w]) {
            edges++;
        }
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**
     * Checks whether the edge is present or not.
     *
     * @param      v     { v }
     * @param      w     { w }
     *
     * @return returns true if edge occurs, otherwise false.
     */
    public boolean contains(final int v, final int w) {
        return adj[v][w];
    }
    /**
     * Gives the vertices adjacent to vertex v.
     * Time complexity is degree of vertex.
     * @param  v  { v }
     *
     * @return returns the vertices adjacent to vertex v.
     */
    public Iterable<Integer> adj(final int v) {
        return new AdjIterator(v);
    }
    /**
     * Class for adj iterator.
     */
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        /**
         * variable v of type int.
         */
        private int v;
        /**
         * variable w of type int.
         */
        private int w = 0;
        /**
         * Constructs the object.
         *
         * @param      v1     { v }
         */
        AdjIterator(final int v1) {
            this.v = v1;
        }
        /**
         * { iterator }.
         *
         * @return     { graph }
         */
        public Iterator<Integer> iterator() {
            return this;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            while (w < vertices) {
                if (adj[v][w]) {
                    return true;
                }
                w++;
            }
            return false;
        }
        /**.
         * { next }
         * Time complexity is constant.
         * @return returns w.
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is O(N^2).
     * @return returns String representation of the object.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " " + edges + NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj(v)) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
