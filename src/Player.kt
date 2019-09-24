class Player(i: Int)
{
    val id: Int = i

    var scores: Int = 0
        set(value) {
            field += this.checkCount(value)
        }
    var cards: Int = 0
        set(value) {
            field += this.checkCount(value)
        }

    // Check if player still in game
    private fun checkCount(count: Int) : Int
    {
        if(this.scores <= 21)
        {
            return count
        }
        return 0
    }
}