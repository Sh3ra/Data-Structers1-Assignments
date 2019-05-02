package eg.edu.alexu.csd.datastructure.queue.cs80_cs64;

public class LinkedBasedQueue implements IQueue, ILinkedBased {

    class QueueNode {
        Object element;
        QueueNode next;
    }
    private int size;
    private QueueNode front = new QueueNode();

    @Override
    public void enqueue(Object item) {

        QueueNode newNode = new QueueNode();
        newNode.element = item;

        if(size == 0)
            front = newNode;
        else {
            QueueNode temp = front;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }

        this.size++;
    }

    @Override
    public Object dequeue() {

        try {
            if(size == 0)
                throw new RuntimeException("The Queue is Empty");
            Object temp = front.element;
            front = front.next;
            this.size--;
            return temp;
        }
        catch(RuntimeException ex){
            return ex.getMessage();
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
