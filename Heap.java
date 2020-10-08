public class Heap {
    static class Node{
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    static int[] arr;
    static int capacity,count,heap_type;
    public Heap(int capacity,int heap_type)
    {
        arr=new int[capacity];
        this.capacity=capacity;
        this.heap_type=heap_type;
        count=0;
    }
    public static int parent_index(int child_index)
    {
        if(child_index<=0 && child_index>count)
            return -1;
        return (child_index-1)/2;
    }
    public static int left_child_index(int parent_index)
    {
        return ((2*parent_index+1)<count?(2*parent_index+1):-1);
    }
    public static int right_child_index(int parent_index)
    {
        return ((2*parent_index+2)<count?(2*parent_index+2):-1);
    }
    public static int max_element()
    {
        return (count!=0?arr[0]:-1);
    }
    public static int min_element()
    {
        return (count!=0?arr[0]:-1);
    }
    public static void heapify_max_heap(int parent_index) {
        int left_child_index = left_child_index(parent_index);
        int right_child_index = right_child_index(parent_index);
        int max = 0;
        if(left_child_index==-1 && right_child_index!=-1)
            max=right_child_index;
        else if(left_child_index!=-1 && right_child_index==-1)
            max=left_child_index;
        else if(left_child_index==-1 && right_child_index==-1)
            return;
        else if (arr[left_child_index] > arr[right_child_index])
            max = left_child_index;
        else
            max = right_child_index;
        if (arr[max] > arr[parent_index]) {
            int temp = arr[max];
            arr[max] = arr[parent_index];
            arr[parent_index] = temp;
            heapify_max_heap(max);
        }
        return;
    }
    public static void heapify_min_heap(int parent_index) {
        int left_child_index = left_child_index(parent_index);
        int right_child_index = right_child_index(parent_index);
        int min = 0;
        if (arr[left_child_index] < arr[right_child_index])
            min = left_child_index;
        else
            min = right_child_index;
        if (arr[min] < arr[parent_index]) {
            int temp = arr[min];
            arr[min] = arr[parent_index];
            arr[parent_index] = temp;
            heapify_min_heap(min);
        }
        return;
    }
    public static int delete_element_max_heap()
    {
        if(count==0)
            return -1;
        int data=arr[0];
        arr[0]=arr[count-1];
        count--;
        heapify_max_heap(0);
        return data;
    }
    public static int delete_element_min_heap()
    {
        if(count==0)
            return -1;
        int data=arr[0];
        arr[0]=arr[count-1];
        count--;
        heapify_min_heap(0);
        return data;
    }
    public static void insert_element_max_heap(int data)
    {
        if(count==capacity)
            resize_heap();
        arr[count]=data;
        count++;
        int parent_index=parent_index(count-1);
        heapify_max_heap(parent_index);
        return;
    }
    public static void insert_element_min_heap(int data)
    {
        if(count==capacity)
            resize_heap();
        arr[count]=data;
        count++;
        int parent_index=parent_index(count-1);
        heapify_min_heap(parent_index);
        return;
    }
    public static void resize_heap(){
        int[] current_array=new int[capacity];
        System.arraycopy(arr,0,current_array,count-1,capacity);
        arr=new int[capacity*2];
        capacity*=2;
        if(arr==null)
        {
            System.out.println("Not enough memory.");
            return;
        }
        System.arraycopy(current_array,0,arr,count-1,capacity);
        current_array=null;
        return;
    }
    public static int max_element_in_min_heap()
    {
        int last_parent_index=parent_index(count-1);
        int max=arr[0];
        for(int i=last_parent_index;i<count;i++)
            if(max<arr[i])
                max=arr[i];
        return max;
    }
    public static void display()
    {
        for(int i=0;i<count;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        return;
    }
    public static void main(String[] args)
    {
        //Max Heap
        Heap root=new Heap(10,1);
        insert_element_max_heap(10);
        insert_element_max_heap(5);
        insert_element_max_heap(3);
        insert_element_max_heap(8);
        insert_element_max_heap(7);
        insert_element_max_heap(2);
        insert_element_max_heap(1);
        insert_element_max_heap(9);
        insert_element_max_heap(4);
        insert_element_max_heap(6);
        display();
    }
}
