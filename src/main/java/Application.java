import init.DataInit;
import mainlogic.MainLoop;

public class Application {

    public static void main(String[] args) {

        DataInit.initialize();
        MainLoop.loop();
    }
}
