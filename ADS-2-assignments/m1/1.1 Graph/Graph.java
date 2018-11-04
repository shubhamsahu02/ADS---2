/**.
 * Class for graph.
 */
public class Graph {
    /**.
     * Newline
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * Vertices
     */
    private final int vertices;
    /**.
     * Edges
     */
    private int edges;
    /**.
     * Adjacent array of Bag
     */
    private Bag<Integer>[] adj;
    /**.
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     * @param  vertices1 number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Graph(final int vertices1) {
        this.vertices = vertices1;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**.
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int numberofVertices() {
        return vertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int numberofEdges() {
        //System.out.println("edges1..." +E);
        return this.edges;
    }
    /**.
     *Throw an IllegalArgumentException unless {@code 0 <= v < V}
     *
     * @param      v     { vertex }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertices) {
            throw new
            IllegalArgumentException(
                "vertex " + v + " is not between 0 and " + (vertices - 1));
        }
    }
    /**.
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both
     */
    public void addEdge(final int v, final int w) {
        if (v == w) {
            //System.out.println("No edges");
            return;
        }
        for (int i : adj[v]) {
            if (i == w) {
                return;
            }
        }
        validateVertex(v);
        validateVertex(w);
        edges++;
        adj[v].add(w);
        adj[w].add(v);
    }
    /**.
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }
    /**.
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
}
