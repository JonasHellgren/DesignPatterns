package org.example.design_pattern_state.kidage;

public class Kid {

    private int age;
    private KidState kidState;

    public Kid(int age) {
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void play() {
        kidState.play();
    }

    public void eat() {
        kidState.eat();
    }

    public void setAge(int age) {
        this.age = age;

        switch (age) {
            case 1:
                kidState=new FirstYearKid();
                break;
            case 2:
                kidState=new SecondYearKid();
                break;
        }



    }


}
