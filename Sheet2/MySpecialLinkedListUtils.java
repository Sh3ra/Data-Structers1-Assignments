/**
 * MySpecialLinkedListUtils
 */
public class MySpecialLinkedListUtils {

    public static double[] summary(LinkedListNode head)
    {
        LinkedListNode temp=new LinkedListNode();
        temp=head;
        double [] arr=new double[5];
        int size=0;
        arr[0]=0;
        arr[3]=temp.getValue();
        arr[4]=temp.getValue();
        while(temp!=null)
        {
            size++;
            arr[0]=arr[0]+temp.getValue();
            if(arr[3]<temp.getValue())
            arr[3]=temp.getValue();
            if(arr[4]>temp.getValue())
            arr[4]=temp.getValue();
            temp=temp.getNext();
        }
        if((size+1)%2!=0)
        {
            temp=head;
            for(int i=0;i<(size/2)-1;i++)
            temp=temp.getNext();
            LinkedListNode x=new LinkedListNode(); 
            x=temp.getNext();
            arr[2]=(temp.getValue()+x.getValue())/2.0;
        }
        else 
        {
            temp=head;
            for(int i=0;i<size/2;i++)
            temp=temp.getNext();
            arr[2]=temp.getValue();
        }
        arr[1]=arr[0]/(size);
        return arr;
    }

    public static LinkedListNode reverse(LinkedListNode head)
    {
        
    }
    public static void main(String[] args) {
        LinkedListNode head= new LinkedListNode();
        LinkedListNode one= new LinkedListNode();
        LinkedListNode two= new LinkedListNode();
        LinkedListNode three= new LinkedListNode();
        LinkedListNode four= new LinkedListNode();
        LinkedListNode five= new LinkedListNode();
        head.value=4;
        head.next=one;
        one.value=1;
        one.next=two;
        two.value=8;
        two.next=three;
        three.value=1;
        three.next=four;
        four.value=1;
        four.next=five;
        five.value=0;
        five.next=null;
        double [] arr=new double[5];
        arr=summary(head);
        for(int i=0;i<5;i++)
        System.out.println(arr[i]);       
    }  

    }