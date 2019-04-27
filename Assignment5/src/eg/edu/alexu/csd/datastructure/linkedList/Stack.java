package eg.edu.alexu.csd.datastructure.linkedList;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class Stack implements IStack {
   private SinglyLinkedList Stacky=new SinglyLinkedList();
    @Override
    public Object pop() {
        Object x;
        try {
           SinglyLinkedList.SLNode temp;
           temp = Stacky.head;
           while (temp.next != null) {
               temp = temp.next;
           }
           x = temp.val;
           Stacky.remove(Stacky.size() - 1);
       }
       catch (NullPointerException ex)
       {
           System.out.println("Stack is Empty!");
           return null;
       }
        return x;

    }

    @Override
    public Object peek() {
        Object x;
        try {
            SinglyLinkedList.SLNode temp;
            temp = Stacky.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            x = temp.val;
        }
        catch (NullPointerException ex)
        {
            System.out.println("Stack is Empty!");
            return null;
        }
        return x;

    }

    @Override
    public void push(Object element) {
        Stacky.add(element);
    }

    @Override
    public boolean isEmpty() {
        return Stacky.isEmpty();
    }

    @Override
    public int size() {
        return Stacky.size();
    }

    public static void main(String[] args) {
        //UI for Stack Implementation
        int s=0;
        Scanner scan=new Scanner(System.in);
        Stack test = new Stack();
        while (true){
        do {
            try {
                System.out.println("Please choose an action");
                System.out.println("----------------------");
                System.out.println("1: Push ");
                System.out.println("2: Pop ");
                System.out.println("3: Peek ");
                System.out.println("4: Get Size ");
                System.out.println("5: Check if empty ");
                System.out.println("6: EXIT ");
                System.out.println("====================================================================");
                String tempooo = scan.nextLine();
                if (!(tempooo.equals("1") || tempooo.equals("2") || tempooo.equals("3") || tempooo.equals("4") || tempooo.equals("5") || tempooo.equals("6")))
                    throw new RuntimeException("Invalid input");
                else s = Integer.parseInt(tempooo);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }while (s>6||s<1);
            switch (s)
            {
                case 1:{
                    System.out.println("Enter element");
                    test.push(scan.nextLine());
                }break;
                case 2:System.out.println(test.pop());
                break;
                case 3:System.out.println(test.peek());
                break;
                case 4:System.out.println(test.size());
                break;
                case 5:System.out.println(test.isEmpty());
                break;
                case 6:System.exit(0);
                break;
            }
        }
    }
}
