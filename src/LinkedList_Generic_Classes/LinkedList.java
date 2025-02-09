package LinkedList_Generic_Classes;

class node<T> {
    public T elem;
    public node<T> next;  // Fixed: Use generic type for next pointer

    public node(T elem) {
        this.elem = elem;
        next = null;
    }

    public node() {
        this.elem = null;
        next = null;
    }
}

public class LinkedList<T> {
    private node<T> head;
    private node<T> tail;
    private int size;

    public LinkedList() {
        head = tail = null; // No need to initialize with empty nodes
        size = 0;
    }

    public void add(T elem) {
        node<T> newnode = new node<>(elem);
        if (size == 0) {  // Fixed: size should be checked before incrementing
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        size++;
    }

    public T set(T elem, int pos) {
        if (pos <= 0 || pos > size) {  // Fixed: Use || instead of &&
            throw new IllegalArgumentException("Index out of bounds");
        }
        node<T> curr = head;
        for (int i = 0; i < pos - 1; i++) {  // Fixed: Loop should run pos - 1 times
            curr = curr.next;
        }
        T removed = curr.elem;  // Use T instead of Object
        curr.elem = elem;
        return removed;
    }

    public void print() {
        node<T> curr = head;
        while (curr != null) {
            System.out.print(curr.elem + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
