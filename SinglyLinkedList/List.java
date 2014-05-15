
public class List {
	private Node head;
	private ListItr itr;
	public List() {
		head = new Node();
		itr = new ListItr(head);
	}

	public void insertAtHead(int i) {
		Node temp = new Node(i);
		temp.setNext(head.getNext());
		head.setNext(temp);
	}

	public void insertAfter(int i, Node n) {
		itr.setCurr(n);
		Node temp = new Node(i);
		temp.setNext(n.getNext());
		n.setNext(temp);
	}

	public void remove(int i) {
		Node temp = findPrev(i);
		if (temp != null) {
			Node toRemove = temp.getNext();
			if (toRemove.getNext() != null) {
				temp.setNext(toRemove.getNext());
				toRemove = null;
			}
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

	public Node findPrev(int i) {
		ListItr parent = new ListItr(head);
		itr.setCurr(head.getNext());
		while (itr.getCurr() != null) {
			if (itr.getCurr().getVal() == i) {
				return parent.getCurr();
			}
			else {
				itr.moveForward();
				parent.moveForward();
			}
		}
		return null;
	}

	public void printList() {
		itr.setCurr(head.getNext());
		while (itr.getCurr() != null) {
			System.out.print(itr.getCurr().getVal() + "-->");
			itr.moveForward();
		}
		System.out.println("NULL");
	}

	public static void main(String[] args) {
		List l = new List();
		l.printList();
		System.out.println("Inserting 1..");
		l.insertAtHead(1);
		System.out.println("Inserting 2..");
		l.insertAtHead(2);
		System.out.println("Inserting 3..");
		l.insertAtHead(3);
		l.printList();
		System.out.println("Inserting 4 after 3..");
		Node temp = l.find(3);
		l.insertAfter(4,temp);
		l.printList();
		System.out.println("Removing 2..");
		l.remove(2);
		l.printList();
	}	
}