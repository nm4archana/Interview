package linkedLists;

public class ChkPalindrome 
{
     static ListNode head;
     
	 class ListNode
	 {
	    char data;
	    ListNode next;
	    
	    ListNode(char n)
	    {
	    	data = n;
	    	next = null;
	    }
	 }
	 
	 private boolean chkPalindrome()
	 {
		 ListNode midNode = head;
		 ListNode fastPtr = head;
		 
		 //To find the middle node
		 while(fastPtr!=null&&fastPtr.next!=null)
		 {
			 midNode = midNode.next;
			 fastPtr = fastPtr.next.next;
		 }
		    if(fastPtr!=null)
		    	 
		     midNode = midNode.next;
		     ListNode current = head;
		     
		     midNode = reverseList(midNode);
		     
		     while(midNode!=null)
		     {
		    	 if(midNode.data!=current.data)
		    	 {
		    		 return false;
		    	 }
		    	 midNode=midNode.next;
		    	 current=current.next;
		     }
		     return true;    
	 }
	 
	 private ListNode reverseList(ListNode current)
	 {
		 ListNode prev = null;
		 
		 while(current!=null)
		 {
			 ListNode next = current.next;
			 current.next = prev;
			 prev = current;
			 current = next;
		 }
		 
		 return prev;
	 }
	 
	 private void push(char s)
	 {
		 ListNode node = new ListNode(s);
		 node.next = head;
		 head = node;
		 
	 }
	 
	 public static void main(String[] args)
	 {
		 ChkPalindrome palindrome = new ChkPalindrome();
		 palindrome.push('R');
		 palindrome.push('A');
		 palindrome.push('D');
		 palindrome.push('A');
		// palindrome.push('A');
		 palindrome.push('R');
		 
		 boolean resultFlag = palindrome.chkPalindrome();
		 
		 if(resultFlag)
		 {
			 System.out.println("The Linked List is a palindrome");
		 }
		 else
		 {
			 System.out.println("The Linked List is not a palindrome");
		 }
	 }
}
