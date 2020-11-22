class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> results = new ArrayList<>();

    solveNQueens(0, n, new ArrayList<>(), results);

    return results;
  }

  private void solveNQueens(int row, int n, List<Integer> colPlacements, List<List<String>> results) {
    if (row == n) {
      results.add(generateBoardFromPlacements(colPlacements, n));
      return;
    }

    for (int col = 0; col < n; col++) {
      colPlacements.add(col);
      if (isValid(colPlacements)) {
        solveNQueens(row + 1, n, colPlacements, results);
      }
      colPlacements.remove(colPlacements.size() - 1);
    }
  }
  private boolean isValid(List<Integer> colPlacements) {
    int rowWeAreValidatingOn = colPlacements.size() - 1;
    for (int ithQueenRow = 0; ithQueenRow < rowWeAreValidatingOn; ithQueenRow++) {
      int absoluteColumnDistance = Math.abs(colPlacements.get(ithQueenRow) - colPlacements.get(rowWeAreValidatingOn));
      int rowDistance = rowWeAreValidatingOn - ithQueenRow;
      if (absoluteColumnDistance == 0 || absoluteColumnDistance == rowDistance) {
        return false;
      }
    }

    return true;
  }
  private List<String> generateBoardFromPlacements(List<Integer> colPlacements, int n) {
    List<String> board = new ArrayList<>();
    int totalItemsPlaced = colPlacements.size();
    for (int row = 0; row < totalItemsPlaced; row++) {
      StringBuilder sb = new StringBuilder();
      for (int col = 0; col < n; col++) {
        if (col == colPlacements.get(row)) {
          sb.append('Q');
        } else {
          sb.append('.');
        }
      }
      board.add(sb.toString());
    }

    return board;
  }
}