/**.
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**.
     * marked[v] = has vertex v been marked?
     */
    private boolean[] marked;
    /**.
     * edgeTo[v] = previous vertex on path to v
     */
    private int[] edgeTo;
    /**.
     *  onStack[v] = is vertex on the stack?
     */
    private boolean[] onStack;
    /**.
     * // directed cycle (or null if no such cycle)
     */
    private Stack<Integer> cycle;
    /**.
     * Determines whether the digraph {@code G}
     * has a directed cycle and, if so,
     * finds such a cycle.
     * @param digraph the digraph
     */
    public DirectedCycle(final Digraph digraph) {
        marked  = new boolean[digraph.numberofVertices()];
        onStack = new boolean[digraph.numberofVertices()];
        edgeTo  = new int[digraph.numberofVertices()];
        for (int v = 0; v < digraph.numberofVertices(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(digraph, v);
            }
        }
    }
    /**.
     * / check that algorithm computes either the
     *  topological order or finds a directed cycle
     *
     * @param      digraph1     { Digraph digraph1 }
     * @param      v     { vertex of int type }
     */
    private void dfs(final Digraph digraph1, final int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph1.adj(v)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(digraph1, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
                assert check();
            }
        }
        onStack[v] = false;
    }

    /**.
     * Does the digraph have a directed cycle?
     * Time complexity is constant as each statement is executed only once.
     * @return {@code true} if the digraph has a directed cycle,
     *  {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }
    /**.
     * Returns a directed cycle if the digraph has a directed cycle,
     * and {@code null} otherwise.
     * @return a directed cycle (as an iterable)
     *  if the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**.
     * certify that digraph has a directed cycle if it reports one
     *
     * @return     { returns true if there is a cycle }
     */
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
                System.err.printf("cycle begins with %d and ends with %d\n",
                                  first, last);
                return false;
            }
        }
        return true;
    }
}