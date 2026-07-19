package SearchingProblems;


//Problem	When arr[mid] == target
//Binary Search	return mid;
//First Occurrence	answer = mid; right = mid - 1;
//Last Occurrence	answer = mid; left = mid + 1;
public class SearcingAlgorithums {

    public static int LinearSearching( int arr[] , int target)
    {
//        Array = [1,3,2,5,6]
//        Target = 5
        //o/p: index of the 5 is 3
        for(int  i =0 ; i<arr.length ; i++)
        {
            if( target == arr[i])
            {
                return i ;//return the index of the target element
            }
        }
        return -1;
    }

    public static int BinarySearching( int arr [] , int target)
    {
//        Array = [1,3,2,5,6]
//        Target = 5
//        o/p: index of the 5 is 3

        int left =0;
        int right = arr.length-1;

        while( left <= right )//this imp because when the left and right beomes same number
        {
            int mid = left + (right - left)/2 ;

            if( target == arr[mid])
            {
                return mid;
            }
            else if( target > arr[mid])
            //when the else if condition is false then we need to left because that element is above the mid
            {
                right = mid - 1 ;
            }
            else {
                left = mid + 1;
            }
        }
        return -1 ;
    }

    public static int firstOcurenceOfArrayInSorted( int[] arr , int target )
    {
        int ans = -1 ;
        int left =0;
        int right = arr.length-1;

        while(left <= right)
        {
            int mid = left + (right - left)/2 ;
            if(arr[mid] == target)
            {
                ans = mid ;
                right = mid -1 ;//we need to move towards the left to get the first occurence and
                //if we want the laste then we need to make the - to +
            }
            else if(arr[mid] > target)
            {
                right = mid - 1 ;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int lastOccurenceOfTheElementInSorted( int[] arr , int target )
    {
        int ans = -1 ;
        int left = 0;
        int right = arr.length-1;

        while(left <= right)
        {
            int mid = left + (left + right)/2;
            if( arr[mid] == target)
            {
                ans = mid;
                //we need to do the searching in the right for the last occrence
                right =mid + 1 ;
            }
            else if (arr[mid] > target)
            {
                right = mid -1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int searchInsertPosition( int arr[] , int target)
    {
        int left = 0;
        int right = arr.length-1;

        while( left <= right)
        {
            int mid = left + (right - left)/2;
            if( arr[mid] == target)
            {
                return mid;
            }
            else if (arr[mid] > target)
            {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left; //we need to retur the left becaue when the left and right value becomes smae then we need to return left only so
    }

    public static void leftRotateByOne(int[] arr)
    {
        // Step 1: Store the first element
        int temp = arr[0];

        // Step 2: Shift every element one position to the left
        for (int i = 1; i < arr.length; i++)
        {
            arr[i - 1] = arr[i];
        }

        // Step 3: Place the first element at the end
        arr[arr.length - 1] = temp;
    }


    public static void rotateByRight(int arr[])
    {
        int temp = arr[arr.length-1];

        for( int i = arr.length-1 ; i>=0 ; i--)
        {
            arr[i] = arr[i-1];
        }

        arr[0] = temp;
    }
}
