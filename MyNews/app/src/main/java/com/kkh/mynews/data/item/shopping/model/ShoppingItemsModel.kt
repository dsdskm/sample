package com.kkh.mynews.data.item.shopping.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shoppingItems")
data class ShoppingItemsModel(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var title: String = "",
    var link: String = "",
    var image: String = "",
    var lprice: Int = 0,
    var hprice: Int = 0,
    var mallName: String = "",
    var productId: Long = 0,
    var productType: Int = 0,
    var brand: String = "",
    var maker: String = "",
    var category1: String = "",
    var category2: String = "",
    var category3: String = "",
    var category4: String = "",
    var query: String = ""
)
/*
<title>허니트립 보스턴백</title>
<link>http://openapi.naver.com/l?AAABWLsQ7CIBRFv+Z1JLzSShkYqLajRmPcG6TQRCgiNunfizdnODnJfX9N2iUMCnoKHYWh/4sSlUtmli7nCExBPRY+bo1xCZaEaTOJ6NWXaKdsSHAB2Lg8gZ2QMmybA0cuqiyx4W0ZZR2KrvJyx2CPV3RQ95fbnDT3r+Fh2kbfz5su7x8wIs7ZjgAAAA==</link>
<image>http://shopping.phinf.naver.net/main_1031546/10315467179.jpg</image>
<lprice>6700</lprice>
<hprice>0</hprice>
<mallName>허니트립</mallName>
<productId>10315467179</productId>
<productType>2</productType>
<brand></brand>
<maker>허니트립</maker>
<category1>패션잡화</category1>
<category2>여행용가방/소품</category2>
<category3>보스턴백</category3>
<category4></category4>
 */