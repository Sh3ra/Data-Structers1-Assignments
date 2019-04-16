package eg.edu.alexu.csd.datastructure.linkedList;

public class SinglyLinkedList implements ILinkedList {

    private SLNode head;
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
        if(this.size()>index)
        {
            SLNode temp=head;
            for(int i=1;i<index;i++)
            {
                temp=temp.next;
            }
            SLNode newNode=new SLNode(element);
            newNode.next=temp.next;
            temp.next=newNode;
        }
    }

    public void add(Object element) {
        SLNode temp=head;
        SLNode newNode=new SLNode(element);
        if(head==null)
        {
            head=newNode;
        }
        while (temp.next!=null)
            temp=temp.next;
        temp.next= newNode;
    }

    
    public Object get(int index) {
        return null;
    }

    
    public void set(int index, Object element) {

    }

    
    public void clear() {
    head=null;
    }

    
    public boolean isEmpty() {
        return  head==null;
    }

    
    public void remove(int index) {

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
        return false;
    }
}
