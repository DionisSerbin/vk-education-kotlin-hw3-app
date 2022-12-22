import com.education.homework3.server.CategoryDto
import com.education.homework3.server.DishDto
import com.education.homework3.server.ProductDto
import com.education.homework3.server.ServerData
import kotlinx.coroutines.delay


class Server {
    var server = ServerData()

    fun startConnection(){
//        server = ServerData()
    }

    suspend fun selectAllFromCategories(): List<CategoryDto> {
        makeDelay()
        return server.Category
    }

    suspend fun selectAllFromDishes(): List<DishDto> {
        makeDelay()
        return server.Dish
    }

    suspend fun selectProductWhereCategory(categoryId: Int): List<ProductDto> {
        makeDelay()
        val productList = mutableListOf<ProductDto>()
        for (product in server.Product) {
            if (product.category_id == categoryId) {
                productList.add(product)
            }
        }
        return productList
    }

    suspend fun selectDishWhereUser(userdId: Int): List<DishDto>{
        makeDelay()
        val dishByUserList = mutableListOf<Int>()
        for (dishByUser in server.UserDish) {
            if(dishByUser.user_id == userdId) {
                dishByUserList.add(dishByUser.dish_id)
            }
        }
        val dishList = mutableListOf<DishDto>()
        for (dish in server.Dish) {
            if (dishByUserList.contains(dish.dish_id)){
                dishList.add(dish)
            }
        }
        return dishList
    }

    private suspend fun makeDelay(){
        delay(200)
    }

}
