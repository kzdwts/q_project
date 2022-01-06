package top.kangyong.study01.demo;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 大象
 * @author: kangyong
 * @date: 2020/10/29 11:42
 * @version: v1.0
 */
@Data
public class Elphant {

    /**
     * 体重
     */
    private Double weight;

    /**
     * 身高
     */
    private Double height;

    /**
     * 颜色
     */
    private String color;

    public Elphant() {
    }

    public Elphant(Double weight, Double height, String color) {
        this.weight = weight;
        this.height = height;
        this.color = color;
    }

    public void showProp() {
        System.out.println("身高：" + this.height);
        System.out.println("体重：" + this.weight);
        System.out.println("颜色：" + this.color);
    }

    public void sayHello() {
        System.out.println("Hello everyone, my name is ant!");
    }

    public void eat() {
        System.out.println("I like eat green plants!");
    }

    public void walk() {
        System.out.println("I can't walk very long!");
    }

    protected void sleep() {
        System.out.println("protected method. sleep");
    }

    private void breathe() {
        System.out.println("private method. breath");
    }

}
