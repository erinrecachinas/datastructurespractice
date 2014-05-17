
public class List {
	private Node head;
	private Node tail;
	private ListItr itr;
	public List() {
		head = new Node();
		tail = new Node();
		itr = new ListItr(head);
		head.setNext(tail);
		tail.setPrev(head);
	}

	public ListItr getItr() {
		itr.setCurr(head);
		return itr;
	}

	public void insertAtHead(int i) {
		Node temp = new Node(i);
		temp.setNext(head.getNext());
		head.getNext().setPrev(temp);
		temp.setPrev(head);
		head.setNext(temp);
	}

	public void insertAtTail(int i) {
		Node temp = new Node(i);
		temp.setPrev(tail.getPrev());
		tail.getPrev().setNext(temp);
		temp.setNext(tail);
		tail.setPrev(temp);

	}



	public void insertAfter(int i, Node n) {
		itr.setCurr(n);
		Node temp = new Node(i);
		temp.setNext(n.getNext());
		temp.setPrev(n);
		n.getNext().setPrev(temp);
		n.setNext(temp);
	}

	public void insertBefore(int i, Node n) {
		itr.setCurr(n);
		Node temp = new Node(i);
		temp.setNext(n);
		temp.setPrev(n.getPrev());
		n.getPrev().setNext(temp);
		n.setPrev(temp);
	}

	public void remove(int i) {
		Node temp = find(i);
		if (temp != null) {
			Node p = temp.getPrev();
			Node n = temp.getNext();
			p.setNext(n);
			n.setPrev(p);
			temp = null;
		}
	}

	public Node find(int i) {
		itr.setCurr(head);
		while (itr.getCurr() != null) {
			if (itr.getCurr().getVal() == i) {
				return itr.getCurr();
			}
			else {
				itr.moveForward();
			}
		}
		return null;
	}


	public void printList() {
		itr.setCurr(head.getNext());
		System.out.print("HEAD<-->");
		while (itr.getCurr() != tail) {
			System.out.print(itr.getCurr().getVal() + "<-->");
			itr.moveForward();
		}
		System.out.println("TAIL");
	}

	public static void main(String[] args) {
		List l = new List();
		l.printList();
		System.out.println("Inserting 1..");
		l.insertAtHead(1);
		System.out.println("Inserting 2..");
		l.insertAtTail(2);
		System.out.println("Inserting 3..");
		l.insertAtTail(3);
		l.printList();
		System.out.println("Inserting 4 after 3..");
		Node temp = l.find(3);
		l.insertAfter(4,temp);
		l.printList();
		System.out.println("Inserting 0 before 1..");
		temp = l.find(1);
		l.insertBefore(0,temp);
		l.printList();
		System.out.println("Removing 2..");
		l.remove(2);
		l.printList();
		System.out.println("Trying to find 5..");
		temp = l.find(5);
		if (temp == null) {
			System.out.println("Couldn't find 5");
		}
	}	
}