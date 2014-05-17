
public class Node {
	private int value;
	private Node next;
	private Node prev;

	public Node(int val) {
		value = val;
		next = null;
		prev = null;
	}

	public Node() {
		value = 0;
		next = null;
		prev = null;
	}

	public void setVal(int val) {
		value = val;
	}

	public void setNext(Node n) {
		next = n;
	}

	public void setPrev(Node n) {
		prev = n;
	}

	public int getVal() {
		return value;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrev() {
		return prev;
	}

}