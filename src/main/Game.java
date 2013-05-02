/**
 * Created with IntelliJ IDEA.
 * User: flocl
 * Date: 13-5-2
 * Time: 下午6:40
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private int score = 0;
    private int kicks[] = new int[21];
    private int currentKick = 0;

    public void kick(int pins) {
        kicks[currentKick++] = pins;
    }

    public int getScore() {
        int kickNum = 0;
        for (int frameNum = 0;frameNum < 10; frameNum ++){
            if (isStrike(kickNum)){
                updateScore(kickNum);
                kickNum ++;
                continue;
            }
            if (isSpare(kickNum)){
                updateScore(kickNum);
                kickNum += 2;
                continue;
            }
            score += kicks[kickNum] + kicks[kickNum + 1];
            kickNum += 2;
        }
        return score;
    }

    private void updateScore(int kickNum) {
        score += kicks[kickNum] + kicks[kickNum + 1] + kicks[kickNum + 2];
    }

    private boolean isSpare(int kickNum) {
        return kicks[kickNum] + kicks[kickNum + 1] == 10;
    }

    private boolean isStrike(int kickNum) {
        return kicks[kickNum] == 10;
    }
}
