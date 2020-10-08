import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class trees {
    static Stack<Node> stack=new Stack<>();
     static class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }
    public static void preorder_display(Node root)
    {
        if(root==null)
            return;
        System.out.print(root.data + " ");
        preorder_display(root.left);
        preorder_display(root.right);
        return;
    }
    public static void inorder_display(Node root)
    {
        if(root==null)
            return;
        inorder_display(root.left);
        System.out.print(root.data + " ");
        inorder_display(root.right);
        return;
    }
    public static void postorder_display(Node root)
    {
        if(root==null)
            return;
        postorder_display(root.left);
        postorder_display(root.right);
        System.out.print(root.data + " ");
        return;
    }
    public static void level_order(Node root)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!(queue.isEmpty()))
        {
            Node tmp=queue.poll();
            System.out.print(tmp.data + " ");
            if(tmp.left!=null)
                queue.offer(tmp.left);
            if(tmp.right!=null)
                queue.offer(tmp.right);
        }
        return;
    }
    public static int max_element(Node root)
    {
        if(root==null)
            return 0;
        int root_data=root.data;
        int left_data=max_element(root.left);
        int right_data=max_element(root.right);
        if(left_data>root_data)
            root_data=left_data;
        if(right_data>root_data)
            root_data=right_data;
        return root_data;
    }
    public static int min_element(Node root)
    {
        if(root==null)
            return 99999999;
        int root_data=root.data;
        int left_data=min_element(root.left);
        int right_data=min_element(root.right);
        if(left_data<root_data)
            root_data=left_data;
        if(right_data<root_data)
            root_data=right_data;
        return root_data;
    }
    public static boolean search_element(Node root,int val)
    {
        if(root==null)
            return false;
        if(root.data==val || search_element(root.left,val))
            return true;
        if(search_element(root.right,val))
            return true;
        return false;
    }
    public static Node insert_node(Node root,int val)
    {
        if(root==null)
        {
            Node new__node=new Node(val);
            root=new__node;
            return root;
        }
        if(root.left==null)
        {
            Node new_node=new Node(val);
            root.left=new_node;
            return root;
        }
        if(root.right==null)
        {
            Node new_node=new Node(val);
            root.right=new_node;
            return root;
        }
        root=insert_node(root.left,val);
        root=insert_node(root.right,val);
        return root;
    }
    public static int size(Node root)
    {
        if(root==null)
            return 0;
        int sizee=1;
        int left_size=size(root.left);
        int right_size=size(root.right);
        return sizee+left_size+right_size;
    }
    public static void reverse_level_order(Node root)
    {
        if(root==null)
            return;
        Queue<Node> queue=new LinkedList<>();
        Stack<Node> stack=new Stack<>();
        queue.offer(root);
        while(!(queue.isEmpty()))
        {
            Node tmp=queue.poll();
            stack.push(tmp);
            if(tmp.left!=null)
                queue.offer(tmp.left);
            if(tmp.right!=null)
                queue.offer(tmp.right);
        }
        while(!(stack.isEmpty()))
            System.out.print(stack.pop().data + " ");
        return;
    }
    public static int max_height(Node root)
    {
        if(root==null)
            return 0;
        int left_height=max_height(root.left);
        int right_height=max_height(root.right);
        if(left_height>right_height)
            return left_height+1;
        return right_height+1;
    }
    public static int min_height(Node root)
    {
        if(root==null)
            return 0;
        int left_height=min_height(root.left);
        int right_height=min_height(root.right);
        if(left_height<right_height)
            return left_height+1;
        return right_height+1;
    }
    public static boolean structurally_identical(Node root1,Node root2)
    {
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        return (structurally_identical(root1.left,root2.right) && structurally_identical(root1.right,root2.left));
    }
    public static int diameter(Node root)
    {
        if(root==null)
            return 0;
        int left_height=max_height(root.left);
        int right_height=max_height(root.right);
        int left_diameter=diameter(root.left);
        int right_diameter=diameter(root.right);
        int a=0;
        if(left_diameter>right_diameter)
            a=left_diameter;
        else
            a=right_diameter;
        if(a>left_height+right_height+1)
            return a;
        return (left_height+right_height+1);
    }
    public static int max_sum(Node root)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        queue.offer(root);
        int max_summ=0,sum=0;
        while(!(queue.isEmpty()))
        {
            Node tmp=queue.poll();
            if(tmp==null)
            {
               if(sum>max_summ)
                   max_summ=sum;
               sum=0;
               if(!(queue.isEmpty()))
                queue.offer(null);
            }
            else
            {
                if(tmp.left!=null)
                    queue.offer(tmp.left);
                if(tmp.right!=null)
                    queue.offer(tmp.right);
                sum+=tmp.data;
            }
        }
        return max_summ;
    }
    //ALL PATHS
    public static void print_stack(Stack<Node> stack)
    {
        if(stack.isEmpty())
            return;
        Node tmp=stack.pop();
        System.out.print(tmp.data + " ");
        print_stack(stack);
        stack.push(tmp);
        return;
    }
    public static void paths(Node root)
    {
        if(root==null)
            return;
        stack.push(root);
        paths(root.left);
        if(root.left==null && root.right==null) {
            print_stack(stack);
            System.out.println();
        }
        paths(root.right);
        stack.pop();
        return;
    }
    public static void mirror_tree(Node root)
    {
        Node temp=null;
        if(root!=null)
        {
            mirror_tree(root.left);
            mirror_tree(root.right);
            temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
        return;
    }
    public static boolean check_mirror(Node root,Node root1)
    {
        if(root==null && root1==null)
            return true;
        if(root==null || root1==null || root.data!=root1.data)
            return false;
        return (check_mirror(root.left,root1.right) && check_mirror(root.right,root1.right));
    }
    public static void all_ancestors(Node root,int val)
    {
        if(root==null)
            return;
        stack.push(root);
        all_ancestors(root.left,val);
        if(root.data==val)
        {
            print_stack(stack);
            System.out.println();
            return;
        }
        all_ancestors(root.right,val);
        stack.pop();
        return;
    }
    public static Node lowest_common_ancestor(Node root,int val,int val2)
    {
        if(root==null)
            return null;
        if(root.data==val || root.data==val2)
            return root;
        Node left_node=lowest_common_ancestor(root.left,val,val2);
        Node right_node=lowest_common_ancestor(root.right,val,val2);
        if(left_node!=null && right_node!=null)
            return root;
        return (left_node!=null?left_node:right_node);
    }
    public static void zig_zag_display(Node root)
    {
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);
        while(true)
        {
            if(!(stack1.isEmpty()))
            {
                while(!(stack1.isEmpty()))
                {
                    Node temp=stack1.pop();
                    if(temp.left!=null)
                     stack2.push(temp.left);
                    if(temp.right!=null)
                    stack2.push(temp.right);
                    System.out.print(temp.data + " ");
                }
            }
            if(!(stack2.isEmpty()))
            {
                while(!(stack2.isEmpty()))
                {
                    Node temp=stack2.pop();
                    if(temp.right!=null)
                     stack1.push(temp.right);
                    if(temp.left!=null)
                     stack1.push(temp.left);
                    System.out.print(temp.data + " ");
                }
            }
            if(stack1.isEmpty() && stack2.isEmpty())
                break;
        }
    }
    public static void invert_binary_tree(Node root)
    {
        if(root==null)
            return;
        invert_binary_tree(root.left);
        invert_binary_tree(root.right);
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        return;
    }
    public static void main(String[] args)
    {
        Node root=new Node(1);
        Node root_left=new Node(2);
        Node root_right=new Node(3);
        root.left=root_left;
        root.right=root_right;
        Node root_left_left=new Node(4);
        Node root_left_right=new Node(5);
        Node root_right_left=new Node(6);
        Node root_right_right=new Node(7);
        root_left.left=root_left_left;
        root_left.right=root_left_right;
        root_right.left=root_right_left;
        root_right.right=root_right_right;
        preorder_display(root);
        System.out.println();
        inorder_display(root);
        System.out.println();
        postorder_display(root);
        System.out.println();
        level_order(root);
        System.out.println();
        System.out.println("Max element in tree : " + max_element(root));
        System.out.println("Min element in tree : " + min_element(root));
        int val=7;
        if(search_element(root,val))
            System.out.println(val + " is present");
        else
            System.out.println(val + " is not present");
        insert_node(root,8);
        level_order(root);
        System.out.println();
        System.out.println("Size of tree : " + size(root));
        reverse_level_order(root);
        System.out.println();
        System.out.println("Max height of tree : " + max_height(root));
        System.out.println("Min height of tree : " + min_height(root));
        Node root1=new Node(1);
        Node root1_left=new Node(2);
        Node root1_right=new Node(3);
        root1.left=root1_left;
        root1.right=root1_right;
        Node root1_left_left=new Node(4);
        Node root1_left_right=new Node(5);
        Node root1_right_left=new Node(6);
        Node root1_right_right=new Node(7);
        root1_left.left=root1_left_left;
        root1_left.right=root1_left_right;
        root1_right.left=root1_right_left;
        root1_right.right=root1_right_right;
        if(structurally_identical(root,root1))
            System.out.println("They are identical");
        else
            System.out.println("They are not structurally identical");
        System.out.println("Diameter of the tree : " + diameter(root));
        System.out.println("Max sum at a level : " + max_sum(root));
        paths(root);
        mirror_tree(root);
        level_order(root);
        System.out.println();
        mirror_tree(root);
        level_order(root);
        System.out.println();
        if(check_mirror(root,root1))
            System.out.println("Mirror trees");
        else
            System.out.println("Not mirror trees");
        all_ancestors(root,8);
        val=8;
        int val2=3;
        System.out.println("Lowest common ancestor of " + val + " and " + val2 + " is " + lowest_common_ancestor(root,val,val2).data);
        zig_zag_display(root);
        System.out.println();
        level_order(root);
        System.out.println();
        invert_binary_tree(root);
        level_order(root);
        System.out.println();
    }
}