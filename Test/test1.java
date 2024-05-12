import java.io.*;
import java.util.*;

public class test1 {
   public static int[] findTiniest(int[][] var){
        int everyV = var.length;
        int tiny = Integer.MAX_VALUE;
        int[] stash = new int[2];
        
        for(int i = 0; i < everyV; i++){
            for(int j = 0; j < everyV; j++){
                if (var[i][j] < tiny){
                tiny = var[i][j];
                stash[0] = i;
                stash[1] = j;
                }
            }
        }
        return stash;
    }
    
    public static boolean requireSpread(int row, int column, int tSize){
        return row >= 0 && row < tSize && column >= 0 && column < tSize;
    }
    
    public static int[][] spreadVal (int[][]var, int[]stash){
        int result = var[stash[0]][stash[1]];
        int[][] movements = {{-1, 0}, {1, 0},{0, -1}, {0,1}};
        for(int[] movement : movements){
            int spreadRow = stash[0] + movement[0];
            int spreadCol = stash[1] + movement[1];
            if(requireSpread(spreadRow, spreadCol, var.length)){
                var[spreadRow][spreadCol] = result;
            }
        }
        return var;
    }

    public static double[][] spreadZeroValue(int[][] array, int[] stash) {
        int rows = array.length;
        int cols = array[0].length;
        double[][] spreadArray = new double[rows][cols];

        // Spread values in the array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double up = (i == 0) ? array[rows - 1][j] : array[i - 1][j];
                double down = (i == rows - 1) ? array[0][j] : array[i + 1][j];
                double left = (j == 0) ? array[i][cols - 1] : array[i][j - 1];
                double right = (j == cols - 1) ? array[i][0] : array[i][j + 1];

                // Spread values by averaging the neighboring values
                spreadArray[i][j] = (up + down + left + right) / 4.0;
            }
        }
        return spreadArray;
    }

    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new FileReader("squarea.txt"));
        PrintWriter outFile = new PrintWriter("output.txt");
        
        int tableSize = inFile.nextInt();
        int[][] rowColumn = new int[tableSize][tableSize];
        
        for(int i = 0; i < tableSize && inFile.hasNextInt(); i++){
            for(int j = 0; inFile.hasNextInt() && j < rowColumn[0].length; j++){
                rowColumn[i][j] = inFile.nextInt();
            }
        }
        
        for(int i = 0; i < rowColumn.length; i++){
            for(int k = 0; k < rowColumn.length; k++){
                outFile.printf("-----");
            }
            outFile.println();
            for(int j = 0; j < rowColumn.length; j++){
                outFile.printf("| %02d ", rowColumn[i][j]);
            }
            outFile.println();
        }
        
        outFile.println();
        
        int[] smallAf = findTiniest(rowColumn);
        
        for (int i = 0; i < 2; i++) {
            spreadVal(rowColumn, smallAf);
        }
        
        rowColumn[smallAf[0]][smallAf[1]] = 0;

        for(int i = 0; i < rowColumn.length; i++){
            for(int k = 0; k < rowColumn.length; k++){
                outFile.printf("-----");
            }
            outFile.println();
            for(int j = 0; j < rowColumn.length; j++){
                outFile.printf("| %02d ", rowColumn[i][j]);
            }
            outFile.println();
        }

        outFile.println();
        
        for (int i = 0; i < 2; i++) {
            rowColumn[smallAf[0]][smallAf[1]] = 0;
            spreadVal(rowColumn, smallAf);
        }

        for(int i = 0; i < rowColumn.length; i++){
            for(int k = 0; k < rowColumn.length; k++){
                outFile.printf("-----");
            }
            outFile.println();
            for(int j = 0; j < rowColumn.length; j++){
                outFile.printf("| %02d ", rowColumn[i][j]);
            }
            outFile.println();
        }
        
        inFile.close();
        outFile.close();
     }
}