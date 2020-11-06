package Scene;

public class RandomSceneFactory implements SceneFactory {

    public RandomSceneFactory() {

       Board board= MapFactory.newSigleMap(50);
       board.generateRandomBoard();
        for (int i = 0; i < board.getBoard().length ; i++) {
            for (int j = 0; j <board.getBoard()[0].length ; j++) {
                if(board.getBoard()[i][j]!=null){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
            System.out.println("\n");
        }
    }
}
