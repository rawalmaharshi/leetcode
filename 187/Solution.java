class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // return usingSubstring(s);
        return rollingHashRabinKarp(s);
    }

    // T: O(N - L), S: O(N - L)
    private List<String> rollingHashRabinKarp(String s) {
        int L = 10, n = s.length();
        if (n <= L) {
            return new ArrayList<>();
        }

        //convert string to array of integers
        Map<Character, Integer> map = new HashMap<>() {
            {
                put('A', 0);
                put('C', 1);
                put('G', 2);
                put('T', 3);
            }
        };
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = map.get(s.charAt(i));
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> answer = new HashSet<>();

        //rolling hash paramaters: base a
        int h = 0;
        int a = 4, aL = (int) Math.pow(a, L);

        for (int i = 0; i < n - L + 1; i++) {
            //Compute hash of current sequence in O(1) time
            if (i != 0) {
                h = (h * a) - (nums[i - 1] * aL) + nums[i + L - 1];
            } else {
                //compute hash for 1st sequence in O(L) time
                for (int j = 0; j < L; j++) {
                    h = (h * a) + nums[j];
                }
            }

            if (seen.contains(h)) {
                answer.add(s.substring(i, i + L));
            }
            seen.add(h);
        }

        return new ArrayList<>(answer);
    }

    // T:  O((N - L)L),  S: O((N - L)L)
    private List<String> usingSubstring(String s) {
        int L = 10, n = s.length();
        Set<String> seen = new HashSet<>();
        Set<String> answer = new HashSet<>();

        for (int i = 0; i < n - L + 1; i++) {
            String temp = s.substring(i, i + L);
            if (seen.contains(temp)) {
                answer.add(temp);
            }
            seen.add(temp);
        }

        return new ArrayList<>(answer);
    }
}