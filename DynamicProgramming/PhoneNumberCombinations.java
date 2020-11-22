class Solution {
  private List<String> digitToPossibleLetters = Arrays.asList(
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
  );

  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }

    List<String> mnemonics = new ArrayList<>();
    exploreCombinations(0, new StringBuilder(), digits, mnemonics);
    return mnemonics;
  }

  private void exploreCombinations(int currentDigit, StringBuilder partialMnemonic, String digits, List<String> mnemonics) {
    if (currentDigit == digits.length()) {
      mnemonics.add(partialMnemonic.toString());
      return;
    }

    char digitCharacter = digits.charAt(currentDigit);
    int digitAsInt = digitCharacter - '0';
    String letters = digitToPossibleLetters.get(digitAsInt);
    for (char possibleLetter: letters.toCharArray()) {
      partialMnemonic.append(possibleLetter);
      exploreCombinations(currentDigit + 1, partialMnemonic, digits, mnemonics);
       partialMnemonic.deleteCharAt(partialMnemonic.length() - 1);
    }
  }
}