import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class OutputButtonListener extends InputButtonListener {
    File f;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            f = fileopen.getSelectedFile();

            WindowAPP.outButtonPressed();

        }

    }


    public String getOutputFileF() {
        return f.toString();
    }
}