package binaryTree;

import java.util.*;
import static binaryTree.TreeNode.createTree;

public class BinaryTree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        TreeNode root = createTree();
        System.out.println(inorderTraversal(root));
        System.out.println(preorderTraversal(root));
        System.out.println(postorderTraversal(root));
        System.out.println(invertBinaryTree(root));
    }

    static List<Integer> ans = new ArrayList<>();

    static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }

    static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }

    static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ans.add(root.val);
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        return ans;
    }

    static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        TreeNode temp = invertBinaryTree(root.left);
        root.left = invertBinaryTree(root.right);
        root.right = temp;
        return root;
    }

    static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int diameterPassingThroughRoot = maxDepth(root.left) + maxDepth(root.right);
        int diameterInLeftSubtree = diameter(root.left);
        int diameterInRightSubtree = diameter(root.right);

        return Math.max(diameterPassingThroughRoot, Math.max(diameterInLeftSubtree, diameterInRightSubtree));
    }

    static boolean balancedTree(TreeNode root) {
        return height(root) != -1;
    }

    static int height(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = height(root.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = height(root.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean sameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1.val != root2.val)
            return false;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        boolean left = false;
        boolean right = false;
        if (root1.val == root2.val) {
            left = sameTree(root1.left, root2.left);
            right = sameTree(root1.right, root2.right);
        }
        return left && right;
    }

    static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    static private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r)
            return null;
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }

    static TreeNode mergeTree(TreeNode p, TreeNode q) {
        if (p == null)
            return q;
        if (q == null)
            return p;
        TreeNode root = new TreeNode(p.val + q.val);
        root.left = mergeTree(p.left, q.left);
        root.right = mergeTree(p.right, q.right);
        return root;
    }

    int sum = 0;

    static boolean pathSum(TreeNode p, int targetSum) {
        if (p == null)
            return false;
        if (p.left == null && p.right == null)
            return targetSum == p.val;
        return pathSum(p.left, targetSum - p.val) || pathSum(p.right, targetSum - p.val);
    }
}