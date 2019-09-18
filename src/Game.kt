class Game {
    private val cards: Map<String, Int> = mapOf(
        "2" to 2,
        "3" to 3,
        "4" to 4,
        "5" to 5,
        "6" to 6,
        "7" to 7,
        "8" to 8,
        "9" to 9,
        "10" to 10,
        "Jack" to 10,
        "Queen" to 10,
        "King" to 10,
        "Ace" to 11
    )

    fun player() : Int
    {
        var points: Int = 0
        var answer : String? = ""

        while(points < 21)
        {
            if(points > 0)
            {
                println("Want more card? Y or N")
                answer = readLine()?.toLowerCase()
            }

            if(answer == "n")
            {
                return points
            }
            points += this.getCard()

            println("Your points is $points")
        }
        println("You can't take more cards :(")
        return points
    }

    fun dealer(user: Int ) : Int
    {
        var points: Int = 0

        while(points < 21)
        {
            points += this.getCard()
            println("Dealer points is $points")

            if(points > 10 && (points > user || user > 21) )
            {
                println("Dealer stop")
                return points
            }

            if(points > 21)
            {
                println("Dealer stop")
            }
        }

        return points
    }

    private fun getCard() : Int {
        val card = this.cards.entries.shuffled().first()
        println("Card is ${card.key}")
        return card.value
    }

    fun selectWinner(user: Int, dealer: Int) : String {
        if(user > 21)
        {
            return "You lose :("
        }

        if(dealer > 21)
        {
            return "Dealer lose!"
        }

        if(dealer > user)
        {
            return "Dealer win!"
        }

        return "You win! :)"
    }
}
