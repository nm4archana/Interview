package linkedLists;

public class CountOfGivenInt 
{
	static ListNode head=null;
	
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
	
	private static int countGivenInt(int n)
	{
		int count = 0;		
		ListNode currentNode = head;
		
		while(currentNode!=null)
		{
			if(currentNode.data==n)
			{
				count++;
			}
			currentNode = currentNode.next;
			
		}		
		
		return count;
	}
	
	private void push(int n)
	{
       	ListNode newNode = new ListNode(n);
       	newNode.next = head;
       	head = newNode;
	}
	
	public static void main(String[] args)
	{
		CountOfGivenInt cntGivInt = new CountOfGivenInt();
		cntGivInt.push(1);
		cntGivInt.push(10);
		cntGivInt.push(2);
		cntGivInt.push(1);
		cntGivInt.push(1);
		cntGivInt.push(1);
		System.out.println("The count of the given Integer in the Linked list is: "+countGivenInt(1));
		
	}
}
