package com.myapp.recipeapp.config;

import com.myapp.recipeapp.model.*;
import com.myapp.recipeapp.repository.CategoryRepository;
import com.myapp.recipeapp.repository.RecipeRepository;
import com.myapp.recipeapp.repository.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoadData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public LoadData(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository, RecipeRepository repository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category category=new Category("American",null);
        Category category1=new Category("Italian",null);
        Category category2=new Category("Turk",null);
        Category category3=new Category("Chinese",null);
        List<Category> myList=List.of(category,category1,category2,category3);
        UnitOfMeasure unitOfMeasure=new UnitOfMeasure("Gram");
        UnitOfMeasure unitOfMeasure1=new UnitOfMeasure("Çay Kaşığı");
        UnitOfMeasure unitOfMeasure2=new UnitOfMeasure("Yemek Kaşığı");
        UnitOfMeasure unitOfMeasure3=new UnitOfMeasure("Kepçe");
        UnitOfMeasure unitOfMeasure4=new UnitOfMeasure("Su Bardağı");
        categoryRepository.saveAll(myList);
        unitOfMeasureRepository.saveAll(List.of(unitOfMeasure,unitOfMeasure1,unitOfMeasure2,unitOfMeasure3,unitOfMeasure4));
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        //Başlangıçta 2 elemanlı bir ArrayList yaratıyoruz. Buraya oluşturduğumuz yemek tariflerini ekleyeceğiz.
        List<Recipe> recipes=new ArrayList<>(2);
        //get UOMs -- ölçü birimlerini getiriyoruz.
        Optional<UnitOfMeasure> gramUomOptional=unitOfMeasureRepository.findByDescription("Gram");
        if(!gramUomOptional.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }

        Optional<UnitOfMeasure> cayKasigiUom = unitOfMeasureRepository.findByDescription("Çay Kaşığı");
        if(!cayKasigiUom.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<UnitOfMeasure> yemekKasigiUom = unitOfMeasureRepository.findByDescription("Yemek Kaşığı");
        if(!yemekKasigiUom.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<UnitOfMeasure> kepceUom = unitOfMeasureRepository.findByDescription("Kepçe");

        if(!kepceUom.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<UnitOfMeasure> suBardagiUom = unitOfMeasureRepository.findByDescription("Su Bardağı");

        if(!suBardagiUom.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }

        UnitOfMeasure gram=gramUomOptional.get();
        UnitOfMeasure cayKasigi= cayKasigiUom.get();
        UnitOfMeasure yemekKasigi= yemekKasigiUom.get();
        UnitOfMeasure kepce= kepceUom.get();
        UnitOfMeasure suBardagi= suBardagiUom.get();

        //get Categories -- kategorileri getiriyoruz..
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");

        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<Category> turkCategoryOptional = categoryRepository.findByDescription("Turk");

        if(!turkCategoryOptional.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }
        Optional<Category> chineseCategoryOptional = categoryRepository.findByDescription("Chinese");

        if(!chineseCategoryOptional.isPresent()){
            throw new RuntimeException("Beklenen Ölçü birimi bulunamamıştır.");
        }

        Category americanCategory= americanCategoryOptional.get();
        Category italianCategory= italianCategoryOptional.get();
        Category turkCategory= turkCategoryOptional.get();
        Category chineseCategory= chineseCategoryOptional.get();

        //Yeni bir tarif nesnesi yaratığ gerekli bilgileri set ediyoruz.
        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd");
        //Notlar
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes( "For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");
        //tarife notu ekliyoruz
        //Tarif sınıfımız içinde bulunan setNotes metodumuz hangi notun hangi tarife ait olduğunu otomatik olarak eklediği için,
        //guacNotes nesnesine hangi tarife ait olduğunu belirten guacNotes.setRecipe("Recipe") metodunu kullanmamıza gerek yok.
        //guacNotes.setRecipe(guacRecipe);
        guacRecipe.setNotes(guacNotes);

        //Yemeğin malzemeleri
        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), gram));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), cayKasigi));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), yemekKasigi));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), kepce));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), gram));
        guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), yemekKasigi));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), suBardagi));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), gram));

        //Kategorileri ekliyoruz. Yemeğin ait olduğu kategorileri
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(chineseCategory);
        //Kalan verileri de (properties) ekliyoruz.
        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");
        //en son tariflere bu yemek tarifimizi ekliyoruz.
        recipes.add(guacRecipe);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        //tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), yemekKasigi));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), suBardagi));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), suBardagi));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), suBardagi));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), cayKasigi));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), gram));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), kepce));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), yemekKasigi));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), yemekKasigi));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), yemekKasigi));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), gram));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), suBardagi));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), gram));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), gram));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), yemekKasigi));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), cayKasigi));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), gram));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cayKasigi));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), gram));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(turkCategory);

        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setServings(4);
        tacosRecipe.setSource("Simply Recipes");

        recipes.add(tacosRecipe);
        return recipes;

    }
}
