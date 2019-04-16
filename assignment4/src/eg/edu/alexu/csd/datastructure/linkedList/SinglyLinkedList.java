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
    @Override
    public void add(int index, Object element) {

    }

    @Override
    public void add(Object element) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public void set(int index, Object element) {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return  head==null;
    }

    @Override
    public void remove(int index) {

    }

    @Override
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

    @Override
    public ILinkedList sublist(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
