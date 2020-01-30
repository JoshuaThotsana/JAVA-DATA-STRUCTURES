public class InputGeneration {

    String[][] myGrid = new String[10][10];
    String input = "/ + + # + + +\n" +
            "/ + + # # # +\n" +
            "/ + + + + + +";;

    public void fillGrid(String string) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                myGrid[i][j] = "+";
            }
        }
        String[] lines = string.split("\n");
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].split(" ").length; j++) {
                if (lines[i].split(" ")[j].trim().equals("#")){
                    myGrid[i][(j-1)] = "#";
                }
            }
        }
    }
}
