package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MoveButton {
    private Vector3 position;
    private Texture texture;
    private int SPEED, mousePosition;
    private Rectangle bounds;

    public MoveButton(int x, int y, String texturePath){
        texture = new Texture(texturePath);
        position = new Vector3(x,y, 0);
        bounds = new Rectangle(position.x, position.y, 100f, 100f);
    }

    public void dispose(){
        texture.dispose();
    }
}
