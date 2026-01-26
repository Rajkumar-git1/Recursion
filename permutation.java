class permutation {
    static void permute(String str, String ans) {
        // Base case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // Pick each character one by one
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Remaining string
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            String rest = left + right;

            permute(rest, ans + ch);
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s, "");
    }
}
