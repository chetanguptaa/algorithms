package binaryTree;

import static binaryTree.BinaryTree.sc;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
    static TreeNode createTree() {
        TreeNode root = null;
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        if (data == -1)
            return null;
        root = new TreeNode(data);
        System.out.println("Enter left for: " + data);
        root.left = createTree();
        System.out.println("Enter right for: " + data);
        root.right = createTree();
        return root;
    }
}
