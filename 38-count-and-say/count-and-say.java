class Solution {
    public String countAndSay(int n) {

        String result = "1";

        // Generate sequence from 2 to n
        for (int i = 2; i <= n; i++) {

            StringBuilder current = new StringBuilder();

            int count = 1;

            for (int j = 1; j < result.length(); j++) {

                // Count same consecutive digits
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {

                    // Append count and digit
                    current.append(count);
                    current.append(result.charAt(j - 1));

                    count = 1;
                }
            }

            // Append last group
            current.append(count);
            current.append(result.charAt(result.length() - 1));

            result = current.toString();
        }

        return result;
    }
}