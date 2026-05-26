import view.menu.MainMenuView;
import view.user.UserLoginFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainMenuView().setVisible(true);
            }
        });
    }

}