package top.kangyong.study01.design.pattern.builder;

/**
 * 套餐构建
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class MealBuilder {

    /**
     * 蔬菜套餐
     *
     * @return {@link Meal}
     * @author Kang Yong
     * @date 2022/6/24
     */
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     * 鸡肉套餐
     *
     * @return {@link Meal}
     * @author Kang Yong
     * @date 2022/6/24
     */
    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
