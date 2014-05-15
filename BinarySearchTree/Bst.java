public class Bst {
	
	private Node root;

	public Bst() {
		root = new Node();
	}

	public void insert(int i, Node n) {
		if (n != null) {
			if(n.getInit()) {
				if(n.getVal() > i) {
					if (n.getLeft() != null)
						insert(i,n.getLeft());
					else {
						n.setLeft(new Node(i));
						return;
					}

				}
				else if (n.getVal() < i) {
					if (n.getRight() != null)
						insert(i,n.getRight());
					else {
						n.setRight(new Node(i));
						return;
					}
				}
				else {
					return;
				}
			}
			else {
				n.setVal(i);
				n.initialize();
			}
		}
		else {
			n = new Node(i);
		}
	}

	public Node find(int i, Node n) {
		if (n == null)
			return null;
		else {
			if(n.getVal() > i) {
				find(i,n.getLeft());
			}
			else if (n.getVal() < i) {
				find(i,n.getRight());
			}
			else {
				return n;
			}
		}
		return null;
	}

	public Node findParent(int i, Node n) {
		if (n == null) {
			return null;
		}
		else {
			if(n.getVal() > i) {
				if (n.getLeft().getVal() == i) {
					return n;
				}
				else findParent(i,n.getLeft());
			}
			else if(n.getVal() < i) {
				if(n.getRight().getVal() == i) {
					return n;
				}
				else findParent(i,n.getRight());
			}
			else return null;
		}
	}

	public void remove(int i) {
		Node t = find(i,root);
		if (n == null)
			return;
		else if (n.getVal() > i) {
			//left
		}
		else if (n.getVal() < i) {
			//right
		}

	}

	public void printTree(Node n) {
		if(n!=null) {
			System.out.print(n.getVal() + " ");
			printTree(n.getLeft());
			printTree(n.getRight());
		}	
		else return;
		
	}
	public static void main(String[] args) {
		Bst t = new Bst();
		t.insert(5,t.root);
		t.insert(6,t.root);
		t.insert(1,t.root);
		t.insert(2,t.root);
		t.insert(0,t.root);
		t.insert(3,t.root);
		t.printTree(t.root);
		Node temp = t.find(0);
		System.out.print("Finding 0..");
		if (temp != null) {
			System.out.print("found 0!");
		}
	}
}

