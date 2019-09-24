class Game {

    private val players: ArrayList<Player> = arrayListOf()

    fun start(playersCount: Int)
    {
        for (i in 1..playersCount)
        {
            println("Player #$i turn")
            val casino: Casino = Casino()
            val player : Player = Player(i)
            casino.player()
            player.scores = casino.points
            player.cards = casino.cardsCount

            if(player.scores <= 21)
            {
                this.players.add(player)
            }
        }

    }

    fun result() : Unit
    {
        val winners: ArrayList<Player> = arrayListOf()
        var winner: Player = Player(0)

        val dealer: Casino = Casino()
        dealer.dealer()

        winner.scores = 0
        winner.cards = 0

        for (player in this.players) {
            if (player.scores > winner.scores) {
                winner = player
                winners.clear()
            }

            if (player.id != winner.id && player.scores == winner.scores) {

                if(winner.cards > player.cards)
                {
                    winner = player
                    winners.clear()
                }

                if(winner.cards == player.cards)
                {
                    winners.add(winner)
                    winners.add(player)

                }
            }
        }

        if(winners.count() == 0)
        {
            winners.add(winner)
        }

        println(dealer.selectWinner(winners))

    }
}