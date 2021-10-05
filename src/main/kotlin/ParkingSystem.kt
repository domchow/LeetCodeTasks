class ParkingSystem(var big: Int, var medium: Int, var small: Int) {
    fun addCar(carType: Int): Boolean {
        return when (carType) {
            BIG_CAR_NUMBER -> big-- > ZERO
            MEDIUM_CAR_NUMBER -> medium-- > ZERO
            SMALL_CAR_NUMBER -> small-- > ZERO
            else -> false
        }
    }
    companion object {
        private const val ZERO = 0
        private const val BIG_CAR_NUMBER = 1
        private const val MEDIUM_CAR_NUMBER = 2
        private const val SMALL_CAR_NUMBER = 4
    }
}
