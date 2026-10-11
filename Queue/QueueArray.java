public class QueueArray{
int arr[];
int start,end;
int currSize,maxSize;

public QueueArray(){
    arr=new int[100];
    start=-1;
    end=-1;
    currSize=0;
    maxSize=100;
}
public void push(int x){
    if(currSize==maxSize){
        System.out.println("Queue is Full");
        System.exit(1);
    }
    if(end==-1){
       start=0;
       end=0;
    }
    else{
        end=(end+1)%maxSize;
    }
    arr[end]=x;
    currSize++;
}
public int pop(){
    if(start==-1){
        System.out.println("Queue Empty");
        System.exit(1);
    }
    int el=arr[start];
    if(currSize==1){
        start=-1;
        end=-1;
    }else{
        start=(start+1)%maxSize;
    }
    currSize--;
    return el;
}
public int peek(){
    if(start==-1){
        System.out.println("Queue is Empty");
        System.exit(1);
    }
    return arr[start];
}
public int size(){
    return currSize;
}
public boolean isEmpty(){
    return(currSize==0);
}

public static void main(String[] args) {
    QueueArray q = new QueueArray();
    q.push(2);
    q.push(3);
    q.push(4);
    q.push(5);
    System.out.println("Top element: "+ q.peek());
    System.out.println("Deleted element: "+q.pop());
    System.out.println("Size of Queue "+q.size());
}
}
