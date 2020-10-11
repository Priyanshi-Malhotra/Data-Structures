import java.util.Stack;

public class Stacks_Longest_Valid_Parentheses {
    public static int longest_valid_parentheses(String s)
    {
        Stack<Integer> stack=new Stack<>();
        int i=0,longest=0,length=0;
        stack.push(-1);
        while(i<s.length())
        {
            if(s.charAt(i)==')')
            {
                stack.pop();
                if(stack.isEmpty())
                    stack.push(i);
                else
                {
                    length=i-stack.peek();
                    if(length>longest)
                        longest=length;
                }
            }
            stack.push(i);
            i++;
        }
        return longest;
    }
    public static void main(String[] args)
    {
        String s="(()))())(";
        System.out.println("Longest valid parentheses are : " + longest_valid_parentheses(s));
    }
}
