class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n, getMap());
    }

    // T: O(N.5^N/2)
    // S: O(N.5^N/2)
    private List<String> helper(int n, int finalLength, Map<Character, Character> map) {
        //base case(s)
        if (n == 0) {
            //0-digit strobogrammatic num is an empty string
            return new ArrayList<>(List.of(""));
        }

        if (n == 1) {
            //1-digit strobogrammatic numbers
            return new ArrayList<>(List.of("0", "1", "8"));
        }

        //Generate strobogrammatic num for (n - 2)
        List<String> prevStrobos = helper(n - 2, finalLength, map);

        List<String> currStrobos = new ArrayList<>();
        for (String strobo : prevStrobos) {
            for (char key : map.keySet()) {
                //We can only append 0 if it is not the 1st digit
                if (key != '0' || n != finalLength) {
                    currStrobos.add(key + strobo + map.get(key));
                }
            }
        }

        return currStrobos;
    }

    private Map<Character, Character> getMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        return map;
    }
}