package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 75. 颜色分类（中等）
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0075 {
    private static Logger logger = Logger.getLogger(SolutionV0075.class);

    public SolutionV0075() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        int[] nums = RandomUtils.randomCommon(n);
        logger.info("nums = " + Arrays.toString(nums));

        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = nums[i] % 3;
        }
        logger.info("colors = " + Arrays.toString(colors));

        int[] result = sortColors(colors);
        logger.info("sortColors = " + Arrays.toString(result));
        logger.info("=====end=====");
    }

    public int[] sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == 0) {
                nums = swap(nums, i, p0);
                p0++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                nums = swap(nums, i, p2);
                p2--;
            }
            if (i > p2) {
                break;
            }
        }
        return nums;
    }

    private int[] swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        return nums;
    }
}
