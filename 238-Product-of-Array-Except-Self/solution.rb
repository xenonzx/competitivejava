# @param {Integer[]} nums
# @return {Integer[]}
# https://leetcode.com/problems/product-of-array-except-self/
def product_except_self(nums)
  arrayproduct = 1
  for n in nums
    arrayproduct *= n
  end
  for l in nums
    arrayproduct /= l
  end
end
