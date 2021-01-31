package giske.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.MediaTracker;
import java.awt.Rectangle;

import giske.mygdx.game.MyGdxGame;
import sprites.AnimateHeli;
import sprites.Ball;
import sprites.Heli;
import sprites.LeftPaddle;
import sprites.RightPaddle;

public class PlayState extends State {
    private BitmapFont font;
    private Rectangle touch;
    private LeftPaddle leftPaddle;
    private RightPaddle rightPaddle;
    private Ball ball;
    private int scoreLeft, scoreRight = 0;
    private String winnerStr = "";


    public PlayState(GameStateManager gsm) {
        super(gsm);
        leftPaddle = new LeftPaddle(50, 30);
        rightPaddle = new RightPaddle(430, 30);
        ball = new Ball();
        font = new BitmapFont();
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            touch = new Rectangle(Gdx.input.getX(), (MyGdxGame.HEIGHT - Gdx.input.getY()), 1, 1);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        leftPaddle.update();
        rightPaddle.update();
        ball.update(dt, this, leftPaddle, rightPaddle);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        if(winnerStr != ""){
            font.draw(sb, winnerStr, 300f, MyGdxGame.HEIGHT / 2 + 100);
        }
        else{
            sb.draw(rightPaddle.texture, rightPaddle.position.x, rightPaddle.position.y);
            sb.draw(leftPaddle.texture, leftPaddle.position.x, leftPaddle.position.y);
            sb.draw(ball.texture, ball.position.x, ball.position.y,20f,20f );
            font.draw(sb, "Score left : Score right", MyGdxGame.WIDTH / 2 -100, MyGdxGame.HEIGHT-50);
        }
        sb.end();
    }

    public void incRightScore(){
        scoreRight ++;
        if(scoreRight >= 21){
            winnerStr = "Right player wins!";
        }
    }

    public void incLeftScore(){
        scoreLeft ++;
        if(scoreLeft >= 21){
            winnerStr = "Left player wins!";
        }
    }

    @Override
    public void dispose() {
    }
}
