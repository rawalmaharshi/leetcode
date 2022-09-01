// # We are profiling the performance of some app. In order to do that, app is instrumented to log events for beginning and end of each function. An event is a record with three fields: 1. function name 2. timestamp 3. type (begin or end)
 
// # Example:
 
// # foo, 10, b
// # bar, 20, b
// # bar, 50, e
// # foo, 100, e
 
// # Given such a log, compute exclusive running time for each function (exclusive time excludes time spent in function's sub-routines).
 
// # For above example the expected output is:
 
// # foo: 60
// # bar: 30



// Imagine an array that contains both integers and nested arrays, such as the following: [8, 4, [5, [9], 3], 6]. The depth sum is described as the weighted sum of each integer, weighted by their respective depths. In the example, 8's depth is 1, while 9's is 3.
// Given such an array, calculate its depth sum.
// For example:
// Input: [1, [2, 3]]
// Output: 1 + 2 * (2 + 3) = 11
// Input: [8, 4, [5, [9], 3], 6]
// Output: 8 + 4 + 2 * 5 + 3 * 9 + 2 * 3 + 6 ==> 61

public class NestedArray() {
  
  int value;
  List<NestedArray> element;
  
  boolean isInteger() {
    if (element.size() == 1) {
      return true;
    }
    
    return false;
  }
  
  int getInteger() {
    return this.value;
  }
}

// [1, [2, 3]]
// [ nums[0].value 
//   nums[0].element = null;
//  nums[1].value = 0;
//  nums[1].element = [2,3] 
//  ]


public int depthSum(List<NestedArray> nums) {
  return depthSumHelper(nums, 1);
}

public int depthSumHelper(List<NestedArray> nums, int depth) {
  int sum = 0;
  for (NestedArray num : nums) {
    if (num.isInteger()) {
      sum += depth * num.getInteger();
    } else {
      sum += depthSumHelper(num, depth + 1);
    }
  }
  
  return sum;
}

// public int depthSum(NestedArray nums) { }

// public class NestedArray() {
  
//   int value;
//   List<NestedArray> element;
  
//   boolean isInteger() {
//     if (element.size() == 1) {
//       return true;
//     }
    
//     return false;
//   }
  
//   int getInteger() {
//     return this.value;
//   }
// }