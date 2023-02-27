import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class Homework10 {

    private static String getInputString(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.next();
    }

    /*
    ------------------First Problem------------------
      დაწერეთ ფუნქცია, რომელიც დააბრუნებს
      გადაცემული სიტყვა პალინდრომია თუ არა.
      პალინდრომი არის სიტყვა რომელიც მარჯვნიდან
      და მარცხნიდან ერთნაირად იკითხება,
      მაგალითად “aba”, “abba”
    */

    private static void firstProblem() {
        System.out.println("------------------First Problem------------------");
        String string = getInputString("შემოიტანეთ სტრინგი");

        System.out.println("--------First Problem For With Loop-----------");

        if (isPalindromeWithForLoop(string)) {
            System.out.println("შემოტანილი სტრინგი პალინდრომია");
        } else System.out.println("შემოტანილი სტრინგი არ არის პალინდრომი");

        System.out.println("--------First Problem With StringBuilder--------");

        if (isPalindromeWithStringBuilder(string)) {
            System.out.println("შემოტანილი სტრინგი პალინდრომია");
        } else System.out.println("შემოტანილი სტრინგი არ არის პალინდრომი");
    }

    private static boolean isPalindromeWithForLoop(String st) {
        String tester = "";
        for (int k = st.length() - 1; k >= 0; k--) {
            tester = tester + st.charAt(k);
        }
        return tester.equals(st);
    }

    private static boolean isPalindromeWithStringBuilder(String st){
        StringBuilder reversed = new StringBuilder();
        reversed.append(st);
        reversed.reverse();
        String resultSt = reversed.toString();
        return resultSt.equals(st);
    }

    /*
    ------------------Second Problem------------------
    დაწერეთ ფუნქცია, რომელიც დააბრუნებს
    გადაცემული ორი სიტყვა ანაგრამები არიან თუ
    არა. ორი სიტყვა ერთმანეთის ანაგრამაა, თუ ისინი
    შეიცავენ ერთი და იმავე რაოდენობის ასოებს.
    */

    private static void secondProblem() {
        System.out.println("------------------Second Problem------------------");
        String firtstSt = getInputString("შემოიტანეთ პირველი სტრინგი");
        String secondSt = getInputString("შემოიტანეთ მეორე სტრინგი");

        System.out.println("--------Second Problem With Loops--------");

        if (isAnagramWithLoops(firtstSt, secondSt)) {
            System.out.println("შემოსული სტრინგები ანაგრამებია");
        } else System.out.println("შემოსული სტრინგები არ არის ანაგრამები");

        System.out.println("--------Second Problem With Array--------");

        if (isAnagramWithArray(firtstSt, secondSt)) {
            System.out.println("შემოსული სტრინგები ანაგრამებია");
        } else System.out.println("შემოსული სტრინგები არ არის ანაგრამები");

    }

    private static boolean isAnagramWithLoops(String firstSt, String secondSt) {
        if (firstSt.length() == secondSt.length()) {
            for (char i = 'a'; i <= 'z'; i++) {
                while (firstSt.contains(String.valueOf(i)) && secondSt.contains(String.valueOf(i))) {
                    firstSt = firstSt.replace(String.valueOf(i), "");
                    secondSt = secondSt.replace(String.valueOf(i), "");
                }
                if (firstSt.length() != secondSt.length()) {
                    return false;
                }
            }
            for (char i = 'A'; i <= 'Z'; i++) {
                while (firstSt.contains(String.valueOf(i)) && secondSt.contains(String.valueOf(i))) {
                    firstSt = firstSt.replace(String.valueOf(i), "");
                    secondSt = secondSt.replace(String.valueOf(i), "");
                }
                if (firstSt.length() != secondSt.length()) {
                    return false;
                }

            }
            return true;

        }
        else return false;

    }

    private static boolean isAnagramWithArray(String firstSt, String  secondSt ){
        if(firstSt.length() == secondSt.length()){
            char [] arrayOfFirstString = firstSt.toCharArray();
            char [] arrayOfSecondString = secondSt.toCharArray();
            Arrays.sort(arrayOfFirstString);
            Arrays.sort(arrayOfSecondString);
            for(int i = 0 ; i < firstSt.length(); i++){
                if(arrayOfFirstString[i] != arrayOfSecondString[i]){
                    return false;
                }
            }
            return true;
        }
        else return false;

    }

    /*
    ------------------Third Problem------------------
    შემოგვდის რიცხვი n. დაბეჭდეთ მე-n ფიბონაჩის
    რიცხვი.
    ფიბონაჩის რიცხვებია: 0 1 2 3 5 8 13. . . ყოველი
    შემდეგი რიცხვი მიიღება წინა ორის ჯამით.
     */

    private static void thirdProblem(){
        System.out.println("------------------Third Problem------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("შემოიტანეთ რიცხვი");
        int n = scanner.nextInt();
        System.out.println("fib(" + n +") -> " + fibonacci(n));
    }

    private static long fibonacci(int n){
        long  [] arr = new long [n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int k = 2; k <= n; k++){
            arr[k] = arr[k-1] + arr[k-2];
        }
        return arr[n];
    }



    public static void main(String[] args) {
       // firstProblem();
        //secondProblem();
        thirdProblem();


    }
}
