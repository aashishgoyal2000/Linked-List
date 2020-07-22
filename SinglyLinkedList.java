class SinglyLinkedList {
	
	class LinkedList {
		int node;
		LinkedList next;
		LinkedList() {
			next = null;
		}
		void setNode(int key) {
			this.node = key;
		}
		int getNode() {
			return node;
		}
	}

	LinkedList head;
	LinkedList current;

	public void PushFront(int node) {
		if (head == null) {
			LinkedList newNode = new LinkedList();
			newNode.node = node;
			newNode.next = null;
			head = newNode;
			current = newNode;
			return;			
		}
		LinkedList newNode = new LinkedList();
		newNode.node = node;
		newNode.next = head;
		head = newNode;
	}

	public int TopFront() {
		return head.node;
	}

	public int PopFront() {
		int temp = head.node;
		head = head.next;
		return temp;
	}
	public void PushBack(int node) {
		if (head == null) {
			LinkedList newNode = new LinkedList();
			newNode.node = node;
			newNode.next = null;
			head = newNode;
			current = newNode;
			return;
		}
		LinkedList newNode = new LinkedList();
		newNode.node = node;
		newNode.next = null;
		current.next = newNode;
		current = current.next;
	}

	public int TopBack() {
		return current.node;
	}

	public int PopBack() {
		if (head == null) {
			return -1;
		}
		int temp = current.node;
		LinkedList newNode = head;
		while(newNode.next != current) {
			newNode = newNode.next;
		}
		current = newNode;
		current.next = null;
		return temp;
	}
	
	boolean Find(int key) {
		LinkedList newNode = head;
		while(newNode.next != null && newNode.node != key) {
			newNode = newNode.next;
		}
		if (newNode.node == key) {
			return true;
		} else
		return false;
	}

	public void Erase(int key) {
		if (head.node == key) {
			head = head.next;
			return;
		}
		LinkedList newNode = head;
		while(newNode.next != null && newNode.next.node != key) {
			newNode = newNode.next;
		}
		newNode.next = newNode.next.next;	
	}

	boolean Empty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void addBefore(int node, int key) {
		LinkedList newNode = head;
		while(newNode.next != null && newNode.next.node != node) {
			newNode = newNode.next;
		}
		LinkedList tempNode = new LinkedList();
		tempNode.node = key;
		tempNode.next = newNode.next;
		newNode.next = tempNode;
	}

	public String toString() {
		LinkedList newNode = head;
		String ss = "";
		while(newNode!= null) {
			ss = ss + newNode.node + "  ";
			newNode = newNode.next;
		}
		return ss;
	}

	public static void main(String[] args) {
		SinglyLinkedList head = new SinglyLinkedList();	
		System.out.println("isEmpty : " + head.Empty());

		head.PushBack(7);
		head.PushBack(8);
		head.PushBack(9);
		head.PushBack(10);
		head.PushBack(11);
		head.PushBack(12);

		head.PushFront(6);
		head.PushFront(5);
		head.PushFront(4);
		head.PushFront(3);
		head.PushFront(2);
		head.PushFront(1);
		System.out.println("After insert from front and end " + head.toString());
		int temp = 3;
		head.addBefore(temp, 4);
		System.out.println("Deleting "+ temp + " , result = " + head.toString());

		System.out.println("isEmpty : " + head.Empty());

	}
}