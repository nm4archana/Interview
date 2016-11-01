/*
 Write a function to delete a Linked List
 
 Question Source: GeekForGeeks
 Runtime: O(1)
 
 */

package linkedLists;

public class DeleteLinkedList 
{
	static ListNode head;
	
     class ListNode
     {
    	 ListNode next;
    	 int data;
    	 
    	 ListNode(int n)
    	 {
    		 data = n;
    		 next = null;
    	 }
     }
	
     public void push(int n)
     {
    	 ListNode newNode = new ListNode(n);
    	 newNode.next = head;
    	 head = newNode; 	 
     }
     
     private static void deleteList()
     {
    	 head = null;
     }
     
	  public static void main(String[] args)
	  {
		  DeleteLinkedList linkedList = new DeleteLinkedList();
		  linkedList.push(10);
		  linkedList.push(5);
		  
		  deleteList();
		  System.out.println("The linkled list is deleted");
	  }
}
