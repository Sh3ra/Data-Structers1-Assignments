package eg.edu.alexu.csd.datastructure.linkedList;

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
}
