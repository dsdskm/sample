package com.kkh.mynews.test.dagger2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kkh.mynews.common.Constant

class DaggerActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "DaggerActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*
        val heater: Heater = A_Heater()
        val pump: Pump = A_Pump(heater)
        val coffeeMaker = CoffeeMaker(heater, pump)
        coffeeMaker.brew()
         */

        val coffeeMaker:CoffeeMaker = CoffeeMaker()


    }
}