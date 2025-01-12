/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

 public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int copiedChars = 0, readChars = 4; //read chars set to 4 so that whenever readChars is not 4, we have reached EOF
        char[] buf4 = new char[4];

        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);

            for (int i = 0; i < readChars; i++) {
                //required number of characters have been read; return
                if (copiedChars == n) {
                    return copiedChars;
                }

                //copy characters from buf4 to buf
                buf[copiedChars] = buf4[i];
                copiedChars++;
            }
        }

        //Number of characters read
        return copiedChars;
    }
}

/*
    Algo:
    1. Initialize copiedChars to 0 and readChars to 4. readChars is set to 4 so that whenever readChars is not 4, we have reached EOF.
    2. Create a buffer buf4 to store the characters read from read4.
    3. While the number of copied characters is less than n and the 
    number of characters read from read4 is 4, read characters from read4 to buf.
    4. Return the number of characters read.
    Time Complexity: O(n)
    Space Complexity: O(1)
 */