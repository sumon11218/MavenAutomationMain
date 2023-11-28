package Practice;

import java.util.ArrayList;

public class TestClass {

    //one array and one target integer
    //function should take both arguments and return a boolean
    //it should return true if any two elements within the array that can sum up to the target
    //else it should be false

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        int targetNumber = 6;
        int arrayVal = 0;
        for(int i=0;i<numbers.size();i++){
            arrayVal = numbers.get(i);
            numbers.remove(arrayVal);
            System.out.printf("Size" + numbers.size());
            for(int j=0; j<numbers.size();j++){
                int newVal = arrayVal + numbers.get(j);
                System.out.println(newVal);
                if((arrayVal+numbers.get(j)) == targetNumber){
                    System.out.printf("True");
                    break;
                } else {
                    System.out.printf("False");
                }
            }//end of sub loop
        }//end of loop
    }//end of method


}//end of class
