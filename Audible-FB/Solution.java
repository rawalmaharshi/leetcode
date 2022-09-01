import java.util.*;
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

class Main {
  public static void main(String[] args) {
    String[] input = new String[] {
      "foo,10,b",
      "bar,20,b",
      "bar,50,e",
      "foo,100,e"
    };
    computeTimes(input);
    
  }

  public static void computeTimes(String[] input) {
    Map<String, Integer> timeMap = new HashMap<>();
    String runningProcess = "";
    int startTime = 0;
    Stack<String> processes = new Stack<>();

    for (String current : input) {
      String[] params = current.split(",");
      String currentProcess = params[0];
      Integer currentTime = Integer.valueOf(params[1]);
      String type = params[2];
      if (type.equals("b")) {
        processes.push(currentProcess);
        //This is for the first input
        if (runningProcess == "") {
          startTime = currentTime;
          runningProcess = currentProcess;
          continue;
        }
        
        if (currentProcess != runningProcess) {
          timeMap.put(runningProcess, timeMap.getOrDefault(runningProcess, 0) + (currentTime - startTime));
          startTime = currentTime;
          runningProcess = currentProcess;
        }
      } else if (type.equals("e")) {
        processes.pop();        
        timeMap.put(runningProcess, timeMap.getOrDefault(runningProcess, 0) + (currentTime - startTime));
        runningProcess = !processes.isEmpty() ?  processes.peek() : "";

        startTime = currentTime;
      }
    }

    for (String key : timeMap.keySet()) {
      System.out.println("Process - " + key + " takes " + timeMap.get(key) + " time.");
    }
  }
}