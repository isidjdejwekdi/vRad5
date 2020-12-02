import java.io.*;
import java.util.ArrayList;

public class FWriter {
    private String outPutFile;

    public FWriter(int result, String outPutFile) {
        this.outPutFile = outPutFile;
        writeResult(result);
    }

    public FWriter(String outPutFile){
        this.outPutFile = outPutFile;
    }

    public void writeResult (int result){

        try (final FileWriter writer = new FileWriter(outPutFile, false)) {

            writer.write(Integer.toString(result));

        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveResult(Integer[][] array, int result){

        int numOfRows = WindowAPP.getReader().getNumOfRows();
        int numOfCols = WindowAPP.getReader().getNumOfCols();

        try (final FileWriter writer = new FileWriter(outPutFile, false)){
            if (array != null) {
                for (int i = 0; i < numOfRows; i++) {
                    for (int j = 0; j < numOfCols/*5*/ ; j++) {

                        if (array[i][j]==null)
                            if(j ==numOfCols-1){
                                writer.write(32);
                            } else {
                                writer.write(32);
                                writer.write(32);
                            }

                        else {
                            writer.write(Integer.toString(array[i][j]));
                            if (j != numOfCols - 1)
                                writer.write(32);
                        }
                    }
                    writer.write(13);
                    writer.write(10);
                }
            }

            writer.write(13);
            writer.write(10);
            writer.write("("+Integer.toString(result)+")");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
