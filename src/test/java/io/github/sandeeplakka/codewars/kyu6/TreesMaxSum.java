package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
Fun with trees: max sum

You are given a binary tree.
Implement the method maxSum which returns the maximal sum of a route from root to leaf.
For example, given the following tree:

    17
   /  \
  3   -10
 /    /  \
2    16   1
         /
        13

The method should return 23, since [17,-10,16] is the route from root to leaf with the maximal sum.

The class TreeNode is available for you:

        class TreeNode {
            TreeNode left;
            TreeNode right;
            int value;
            ...
        }

Categories : Algorithms, Trees, Data Structures, Recursion, Computability Theory
Theoretical Computer Science, Binary Search Trees, Binary

 */
class TreesMaxSum {

    //tests

    /**
     * null
     */
    @Test
    public void maxSumInNullTree() {
        TreeNode root = null;
        assertThat(maxSum(root), is(0));
    }

    /**
     * 17
     */
    @Test
    public void maxSumInLeaf() {
        TreeNode root = TreeNode.leaf(17);
        assertThat(maxSum(root), is(17));
    }

    /**
     * 1
     * /
     * 2
     */
    @Test
    public void maxSumInOneChildTree() {
        TreeNode root = TreeNode.leaf(1).withLeftLeaf(2);
        assertThat(maxSum(root), is(3));
    }

    /**
     * 5
     * /   \
     * -22    11
     * / \    / \
     * 9  50  9   2
     */
    @Test
    public void maxSumInPerfectTree() {
        TreeNode left = TreeNode.leaf(-22).withLeaves(9, 50);
        TreeNode right = TreeNode.leaf(11).withLeaves(9, 2);
        TreeNode root = TreeNode.join(5, left, right);
        assertThat(maxSum(root), is(33));
    }

    /**
     * 6
     * /  \
     * 50   40
     * /  \
     * -100  -10
     */
    @Test
    public void maxSumInUnbalancedTree() {
        TreeNode left = TreeNode.leaf(50).withLeaves(-100, -10);
        TreeNode right = TreeNode.leaf(40);
        TreeNode root = TreeNode.join(6, left, right);
        assertThat(maxSum(root), is(46));
    }

    /**
     * random tree 1
     */
    @Test
    public void randomTree1() {
        TreeNode root = buildRandomTree();
        int expected = maxSum(root);
        assertThat(maxSum(root), is(expected));
    }

    /**
     * random tree 2
     */
    @Test
    public void randomTree2() {
        TreeNode root = buildRandomTree();
        int expected = maxSum(root);
        assertThat(maxSum(root), is(expected));
    }


    private static TreeNode buildRandomTree() {
        int[] values = new java.util.Random().ints(1, 1001).limit(9).toArray();
        return TreeNode.join(values[0], TreeNode.leaf(values[1]).withRightLeaf(values[2]), TreeNode.join(values[3], TreeNode.leaf(values[4]).withLeaves(values[5], values[6]), TreeNode.leaf(values[7]).withLeftLeaf(values[8])));
    }

    //implementation
    static int maxSum(TreeNode root) {
        if (root == null) return 0;
        return root.value + Math.max(maxSum(root.left), maxSum(root.right));
    }

}