package eg.edu.alexu.csd.datastructure.queue.cs80_cs64;

public class QueueArrayBased implements IArrayBased,IQueue {

    private int qsize;
    
    public QueueArrayBased(int qsize)
    {
        this.qsize=qsize;
    }
    @Override
    public void enqueue(Object item) {

    }

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
