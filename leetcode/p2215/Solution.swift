class Solution {
    func findDifference(_ nums1: [Int], _ nums2: [Int]) -> [[Int]] {
        var set1 = Set<Int>(nums1)
        var set2 = Set<Int>(nums2)
        return [Array<Int>(set1.subtracting(set2)), Array<Int>(set2.subtracting(set1))]
    }
}
