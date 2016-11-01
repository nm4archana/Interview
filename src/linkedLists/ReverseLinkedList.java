package linkedLists;

public class ReverseLinkedList 
{
	static ListNode head;
	
  class ListNode
  {
	  int data;
	  ListNode next;
	   
	  ListNode(int n)
	  {
		  data = n;
		  next = null;
	  }	  
  }	
 
  private static ListNode reverseLinList()
  {
	 ListNode prev = null;
	 ListNode current = head;
	 
	 while(current!=null)
	 {
		 ListNode next = current.next;
		 current.next = prev;
		 prev = current;
		 current = next;
	 }
	  
	return prev;
  }
  
  private static void printList(ListNode head)
  {
	  System.out.println("The reversed list is: ");
	  while(head!=null)
	  {
		  System.out.print(head.data);
		  if(head.next!=null)
		  System.out.print("-->");
		  head = head.next;
	  }
  }
  
  public void push(int n)
  {
	  ListNode node = new ListNode(n);
      node.next=head;
      head = node;
  }
  
  public static void main(String[] args)
  {
	  ReverseLinkedList linkedList = new ReverseLinkedList();
	  linkedList.push(1);
	  linkedList.push(2);
	  linkedList.push(3);
	  linkedList.push(4);
	  linkedList.push(5);
	  ListNode head = reverseLinList();
	  printList(head);
  }
}
