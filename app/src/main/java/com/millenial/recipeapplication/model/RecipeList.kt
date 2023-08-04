package com.millenial.recipeapplication.model

import com.millenial.recipeapplication.R

fun recipeListForBreakfast(): List<RecipeWithInstructionAndIngredients> {
    return listOf(
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Avocado Toast with Poached Eggs",
                code = "B01",
                image = R.drawable.avocado_toast_with_poached_eggs,
                categoryType = CategoryTypes.BREAKFAST
            ),
            instructions = listOf(
                Instruction(step = 0, instruction = "Toast the bread slices until golden brown."),
                Instruction(step = 1, instruction = "While the bread is toasting, slice the avocado and mash it with a fork in a bowl. Season with salt and pepper."),
                Instruction(step = 2, instruction = "Poach the eggs in boiling water for about 3-4 minutes until the whites are set but the yolks are still runny."),
                Instruction(step = 3, instruction = "Spread the mashed avocado on each toast and top with a poached egg."),
                Instruction(step = 4, instruction = "Add optional toppings if desired and serve immediately.")
            ),
            ingredients = listOf(
                Ingredient(amount = 2.0, description = "slices of whole-grain bread"),
                Ingredient(amount = 1.0, description = "ripe avocado"),
                Ingredient(amount = 2.0, description = "large eggs"),
                Ingredient(amount = 1.0, description = "Salt and pepper to taste"),
                Ingredient(amount = 1.0, description = "sliced tomatoes, microgreens, hot sauce")
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Greek Yogurt Parfait",
                code = "B02",
                image = R.drawable.greek_yogurt_parfait,
                categoryType = CategoryTypes.BREAKFAST
            ),
            instructions = listOf(
                Instruction(step = 0, instruction = "In a glass or bowl, layer Greek yogurt, granola, and fresh berries."),
                Instruction(step = 1, instruction = "Repeat the layers until all the ingredients are used."),
                Instruction(step = 2, instruction = "Drizzle honey or maple syrup on top for added sweetness."),
                Instruction(step = 3, instruction = "Serve immediately or refrigerate for a few hours to let the flavors meld.")
            ),
            ingredients = listOf(
                Ingredient(amount = 1.0, description = "cup Greek yogurt"),
                Ingredient(amount = 0.5, description = "cup granola"),
                Ingredient(
                    amount = 1.0,
                    description = "cup mixed fresh berries (strawberries, blueberries, raspberries)"
                ),
                Ingredient(description = "Honey or maple syrup for drizzling", required = true)
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Veggie Omelette",
                code = "B03",
                image = R.drawable.veggie_omelette,
                categoryType = CategoryTypes.BREAKFAST
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "In a bowl, whisk the eggs with salt and pepper."),
                Instruction(step = 2, instruction = "Heat a non-stick skillet over medium heat and add a drizzle of oil or butter."),
                Instruction(step = 3, instruction = "Add the chopped veggies to the skillet and sauté for a few minutes until tender."),
                Instruction(step = 4, instruction = "Pour the whisked eggs over the veggies and cook until the edges set."),
                Instruction(step = 5, instruction = "Sprinkle shredded cheese on one half of the omelette and fold the other half over it."),
                Instruction(step = 6, instruction = "Cook for another minute until the cheese melts."),
                Instruction(step = 7, instruction = "Slide the omelette onto a plate, garnish with fresh herbs, and serve hot.")
            ),
            ingredients = listOf(
                Ingredient(amount = 3.0, description = "large eggs"),
                Ingredient(amount = 0.25, description = "cup chopped bell peppers (any color)"),
                Ingredient(amount = 0.25, description = "cup chopped onions"),
                Ingredient(amount = 0.25, description = "cup chopped tomatoes"),
                Ingredient(amount = 0.25, description = "cup shredded cheddar cheese"),
                Ingredient(description = "Salt and pepper to taste", required = true),
                Ingredient(
                    description = "Fresh herbs (such as chives or parsley) for garnish",
                    required = true
                )
            )
        )
    )
}

fun recipeListForLunch(): List<RecipeWithInstructionAndIngredients> {
    return listOf(
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Grilled Chicken Caesar Salad",
                code = "L01",
                image = R.drawable.grilled_chicken_caesar_salad,
                categoryType = CategoryTypes.LUNCH
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Season the chicken breasts with salt and pepper."),
                Instruction(step = 2, instruction = "Grill the chicken on medium heat for about 6-7 minutes per side until fully cooked."),
                Instruction(step = 3, instruction = "Let the chicken rest for a few minutes, then slice it into strips."),
                Instruction(step = 4, instruction = "In a large bowl, combine chopped romaine lettuce, Caesar dressing, and croutons. Toss to coat the lettuce evenly."),
                Instruction(step = 5, instruction = "Top the salad with the grilled chicken strips and sprinkle with grated Parmesan cheese."),
                Instruction(step = 6, instruction = "Serve immediately for a delicious and filling lunch.")
            ),
            ingredients = listOf(
                Ingredient(amount = 2.0, description = "boneless, skinless chicken breasts"),
                Ingredient(description = "Romaine lettuce, chopped", required = true),
                Ingredient(description = "Caesar dressing", required = true),
                Ingredient(description = "Croutons", required = true),
                Ingredient(description = "Grated Parmesan cheese", required = true),
                Ingredient(description = "Salt and pepper to taste", required = false)
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Caprese Sandwich",
                code = "L02",
                image = R.drawable.caprese_sandwich,
                categoryType = CategoryTypes.LUNCH
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Cut the baguette or ciabatta bread into sandwich-sized portions."),
                Instruction(step = 2, instruction = "Slice the tomatoes and mozzarella cheese into ¼-inch thick slices."),
                Instruction(step = 3, instruction = "Layer the tomato and mozzarella slices on one half of the bread."),
                Instruction(step = 4, instruction = "Drizzle balsamic glaze over the tomatoes and mozzarella."),
                Instruction(step = 5, instruction = "Top with fresh basil leaves and season with salt and pepper."),
                Instruction(step = 6, instruction = "Close the sandwich with the other half of the bread."),
                Instruction(step = 7, instruction = "Serve the Caprese sandwich with a side salad or chips.")
            ),
            ingredients = listOf(
                Ingredient(description = "Baguette or ciabatta bread", required = true),
                Ingredient(description = "Tomatoes, sliced", required = true),
                Ingredient(description = "Fresh mozzarella cheese, sliced", required = true),
                Ingredient(description = "Balsamic glaze", required = true),
                Ingredient(description = "Fresh basil leaves", required = true),
                Ingredient(description = "Salt and pepper to taste", required = false)
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Veggie Wrap with Hummus",
                code = "L03",
                image = R.drawable.veggie_omelette,
                categoryType = CategoryTypes.LUNCH
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Lay the tortilla or wrap flat on a clean surface."),
                Instruction(step = 2, instruction = "Spread a generous amount of hummus over the entire surface of the wrap."),
                Instruction(step = 3, instruction = "Layer the sliced avocado, cucumbers, shredded carrots, bell peppers, and baby spinach on top of the hummus."),
                Instruction(step = 4, instruction = "Roll the wrap tightly, folding in the sides as you go to keep the filling secure."),
                Instruction(step = 5, instruction = "Cut the wrap in half and serve as a tasty and nutritious lunch option.")
            ),
            ingredients = listOf(
                Ingredient(description = "Large whole-grain tortilla or wrap", required = true),
                Ingredient(description = "Hummus", required = true),
                Ingredient(description = "Sliced avocado", required = true),
                Ingredient(description = "Sliced cucumbers", required = true),
                Ingredient(description = "Shredded carrots", required = true),
                Ingredient(description = "Sliced bell peppers", required = true),
                Ingredient(description = "Baby spinach or mixed greens", required = true)
            )
        )
    )
}

fun recipeListForSupper(): List<RecipeWithInstructionAndIngredients> {
    return listOf(
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Spaghetti Carbonara",
                code = "S01",
                image = R.drawable.spaghetti_carbonara,
                categoryType = CategoryTypes.SUPPER
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Cook the spaghetti in a large pot of boiling salted water until al dente. Reserve some pasta water before draining."),
                Instruction(step = 2, instruction = "In a separate bowl, whisk together the eggs, grated Pecorino Romano cheese, and a generous amount of freshly ground black pepper."),
                Instruction(step = 3, instruction = "In a skillet, cook the diced pancetta or guanciale over medium heat until crispy. Add minced garlic and cook for another minute."),
                Instruction(step = 4, instruction = "Add the drained spaghetti to the skillet with the pancetta. Toss to combine and remove the skillet from the heat."),
                Instruction(step = 5, instruction = "Quickly pour the egg and cheese mixture over the hot spaghetti while continuously tossing to coat the pasta evenly. The heat from the pasta will cook the eggs, creating a creamy sauce."),
                Instruction(step = 6, instruction = "If the sauce seems too thick, add some of the reserved pasta water to achieve the desired consistency."),
                Instruction(step = 7, instruction = "Serve immediately with additional grated Pecorino Romano cheese and chopped parsley for garnish, if desired.")
            ),
            ingredients = listOf(
                Ingredient(amount = 8.0, description = "ounces (225g) spaghetti"),
                Ingredient(amount = 2.0, description = "large eggs"),
                Ingredient(amount = 1.0, description = "cup grated Pecorino Romano cheese"),
                Ingredient(amount = 4.0, description = "ounces (115g) pancetta or guanciale, diced"),
                Ingredient(amount = 2.0, description = "cloves garlic, minced"),
                Ingredient(description = "Freshly ground black pepper", required = true),
                Ingredient(description = "Fresh parsley, chopped, for garnish (optional)", required = true)
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Lemon Herb Roasted Chicken",
                code = "S02",
                image = R.drawable.lemon_herb_roasted_chicken,
                categoryType = CategoryTypes.SUPPER
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Preheat the oven to 425°F (220°C)."),
                Instruction(step = 2, instruction = "Rinse the chicken inside and out, then pat it dry with paper towels."),
                Instruction(step = 3, instruction = "Squeeze the lemon halves over the chicken, then stuff them inside the cavity along with any leftover lemon pieces."),
                Instruction(step = 4, instruction = "In a small bowl, mix minced garlic, olive oil, fresh thyme, rosemary, and sage leaves."),
                Instruction(step = 5, instruction = "Rub the herb mixture all over the chicken, ensuring it is evenly coated."),
                Instruction(step = 6, instruction = "Season the chicken with salt and pepper to taste."),
                Instruction(step = 7, instruction = "Place the seasoned chicken in a roasting pan or oven-safe skillet."),
                Instruction(step = 8, instruction = "Pour chicken broth into the bottom of the pan."),
                Instruction(step = 9, instruction = "Roast the chicken in the preheated oven for about 1 hour and 30 minutes, or until the internal temperature reaches 165°F (74°C) and the skin is golden and crispy."),
                Instruction(step = 10, instruction = "Let the roasted chicken rest for a few minutes before carving and serving.")
            ),
            ingredients = listOf(
                Ingredient(amount = 1.0, description = "whole chicken (about 4 pounds)"),
                Ingredient(amount = 1.0, description = "lemon, halved"),
                Ingredient(amount = 4.0, description = "cloves garlic, minced"),
                Ingredient(amount = 2.0, description = "tablespoons olive oil"),
                Ingredient(amount = 1.0, description = "tablespoon fresh thyme leaves"),
                Ingredient(amount = 1.0, description = "tablespoon fresh rosemary leaves"),
                Ingredient(amount = 1.0, description = "tablespoon fresh sage leaves"),
                Ingredient(description = "Salt and pepper to taste", required = true),
                Ingredient(amount = 1.0, description = "cup chicken broth")
            )
        ),
        RecipeWithInstructionAndIngredients(
            recipe = Recipe(
                name = "Vegetable Stir-Fry with Tofu",
                code = "S03",
                image = R.drawable.vegetable_stir_fry_with_tofu,
                categoryType = CategoryTypes.SUPPER
            ),
            instructions = listOf(
                Instruction(step = 1, instruction = "Press the tofu to remove excess moisture, then cut it into cubes."),
                Instruction(step = 2, instruction = "In a small bowl, mix soy sauce, hoisin sauce, and sesame oil to make the sauce."),
                Instruction(step = 3, instruction = "Heat vegetable oil in a large skillet or wok over medium-high heat."),
                Instruction(step = 4, instruction = "Add cubed tofu to the skillet and stir-fry until it becomes lightly browned and crispy on all sides. Remove tofu from the skillet and set aside."),
                Instruction(step = 5, instruction = "In the same skillet, add sliced bell peppers, broccoli florets, sliced carrots, and snap peas. Stir-fry the vegetables until they are tender-crisp."),
                Instruction(step = 6, instruction = "Add the tofu back to the skillet with the stir-fried vegetables."),
                Instruction(step = 7, instruction = "Pour the sauce over the tofu and vegetables. Stir to coat everything evenly and cook for a few more minutes until heated through."),
                Instruction(step = 8, instruction = "Serve the vegetable stir-fry with tofu over steamed rice or noodles."),
                Instruction(step = 9, instruction = "Garnish with chopped green onions and sesame seeds, if desired.")
            ),
            ingredients = listOf(
                Ingredient(amount = 1.0, description = "block of firm tofu"),
                Ingredient(amount = 3.0, description = "tablespoons soy sauce"),
                Ingredient(amount = 2.0, description = "tablespoons hoisin sauce"),
                Ingredient(amount = 1.0, description = "teaspoon sesame oil"),
                Ingredient(amount = 2.0, description = "tablespoons vegetable oil"),
                Ingredient(amount = 1.0, description = "bell peppers, sliced"),
                Ingredient(amount = 1.0, description = "cup broccoli florets"),
                Ingredient(amount = 2.0, description = "carrots, sliced"),
                Ingredient(amount = 1.0, description = "cup snap peas"),
                Ingredient(description = "Steamed rice or noodles for serving", required = true),
                Ingredient(description = "Chopped green onions and sesame seeds for garnish (optional)", required = true)
            )
        )
    )
}

