package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun main() {
    }

    @Test
    fun payment_system_default_test() {
        val transfer = 950_000

        val result = paymentSystem(currentTransfer = transfer)

        assertEquals(1, result)
    }

    @Test
    fun payment_system_vk_pay_test() {
        val nameCard = "VK Pay"
        val allTransfers = 7_600_000
        val transfer = 950_000

        val result = paymentSystem(paymentCard = nameCard, monthlyTransfers = allTransfers, currentTransfer = transfer)

        assertEquals(0, result)
    }

    @Test
    fun payment_system_mastercard_maestro_test() {
        val nameCard = "Mastercard"
        val allTransfers = 7_600_000
        val transfer = 950_000

        val result = paymentSystem(paymentCard = nameCard, monthlyTransfers = allTransfers, currentTransfer = transfer)

        assertEquals(7_700, result)
    }

    @Test
    fun payment_system_mastercard_maestro_else_test() {
        val nameCard = "Mastercard"
        val allTransfers = 7_400_000
        val transfer = 950_000

        val result = paymentSystem(paymentCard = nameCard, monthlyTransfers = allTransfers, currentTransfer = transfer)

        assertEquals(0, result)
    }

    @Test
    fun payment_system_visa_mir_test() {
        val nameCard = "Visa"
        val allTransfers = 7_400_000
        val transfer = 950_000

        val result = paymentSystem(paymentCard = nameCard, monthlyTransfers = allTransfers, currentTransfer = transfer)

        assertEquals(7_125, result)
    }

    @Test
    fun payment_system_else_test() {
        val nameCard = "PayPal"
        val allTransfers = 7_400_000
        val transfer = 950_000

        val result = paymentSystem(paymentCard = nameCard, monthlyTransfers = allTransfers, currentTransfer = transfer)

        assertEquals(false, result)
    }

    @Test
    fun commission_visa_mir_test() {
        val amount = 300_000
        val percent = 0.75
        val minCommissionTest = 3_500

        val result = commissionVisaMir(
            amountVisaMir = amount,
            percentCommission = percent,
            minCommission = minCommissionTest
        )

        assertEquals(3_500, result)
    }

    @Test
    fun commission_visa_mir_else_test() {
        val amount = 950_000
        val percent = 0.75
        val minCommissionTest = 3_500

        val result = commissionVisaMir(
            amountVisaMir = amount,
            percentCommission = percent,
            minCommission = minCommissionTest
        )

        assertEquals(7_125, result)
    }

    @Test
    fun commission_mastercard_maestro_test() {
        val amount = 950_000

        val result = commissionMastercardMaestro(amountMastercardMaestro = amount)

        assertEquals(7_700, result)
    }
}