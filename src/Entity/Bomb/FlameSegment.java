package Entity.Bomb;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class FlameSegment {
    public int x, y;
    boolean isLast;
    String type;
    String direction;
    BufferedImage[] image;
    BufferedImage
            explosion_horizontal, explosion_horizontal1, explosion_horizontal2,
            explosion_horizontal_left_last, explosion_horizontal_left_last1, explosion_horizontal_left_last2,
            explosion_horizontal_right_last, explosion_horizontal_right_last1, explosion_horizontal_right_last2,
            explosion_vertical, explosion_vertical1, explosion_vertical2,
            explosion_vertical_down_last, explosion_vertical_down_last1, explosion_vertical_down_last2,
            explosion_vertical_top_last, explosion_vertical_top_last1, explosion_vertical_top_last2;

    public FlameSegment(String type, boolean isLast,String direction) {
        this.isLast = isLast;
        this.type=type;
        this.direction=direction;
        getImage();
        setImage();
    }
    public void getImage() {
        try {
            explosion_horizontal = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal.png"));
            explosion_horizontal1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal1.png"));
            explosion_horizontal2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal2.png"));
            explosion_horizontal_left_last = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_left_last.png"));
            explosion_horizontal_left_last1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_left_last1.png"));
            explosion_horizontal_left_last2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_left_last2.png"));
            explosion_horizontal_right_last = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_right_last.png"));
            explosion_horizontal_right_last1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_right_last1.png"));
            explosion_horizontal_right_last2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_horizontal_right_last2.png"));
            explosion_vertical = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical.png"));
            explosion_vertical1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical1.png"));
            explosion_vertical2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical2.png"));
            explosion_vertical_down_last = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_down_last.png"));
            explosion_vertical_down_last1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_down_last1.png"));
            explosion_vertical_down_last2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_down_last2.png"));
            explosion_vertical_top_last = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_top_last.png"));
            explosion_vertical_top_last1 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_top_last1.png"));
            explosion_vertical_top_last2 = ImageIO.read(getClass().getResourceAsStream("/flame/explosion_vertical_top_last2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setImage() {
        image=new BufferedImage[3];
        if(Objects.equals(type, "vertical")) {
            if(!isLast) {
                image[0]=explosion_vertical;
                image[1]=explosion_vertical1;
                image[2]=explosion_vertical2;
            }
            else{
                if(Objects.equals(direction, "up")) {
                    image[0]=explosion_vertical_top_last;
                    image[1]=explosion_vertical_top_last;
                    image[2]=explosion_vertical_top_last;
                }
                if(Objects.equals(direction, "down")) {
                    image[0]=explosion_vertical_down_last;
                    image[1]=explosion_vertical_down_last;
                    image[2]=explosion_vertical_down_last;
                }

            }
        }
        if(Objects.equals(type, "horizontal")) {
            if(!isLast) {
                image[0]=explosion_horizontal;
                image[1]=explosion_horizontal1;
                image[2]=explosion_horizontal2;
            }else{
                if(Objects.equals(direction, "left")) {
                    image[0]=explosion_horizontal_left_last;
                    image[1]=explosion_horizontal_left_last1;
                    image[2]=explosion_horizontal_left_last2;
                }
                if(Objects.equals(direction, "right")) {
                    image[0]=explosion_horizontal_right_last;
                    image[1]=explosion_horizontal_right_last1;
                    image[2]=explosion_horizontal_right_last2;
                }
            }
        }
    }
}
