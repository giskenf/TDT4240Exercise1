package giske.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

import giske.mygdx.game.MyGdxGame;
import sprites.AnimateHeli;
import sprites.Heli;

public class PlayState extends State {
    private Heli heli;
    private BitmapFont font;
    private AnimateHeli heli1, heli2, heli3;
    private Rectangle touch;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        //heli = new Heli(100,100);
        //font = new BitmapFont();

        heli1 = new AnimateHeli(MyGdxGame.WIDTH / 2 + 300, MyGdxGame.HEIGHT / 2);
        heli2 = new AnimateHeli(MyGdxGame.WIDTH / 2, MyGdxGame.HEIGHT / 2);
        heli3 = new AnimateHeli(MyGdxGame.WIDTH / 2 - 300, MyGdxGame.HEIGHT / 2);

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
        heli1.update(dt, heli2, heli3);
        heli2.update(dt, heli1, heli3);
        heli3.update(dt, heli1, heli2);

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        //sb.draw(heli.heliSprite, heli.getPosition().x, heli.getPosition().y);
        //font.draw(sb, heli.getPosition().toString() , 10, 780);
        sb.draw(heli1.getTexture(), heli1.getPosition().x, heli1.getPosition().y);
        sb.draw(heli2.getTexture(), heli2.getPosition().x, heli2.getPosition().y);
        sb.draw(heli3.getTexture(), heli3.getPosition().x, heli3.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {
    }
}
