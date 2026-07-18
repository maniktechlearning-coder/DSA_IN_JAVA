package SearchingProblems;

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
            {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1 ;
    }

}
