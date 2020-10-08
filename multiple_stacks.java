import java.util.Scanner;

public class multiple_stacks {
    public static int SIZE,NO_OF_STACKS;
    public static int[] array;
    public static int[] base;
    public static int[] top;
    public multiple_stacks(int stack_id)
    {
        base[stack_id-1]=(SIZE/NO_OF_STACKS)*(stack_id-1);
        top[stack_id-1]=base[stack_id-1]-1;
        System.out.println("Base of stack " + stack_id + " is " + base[stack_id-1]);
        System.out.println("Top of stack " + stack_id + " is " + top[stack_id-1]);
    }
    public static void SIZE(int size,int m)
    {
        SIZE=size;
        NO_OF_STACKS=m;
        array=new int[SIZE];
        base=new int[NO_OF_STACKS];
        top=new int[NO_OF_STACKS];
    }
    public static void push(int stack_id,int data)
    {
        if(stack_id<NO_OF_STACKS && (top[stack_id-1])==base[stack_id]-1)
        {
            //System.out.println(base[stack_id]-1);
            //System.out.println(top[stack_id-1]);
            if(stack_id!=1 && (top[stack_id-2]<(base[stack_id-1]-1))) {
                left_shift(base[stack_id-1], top[stack_id-1]);
                base[stack_id-1]--;
                top[stack_id-1]--;
            }
            else if(stack_id+1<NO_OF_STACKS && top[stack_id]<base[stack_id+1]-1) {
                right_shift(base[stack_id], top[stack_id]);
                base[stack_id]++;
                top[stack_id]++;
                /*System.out.println("Top of stack " + (stack_id+1) +" is now " +top[stack_id]);
                System.out.println("Base of stack " + (stack_id+1) +" is now " +base[stack_id]);*/
            }
            else if(top[stack_id-1]==top[stack_id] && top[stack_id-1]+1==base[stack_id])
            {
                    top[stack_id]++;
                    base[stack_id]++;
            }
            else if(top[NO_OF_STACKS-1]<SIZE-1)
            {
                right_shift(top[stack_id-1]+1,top[NO_OF_STACKS-1]);
                for(int i=stack_id;i<NO_OF_STACKS;i++)
                {
                    base[i]++;
                    top[i]++;
                }
                /*System.out.println("Top of stack 3 is " + top[2]);
                System.out.println("Base of stack 3 is " + base[2]);*/
            }
            else
            {
                System.out.println("Sorry,No more space.");
                return;
            }
        }
        if(stack_id==NO_OF_STACKS)
        {
            //System.out.println(top[stack_id-1]);
            if(top[stack_id-1]==SIZE-1)
            {
                if(top[stack_id-2]<base[stack_id-1]-1) {
                    left_shift(base[stack_id-1], top[stack_id-1]);
                    base[stack_id-1]--;
                    top[stack_id-1]--;
                }
                else{
                    System.out.println("Stack " + stack_id + " is full.");
                    return;
                }
            }
        }
        System.out.println("earlier top of stack " + stack_id + " was " + top[stack_id-1]);
        top[stack_id-1]++;
        array[top[stack_id-1]]=data;
        System.out.println("Pushed " + data + " to stack " + stack_id + " and now top is " + top[stack_id-1]);
        System.out.println();
        for(int i=0;i<SIZE;i++)
            System.out.print(array[i] + " ");
        System.out.println();
        return;
    }
    public static int pop(int stack_id)
    {
       if(top[stack_id-1]<base[stack_id-1])
       {
           System.out.println("Stack " + stack_id + " is empty.");
           return -1;
       }
       int temp=array[top[stack_id-1]];
       top[stack_id-1]--;
       return temp;
    }
    public static int peek(int stack_id)
    {
        if(top[stack_id-1]<base[stack_id-1])
        {
            System.out.println("Stack " + stack_id + " is empty.");
            return -1;
        }
        return array[top[stack_id-1]];
    }
    public static void left_shift(int base_index,int top_index)
    {
        for(int i=base_index;i<=top_index;i++)
            array[i-1]=array[i];
        return;
    }
    public static void right_shift(int base_index,int top_index)
    {
        for(int i=top_index;i>=base_index;i--)
            array[i+1]=array[i];
        return;
    }
    public static void display(int stack_id)
    {
        for(int i=base[stack_id-1];i<=top[stack_id-1];i++)
            System.out.print(array[i] + " ");
        System.out.println();
        return;
    }
    public static void main(String[] args)
    {
        SIZE(16,4);
        System.out.println("Size of array is " + SIZE);
        System.out.println("Total no of stacks is " + NO_OF_STACKS);
        multiple_stacks stack_1=new multiple_stacks(1);
        multiple_stacks stack_2=new multiple_stacks(2);
        multiple_stacks stack_3=new multiple_stacks(3);
        multiple_stacks stack_4=new multiple_stacks(4);
        System.out.println();
        stack_1.push(1,1);
        stack_1.push(1,2);
        stack_1.push(1,3);
        stack_1.push(1,4);
        stack_2.push(2,5);
        stack_2.push(2,6);
        stack_2.push(2,7);
        stack_4.push(4,5);
        stack_4.push(4,5);
        stack_3.push(3,8);
        stack_3.push(3,9);
        stack_1.push(1,5);
        stack_3.push(3,5);
        stack_3.push(3,5);
        stack_1.push(1,5);
        stack_2.push(2,5);
        stack_3.push(3,5);
        stack_2.push(2,5);
        stack_2.push(2,5);
        stack_2.push(2,8);
        stack_2.push(2,9);
        System.out.println();
        System.out.print("Elements of 1st Stack are ");
        display(1);
        System.out.print("Elements of 2nd Stack are ");
        display(2);
        System.out.print("Elements of 3rd Stack are ");
        display(3);
        System.out.print("Elements of 4th Stack are ");
        display(4);
        return;
    }
}
