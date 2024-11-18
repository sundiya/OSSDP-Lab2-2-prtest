package question;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 *
 * 示例 1：
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 */
public class Solution5 {
    static final int P = 1_000_000_007; // 模数
    static final int MAX_N = 100_005; // 最大长度限制
    int[] f = new int[MAX_N]; // 2 的幂次预处理数组

    public int numSubseq(int[] nums, int target) {
        pretreatment(); // 预处理 2 的幂次取模值
        Arrays.sort(nums); // 对数组排序
        int ans = 0;

        // 遍历每个可能的左边界
        for (int i = 0; i < nums.length && nums[i] <= target; ++i) {
            int maxValue = target - nums[i]; // 最大允许的右边界值
            int pos = binarySearch(nums, maxValue); // 找到右边界位置

            if (pos >= i) { // 确保右边界在左边界之后
                int contribute = f[pos - i]; // 计算贡献值
                ans = (ans + contribute) % P; // 累计答案
            }
        }

        return ans;
    }

    // 预处理 2^i % P 值
    public void pretreatment() {
        f[0] = 1; // 空子序列贡献值为 1，但实际计算时不会算入答案
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] * 2) % P; // 2 的幂次取模
        }
    }

    // 二分查找，找到小于等于 target 的最大索引
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1; // 二分范围
        while (low <= high) {
            int mid = low + (high - low) / 2; // 防止溢出
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high; // 返回满足条件的最大索引
    }
}
