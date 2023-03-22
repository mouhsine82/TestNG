package class01;

import org.testng.annotations.Test;

public class Priority {


    @Test (priority = 3)  // if you don't give the priority the 0 is the default it will execute first
    public void Atest(){
        System.out.println("I am TestA");
    }

    @Test (priority = 1)
    public void Btest(){
        System.out.println("I am TestB");
    }

    @Test(priority = 2)
    public void Ctest(){
        System.out.println("I am TestC");
    }

}
