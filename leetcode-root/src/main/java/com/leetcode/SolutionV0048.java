package com.leetcode;

import com.leetcode.utils.MockUtils;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/13 18:48
 * @Description 48. 旋转图像（中等）
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0048 {
    private static Logger logger = Logger.getLogger(SolutionV0048.class);

    public SolutionV0048(int max) {
        // 模拟输入
        int n = MockUtils.get(max);
        // 获取随机数

        logger.info("rotate = ");
        logger.info("=====end=====");
    }

    public void rotate(int[][] matrix) {

    }
}
