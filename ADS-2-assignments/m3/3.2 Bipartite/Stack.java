/**
 * imports iterator package
 */
import java.util.Iterator;
/**.
 * imports NoSuchElementException package
 */
import java.util.NoSuchElementException;
/**.
 * class for Stack
 *
 * @param      <Item>  The item
 */
public class Stack<Item> implements Iterable<Item> {
    /**.
     * size of the stack
     */
    private int size;
    /**.
     * // top of stack
     */
    private Node first;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * item of Item type
         */
        private Item item;
        /**.
         * Next of node type
         */
        private Node next;
    }

    /**.
      * Create an empty stack.
      */
    public Stack() {
        first = null;
        size = 0;
    }
    /**.
      * Is the stack empty?
      * @return boolean type
      */
    public boolean isEmpty() {
        return first == null;
    }
    /**.
      * Return the number of items in the stack.
      * @return size of Stack
      */
    public int size() {
        return size;
    }
    /**.
      * Add the item to the stack.
      * TIme complexity is constant bcz each statement is executed onlyonce.
      * @param item item of type ITem
      */
    public void push(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }
    /**.
      * Delete and return the item most recently added to the stack.
      * Throw an exception if no such item exists because the stack is empty.
      * TIme complexity is constant bcz each statement is executed onlyonce.
      * @return return the saved item
      */
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        size--;
        return item;                   // return the saved item
    }
    /**
      * Return the item most recently added to the stack.
      * Throw an exception if no such item exists because the stack is empty.
      * @return returns recently added to stack
      */
    public Item peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return first.item;
    }
    /**.
      * Return string representation.
      * Time complexity is N bcz for iterates till the end of loop.
      * @return returns String
      */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();
    }
    /**.
      * Return an iterator to the stack that
      * iterates through the items in LIFO order.
      * @return returns new List iterator
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        /**.
         * curent of Node type
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
         * removes function
         */
        public void remove()      {
            throw new UnsupportedOperationException();
        }
        /**.
         * checks if next is there or not
         *
         * @return     { item of Item type }
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
