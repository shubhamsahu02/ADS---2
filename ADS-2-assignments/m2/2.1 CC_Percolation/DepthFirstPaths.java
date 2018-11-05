/**.
 * Class for depth first paths.
 */
class DepthFirstPaths {
    /**.
     * Marked array of type boolean.
     */
    private boolean[] marked;
    /**.
     * edgeTo array of type int.
     */
    private int[] edgeTo;
    /**.
     * s of type int.
     */
    private final int s;
    /**.
     * Constructs the object for DepthFirstPaths.
     *
     * @param      g     { graph }
     * @param      s1     { source vertex }
     */
    DepthFirstPaths(final Graph g, final int s1) {
        this.s = s1;
        edgeTo = new int[g.numberofVertices()];
        marked = new boolean[g.numberofVertices()];
        validateVertex(s);
        dfs(g, s);
    }
    /**.
     * { dfs }.
     *
     * @param      g    { graph }
     * @param      v     { vertex }
     */
    private void dfs(final Graph g, final int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }
    /**.
     * Determines if it has path to.
     * Time complexity is constant.
     * @param      v     { vertex }
     *
     * @return     True if has path to, False otherwise.
     */
    public boolean hasPathTo(final int v) {
        validateVertex(v);
        return marked[v];
    }
    /**.
     * { validate vertex or not }.
     *
     * @param      v1    { v }
     */
    private void validateVertex(final int v1) {
        int v = marked.length;
        if (v1 < 0 || v1 >= v) {
            throw new IllegalArgumentException(
                "vertex " + v1 + " is not between 0 and " + (v - 1));
        }
    }
}
