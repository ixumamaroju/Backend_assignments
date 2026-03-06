package com.example;

public class A {
    private B b;
    public A() {
        System.out.println("A created");
    }
    public  void setB(B b) {
        this.b = b;
        System.out.println("A injected with B");
    }
}
