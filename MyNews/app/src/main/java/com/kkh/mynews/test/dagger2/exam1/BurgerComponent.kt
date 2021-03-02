package com.kkh.mynews.test.dagger2.exam1

import com.kkh.mynews.test.dagger2.DaggerActivity
import dagger.Component


@Component(modules = [BurgerModule::class])
interface BurgerComponent {
    fun inject(activity: DaggerActivity?)
}