data class Recipe(
    val recipeName: String,
    val portionInPeople: Int,
    val ingredients: List<Ingredient>,
    val desc: String
)


data class Ingredient(
    val name: String,
    val total: Int,
    val unit: IngredientUnit
)

enum class IngredientUnit {
    tsp, tbs, ml, gram, pcs
}

fun Recipe.ingredientToString(): String {
    return this.ingredients.joinToString("\n") { "${it.name} : ${it.total} ${it.unit}" }
}


class App() {
    private var recipeList: MutableList<Recipe>? = null

    fun initRecipe() {
        recipeList = mutableListOf()
        recipeList?.apply {
            add(
                Recipe(
                    recipeName = "Nasi Goreng",
                    portionInPeople = 1,
                    ingredients = listOf(
                        Ingredient("Nasi", total = 500, unit = IngredientUnit.gram),
                        Ingredient("Sambal", total = 2, unit = IngredientUnit.tbs),
                        Ingredient("Egg", total = 2, unit = IngredientUnit.pcs),
                    ),
                    desc = "Just Stir fry nasi with sambal and eggs"
                )
            )
            add(
                Recipe(
                    recipeName = "Bakso",
                    portionInPeople = 1,
                    ingredients = listOf(
                        Ingredient("Bakso", total = 20, unit = IngredientUnit.pcs),
                        Ingredient("Daging", total = 100, unit = IngredientUnit.gram),
                        Ingredient("Broth", total = 200, unit = IngredientUnit.ml),
                    ),
                    desc = "Just Stir fry nasi with sambal and eggs"
                )
            )
        }
    }
    fun printRecipe() {
        if (recipeList == null) {
            println("Recipe is Empty")
            return
        }
        recipeList?.forEachIndexed { index, recipe ->
            println(
                """
                =============================
                Recipe number : ${index + 1}
                =============================
                How to make ${recipe.recipeName}
                -----------------------------
                Portion : ${recipe.portionInPeople} Per People
            """.trimIndent()
            )
            println("Ingredients :\n${recipe.ingredientToString()} \n")
            println("Step to make :\n${recipe.desc}")
            println()
        }
    }
}

fun main(args: Array<String>) {
    val app = App()
    app.initRecipe()
    app.printRecipe()
}