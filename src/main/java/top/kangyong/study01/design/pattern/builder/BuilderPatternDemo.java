package top.kangyong.study01.design.pattern.builder;

/**
 * 收银台
 * <p>
 * 建造者模式
 *
 * @author Kang Yong
 * @date 2022/6/24
 * @since 1.0.0
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        // 蔬菜套餐
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("蔬菜套餐：");
        vegMeal.showItems();
        System.out.println("Total Cost:" + vegMeal.getCost());

        // 鸡肉套餐
        Meal chickenMeal = mealBuilder.prepareChickenMeal();
        System.out.println("鸡肉套餐：");
        chickenMeal.showItems();
        System.out.println("Total Cost:" + chickenMeal.getCost());

    }
}
