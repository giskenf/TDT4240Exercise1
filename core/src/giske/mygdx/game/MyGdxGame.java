package giske.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import giske.mygdx.game.states.GameStateManager;
//import giske.mygdx.game.states.MenuState;
import giske.mygdx.game.states.PlayState;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	public static final String TITLE = "Sprites";
	private GameStateManager gsm;
	private SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		//img = new Texture("heli1.png");
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new PlayState(gsm));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);

		/*batch.begin();
		batch.draw(img, 5, 7);
		batch.draw(img, 100,120);
		batch.end();*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
