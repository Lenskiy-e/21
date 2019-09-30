import Interfaces.ICards

class Cards : ICards {
    private val cards: Map<String, Int> = mapOf(
        "2"     to 2,
        "3"     to 3,
        "4"     to 4,
        "5"     to 5,
        "6"     to 6,
        "7"     to 7,
        "8"     to 8,
        "9"     to 9,
        "10"    to 10,
        "Jack"  to 10,
        "Queen" to 10,
        "King"  to 10,
        "Ace"   to 11
    )

    override var pack: MutableMap<String, Map<String, Int>> = mutableMapOf(
        "diamonds"  to  this.cards,
        "hearts"    to this.cards,
        "spades"    to this.cards,
        "clubs"     to this.cards
    )

    override fun getCard(): Int
    {
        val pack = this.pack.entries.shuffled().first()
        val card = pack.value.entries.shuffled().first()

        this.pack[pack.key] = pack.value.filter { it.key != card.key }

        println("Card is ${card.key} of ${pack.key}")
        return card.value
    }
}