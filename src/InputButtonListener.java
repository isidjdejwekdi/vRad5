import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Reader;
import java.util.ArrayList;

class InputButtonListener implements ActionListener {
    File f;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            f = fileopen.getSelectedFile();

            WindowAPP.inputButtonPressed();

        }
    }

    public String getInputFile() {
        return f.toString();
    }

}