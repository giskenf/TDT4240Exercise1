package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import giske.mygdx.game.MyGdxGame;

public class LeftPaddle {
    private Vector3 position;
    private Texture texture;
    private int SPEED, mousePosition;
    private Rectangle bounds;

    public LeftPaddle(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("");
        bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
        SPEED = 20;
    }

    public void update(){
        bounds.setPosition(position.x, position.y);
        if(position.y < 0){
            position.y = 0f;
        }
        if(position.y > MyGdxGame.HEIGHT - texture.getHeight()){
            position.y = MyGdxGame.HEIGHT - texture.getHeight();
        }
        if(Gdx.input.isTouched()){
            mousePosition = MyGdxGame.HEIGHT - Gdx.input.getY();
            if (mousePosition - SPEED > position.y){
                position.y += SPEED;
            }
            else if(mousePosition + SPEED < position.y){
                position.y -= SPEED;
            }
        }
    }

}
