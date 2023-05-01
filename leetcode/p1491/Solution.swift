class Solution {
    func average(_ salary: [Int]) -> Double {
        let maxSalary = salary.max()!
        let minSalary = salary.min()!

        return Double(salary.filter { minSalary < $0 && $0 < maxSalary }
        .reduce(0, +)) / Double(salary.count - 2)
    }
}
