import java.util.concurrent.atomic.AtomicInteger;
import java.util.Arrays;

class Solution {
    public int[] runningSum(int[] nums) {
        AtomicInteger sum = new AtomicInteger(0);
        return Arrays.stream(nums)
                     .map(a -> sum.addAndGet(a)) // update sum and return it
                     .toArray();
    }
}
