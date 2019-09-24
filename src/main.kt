fun main(args: Array<String>)
{
    println("Enter players count: ")
    val i: Int? = readLine()?.toInt()

    if (i !== null && i > 0)
    {
        val game: Game = Game()
        game.start(i)
        game.result()
    }
}