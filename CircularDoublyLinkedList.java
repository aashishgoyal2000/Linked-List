class CircularDoublyLinkedList {
	
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
		Node newNode = new Node();
		newNode.node = node;
		if (head == null) {
			head = newNode;
			head.next = newNode;
			head.prev = newNode;
			current = head;
			return;
		}
		newNode.prev = head.prev;
		newNode.prev.next = newNode;
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	public int TopFront() {
		return head.node;
	}

	public int PopFront() {
		head.next.prev = head.prev;
		head.prev.next = head.next;
		int temp = head.node;
		head = head.next;
		return temp;
	}
	
	public void PushBack(int node) {
		
		Node newNode = new Node();
		newNode.node = node;
		if (head == null) {
			head = newNode;
			head.next = newNode;
			head.prev = newNode;
			current = head;
			return;
		}
		newNode.next = current.next;
		current.next = newNode;
		newNode.next.prev = newNode;
		newNode.prev = current;
		current = newNode;
	}

	public int TopBack() {
		return current.node;
	}

	public int PopBack() {
		current.next.prev = current.prev;
		current.prev.next = current.next;
		int temp = current.node;
		current = current.prev;
		return temp;
	}
	
	boolean Find(int key) {
		Node newNode = current;
		
		while (newNode != head) {
			if (newNode.node == key) {
				return true;
			}
		}
		
		if (newNode.node == key) {
			return true;
		}
		
	}

	// public void Erase(int key) {

	// }

	// boolean Empty() {

	// }

	// public void addBefore(int node, int key) {

	// }

	public String toString() {
		Node newNode = current;
		String s = "";		
		if (newNode == head) {
			s += head.node+" ";
			newNode = newNode.prev;
		}
		while (newNode != head) {
			s += newNode.node + " ";
			newNode = newNode.prev;
		}
		if (newNode == head) {
			s += head.node+" ";
			newNode = newNode.prev;
		}
		return s;
	}


	public static void main(String[] args) {
		CircularDoublyLinkedList list = new CircularDoublyLinkedList();

		list.PushFront(6);
		list.PushFront(7);
		list.PushFront(8);
		list.PushFront(9);
		list.PushFront(10);
		list.PushBack(5);
		System.out.println(list.toString());
		list.PushBack(4);
		list.PushBack(3);
		list.PushBack(2);
		list.PushBack(1);
		list.PushBack(0);
		System.out.println(list.toString());

		System.out.println("Deleting : " + list.TopBack());
		list.PopBack();
		System.out.println("Results : " + list.toString());
	
		System.out.println("Deleting : " + list.TopBack());
		list.PopBack();
		System.out.println("Results : " + list.toString());
	
		System.out.println("Deleting : " + list.TopBack());
		list.PopBack();
		System.out.println("Results : " + list.toString());
	
		System.out.println("Deleting : " + list.TopBack());
		list.PopBack();
		System.out.println("Results : " + list.toString());
	
		System.out.println("Deleting : " + list.TopBack());
		list.PopBack();
		System.out.println("Results : " + list.toString());
	}
}