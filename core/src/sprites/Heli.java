package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import java.lang.Math;


import giske.mygdx.game.MyGdxGame;

public class Heli {
    //private static final int GRAVITY = -10;
    private boolean UP = true;
    private static final int SPEED = 200;
    private boolean RIGHT = false;
    private Vector3 position;
    private Vector3 direction;
    public Sprite heliSprite;
    public Texture heli;
    public float inputPosX = 0;
    public float inputPosY = 0;
    private boolean touched = false;
    private BitmapFont font;
    private Rectangle rec;

    public Heli(int x, int y){
        direction = new Vector3(x,y,0);
        position = new Vector3(x,y,0);
        heli = new Texture("heli1.png");
        heliSprite = new Sprite(heli);

    }

    public void update (float dt){
        handleInput();
        if(touched){
            moveX(SPEED * dt);
            moveY(SPEED * dt);
        }
    }

    public void handleInput(){
        if(Gdx.input.justTouched()){
            touched = true;
            inputPosX = Gdx.input.getX();
            inputPosY = (800 - Gdx.input.getY());
            direction.x = Math.abs(inputPosX-position.x);
            direction.y = Math.abs(inputPosY-position.y);
            direction.nor();
            rec = new Rectangle(inputPosX, inputPosY, heli.getWidth()/20, heli.getHeight()/20);

           /* System.out.print(getPosition() + "\n");
            System.out.print("X: " + inputPosX  + "\n");
            System.out.print("Y: " + inputPosY  + "\n");
            System.out.print("direction: " + direction + "\n");*/
            System.out.print(heliSprite.getRegionX());

        }
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return heli;
    }

    public void moveX(float movement){
        if(inputPosX >= position.x){
            position.x += (movement * direction.x);
        }
        else{
            position.x -= (movement * direction.x);
        }
        if(rec.contains(position.x, position.y)){
            touched=false;
        }
        if (position.x > MyGdxGame.WIDTH - heli.getWidth()) {
            touched = false;
            heliSprite.flip(true, false);
        }
        if (position.x < 0) {
            touched = false;
            heliSprite.flip(true, false);
        }

    }

    public void moveY(float movement){
        if(inputPosY > position.y){
            position.y += (movement * direction.y);
        }
        else{
            position.y -= (movement * direction.y);
        }
        if(rec.contains(position.x, position.y)){
            touched=false;
        }
        if (position.y > MyGdxGame.HEIGHT - heli.getHeight()){
            touched = false;
        }
        if (position.y <= 0){
            touched = false;
        }
    }


}
