package ru.netology

const val moneyTransfer = 950_000
const val transferLimit = 7_600_000

fun main() {

    val commission = paymentSystem("Maestro", transferLimit, moneyTransfer)

    if (commission == false) println("Данная платежная система не поддерживается")
    else println("Ваша комиссия за перевод составила: $commission копеек")
}

fun paymentSystem(paymentCard : String = "VK Pay", monthlyTransfers : Int = 0, currentTransfer : Int) : Any {

    return when (paymentCard) {
        "VK Pay" -> 0
        "Mastercard", "Maestro" -> if (monthlyTransfers > 7_500_000) {
            commissionMastercardMaestro(currentTransfer)
        } else 0
        "Visa", "Mir" -> commissionVisaMir(currentTransfer)
        else -> false
    }
}

fun commissionVisaMir(amountVisaMir: Int, percentCommission: Double = 0.75, minCommission: Int = 3_500): Int {

    return if (((amountVisaMir * percentCommission) / 100) < minCommission) minCommission
    else ((amountVisaMir * percentCommission) / 100).toInt()
}

fun commissionMastercardMaestro(amountMastercardMaestro: Int) : Int {

    val commissionCard = ((amountMastercardMaestro * 0.6) / 100) + 2_000
    return commissionCard.toInt()
}