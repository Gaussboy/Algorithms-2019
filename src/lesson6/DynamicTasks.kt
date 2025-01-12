@file:Suppress("UNUSED_PARAMETER")

package lesson6

import com.sun.xml.internal.bind.v2.TODO
import java.util.*


/**
 * Наибольшая общая подпоследовательность.
 * Средняя
 *
 * Дано две строки, например "nematode knowledge" и "empty bottle".
 * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
 * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
 * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
 * Если общей подпоследовательности нет, вернуть пустую строку.
 * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
 * При сравнении подстрок, регистр символов *имеет* значение.
 */
fun longestCommonSubSequence(first: String, second: String): String {
    val maxL =
        Array(first.length + 1) { IntArray(second.length + 1) }
    for (i in 1..first.length) {
        for (j in 1..second.length) {
            if (first[i - 1] == second[j - 1]) maxL[i][j] =
                maxL[i - 1][j - 1] + 1 else maxL[i][j] =
                Math.max(maxL[i - 1][j], maxL[i][j - 1])
        }
    }
    val result = StringBuilder()
    var i = first.length
    var j = second.length
    while (i > 0 && j > 0) {
        when {
            first[i - 1] == second[j - 1] -> {
                result.insert(0, first[i - 1])
                i--
                j--
            }
            maxL[i - 1][j] == maxL[i][j] -> i--
            else -> j--
        }
    }
    return result.toString()
}

/**
 * Наибольшая возрастающая подпоследовательность
 * Сложная
 *
 * Дан список целых чисел, например, [2 8 5 9 12 6].
 * Найти в нём самую длинную возрастающую подпоследовательность.
 * Элементы подпоследовательности не обязаны идти подряд,
 * но должны быть расположены в исходном списке в том же порядке.
 * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
 * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
 * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
 */
fun longestIncreasingSubSequence(list: List<Int>): List<Int> {
    val startSize: Int = list.size
    val maxL = IntArray(startSize)
    val previous = IntArray(startSize)
    for (i in 0 until startSize) {
        maxL[i] = 1
        previous[i] = -1
        for (j in 0 until i) {
            if (list[j] < list[i] && maxL[j] + 1 > maxL[i]) {
                maxL[i] = maxL[j] + 1
                previous[i] = j
            }
        }
    }
    var position = 0
    var length = 0
    for (i in 0 until startSize) {
        if (maxL[i] > length) {
            position = i
            length = maxL[i]
        }
    }
    val result: List<Int> = ArrayList()
    if (list.isEmpty()) return result
    while (position != -1) {
        result.add(0, list[position])
        position = previous[position]
    }
    return result
}

/**
 * Самый короткий маршрут на прямоугольном поле.
 * Средняя
 *
 * В файле с именем inputName задано прямоугольное поле:
 *
 * 0 2 3 2 4 1
 * 1 5 3 4 6 2
 * 2 6 2 5 1 3
 * 1 4 3 2 6 2
 * 4 2 3 1 5 0
 *
 * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
 * В каждой клетке записано некоторое натуральное число или нуль.
 * Необходимо попасть из верхней левой клетки в правую нижнюю.
 * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
 * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
 *
 * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
 */
fun shortestPathOnField(inputName: String): Int {
    TODO()
}

// Задачу "Максимальное независимое множество вершин в графе без циклов"
// смотрите в уроке 5