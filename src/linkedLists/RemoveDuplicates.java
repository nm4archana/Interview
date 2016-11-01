package linkedLists;

/*
 * 
  Remove duplicates from a sorted linked list 
  Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list. The list should only be traversed once.
  For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
 * Source : Geek For Geeks
 */

public class RemoveDuplicates
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
	 
	 
	private void removeDuplicates()
	{
		ListNode current = head;
		
		while(current.next!=null)
		{
			if(current.data==current.next.data)
			{
				current.next=current.next.next;
			}
			else
			{
				current = current.next;
			}
		}
	}
	
	private static void printList()
	{
		while(head!=null)
		{
			System.out.print(head.data);
			head = head.next;
			if(head!=null)
			{
				System.out.print("-->");
			}
		}
	}
	
	private void push(int n)
	{ 
    ListNode node = new ListNode(n);
	 node.next = head;
	 head = node;
		
	}
	
   public static void main(String[] args)
   {
         RemoveDuplicates removeDuplicates = new RemoveDuplicates();
         removeDuplicates.push(5);
         removeDuplicates.push(5);
         removeDuplicates.push(5);
         removeDuplicates.push(2);
         removeDuplicates.push(2);
         removeDuplicates.push(1);
         removeDuplicates.push(1);
         removeDuplicates.push(1);
         removeDuplicates.push(1);
         removeDuplicates.push(1);
         removeDuplicates.push(1);
         removeDuplicates.removeDuplicates();
         printList();
   }
}
