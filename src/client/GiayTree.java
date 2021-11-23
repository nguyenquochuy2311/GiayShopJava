package client;

public class GiayTree {

	int key;
	GiayTree left, right;
 
    public GiayTree(int item)
    {
        key = item;
        left = right = null;
    }
}

//A Java program to introduce Binary Tree
class BinaryTree
{
    // Root of Binary Tree
	GiayTree root;
 
    // Constructors
    BinaryTree(int key)
    {
        root = new GiayTree(key);
    }
 
    BinaryTree()
    {
        root = null;
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = new GiayTree(1);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.left = new GiayTree(2);
        tree.root.right = new GiayTree(3);
 
        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */
 
 
        tree.root.left.left = new GiayTree(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}

