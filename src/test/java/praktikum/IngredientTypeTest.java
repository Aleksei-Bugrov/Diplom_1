package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    //Сначала добавил эти 2 теста, для быстрой проверки подходят, но в дальнейшем, при расширении ассортимента, параметризованный тест, будет лучше.
    /*@Test
    public void IngredientTypeSauceTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "Тестовый соус", 123);
        assertEquals("В соус не передалось имя", ingredient.getName(), "Тестовый соус");
        assertEquals("В соус не передалась цена", ingredient.getPrice(), 123, 0);
        assertEquals("Не совпадает тип ингредиента", ingredient.getType(), SAUCE);
    }

    @Test
    public void IngredientTypeFillingTest() {
        Ingredient ingredient = new Ingredient(FILLING, "Тестовая начинка", 123);
        assertEquals("В начинку не передалось имя", ingredient.getName(), "Тестовая начинка");
        assertEquals("В начинку не передалась цена", ingredient.getPrice(), 123, 0);
        assertEquals("Не совпадает тип ингредиента", ingredient.getType(), FILLING);
    }
*/
    @Test
    public void thtfd() {
        int expected = IngredientType.values().length;
        assertEquals("Не совпадает кол-во типов ингредиентов", expected, 2);
    }
}