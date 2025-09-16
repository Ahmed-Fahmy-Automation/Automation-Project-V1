package UI.Base;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileDownloadHelper {

    /**
     * Handles Windows "Save As" dialog by typing the full file path and pressing Save.
     *
     * @param filePath Full path where file should be saved (e.g. "C:\\Downloads\\sampleFile.jpeg")
     */
    public static void handleSaveAs(String filePath) {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(100);

            for (char c : filePath.toCharArray()) {
                switch (c) {
                    case ':':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    case '\\':
                        robot.keyPress(KeyEvent.VK_BACK_SLASH);
                        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
                        break;
                    case '.':
                        robot.keyPress(KeyEvent.VK_PERIOD);
                        robot.keyRelease(KeyEvent.VK_PERIOD);
                        break;
                    case '_':
                        robot.keyPress(KeyEvent.VK_SHIFT);
                        robot.keyPress(KeyEvent.VK_MINUS);
                        robot.keyRelease(KeyEvent.VK_MINUS);
                        robot.keyRelease(KeyEvent.VK_SHIFT);
                        break;
                    default:
                        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
                        if (keyCode == KeyEvent.VK_UNDEFINED) {
                            System.out.println("Cannot type char: " + c);
                            continue;
                        }
                        robot.keyPress(keyCode);
                        robot.keyRelease(keyCode);
                }
            }

            // Press Enter (Save)
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void handleFileUpload(String filePath) {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(500);

            // Copy path to clipboard
            StringSelection selection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

            // Paste (Ctrl+V)
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter (Open)
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}