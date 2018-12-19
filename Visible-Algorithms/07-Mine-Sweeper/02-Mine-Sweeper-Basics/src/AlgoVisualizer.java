import java.awt.*;

public class AlgoVisualizer {

    private static int DELAY = 5;
    private static int blockSide = 32;

    private MineSweeperData data;
    private AlgoFrame frame;

    public AlgoVisualizer(int N, int M, int mineNumber){

        data = new MineSweeperData(N, M, mineNumber);
        int sceneWidth = M * blockSide;
        int sceneHeight = N * blockSide;

        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Mine Sweeper", sceneWidth,sceneHeight);

            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run(){

        setData();
    }

    private void setData(){
        frame.render(data);
        AlgoVisHelper.pause(DELAY);
    }

    public static void main(String[] args) {

        int N = 20;
        int M = 20;
        int mineNumber = 1;

        AlgoVisualizer vis = new AlgoVisualizer(N, M, mineNumber);

    }
}
