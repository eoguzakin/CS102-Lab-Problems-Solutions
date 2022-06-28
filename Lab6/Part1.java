import java.util.Arrays;
import java.util.Scanner;
public class Part1 {

    public static void main(String args[]) {
        int n = 10000;
        int k = 5;//5
        Scanner input = new Scanner(System.in);
        // Each element of the array is between 0 and 4n
        int[] arr = generateRandomArray(n);

        // Sorting is pre-condition of the search algorithms in this lab
        Arrays.sort(arr);

        // Insert appropriate code segments to calculate execution time
        long start;
        long end;
        // Checking if the method can correctly find already existing elements
        for (int elem : arr) {
            int res = 999999999;
            // call the search function and assign it to ``res``
            //selecting k for the method and starting measuring execution time
            System.out.print("Select k: ");
            int j = input.nextInt();
            start = System.currentTimeMillis();
            try{
            	//if there is an error, it will be thrown
            	res = genericSearch(arr,elem,0,arr.length-1,j);
            	//if the element is not found, throws error
            	if (elem != arr[res]) {
                throw new RuntimeException("Method works incorrectly (cannot properly locate elements)");
            	}
            	//ends measurement
            	end = System.currentTimeMillis();
            }catch(KIsLessThan2Exception e){
            	end = System.currentTimeMillis();
            }catch(InputNotSortedException e){
            	end = System.currentTimeMillis();
            }
            //prints elapsed time
            System.out.println("Execution time: " + (end - start));
            // Generalize the code so that you can experiment with different k values in a single execution
        }


        // Checking if the method can correctly report absence of elements
        int[] nonExistingElements = {-90, -54, 5 * n + 5, 6 * n};
        for(int elem: nonExistingElements){
            int res = 999999999;
            // call the search function and assign it to ``res``
            //we select k for the method
            System.out.print("Select k: ");
            int m = input.nextInt();
            //start the execution and measuring
            start = System.currentTimeMillis();
            try{
            	res = genericSearch(arr,elem,0,arr.length-1,m);
            	end = System.currentTimeMillis();
            	//if the method works incorrectly, throws error
            	if (res != -1) {
                throw new RuntimeException("Method works incorrectly (cannot report absence of elements)");
            	}
            }catch(KIsLessThan2Exception e){
            	end = System.currentTimeMillis();
            }catch(InputNotSortedException e){
            	end = System.currentTimeMillis();
            }
            //prints execution time
            end = System.currentTimeMillis();
            System.out.println("Execution time: " + (end - start));
            // Generalize the code so that you can experiment with different k values in a single execution
        }
    }
    //binary search method filled according to the pseudocode in the lab prompt
    public static int binarySearch(int[] arr, int target, int low, int high){
        if(low > high)
        	return -1;
        int mid = low + (high-low)/2;
        if(arr[mid] == target)
        	return mid;
        if(target < arr[mid])
        	return binarySearch(arr,target,low,mid);
        else
        	return binarySearch(arr,target,mid,low);
    }
    //ternary search method filled according to the pseudocode in the lab prompt
    public static int ternarySearch(int[] arr, int target, int low, int high){
        if(low > high)
        	return -1;
        int mid1 = low + (high-low)/3;
        int mid2 = low + 2*(high-low)/3;
        if(arr[mid1] == target)
        	return mid1;
        if(arr[mid2] == target)
        	return mid2;
        if(target < arr[mid1])
        	return ternarySearch(arr,target,low,mid1);
        else if(target < arr[mid2])
        	return ternarySearch(arr,target,mid1,mid2);
        else
        	return ternarySearch(arr,target,mid2,high);
    }

    public static int genericSearch(int[] arr, int target, int low, int high, int k) throws KIsLessThan2Exception,InputNotSortedException{
        //if k<2 throws error
        if(k < 2){
        	System.out.println("k<2");
        	throw new KIsLessThan2Exception("aaaaaaaa!");
        }
        //if arr is not sorted, throws error
        for(int i = 0; i < high; i++){
        	if(arr[i] > arr[i+1]){
        		System.out.println("not sorted");
        		throw new InputNotSortedException();
        	}
        }
        //if the pointers have crossed each other returns -1
        if(low > high)
        	return -1;
        //we create an array for mid points and start-end points
        int[] mids = new int[k+1];
        //we add start and end points
        mids[0] = low;
        mids[k] = high;
        //we add other mid points
        for(int i = 1; i < k; i++){
        	int mid = low + (i)*(high-low)/k;
        	mids[i] = mid; 
        }
        //we check if the target is at one of mid points
        for(int i = 0; i < k+1; i++){
        	if(arr[mids[i]] == target){
        		return mids[i];
        	}
        }
        //then we check for each inner array
        for(int i = 0; i < k; i++){
        	if(target > arr[mids[i]])
        		return genericSearch(arr,target,mids[i],mids[i+1],k);
        }
        return -1;
    }


    /**
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     * YOU SHOULD NOT TOUCH BELOW THIS POINT
     */

    public static int[] generateRandomArray(int length)
    {
        int[] array = new int[length];

        for (int i = 0; i < length; ++i)
        {
            array[i] = (int)(Math.random() * length * 4);
        }

        return array;
    }

}
