import java.util.Scanner


fun main(args: Array<String>)
{
    evenOrOdd()
    isPalindrome()
    sumAndAverageOfArray()
    searchArrayStrings()
    sub2Matrices()
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

    println("$input is ${if (isPal) "a" else "not a"} palindrome\n")
}

fun sumOfArray(dArray: DoubleArray): Double
{

    var sum = 0.0;
    for (i in dArray)
    {
        sum += i
    }

    return sum
}

fun sumAndAverageOfArray()
{
    val s = Scanner(System.`in`)
    print("Sum and Average of an Array\nEnter array elements separated by spaces (ie 1 2 3)\n>")

    var input: String  = s.nextLine()
    val elements = input.trim().split(" ")
    val doubleArray = DoubleArray(elements.size)

    var cnt = 0
    for (e in elements)
    {
        doubleArray[cnt++] = e.toDouble()
    }

    val sum = sumOfArray(doubleArray)
    val avg = sum/doubleArray.size

    println("Sum of array is $sum\nAverage of array $avg\n")
}

fun searchArrayStrings()
{
    val s =  Scanner(System.`in`)

    print("String Search\nEnter the contents of the array separated by spaces (ie Hi Luck Charm)\n>")
    val input: String  = s.nextLine()

    //technically not an array but I think its a better solution for this case
    var strList = input.split(" ")

    print("Enter the string to search\n>")
    val search = s.nextLine()

    println("${search.trim()} ${if (search.trim() in strList) "is" else "is not"} in the list")
}

fun sub2Matrices()
{
    val s = Scanner(System.`in`)

    print("\nMatrix Subtraction A - B\nEnter the rows x columns of the matrix (ex: 2x3) no space in between\n>")

    val input = s.nextLine()
    val para = input.split("x")

    val rows = para[0].toInt()
    val cols = para[1].toInt()
    val matrixA = Array(rows){DoubleArray(cols)}
    val matrixB = Array(rows){DoubleArray(cols)}
    val matrixDiff = Array(rows){DoubleArray(cols)}

    println("Enter the elements of the first matrix($rows X $cols):")
    for(i in matrixA.indices)
    {
        for(j in matrixA[i].indices)
        {
            print("matrixA[$i][$j]:")
            matrixA[i][j] = s.nextDouble()
        }
    }

    println("Enter the elements of the second matrix($rows X $cols):")
    for(i in matrixB.indices)
    {
        for(j in matrixB[i].indices) {
            print("matrixB[$i][$j]:")
            matrixB[i][j] = s.nextDouble()
        }
    }

    for(i in matrixA.indices){
        println("${matrixA[i].contentToString()} ")
    }

    println("Matrix B:")
    for(i in matrixB.indices){
        println("${matrixB[i].contentToString()} ")
    }

    for (row in matrixA.indices)
    {
        for (col in matrixB.indices)
        {
            matrixDiff[row][col] = matrixA[row][col] - matrixB[row][col]
        }
    }

    println("\nDifference of the Matrices:")
    for(i in matrixDiff.indices){
        println("${matrixDiff[i].contentToString()} ")
    }


}