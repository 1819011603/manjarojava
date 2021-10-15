package com.company;

public class FindPeakElement162 {
    private static int ans = 0;
    public int findPeakElement(int[] nums) {
        ans = 0;
        int l = 0,r = nums.length-1,mid;
        if(r == 0)return 0;
        if(nums[0] > nums[1])return 0;
        if(nums[r]>nums[r-1])return r;
        findPeak(nums,0,r);
        return ans;
    }
    public void findPeak(int[] nums,int l,int r){
        if(l >= r || ans > 0)return;
        int mid = (l+r)>>1;
        if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] && nums[mid-1] != nums[mid+1]){
            ans = mid;
            return;
        }
        findPeak(nums,l,mid-1);
        findPeak(nums,mid+1,r);
    }

    public static void main(String[] args) {
        new FindPeakElement162().findPeakElement(new int[]{1,2,1,3,5,6,4});
        System.out.println(ans);
    }
}
