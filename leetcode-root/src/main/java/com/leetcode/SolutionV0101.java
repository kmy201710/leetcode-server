package com.leetcode;

import com.leetcode.model.TreeNode;
import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 101. 对称二叉树（简单）
 * 给定一个二叉树，检查它是否是镜像对称的。。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0101 {
    private static Logger logger = Logger.getLogger(SolutionV0101.class);

    public SolutionV0101() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums1 = RandomUtils.randomCommon2(n);
        int[] nums2 = RandomUtils.randomCommon2(nums1[0]);
        logger.info("nums1 = " + Arrays.toString(nums1));
        logger.info("nums2 = " + Arrays.toString(nums2));

        TreeNode root = TreeNode.get(nums1);
        logger.info("root = " + Arrays.toString(root.popVal()));

        boolean result = isSymmetric(root);
        logger.info("isSymmetric = " + result);
        logger.info("=====end=====");
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && check(n1.left, n2.right) && check(n1.right, n2.left);
    }
}
