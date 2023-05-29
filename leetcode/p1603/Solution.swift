class ParkingSystem {
    private var car = Array(repeating: 0, count: 4)
    init(_ big: Int, _ medium: Int, _ small: Int) {
        car[1] = big
        car[2] = medium
        car[3] = small
    }
    
    func addCar(_ carType: Int) -> Bool {
        guard 1 <= carType && carType <= 3 else {
            return false
        }
        guard car[carType] > 0 else {
            return false
        }
        car[carType] -= 1
        return true
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * let obj = ParkingSystem(big, medium, small)
 * let ret_1: Bool = obj.addCar(carType)
 */
