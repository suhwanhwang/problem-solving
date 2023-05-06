class Solution {
    /*
    func numSubseq(_ nums: [Int], _ target: Int) -> Int {
        let nums = nums.sorted()
        var list = [Int]()
        return helper(nums, target, 0, nil, nil)
    }

    private func helper(_ nums: [Int], _ target: Int, _ index:Int, _ minNum: Int?, _ maxNum: Int?) -> Int {
        if index >= nums.count {
            if let minNum = minNum {
                if let maxNum = maxNum {
                    return (minNum + maxNum) <= target ? 1 : 0
                }
            } 
            return 0
        }

        let exclude = helper(nums, target, index + 1, minNum, maxNum)

        let minNum = (minNum == nil) ? nums[index] : minNum
        let maxNum = nums[index]
        let include = helper(nums, target, index + 1, minNum, maxNum)
        return include + exclude
    }
    */

    func numSubseq(_ nums: [Int], _ target: Int) -> Int {
        let nums = nums.sorted()
        var count = 0
        var power = Array<Int>(repeating: 0, count: nums.count + 1)
        power[0] = 1
        for i in 1...nums.count {
            power[i] = power[i - 1] * 2
            power[i] %= 1000000007
        }

        for (i, num) in nums.enumerated() {
            if 2 * num > target {
                break
            }

            let remain = target - num
            var endIndex = upperBound(nums, remain)
            if nums[endIndex] > remain {
                endIndex -= 1
            }

            //print ("\(i) - \(endIndex)")
            count += power[endIndex - i]
            count %= 1000000007
        }
        return count
    }
/*
    private var map = [Int:Int]()

    private func powerOfTwo(_ num: Int) -> Int {
        if let val = Solution.map[num] {
            return val 
        }

        var result = 1
        for i in 0..<num {
            result *= 2
            result %= 1000000007
        }
        map[num] = result
        return result
    }
*/

    private func upperBound(_ nums: [Int], _ target: Int) -> Int {
        var left = 0
        var right = nums.count - 1
        while left < right {
            let mid = (left + right) / 2
            if nums[mid] <= target {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

}
