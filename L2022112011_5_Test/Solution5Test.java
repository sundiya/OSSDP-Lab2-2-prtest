package L2022112011_5_Test;

import question.Solution5;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 以下是对这段使用JUnit 5进行单元测试代码的分析：
 *<p>
 * ### 测试用例设计总体原则
 * - **等价类划分原则**：将输入数据域划分成若干等价类，从每个等价类中选取具有代表性的数据来设计测试用例，这样可以用较少的测试用例覆盖尽可能多的情况。例如在这段代码中，考虑了正常情况（如示例数据对应的正常情况 `testNormalCaseExample1`）、边界情况（像数组长度最小、最大，元素值最小、最大，`target` 取最小值等边界相关的测试方法）以及特殊情况（如数组元素全部相同这种特殊场景的 `testSpecialCaseAllSameElements`）等不同的等价类，通过对这些不同类别情况的测试，期望能较为全面地验证 `Solution5` 类中 `numSubseq` 方法在各种可能输入下的正确性。
 *<p>
 * ### 各个测试方法具体分析
 *<p>
 * 1. **`testNormalCaseExample1` 方法**
 *     - **测试目的**：验证 `Solution5` 类中的 `numSubseq` 方法在题干给出的示例数据这种正常情况下能否正确返回预期结果。
 *     - **用到的测试用例**：
 *         - 输入数组 `nums1 = {3, 5, 6, 7}`，`target1 = 9`，期望输出 `expected1 = 4`。
 *         - 输入数组 `nums2 = {3, 3, 6, 8}`，`target2 = 10`，期望输出 `expected2 = 6`。
 *         - 输入数组 `nums3 = {2,3,3,4,6,7}`，`target3 = 12`，期望输出 `expected3 = 61`。
 *         通过创建 `Solution5` 类的实例，调用 `numSubseq` 方法获取实际输出 `actual1`、`actual2`、`actual3`，然后使用 `assertEquals` 断言来验证实际输出与期望输出是否一致。
 *<p>
 * 2. **`testBoundaryCaseMinLengthAndMinValue` 方法**
 *     - **测试目的**：测试当输入数组长度最小且元素值最小这种边界情况时，`numSubseq` 方法的返回结果是否符合预期。
 *     - **用到的测试用例**：
 *         - 输入数组 `nums = {1}`，`target = 1`，期望输出 `expected = 0`，表示在此种情况下不满足条件。同样是创建 `Solution5` 实例调用方法获取实际值与期望值对比验证。
 *<p>
 * 3. **`testBoundaryCaseMaxLengthAndMaxValue` 方法**
 *     - **测试目的**：针对输入数组长度最大且元素值最大的边界场景，验证 `numSubseq` 方法的正确性，尤其是要考虑可能出现的数值溢出以及按规则取余等情况。
 *     - **用到的测试用例**：
 *         - 创建长度为 `105` 的数组 `nums`，并使用 `Arrays.fill` 方法将所有元素填充为最大值 `106`，`target = 212`，期望输出 `expected = 243880902`。再进行实例调用和结果验证的常规操作。
 *<p>
 * 4. **`testSpecialCaseAllSameElements` 方法**
 *     - **测试目的**：检测当输入数组元素全部相同时（且不发生溢出的特殊情况），`numSubseq` 方法能否正确统计出满足条件的子序列数量。
 *     - **用到的测试用例**：
 *         - 输入数组 `nums = {5, 5, 5}`，`target = 10`，期望输出 `expected = 7`，注释中详细列出了对应的子序列情况，然后进行实际与期望结果的比较验证。
 *<p>
 * 5. **`testBoundaryCaseMinTarget` 方法**
 *     - **测试目的**：验证当 `target` 取最小值这种边界情况时，`numSubseq` 方法返回的结果是否正确，也就是验证在这种难以满足条件的情况下是否返回无子序列满足条件的正确标识。
 *     - **用到的测试用例**：
 *         - 输入数组 `nums = {2}`，`target = 1`，期望输出 `expected = 0`，后续进行相应的方法调用和断言验证。
 *<p>
 * 6. **`testBoundaryCaseTargetSlightlyLarger` 方法**
 *     - **测试目的**：测试当 `target` 比数组元素略大这种边界情况时，`numSubseq` 方法能否准确返回符合预期的子序列数量。
 *     - **用到的测试用例**：
 *         - 输入数组 `nums = {3, 4}`，`target = 6`，期望输出 `expected = 1`，对应的子序列为 `[3]`，最后通过调用方法对比实际和期望结果来验证。
 *<p>
 * 总体来说，这段单元测试代码覆盖了多种不同类型的情况来对 `Solution5` 类的 `numSubseq` 方法进行测试，有助于发现该方法在不同输入场景下可能存在的逻辑错误，保证方法功能的正确性。不过，实际应用中可能还需要根据具体业务逻辑和方法的更多细节特点进一步补充或完善测试用例，比如考虑更多不同元素组合的数组等情况来更全面地进行测试。
 */


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
