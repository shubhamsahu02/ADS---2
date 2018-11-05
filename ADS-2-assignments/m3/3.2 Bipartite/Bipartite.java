/**.
 * Class for bipartite.
 */
public class Bipartite {
    /**.
     * // is the graph bipartite?
     */
    private boolean isBipartite;
    /**.
     * // color[v] gives vertices on one side of bipartition
     */
    private boolean[] color;
    /**.
     * // marked[v] = true iff v has been visited in DFS
     */
    private boolean[] marked;
    /**.
     * // edgeTo[v] = last edge on path to v
     */
    private int[] edgeTo;
    /**.
     * // odd-length cycle
     */
    private Stack<Integer> cycle;
    /**.
     * Determines whether an undirected graph is bipartite and finds either a
     * bipartition or an odd-length cycle.
     *
     * @param  graph the graph
     */
    public Bipartite(final Graph graph) {
        isBipartite = true;
        color  = new boolean[graph.numberofVertices()];
        marked = new boolean[graph.numberofVertices()];
        edgeTo = new int[graph.numberofVertices()];

        for (int v = 0; v < graph.numberofVertices(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
        //assert check(graph);
    }
    /**Time complexity is degree(V) as it checks number of adjacent.
     *vertices for given vertex
     * runs dfs
     *
     * @param      graph1  The graph 1
     * @param      v       { vertex }
     */
    private void dfs(final Graph graph1, final int v) {
        marked[v] = true;
        for (int w : graph1.adj(v)) {

            // short circuit if odd-length cycle found
            if (cycle != null)  {
                return;
            }

            // found uncolored vertex, so recur
            if (!marked[w]) {
                edgeTo[w] = v;
                color[w] = !color[v];
                dfs(graph1, w);
            } else if (color[w] == color[v]) {
                isBipartite = false;
                cycle = new Stack<Integer>();
                cycle.push(w);
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
            }
        }
    }
    /**.
     * Returns true if the graph is bipartite.
     *Time complexity is constant as each statement executes only once
     * @return {@code true} if the graph is bipartite; {@code false} otherwise
     */
    public boolean isBipartite() {
        return isBipartite;
    }
    /**.
     * Returns an odd-length cycle if the graph is not bipartite, and
     * {@code null} otherwise.
     *
     * @return an odd-length cycle if the graph is not bipartite
     *         (and hence has an odd-length cycle), and {@code null}
     *         otherwise
     */
    public Iterable<Integer> oddCycle() {
        return cycle;
    }
    /**.
     * checks if the given vertex is valid or not
     *Time complexity is constant as each statement executes only once
     * @param      v     { vertex of int type }
     */
    private void validateVertex(final int v) {
        int vertex = marked.length;
        if (v < 0 || v >= vertex) {
            throw new
            IllegalArgumentException("vertex " + v
                                     + " is not between 0 and " + (vertex - 1));
        }
    }
}
