class ReverseSinglyLinkedList {
	
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

	public void reverseList() {
		LinkedList newNode = head;
		LinkedList prevv = null;
		while(newNode != null) {
			LinkedList temp = newNode.next;
			newNode.next = prevv;
			prevv = newNode;
			newNode = temp;
		}
		head = prevv;
	}
	public void recurrsiveReverseList() {
		head = reverse(head);
	}
	static LinkedList reverse(LinkedList head) { 
        if(head == null) { 
            return head; 
        } 
  
        // last node or only one node 
        if(head.next == null) { 
            return head; 
        } 
  
        LinkedList newHeadNode = reverse(head.next); 
  
        // change references for middle chain 
        head.next.next = head; 
        head.next = null; 
  
        // send back new head node in every recursion 
        return newHeadNode; 
    } 


	public static void main(String[] args) {
		ReverseSinglyLinkedList head = new ReverseSinglyLinkedList();	
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
		System.out.println( "Unreversed " + head.toString());

		head.reverseList();
		System.out.println(" Reversed " + head.toString());

		head.recurrsiveReverseList();
		System.out.println(" Reversed " + head.toString());

	}
}