const val USER_NAME1 = "Alex"
const val USER_NAME2 = "Вася"
const val USER_NAME3 = "Женя"
const val USER_NAME4 = "Олег"
const val USER_NAME5 = "Аркадий"
const val USER_NAME6 = "Crazy Frog"

fun main() {
    println(agoToText(32541))
}

fun minutesAgo(seconds: Int): Int {
    return seconds / 60
}

fun hoursAgo(seconds: Int): Int {
    return seconds / 3600
}

fun minutesToText(seconds: Int): String {
    return when (val minutes = minutesAgo(seconds)) {
        1, 21, 31, 41, 51 -> "$minutes минуту назад"
        2, 3, 4, 22, 23, 24, 32, 33, 34, 42, 43, 44, 52, 53, 54 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun hoursToText(seconds: Int): String {
    return when (val hours = hoursAgo(seconds)) {
        1, 21 -> "$hours час назад"
        2, 3, 4, 22, 23 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "$USER_NAME1 \nбыл(а) в сети только что"
        in 61..3600 -> "$USER_NAME2 \nбыл(а) в сети ${minutesToText(seconds)}"
        in 3601..86400 -> "$USER_NAME3 \nбыл(а) в сети ${hoursToText(seconds)}"
        in 86401..172800 -> "$USER_NAME4 \nбыл(а) в сети сегодня"
        in 172801..259200 -> "$USER_NAME5 \nбыл(а) в сети вчера"
        else -> "$USER_NAME6 \nбыл(а) в сети давно"
    }
}