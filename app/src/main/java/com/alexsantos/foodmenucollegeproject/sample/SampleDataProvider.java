package com.alexsantos.foodmenucollegeproject.sample;

import com.alexsantos.foodmenucollegeproject.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24/02/2017.
 */

public class SampleDataProvider {


    public static List<Product> dataItem;
    public static Map<String,Product> dataItemMap;

    static{

        dataItem = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addProduct(new Product(null, "Caesar Salad", "Salads",
                "Our quinoa salad is served with quinoa, tomatoes, cucumber, scallions, and smoked salmon. Served with your choice of dressing.",
                1, 12.10, "caesar_salad.jpg"));

        addProduct(new Product(null, "Tea leaf Salad", "Salads",
                "The chef’s salad has cucumber, tomatoes, red onions, mushrooms, hard-boiled eggs, cheese, and hot grilled chicken on a bed of romaine lettuce. Served with croutons and your choice of dressing.",
                2, 9.20, "tea_leaf_salad.jpg"));

        addProduct(new Product(null, "Classic Spicy Caesar ", "Salads",
                "Our house salad is made with romaine lettuce and spinach, topped with tomatoes, cucumbers, red onions and carrots. Served with a dressing of your choice.",
                3, 7, "fresh_caesar_salad.jpg"));

        addProduct(new  Product(null, "Spicy Papaya Salad", "Salads",
                "Choose from our fresh local, organically grown ingredients to make a custom salad.",
                4, 10, "spicy_papaya_salad.jpg"));

        addProduct(new  Product(null, "Mini Cheeseburgers", "Starter",
                "These mini cheeseburgers are served on a fresh baked pretzel bun with lettuce, tomato, avocado, and your choice of cheese.",
                1, 8, "mini_cheeseburgers.jpg"));

        addProduct(new Product(null, "Panko Stuffed Mushrooms", "Starter",
                "Large mushroom caps are filled a savory cream cheese, bacon and panko breadcrumb stuffing, topped with cheddar cheese.",
                2, 7, "stuffed_mushrooms.jpg"));

        addProduct(new Product(null, "French Onion Soup", "Starter",
                "Caramelized onions slow cooked in a savory broth, topped with sourdough and a provolone cheese blend. Served with sourdough bread.",
                3, 7, "french_onion_soup.jpg"));

        addProduct(new Product(null, "Artichokes with Garlic Aeoli", "Starter",
                "Our artichokes are brushed with an olive oil and rosemary blend and then broiled to perfection. Served with a side of creamy garlic aioli.",
                4, 9, "artichokes.jpg"));

        addProduct(new Product(null, "Parmesan Deviled Eggs", "Starter",
                "SOME SAY OUR EGGS ARE DEVILISHLY GOOD. I HAVE TO AGREE.\n" +
                        "These delectable little bites are made with organic eggs, fresh Parmesan, and chopped pine nuts.\"",
                5, 8, "deviled_eggs.jpg"));

        addProduct(new Product(null, "Classic Burger", "Entrees",
                "Our classic burger is made with 100% pure angus beef, served with lettuce, tomatoes, onions, pickles, and cheese of your choice. Veggie burger available upon request. Served with French fries, fresh fruit, or a side salad.",
                1, 10, "classic_burger.jpg"));

        addProduct(new Product(null, "Tomato Bruschetta Tortellini", "Entrees",
                "This classic cheese tortellini is cooked in a sundried tomato sauce. Served with bruschetta topped with a tomato and basil marinara.",
                2, 14, "tortellini.jpg"));

        addProduct(new Product(null, "Handcrafted Pizza", "Entrees",
                "Our thin crust pizzas are made fresh daily and topped with your choices of fresh meats, veggies, cheese, and sauce.  Price includes two toppings. Add $1 for each additional topping.",
                3, 10, "pizza.jpg"));

        addProduct(new Product(null, "Barbecued Tofu Skewers", "Entrees",
                "Our barbecued skewers include tofu, cherry tomatoes, bell peppers, and zucchini marinated in a ginger sesame sauce and charbroiled. Served with steamed rice.",
                4, 10, "tofu_skewers.jpg"));

        addProduct(new Product(null, "Fiesta Family Platter", "Entrees",
                "This platter is perfect for sharing! Enjoy our spicy buffalo wings, traditional nachos, and cheese quesadillas served with freshly made guacamole dip.",
                5, 16, "fiesta_platter.jpg"));

        addProduct(new Product(null, "Napoleon_Strawberry", "Desserts",
                "Elegantly crafted creamy vanilla custard with a caramelized crunchy layer on top. Served with seasonal fruit.",
                1, 9, "napoleon_strawberry.jpg"));

        addProduct(new Product(null, "Red and Green Jelly", "Desserts",
                "Our New York Style Cheesecake is rich, smooth, and creamy. Available in various flavors, and with seasonal fruit toppings.",
                2, 9, "red_and_green_jelly.jpg"));

        addProduct(new Product(null, "Green tea dessert ", "Desserts",
                "A warm chocolate chip brownie served with chocolate or vanilla ice cream and rich chocolate sauce.",
                3, 6, "green_tea_dessert.jpg"));

        addProduct(new Product(null, "Swiss roll", "Desserts",
                "Made with local granny smith apples to bring you the freshest classic apple pie available.",
                4, 5, "swiss_roll.jpg"));

        addProduct(new Product(null, "Ice Cream", "Desserts",
                "Raspberries, blueberries, and strawberries on top of a creamy filling served in a crispy tart.",
                5, 7, "ice_cream.jpg"));

        addProduct(new Product(null, "Tropical Blue Smoothie", "Drinks",
                "This blueberry mint-based smoothie is refreshing and perfect for any celebration.",
                1, 6, "smoothie.jpg"));

        addProduct(new Product(null, "Pomegranate Iced Tea", "Drinks",
                "Our unique blend of pomegranate juice, black Rubio, and mint tea creates this light fusion of flavors.  ",
                2, 4, "iced_tea.jpg"));

        addProduct(new Product(null, "Café Latte", "Drinks",
                "Our house blend of espresso and foamed milk. Can be served with flavored syrups and over ice.  Non-dairy substitutions available upon request.",
                3, 6, "cafe_latte.jpg"));

    }



    public static void addProduct(Product product){

        dataItem.add(product);
        dataItemMap.put(product.getProductId(),product);
    }
}
