package Entity.Bomb;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Flame {
    public int frameCounter = 0;
    public int flameNum = 0;
    GamePanel gp;
    List<FlameSegment> upFlame = new ArrayList<>();
    List<FlameSegment> downFlame = new ArrayList<>();
    List<FlameSegment> leftFlame = new ArrayList<>();
    List<FlameSegment> rightFlame = new ArrayList<>();
    public int maxFlameSize = 4;
    public int maxUpSize = maxFlameSize,
            maxDownSize = maxFlameSize,
            maxLeftSize = maxFlameSize,
            maxRightSize = maxFlameSize;

    public Flame(GamePanel gp) {
        this.gp = gp;
    }


    public void creatFlameSegment() {
        for (int i = 0; i < maxFlameSize; i++) {
            upFlame.add(new FlameSegment("vertical", false, "up"));
            downFlame.add(new FlameSegment("vertical", false, "down"));
            leftFlame.add(new FlameSegment("horizontal", false, "left"));
            rightFlame.add(new FlameSegment("horizontal", false, "right"));
        }
        if (maxUpSize > 0) {
            upFlame.get(maxUpSize - 1).isLast = true;
        }
        if (maxDownSize > 0) {
            downFlame.get(maxDownSize - 1).isLast = true;
        }
        if (maxLeftSize > 0) {
            leftFlame.get(maxLeftSize - 1).isLast = true;
        }
        if (maxRightSize > 0) {
            upFlame.get(maxRightSize - 1).isLast = true;
        }
    }

    public void InitFlame(int flameX, int flameY) {
        for (int i = 0; i < maxUpSize; i++) {
            upFlame.get(i).x = flameX;
            upFlame.get(i).y = flameY - i * gp.tileSize;
        }
        for (int i = 0; i < maxDownSize; i++) {
            downFlame.get(i).x = flameX;
            downFlame.get(i).y = flameY + i * gp.tileSize;
        }
        for (int i = 0; i < maxLeftSize; i++) {
            leftFlame.get(i).x = flameX - i * gp.tileSize;
            leftFlame.get(i).y = flameY;
        }
        for (int i = 0; i < maxRightSize; i++) {
            rightFlame.get(i).x = flameX + i * gp.tileSize;
            rightFlame.get(i).y = flameY;
        }

    }

    public void update() {
        frameCounter++;
        if (frameCounter > 20) {
            flameNum++;
            frameCounter = 0;
            if (flameNum > 3) {
                flameNum = 0;
            }
        }
    }


    public void draw(Graphics2D g2) {
        for (int i = 0; i < upFlame.size(); i++) {
            g2.drawImage(upFlame.get(i).image[flameNum], upFlame.get(i).x, upFlame.get(i).y, gp.tileSize, gp.tileSize, null);
        }
        for (int i = 0; i < downFlame.size(); i++) {
            g2.drawImage(downFlame.get(i).image[flameNum], downFlame.get(i).x, downFlame.get(i).y, gp.tileSize, gp.tileSize, null);
        }
        for (int i = 0; i < leftFlame.size(); i++) {
            g2.drawImage(leftFlame.get(i).image[flameNum], leftFlame.get(i).x, leftFlame.get(i).y, gp.tileSize, gp.tileSize, null);
        }
        for (int i = 0; i < rightFlame.size(); i++) {
            g2.drawImage(rightFlame.get(i).image[flameNum], rightFlame.get(i).x, rightFlame.get(i).y, gp.tileSize, gp.tileSize, null);
        }
    }
}
