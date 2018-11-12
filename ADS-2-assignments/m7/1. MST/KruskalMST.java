/**.
 * Class for kruskal mst.
 */
public class KruskalMST {
    /**.
     * Floating point epsilion
     */
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**.
     * // weight of MST
     */
    private double weight;
    /**.
     * { // edges in MST}
     */
    private Queue<Edge> mst = new Queue<Edge>();
    /**.
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param graph the edge-weighted graph
     */
    public KruskalMST(final EdgeWeightedGraph graph) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : graph.edges1()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(graph.vertices());
        while (!pq.isEmpty() && mst.size() < graph.vertices() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }
    }
    /**.
     * Returns the edges in a minimum spanning tree (or forest).
     * TIme complexity is E as it iterates through all the edges
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }
    /**.
     * Returns the sum of the edge weights in a minimum
     * spanning tree (or forest).
     * Time complexity is constant as each statement is executed only once
     * @return the sum of the edge weights in a minimum
     * spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }
}
