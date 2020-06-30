package com.example.mode.strategy;

import java.util.function.Function;

public class StrategyMode {
    public static void main(String[] args) {
        BaseStrategy add = new AddStrategy();
        BaseStrategy sub = new SubStrategy();
        System.out.println(add.exec(1,2));
        System.out.println(sub.exec(1,2));
        System.out.println("---------------");
        System.out.println(StrategyEnum.ADD.exec(1,2));
        System.out.println(StrategyEnum.SUB.exec(1,2));
        System.out.println("----------------");
        System.out.println(StrategyEnum2.ADD.apply(new Cal(1,2)));
        System.out.println(StrategyEnum2.SUB.apply(new Cal(1,2)));
        System.out.println("++++++++++++++++++++");
        System.out.println(StrategyFactory.getStrategy("+").apply(new Cal(1,2)));
        System.out.println(StrategyFactory.getStrategy("-").apply(new Cal(1,2)));
    }
}
interface BaseStrategy{
    int exec(int a,int b);
}
class AddStrategy implements BaseStrategy{

    @Override
    public int exec(int a, int b) {
        return a+b;
    }
}
class SubStrategy implements BaseStrategy{

    @Override
    public int exec(int a, int b) {
        return a-b;
    }
}
enum StrategyEnum{
    ADD("+"){
        @Override
        int exec(int a, int b) {
            return a+b;
        }
    },
    SUB("-"){
        @Override
        int exec(int a, int b) {
            return a-b;
        }
    };
    String desc;

    StrategyEnum(String desc) {
        this.desc = desc;
    }
    abstract int exec(int a, int b);
}
class Cal{
    private int a;
    private int b;

    public Cal() {
    }

    public Cal(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
enum StrategyEnum2{
    ADD(cal->{
        return cal.getA()+cal.getB()+"";
    }),
    SUB(cal -> {
        return cal.getA()-cal.getB()+"";
    })
    ;
    private Function<Cal, String> func;

    StrategyEnum2(Function<Cal, String> func) {
        this.func = func;
    }
    public String apply(Cal cal) {
        System.out.println("123");
        return this.func.apply(cal);
    }
}