/*
Write a function to get Nth node in a Linked List

Write a GetNth() function that takes a linked list and an integer index and returns the data value stored in the node at that index position.

Example:
Input:  1->10->30->14,  index = 2
Output: 30  
The node at index 2 is 30

Runtime Complexity: O(n)

Question Source: GeekForGeeks
*/

package linkedLists;

public class NthNode 
{
	static ListNode head=null;
	int length = 0;
	
	class ListNode
	{
		private int data;
		private ListNode next;
		
		ListNode(int n)
		{
			data = n;
			next = null;
		}
	}
   
	private void push(int n)
	{
		ListNode node = new ListNode(n);
        node.next=head;
        head = node;
	}
	
	private static int getNthNode(int n)
	{
		ListNode currentNode = head;
		int count = 0;
		
		while(currentNode!=null && count!=n)
		{
			currentNode=currentNode.next;
			count++;
		}
		
		if(currentNode==null)
			
			return Integer.MIN_VALUE;
		else
		    return currentNode.data;
 		
	}
	
   public static void main(String[] args)
   {	   
	   NthNode nthnode = new NthNode();
	   nthnode.push(1);
	   nthnode.push(10);
	   nthnode.push(11);
	   nthnode.push(15);
	   nthnode.push(14);
	   nthnode.push(19);
	   nthnode.push(14);
 	   nthnode.push(13);
 	   
 	   if(NthNode.getNthNode(8)==Integer.MIN_VALUE)
 	   {
 		   System.out.println("The size of linked list is less than the nth value");
 	   }
 	   else
 	   {
 		   System.out.println("The nth value is: "+NthNode.getNthNode(8));
 	   }  
   }
}
