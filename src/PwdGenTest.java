import org.junit.Test;

import static org.junit.Assert.*;

public class PwdGenTest {

    private PwdGen testPwdGen = new PwdGen();
    private  int timesToTest = 10000;

    @Test
    public void testSpecialChars(){
        Character[] specialCharacters = {'.','-','_','+','!','?','\'',',','='};
        Boolean containsSpecialChar = false;

        for (int i = 0; i < timesToTest; i++) {
            String pwd = testPwdGen.getPassword();
            System.out.println(pwd);
            for (Character c : specialCharacters){
                if (pwd.indexOf(c) != -1){
                    containsSpecialChar = true;
                }
            }
            assert(containsSpecialChar);

        }

        System.out.println("\nEvery password contains a special character.");

    }

    @Test
    public void testLength(){

        for (int i = 0; i < timesToTest; i++) {
            String pwd = testPwdGen.getPassword();
            assert (pwd.length() >= 6) && (pwd.length() <= 50);
        }
        System.out.println("\nLength within bounds: 6 to 50");

        int maxLength = 0, minLength = 50;

        for (int i = 0; i < timesToTest; i++) {

            String pwd = testPwdGen.getPassword();
            if (pwd.length() > maxLength){
                maxLength = pwd.length();
            }
            if (pwd.length() < minLength){
                minLength = pwd.length();
            }
        }
        assertEquals(50, maxLength);
        assertEquals(6, minLength);

        System.out.println("\nBoth maximum and minimum length is used.");

    }

}