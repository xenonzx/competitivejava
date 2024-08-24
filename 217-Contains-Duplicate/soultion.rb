def contains_duplicate(nums)
  hash = Hash.new(0)
  result = false
  for n in nums
    if hash[n] == 0
      hash[n] = hash[n] + 1
    else
      result = true
      break
    end
  end
  result
end
