
import java.util.*
class navigator {
    private val scanner = Scanner(System.`in`)
    // навигация
    fun start() {
        while (true) {
            println("выберите игру:")
            println("1. калькулятор")
            println("2. найти палиндром")
            println("3. счет очков")
            println("4. минимальное число")
            println("5. равно или нет")
            println("6. карточная игра 21")
            println("0. выход")
            when (scanner.nextInt()) {
                1 -> calculator()
                2 -> findPalindrome()
                3 -> scoreCalculator()
                4 -> findMinimum()
                5 -> checkEquality()
                6 -> cardGame21()
                0 -> {
                    println("выход из игры")
                    return
                }
                else -> println("неверный выбор")
            }
        }
    }
    // калькулятор
    private fun calculator() {
        println("введите первое число:")
        val num1 = scanner.nextDouble()
        println("введите второе число:")
        val num2 = scanner.nextDouble()
        println("введите операцию (+, -, *, /):")
        val operation = scanner.next()
        val result = when (operation) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> num1 / num2
            else -> {
                println("неверная операция")
                return
            }
        }
        println("результат: $result")
    }
    // найти палиндром
    private fun findPalindrome() {
        println("введите строку:")
        val input = scanner.next()
        val isPalindrome = input == input.reversed()
        if(isPalindrome == false)
            println("это не палиндром")
        else
            println("это палиндром")
    }
    // калькулятор побед
    private fun scoreCalculator() {
        println("введите количество побед:")
        val wins = scanner.nextInt()
        println("введите количество ничьих:")
        val draws = scanner.nextInt()
        println("введите количество поражений:")
        val losses = scanner.nextInt()
        val points = wins * 3 + draws
        println("количество очков: $points")
    }
    // минимальное число
    private fun findMinimum() {
        println("введите количество чисел:")
        val count = scanner.nextInt()
        val numbers = IntArray(count)
        println("введите числа:")
        for (i in 0 until count) {
            numbers[i] = scanner.nextInt()
        }
        val minimum = numbers.minOrNull()
        println("минимальное число: $minimum")
    }
    // равны или нет
    private fun checkEquality() {
        println("введите первое число:")
        val num1 = scanner.nextDouble()
        println("введите второе число:")
        val num2 = scanner.nextDouble()
        val isEqual = num1 == num2
        if(isEqual == false)
            println("они НЕ РАВНЫ")
        else
            println("они РАВНЫ")
    }
    //  игра 21
    private fun cardGame21() {
        val random = Random()
        var playerScore = 0
        var dealerScore = 0
        while (playerScore < 21 && dealerScore < 21) {
            println("хотите взять карту? (да/нет)")
            if (scanner.next() == "да") {
                val card = random.nextInt(1, 11)
                playerScore += card
                println("вы взяли карту: $card. ваш счет: $playerScore")
            } else {
                break
            }
            if (playerScore > 21) {
                println("вы перебрали! счет: $playerScore")
                return
            }
        }
        while (dealerScore < 17) {
            dealerScore += random.nextInt(1, 11)
        }
        println("счет дилера: $dealerScore")
        when {
            playerScore > 21 -> println("вы проиграли")
            dealerScore > 21 || playerScore > dealerScore -> println("вы выиграли")
            dealerScore > playerScore -> println("вы проиграли")
            else -> println("ничья")
        }
    }
}
fun main() {
    val gameNavigator = navigator()
    gameNavigator.start()
}
