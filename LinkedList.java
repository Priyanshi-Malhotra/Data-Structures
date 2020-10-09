import java.util.Scanner;

public class LinkedList {
    Node head=null;
    static int counter=0;
    static class Node {
        public int data;
        Node next;
        public Node(int data)
        {
            this.data=data;
            next=null;
        }
    }
    public static Node insert(Node head,int data)
    {
        Node new_node=new Node(data);
        if(head==null)
        {
            head=new_node;
            return head;
        }
        else
        {
            Node temp=head;
            while(temp.next!=null)
                temp=temp.next;
            temp.next=new_node;
        }
        return head;
    }
    public static void display(Node head)
    {
        while(head!=null)
        {
            System.out.print(head.data + " ");
            head=head.next;
        }
        System.out.println();
        return;
    }
    public static int length(Node head)
    {
        Node temp=head;
        int count=1;
        while(temp.next!=head && temp.next!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }
    public static void display_circular(Node head)
    {
        Node temp=head;
        while(temp.next!=head)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.print(temp.data + " ");
        System.out.println();
        return;
    }
    public static void n_from_end(Node head,int n)
    {
        int count=1;
        Node temp=head;
        while(temp.next!=null)
        {
            count++;
            temp=temp.next;
        }
        if(count<n)
        {
            System.out.println("Fewer no of nodes");
            return;
        }
        if(count==n)
        {
            System.out.println(head.data);
            return;
        }
        else
        {
            temp=head;
            while(count!=(n-1))
            {
                head=head.next;
                count=0;
                temp=head;
                while(temp.next!=null)
                {
                    count++;
                    temp=temp.next;
                }
            }
            System.out.println(head.data);
        }
        return;
    }
    public static void n_from_end_efficient(Node head,int n)
    {
        Node p_temp=head;
        Node p_nth=head;
        while(n!=1)
        { if(p_temp!=null)
            p_temp=p_temp.next;
            n--;
        }
        if(p_temp==null)
        {
            p_nth=head;
            System.out.println("Fewer no of nodes");
            return;
        }
        while(p_temp.next!=null)
        {
            p_nth=p_nth.next;
            p_temp=p_temp.next;
        }
        System.out.println(p_nth.data);
        return;
    }
    public static void n_from_end_recursion(Node head,int n)
    {
     if(head!=null)
     {
         n_from_end_recursion(head.next,n);
         counter++;
         if(n==counter)
         {
             System.out.println(head.data);
             return;
         }
     }
     return;
    }
    public static boolean loop_check(Node head)
    {
        Node slow_ptr=head;
        Node fast_ptr=head;
        while(fast_ptr!=null && fast_ptr.next!=null)
        {
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            if(slow_ptr==fast_ptr)
                return true;
        }
        return false;
    }
    public static int loop_length(Node head)
    {
        Node slow_ptr=head;
        Node fast_ptr=head;
        int count=1;
        while(fast_ptr.next!=null)
        {
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
            if(slow_ptr==fast_ptr)
            {
                slow_ptr=slow_ptr.next;
                while(slow_ptr!=fast_ptr) {
                    slow_ptr=slow_ptr.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
    }
    public static Node insert_into_sorted_list(Node head,int data)
    {
        Node new_node=new Node(data);
        Node temp=head;
        Node temp2=head;
        while(temp.data<data) {
            temp2=temp;
            temp = temp.next;
        }
        new_node.next=temp2.next;
        temp2.next=new_node;
        return head;
    }
    public static Node merging_point(Node head,Node head2)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node temp2=head2;
            while(temp2!=null) {
                if (temp == temp2)
                    return temp;
                temp2=temp2.next;
            }
            temp=temp.next;
        }
        return head;
    }
    public static Node merging_point_efficient(Node head1,Node head2)
    {
        int l1=0,l2=0,diff=0;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null)
        {
            temp1=temp1.next;
            l1++;
        }
        while(temp2!=null)
        {
            temp2=temp2.next;
            l2++;
        }
        if(l1<l2)
        {
            temp1=head2;
            temp2=head1;
            diff=l2-l1;
        }
        else if(l1>l2)
        {
            temp1=head1;
            temp2=head2;
            diff=l1-l2;
        }
        for(int i=0;i<diff;i++)
            temp1=temp1.next;
        while(temp1!=null)
        {
            if(temp1==temp2)
                return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
    public static Node middle_node(Node head)
    {
        Node fast_ptr=head;
        Node slow_ptr=head;
        while(fast_ptr.next!=null)
        {
            if(fast_ptr.next.next==null)
                return slow_ptr;
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
        }
        return slow_ptr;
    }
    public static void reverse_display(Node head)
    {
        if(head==null)
            return;
        reverse_display(head.next);
        System.out.print(head.data + " ");
        return;
    }
    public static int even_odd_length(Node head)
    {
        Node fast_ptr=head;
        while(fast_ptr.next!=null)
        {
            if(fast_ptr.next.next==null)
                return 1;
            fast_ptr=fast_ptr.next.next;
        }
        return 0;
    }
    public static Node merge_sorted(Node head1,Node head2)
    {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        Node head=null;
        if(head1.data<=head2.data)
        {
            head=head1;
            head.next=merge_sorted(head1.next,head2);
        }
        else
        {
            head=head2;
            head.next=merge_sorted(head1,head2.next);
        }
        return head;
    }
    public static Node merge_sorted_without_recursion(Node head1,Node head2)
    {
        Node head=new Node(0);
        Node temp=head;
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
            }
        }
        if(head1!=null)
            temp.next=head1;
        if(head2!=null)
            temp.next=head2;
        return head.next;
    }
    public static void split_circular(Node head)
    {
        Node slow_ptr=head;
        Node fast_ptr=head;
        Node head_first=head;
        Node head_second=new Node(0);
        while(fast_ptr.next!=head)
        {
            if(fast_ptr.next.next==head)
            {
                break;
            }
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
        }
        head_second=slow_ptr.next;
        slow_ptr.next=null;
        if(fast_ptr.next.next==head)
            fast_ptr.next.next=null;
        else
            fast_ptr.next=null;
        display(head_first);
        display(head_second);
        return;
    }
    public static Node reverse(Node head)
    {
        Node current=head;
        Node prev=null;
        while(current!=null)
        {
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public static boolean check_palindrome(Node head)
    {
        Node fast_ptr=head;
        Node slow_ptr=head;
        Node temp=null;
        int l=0;
        while(fast_ptr.next!=null)
        {
            if(fast_ptr.next.next==null) {
                l = 1;
                break;
            }
            slow_ptr=slow_ptr.next;
            fast_ptr=fast_ptr.next.next;
        }
        temp=slow_ptr.next;
        Node current=temp;
        Node prev=null;
        while(current!=null)
        {
            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        temp=prev;
        while (head != slow_ptr.next)
        {
            if(l==0 && head==slow_ptr)
                break;
            if (head.data != temp.data)
                return false;
            head = head.next;
            temp = temp.next;
        }
        return true;
    }
    public static Node reverse_k_nodes_recursive(Node head,int k)
    {
        Node prev=null;
        Node current=head;
        Node next=current;
        int count=k;
        while(current!=null && count>0)
        {
            count--;
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        if(next!=null)
            head.next=reverse_k_nodes_recursive(next,k);
        return prev;
    }
    public static Node reverse_k_nodes(Node head,int k)
    {
        Node current=head;
        Node end=null;
        Node start=head;
        while(current!=null)
        {
            int count=k;
            Node prev=null;
            while(current!=null && count>0)
            {
                Node next=current.next;
                current.next=prev;
                prev=current;
                current=next;
                count--;
            }
            if(end!=null)
                end.next=prev;
            else
                head=prev;
            end=start;
            start=current;
        }
        return head;
    }
    public static Node JosephusCircle(Node head,int k)
    {
        for(int i=length(head);i>1;i--)
        {
            for(int j=1;j<(k-1);j++)
                head=head.next;
            head=head.next.next;
        }
        return head;
    }
    public static Node modular_node(Node head,int k)
    {
        Node modular=head;
        int i=1,position=0;
        while(head!=null)
        {
            if(i%k==0) {
                modular = head;
                position=i;
            }
            i++;
            head=head.next;
        }
        System.out.println("Position of modular node is " + position);
        return modular;
    }
    public static Node fractional_node(Node head,int k)
    {
        int position=length(head)/k;
        System.out.println("Position of fractional node is - " + position);
        while (position>1)
        {
            head=head.next;
            position--;
        }
        return head;
    }
    public static Node l1_l2(Node head)
    {
        Node slow_ptr=head;
        Node fast_ptr=head;
        Node head1=head.next;
        Node head3=head;
        while(fast_ptr.next!=null && fast_ptr.next.next!=null)
        {
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;
        }
        Node head2=slow_ptr.next;
        slow_ptr.next=null;
        int l=1;
        Node temp=head3;
        head2=reverse(head2);
        while (head1!=null && head2!=null)
        {
            if(l==0)
            {
                head3.next=head1;
                head1=head1.next;
                head3=head3.next;
                l=1;
            }
            else
            {
                head3.next=head2;
                head2=head2.next;
                head3=head3.next;
                l=0;
            }
        }
        if(head1==null)
            head3.next=head2;
        if(head2==null)
            head3.next=head1;
        return temp;
    }
    public static Node insertion_sort(Node head,int k)
    {
        Node new_node=new Node(k);
        if(head.data>k) {
            new_node.next = head;
            head = new_node;
            return head;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.data<k)
            temp=temp.next;
        if(temp.next==null)
            temp.next=new_node;
        else
        {
            new_node.next=temp.next;
            temp.next=new_node;
        }
        return head;
    }
    public static Node rotate_by_k(Node head,int k)
    {
        while(k>0)
        {
            Node temp=head;
            while(temp.next.next!=null)
                temp=temp.next;
            Node tmp=temp.next;
            tmp.next=head;
            temp.next=null;
            head=tmp;
            k--;
        }
        return head;
    }
    public static Node sum(Node head1,Node head2)
    {
        head1=reverse(head1);
        head2=reverse(head2);
        int num1=0,num2=0;
        while(head1!=null)
        {
            num1=num1*10+head1.data;
            head1=head1.next;
        }
        while (head2!=null)
        {
            num2=num2*10+head2.data;
            head2=head2.next;
        }
        int sum=num1+num2;
        Node head=new Node(sum%10);
        sum=sum/10;
        Node temp=head;
        while(sum!=0)
        {
            head=insert(head,sum%10);
            sum=sum/10;
        }
        return head;
    }
    public static Node remove_duplicates(Node head)
    {
        Node temp=head;
        while(temp.next!=null)
        {
            if(temp.data==temp.next.data)
            {
                Node ptr=temp;
                while(ptr.next!=null && ptr.next.data==temp.data)
                    ptr=ptr.next;
                temp.next=ptr.next;
            }
            else
                temp=temp.next;
        }
        return head;
    }
    public static Node common(Node head1,Node head2)
    {
        Node head=new Node(0);
        Node temp=head;
        while(head1!=null && head2!=null)
        {
            if(head1.data==head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                head2=head2.next;
                temp=temp.next;
            }
            else if(head1.data>head2.data)
                head2=head2.next;
            else
                head1=head1.next;
        }
        return head.next;
    }
    public static Node even_odd(Node head)
    {
        Node odd_list=new Node(0);
        Node odd=odd_list;
        Node even_list=new Node(0);
        Node even=even_list;
        while(head!=null)
        {
            if(head.data%2!=0)
            {
                odd.next=head;
                odd=odd.next;
            }
            else
            {
                even.next=head;
                even=even.next;
            }
            head=head.next;
        }
        odd.next=null;
        even.next=odd_list.next;
        return even_list.next;
    }
    public static Node partition(Node head,int k)
    {
        Node greater_head=new Node(0);
        Node greater=greater_head;
        Node lesser_head=new Node(0);
        Node lesser=lesser_head;
        while(head!=null)
        {
            if(head.data<k)
            {
                lesser.next=head;
                lesser=lesser.next;
            }
            else
            {
                greater.next=head;
                greater=greater.next;
            }
            head=head.next;
        }
        greater.next=null;
        lesser.next=greater_head.next;
        return lesser_head.next;
    }
    public static void main(String[] args)
    {
        Node head=new Node(1);
        head=insert(head,2);
        head=insert(head,3);
        head=insert(head,5);
        //head=insert(head,6);
        /*Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=head.next;*/
        Node head2=new Node(10);
        head2=insert(head2,11);
        head2=insert(head2,12);
        head2=insert(head2,14);
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        Node temp2=head2;
        while(temp2.next!=null)
            temp2=temp2.next;
        Node new_node=new Node(20);
        temp.next=new_node;
        temp2.next=new_node;
        new_node.next=new Node(21);
        if(loop_check(head)) {
            System.out.println("There's a loop!");
            int count=loop_length(head);
            System.out.println("And the length is " + count);
            return;
        }
        else
            System.out.println("There's no loop.Yay!");
        display(head);
        n_from_end(head,2);
        n_from_end_efficient(head,2);
        n_from_end_recursion(head,2);
        insert_into_sorted_list(head,4);
        display(head);
        display(head2);
        Node tmp=merging_point(head,head2);
        System.out.println(tmp.data);
        Node tmp2=merging_point_efficient(head,head2);
        System.out.println(tmp2.data);
        tmp=middle_node(head);
        tmp2=middle_node(head2);
        System.out.println("Middle Node of first list is " + tmp.data);
        System.out.println("Middle Node of second list is " + tmp2.data);
        System.out.println("List in reverse order is :");
        reverse_display(head);
        System.out.println();
        reverse_display(head2);
        System.out.println();
        int m=even_odd_length(head);
        if(m==1)
         System.out.println("even");
        else
            System.out.println("odd");
        m=even_odd_length(head2);
        if(m==1)
            System.out.println("even");
        else
            System.out.println("odd");
        //sorted lists
        System.out.println("Merging Sorted Lists");
        Node head3=new Node(1);
        head3=insert(head3,2);
        head3=insert(head3,3);
        head3=insert(head3,5);
        Node head4=new Node(4);
        head4=insert(head4,7);
        head4=insert(head4,19);
        head4=insert(head4,20);
        display(head3);
        display(head4);
        Node head_sorted=merge_sorted(head3,head4);
        display(head_sorted);
        head_sorted=merge_sorted_without_recursion(head3,head4);
        display(head_sorted);
        //Circular linked list
        Node head5=new Node(1);
        head5=insert(head5,2);
        head5=insert(head5,3);
        head5=insert(head5,4);
        head5=insert(head5,5);
        head5=insert(head5,6);
        head5=insert(head5,7);
        Node tmp1=head5;
        while(tmp1.next!=null)
            tmp1=tmp1.next;
        tmp1.next=head5;
        System.out.println("Splitting the following circular list :");
        display_circular(head5);
        split_circular(head5);
        System.out.println("Reversing the following list :");
        display(head4);
        Node reversed_head=reverse(head4);
        display(reversed_head);
        //check palindrome
        System.out.println("Let's check if the following list if palindrome or not :");
        Node head6=new Node(1);
        head6=insert(head6,2);
        head6=insert(head6,3);
        head6=insert(head6,4);
        head6=insert(head6,5);
        head6=insert(head6,6);
        head6=insert(head6,7);
        head6=insert(head6,8);
        display(head6);
        if(check_palindrome(head6))
            System.out.println("It's a palindrome!!");
        else
            System.out.println("Nayy,not a palindrome.");
        Node head7=new Node(1);
        head7=insert(head7,2);
        head7=insert(head7,3);
        head7=insert(head7,4);
        head7=insert(head7,5);
        head7=insert(head7,6);
        head7=insert(head7,7);
        head7=insert(head7,8);
        System.out.println("Reverse k nodes :");
        display(head7);
        Node rev_head=reverse_k_nodes_recursive(head7,3);
        display(rev_head);
        Node head8=new Node(1);
        head8=insert(head8,2);
        head8=insert(head8,3);
        head8=insert(head8,4);
        head8=insert(head8,5);
        head8=insert(head8,6);
        head8=insert(head8,7);
        head8=insert(head8,8);
        display(head8);
        rev_head=reverse_k_nodes(head8,3);
        display(rev_head);
        System.out.println("Josephus Circle");
        Node head9=new Node(1);
        head9=insert(head9,2);
        head9=insert(head9,3);
        head9=insert(head9,4);
        head9=insert(head9,5);
        head9=insert(head9,6);
        head9=insert(head9,7);
        head9=insert(head9,8);
        temp=head9;
        while(temp.next!=null)
            temp=temp.next;
        temp.next=head9;
        display_circular(head9);
        Node winner=JosephusCircle(head9,2);
        System.out.println(winner.data);
        System.out.println("Modular Node :");
        head=insert(head,15);
        display(head);
        System.out.println("Length of list - " + length(head));
        Node modular=modular_node(head,2);
        System.out.println(modular.data);
        Node fractional=fractional_node(head,1);
        System.out.println(fractional.data);
        System.out.println("L1 LN L2 LN-1 :- ");
        display(head);
        Node new_head=l1_l2(head);
        display(new_head);
        System.out.println("Insertion sort :");
        Node head10=new Node(5);
        head10=insertion_sort(head10,14);
        head10=insertion_sort(head10,10);
        head10=insertion_sort(head10,1);
        head10=insertion_sort(head10,2);
        head10=insertion_sort(head10,50);
        display(head10);
        System.out.println("Rotate by k :");
        head10=rotate_by_k(head10,2);
        display(head10);
        System.out.println("Sum of two numbers :");
        Node head_first=new Node(3);
        head_first=insert(head_first,4);
        head_first=insert(head_first,3);
        Node head_second=new Node(5);
        head_second=insert(head_second,6);
        head_second=insert(head_second,4);
        display(head_first);
        display(head_second);
        Node head_sum=sum(head_first,head_second);
        display(head_sum);
        System.out.println("Remove Duplicates : ");
        Node head11=new Node(5);
        head11=insertion_sort(head11,14);
        head11=insertion_sort(head11,10);
        head11=insertion_sort(head11,1);
        head11=insertion_sort(head11,14);
        head11=insertion_sort(head11,50);
        head11=insertion_sort(head11,50);
        head11=insertion_sort(head11,50);
        head11=insertion_sort(head11,18);
        head11=insertion_sort(head11,12);
        head11=insertion_sort(head11,2);
        display(head11);
        head11=remove_duplicates(head11);
        display(head11);
        Node head12=new Node(5);
        head12=insertion_sort(head12,14);
        head12=insertion_sort(head12,20);
        head12=insertion_sort(head12,1);
        head12=insertion_sort(head12,24);
        head12=insertion_sort(head12,50);
        head12=insertion_sort(head12,60);
        head12=insertion_sort(head12,18);
        System.out.println("Display common :");
        display(head11);
        display(head12);
        Node common=common(head11,head12);
        display(common);
        System.out.println("Even odd :");
        display(head);
        Node even_odd_head=even_odd(head);
        display(even_odd_head);
        System.out.println("Partition with respect to X :");
        display(head);
        head=partition(head,15);
        display(head);
        return;
    }
}