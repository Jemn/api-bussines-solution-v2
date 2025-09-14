package com.solution.mateo.application.util;

public class Util {

    public static void main (String[] args) {


        Perro perro = new Perro();

        //perro = null;

        System.out.print(perro instanceof Animal); // false

    }

    static class  Animal {}

    static class Perro extends Animal {}
    class Fish extends Animal {

        void swim(){
            System.out.println("Swim");
        }

    }

    class Bird extends Animal {
        void fly(){
            System.out.println("Fly");
        }

    }

    class Kangaroo extends Animal {

        void jump(){
            System.out.println("Jump");
        }

    }
}
