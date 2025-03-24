package io.github.geometrydash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Camera {
    private Vector2 previous_mouse_pos;
    private Vector2 position;

    public Camera(Vector2 position) {
        this.position = position;
    }

    public Camera() {
        this.position = Vector2.ZERO;
    }

    public Vector2 global_to_screen_space(Vector2 pos) {
        Vector2 screen_centre = new Vector2(
            (float) Gdx.graphics.getWidth() / 2,
            (float) Gdx.graphics.getHeight() / 2
        );

        Vector2 relative_position = Vector2.sub(pos, this.position);

        return Vector2.add(screen_centre, relative_position);
    }


    public void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            if (previous_mouse_pos == null) {
                previous_mouse_pos = new Vector2(Gdx.input.getX(), -Gdx.input.getY());
                return;
            }
            Vector2 mouse_pos = new Vector2(Gdx.input.getX(), -Gdx.input.getY());
            Vector2 mouse_displacement = Vector2.sub(previous_mouse_pos, mouse_pos);
            this.position = Vector2.add(this.position, mouse_displacement);

            previous_mouse_pos = new Vector2(Gdx.input.getX(), -Gdx.input.getY());
        } else {
            previous_mouse_pos = null;
        }

    }
}
