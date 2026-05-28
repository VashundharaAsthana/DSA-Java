class List {
     private Node head;
    private Node tail;
    private int size;
    public List(){
        this.size=0;
    }
    //Node class
     private static class Node{
           int value;
           Node next;
           Node prev;
            Node(int value) {//constructor
        this.value = value;
        this.next = null;
        this.prev=null;
    }
    }
    //INSERTION
    //insertion at start
    public void insertStart( int value){//TC: O(1)
         Node node = new Node(value);
          if(head==null){
        head=node;
        tail=node;
        node.next=node;
        node.prev=node;
        }
        else{
        node.prev=tail;
        node.next=head;
        tail.next=node;
        head.prev=node;
        head=node;}
        size++;
    }
    //insert at last
    public void insertLast(int value){//TC: O(1)
        Node node= new Node(value);
        if(head==null){
            head=node;
            tail=node;
            node.next=node;
            node.prev=node;
        }
       else{
        node.prev=tail;
        node.next=head;
        head.prev=node;
        tail.next=node;
        tail=node;
       }
       size++;
    }
    //insert at nth index
    public void insertAtIndex(int index,int value){//TC:O(n)
    if(index==0){
        insertStart(value);
        return;
    }
    if(index==size){
        insertLast(value);
        return;
    }
    if(index<0||index>size){
     throw new IndexOutOfBoundsException("Invalid Index");
    }
    Node node= new Node(value);
    Node temp=head;
    for(int i=1;i<index;i++){//reaches one index brfore the insertion is to happen
        temp=temp.next;
    }
    node.next=temp.next;
    node.prev=temp;
    temp.next.prev=node;
    temp.next=node;
    
    size++;
    }
    //DELETION
  //deletion at start
    public int deleteStart(){//TC:O(1)
        if(head==null){
            throw new IllegalStateException("EmptyList");
        }
        int val=head.value;
        if(head==tail){
        tail=null;
        head=null;
        }
        head=head.next;
        head.prev=tail;
        tail.next=head;
        size--;
        return val;
    }
  //deletion at last
    public int deleteLast(){//TC:O(1)
        if(head==null){
            throw new IllegalStateException("Empty List");
        }
        int val=tail.value;
        if(head==tail){
        tail=null;
        head=null;
        }
        tail=tail.prev;
        tail.next=head;
        head.prev=tail;
        size--;
        return val;
    }
  //deletion at nth index
    public int deleteAtIndex(int index){//TC:O(n)
           if(index==0){
       return deleteStart();
    }
    if(index==size-1){
        return deleteLast();
    }
    if(index>=size||index<0){
        throw new IndexOutOfBoundsException("Invalid Index");
    }
    
       Node temp=head;
        int value;
        for(int i=1;i<=index;i++){//reaches at the exact node where deletion is to happen
            temp=temp.next;
        }
        value = temp.value;
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
        size--;
     
     return value;
    }
     //displaying the list.
    public void display(){
    if(head==null){
    System.out.println("Empty list");
    return;
    }
    Node temp=head;
    do{
    System.out.print(temp.value+"<->");
    temp=temp.next;
    }
    while(temp!=head);
    System.out.println("Head");
 
    }
    //size print
    public int getSize(){
    return size;
    }
}
//main class
public class DoublyCircularLinkedList {
     public static void main(String[] args) {
     List list = new List();
       list.insertStart(80);
       list.insertStart(90);
       list.insertLast(89);
       list.insertLast(45);
       list.insertAtIndex(1, 8);
       list.insertAtIndex(2, 57);
       list.display();
      System.out.println("size:"+list.getSize()); 
      System.out.println("After deletion");
      list.deleteStart();
      list.deleteLast();
      list.deleteAtIndex(2);
      list.display();
      System.out.println("size:"+list.getSize());
        
    }

}
