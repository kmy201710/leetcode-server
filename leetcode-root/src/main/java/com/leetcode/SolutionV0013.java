package com.leetcode;

import com.leetcode.model.ListNode;
import com.leetcode.model.Roman;
import org.apache.log4j.Logger;

/**
 * @Author hhe
 * @Date 2021/2/5 16:23
 * @Description 13. 罗马数字转整数（简单）
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionV0013 {
    private static Logger logger = Logger.getLogger(SolutionV0013.class);

    private static ListNode node = ListNode.get(new Roman());

    public SolutionV0013(String s) {
        int result = romanToInt(s);
        logger.info("romanToInt = " + result);
    }

    public int romanToInt(String s) {
        return helper(s.toCharArray(), 0, 0);
    }

    private int helper(char[] c, int index, int num) {
        if (c.length == index) {
            return num;
        }
        int i = index;
        char c1 = c[index];
        while (i < c.length && c[i] == c1) {
            if (node.name.equals(String.valueOf(c[i]))) {
                num += node.val;
                i++;
            } else {
                break;
            }
        }
        node = node.next;
        return helper(c, i, num);
    }
}
