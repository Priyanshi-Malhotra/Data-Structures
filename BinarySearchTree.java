import java.util.Stack;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data=data;
            left=right=null;
        }
    }
    public static Node insert(Node root,int data)
    {
        if(data<root.data && root.left!=null)
          insert(root.left,data);
        else if(data>root.data && root.right!=null)
          insert(root.right,data);
        else if(data>root.data && root.right==null)
        {
            Node new_node=new Node(data);
            root.right=new_node;
            return root;
        }
        else if(data<root.data && root.left==null)
        {
            Node new_node = new Node(data);
            root.left=new_node;
            return root;
        }
        return root;
    }
    public static boolean search_element(Node root,int data)
    {
        if(root==null)
            return false;
        if(data==root.data)
            return true;
        boolean left=false,right=false;
        if(data>root.data)
            right=search_element(root.right,data);
        else
            left=search_element(root.left,data);
        if(left)
            return left;
        return right;
    }
    public static int max_element(Node root)
    {
        if(root==null)
            return -1;
        if(root.right==null)
            return root.data;
        int max_element=max_element(root.right);
        return max_element;
    }
    public static int min_element(Node root)
    {
        if(root==null)
            return -1;
        if(root.left==null)
            return root.data;
        int min_element=min_element(root.left);
        return min_element;
    }
    public static Node delete_node(Node root,int data)
    {
        if(root==null)
            return null;
        if(data>root.data)
            root.right=delete_node(root.right,data);
        else if(data<root.data)
            root.left=delete_node(root.left,data);
        if(root.data==data)
        {
            if(root.left==null && root.right!=null)
                return root.right;
            else if(root.left!=null && root.right==null)
                return root.left;
            else if(root.right!=null && root.left!=null) {
                Node temp = max_element_node(root.left);
                root.left = delete_node(root.left, temp.data);
                root.data = temp.data;
            }
        }
        return root;
    }
    public static Node max_element_node(Node root)
    {
        if(root==null)
            return null;
        if(root.right==null)
            return root;

        return max_element_node(root.right);
    }
    public static Node lowest_common_ancestor(Node root,int data1,int data2)
    {
        if(root==null)
            return null;
        if(root.data==data1 || root.data==data2)
            return root;
        Node left=lowest_common_ancestor(root.left,data1,data2);
        Node right=lowest_common_ancestor(root.right,data1,data2);
        if(left!=null && right!=null)
            return root;
        return (left!=null?left:right);
    }
    public static boolean check_bst(Node root)
    {
        if(root==null)
            return true;
        if((root.left!=null && max_element(root.left)>root.data) || (root.right!=null && min_element(root.right)<root.data))
            return false;
        if(!(check_bst(root.left)) || !(check_bst(root.right)))
            return false;
        return true;
    }
    static Node head=null;
    static Node prev=null;
    public static void binary_tree_to_doublylinkedlist(Node current,Node head)
    {
        if(current==null)
            return;
        binary_tree_to_doublylinkedlist(current.left,head);
        if(prev==null)
            head=current;
        else
        {
            current.left=prev;
            prev.right=current;
        }
        prev=current;
        binary_tree_to_doublylinkedlist(current.right,head);
    }
    static int count=0;
    public static Node kth_smallest(Node root,int k)
    {
        if(root==null)
            return null;
        Node left=kth_smallest(root.left,k);
        if(left!=null)
            return left;
        if(++count==k)
            return root;
        return (kth_smallest(root.right,k));
    }
    public static int floor(Node root,int key)
    {
        if(root==null)
            return -1;
        if(root.data==key && (root.left==null || (root.left!=null && max_element(root.left)<root.data)))
            return root.data;
        else if(root.data<key && max_element(root)<=root.data)
            return root.data;
        return (key<root.data?floor(root.left,key):floor(root.right,key));
    }
    public static int ceil(Node root,int key)
    {
        if(root==null)
            return -1;
        if(root.data==key && (root.right==null || (root.right!=null && min_element(root.right)>=root.data)))
            return root.data;
        if(root.data>key && min_element(root)>=root.data)
            return root.data;
        return (key<root.data && max_element(root.left)>=key?ceil(root.left,key):ceil(root.right,key));
    }
    public static Node merge_trees(Node root1,Node root2)
    {
        if(root1==null)
            return root2;
        if(root2==null)
            return root1;
        root1.data+=root2.data;
        root1.left=merge_trees(root1.left,root2.left);
        root1.right=merge_trees(root1.right,root2.right);
        return root1;
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
    public static void main(String[] args)
    {
        Node root=new Node(5);
        root=insert(root,3);
        root=insert(root,4);
        root=insert(root,2);
        root=insert(root,1);
        root=insert(root,6);
        inorder_display(root);
        System.out.println();
        int val=10;
        if(search_element(root,val))
            System.out.println(val + " is present.");
        else
            System.out.println((val + " is not present."));
        System.out.println("Max element is : " + max_element(root));
        System.out.println("Min element is : " + min_element(root));
        /*delete_node(root,3);
        inorder_display(root);
        System.out.println();*/
        insert(root,3);
        inorder_display(root);
        System.out.println();
        System.out.println(lowest_common_ancestor(root,1,4).data);
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
        if(check_bst(root))
            System.out.println("It is a binary search tree.");
        else
            System.out.println("It is not a binary search tree.");
        binary_tree_to_doublylinkedlist(root1,head);
        System.out.println(kth_smallest(root,4).data);
        val=9;
        System.out.println("Floor of " + val + " is : " + floor(root,val));
        System.out.println("Ceil of " + val + " is : " + ceil(root,val));
    }
}
