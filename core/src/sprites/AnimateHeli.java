package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
    public Sprite heliSprite;

    public AnimateHeli(int x, int y){
        position = new Vector3(x,y,0);
        heli = new Texture("heli1.png");
        heliHeight = heli.getHeight();
        heliWidth = heli.getWidth();
        //heli.dispose();
        heliAnimated = new Texture("heliAnimation.PNG");
        texReg = new TextureRegion(heliAnimated);
        heliAnimation = new Animation<>(0.1f,4, texReg);
        //heliSprite = new Sprite(heli);

        rand = new Random();
        SPEED = 30 * rand.nextInt(20) + 1;
        UP = rand.nextBoolean();
        RIGHT = rand.nextBoolean();
        bounds = new Rectangle(position.x, position.y, heli.getWidth(), heli.getHeight());


    }

    public void update (float dt, AnimateHeli h2, AnimateHeli h3){
        //heliAnimation.update();
        bounds.setPosition(position.x, position.y);
        if(bounds.overlaps(h2.bounds) || bounds.overlaps(h3.bounds)){
            UP = !UP;
            RIGHT = !RIGHT;
        }
        moveX(SPEED*dt);
        moveY(SPEED*dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return heli;
    }

    /*public TextureRegion getTexture() {
        return heliAnimation.getKeyFrames();*/

    public void moveX(float speed){
        if(RIGHT){
            position.x += speed;
        }
        else{
            position.x -= speed;
        }
        if(RIGHT && position.x < MyGdxGame.WIDTH - heliWidth){
            RIGHT = false;
        }
        if(!RIGHT && position.x <0 ) {
            RIGHT = true;
        }
    }

    public void moveY(float speed){
      if(UP){
          position.y += speed;
      }
      else{
          position.y -= speed;
      }
      if(UP && position.y > MyGdxGame.HEIGHT - heliHeight){
          UP = false;
      }
      if(!UP && position.y < 0){
          UP = true;
      }
    }


}
