package Resources.components;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilityMethods {

    public enum DefaultFocus {
        GAINED,
        LOST
    }
    
    public static void TransparentField2(JTextField... fields) {
        for (JTextField f : fields) {
            f.setForeground(new Color(102, 102, 102, 100));
        }
    }

    public static void DefaultText2(JTextField field, String defaultText, DefaultFocus enumFocus) {
        if (enumFocus == DefaultFocus.GAINED) {
            if (field.getText().equals(defaultText)) {
                field.setText("");
                field.setForeground(new Color(51, 51, 51, 255));
            }
        } else if (enumFocus == DefaultFocus.LOST) {
            if (field.getText().equals("")) {
                field.setText(defaultText);
                field.setForeground(new Color(102, 102, 102, 100));
            }
        }
    }
}
