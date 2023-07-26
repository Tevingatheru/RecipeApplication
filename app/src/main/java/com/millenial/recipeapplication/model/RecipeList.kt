package com.millenial.recipeapplication.model

import com.millenial.recipeapplication.R

fun recipeListForBreakfast(): List<Recipe> {
    return listOf(
        Recipe("Avocado Toast with Poached Eggs", "B01", R.drawable.avocado_toast_with_poached_eggs, listOf(
            Instruction(0, "Toast the bread slices until golden brown."),
            Instruction(1, "While the bread is toasting, slice the avocado and mash it with a fork in a bowl. Season with salt and pepper."),
            Instruction(2, "Poach the eggs in boiling water for about 3-4 minutes until the whites are set but the yolks are still runny."),
            Instruction(3,"Spread the mashed avocado on each toast and top with a poached egg."),
            Instruction(4, "Add optional toppings if desired and serve immediately.")
        ), listOf(
            Ingredient(2.0, "slices of whole-grain bread"),
            Ingredient(1.0, "ripe avocado"),
            Ingredient(2.0, "large eggs"),
            Ingredient(1.0, "Salt and pepper to taste"),
            Ingredient(1.0, "sliced tomatoes, microgreens, hot sauce")
        ), CategoryTypes.BREAKFAST
            ),
        Recipe("Greek Yogurt Parfait", "B02", R.drawable.greek_yogurt_parfait, listOf(
            Instruction(0, "In a glass or bowl, layer Greek yogurt, granola, and fresh berries."),
            Instruction(1, "Repeat the layers until all the ingredients are used."),
            Instruction(2, "Drizzle honey or maple syrup on top for added sweetness."),
            Instruction(3, "Serve immediately or refrigerate for a few hours to let the flavors meld.")
        ),  listOf(
            Ingredient(1.0, "cup Greek yogurt"),
            Ingredient(0.5, "cup granola"),
            Ingredient(1.0, "cup mixed fresh berries (strawberries, blueberries, raspberries)"),
            Ingredient( "Honey or maple syrup for drizzling", true)
        ), CategoryTypes.BREAKFAST),
        Recipe("Veggie Omelette", "B03", R.drawable.veggie_omelette, listOf(
            Instruction(1, "In a bowl, whisk the eggs with salt and pepper."),
            Instruction(2, "Heat a non-stick skillet over medium heat and add a drizzle of oil or butter."),
            Instruction(3, "Add the chopped veggies to the skillet and sauté for a few minutes until tender."),
            Instruction(4, "Pour the whisked eggs over the veggies and cook until the edges set."),
            Instruction(5, "Sprinkle shredded cheese on one half of the omelette and fold the other half over it."),
            Instruction(6, "Cook for another minute until the cheese melts."),
            Instruction(7, "Slide the omelette onto a plate, garnish with fresh herbs, and serve hot.")
        ), listOf(
            Ingredient(3.0, "large eggs"),
            Ingredient(0.25, "cup chopped bell peppers (any color)"),
            Ingredient(0.25, "cup chopped onions"),
            Ingredient(0.25, "cup chopped tomatoes"),
            Ingredient(0.25, "cup shredded cheddar cheese"),
            Ingredient("Salt and pepper to taste", true),
            Ingredient("Fresh herbs (such as chives or parsley) for garnish", true)
        ), CategoryTypes.BREAKFAST),
    )
}

fun recipeListForLunch(): List<Recipe> {
    return listOf(
        Recipe("Grilled Chicken Caesar Salad", "L01", R.drawable.grilled_chicken_caesar_salad, listOf(
            Instruction(1, "Season the chicken breasts with salt and pepper."),
            Instruction(2, "Grill the chicken on medium heat for about 6-7 minutes per side until fully cooked."),
            Instruction(3, "Let the chicken rest for a few minutes, then slice it into strips."),
            Instruction(4, "In a large bowl, combine chopped romaine lettuce, Caesar dressing, and croutons. Toss to coat the lettuce evenly."),
            Instruction(5, "Top the salad with the grilled chicken strips and sprinkle with grated Parmesan cheese."),
            Instruction(6, "Serve immediately for a delicious and filling lunch.")
        ), listOf(
            Ingredient(2.0, "boneless, skinless chicken breasts"),
            Ingredient("Romaine lettuce, chopped", true),
            Ingredient("Caesar dressing", true),
            Ingredient("Croutons", true),
            Ingredient("Grated Parmesan cheese", true),
            Ingredient("Salt and pepper to taste", false)
        ), CategoryTypes.LUNCH),
        Recipe("Caprese Sandwich", "L02", R.drawable.caprese_sandwich, listOf(
            Instruction(1, "Cut the baguette or ciabatta bread into sandwich-sized portions."),
            Instruction(2, "Slice the tomatoes and mozzarella cheese into ¼-inch thick slices."),
            Instruction(3, "Layer the tomato and mozzarella slices on one half of the bread."),
            Instruction(4, "Drizzle balsamic glaze over the tomatoes and mozzarella."),
            Instruction(5, "Top with fresh basil leaves and season with salt and pepper."),
            Instruction(6, "Close the sandwich with the other half of the bread."),
            Instruction(7, "Serve the Caprese sandwich with a side salad or chips.")
        ), listOf(
            Ingredient("Baguette or ciabatta bread", true),
            Ingredient("Tomatoes, sliced", true),
            Ingredient("Fresh mozzarella cheese, sliced", true),
            Ingredient("Balsamic glaze", true),
            Ingredient("Fresh basil leaves", true),
            Ingredient("Salt and pepper to taste", false)
        ), CategoryTypes.LUNCH),
        Recipe("Veggie Wrap with Hummus", "L03", R.drawable.veggie_omelette, listOf(
            Instruction(1, "Lay the tortilla or wrap flat on a clean surface."),
            Instruction(2, "Spread a generous amount of hummus over the entire surface of the wrap."),
            Instruction(3, "Layer the sliced avocado, cucumbers, shredded carrots, bell peppers, and baby spinach on top of the hummus."),
            Instruction(4, "Roll the wrap tightly, folding in the sides as you go to keep the filling secure."),
            Instruction(5, "Cut the wrap in half and serve as a tasty and nutritious lunch option.")
        ), listOf(
            Ingredient("Large whole-grain tortilla or wrap", true),
            Ingredient("Hummus", true),
            Ingredient("Sliced avocado", true),
            Ingredient("Sliced cucumbers", true),
            Ingredient("Shredded carrots", true),
            Ingredient("Sliced bell peppers", true),
            Ingredient("Baby spinach or mixed greens", true)
        ), CategoryTypes.LUNCH)
    )
}

fun recipeListForSupper(): List<Recipe> {
    return listOf(
        Recipe("Spaghetti Carbonara", "S01", R.drawable.spaghetti_carbonara, listOf(
            Instruction(1, "Cook the spaghetti in a large pot of boiling salted water until al dente. Reserve some pasta water before draining."),
            Instruction(2, "In a separate bowl, whisk together the eggs, grated Pecorino Romano cheese, and a generous amount of freshly ground black pepper."),
            Instruction(3, "In a skillet, cook the diced pancetta or guanciale over medium heat until crispy. Add minced garlic and cook for another minute."),
            Instruction(4, "Add the drained spaghetti to the skillet with the pancetta. Toss to combine and remove the skillet from the heat."),
            Instruction(5, "Quickly pour the egg and cheese mixture over the hot spaghetti while continuously tossing to coat the pasta evenly. The heat from the pasta will cook the eggs, creating a creamy sauce."),
            Instruction(6, "If the sauce seems too thick, add some of the reserved pasta water to achieve the desired consistency."),
            Instruction(7, "Serve immediately with additional grated Pecorino Romano cheese and chopped parsley for garnish, if desired.")
        ), listOf(
            Ingredient(8.0, "ounces (225g) spaghetti"),
            Ingredient(2.0, "large eggs"),
            Ingredient(1.0, "cup grated Pecorino Romano cheese"),
            Ingredient(4.0, "ounces (115g) pancetta or guanciale, diced"),
            Ingredient(2.0, "cloves garlic, minced"),
            Ingredient("Freshly ground black pepper", true),
            Ingredient("Fresh parsley, chopped, for garnish (optional)", true)
        ), CategoryTypes.SUPPER),
        Recipe("Lemon Herb Roasted Chicken", "S02", R.drawable.lemon_herb_roasted_chicken, listOf(
            Instruction(1, "Preheat the oven to 425°F (220°C)."),
            Instruction(2, "Rinse the chicken inside and out, then pat it dry with paper towels."),
            Instruction(3, "Squeeze the lemon halves over the chicken, then stuff them inside the cavity along with any leftover lemon pieces."),
            Instruction(4, "In a small bowl, mix minced garlic, olive oil, fresh thyme, rosemary, and sage leaves."),
            Instruction(5, "Rub the herb mixture all over the chicken, ensuring it is evenly coated."),
            Instruction(6, "Season the chicken with salt and pepper to taste."),
            Instruction(7, "Place the seasoned chicken in a roasting pan or oven-safe skillet."),
            Instruction(8, "Pour chicken broth into the bottom of the pan."),
            Instruction(9, "Roast the chicken in the preheated oven for about 1 hour and 30 minutes, or until the internal temperature reaches 165°F (74°C) and the skin is golden and crispy."),
            Instruction(10, "Let the roasted chicken rest for a few minutes before carving and serving.")
        ), listOf(
            Ingredient(1.0, "whole chicken (about 4 pounds)"),
            Ingredient(1.0, "lemon, halved"),
            Ingredient(4.0, "cloves garlic, minced"),
            Ingredient(2.0, "tablespoons olive oil"),
            Ingredient(1.0, "tablespoon fresh thyme leaves"),
            Ingredient(1.0, "tablespoon fresh rosemary leaves"),
            Ingredient(1.0, "tablespoon fresh sage leaves"),
            Ingredient("Salt and pepper to taste", true),
            Ingredient(1.0, "cup chicken broth")
        ) , CategoryTypes.SUPPER),
        Recipe("Vegetable Stir-Fry with Tofu", "S03", R.drawable.vegetable_stir_fry_with_tofu, listOf(
            Instruction(1, "Press the tofu to remove excess moisture, then cut it into cubes."),
            Instruction(2, "In a small bowl, mix soy sauce, hoisin sauce, and sesame oil to make the sauce."),
            Instruction(3, "Heat vegetable oil in a large skillet or wok over medium-high heat."),
            Instruction(4, "Add cubed tofu to the skillet and stir-fry until it becomes lightly browned and crispy on all sides. Remove tofu from the skillet and set aside."),
            Instruction(5, "In the same skillet, add sliced bell peppers, broccoli florets, sliced carrots, and snap peas. Stir-fry the vegetables until they are tender-crisp."),
            Instruction(6, "Add the tofu back to the skillet with the stir-fried vegetables."),
            Instruction(7, "Pour the sauce over the tofu and vegetables. Stir to coat everything evenly and cook for a few more minutes until heated through."),
            Instruction(8, "Serve the vegetable stir-fry with tofu over steamed rice or noodles."),
            Instruction(9, "Garnish with chopped green onions and sesame seeds, if desired.")
        ), listOf(
            Ingredient(1.0, "block of firm tofu"),
            Ingredient(3.0, "tablespoons soy sauce"),
            Ingredient(2.0, "tablespoons hoisin sauce"),
            Ingredient(1.0, "teaspoon sesame oil"),
            Ingredient(2.0, "tablespoons vegetable oil"),
            Ingredient(1.0, "bell peppers, sliced"),
            Ingredient(1.0, "cup broccoli florets"),
            Ingredient(2.0, "carrots, sliced"),
            Ingredient(1.0, "cup snap peas"),
            Ingredient("Steamed rice or noodles for serving", true),
            Ingredient("Chopped green onions and sesame seeds for garnish (optional)", true)
        ) , CategoryTypes.SUPPER)
    )
}

