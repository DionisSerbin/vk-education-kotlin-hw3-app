package com.education.homework3.server

data class UserDto(
    val user_id: Int,
    val user_mail: String
)

data class CategoryDto(
    val category_id: Int,
    val category_name: String
)

data class ProductDto(
    val product_id: Int,
    val product_name: String,
    val category_id: Int
)

data class DishDto(
    val dish_id: Int,
    val dish_name: String,
    val dish_subs: String,
    val dish_image: String,
    val minutes: Int
)

data class UserDishDto(
    val user_id: Int,
    val dish_id: Int
)

data class UserProductDto(
    val user_id: Int,
    val product_id: Int
)

data class DishProductDto(
    val dish_id: Int,
    val product_id: Int
)

class ServerData {
    var Category: MutableList<CategoryDto> = mutableListOf(
        CategoryDto(1, "молочные продукты, яица"),
        CategoryDto(2, "овощи"),
        CategoryDto(3, "фрукты"),
        CategoryDto(4, "грибы"),
        CategoryDto(5, "макароны, крупы, масло"),
        CategoryDto(6, "мясо"),
        CategoryDto(7, "хлеб, выпечка"),
        CategoryDto(8, "рыба"),
        CategoryDto(9, "специи"),
        CategoryDto(10, "орехи")
    )

    var Product: MutableList<ProductDto> = mutableListOf(
        ProductDto(1, "молоко", 1),
        ProductDto(2, "сливки", 1),
        ProductDto(3, "йогурт", 1),
        ProductDto(4, "сыр", 1),
        ProductDto(5, "сливочный", 1),
        ProductDto(6, "творог", 1),
        ProductDto(7, "яйца", 1),
        ProductDto(8, "сметана", 1),
        ProductDto(9, "картофель", 2),
        ProductDto(10, "лук", 2),
        ProductDto(11, "огурцы", 2),
        ProductDto(12, "помидоры", 2),
        ProductDto(13, "капуста", 2),
        ProductDto(14, "морковь", 2),
        ProductDto(15, "свекла", 2),
        ProductDto(16, "черешня", 3),
        ProductDto(17, "бананы", 3),
        ProductDto(18, "мандарины", 3),
        ProductDto(19, "апельсины", 3),
        ProductDto(20, "яблоки", 3),
        ProductDto(21, "груши", 3),
        ProductDto(22, "лимон", 3),
        ProductDto(23, "виноград", 3),
        ProductDto(24, "ананас", 3),
        ProductDto(25, "шампиньоны", 4),
        ProductDto(26, "белые", 4),
        ProductDto(27, "лисички", 4),
        ProductDto(28, "спагетти", 5),
        ProductDto(29, "лапша", 5),
        ProductDto(30, "вермишель", 5),
        ProductDto(31, "спираль", 5),
        ProductDto(32, "рожки", 5),
        ProductDto(33, "рис", 5),
        ProductDto(34, "гречка", 5),
        ProductDto(35, "пшено", 5),
        ProductDto(36, "булгур", 5),
        ProductDto(37, "кунжут", 5),
        ProductDto(38, "мясо", 6),
        ProductDto(39, "курица", 6),
        ProductDto(40, "говядина", 6),
        ProductDto(41, "баранина", 6),
        ProductDto(42, "свинина", 6),
        ProductDto(43, "бекон", 6),
        ProductDto(44, "белый", 7),
        ProductDto(45, "черный", 7),
        ProductDto(46, "багет", 7),
        ProductDto(47, "бородинский", 7),
        ProductDto(48, "форель", 8),
        ProductDto(49, "лосось", 8),
        ProductDto(50, "селдь", 8),
        ProductDto(51, "тунец", 8),
        ProductDto(52, "карп", 8),
        ProductDto(53, "соль", 9),
        ProductDto(54, "сахар", 9),
        ProductDto(55, "перец", 9),
        ProductDto(56, "базилик", 9),
        ProductDto(57, "укроп", 9),
        ProductDto(58, "прованские травы", 9),
        ProductDto(59, "кунжут", 10),
        ProductDto(60, "арахис", 10),
        ProductDto(61, "миндаль", 10),
        ProductDto(62, "грецкий", 10)
    )
    var Dish: MutableList<DishDto> = mutableListOf(
        DishDto(
            1,
            "ризотто",
            "Нарежьте грибы тонкими пластинками и выложите на сковороду с разогретым оливковым маслом. " +
                    "Обжаривайте, пока грибы не подрумянятся. Влейте в сотейник вино. Когда оно впитается в рис, постепенно влейте горячий бульон. Затем добавьте измельчённый чеснок, обжаренные грибы, рубленую петрушку, тёртый пармезан и соль и хорошо перемешайте.",
            "https://cdn.lifehacker.ru/wp-content/uploads/2018/09/chicken-risotto_1537277876-e1537277924924.jpg",
            30
        ),
        DishDto(
            2,
            "карбонара",
            "Спагетти варить 7-10 минут в кипящей подсоленной воде и откинуть на дуршлаг В сковороде разогрейте оливковое масло, положите чеснок и слегка подрумяньте.Ветчину/бекон мелко нарежьте, добавьте к чесноку и обжаривайте 5 минут.Сыр пармезан натрите на мелкой терке. Желтки взбить со сливками, немного подсолить.Спагетти переложить в сотейник с чесноком и ветчиной/беконом.Добавить взбитые желтки и тёртый сыр, перемешать. Держать на огне 3 минуты.Посыпать молотым перцем, украсить зеленью и подавать на стол.",
            "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/150525210126/150601174518/p_O.jpg.webp",
            35
        ),
        DishDto(
            3,
            "стейк",
            "Сначала мясо нужно зачистить от различных пленок. Затем нарезаем его порционными кусками. Желательно чтобы их толщина была в пределах 1,5–2 сантиметров. Из 500-граммовой вырезки получится 5–6 кусков. В этом случае стейки будут слегка розовыми внутри. Если хотите, чтобы мясо внутри окончательно приготовилось, то, перевернув куски на другую сторону, подержите на сковороде под крышкой на протяжении 3,5–4 минут.",
            "https://www.chefmarket.ru/blog/wp-content/uploads/2019/06/steak-e1559574438347.jpg",
            15
        ),
        DishDto(
            4,
            "плов",
            "Рис для узбекского плова в казане промыть холодной водой, меняя ее несколько раз. Последняя вода после промывки должна остаться совершенно прозрачной. Рис готов. Разровнять поверхность, накрыть узбекский плов большой плоской тарелкой, а сверху крышкой. Уменьшить огонь до минимума и оставить плов на огне на 30 мин.",
            "https://www.gastronom.ru/binfiles/images/20170418/b87bb973.jpg",
            50
        ),
        DishDto(
            5,
            "борщ",
            "Налейте в кастрюлю холодную воду, выложите мясо и поставьте на средний огонь. Бульон будет вкуснее, если использовать именно мясо на кости. Для аромата можно добавить в кастрюлю немного измельчённого чеснока, молотой гвоздики или чёрного перца. Оставьте борщ под крышкой настаиваться 5–10 минут.",
            "https://cdn.lifehacker.ru/wp-content/uploads/2014/12/ob-05_1568611223-1280x640.jpg",
            55
        ),
        DishDto(
            6,
            "брускетта",
            "Подготовьте продукты. Брускетту чаще готовят на белом хлебе, используют багет или чиабатту. Но вообще подойдет любой, какой вы любите или какой есть в наличие. В качестве намазки возьмите любой мягкий сыр — сливочный, творожный, лучше без добавок, чтобы не забивать вкус рыбы. Дополнительно к крем-сыру можно добавить какой-нибудь яркий сыр, типа брынзы или козьего. Украсьте брускетту с лососем любой зеленью по вкусу — укропом, петрушкой, зеленым луком, базиликом. Также можно добавить помидорки-черри, оливки, дольки лимона. Подавайте блюдо к столу. Приятного аппетита!",
            "https://static.1000.menu/res/640/img/content-v2/04/e9/64664/brusketta-s-lososem_1651515164_13_max.jpg",
            10
        ),
        DishDto(
            7,
            "пюре с курицей",
            "Подготовьте курицу. Куриные окорочка приправьте солью и перцем. Сделайте надрезы ножом, вставьте кусочки чеснока. В миске соедините майонез, 1 яйцо, давленный чеснок, влейте 1 ч.л. воды, смешайте продукты. Положите в маринад окорочка и оставьте на 15 минут. Картофельное пюре с курицей разложите по порционным тарелкам, перед подачей посыпьте измельченной зеленью.",
            "https://cdn.food.ru/unsigned/fit/1080/810/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy9yZWNpcGVzLzU0NTAwL2NvdmVycy8zWEFTWEguanBlZw.webp",
            25
        ),
        DishDto(
            8,
            "поке",
            "Очистите авокадо от шкурки и нарежьте кубиками. Подавайте поке с курицей терияки, украсив тонко нарезанным листом нори и кунжутом.",
            "https://cdn.food.ru/unsigned/fit/1080/810/ce/0/czM6Ly9tZWRpYS9waWN0dXJlcy9yZWNpcGVzLzEyNi9jb3ZlcnMvM242RERqLmpwZw.webp",
            20
        ),
        DishDto(
            9,
            "драники",
            "Обжариваются драники на среднем огне с двух сторон до появления красивой румяной корочки, после чего сковородка накрывается крышкой, а блинчики прожариваются еще приблизительно три минуты на маленьком огне.",
            "https://eda.ru/img/eda/c620x415/s1.eda.ru/StaticContent/Photos/i/130327083418/p_O.jpg.webp",
            25
        ),
        DishDto(
            10,
            "салат с фрутками",
            "Фрукты помыть, очистить, нарезать кубиками. Заправить салат йогуртом.",
            "https://eda.ru/img/eda/c434x295/s1.eda.ru/StaticContent/Photos/170304220918/210325013621/p_O.jpg.webp",
            10
        )
    )

    var User: MutableList<UserDto> = mutableListOf(
        UserDto(1, "reaganusm@gmail.com")
    )
    lateinit var UserProduct: MutableList<UserProductDto>
    var UserDish: MutableList<UserDishDto> = mutableListOf(
        UserDishDto(1, 1),
        UserDishDto(1, 2),
        UserDishDto(1, 3),
        UserDishDto(1, 4),
        UserDishDto(1, 5),
        UserDishDto(1, 6),
        UserDishDto(1, 7),
        UserDishDto(1, 8),
        UserDishDto(1, 9),
        UserDishDto(1, 10),
    )
    var DishProduct: MutableList<DishProductDto> = mutableListOf(
        DishProductDto(1, 25),
        DishProductDto(1, 10),
        DishProductDto(1, 33),
        DishProductDto(1, 4),
        DishProductDto(1, 53),
        DishProductDto(2, 28),
        DishProductDto(2, 43),
        DishProductDto(2, 7),
        DishProductDto(2, 4),
        DishProductDto(2, 2),
        DishProductDto(2, 53),
        DishProductDto(2, 55),
        DishProductDto(3, 55),
        DishProductDto(3, 53),
        DishProductDto(3, 40),
        DishProductDto(4, 33),
        DishProductDto(4, 41),
        DishProductDto(4, 14),
        DishProductDto(4, 10),
        DishProductDto(4, 39),
        DishProductDto(5, 42),
        DishProductDto(5, 15),
        DishProductDto(5, 14),
        DishProductDto(5, 10),
        DishProductDto(5, 13),
        DishProductDto(5, 9),
        DishProductDto(5, 53),
        DishProductDto(5, 55),
        DishProductDto(6, 44),
        DishProductDto(6, 49),
        DishProductDto(6, 5),
        DishProductDto(7, 9),
        DishProductDto(7, 39),
        DishProductDto(7, 1),
        DishProductDto(7, 7),
        DishProductDto(7, 53),
        DishProductDto(7, 55),
        DishProductDto(8, 39),
        DishProductDto(8, 33),
        DishProductDto(8, 11),
        DishProductDto(8, 14),
        DishProductDto(8, 53),
        DishProductDto(9, 9),
        DishProductDto(9, 10),
        DishProductDto(9, 7),
        DishProductDto(9, 53),
        DishProductDto(9, 55),
        DishProductDto(10, 20),
        DishProductDto(10, 19),
        DishProductDto(10, 17),
        DishProductDto(10, 6),
        DishProductDto(10, 3)
    )

}