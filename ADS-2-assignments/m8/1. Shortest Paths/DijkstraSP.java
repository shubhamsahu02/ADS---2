/**
 * Class for dijkstra sp.
 */
class DijkstraSP {
    /**
     * distance of the edge from vetrex1 to vertex 2.
     */
    private Double[] distTo;
    /**
     *  to store edge object.
     */
    private Edge[] edgeTo;
    /**
     * Index min pQ to store the weights of edges.
     */
    private IndexMinPQ<Double> pq;
    /**
     * edgeweightedgraph object.
     */
    private EdgeWeightedGraph graph;
    /**
     * The constructor to initialize the objects.
     * Time compelxity is O(ElogV)
     * @param      g  graph object.
     * @param      source  The source
     */
    DijkstraSP(final EdgeWeightedGraph g,
               final int source) {
        distTo = new Double[g.vertices()];
        edgeTo = new Edge[g.vertices()];
        for (int i = 0; i < g.vertices(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[source] = 0.0;
        pq = new IndexMinPQ<Double>(g.vertices());
        pq.insert(source, distTo[source]);
        while (!pq.isEmpty()) {
            int vertex = pq.delMin();
            for (Edge edge : g.adj(vertex)) {
                relax(edge, vertex);
            }
        }
    }
    /**
     * This method is to relax the edges.
     * Time complexity is E
     * @param      edge    The edge
     * @param      vertex  The vertex
     */
    private void relax(final Edge edge,
                       final int vertex) {
        int vertexTwo = edge.other(vertex);
        if (distTo[vertexTwo] > distTo[vertex] + edge.weight()) {
            distTo[vertexTwo] = distTo[vertex] + edge.weight();
            edgeTo[vertexTwo] = edge;
            if (pq.contains(vertexTwo)) {
                pq.decreaseKey(vertexTwo, distTo[vertexTwo]);
            } else {
                pq.insert(vertexTwo, distTo[vertexTwo]);
            }
        }
    }
    /**
     * returns the distance of two vertices.
     *Time complexity is constant bcz each statement is executed only once
     * @param      v  vertex
     *
     * @return distance between two vertices.
     */
    public double distTo(final int v) {
        return distTo[v];
    }
    /**
     * returns the boolean value if the path is present
     * or not.
     *Time complexity is constant bcz each statement is executed only once
     * @param      v another vertex.
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    /**
     * returns shortest path to given vertex.
     * Time complexity is O(E) because it checks all
     * the edges through vertex v
     * @param      v  vertex.
     *
     * @return shortest path is returned from the source.
     */
    public Iterable<Edge> pathTo(final int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Edge> path = new Stack<Edge>();
        int x = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[x]) {
            path.push(e);
            x = e.other(x);
        }
        return path;
    }
}