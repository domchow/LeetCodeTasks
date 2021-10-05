import  kotlin.math.abs

class LeetCode private constructor() {

    companion object {
        fun kidsWithTheGreatestNumberOfCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
            val max = candies.sorted().last()
            return candies.map { it + extraCandies >= max }
        }

        fun toLowerCase(s: String): String {
            return s.toLowerCase()
        }

        fun numberOfGoodPairs(nums: IntArray) =
            nums.mapIndexed { index, i -> nums.copyOfRange(index + 1, nums.size).toMutableList().count { it == i } }
                .sum()

        fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
            var c = 0
            fun doCalc(root: TreeNode?, low: Int, high: Int) {
                if (root != null) {
                    doCalc(root.left, low, high)
                    doCalc(root.right, low, high)
                    if (root.nodeVal in low..high) {
                        c += root.nodeVal
                    }
                }
            }
            doCalc(root, low, high)
            return c
        }

        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            return nums.map { num -> nums.filter { it < num }.size }.toIntArray()
        }

        fun calculateTime(keyboard: String, word: String) =
            keyboard.indexOf(word[0]) + word.mapIndexed { index, c ->
                if (index==0) return@mapIndexed 0
                abs(keyboard.indexOf(word[index - 1]) - keyboard.indexOf(c))
            }.sum()
    }
}

data class TreeNode(var nodeVal: Int, var left: TreeNode? = null, var right: TreeNode? = null)
