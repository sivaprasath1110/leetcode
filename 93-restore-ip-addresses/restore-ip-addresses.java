class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int start,
                           List<String> path,
                           List<String> result) {

        // If 4 parts are formed
        if (path.size() == 4) {

            // Entire string should be used
            if (start == s.length()) {
                result.add(String.join(".", path));
            }

            return;
        }

        // Try lengths 1 to 3
        for (int len = 1; len <= 3; len++) {

            if (start + len > s.length()) {
                break;
            }

            String part = s.substring(start, start + len);

            // Leading zero check
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }

            // Range check
            int num = Integer.parseInt(part);

            if (num <= 255) {
                path.add(part);

                backtrack(s, start + len, path, result);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }
}