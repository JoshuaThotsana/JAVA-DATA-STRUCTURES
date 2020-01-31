import java.util.Arrays;

public class ConwayGameOfLife {

    public static void main(String[] args) {

        ConwayGameOfLife life = new ConwayGameOfLife();

        String[][] myGrid = new String[10][10];
        String input = "/ + + # + + +\n" +
                "/ + + # # # +\n" +
                "/ + + + + + +";

        fillGrid(input,myGrid);
        System.out.println("Input\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(myGrid[i]));
        }
        System.out.println("\nNext generation\n");

        for (int i = 0; i < 10; i++) {
            System.out.println(Arrays.toString(life.nextGen(myGrid)[i]));
        }
    }
    static void fillGrid(String string, String[][] myGrid) {
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
    public String[][] nextGen(String[][] myGrid) {
        String[][] nextGeneration = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                nextGeneration[i][j] = "+";
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (myGrid[i][j].trim().equals("#") && (neighbors(i,j,myGrid) < 2)) {
                    nextGeneration[i][j] = "+";
                }
                if (myGrid[i][j].trim().equals("#") && (neighbors(i,j,myGrid) ==2 || neighbors(i,j,myGrid) == 3)) {
                    nextGeneration[i][j] = "#";
                }
                if (myGrid[i][j].trim().equals("#") && (neighbors(i,j,myGrid) > 3)) {
                    nextGeneration[i][j] = "+";
                }
                if (myGrid[i][j].trim().equals("+") && (neighbors(i,j,myGrid) == 3)) {
                    nextGeneration[i][j] = "#";
                }
            }
        }
        return nextGeneration;
    }
    static boolean isPath(int i, int j) {
        return (i <= 9 && i >= 0) && (j <= 9 && j >= 0);
    }

    static int neighbors(int i, int j,String[][] myGrid){
        int numberOfNeighbors = 0;
        if (isPath((i-1),(j-1))) {
            if (myGrid[(i-1)][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath(i,(j-1))) {
            if (myGrid[i][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),(j-1))) {
            if (myGrid[(i+1)][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),j)) {
            if (myGrid[(i+1)][j].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),(j+1))) {
            if (myGrid[(i+1)][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath(i,(j+1))) {
            if (myGrid[i][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i-1),(j+1))) {
            if (myGrid[(i-1)][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i-1),j)) {
            if (myGrid[(i-1)][j].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        return numberOfNeighbors;
    }
}
