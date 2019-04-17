package eg.edu.alexu.csd.datastructure.linkedList;

import jdk.nashorn.internal.ir.CatchNode;

public class SinglyLinkedList implements ILinkedList {

     SLNode head;
    class SLNode
    {
        Object val;
        SLNode next;
        SLNode(Object val)
        {
            this.val=val;
            this.next=null;
        }
    }
    public void add(int index, Object element) {
       try{
           if(index>size())
               throw new IndexOutOfBoundsException("Index Out Of Boundaries");
        SLNode newNode=new SLNode(element);
        if(this.size()>index)
        {
            SLNode temp=head;
            if(index==0)
            {
                newNode.next=head;
                head=newNode;
                return;
            }
            for(int i=1;i<index;i++)
            {
                temp=temp.next;
            }
            newNode.next=temp.next;
            temp.next=newNode;
        }
        if(index==size())
        {
            SLNode temp=head;
            while (temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
        }
       }
       catch (IndexOutOfBoundsException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public void add(Object element) {
        SLNode temp=head;
        SLNode newNode=new SLNode(element);
        if(head==null)
        {
            head=newNode;
            return;
        }
        while (temp.next!=null)
            temp=temp.next;
        temp.next= newNode;
    }

    public Object get(int index) {
        if(this.size()>index)
        {
            SLNode temp=head;
            for(int i=0;i<index;i++)
            {
                temp=temp.next;
            }
            return temp.val;
        }
        return null;
    }
    
    public void set(int index, Object element) {

        if(this.size()>index)
        {
            SLNode temp=head;
            for(int i=0;i<index;i++)
            {
                temp=temp.next;
            }
            temp.val=element;
        }
    }

    
    public void clear() {
    head=null;
    }

    
    public boolean isEmpty() {
        return  head==null;
    }

    
    public void remove(int index) {
        if(head==null)return;
        if(this.size()>index) {
            SLNode temp = head;
            for (int i = 0; i < index-1; i++) {
                temp = temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public int size() {
        int count=0;
        SLNode temp=head;
        while (temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }

    public ILinkedList sublist(int fromIndex, int toIndex) {
        return null;
    }


    public boolean contains(Object o) {
        SLNode temp=head;
        while (temp!=null)
        {
            if(temp.val==o)return true;
            temp=temp.next;
        }
        return false;
    }
}
