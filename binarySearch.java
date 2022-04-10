import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        int list[] = {5,10,15,17,21,25,30,50,100,112,115,120,125,130,150,160,165,180,195,205,215,221,222,229,231,233,235,239,241,242,244};
        int target;
        int startIndex=0, endIndex=list.length-1, midIndex=endIndex/2;
        
        System.out.print("Input the target to search: ");
        Scanner scan = new Scanner(System.in);
        target = Integer.parseInt(scan.nextLine());
        scan.close();

        boolean flag = true;
        int targetIndex = -1;
        int loopCount = 0;

        while(flag) {
            loopCount++;
            int currentElement = list[midIndex];
            if ( currentElement == target) {
                targetIndex = midIndex;
                flag = false;
            } else if (currentElement < target) {
                startIndex = midIndex+1;
                midIndex = (startIndex + endIndex)/2;
            } else {
                endIndex = midIndex-1;
                midIndex = (startIndex + endIndex)/2;
            }
        }
        
        if (targetIndex > -1) {
            System.out.println("The target found at "+ targetIndex + " position.");
        } else {
            System.out.println("Target not found!");
        }
        System.out.println("Loop Count is " + loopCount);
    }
}