class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        
        StringBuilder sb = new StringBuilder();
        int digitsCount = (int) Math.log10(num) + 1;
        int temp = num;
        while (temp > 0) {
            int place = (int) Math.pow(10, digitsCount - 1);
            int digit = (int) temp / place;
            
            if (digit == 4) {
                sb.append(map.get(place));
                sb.append(map.get(place * 5));
            } else if (digit == 9) {
                sb.append(map.get(place));
                sb.append(map.get(place * 10));
            } else {
                if (digit >= 5) {
                    sb.append(map.get(place * 5));    
                }
                
                for (int i = digit % 5; i > 0; i--) {
                    sb.append(map.get(place));
                }
            }
            temp -= place * digit;
            digitsCount--;
        }
        
        return sb.toString();
    }
}