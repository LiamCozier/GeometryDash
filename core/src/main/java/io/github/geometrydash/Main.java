package io.github.geometrydash;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Vector;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private ShapeRenderer sr;
    private Camera c;
    private Texture image;

    @Override
    public void create() {
        sr = new ShapeRenderer();
        c = new Camera();
    }

    @Override
    public void render() {
        c.input();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        sr.begin(ShapeRenderer.ShapeType.Filled);
        Vector2 pos = c.global_to_screen_space(new Vector2(-25, -25));
        sr.rect(pos.x, pos.y, 50, 50);
        sr.end();
    }

    @Override
    public void dispose() {

    }
}
