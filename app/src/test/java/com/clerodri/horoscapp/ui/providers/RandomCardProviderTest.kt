package com.clerodri.horoscapp.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest{

    @Test
    fun `getRandomCard should return a random card`(){
        //GIVEN
        val randomCard = RandomCardProvider()
        //WHEN
        val card = randomCard.getLucky()
        //THEN
        assertNotNull(card)
    }
}