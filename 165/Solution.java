class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        
        int ver1Len = ver1.length, ver2Len = ver2.length;
        int v1 = 0, v2 = 0;
        // System.out.println(ver1Len + "   " + ver2Len);
        while (v1 < ver1Len && v2 < ver2Len) {
            Integer v1int = Integer.parseInt(ver1[v1]);
            Integer v2int = Integer.parseInt(ver2[v2]);
            // System.out.println(v1int + "  " + v2int);
            if (v1int < v2int) {
                return -1;
            } else if (v1int > v2int) {
                return 1;
            } 
            
            v1++;
            v2++;
        }
        
        while (v1 < ver1Len) {
            Integer v1int = Integer.parseInt(ver1[v1]);
            if (v1int > 0) {
                return 1;
            }
            v1++;
        }
        
        while (v2 < ver2Len) {
            Integer v2int = Integer.parseInt(ver2[v2]);
            if (v2int > 0) {
                return -1;
            }
            v2++;
        }
        
        return 0;
    }
}