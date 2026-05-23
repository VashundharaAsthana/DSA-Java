//insertion an deletion in Doubly Linked List.
class DoubleList{
    private Node head;
    private Node tail;
    private int size;
    public DoubleList(){
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
//end insertion
public void insertLast(int value){
    Node node =new Node(value);
    if(head==null){
        head=node;
        tail=node;
    }
    else{
        tail.next=node;
        node.prev=tail;
        tail=node;
    }
    size++;
}
//start insertion
public void insertStart(int value){
    Node node=new Node(value);
    if(head==null){
        head=node;
        tail=node;
    }
    else{
     head.prev=node;
     node.next=head;
     head=node;
    }
    size++;
}
//inserting at a given index
public void insertAtIndex(int index,int value){
    if(index==0){
        insertStart(value);}
    if(index==size){
        insertLast(value);}
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
//from start
  public int deleteStart(){
    if(head==null){
        throw new IllegalStateException("List is empty");
    }
    int value=head.value;
    head=head.next;
    if(head==tail){
        tail=null;
        head=null;
    }else{
        head.prev=null;
    }
    return value;
  }
  //from end
  public int deleteLast(){
    if(head==null){
        throw new IllegalStateException("List is Empty");
    } int value=tail.value;
     
     if(head==tail){
        tail=null;
        head=null;
     }
     else{
     tail=tail.prev;
     tail.next=null;
     }
     size--;
     return value;
  }
  //at nth index
  public int deleteAtIndex(int index){
    if(index==0){
       return deleteStart();
    }
    if(index==size-1){
        return deleteLast();
    }
    if(index>size){
        throw new IndexOutOfBoundsException("Invalid Index");
    }
    
       Node temp=head;
        int value=temp.value;
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
    Node temp=head;
    while(temp!=null){
        System.out.print(temp.value+"<->");
        temp=temp.next;
    }
    System.out.println("End of list");
}
 //size print
    public int getSize(){
    return size;
     }
}
public class DoublyLinkedList {//Main class
   public static void main(String[] args) {
    DoubleList list=new DoubleList();
    list.insertLast(10);
    list.insertLast(30);
    list.insertStart(90);
    list.insertStart(45);
    list.insertAtIndex(2, 67);
    list.display();
    System.out.println("Size:"+ list.getSize());
    list.deleteStart();
    list.deleteLast();
    list.deleteAtIndex(3);
    System.out.println("list after deletion");
    list.display();
    System.out.println("Size:"+list.getSize());
   } 
}
