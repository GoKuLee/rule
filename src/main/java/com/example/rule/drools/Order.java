package com.example.rule.drools;
public class Order {
    private int amount;
    private int score;

    public Order() {
    }

    public Order(int amount, int score) {
        this.amount = amount;
        this.score = score;
    }

    public Order(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Order{" +
                "amount=" + amount +
                ", score=" + score +
                '}';
    }
}
