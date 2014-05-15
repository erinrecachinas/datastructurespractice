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

	public void insert(int i) {
		insert(i,root);
	}

	public Node find(int i, Node n) {
		if (n == null)
			return null;
		else {
			if(n.getVal() > i) {
				return find(i,n.getLeft());
			}
			else if (n.getVal() < i) {
				return find(i,n.getRight());
			}
			else {
				return n;
			}
		}
	}

	public Node find(int i) {
		return find(i,root);
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
				else return findParent(i,n.getLeft());
			}
			else if(n.getVal() < i) {
				if(n.getRight().getVal() == i) {
					return n;
				}
				else return findParent(i,n.getRight());
			}
			else return null;
		}
	}

	public Node findParent(int i) {
		return findParent(i,root);
	}

	public void remove(int i, Node n) {
		Node t = find(i,root);
		if (t == null) {
			System.out.print("didn't find " + i);
			return;
		}
		else if (t.getRight() != null && t.getLeft() != null) {
			Node pred = findMaxLeft(t.getLeft());
			t.setVal(pred.getVal());
			remove(pred.getVal(),t.getLeft());
		}
		else if (t.getRight() == null && t.getLeft() != null) {
			t = t.getLeft();
			return;
		}
		else if (t.getRight() != null && t.getLeft() == null) {
			t = t.getRight();
			return;
		}
		else {
			t = null;
			return;
		}
	}

	public void remove(int i) {
		remove(i,root);
	}

	public Node findMaxLeft(Node n) {
		if (n.getRight() != null)
			return findMaxLeft(n.getRight());
		else return n;
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
		System.out.println("");
		Node temp = t.find(0,t.root);
		System.out.println("Finding 0..");
		if (temp != null) {
			System.out.println("found 0!");
		}
		System.out.println("Removing 2...");
		t.remove(2,t.root);
		t.printTree(t.root);
	}
}

