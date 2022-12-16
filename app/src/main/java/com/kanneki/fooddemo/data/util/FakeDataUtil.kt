package com.kanneki.fooddemo.data.util

import com.kanneki.fooddemo.data.dto.ProductDataDto
import com.kanneki.fooddemo.data.dto.ProductTypeDataDto

/**
 * 此為Demo範本,沒有要串接API所以會有假資料
 */
object FakeDataUtil {

    /**
     * 商品分類假資料
     */
    val fakeProductTypeList = listOf<ProductTypeDataDto>(
        ProductTypeDataDto(1, "全部", 0),
        ProductTypeDataDto(2, "套餐", 10),
        ProductTypeDataDto(3, "飯類", 20),
        ProductTypeDataDto(4, "麵類", 30),
        ProductTypeDataDto(5, "西式", 40),
        ProductTypeDataDto(6, "飲料", 50)
    )

    /**
     * 商品假資料
     */
    val fakeProductList = listOf<ProductDataDto>(
        ProductDataDto(
            1,
            "經典套餐 1",
            "中份薯條 1份\n超級無敵大麥克 1份\n普通可樂 1杯",
            159,
            10,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/pexels-robin-stickel-70497.jpg"
        ),
        ProductDataDto(
            2,
            "經典套餐 2",
            "3支雞腿\n3支雞翅\n普通可樂 2杯",
            189,
            10,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/leo-roza-CLMpC9UhyTo-unsplash%20(1).jpg"
        ),
        ProductDataDto(
            3,
            "經典套餐 3",
            "說明",
            219,
            10,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/ashley-green-UbTUTDRqj-o-unsplash.jpg"
        ),
        ProductDataDto(
            4,
            "經典套餐 4",
            "說明",
            199,
            10,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/amirali-mirhashemian-sc5sTPMrVfk-unsplash.jpg"
        ),
        ProductDataDto(
            5,
            "焗烤飯",
            "超好吃",
            90,
            20,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/tomoyo-s-OP5MUu2sTqY-unsplash.jpg"
        ),
        ProductDataDto(
            6,
            "炒飯",
            "超大碗",
            70,
            20,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/christopher-alvarenga-rQX9eVpSFz8-unsplash.jpg"
        ),
        ProductDataDto(
            7,
            "壽司",
            "好吃",
            100,
            20,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/niclas-illg-Y9pFfA4Z3g0-unsplash.jpg"
        ),
        ProductDataDto(
            8,
            "炒泡麵",
            "超大碗",
            50,
            30,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/joshua-ryder-I51a7Yy7mQA-unsplash.jpg"
        ),
        ProductDataDto(
            9,
            "義大利麵",
            "超好吃",
            110,
            30,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/pexels-eneida-nieves-803963.jpg"
        ),
        ProductDataDto(
            11,
            "拉麵",
            "超好吃",
            140,
            30,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/bon-vivant-qom5MPOER-I-unsplash.jpg"
        ),
        ProductDataDto(
            12,
            "Pizza",
            "超好吃",
            160,
            40,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/kelvin-t-AcA8moIiD3g-unsplash.jpg"
        ),
        ProductDataDto(
            13,
            "牛排",
            "超好吃",
            120,
            40,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/pexels-kasumi-loffler-3535383.jpg"
        ),
        ProductDataDto(
            14,
            "紅茶",
            "超好喝",
            20,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/yana-bhKdRjYJ1CA-unsplash.jpg"
        ),
        ProductDataDto(
            15,
            "綠茶",
            "超好喝",
            20,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/anton-darius-ZX1TWlw-grI-unsplash.jpg"
        ),
        ProductDataDto(
            16,
            "可樂",
            "超好喝",
            30,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/victor-rutka-P35npQyRNGw-unsplash.jpg"
        ),
        ProductDataDto(
            17,
            "珍珠奶茶",
            "超好喝",
            35,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/rosalind-chang-P_wPicZYoPI-unsplash.jpg"
        ),
        ProductDataDto(
            18,
            "檸檬紅茶",
            "超好喝",
            35,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/mae-mu-kbch-i63YTg-unsplash.jpg"
        ),
        ProductDataDto(
            19,
            "咖啡",
            "超好喝",
            70,
            50,
            "https://filedn.eu/ld7ntGrLWgQhBvvkDSMNGY8/nathan-dumlao-tA90pRfL2gM-unsplash.jpg"
        ),
    )
}