package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import giske.mygdx.game.MyGdxGame;
import giske.mygdx.game.states.PlayState;
import sun.util.resources.ms.CalendarData_ms_MY;

public class Ball {
    public Vector3 position;
    public Texture texture;
    private boolean UP, RIGHT = true;
    private Rectangle bounds;
    private int SPEED;

    public Ball(){
        texture = new Texture("ball.png");
        position = new Vector3((MyGdxGame.WIDTH/2), (MyGdxGame.HEIGHT / 2), 0);
        SPEED = 400;
        bounds = new Rectangle(position.x, position.y, 20f, 20f);
    }

    public void update(float dt, PlayState state, LeftPaddle lp, RightPaddle rp){
        bounds.setPosition(position.x, position.y);
        if(bounds.overlaps(lp.bounds) || bounds.overlaps(rp.bounds)){
            RIGHT = !RIGHT;
        }
        moveY(SPEED * dt);
        moveX(SPEED * dt, state);
    }

    public void moveX(float speed, PlayState state){
        if(RIGHT){
            position.x += speed;
        }
        else{
            position.x -= speed;
        }
        if(position.x > MyGdxGame.WIDTH){
            position.x = MyGdxGame.WIDTH / 2;
            position.y = MyGdxGame.HEIGHT / 2;
            RIGHT = false;
            UP = !UP;
            state.incLeftScore();
        }
        if(position.x < 0){
            position.x = MyGdxGame.WIDTH / 2;
            position.y = MyGdxGame.HEIGHT / 2;
            RIGHT = true;
            UP = !UP;
            state.incRightScore();
        }
    }

    public void moveY(float speed){
        if(UP){
            position.y += speed;
        }
        else{
            position.y -= speed;
        }
        if(UP && position.y > MyGdxGame.HEIGHT){
            UP = false;
        }
        if(!UP && position.y < 0){
            UP = true;
        }
    }
}
