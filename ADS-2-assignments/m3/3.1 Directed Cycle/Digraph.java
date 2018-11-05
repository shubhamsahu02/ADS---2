/**.
 * Class for digraph.
 */
public class Digraph {
    /**.
     * New line
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * { number of vertices in this digraph }
     */
    private final int vertices;
    /**.
     * number of edges in this digraph
     */
    private int edges;
    /**.
     * adj[v] = adjacency list for vertex v
     */
    private Bag<Integer>[] adj;
    /**.
     *  indegree[v] = indegree of vertex v
     */
    private int[] indegree;
    /**.
     * Constructs the object. for digraph
     *
     * @param      vertices1     { vertex }
     */
    public Digraph(final int vertices1) {
        this.vertices = vertices1;
        this.edges = 0;
        indegree = new int[vertices];
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param  digraph the digraph to copy
     */
    public Digraph(final Digraph digraph) {
        this(digraph.numberofVertices());
        this.edges = digraph.numberofEdges();
        for (int v = 0; v < vertices; v++) {
            this.indegree[v] = digraph.indegree(v);
        }
        for (int v = 0; v < digraph.numberofVertices(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : digraph.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    /**.
     * Returns the number of vertices in this digraph.
     *Time complexity is constant because each statement is executed only once.
     * @return the number of vertices in this digraph
     */
    public int numberofVertices() {
        return vertices;
    }

    /**.
     * Returns the number of edges in this digraph.
     *Time complexity is constant because each statement is executed only once.
     * @return the number of edges in this digraph
     */
    public int numberofEdges() {
        return edges;
    }
    /**.
     * checks if the given vertex is valid or not
     *Time complexity is constant because each statement is executed only once.
     * @param      v     { vertex of int type }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("vertex " + v
                + " is not between 0 and " + (vertices - 1));
        }
    }
    /**.
     * Adds the directed edge v→w to this digraph.
     *Time complexity is constant because each statement is executed only once.
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless
     * both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edges++;
    }
    /**.
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *Time complexity is constant because each statement is executed only once.
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }
    /**.
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *Time complexity is constant because each statement is executed only once.
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }
    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     * Time complexity is V as it iterates through all vertices
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph,
     *  as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }
}