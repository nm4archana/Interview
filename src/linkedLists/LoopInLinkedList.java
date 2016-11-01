package linkedLists;

/*
* 
Write a program function to detect loop in a linked list
Given a linked list, check if the the linked list has loop or not.
*
*Source - Geek for Geeks
*/


public class LoopInLinkedList 
{
	static ListNode head;
    class ListNode
    {
    	int data;
    	ListNode next;
    	
    	ListNode(int data)
        {
        	this.data = data;
        	next = null;
        }
    }
    
    private static boolean findLoop()
    {
    	//To chk if loop exists
    	//head.next.next=head;
    	ListNode slowPtr = head;
    	ListNode fastPtr = head;
    	
    	while(slowPtr!=null&&fastPtr!=null&&fastPtr.next!=null)
    	{
    		slowPtr=slowPtr.next;
    		fastPtr=fastPtr.next.next;
    		if(slowPtr==fastPtr)
    		{
    			return true;
    		}
    	}
		return false;
    	
    }
    private void push(int n)
    {
  	  ListNode node = new ListNode(n);
        node.next=head;
        head = node;
    }
    
    public static void main(String[] args)
    {
    	LoopInLinkedList inLinkedList=new LoopInLinkedList();
    	inLinkedList.push(1);
    	inLinkedList.push(2);
    	
    	if(findLoop())
    	{
    		System.out.println("Loop Exists");
    	}
    	else
    	{
    		System.out.println("No Loop Exists");
    	}
    }
}
