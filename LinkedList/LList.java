//Insertion and Deletion in singly LinkedList
class LL{
    private Node head;
    private Node tail;
    private int size;
    //constructor 
      public LL(){
        this.size=0;
    }
     //NODE CLASS
      private class Node{
       int value;
        Node next;
        //constructor
         Node(int value){
            this.value=value;//points to the  current object; 
        }
        //constructor2
        Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
      }
    // INSERTION
    //inserting through START
    public void insertStart(int value){
        Node newNode = new Node(value);//new node creation
        if(head==null){
            tail=newNode;
        }
        newNode.next=head;//now new node points to the head

        head=newNode;//update the value of head : head= newNode
        size++;
       
    }
    //inserting through END
    public void insertLast(int value){
        Node newNode = new Node( value);
        if (head== null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            tail= newNode;
        }
        size++;
    }
      //inserting at INDEX
     public void insert(int index, int value){
        // if head is empty
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
            temp = temp.next;
        }
        // Insert node at index
        Node node = new Node(value, temp.next);
        temp.next = node;

        size++;
          }
         
    //DELETION
          // from START
         public int deleteStart(){
         
         if(head == null){
               throw new IllegalStateException("List is empty");
               }
         int val=head.value;
         head=head.next;//starts pointing to the next node from the head node so head automatically get disconnected
         if(head==null){
          tail=null;
         }
         size--;
         return val;//returns the deleted value
          }              

          //from LAST
           public int deleteLast(){
            //edge case
            if(size==1){
                return deleteStart();
            }
            if(size==0){
                throw new IllegalStateException("List is empty");
            }
            Node temp=head;
            for(int i=0;i<size-2;i++){//size-2 is the second last node 
                temp=temp.next;
            }
            int val=temp.next.value;
            tail=temp;
            tail.next=null;
               size--;
            return val;
           }
         //from any INDEX K(GIVEN INDEX)
             //delete from any index
public int delete(int index){

    //edge cases
    if(index<0||index>=size){
        throw new IndexOutOfBoundsException("Invalid Index");
    }
    if(index == 0){
        return deleteStart();
    }

    if(index == size - 1){
        return deleteLast();
    }
    Node temp = head;

    for(int i = 0; i < index - 1; i++){
        temp = temp.next;
    }

    int val = temp.next.value; //value to return
    temp.next = temp.next.next;
    size--;
    return val;
}
    //printing the list
    public void display(){
        Node temp= head;//copies value of head-> the address stored at head
        while(temp!=null){
            System.out.print(temp.value+"->");//the value at the address which is stored in temp (eg:10|null initially)
            temp=temp.next;}//points to next node 
            System.out.println("END");
        }
            //size print
            public int getSize(){
                return size;
            }
              }
//Main method
public class LList {
    public static void main(String[] args) {
        LL list= new LL();
        list.insertStart(10);
         list.insertLast(30);
         list.insert(1, 90);
         list.insert(0, 99);
        //list.insert(100, 45);-> throws index out of bound exception
        list.delete(2);
        list.deleteLast();
        list.display();
        System.out.print("size"+": "+list.getSize());
        LL list2 = new LL();
        // list2.deleteStart();->throws Illegal State Exception
    }
}
