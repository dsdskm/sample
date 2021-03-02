package com.kkh.mynews.test.dagger2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kkh.mynews.common.Constant
import com.kkh.mynews.test.dagger2.exam1.Burger
import com.kkh.mynews.test.dagger2.exam1.BurgerComponent
import com.kkh.mynews.test.dagger2.exam1.BurgerModule
import com.kkh.mynews.test.dagger2.exam1.DaggerBurgerComponent
import javax.inject.Inject


class DaggerActivity : AppCompatActivity() {
    companion object {
        const val TAG = Constant.TAG_PREFIX + "DaggerActivity"
    }

    @Inject
    lateinit var burger: Burger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*WheatBun bun = new WheatBun();
        BeefPatty patty = new BeefPatty();

        burger = new Burger(bun, patty);*/

        /*WheatBun bun = new WheatBun();
        BeefPatty patty = new BeefPatty();

        burger = new Burger(bun, patty);*/
        val component: BurgerComponent = DaggerBurgerComponent.builder()
            .build()

        component.inject(this)

        Log.d(
            "MyTag", "burger bun : " + burger.bun.bun.toString() +
                    " , patty : " + burger.patty.patty
        )

    }
}