/*
Find the middle of a given linked list 
Given a singly linked list, find middle of the linked list. For example, if given linked list is 1->2->3->4->5 then output should be 3.

If there are even nodes, then there would be two middle nodes, we need to print second middle element. For example, if given linked list is 1->2->3->4->5->6 then output should be 4.

Question Source: GeekForGeeks

Runtime: O(n)
*/

package linkedLists;

public class PrintMiddle 
{
    private ListNode head;
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
   
	private int printMiddleNode()
	{
		ListNode currentNode = head;
		ListNode middleNode = head;
		while(currentNode!=null&&currentNode.next!=null)	
		{
			currentNode=currentNode.next.next;
			middleNode=middleNode.next;
		}
	
		return middleNode.data;
	
	}
	
	public void push(int n)
	{
		ListNode node = new ListNode(n);
        node.next=head;
        head = node;
	}
  
    public static void main(String[] args)
    {
    	   PrintMiddle printMiddle = new PrintMiddle();
    	   printMiddle.push(1);
    	   printMiddle.push(10);
    	   printMiddle.push(11);
    	   printMiddle.push(15);
    	   printMiddle.push(14);
    	   printMiddle.push(19);
    	   printMiddle.push(14);
    	   printMiddle.push(13);
      	   
      	   System.out.println("The middle node in the linked list is: "+printMiddle.printMiddleNode());
      	   
    }
}
