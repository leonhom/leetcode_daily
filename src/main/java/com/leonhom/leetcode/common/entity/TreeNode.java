package com.leonhom.leetcode.common.entity;

import lombok.Data;

/**
 * Definition for a binary tree node.
 *
 * @author: leon wang
 * @since: 2022/09/06
 */
@Data
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}