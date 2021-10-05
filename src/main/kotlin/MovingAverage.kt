import java.util.*

class MovingAverage(private val size: Int) {
    private var nums: Queue<Int> = LinkedList()

    fun next(value: Int): Double {
        if (nums.size < size) {
            nums.add(value)
        } else {
            nums.remove()
            nums.add(value)
        }
        return nums.sum() / nums.size.toDouble()
    }
}

