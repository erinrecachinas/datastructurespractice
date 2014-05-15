
public class Node {
	private int value;
	private boolean init;
	private Node left;
	private Node right;

	public Node(int val) {
		value = val;
		left = null;
		right = null;
		init = true;
	}

	public Node() {
		value = 0;
		init = false;
		left = null;
		right = null;
	}

	public void setVal(int val) {
		value = val;
	}

	public void initialize() {
		init = true;
	}

	public void setLeft(Node n) {
		left = n;
	}

	public void setRight(Node n) {
		right = n;
	}

	public int getVal() {
		return value;
	}

	public boolean getInit() {
		return init;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

}