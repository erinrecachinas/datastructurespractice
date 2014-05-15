
public class Node {
	private int value;
	private Node next;

	public Node(int val) {
		value = val;
		next = null;
	}

	public Node() {
		value = 0;
		next = null;
	}

	public void setVal(int val) {
		value = val;
	}

	public void setNext(Node n) {
		next = n;
	}

	public int getVal() {
		return value;
	}

	public Node getNext() {
		return next;
	}

}