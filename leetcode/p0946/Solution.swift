class Solution {
    func validateStackSequences(_ pushed: [Int], _ popped: [Int]) -> Bool {
        
        var st = [Int]()
        var pushIndex = 0

        for popNum in popped {

            if !st.isEmpty && st.last == popNum {
                st.removeLast()
            } else {
                /*
                if pushIndex >= pushed.count {
                    return false
                }
                */

                while pushIndex < pushed.count && pushed[pushIndex] != popNum {
                    st.append(pushed[pushIndex])
                    pushIndex += 1
                }
                if pushIndex >= pushed.count {
                    return false
                }
                pushIndex += 1
            }
        }
        return st.isEmpty
    }
}
