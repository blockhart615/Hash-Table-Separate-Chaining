package pkg328.lab.pkg5;

/**
 *
 * @author Brett
 */
public class LinkedList {

    private Node head, tail;
    private int size;

    public LinkedList() {
	size = 0;
	head = tail = null;
    }

    /**
     * Internal Node Class
     */
    private class Node {

	int data;
	Node next, previous;

	public Node(int value) {
	    this.data = value;
	    next = previous = null;
	}

	public Node(int value, Node previous, Node next) {
	    this.data = value;
	    this.previous = previous;
	    this.next = next;
	}

	public Node getNext() {
	    return next;
	}

	public Node getPrevious() {
	    return previous;
	}

	public int getData() {
	    return data;
	}

	public boolean hasNext() {
	    return next != null;
	}
    }

    /**
     *
     * @param value
     */
    public void add(int value) {
	if (size == 0) {
	    head = tail = new Node(value);
	} else {
	    tail = tail.next = new Node(value, tail, null);
	}
	size++;
    }

    /**
     * Checks if the linked list containsa value
     *
     * @param data
     * @return
     */
    public boolean contains(int data) {
	Node current = head;
	
	if (current == null)
	    return false;

	if (current != null && current.getData() == data) {
	    return true;
	}

	while ((current.hasNext() && current != null) || current == head) {
	    current = current.getNext();
	    if (current != null) {
		if (current.getData() == data) {
		    return true;
		}
	    }
	    else
		return false;
	}
	return false;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
	return size == 0;
    }

    /**
     *
     * @param index
     * @return
     */
    public int get(int index) {
	Node current = head;
	for (int i = 0; i < index; i++) {
	    if (current.hasNext()) {
		current = current.getNext();
	    }
	}
	return current.getData();
    }

    /**
     *
     * @return
     */
    public int size() {
	return size;
    }

}
