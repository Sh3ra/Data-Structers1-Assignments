/**
 * MySpecialLinkedListUtils
 */
public class MySpecialLinkedListUtils {

    public static double[] summary(LinkedListNode head) {
        LinkedListNode temp = new LinkedListNode();
        temp = head;
        double[] arr = new double[5];
        int size = 0;
        arr[0] = 0;
        arr[3] = temp.getValue();
        arr[4] = temp.getValue();
        while (temp != null) {
            size++;
            arr[0] = arr[0] + temp.getValue();
            if (arr[3] < temp.getValue())
                arr[3] = temp.getValue();
            if (arr[4] > temp.getValue())
                arr[4] = temp.getValue();
            temp = temp.getNext();
        }
        if ((size + 1) % 2 != 0) {
            temp = head;
            for (int i = 0; i < (size / 2) - 1; i++)
                temp = temp.getNext();
            LinkedListNode x = new LinkedListNode();
            x = temp.getNext();
            arr[2] = (temp.getValue() + x.getValue()) / 2.0;
        } else {
            temp = head;
            for (int i = 0; i < size / 2; i++)
                temp = temp.getNext();
            arr[2] = temp.getValue();
        }
        arr[1] = arr[0] / (size);
        return arr;
    }

    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode point = new LinkedListNode();
        LinkedListNode temp = new LinkedListNode();
        point = head;
        int size = 0;
        LinkedListNode new_head = new LinkedListNode();
        while (point.getNext() != null) {
            point = point.getNext();
            size++;
        }
        new_head = point;
        int temp_size = size;
        for (int i = 0; i <= size; i++) {
            temp = head;
            for (int j = 0; j < temp_size; j++) {
                temp = temp.getNext();
            }
            temp_size--;
            point.next = temp;
            point = point.getNext();
        }
        point.next = null;
        return new_head;
    }

    public static LinkedListNode evenIndexedElements(LinkedListNode head) {
        LinkedListNode new_head = new LinkedListNode();
        LinkedListNode point = new LinkedListNode();
        int counter = 0;
        new_head.value = head.getValue();
        point = new_head;
        while (head.getNext() != null) {
            if (counter % 2 == 0) {
                new_head.value = head.getValue();

            } else {
                new_head.next = head.getNext();
                new_head = new_head.getNext();
            }
            head = head.getNext();
            counter++;
        }
        new_head.next = null;
        return point;
    }

    public static LinkedListNode insertionSort(LinkedListNode head) {
        LinkedListNode temp1 = new LinkedListNode();
        LinkedListNode temp2 = new LinkedListNode();
        temp1 = head;
        int swap;
        int size = 0;
        while (temp1.getNext() != null) {
            temp1 = temp1.getNext();
            size++;
        }
        temp1 = head;
        for (int i = 0; i < size; i++) {
            if (temp1.next.getValue() < temp1.getValue()) {
                swap = temp1.next.getValue();
                temp2 = head;
                for (int j = 0; j <= i + 1; j++) {
                    if (j == i + 1)
                        temp2.value = swap;
                    else {
                        int swap_temp;
                        if (temp2.getValue() >= swap) {
                            swap_temp = swap;
                            swap = temp2.getValue();
                            temp2.value = swap_temp;
                        }
                        temp2 = temp2.getNext();
                    }
                }
            }
            temp1 = temp1.getNext();
        }
        return head;
    }

    public static LinkedListNode mergeSort(LinkedListNode head) {

        return head;
    }

    public static LinkedListNode removeCentralNode(LinkedListNode head) {
        LinkedListNode temp1 = new LinkedListNode();
        int size = 0;
        temp1 = head;
        while (temp1.getNext() != null) {
            temp1 = temp1.getNext();
            size++;
        }
        temp1 = head;
        if (size % 2 != 0) {
            for (int i = 0; i < (size / 2) - 1; i++) {
                temp1 = temp1.getNext();
            }
            temp1.next = temp1.getNext().getNext();
        } else {
            for (int i = 0; i < (size / 2) - 1; i++) {
                temp1 = temp1.getNext();
            }
            temp1.next = temp1.getNext().getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode();
        LinkedListNode one = new LinkedListNode();
        LinkedListNode two = new LinkedListNode();
        LinkedListNode three = new LinkedListNode();
        LinkedListNode four = new LinkedListNode();
        LinkedListNode five = new LinkedListNode();
        head.value = 4;
        head.next = one;
        one.value = 1;
        one.next = two;
        two.value = 8;
        two.next = three;
        three.value = 1;
        three.next = four;
        four.value = 1;
        four.next = five;
        five.value = 0;
        five.next = null;
        /*
         * double [] arr=new double[5]; arr=summary(head); for(int i=0;i<5;i++)
         * System.out.println(arr[i]);
         */
        /*
         * head=reverse(head); while(head.getNext()!=null) {
         * System.out.println(head.getValue()); head=head.next; }
         * System.out.println(head.getValue());
         */

        /*
         * head=evenIndexedElements(head); while(head.getNext()!=null) {
         * System.out.println(head.getValue()); head=head.next; }
         * System.out.println(head.getValue());
         */

        /*
         * head = insertionSort(head); while (head.getNext() != null)
         * {System.out.println(head.getValue()); head = head.next; }
         * System.out.println(head.getValue());
         */
        /*
         * head= removeCentralNode(head); while (head.getNext() != null)
         * {System.out.println(head.getValue()); head = head.next; }
         * System.out.println(head.getValue());
         */

    }

}