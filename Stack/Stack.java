

public class Stack {

	private List stack;
	private int count;
	private ListItr last;

	public Stack() {
		stack = new List();
		last = stack.getItr();
		count = 0;
	}
	
	public void push(int i) {
		stack.insertAtHead(i);
		count++;
		stack.printList();
	}	

	public int pop() {
		if (!isEmpty()) {
			last = stack.getItr();
			last.moveForward();
			int r = last.getCurr().getVal();
			stack.remove(r);
			count--;
			stack.printList();
			return r;
		}
		else {
			System.out.println("Error: Stack underflow...");
			return 0;
		}

	}

	public boolean isEmpty() {
		if (count == 0) return true;
		else return false;
	}

	public int top() {
		if (!isEmpty()) {
			last = stack.getItr();
			last.moveForward();
			return last.getCurr().getVal();
		}
		else {
			System.out.println("Error: Stack underflow...");
			return 0;
		}
	}

	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println("Push 1..");
		s.push(1);
		System.out.println("Push 5..");
		s.push(5);
		System.out.println("Push 8..");
		s.push(8);
		System.out.println("top: " + s.top());
		System.out.println("Pop..");
		s.pop();
		System.out.println("top: " + s.top());
		System.out.println("Pop..");
		s.pop();
		System.out.println("top: " + s.top());
		System.out.println("Pop..");
		s.pop();
		System.out.println("top: " + s.top());
		System.out.println("Pop..");
		s.pop();


	}
}

