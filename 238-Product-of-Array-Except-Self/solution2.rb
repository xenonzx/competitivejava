#leetcode.com/problems/product-of-array-except-self/ ""
def calculate_prefix(nums)
  prefix = Array.new(nums.length)
  prefix[nums.length - 1] = 1
  for i in (nums.length - 2).downto(0) do
    prefix[i] = prefix[i + 1] * nums[i + 1]
  end
  prefix
end

def calculate_postfix(nums)
  postfix = Array.new(nums.length)
  postfix[0] = 1
  for i in 1...nums.length do
    previtem = postfix[i - 1]
    currentNum = nums[i - 1]
    postfix[i] = previtem.to_i * currentNum.to_i
  end
  postfix
end

def product_except_self(nums)
  prefix = calculate_prefix(nums)
  postfix = calculate_postfix(nums)
  result = []
  for i in 0...nums.length
    result.push(prefix[i] * postfix[i])
  end
  result
end
nums = [1, 2, 3, 4]
# puts nums.length
# for i in 0...nums.length do
#   puts "#{i}   #{nums[i]}"
# end

puts calculate_postfix(nums)
puts
puts calculate_prefix(nums)
puts
puts product_except_self(nums)
