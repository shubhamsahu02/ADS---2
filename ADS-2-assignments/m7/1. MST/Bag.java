/**.
 * imports iterator packagae
 */
import java.util.Iterator;
/**.
 * imports nosuchelementexception
 */
import java.util.NoSuchElementException;
/**.
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * number of elements in bag
     */
    private int numberofelementinbag;
    /**.
     * beginning of bag
     */
    private Node first;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * item of type item
         */
        private Item item;
        /**.
         * next of NOde type
         */
        private Node next;
    }


    /**.
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        numberofelementinbag = 0;
    }

    /**.
      * Is the BAG empty?
      * Time complesxity is constant as each statement is executed only once
      * @return is boolean type
      */
    public boolean isEmpty() {
        return first == null;
    }

    /**.
      * Return the number of items in the bag.
      * Time complesxity is constant as each statement is executed only once
      * @return returns size of bag of int type
      */
    public int size() {
        return numberofelementinbag;
    }
    /**.
      * Add the item to the bag.
      * Time complesxity is constant as each statement is executed only once
      *@param item of item type
      */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        numberofelementinbag++;
    }
    /**.
      * Return an iterator that iterates over the items in the bag.
      * @return Listiterator
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**.
         * current of Node type
         */
        private Node current = first;
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext()  {
            return current != null;
        }
        /**.
         * checks if next vertex is there or not
         *
         * @return     { returns item of ITem type }
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}


