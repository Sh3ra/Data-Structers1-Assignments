package eg.edu.alexu.csd.datastructure.queue.cs80_cs64;

import static org.junit.Assert.*;

public class QueueArrayBasedTest {


    @org.junit.Test
    public void enqueue() {
        QueueArrayBased test = new QueueArrayBased(4);
        test.enqueue(0);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(3);
        assertEquals(0,test.dequeue());
    }


}