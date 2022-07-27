package com.eternal.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Eternal
 * @Date 2022/7/27
 */
public class Traversal {

    /*
    * BM23 二叉树的前序遍历
    * */
    public void preorder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        // 先遍历根节点
        list.add(root.val);

        // 再去左子树
        preorder(list, root.left);

        // 最后去右子树
        preorder(list, root.right);
    }

    /*
    * BM24 二叉树的中序遍历
    * */
    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        // 先去左子树
        inorder(list, root.left);

        // 再访问根节点
        list.add(root.val);

        // 最后去右子树
        inorder(list, root.right);
    }

    /*
     * BM25 二叉树的后序遍历
     * */
    public void postorder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        // 先去左子树
        inorder(list, root.left);

        // 再去右子树
        inorder(list, root.right);

        // 最后访问根节点
        list.add(root.val);
    }

    public int[] traversal(TreeNode root) {
        // 添加遍历结果的数组
        List<Integer> list = new ArrayList<>();

        // 递归前序遍历
        preorder(list, root);

        // 递归中序遍历
        inorder(list, root);

        // 递归后序遍历
        postorder(list, root);

        // 返回的结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

}