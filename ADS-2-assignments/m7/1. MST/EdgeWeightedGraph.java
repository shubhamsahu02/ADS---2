/**.
 * Class for edge weighted graph.
 */
public class EdgeWeightedGraph {
    /**.
     * New line is line seperator
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * no of vertices
     */
    private final int vertices;
    /**.
     * number of edges
     */
    private int edges;
    /**.
     * adjcent list
     */
    private Bag<Edge>[] adj;
    /**.
     * Initializes an empty edge-weighted graph with
     *  {@code V} vertices and 0 edges.
     * TIme complexity is O(V) as it iterates through numberof vertices.
     * @param  vertices1 the number of vertices
     */
    public EdgeWeightedGraph(final int vertices1) {
        this.vertices = vertices1;
        this.edges = 0;
        adj = (Bag<Edge>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<Edge>();
        }
    }
    /**.
     * Initializes a new edge-weighted graph that is a deep copy of {@code G}.
     * TIme complexity is O(V) as it iterates through numberof vertices.
     * @param  graph the edge-weighted graph to copy
     */
    public EdgeWeightedGraph(final EdgeWeightedGraph graph) {
        this(graph.vertices());
        this.edges = graph.edges();
        for (int v = 0; v < graph.vertices(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : graph.adj[v]) {
                reverse.push(e);
            }
            for (Edge e : reverse) {
                adj[v].add(e);
            }
        }
    }
    /**.
     * Returns the number of vertices in this edge-weighted graph.
     *Time complexity is constant bcz each statement is executed only once
     * @return the number of vertices in this edge-weighted graph
     */
    public int vertices() {
        return vertices;
    }
    /**.
     * Returns the number of edges in this edge-weighted graph.
     *Time complexity is constant bcz each statement is executed only once
     * @return the number of edges in this edge-weighted graph
     */
    public int edges() {
        return edges;
    }
    /**.
     * checks if the given vertex is valid or not
     *Time complexity is constant bcz each statement is executed only once
     * @param      v     { vertex}
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertices) {
            throw new
            IllegalArgumentException("vertex "
                                     + v + " is not between 0 and "
                                     + (vertices - 1));
        }
    }
    /**.
     * Adds the undirected edge {@code e} to this edge-weighted graph.
     *Time complexity is constant bcz each statement is executed only once
     * @param  e the edge
     * @throws IllegalArgumentException unless both endpoints
     * are between {@code 0} and {@code V-1}
     */
    public void addEdge(final Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        edges++;
    }
    /**.
     * Returns the edges incident on vertex {@code v}.
     * Time complexity is E because it iterates through all the edges
     * @param  v the vertex
     * @return the edges incident on vertex {@code v} as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Edge> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }
    /**.
     * Returns the degree of vertex {@code v}.
     *Time complexity is constant bcz each statement is executed only once
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**.
     * Returns all edges in this edge-weighted graph.
     * To iterate over the edges in this edge-weighted graph,
     * use foreach notation:
     * {@code for (Edge e : G.edges())}.
     *Time complexity is E because it iterates through all the edges
     * @return all edges in this edge-weighted graph, as an iterable
     */
    public Iterable<Edge> edges1() {
        Bag<Edge> list = new Bag<Edge>();
        for (int v = 0; v < vertices; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                } else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) {
                        list.add(e);
                    }
                    selfLoops++;
                }
            }
        }
        return list;
    }

}