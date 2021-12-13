package org.example.design_pattern_state.kidage;

public class KidRunner {

    public static void main(String[] args) {
        Kid kid=new Kid(1);
        runKidMethods(kid);

        kid.setAge(2);
        runKidMethods(kid);

    }

    private static void runKidMethods(Kid kid) {
        System.out.println("age = "+kid.getAge());
        kid.eat();
        kid.play();
    }
}
