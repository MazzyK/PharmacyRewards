import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(final String[] args)  {

        DbHelper.getInstance().init();
        DbHelper.getInstance().registerShutdownHook();

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                System.out.println("Starting Application");
                final Application app = new Application();
                app.setTitle("PharmacyRewardsScheme");
                app.setSize(800,600);
                app.setLocationRelativeTo(null);
                app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                app.setVisible(true);


            }
        });

    }
}
