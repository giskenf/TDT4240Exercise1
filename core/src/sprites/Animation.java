package sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.List;

class Animation{
    public List<TextureRegion> frames = new ArrayList<>();
    private float maxFrameTime;
    private int frameCount, frame;
    private int frameWidth;
    private float currentFrameTime;
    private TextureRegion texReg;

    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frameWidth = region.getRegionWidth() / frameCount;
        currentFrameTime = 0f;
        frame = 0;

        for (int i = 0; i < frameCount; i++) {
            texReg = new TextureRegion(region, i * region.getRegionWidth(), 0, frameWidth, region.getRegionHeight());
            frames.add(texReg);
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
            frame++;
            currentFrameTime = 0f;
        }
        if (frame >= frameCount) {
            frame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }

}