package com.leetcode;

import com.leetcode.demo.SpiDemo;
import com.leetcode.register.LocalRegister;

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
    public static List<String> registNames = new ArrayList<String>();

    static {
        registNames.add("spiDemo");
//        registNames.add("solutionV0001");
//        registNames.add("solutionV0002");
//        registNames.add("solutionV0003");
//        registNames.add("solutionV0004");
//        registNames.add("solutionV0011");
//        registNames.add("solutionV0012");
//        registNames.add("solutionV0014");
        registNames.add("solutionV0015"); // com.leetcode.model.ListNode.popVal
//        registNames.add("solutionV0075");
        registNames.add("solutionV0101"); // com.leetcode.model.TreeNode.popVal

        LocalRegister.regist("spiDemo", SpiDemo.class);
        LocalRegister.regist("solutionV0001", SolutionV0001.class);
        LocalRegister.regist("solutionV0002", SolutionV0002.class);
        LocalRegister.regist("solutionV0003", SolutionV0003.class);
        LocalRegister.regist("solutionV0004", SolutionV0004.class);
        LocalRegister.regist("solutionV0011", SolutionV0011.class);
        LocalRegister.regist("solutionV0012", SolutionV0012.class);
        LocalRegister.regist("solutionV0013", SolutionV0013.class);
        LocalRegister.regist("solutionV0014", SolutionV0014.class);
        LocalRegister.regist("solutionV0015", SolutionV0015.class);
        LocalRegister.regist("solutionV0075", SolutionV0075.class);

        LocalRegister.regist("solutionV0101", SolutionV0101.class);
        LocalRegister.regist("solutionV0135", SolutionV0135.class);

        LocalRegister.regist("solutionV0201", SolutionV0201.class);
        LocalRegister.regist("solutionV0202", SolutionV0202.class);

        LocalRegister.regist("solutionV0322", SolutionV0322.class);
        LocalRegister.regist("solutionV0344", SolutionV0344.class);
    }

    public static void main(String[] args) {
        try {
            for (int i = 0; i < registNames.size(); i++) {
                Class clazz = LocalRegister.get(registNames.get(i));
                clazz.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
