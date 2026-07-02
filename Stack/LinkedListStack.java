//Stack Implementation using LinkedList
//TC-O(1) ,if display() implemented-O(n)
//SC-O(n)
class Node{//node class
    int value;
    Node next;
    Node (int d){
        value=d;
        next=null;
    }
}
public class LinkedListStack {
    private Node head;
    private int size;
    public LinkedListStack(){//constructor
        head=null;
        size=0;
    }
  //push method-to enter elements in stack
    public void push(int x){
        Node element =new Node(x);
        element.next=head;
        head=element;
        size++;
    }
  //pop method- to remove last entered element from stack
    public int pop(){
        if(head==null){
            return-1;
        }
        int val=head.value;
        head=head.next;
        size--;
        return val;
    }
  //peek method- to get the last entered element without removing it from stack
    public int peek(){
        if(head==null){
            return -1;
        }
        return head.value;
    }
    public boolean isEmpty(){
        return(size==0);
    }
  //display method- to display the elements of stack
    public void display(){
        System.out.println("Elements of Stack");
        if(head==null){
            System.out.println("Empty stack");
            return;
        }
        Node current=head;
        while(current!=null){
            System.out.println(current.value+" ");
            current=current.next;
        }
    }
//main method
    public static void main(String[] args) {
       LinkedListStack sl = new LinkedListStack();
        sl.push(3);
        sl.push(29);
        sl.push(22);
        sl.push(89);
        sl.display();
        System.out.println("Element removed from stack: "+sl.pop());
        System.out.println("First element in stack: "+sl.peek());
       
    }
}
