import java.util.ArrayList;

public class WindowAPP {
    private static GUI gui;

    private static InputButtonListener inputButtonListener = new InputButtonListener();
    private static OutputButtonListener outputButtonListener = new OutputButtonListener();
    private static FReader reader = null;
    private static Viewer viewer = null;


    public static void main(String[] args) {

        gui = new GUI(inputButtonListener, outputButtonListener);
    }

    public static void inputButtonPressed() {//читаем из файла в массив

        ArrayList<ArrayList<Integer>> mas;

        String file = inputButtonListener.getInputFile();

        reader = new FReader(file);
        mas = reader.readAndFill();

        viewer = new Viewer(mas, reader.getNumOfCols(), reader.getNumOfRows());

        Integer[][] mas2 = fillTheMasFromArrayList(mas, reader.getNumOfRows(), reader.getNumOfCols());

        gui.setJTable(inputButtonListener, outputButtonListener, mas2);//пишем из массива в jTable

    }

    public static void outButtonPressed() {//пишем в файл из массива
        Integer[][] array = readFromTable();

        String file2 = outputButtonListener.getOutputFileF();

        FWriter writer = new FWriter(file2);
        writer.saveResult(array, viewer.getRes());

    }

    public static Integer[][] readFromTable(){//пишем в массив из jTable
        int numOfRows = reader.getNumOfRows();
        int numOfCols = reader.getNumOfCols();
        Integer[][] array = new Integer[numOfRows][numOfCols];
        Object b;
        String s = "";

        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols; j++) {

                b = gui.getTable().getValueAt(i,j);
                if (b == null)
                    array[i][j] = null;
                else
                    if (b.getClass().isInstance(s)){//если ячейка в таблице была изменена - она типа String, если нет - Integer
                        s = (String)b;
                        array[i][j] = Integer.parseInt (s.trim ());
                        s = "";
                    } else {
                        array[i][j] = (Integer) b;
                    }


            }

        }
        return array;
    }

    public static Integer[][] fillTheMasFromArrayList(ArrayList<ArrayList<Integer>> mas, int numOfRows, int numOfCols){
        Integer[][] mas2 = new Integer[numOfRows][numOfCols];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfCols/*5*/ ; j++) {

                mas2[i][j] = mas.get(i).get(j);
            }

        }
        return mas2;
    }

    public static FReader getReader() {
        return reader;
    }
}
