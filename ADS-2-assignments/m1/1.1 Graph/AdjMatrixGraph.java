/**
 * Imports iterator
 */
import java.util.Iterator;
/**.
 * Imports no such element exception
 */
import java.util.NoSuchElementException;
/**.
 * Class for adj matrix graph.
 */
public final  class AdjMatrixGraph {
    /**.
     * NEWLINE
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * Number of vertices
     */
    private final int vertices;
    /**.
     * Number of edges
     */
    private int edges;
    /**.
     * Adjcent matrix of boolean type
     */
    private boolean[][] adj;

    /**.
     * Constructs the object for Adjmatrixgraph
     *
     * @param      vertices1    { number of vertices }
     */
    public AdjMatrixGraph(final int vertices1) {
        if (vertices1 < 0) {
            throw new IllegalArgumentException("Too few vertices");
        }
        this.vertices = vertices1;
        this.edges = 0;
        this.adj = new boolean[vertices][vertices];
    }
    /**.
     * Number of vertices
     * Time complesxity is constant as each statement is executed only once
     * @return     { returns number of vertices }
     */
    public int numberofVertices() {
        return vertices;
    }
    /**.
     * { number of edges }
     * Time complesxity is constant as each statement is executed only once
     * @return     { returns number of edges }
     */
    public int numberofEdges() {
        return edges;
    }
    /**.
     * Adds an edge.
     * Time complesxity is constant as each statement is executed only once
     * @param      v     { integer type }
     * @param      w     { integer type }
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!adj[v][w]) {
            edges++;
        }
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**.
     * Checks if given components are connected or not
     * Time complesxity is constant as each statement is executed only once
     * @param      v     { integer type }
     * @param      w     { integer type  }
     *
     * @return     { returns true if the two components are connected
     *             else returns false }
     */
    public boolean contains(final int v, final int w) {
        return adj[v][w];
    }
    /**.
     *  Return list of neighbors of v
     *
     * @param      v     { vertex of integer type }
     *
     * @return     {  return list of neighbors of v }
     */
    public Iterable<Integer> adj(final int v) {
        return new AdjIterator(v);
    }
    /**.
     * Support iteration over graph vertices
     */
    private final class AdjIterator implements
        Iterator<Integer>, Iterable<Integer> {
        /**.
         * Vertex
         */
        private int v;
        /**.
         * Vertex
         */
        private int w = 0;
        /**.
         * Constructs the object.
         *
         * @param      v1    { integer type }
         */
        AdjIterator(final int v1) {
            this.v = v1;
        }
        /**.
         * Iterator
         *
         * @return     { description_of_the_return_value }
         */
        public Iterator<Integer> iterator() {
            return this;
        }
        /**.
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
         *
         * @return     { returns integer type }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
    }
    /**.
     * Returns a string representation of the object.
     * Time complexity is N^2 as each for loop iterates for N times.
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberofVertices(); i++) {
            for (int j = 0; j < numberofVertices(); j++) {
                if (adj[i][j]) {
                    sb.append("1 ");
                } else {
                    sb.append("0 ");
                }
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}