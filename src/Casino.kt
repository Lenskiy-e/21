class Casino {
    var points: Int = 0
    var cardsCount: Int = 0

    fun player(cards: Cards)
    {
        var answer : String? = ""
        var message = "You can't take more cards :("

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
            this.points += cards.getCard()
            this.cardsCount++

            println("Your points is ${this.points}")
        }
        println(message)
    }

    fun dealer(cards: Cards)
    {
        while(this.points < 21)
        {
            this.points += cards.getCard()
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


    fun selectWinner(winners: ArrayList<Player>) : String {
        var message = "Dealer win!"

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
        var announce: String

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
