package com.owodigi.sliding.window;

import java.util.List;

class MaxSumFixedSubArray1 extends MaxSumFixedSubArray {

    @Override
    public int subarraySumFixed(final List<Integer> nums, final int k) {
        int left = 0, right = 0, sum = 0, max = 0;
        while (right < nums.size()) {
            if (right < k) {
                sum += nums.get(right++);
            } else {
                max = Math.max(sum, max);
                sum -= nums.get(left++);
                sum += nums.get(right++);
            }
        }
        return max;
    }
}