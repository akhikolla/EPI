class longestCommonsubsequence{
  public int longestCommonsubsequenceLength(String s1, String s2) {
    int cache[][] = new int[s2.length() + 1][s1.length() + 1];
    for (int s2Row = 0; s2Row <= s2.length(); s2Row++) {
      for (int s1Col = 0; s1Col <= s1.length(); s1Col++) {
        if (s2Row == 0 || s1Col == 0) {
          cache[s2Row][s1Col] = 0;
        } else if (s2.charAt(s2Row - 1) == s1.charAt(s1Col - 1)) {
          cache[s2Row][s1Col] = cache[s2Row - 1][s1Col - 1] + 1;
        } else {
          cache[s2Row][s1Col] = Math.max(cache[s2Row - 1][s1Col], cache[s2Row][s1Col - 1]);
        }
      }
    }

    return cache[s2.length()][s1.length()];
  }
}
