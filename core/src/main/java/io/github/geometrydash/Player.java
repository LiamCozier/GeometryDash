package io.github.geometrydash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.geometrydash.level.objects.LevelObject;

public class Player {
    private final Vector2 gravity = new Vector2(0, -75f);

    private Vector2 grid_position;
    private Vector2 grid_velocity;

    public Player(Vector2 position) {
        this.grid_position = position;
        this.grid_velocity = Vector2.ZERO;
    }

    public void move_and_collide(float dt, LevelObject[] objects) {

        // apply gravity
        Vector2 delta_acceleration = Vector2.mul(gravity, dt);
        grid_velocity = Vector2.add(this.grid_velocity, delta_acceleration);

        // update position by adding velocity
        Vector2 delta_displacement = Vector2.mul(grid_velocity, dt);
        grid_position = Vector2.add(this.grid_position, delta_displacement);

        // ground collision
        if (grid_position.y<0) {
            grid_position.y = 0;
            grid_velocity.y = 0;
        }

        for (LevelObject o: objects) {

        }
    }

    public void input() {
        grid_velocity.x = 0f;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            grid_velocity.x = 7.5f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            grid_velocity.x = -7.5f;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            grid_velocity.y = 20f;
        }
    }

    public void render(ShapeRenderer sr, Camera c) {
        Vector2 world_pos = Vector2.mul(grid_position, 64);
        Vector2 screen_pos = c.global_to_screen_space(world_pos);

        sr.setColor(Color.CYAN);
        sr.rect(screen_pos.x, screen_pos.y, 64, 64);
    }




}
