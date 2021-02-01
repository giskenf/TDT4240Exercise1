package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import java.util.Random;
import giske.mygdx.game.MyGdxGame;

public class AnimateHeli {
    public Animation heliAnimation;
    private Rectangle bounds;
    private Vector3 position;
    private boolean UP;
    private int SPEED;
    private boolean RIGHT;
    private float heliWidth;
    private float heliHeight;
    private Texture heli;
    private Texture heliAnimated;
    private TextureRegion texReg;
    private Random rand;
    private Sprite heliSprite;

    public AnimateHeli(int x, int y){
        position = new Vector3(x,y,0);
        heli = new Texture("heli1.png");
        heli.dispose();
        heliAnimated = new Texture("heliAnimation.png");
        texReg = new TextureRegion(heliAnimated);
        heliAnimation = new Animation(texReg, 4, 0.1f);

        rand = new Random();
        SPEED = 20 * rand.nextInt(20) + 1;
        UP = rand.nextBoolean();
        RIGHT = rand.nextBoolean();
        bounds = new Rectangle(position.x, position.y, heli.getWidth(), heli.getHeight());

        heliSprite = new Sprite(texReg);
    }

    public void update (float dt, AnimateHeli h2, AnimateHeli h3){
        heliAnimation.update(dt);
        bounds.setPosition(position.x, position.y);
        if(bounds.overlaps(h2.bounds) || bounds.overlaps(h3.bounds)){
            UP = !UP;
            RIGHT = !RIGHT;
        }
        moveY(SPEED*dt);
        moveX(SPEED*dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return heliAnimation.getFrame();
    }

    public void moveX(float movement){
        if (RIGHT) {
            position.x += movement;
        } else {
            position.x -= movement;

        }
        if (RIGHT && position.x > MyGdxGame.WIDTH - heli.getWidth()) {
            RIGHT = false;
            heliSprite.flip(true, false);

        }
        if (!RIGHT && position.x < 0) {
            RIGHT = true;
            heliSprite.flip(true, false);
        }
    }

    public void moveY(float movement){
        if(UP){
            position.y += movement;
        } else {
            position.y -= movement;
        }
        if (UP && position.y > MyGdxGame.HEIGHT - heli.getHeight()){
            UP = false;
        }
        if (!UP && position.y <= 0){
            UP = true;
        }
    }


}
