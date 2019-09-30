package Interfaces

interface ICards {
    var pack: MutableMap<String, Map<String, Int>>

    fun getCard(): Int
}