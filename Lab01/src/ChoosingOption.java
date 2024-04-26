import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket");
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}
// -When user choose "Cancel", the message is "You've chosen: No"
// -To change the option to just only 2 choice, the code need to be:
//  int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?","Message",  JOptionPane.YES_NO_OPTION);
// -To change the option to I do - I don't, the code need to be:
//  String[] options = {"I do", "I don't"};
//  int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);