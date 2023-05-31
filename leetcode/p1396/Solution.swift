class UndergroundSystem {
    private var inMap = [Int : (String, Int)] ()
    private var timeMap = [String : [String : (Int, Int)]]()

    init() {
        
    }
    
    func checkIn(_ id: Int, _ stationName: String, _ t: Int) {
        inMap[id] = (stationName, t)
    }
    
    func checkOut(_ id: Int, _ stationName: String, _ t: Int) {
        guard let (startStation, startTime) = inMap[id] else {
            return
        }

        var map = timeMap[startStation, default: [String : (Int, Int)]()]
        let (sum, count) = map[stationName, default: (0, 0)]
        map[stationName] = (sum + (t - startTime), count + 1)
        timeMap[startStation] = map
    }
    
    func getAverageTime(_ startStation: String, _ endStation: String) -> Double {
        guard let map = timeMap[startStation] else {
            return 0.0
        }

        guard let (sum, count) = map[endStation] else {
            return 0.0
        }

        return Double(sum) / Double(count)
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * let obj = UndergroundSystem()
 * obj.checkIn(id, stationName, t)
 * obj.checkOut(id, stationName, t)
 * let ret_3: Double = obj.getAverageTime(startStation, endStation)
 */
