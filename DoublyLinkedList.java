class DoublyLinkedList {
	
	class Node {
		Node prev;
		int node;
		Node next;
		Node() {
			prev = null;
			next = null;
		}
	}

	Node head;
	Node current;

	public void PushFront(int node) {
		if (head == null) {
			head = new Node();
			head.node = node;
			current = head;
			return;
		}
		Node newNode = new Node();
		newNode.node = node;
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	public int TopFront() {
		return head.node;
	}

	public int PopFront() {
		int temp = head.node;
		head = head.next;
		head.prev = null;
		return temp;
	}
	
	public void PushBack(int node) {
		if (head == null) {
			head = new Node();
			head.node = node;
			current = head;
			return;
		}
		Node newNode = new Node();
		newNode.node = node;
		newNode.prev = current;
		current.next = newNode;
		current = current.next;
	}

	public int TopBack() {
		return current.node;
	}

	public int PopBack() {
		int temp = current.node;
		current = current.prev;
		current.next = null;
		return temp;
	}
	
	boolean Find(int key) {
		Node newNode = head;
		while(newNode != null) {
			if (newNode.node == key) {
				return true;
			}
			newNode = newNode.next;
		}
		return false;
	}

	public void Erase(int key) {
		Node newNode = head;
		if (head.node == key) {
			head = head.next;
			head.prev = null;
			return;
		} else if (current.node == key) {
			current = current.prev;
			current.next = null;
		}
		while(newNode != null) {
			if (newNode.node == key) {
				Node temp = newNode;
				newNode.prev.next = temp.next;
				temp.next.prev = temp.prev; 
				return;
			}
			newNode = newNode.next;
		}
	}

	boolean Empty() {
		if (head == null) {
			return true;
		}
		return false;
	}

	public void addBefore(int node, int key) {
		
		if (head.node == node) {
			Node newNode = new Node();
			newNode.node = key;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
			return;
		}
		Node newNode = head;
		while(newNode != null) {
			if (newNode.node == node) {
				Node temp = new Node();
				temp.node = key;
				temp.prev = newNode.prev;
				temp.next = newNode;
				newNode.prev.next = temp;
				newNode.prev = temp;
				return;
			}
			newNode = newNode.next;
		}
	}

	public String toString() {
		Node newNode = head;
		String s = "";
		while(newNode != null) {
			s += newNode.node + " ";
			newNode = newNode.next;
		}
		return s;	
	}

	public static void main(String[] args) {
		DoublyLinkedList head = new DoublyLinkedList();	

		head.PushFront(1);
		head.PushFront(2);
		head.PushFront(3);
		head.PushFront(4);
		head.PushFront(5);
		head.PushFront(6);
		
		head.PushBack(7);
		head.PushBack(8);
		head.PushBack(9);
		head.PushBack(10);
		head.PushBack(11);
		head.PushBack(12);

		System.out.println("After insert from front and end " + head.toString());

		int temp = head.PopBack();
		System.out.println("Element From Last  = " + temp);
		System.out.println("After deleting from last " + head.toString());
		temp = head.PopBack();
		System.out.println("Element From Last  = " + temp);
		System.out.println("After deleting from last " + head.toString());
		temp = head.PopBack();
		System.out.println("Element From Last  = " + temp);
		System.out.println("After deleting from last " + head.toString());
		temp = head.PopBack();
		System.out.println("Element From Last  = " + temp);
		System.out.println("After deleting from last " + head.toString());

		temp = head.PopFront();
		System.out.println("Element from front  = " + temp);
		System.out.println("After deleting from front " + head.toString());
		temp = head.PopFront();
		System.out.println("Element from front  = " + temp);
		System.out.println("After deleting from front " + head.toString());
		temp = head.PopFront();
		System.out.println("Element from front  = " + temp);
		System.out.println("After deleting from front " + head.toString());
		temp = 8;
		head.Erase(temp);
		System.out.println("Deleting "+ temp + " , result = " + head.toString());

		System.out.println("isEmpty : " + head.Empty());
		
		temp = 7;
		head.addBefore(temp, 4);
		System.out.println("Adding Before "+ temp + " , result = " + head.toString());

		System.out.println("isEmpty : " + head.Empty());

	}
}