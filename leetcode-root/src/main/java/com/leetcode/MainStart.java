package com.leetcode;

import com.leetcode.demo.JdbcDemo;
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
//        registNames.add("solution001");
//        registNames.add("solution002");
//        registNames.add("solution003");
//        registNames.add("solution004");
        registNames.add("solution011");
        registNames.add("solution012");

        LocalRegister.regist("jdbcDemo", JdbcDemo.class);
        LocalRegister.regist("spiDemo", SpiDemo.class);
        LocalRegister.regist("solution001", Solution001.class);
        LocalRegister.regist("solution002", Solution002.class);
        LocalRegister.regist("solution003", Solution003.class);
        LocalRegister.regist("solution004", Solution004.class);
        LocalRegister.regist("solution011", Solution011.class);
        LocalRegister.regist("solution012", Solution012.class);
        LocalRegister.regist("solution013", Solution013.class);
        LocalRegister.regist("solution014", Solution014.class);
        LocalRegister.regist("solution015", Solution015.class);
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
