import java.util.Scanner;
import java.lang.*;

public class StackLinked {

    public static void main(String[] args)
    {
        Node top = null;
        Scanner sc = new Scanner(System.in);
        char cond = 'y';
        while(cond == 'y'){

            System.out.println("Enter a choice\n1.Push\n2.Pop\n3.Print List");;
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the data you want to push into the stack");
                    int data = sc.nextInt();
                    top = StackMethodLink.push(data, top);
                    if(top != null)
                    {
                        System.out.println(top.data+" is pushed successfully");
                    }
                    break;

                case 2:
                    top = StackMethodLink.pop(top);
                    break;

                case 3:
                    if(top == null){

                        System.out.println("Stack is Empty");
                        break;
                    }
                    StackMethodLink.printList(top);
                    break;

                default:
                  
                    System.out.println("Wrong entry!");
                    break;                 
                
            }
            System.out.println("Do you want to continue?(y/n)");
            cond = sc.next().charAt(0);
              
        }


    }
    
}

class StackMethodLink
{
    
    public static Node push(int data, Node top)
    {
        Node new_node = new Node();
        if(new_node == null)
        {
            System.out.println("Stack overflowed");
            return null;   
        }
        new_node.data = data;
        new_node.next = top;
        top = new_node;
        return new_node;
    }

    public static Node pop(Node top)
    {
        if(top == null){
            System.out.println("Stack is underflow");
            return null;
        }
        Node copy = top;
        top = top.next;
        System.out.println(copy.data+" is successfully deleted");
        return top;
    }

    public static void printList(Node top){

        while(top != null){

            System.out.print(top.data+"->");
            top = top.next;
            System.out.print((top != null)?"":"NULL\n");
        }
    }
}

class Node{

    int data;
    Node next;

}
