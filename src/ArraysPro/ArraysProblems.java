package ArraysPro;

import java.util.*;

public class ArraysProblems {

    public static int SumofNumbres( int arr[])
    {
        int sum = 0;
        for( int i=0;i<arr.length;i++)
        {
            sum += arr[i];
        }
        System.out.println("The sum of the numbers in the array is: " + sum);
        return sum;
    }
    public static void ProductOfArrays( int arr[])
    {
        int product = 1;
        for(int i = 0;i<arr.length;i++)
        {
            product *= arr[i];
        }
        System.out.println("The product of the numbers in the array is: " + product);
    }

    public static void LargstElementInArray(int arr [])
    {
        int max = arr[0];
        for( int i = 0 ; i< arr.length;i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println("The largest element in the array is: " + max);
    }

    public static void SmallestElementInarray( int arr[])
    {
        int min =  arr[0];
        for( int i = 0 ; i< arr.length;i++)
        {
            if(arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println("The smallest element in the array is: " + min);
    }

    public static void ReverseTheArray( int arr[])
    {

//        for( int i = arr.length-1; i>=0 ; i--)
//        {
//            System.out.println( arr[i] + " ");
//        }
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // Print the reversed array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static  void AvarageofArrays( int arr[])
    {
        int sum = SumofNumbres(arr);
        System.out.println("The sum of the numbers in the array is: " + sum);
        double avr = (double) sum / arr.length;
        System.out.println("The average of the numbers in the array is: " + avr);
    }

    public static void SecondLargestNumberInArray( int arr [])
    {
        int p = Integer.MIN_VALUE;
        int vp = Integer.MIN_VALUE;

        for( int i = 0 ; i< arr.length;i++)
        {
            if(arr[i] > p)
            {
                vp = p ;
                p = arr[i];
            } else if (arr[i] > vp && arr[i] != p)
            {
                vp = arr[i] ;
            }
        }
        System.out.println("The largest number in the array is: " + vp);
    }

    public static  void CheckDuplicateInArray( int arr[])
    {
        HashSet<Integer> set = new HashSet<Integer>();
//if we want to return the list then you have to create the list add those to the list and return
        for(int element : arr)
        {
            if(set.contains(element))
            {
                System.out.println("Duplicate in the array");
//                instead of printing add the elements to the list
            }
            set.add(element);
        }
    }

    public static void CountTheFrequencyOfTheArrayElements(int arr[])
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int nums : arr)
        {
            map.put(nums, map.getOrDefault(nums,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static  void DuplicateElementsInArray(int arr [])
    {
        HashMap<Integer,Integer> map = new HashMap<>();

        for( int nums :arr)
        {
            map.put(nums, map.getOrDefault(nums,0)+1);
        }

        for( HashMap.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue()>1)
            {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }

    public static void FirstNonRepeatingNumber( int arr [])
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int nums :arr)
        {
            map.put(nums , map.getOrDefault(nums,0)+1);
        }

        for( int nums :arr)
        {
            if( map.get(nums) == 1)
            {
                System.out.println("The non Repeating numbre is " + nums);
                break;
            }
        }
    }

    public static int[] TwoSumProblem(int arr [] , int target)
    {
//        this approch is only when we have no duplicate elements in the array
        HashMap<Integer,Integer> map = new HashMap<>();
        for( int i = 0 ;  i< arr.length;i++)
        {
            int complement = target - arr[i];
            if( map.containsKey(complement))
            {
                return new int[]{map.get(complement),i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }
//both the s and t Shuld be lower case string
//    ASCII Value --> A-65 and a-97
    public static boolean AnagramProblem(String s , String t)
    {
        if(s.length()!=t.length())
        {
            return false;
        }
         int arr[] = new int[26];

        for( int i =0 ; i< s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
//if the arr elements are not zero then the those are anagrams
// cat is formed by the act so those are anagrams
        for( int num : arr)
        {
            if(num != 0 )
            {
                return false;
            }
        }
        return true;
    }

    public static void CountTheAlpabetsandNonAlphabets(String str)
    {
        int alpabet = 0;
        int spaces = 0;
        int numerics = 0;

        for( int i = 0 ; i < str.length() ; i++ )
        {
            char ch = str.charAt(i);
            if((ch >='A' && ch <= 'Z') || (ch >='a' && ch <='z'))
            {
                alpabet++;
            }
            else if(ch >= '0' && ch <= '9')
            {
                numerics++;
            }
            else if(ch == ' '){
                spaces++;
            }
        }
    }

    public static List<List<String>> groupAnagrams(String str[])
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for( String s : str)
        {
            //convert into the arr of strings and then sort the charcater elements
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            //Convert that charcter array back inot the string
            String st = new String(arr);

            if(!map.containsKey(st))
            {
                //we need to it the word does not there in the hash map then push that one to list
                map.put(st , new ArrayList<>());
            }
            map.get(st).add(s);
        }
        //we wil return the entrie the arralist of the values back.
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramsApprochOptimized(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
//this is the array of 26 is the approch for the anagram also
            int[] count = new int[26];

            // Count frequency of each character
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }

            // Convert frequency array into a unique key
            String key = Arrays.toString(count);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static boolean CheckSortedArray(int arr[])
    {
        boolean flag = true;

        for(int index = 1; index < arr.length; index++)
        {
            if(arr[index] > arr[index-1])
            {
                flag = false;
                break;
            }
        }

        return flag;
    }

    public static int  MissingNumberInArray(int arr[])
    {
        int actualsum = 0 ;

        for( int num : arr)
        {
            actualsum += num;
        }

        int n = arr.length + 1 ;

        int expectedsum = n * (n+1) / 2 ;

        return expectedsum - actualsum;
    }

    public static void MoveZeroToEnd( int arr [])
    {
//        Input:
//        1 0 2 0 3 0 5
//
//        Output:
//        1 2 3 5 0 0 0
        int j = 0 ;
        for(int i = 0 ; i< arr.length ; i++ )
        {
            if( arr[i] != 0 )
            {
                arr[j] = arr[i];
                j++;
            }
        }

        while( j < arr.length )
        {
            arr[j] = 0;
            j++;
        }
    }

    public static void MoveZerosToFront(int arr[])
    {
//        Input:
//        1 0 2 0 3
//
//        Output:
//        0 0 1 2 3
        int j = arr.length-1;

        for( int i = arr.length -1 ; i >= 0 ; i-- )
        {
            if(arr[i] != 0)
            {
                arr[j] = arr[i];
                j--;
            }
        }

        while ( j >= 0 )
        {
            arr[j] = 0;
            j--;
        }

    }

    public static void MoveNegativeNumberToEnd(int arr[])
    {
//        order of the array cannot be mentained and if you wnat we need to use the one extra array for that
        int left = 0 ;
        int right = arr.length -1 ;

        while( left < right )
        {
            while(left < right && arr[left] < 0)
            {
                left ++ ;
            }
            while( left < right && arr[right] >= 0)
            {
                right -- ;
            }

            if( left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void MoveNegativeNumbersToRight( int arr[])
    {
        int left = 0 ;
        int right = arr.length -1 ;

        while( left < right )
        {
            while(left < right && arr[left] >= 0)
            {
                left ++ ;
            }

            while(left < right && arr[right] < 0)
            {
                right -- ;
            }

            if( left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void SepearateTheOddEven( int arr[])
    {
//        keep the even in the left and odd in the left
        int left = 0;
        int right = arr.length-1;

        while( left < right)
        {
            while( left < right && arr[left] % 2 == 0 )
            {
                left ++ ;
            }
            while( left < right && arr[right] % 2 != 0)
            {
                right--;
            }
//            swap the number of the array
            if( left < right)
            {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    public static void RemoveTheDuplicatesFromUnsortedArray( int arr[])
    {
        // 2 3 4 5 1 6 6 7 5 I/P --> 1234567
        Set<Integer> set = new LinkedHashSet<>();

        for( int num : arr)
        {
            set.add(num);
        }
    }

}

