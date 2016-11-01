package linkedLists;

import java.util.HashMap;
import java.util.Map;

/*
 * 
Remove duplicates from an unsorted linked list
Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.

For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43.
*SOURCE: Geek for geeks
*/
 


public class RemoveDuplicatesUnSort 
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
	
   public static void removeDuplicates()
   {
	  Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	  int count = 0;
	  ListNode current = head;
	  ListNode prev = head;
	  map.put(current.data, count);
	  current = current.next;
	  
	  while(current!=null)
	  {
		  if(map.get(current.data)==null)
		  {
			  count++;
			  prev = current;
			  map.put(current.data,count);
			  current = current.next;		 
		  }
		  else
		  {
			  current = current.next;
			  prev.next =  current;
			  
			
			  
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
		RemoveDuplicatesUnSort duplicates = new RemoveDuplicatesUnSort();
		duplicates.push(11);
		duplicates.push(1);
		duplicates.push(1);
		duplicates.push(11);
		duplicates.push(13);
		duplicates.push(13);
		duplicates.push(1);
		duplicates.push(19);
		duplicates.push(19);
		removeDuplicates();
		printList();
	}
}
