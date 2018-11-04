/**.
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class LinearProbingHashST<Key, Value> {
    /**.
     * capacity of int type
     */
    private static final int INIT_CAPACITY = 4;
    /**.
     * n number of key value pairs of int type
     */
    private int n;
    /**.
     * m of int type size of hash table
     */
    private int m;
    /**.
     * keys of Key array
     */
    private Key[] keys;
    /**.
     * values of Value type
     */
    private Value[] vals;
    /**.
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**.
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    /**.
     * Returns the number of key-value pairs in this symbol table.
     * Time complexity is constant because each statement is executed only once.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**.
     * hash funciton
     * Time complexity is constant because each statement is executed only once.
     * @param      key   The key
     *
     * @return     {hash number of int tuype }
     */
    private int hash(final Key key) {
        return (key.hashCode() * (2 + 2 + 1 + 2 + 2 + 1 + 1)) % m;
    }
    /**.
     * check if the key contains or not
     * Time complexity is constant because each statement is executed only once.
     * @param      key   The key
     *
     * @return     { returns true if key contained else false}
     */
    public boolean contains(final Key key) {
        if (key == null) {
            throw new
            IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }
    /**.
     * resizes the array
     * Time complexity is N because loop iterates till end.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp =
            new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }
    /**.
     * Inserts the specified key-value pair into the symbol
     * table, overwriting the old
     * Time complexity is N because loop iterates till end.
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        if (key == null) {
            throw new
            IllegalArgumentException("first argument to put() is null");
        }
        if (val == null) {
            delete(key);
            return;
        }
        // double table size if 50% full
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**.
     * Returns the value associated with the specified key.
     * Time complexity is N because loop iterates till end.
     * @param      key   The key
     *
     * @return     {gets value of Key of value type }
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new
            IllegalArgumentException("argument to get() is null");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    /**.
     * Removes the specified key and its associated value from this symbol table
     * Time complexity is N because loop iterates till end.
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new
            IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }
        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }

        // delete key and associated value
        keys[i] = null;
        vals[i] = null;

        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
        // halves size of array if it's 12.5% full or less
        if (n > 0 && n <= m / (2 + 2 + 2 + 2)) {
            resize(m / 2);
        }
    }
    /**.
     * displays the hash table in dictonary format
     * TIme complexity is N because the for loop iterates till
     * the size of hashtable.
     */
    public void display() {
        if (size() == 0) {
            System.out.println("{}");
            return;
        }
        String str = "{";
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                str += keys[i] + ":" + vals[i] + ", ";
            }
        }
        str = str.substring(0, str.length() - 2);
        str += "}";
        System.out.println(str);
    }
}
