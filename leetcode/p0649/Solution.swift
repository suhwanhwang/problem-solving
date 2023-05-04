class Solution {
    /*
    DDRRR
    */
    func predictPartyVictory(_ senate: String) -> String {
        var qR = [Int]()
        var qD = [Int]()
        for (i, c) in senate.enumerated() {
            if c == "R" {
                qR.append(i)
            } else {
                qD.append(i)
            }
        }
        
        var nextIndex = senate.count

        while !qR.isEmpty && !qD.isEmpty {
            let indexR = qR.removeFirst()
            let indexD = qD.removeFirst()
            if indexR < indexD {
                qR.append(nextIndex)
            } else {
                qD.append(nextIndex)
            }
            nextIndex += 1
        }
        return qR.count > qD.count ? "Radiant" : "Dire"
    }
}
