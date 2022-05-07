package io.github.sandeeplakka.codewars.kyu6;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }


    public static TreeNode leaf(int value) {
        return new TreeNode(value);
    }

    public static TreeNode join(int value, TreeNode left, TreeNode right) {
        return new TreeNode(left, right, value);
    }

    public TreeNode withLeftLeaf(int value) {
        this.left = new TreeNode(value);
        return this;
    }

    public TreeNode withLeaves(int leftValue, int rightValue) {
        this.left = new TreeNode(leftValue);
        this.right = new TreeNode(rightValue);
        return this;
    }

    public TreeNode withRightLeaf(int value) {
        this.right = new TreeNode(value);
        return this;
    }
}
