package linkedLists;


public class SinglyLinkedList {
	ListNode head = null;
	int length = 0;

	class ListNode {

		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}

	public void addAtBegin(int n) {
		ListNode newNode= new ListNode(n);
		if (head == null) {
			head = newNode;
			length++;
		} else {
			newNode.setNext(head);
			head = newNode;
			length++;
		}
	}

	public void addAtEnd(int n) {
		ListNode newNode = new ListNode(n);
		ListNode temp = head;
		if (head == null) {
			head = newNode;
			length++;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newNode);
			length++;
		}
	}

	public void insertAtPosition(int position, int n) {
		ListNode newNode = new ListNode(n);
		ListNode temp = head;
		ListNode current = null;

		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}
		if (head == null) {
			head = newNode;
			length++;
		} else if (position == 0) {
			newNode.setNext(head);
			head = newNode;
			length++;
		} else {
			for (int i = 0; i < position; i++) {
				current = temp;
				temp = temp.getNext();
			}
			newNode.setNext(temp);
			current.setNext(newNode);
			length++;
		}

	}

	public void deleteAtBegin() {
		ListNode temp;

		if (head.getNext() == null) {
			head = null;
			length--;
		} else {
			temp = head.getNext();
			head = temp;
			length--;
		}
	}

	public void deleteAtEnd() {
		ListNode current = null;
		ListNode temp = head;
		if (head.getNext() == null) {
			head = null;
			length--;
		} else {
			while (temp.getNext() != null) {
				current = temp;
				temp = temp.getNext();
			}
			temp = null;
			current.setNext(null);
			length--;
		}
	}

	public void deleteAtPosition(int position) {
		ListNode current = null;
		ListNode tempNext = null;
		ListNode temp = head;

		if (position < 0) {
			position = 0;
		}
		if (position >= length) {
			position = length - 1;
		}
		if (head.getNext() == null) {
			head = null;
			length--;
		} else if (position == 0) {
			temp = head.getNext();
			head = temp;
			length--;
		} else {
			for (int i = 0; i < position; i++) {
				current = temp;
				temp = current.getNext();
				tempNext = temp.getNext();
			}
			current.setNext(tempNext);
			length--;
		}
	}

	// Not Working
	public void removeMatchedNode(ListNode newNode) {
		ListNode temp = head;
		ListNode current = null;
		if (head == null) {
			return;
		} else {
			System.out.println(newNode + "New Node");
			while (!temp.getNext().equals(newNode)) {
				System.out.println(temp + "Temp");
				current = temp;
				temp = temp.getNext();
			}
			current.setNext(temp.getNext().getNext());
		}
	}

	public void getPosition(int data) {
		int position = 0;
		ListNode temp = head;

		if (head == null) {
			System.out.println("No data in list");
		} else {
			try {
				while (temp.getData() != data) {
					temp = temp.getNext();
					position = position + 1;
				}
				System.out.println(position);
			} catch (Exception e) {
				System.out.println("Element not found in the list");
			}

		}
	}

	public void getDataFromList() {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println("Length: " + length);
	}

	public static void main(String[] args){
		 SinglyLinkedList list=new SinglyLinkedList();
		 list.addAtBegin(4);
		 list.addAtBegin(8);
		 list.addAtBegin(7);
		 list.addAtBegin(15);
		 list.addAtEnd(24);
		 list.addAtEnd(38);
		 list.addAtEnd(47);
		 list.addAtEnd(55);
		 list.insertAtPosition(0,0);
		 list.insertAtPosition(4,100);
		 
		 System.out.println("Before Deletion: "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		 list.deleteAtBegin();		 
		 System.out.println("After Deletion at Begin: "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		 list.deleteAtEnd();
		 System.out.println("After Deletion at End: "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		 list.deleteAtPosition(0);
		 System.out.println("After Deletion at Position 0: "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		 list.deleteAtPosition(7);
		 System.out.println("After Deletion at Position Length: "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		 list.deleteAtPosition(3);
		 System.out.println("After Deletion at Position : "); 
		 list.getDataFromList();
		 System.out.println("\n"); 
		 
		
		 System.out.println("Position of the given data: "); 
		 list.getPosition(55);
		 System.out.println("\n"); 
		 
		/* list.removeMatchedNode(new ListNode(7));
		 System.out.println("After Deletion Of Matched Node : "); 
		 list.getData();*/
		 
		 
	 }
}
