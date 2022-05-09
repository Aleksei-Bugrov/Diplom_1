package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();

    @Mock
    Bun bun;
    Ingredient firstIngredient = mock(Ingredient.class);
    Ingredient secondIngredient = mock(Ingredient.class);

    @Test
    public void getBunPrice() {
        burger.setBuns(bun);

        Mockito.when(bun.getPrice()).thenReturn(150.0f);
        float expected = bun.getPrice();

        assertEquals("Посчитана неверная цена булочки", expected, 150.0f, 0);
    }

    @Test
    public void getBunName() {
        burger.setBuns(bun);

        Mockito.when(bun.getName()).thenReturn("Черная булочка");
        String expected = bun.getName();

        assertEquals("Возвращается неправильное имя булочки", expected, "Черная булочка");
    }

    @Test
    public void getBurgerPrice() {
        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);

        Mockito.when(bun.getPrice()).thenReturn(150.0f);
        Mockito.when(firstIngredient.getPrice()).thenReturn(150.0f);
        float expected = burger.getPrice();

        assertEquals("Посчитана неверная цена бургера", expected, 450, 0);
    }

    @Test
    public void RemoveIngredientBurger() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.removeIngredient(1);

        assertEquals("Ингредиент не удалился", burger.ingredients.size(), 1);
    }

    @Test
    public void moveIngredientBurger() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(0, 1);
        String expected = burger.ingredients.get(0).toString();

        assertEquals("Ингредиент не перемешался", expected, "secondIngredient");
    }

    @Test
    public void getBurgerReceipt() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(200.0f);
        Mockito.when(bun.getName()).thenReturn("Обычная булка");

        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("Чили");
        Mockito.when(firstIngredient.getPrice()).thenReturn(50.0f);

        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Лук");
        Mockito.when(secondIngredient.getPrice()).thenReturn(25.0f);

        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);

        String expected = burger.getReceipt();
        String actual = (String.format("(==== Обычная булка ====)%n") + String.format("= sauce Чили =%n") + String.format("= filling Лук =%n") + String.format("(==== Обычная булка ====)%n") + String.format("%nPrice: 475,000000%n"));
        assertEquals("Выводится неправильный чек", expected, actual);

    }

}