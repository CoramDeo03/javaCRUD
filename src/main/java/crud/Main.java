package crud;
import crud.word.WordManager;
public class Main {
    public static void main(String[] args) {

        Main myMain = new Main();

        myMain.run(args);
    }

    private void run(String[] args) {
        WordManager wordmanager1 = new WordManager();
        wordmanager1.Menu();
    }
}
