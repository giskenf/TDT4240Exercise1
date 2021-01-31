package sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import giske.mygdx.game.MyGdxGame;

public class RightPaddle {
    public Vector3 position;
    public Texture texture;
    private int SPEED, mousePosition;
    public Rectangle bounds;

    public RightPaddle(int x, int y){
        position = new Vector3(x, y, 0);
        texture = new Texture("paddle.png");
        bounds = new Rectangle(position.x, position.y, texture.getWidth(), texture.getHeight());
        SPEED = 10;
    }

    public void update (){
        bounds.setPosition(position.x, position.y);
        System.out.print(position.x + ", " + position.y + "\n");
        if(position.y < 0){
            position.y = 0f;
        }
        if(position.y > MyGdxGame.HEIGHT - texture.getHeight()){
            position.y = MyGdxGame.HEIGHT - texture.getHeight();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            position.y += 20f;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.y -= 20f;
        }

    }
}
