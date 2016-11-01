package linkedLists;


public class DoublyLinkedList 
{

	int length=0;
	DLLNode head;
	DLLNode tail;
	
	class DLLNode
	{

		int data;
		DLLNode prev;
		DLLNode next;
		
		public DLLNode(){
			
		} 
		public DLLNode(int data,DLLNode prev,DLLNode next ){
			
			this.data=data;
			this.prev=prev;
			this.next=next;
		}
		
		
		
		public DLLNode(int newValue) {
			this.data=newValue;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public DLLNode getPrev() {
			return prev;
		}
		public void setPrev(DLLNode prev) {
			this.prev = prev;
		}
		public DLLNode getNext() {
			return next;
		}
		public void setNext(DLLNode next) {
			this.next = next;
		}
		
	}
	
	public void addAtBegin(int newValue){
	
		DLLNode newNode=new DLLNode(newValue,null,head);
		if(head==null){
			head=newNode;
		}
		else{
		head.setPrev(newNode);
		head=newNode;
		}
		length++;
	}
	
	
	public void addAtEnd(int newValue){		
		DLLNode current=head;
		DLLNode temp=null;
		if(head==null){
			DLLNode newNode=new DLLNode(newValue,null,null);
			head=newNode;
		}
		else{
		while(current!=null){
			temp=current;
			current=current.getNext();
		}
		DLLNode newNode=new DLLNode(newValue,temp,null);
		temp.setNext(newNode);

		}
		length++;
	}
	
	public void insertNode(int position,int newValue){
		if(position>length)
		{
			
			position=length;
		}
		if(position<0){
			position=0;
	}
	if(head==null){
		DLLNode newNode=new DLLNode(newValue,null,null);
		head=newNode;
		}
	else if(position==0){
		DLLNode newNode=new DLLNode(newValue,null,head);
		head.setPrev(newNode);
		head=newNode;
	}
	
	else if(position==length){
		DLLNode temp=head;
		DLLNode current=null;
		while(temp!=null){
			current=temp;
			temp=temp.getNext();
		}
		DLLNode newNode=new DLLNode(newValue,current,temp);
		current.setNext(newNode);
	}
	
	else{
		DLLNode temp=head;
		for(int i=0;i<position;i++){		
			 temp=temp.getNext();
		}
		DLLNode newNode=new DLLNode(newValue,temp.getPrev(),temp);
		temp.getPrev().setNext(newNode);
		temp.setPrev(newNode);
}
	
	length++;
	}
	
	public void length(){
	System.out.println(length);
	}
	
	public void getData(){
		
		DLLNode temp=head;
		while(temp!=null){
			System.out.println(temp.getData());
			temp=temp.getNext();
			
		}
	}
	
	public void deleteAtBegin(){
		if(head==null){}
		if(length==1){
			head=null;
		}
		else{
		DLLNode temp=head;
		temp.getNext().setPrev(null);
		head=temp.getNext();
		length--;  
		}
	}
	
	
	//public void deleteAtEnd(){}
	//public void deleteAtPosition(){} 
	public static void main(String[] args){
		DoublyLinkedList  linkedList=new DoublyLinkedList();
		linkedList.addAtBegin(10);
		linkedList.addAtBegin(20);
		linkedList.addAtBegin(30);
		linkedList.addAtBegin(25);
		System.out.println("After adding at the Begin:");
		linkedList.getData();
		System.out.println("\n");
		
		linkedList.addAtEnd(10);
		linkedList.addAtEnd(20);
		linkedList.addAtEnd(30);
		linkedList.addAtEnd(25);
		System.out.println("After adding at the End:");
		linkedList.getData();
		System.out.println("\n");
		
		System.out.println("After adding at the Position 0:");
		linkedList.insertNode(0, 1);
		linkedList.getData();
		System.out.println("\n");
		linkedList.insertNode(4, 5);
		System.out.println("After adding at the Position 4:");
		linkedList.getData();
		System.out.println("\n");
		
		System.out.println("Displaying the length:");
		linkedList.length();
		System.out.println("\n");
		
		linkedList.insertNode(11, 11);
		System.out.println("After adding at the Position 11:");
		linkedList.getData();
		System.out.println("\n");
		
		System.out.println("Displaying the length:");
		linkedList.length();
		System.out.println("\n");
		
		System.out.println("Delete at Begin:");
		linkedList.deleteAtBegin();
		linkedList.getData();
		System.out.println("\n");
		
	}
}
