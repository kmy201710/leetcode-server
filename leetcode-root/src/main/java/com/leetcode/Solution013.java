package com.leetcode;

import com.leetcode.utils.MockUtils;
import com.leetcode.utils.RandomUtils;
import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 13. 罗马数字转整数
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution013 {
    private static Logger logger = Logger.getLogger(Solution013.class);

    public Solution013() {
        // 模拟输入
        int n = MockUtils.get(10);
        // 获取随机数
        String s = RandomUtils.randomCommon("a025fafddcsc", n);
        logger.info("s = " + s);

        logger.info("=====end=====");
    }

    public int romanToInt(String s) {
        return 0;
    }
}
