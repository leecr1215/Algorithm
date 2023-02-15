function solution(nums) {
  const arr = [...new Set(nums)];
  return Math.min(arr.length, nums.length / 2);
}
