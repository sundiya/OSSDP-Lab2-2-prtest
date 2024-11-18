package test;

import question.Solution5;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class L2022112011_5_Test {

    // 1. 测试正常情况，示例数据验证
    @Test
    public void testNormalCaseExample1() {
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        int expected = 4; // 示例1期望输出
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 2. 测试边界情况，数组长度最小且元素值最小
    @Test
    public void testBoundaryCaseMinLengthAndMinValue() {
        int[] nums = {1};
        int target = 1;
        int expected = 1; // 单个元素[1]本身满足条件
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 3. 测试边界情况，数组长度最大且元素值最大
    @Test
    public void testBoundaryCaseMaxLengthAndMaxValue() {
        int[] nums = new int[105];
        Arrays.fill(nums, 106); // 全部填充为最大值106
        int target = 212; // 保证 106+106 不超过 target
        int expected = 0; // 全部元素无法组成有效子序列
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 4. 测试特殊情况，数组元素全部相同
    @Test
    public void testSpecialCaseAllSameElements() {
        int[] nums = {5, 5, 5};
        int target = 10;
        int expected = 7; // 子序列为: [5], [5], [5], [5, 5], [5, 5], [5, 5], [5, 5, 5]
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 5. 测试边界情况，target取最小值
    @Test
    public void testBoundaryCaseMinTarget() {
        int[] nums = {2};
        int target = 1; // 无法满足条件
        int expected = 0; // 无子序列满足条件
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 6. 测试边界情况，target比数组元素略大
    @Test
    public void testBoundaryCaseTargetSlightlyLarger() {
        int[] nums = {3, 4};
        int target = 6;
        int expected = 2; // 子序列为: [3], [4]
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }
}
