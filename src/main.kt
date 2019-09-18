fun main(args: Array<String>)
{
    val game: Game = Game()
    val player : Int = game.player()
    val dealer : Int = game.dealer(player)
    println(game.selectWinner(player,dealer))
}