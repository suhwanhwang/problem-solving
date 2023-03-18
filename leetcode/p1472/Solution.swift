class BrowserHistory {
    private var history:[String] = []
    private var curIndex: Int

    init(_ homepage: String) {
        history.append(homepage)
        curIndex = 0
    }
    
    func visit(_ url: String) {
        while history.count - 1 > curIndex {
            print("removeLast")
            history.removeLast()
        }
        history.append(url)
        curIndex += 1
    }
    
    func back(_ steps: Int) -> String {
        curIndex = max(0, curIndex - steps)
        return history[curIndex]
    }
    
    func forward(_ steps: Int) -> String {
        curIndex = min(history.count - 1, curIndex + steps)
        return history[curIndex]
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * let obj = BrowserHistory(homepage)
 * obj.visit(url)
 * let ret_2: String = obj.back(steps)
 * let ret_3: String = obj.forward(steps)
 */
