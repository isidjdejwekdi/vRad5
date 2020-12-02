import java.io.*;
import java.util.ArrayList;

public  class FReader {
    private String inputFile;
    private int numOfCols;
    private int numOfRows;

    public FReader(String inputFile) {
        this.inputFile = inputFile;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    private void setNumOfCols(int numOfCols) {
        this.numOfCols = numOfCols;
    }

    private void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }

    public ArrayList<ArrayList<Integer>> readAndFill (){
        ArrayList<ArrayList<Integer>> mas = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        BufferedReader br;
        int byteRead =0;
        int empties =0;

        try {
            br = new BufferedReader(new FileReader(inputFile));

            while (byteRead!=-1){//запись в массив
                byteRead=br.read();
                if (byteRead!=-1){

                    switch(byteRead) {
                        case 49: //1
                            row.add(1);
                            empties = 0;
                            break;
                        case 48: //0
                            row.add(0);
                            empties = 0;
                            break;
                        case 13: // \r
                            mas.add(row);
                            empties = 0;
                            break;
                        case 10: // \n
                            row = new ArrayList<>();
                            break;
                        case 32:
                            //row.add(null);
                            empties++;
                            br.mark(1);
                            int b = br.read();

                            if (empties > 1 || (empties ==1 && b==13)) {
                                row.add(null);
                                empties = 0;
                            }

                            br.reset();
                            break;
                        default:

                            break;
                    }

                }
            }
            mas.add(row);
            br.close();

            setNumOfRows(mas.size());
            setNumOfCols(mas.get(0).size());

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return mas;
    }
}
