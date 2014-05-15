
public class ListItr {
	
	private Node curr;

	public ListItr() {
		curr = null;
	}

	public ListItr(Node n) {
		curr = n;
	}

	public Node getCurr() {
		return curr;
	}

	public void setCurr(Node n) {
		curr = n;
	}
	
	public void moveForward() {
		curr = curr.getNext();
	}

	public void moveBackard() {
		curr = curr.getPrev();
	}

	public boolean isPastEnd() {
		if (curr.getNext() ==  null) {
			return true;
		}
		else return false;
	}
	public boolean isPastBeginning() {
		if (curr.getPrev() == null) {
			return true;
		}
		else return false;
	}
}