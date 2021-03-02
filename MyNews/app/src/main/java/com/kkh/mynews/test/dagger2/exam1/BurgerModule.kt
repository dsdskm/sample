package com.kkh.mynews.test.dagger2.exam1

import dagger.Module
import dagger.Provides


@Module
class BurgerModule {
    @Provides
    fun provideBurger(bun: WheatBun?, patty: BeefPatty?): Burger {
        return Burger(bun!!, patty!!)
    }

    @Provides
    fun provideBun(): WheatBun {
        return WheatBun()
    }

    @Provides
    fun providePatty(): BeefPatty {
        return BeefPatty()
    }
}
