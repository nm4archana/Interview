/*
 Write a function to get Nth node from the end in a Linked List
 Question Source: GeekForGeeks
 
 Runtime - O(n)
 */

package linkedLists;

public class NThNodeFromEnd 
{
	ListNode head;
	
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
	
    public int nthNodeFromEnd(int n)
    {
    	ListNode currentNode = head;
    	ListNode nthNode = head;
    	int count=0;
    	
    	while(currentNode!=null&&count<n)
    	{
    		currentNode=currentNode.next;
    		count++;		
    	}
    
    	while(currentNode!=null)
    	{
    		currentNode=currentNode.next;
    		nthNode = nthNode.next;
    	}
    	
    	return nthNode.data;
    }
	
	public static void main(String[] args)
	{
		NThNodeFromEnd nodeFromEnd = new NThNodeFromEnd();
		nodeFromEnd.push(1);
		nodeFromEnd.push(2);
		nodeFromEnd.push(3);
		nodeFromEnd.push(4);
		nodeFromEnd.push(5);
		
		if(nodeFromEnd.nthNodeFromEnd(5)!=Integer.MIN_VALUE)
		System.out.println("The nth Node from end of the list is: "+nodeFromEnd.nthNodeFromEnd(5));
		else
		{
			System.out.println("n is greater than the length of the linked list");
		}
	}
}
