package com.leonhom.leetcode.stack;

import com.leonhom.leetcode.common.entity.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点root，返回它的中序遍历。
 *
 * 示例1
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author: leon wang
 * @since: 2022/09/06
 */
public class LeetCode94Easy {

    @Test
    public void test() {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            root = stack.pop();
            result.add(root.getVal());
            root = root.getRight();
        }
        return result;
    }
}
