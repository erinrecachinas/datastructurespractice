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

	public Node findParent(Node n, Node r) {
		if (n == root) {
			return null;
		}
		if (r == null) {
			return null;
		}
		else if (r.getRight() != null && r.getRight() == n) 
			return r;
		else if (r.getLeft() != null && r.getLeft() == n) 
			return r;
		else {
			if (r.getVal() > n.getVal()) {
				return findParent(n,r.getLeft());
			}
			else return findParent(n,r.getRight());
		}
	}
	public Node findParent(Node n) {
		return findParent(n,root);
	}

	public void remove(int i, Node n) {
		Node r = find(i,n);
		if(r != null) {
			Node p = findParent(r);
		if (p != null) {
			boolean isLeft = false;
			if (p.getLeft() == r) {
				isLeft = true;
			}
			if (r.getRight() == null && r.getLeft() == null) {
				if (!isLeft) {
					p.setRight(null);
				}
				else p.setLeft(null);
				return;
			}
			else if (r.getRight() == null && r.getLeft() != null) {
				if (!isLeft) {
					p.setRight(r.getLeft());
					return;
				}
				else p.setLeft(r.getLeft());
				return;
			}
			else if (r.getRight() != null && r.getLeft() == null) {
				if (!isLeft) {
					p.setRight(r.getRight());
					return;
				}
				else p.setLeft(r.getRight());
				return;
			}
			else {
				Node succ = findMaxLeft(r.getLeft());
				remove(succ);
				r.setVal(succ.getVal());
				return;
			}
		}
		
		else {
			if(r != null) {
				if (r.getRight() == null && r.getLeft() == null) {
					r = null;
					return;
				}
				else if (r.getRight() == null && r.getLeft() != null) {
					r = r.getLeft();
					return;
				}
				else if (r.getRight() != null && r.getLeft() == null) {
					r = r.getRight();
					return;
				}
				else {
					Node succ = findMaxLeft(r.getLeft());
					
					remove(succ);
					r.setVal(succ.getVal());
				}
				return;
			}
		}
		return;
	}
		return;
	}

	public void remove(int i) {
		remove(i,root);
	}

	public void remove(Node n) {
		if (n!=null) {
			boolean isLeft = false;
			Node p = findParent(n);
			if (p != null) {
				if (p.getLeft() == n) {
					isLeft = true;
				}
				if (n.getRight() == null && n.getLeft() == null) {
					if (!isLeft) {
						p.setRight(null);
					}
					else p.setLeft(null);
					return;
				}
				else if (n.getRight() == null && n.getLeft() != null) {
					if (!isLeft) {
						p.setRight(n.getLeft());
						return;
					}
					else p.setLeft(n.getLeft());
					return;
				}
				else if (n.getRight() != null && n.getLeft() == null) {
					if (!isLeft) {
						p.setRight(n.getRight());
						return;
					}
					else p.setLeft(n.getRight());
					return;
				}
				else {
					Node succ = findMaxLeft(n.getLeft());
					remove(succ);
					n.setVal(succ.getVal());
					return;
				}
			}
		}
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
		t.insert(7,t.root);
		t.insert(6,t.root);
		t.insert(8,t.root);
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
		System.out.println("Removing 1...");
		t.remove(1);
		t.printTree(t.root);
		System.out.println("Removing 2...");
		t.remove(2,t.root);
		t.printTree(t.root);
		System.out.println("Removing 5...");
		t.remove(5);
		t.printTree(t.root);
	}
}

