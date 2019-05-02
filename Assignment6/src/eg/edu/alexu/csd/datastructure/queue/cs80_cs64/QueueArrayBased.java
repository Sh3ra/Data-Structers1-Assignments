package eg.edu.alexu.csd.datastructure.queue.cs80_cs64;

public class QueueArrayBased implements IArrayBased,IQueue {

    private int MAX;
    private int front=0;
    private int rear=0;

    public QueueArrayBased(int MAX)
    {
        try {
            if (MAX > 0)
                this.MAX = MAX;
            else throw new RuntimeException("Queue must have a +ve size");
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
       arr =new Object[MAX];
    }
    private Object[]arr;

    @Override
    public void enqueue(Object item) {
    try
    {
        if(size()==MAX)
            throw new RuntimeException("Queue is Full");
            arr[rear]=item;
            rear=(rear+1)%MAX;
    }
    catch (RuntimeException ex)
    {
        System.out.println(ex.getMessage());
    }
    }

    @Override
    public Object dequeue() {
        Object temp=null;
        try
        {
            if(isEmpty())
                throw new RuntimeException("Queue is EMPTY");
            temp=arr[front];
            arr[front]=null;
            front=(front+1)%MAX;
        }catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public int size() {
        if ((MAX - front + rear) % MAX==0)
        {
          if (arr[front]==null)return 0;
          else return MAX;
         }
  }
}
