package com.erraveni;


/*
*
* Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
Example

There are two each of types  and , and one sighting of type . Pick the lower of the two types seen twice: type .
Function Description
Complete the migratoryBirds function in the editor below.
migratoryBirds has the following parameter(s):
int arr[n]: the types of birds sighted
Returns
int: the lowest type id of the most frequently sighted birds
Input Format
The first line contains an integer, , the size of .
The second line describes  as  space-separated integers, each a type number of the bird sighted.
Constraints

It is guaranteed that each type is , , , , or .
Sample Input 0
6
1 4 4 4 5 3
Sample Output 0
4
Explanation 0
The different types of birds occur in the following frequencies:
Type :  bird
Type :  birds
Type :  bird
Type :  birds
Type :  bird
The type number that occurs at the highest frequency is type , so we print  as our answer.
Sample Input 1
11
1 2 3 4 5 4 3 2 1 3 4
Sample Output 1
3
Explanation 1
The different types of birds occur in the following frequencies:
Type :
Type :
Type :
Type :
Type :
Two types have a frequency of , and the lower of those is type .*/

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result_4 {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Map<Integer,Integer> map=new HashMap<>();
        for(Integer value:arr){
            map.put(value, map.getOrDefault(value, 0)+1);
        }
        int max=0;
        int result=0;

        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>max){
                max=m.getValue();
                result=m.getKey();
            }
            else if(m.getValue()==max){
                result=Math.min(result, m.getKey());
            }
        }
        return result;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result_4.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

