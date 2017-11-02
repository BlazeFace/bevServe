import java.util.*;
var amount = 0
fun loadInventory() {
    print("Enter amount added and unit price: ")
    val input = Scanner(System.`in`)
    amount = input.nextInt()
    val up = input.nextInt()
    val id = 0
    println("Enter 4 digit password: ")
    val pass = input.nextInt()
}
fun loadCard(amount: Int, id: Int){
    DatabaseConnect.writeDB(id,amount, "users", "accountvalue")
}
fun main(args : Array<String>) {
    //loadInventory()
    loadCard(100, 0)
}