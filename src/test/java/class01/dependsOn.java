package class01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void Login() {   // if this case failed the below test case will be ignored
        System.out.println(6/0); // this exp to make the test failed
    }

    @Test (dependsOnMethods = {"Login"})  // this test case is depends on the login test case if the first pass this will pass
    public void DashBoardVerification() {  // if the login failed this will be ignored
        System.out.println("After login I am verifying dashboard");
    }
}
