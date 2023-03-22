package class01;

import org.testng.annotations.Test;

public class enableDisable {


    @Test (enabled = false)  // use this function to disable the test(it will not execute) bug issue waiting for devs to fix
    public void Atest(){
        System.out.println("I am first test case");
    }
    @Test
    public void Btest(){
        System.out.println("I am second test case");
    }
    @Test
    public void Ctest(){
        System.out.println("I am third test case");
    }
}
