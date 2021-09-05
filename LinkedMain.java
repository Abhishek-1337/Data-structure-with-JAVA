import java.util.Scanner;

public class LinkedMain
{
    public static void main(String[] args)
    {

        Node head = new Node(1);
        Node direct = head;
        int t = 1;
        while(t == 1)
        {
            System.out.println("Enter a choice\n1.Insert\n2.Delete\n3.Print List");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the data you want to insert");
                    int data = sc.nextInt();
                    System.out.println("Enter (1) if you to insert at the head position or (0) to continue from the end");
                    int position = sc.nextInt();
                    Node new_node = MethodsLink.insert( data);// Static method call with class name
                    if(position == 1)
                    {
                       new_node.next = direct;
                       head = new_node;
                       System.out.println("New head is " + head.data);
                    }
                    else if(position == 0){
                        direct.next = new_node;  
                        System.out.println(new_node.data + " is inserted at position at the end");
                    }
                    break;

                case 2:
                    if(head != null){
                        
                        System.out.println("Enter the position you wan to delete from");
                        position = sc.nextInt();
                        Node deletedNode = MethodsLink.delete(head, position);
                        if(position == 1)
                        {
                            head = deletedNode;
                            System.out.println("Head node is deleted");
                        }
                        else
                        {
                            System.out.println(deletedNode.data+" Node is deleted");
                        }
                    }
                    else{

                        System.out.println("List is empty");
                    }
                    break;
                    
                
                case 3:
                    if(head != null)
                    {
                        MethodsLink.printList(head);
                    }
                    else{

                        System.out.println("List is empty");
                    }
                    break; 

                default:
                    System.out.println("Wrong Entry! Please try again");
                    break;
            }   

            System.out.println("Do you want to continue:(y/n)");
            char ans = sc.next().charAt(0);
            t = (ans == 'y')?1:0;

        }
    }
    
}


class MethodsLink{
    
    public static Node insert(int data)
    {
        Node new_node = new Node(data);
        return new_node;
      
    }
    public static Node delete(Node head, int position)
    {
        int i = 0;
        Node ptr = head;
        Node prev = ptr;
        if(position == 1)
        {
            ptr = ptr.next;
            return ptr;
        }
        else
        {
            while(i != position-1)
            { 
                prev = ptr;
                ptr = ptr.next;
                i++;

            }
            prev.next = ptr.next;
           return ptr;
        }
    }
    public static void printList(Node head)
    {
        Node ptr = head;
        while(ptr!= null)
        {
            System.out.print(ptr.data+"->");
            ptr = ptr.next;
            System.out.print((ptr!=null)?"":"NULL" + "\n");
        }
    }

}

class Node{

    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
 
}


