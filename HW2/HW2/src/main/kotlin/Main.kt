import java.util.Scanner

fun main(args: Array<String>)
{
    evenOrOdd()
    isPalindrome()

}

fun evenOrOdd()
{
    println("Even or Odd")
    val s = Scanner(System.`in`)
    print("Enter a number:\n>")
    val input = s.nextDouble()

    if (input != null)
    {
        if (input % 2 == 0.0)
        {
            println("$input is even")
        }
        else
        {
            println("$input is odd")
        }
    }
}

fun isPalindrome()
{
    println("\nPalidrome")
    val s = Scanner(System.`in`)
    print("Enter a string\n>")
    val input = s.nextLine()
    val cleanStr = input.lowercase().replace(Regex("[^a-zA-Z0-9]"),"")
    val isPal =  cleanStr == cleanStr.reversed()

    println("$input is ${if (isPal) "a" else "not a"} palindrome")
}