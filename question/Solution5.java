package question5;
import java.util.Arrays;

/**
 *
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 * <p>
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 * <p>
 * 示例 1：
 *<p>
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 *<p>
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 *<p>
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *<p>
 *
 * 提示：
 *<p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 */

//加上public，为了在测试类中能够使用Solution5
public class Solution5 {
    static final int P = 1000000007;
    static final int MAX_N = 100005;

    int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
        pretreatment();

        Arrays.sort(nums);
        //对数组排序，减少无用的选数

        int ans = 0;
        //从第i个数开始选择一串数组，如果第i个比target还大，那么后续数字一定不满足条件---选择左边界
        for (int i = 0; i < nums.length && nums[i] * 2 <= target; ++i) {//存在遗漏最后一个元素单独作为子序列情况，调整
            int maxValue = target - nums[i];//约束右边界
            int pos = binarySearch(nums, maxValue) - 1;
            int contribute = (pos >= i) ? f[pos - i] : 0;
            ans = (ans + contribute) % P;//累加取余用%
        }

        return ans;
    }

    public void pretreatment() {
        f[0] = 0;
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] << 1) % P;
        }
    }

    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;//二分上限
        while (low <= high) {
            int mid = low + (high - low) / 2;//防止溢出
            int num = nums[mid];
            if (num <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}