package io.github.geometrydash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.level.Level;
import io.github.geometrydash.level.LevelRenderer;

public class Game {
    ShapeRenderer sr;
    LevelRenderer lr;
    Level l;
    Camera c;
    Player p;

    float ground_height = 0f;

    public Game() {
        init();
    }

    private void init() {
        this.sr = new ShapeRenderer();
        this.lr = new LevelRenderer();
        this.l = new Level();
        this.c = new Camera();
        this.p = new Player(Vector2.ZERO);
    }

    public void process(float dt) {
        take_input();
        p.move_and_collide(dt, l.get_objects());
        render(dt);
    }

    public void take_input() {
        c.input();
        p.input();
    }

    public void render(float dt) {
        lr.render_background(l.get_background_color());
        sr.begin(ShapeRenderer.ShapeType.Filled);

        lr.render_ground(ground_height, l.get_ground_color(), sr, c);

        sr.setColor(Color.WHITE);
        lr.render_objects(l.get_objects(), sr, c);

        p.render(sr, c);
        sr.end();

        sr.begin(ShapeRenderer.ShapeType.Line);
        lr.render_hitboxes(l.get_objects(), sr, c);
        sr.end();
    }
}
