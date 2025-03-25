package io.github.geometrydash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.geometrydash.level.Level;
import io.github.geometrydash.level.LevelRenderer;

public class Game {
    ShapeRenderer sr;
    LevelRenderer lr;
    Level l;
    Camera c;

    float ground_height = 0f;

    public Game() {
        init();
    }

    private void init() {
        this.sr = new ShapeRenderer();
        this.lr = new LevelRenderer();
        this.l = new Level();
        this.c = new Camera();
    }

    public void process(float dt) {
        c.input();
        render(dt);

    }

    public void render(float dt) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        sr.begin(ShapeRenderer.ShapeType.Filled);

        // render level objects
        sr.setColor(Color.WHITE);
        lr.render_objects(l.get_objects(), sr, c);

        lr.render_ground(ground_height, sr, c);
        sr.end();
    }
}
