package com.leetcode;

import com.leetcode.demo.SpiDemo;
import com.leetcode.register.LocalRegister;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hhe
 * @Date 2021/2/3 17:35
 * @Description 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MainStart {
    public static int max = 100;

    public static List<String> registNames = new ArrayList<String>();

    static {
        registNames.add("spiDemo");
        LocalRegister.regist("spiDemo", SpiDemo.class);

        /**
         * LCP 01. 猜数字（简单）
         */
//        registNames.add("solutionLCP01");
        LocalRegister.regist("solutionLCP01", SolutionLCP01.class);

        /**
         * 1. 两数之和（简单）
         * 2. 两数相加（中等）
         * 3. 无重复字符的最长子串（中等）
         * 4. 寻找两个正序数组的中位数（困难）
         * 11. 盛最多水的容器（中等）
         * 12. 整数转罗马数字（中等）
         * 13. 罗马数字转整数（简单）
         * 14. 最长公共前缀（简单）
         * 15. 三数之和（中等）
         * 75. 颜色分类（中等）
         */
//        registNames.add("solutionV0001");
//        registNames.add("solutionV0002"); // com.leetcode.model.ListNode
//        registNames.add("solutionV0003");
//        registNames.add("solutionV0004"); // com.leetcode.model.ListNode
//        registNames.add("solutionV0011");
//        registNames.add("solutionV0012"); // com.leetcode.model.ListNode
//        registNames.add("solutionV0014");
//        registNames.add("solutionV0015");
//        registNames.add("solutionV0018");
//        registNames.add("solutionV0075");

        /**
         * 101. 对称二叉树（简单）
         * 135. 分发糖果（困难）
         * 201. 数字范围按位与（中等）
         * 202. 快乐数（简单）
         * 231. 2的幂（简单）
         * 322. 零钱兑换（中等）
         * 326. 3的幂（简单）
         * 342. 4的幂（简单）
         * 344. 反转字符串（简单）
         * 500. 键盘行（简单）
         */
//        registNames.add("solutionV0101"); // com.leetcode.model.TreeNode
        registNames.add("solutionV0135");
        registNames.add("solutionV0201");

        registNames.add("solutionV0500");


        LocalRegister.regist("solutionV0001", SolutionV0001.class);
        LocalRegister.regist("solutionV0002", SolutionV0002.class);
        LocalRegister.regist("solutionV0003", SolutionV0003.class);
        LocalRegister.regist("solutionV0004", SolutionV0004.class);
        LocalRegister.regist("solutionV0011", SolutionV0011.class);
        LocalRegister.regist("solutionV0012", SolutionV0012.class);
        LocalRegister.regist("solutionV0013", SolutionV0013.class);
        LocalRegister.regist("solutionV0014", SolutionV0014.class);
        LocalRegister.regist("solutionV0015", SolutionV0015.class);
        LocalRegister.regist("solutionV0018", SolutionV0018.class);
        LocalRegister.regist("solutionV0075", SolutionV0075.class);

        LocalRegister.regist("solutionV0101", SolutionV0101.class);
        LocalRegister.regist("solutionV0135", SolutionV0135.class);
        LocalRegister.regist("solutionV0201", SolutionV0201.class);
        LocalRegister.regist("solutionV0202", SolutionV0202.class);
        LocalRegister.regist("solutionV0231", SolutionV0231.class);
        LocalRegister.regist("solutionV0322", SolutionV0322.class);
        LocalRegister.regist("solutionV0326", SolutionV0326.class);
        LocalRegister.regist("solutionV0342", SolutionV0342.class);
        LocalRegister.regist("solutionV0344", SolutionV0344.class);
        LocalRegister.regist("solutionV0500", SolutionV0500.class);
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < registNames.size(); i++) {
                System.out.println("i = " + i);
                Class clazz = LocalRegister.get(registNames.get(i));
                Constructor constructor = clazz.getDeclaredConstructor(int.class);
                constructor.newInstance(max);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
