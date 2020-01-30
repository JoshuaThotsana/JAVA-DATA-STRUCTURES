public class NextGeneration {

    public String[][] nextGen(String[][] nextGeneration) {
        InputGeneration inputGeneration = new InputGeneration();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (inputGeneration.myGrid[i][j].trim().equals("#") && (neighbors(i,j) < 2)) {
                    nextGeneration[i][j] = "+";
                }
                if (inputGeneration.myGrid[i][j].trim().equals("#") && (neighbors(i,j) ==2 || neighbors(i,j) == 3)) {
                    nextGeneration[i][j] = "#";
                }
                if (inputGeneration.myGrid[i][j].trim().equals("#") && (neighbors(i,j) > 3)) {
                    nextGeneration[i][j] = "+";
                }
                if (inputGeneration.myGrid[i][j].trim().equals("+") && (neighbors(i,j) == 3)) {
                    nextGeneration[i][j] = "#";
                }
            }
        }
        return nextGeneration;
    }
    public boolean isPath(int i, int j) {
        return (i <= 9 && i >= 0) && (j <= 9 && j >= 0);
    }
    public int neighbors(int i, int j){
        InputGeneration inputGeneration = new InputGeneration();
        int numberOfNeighbors = 0;
        if (isPath((i-1),(j-1))) {
            if (inputGeneration.myGrid[(i-1)][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath(i,(j-1))) {
            if (inputGeneration.myGrid[i][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),(j-1))) {
            if (inputGeneration.myGrid[(i+1)][(j-1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),j)) {
            if (inputGeneration.myGrid[(i+1)][j].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i+1),(j+1))) {
            if (inputGeneration.myGrid[(i+1)][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath(i,(j+1))) {
            if (inputGeneration.myGrid[i][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i-1),(j+1))) {
            if (inputGeneration.myGrid[(i-1)][(j+1)].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        if (isPath((i-1),j)) {
            if (inputGeneration.myGrid[(i-1)][j].trim().equals("#")) {
                numberOfNeighbors++;
            }
        }
        return numberOfNeighbors;
    }
}
