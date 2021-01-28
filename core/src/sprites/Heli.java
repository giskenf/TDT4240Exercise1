package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import giske.mygdx.game.MyGdxGame;

public class Heli {
    //private static final int GRAVITY = -10;
    private boolean UP = true;
    private static final int SPEED = 200;
    private boolean RIGHT = false;
    private Vector3 position;
    private Vector3 velocity;
    public Sprite heliSprite;
    public Texture heli;
    public float inputPosX = 0;
    public float inputPosY = 0;

    public Heli(int x, int y){
        velocity = new Vector3(x,y,0);
        position = new Vector3(x,y,0);
        heli = new Texture("heli1.png");
        heliSprite = new Sprite(heli);

    }

    public void update (float dt){
        handleInput();
        moveX(SPEED * dt);
        moveY(SPEED * dt);
    }

    public void handleInput(){
        if(Gdx.input.justTouched()){
            position.x = Gdx.input.getX();
            position.y = 800 - Gdx.input.getY();
            System.out.print(getPosition() + "\n");
            System.out.print(Gdx.input.getX()  + "\n");
            System.out.print(Gdx.input.getY()  + "\n");

        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return heli;
    }

    public void moveX(float movement){
        if (RIGHT) {
            position.x += movement ;
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

    public void touchMove(float inputX, float inputY){

    }

}
