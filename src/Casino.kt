class Casino {
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

    var points: Int = 0
    var cardsCount: Int = 0

    fun player() : Unit
    {
        var answer : String? = ""
        var message : String = "You can't take more cards :("

        while(this.points < 21)
        {
            if(this.points > 0)
            {
                println("Want more card? Y or N")
                answer = readLine()?.toLowerCase()
            }

            if(answer == "n")
            {
                message = "You stop"
                break
            }
            this.points += this.getCard()
            this.cardsCount++

            println("Your points is ${this.points}")
        }
        println(message)
    }

    fun dealer() : Unit
    {
        while(this.points < 21)
        {
            this.points += this.getCard()
            this.cardsCount++
            println("Dealer this.points is ${this.points}")

            if(this.points in 18..20 )
            {
                println("Dealer stop")
                break
            }

            if(this.points > 21)
            {
                println("Dealer stop")
            }
        }
    }

    private fun getCard() : Int {
        val card = this.cards.entries.shuffled().first()
        println("Card is ${card.key}")
        return card.value
    }

    fun selectWinner(winners: ArrayList<Player>) : String {
        var message: String = "Dealer win!"

        if(this.points < 22)
        {
            if(winners.first().scores > this.points)
            {
                message = this.announceWinner(winners)
            }

            if(winners.first().scores == this.points && winners.first().cards <= this.cardsCount)
            {
                message = this.announceWinner(winners)
            }
        }else{
            message = this.announceWinner(winners)
        }

        return message
    }

    private fun announceWinner(winners: ArrayList<Player>) : String
    {
        var announce: String = ""

        if(winners.count() > 1)
        {
            announce = "Winners of the game are"

            for (winner in winners)
            {
                announce += " player №${winner.id} "
            }
        }else
        {
            announce = "Winner is player №${winners.first().id}"
        }

        return announce
    }
}
