//SinglyCircularLinkedList
class CircularList{
 private Node head;
    private Node tail;
    private int size;
    public CircularList(){
        this.size=0;
    }
    //Node class
     private static class Node{
           int value;
           Node next;
            Node(int value) {//constructor
        this.value = value;
        this.next = null;
    }
    }
    //Singly Circular Linked List
    //insertiom
    // insertionat start TC-O(1)
    public void insertStart(int value){ 
        Node node=new Node(value);
        if(head==null){
        head=node;
        tail=node;
        node.next=node;
       }
       else{
        node.next=head;
        tail.next=node;
        head=node;}
        size++;
    }
    //insertion at last TC-O(1)
    public void insertLast(int value){
        Node node= new Node(value);
        if(head==null){
            head=node;
            tail=node;
            node.next=node;//or node.next=head;
        }
        else{
            tail.next=node;
            node.next=head;
            tail=node;
        }
        size++;
    }
    //insert at nth index TC O(n)
    public void insertAtIndex(int index ,int value){
          if(index==0){
          insertStart(value);
          return;
        }
        //if list is full
        if(index==size){
            insertLast(value);
            return;
        }
        //If invalid index
        if(index<0||index>size){
          throw new IndexOutOfBoundsException("Invalid Index");
        }
         Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;//moves to its next
        }
        // Insert node at index
        Node node = new Node(value);
        node.next=temp.next;
        temp.next = node;

        size++;
    }
    //DELETION TC O(1)
     public int  deleteStart(){ 
        if(head==null){
            throw new IllegalStateException("List is Empty");
        }
         if(size==1){
         int val=head.value;
            head=null;
            tail=null;
            size--;
            return val;
        }
        int val=head.value;
        head=head.next;
        tail.next=head;
        //OR tail.next=head.next;head=head.next;
        size--;
        return val;
    }
    //delete last node TC=O(n)
    public int deleteLast(){
        if(head==null){
            throw new IllegalStateException("List is empty");
        }
        if(size==1){
            int val=head.value;
            tail=null;
            head=null;
            size--;
            return val;
        }
        Node  temp=head;
        for(int i=1;i<size-1;i++){
            temp=temp.next;
        }
         int val= temp.next.value;
         temp.next=head;
         tail=temp;

         size--;
         return val;
    }
    //delete at nth index TC O(n)
    public int deleteAtIndex(int index){
        if(index>=size||index<0){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if(index==0){
            return deleteStart();
        }
        if(index==size-1){
            return deleteLast();
        }
         Node  temp=head;
           for(int i =0;i<index-1;i++){
            temp=temp.next;
           }
           int val=temp.next.value;
           temp.next=temp.next.next;

           size--;
           return val;
    }
    //display
    public void display(){
        if(head==null){
            System.out.println("This list is empty");
            return;
        }
    Node temp=head;
  while(temp.next!=head){
    System.out.print(temp.value+"<->");
    temp=temp.next;
  }
     System.out.println(temp.value);
}
}
public class CircularLinkedList {
   public static void main(String[] args) {
    CircularList list=new CircularList();
    list.insertStart(78);
    list.insertLast(89);
    list.insertLast(34);
    list.insertAtIndex(1, 67);
    System.out.println("After insertion");
    list.display();
    System.out.println("After deletion");
    list.deleteStart();
    list.deleteLast();
    list.deleteAtIndex(2);
    list.display();
   } 
}
