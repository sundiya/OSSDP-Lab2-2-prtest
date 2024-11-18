package L2022112011_5_Test;

import question.Solution5;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution5Test {

    // 1. 测试正常情况，示例数据验证,题干中给出的情况
    @Test
    public void testNormalCaseExample1() {
        int[] nums1 = {3, 5, 6, 7};
        int[] nums2 = {3, 3, 6, 8};
        int[] nums3 = {2,3,3,4,6,7};
        int target1 = 9;
        int target2 = 10;
        int target3 = 12;
        int expected1 = 4; // 示例1期望输出
        int expected2 = 6; // 示例2期望输出
        int expected3 = 61; // 示例2期望输出
        Solution5 solution = new Solution5();
        int actual1 = solution.numSubseq(nums1, target1);
        int actual2 = solution.numSubseq(nums2, target2);
        int actual3 = solution.numSubseq(nums3, target3);
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // 2. 测试边界情况，数组长度最小且元素值最小
    @Test
    public void testBoundaryCaseMinLengthAndMinValue() {
        int[] nums = {1};
        int target = 1;
        int expected = 0; // 不满足条件
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 3. 测试边界情况，数组长度最大且元素值最大
    //此时会出现溢出，2的105次幂 = 4026531840782516222
    //对100000007取余 243880903
    //减去空集，空集不算贡献率
    @Test
    public void testBoundaryCaseMaxLengthAndMaxValue() {
        int[] nums = new int[105];
        Arrays.fill(nums, 106); // 全部填充为最大值106
        int target = 212; // 保证 106+106 不超过 target
        int expected = 243880902; //
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }

    // 4. 测试特殊情况，数组元素全部相同，但不发生溢出
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
        int expected = 1; // 子序列为: [3]
        Solution5 solution = new Solution5();
        int actual = solution.numSubseq(nums, target);
        assertEquals(expected, actual);
    }
}
