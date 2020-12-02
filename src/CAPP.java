import java.util.ArrayList;

public class CAPP {

    public static void main(String[] args) {
        Viewer viewer;
        FWriter writer;
        FReader reader;
        ArrayList<ArrayList<Integer>> mas = new ArrayList<>();
        String file;
        String file2;

        if (args.length != 4) {
            System.err.println("Please enter arguments -i INPUT_FILE_NAME.txt -o OUTPUT_FILE_NAME.txt");
            System.exit(1);
        }

        file = parseCmdArgs(args).getInputFile();
        file2 = parseCmdArgs(args).getOutputFile();

        reader = new FReader(file);

        mas = reader.readAndFill();

        viewer = new Viewer(mas, reader.getNumOfCols(), reader.getNumOfRows());

        writer = new FWriter(viewer.getRes(), file2);


        System.out.println("input file: "+file);
        System.out.println("the result was written to output file: "+file2);

    }

    public static InputArgs parseCmdArgs(String[] args){
        InputArgs inputArgs = new InputArgs();

        for (int i = 0; i <args.length ; i++){

            switch (args[i]){
                case "-i":
                    i++;
                    if (i > args.length-1){
                        System.err.println("Please enter arguments -i INPUT_FILE_NAME.txt -o OUTPUT_FILE_NAME.txt");
                        System.exit(2);
                    }
                    inputArgs.setInputFile(args[i]);
                    break;
                case "-o":
                    i++;
                    if (i > args.length-1){
                        System.err.println("Please enter arguments -i INPUT_FILE_NAME.txt -o OUTPUT_FILE_NAME.txt");
                        System.exit(2);
                    }
                    inputArgs.setOutputFile(args[i]);
                    break;
                default:

                    break;
            }
        }

        return inputArgs;
    }
}
