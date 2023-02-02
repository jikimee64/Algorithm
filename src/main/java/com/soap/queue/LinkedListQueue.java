package com.soap.queue;

import lombok.*;

import java.util.LinkedList;

enum AnimalType {
    CAT, DOG
}

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
abstract class Animal {
    private String name;
    private AnimalType animalType;
    private int order;

    public Animal(String name, AnimalType animalType) {
        this.name = name;
        this.animalType = animalType;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name, AnimalType.DOG);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name, AnimalType.CAT);
    }
}

class AnimalShelter {
    private LinkedList<Animal> cats = new LinkedList<>();
    private LinkedList<Animal> dogs = new LinkedList<>();
    private int order = 1;

    void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;

        if (animal.getAnimalType() == AnimalType.CAT) {
            cats.addLast(animal);
        }

        if (animal.getAnimalType() == AnimalType.DOG) {
            dogs.addLast(animal);
        }
    }

    Animal dequeue() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        } else if (dogs.isEmpty()) {
            return cats.poll();
        } else if (cats.isEmpty()) {
            return dogs.poll();
        } else {
            Animal dog = dogs.peek();
            Animal cat = cats.peek();

            int dogOrder = dog.getOrder();
            int catOrder = cat.getOrder();

            if (dogOrder <= catOrder) {
                return dogs.poll();
            } else {
                return cats.poll();
            }
        }
    }

    Animal dequeueCat() {
        return cats.poll();
    }

    Animal dequeueDog() {
        return dogs.poll();
    }
}

/**
 * 개와 고양이만 분양하는 분양소가 있다.
 * 분양받는 사람은 동물의 종류만 고를 수 있고, 분양소에서 가장 오래있은 순서로
 * 자동으로 분양될 동물이 정해지는 클래스를 구현하시오,
 * (단, 자바에서 제공하는 LinkedList로 구현하시오.
 * <p>
 * 필요한 클래스
 * enum AnimalType
 * abstract class Animal
 * class Dog
 * class Cat
 * class AnimalShelter
 */
public class LinkedListQueue {

    public static void main(String[] args) {
        Dog d1 = new Dog("puppy");
        Dog d2 = new Dog("chichi");
        Dog d3 = new Dog("choco");
        Cat c1 = new Cat("shasha");
        Cat c2 = new Cat("miumiu");
        Cat c3 = new Cat("gaga");

        AnimalShelter as = new AnimalShelter();
        as.enqueue(d1);
        as.enqueue(c1);
        as.enqueue(d2);
        as.enqueue(c2);
        as.enqueue(d3);
        as.enqueue(c3);

        System.out.println(as.dequeueCat().toString()); // type:CAT, name: shasha
        System.out.println(as.dequeueDog().toString()); // type:DOG, name: puppy
        System.out.println(as.dequeue().toString()); // type:DOG, name: chichi
        System.out.println(as.dequeue().toString()); // type:CAT, name: miumui
        System.out.println(as.dequeue().toString()); // type:DOG, name: choco
        System.out.println(as.dequeue().toString()); // type:CAT, name: gaga
    }

}
