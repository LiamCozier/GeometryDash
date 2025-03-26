package io.github.geometrydash.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import io.github.geometrydash.Camera;
import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.objects.LevelObject;

public class LevelRenderer {

    public LevelRenderer() {}

    public void render_ground(float ground_height, Color ground_colour, ShapeRenderer sr, Camera c) {
        float half_height = (float) Gdx.graphics.getHeight() / 2;
        Vector2 floor_centre = new Vector2(0, ground_height);
        float floor_screen_height = c.global_to_screen_space(floor_centre).y;
        if (floor_screen_height >= -half_height) {
            sr.setColor(ground_colour);
            sr.rect(0, 0 ,Gdx.graphics.getWidth(), floor_screen_height);
        }
    }

    public void render_background(Color background_colour) {
        ScreenUtils.clear(background_colour);
    }

    public void render_objects(LevelObject[] objects, ShapeRenderer sr, Camera c) {
        for (LevelObject o : objects) {
            Vector2 render_pos = Vector2.mul(o.get_position(), 64);
            render_pos = c.global_to_screen_space(render_pos);

            o.render(render_pos, sr);
        }
    }

    public void render_hitboxes(LevelObject[] objects, ShapeRenderer sr, Camera c) {
        for (LevelObject o : objects) {

            Hitbox h = o.get_hitbox();
            Vector2 corner1 = Vector2.mul(h.corner1, 64);
            Vector2 corner2 = Vector2.mul(h.corner2, 64);

            corner1 = c.global_to_screen_space(corner1);
            corner2 = c.global_to_screen_space(corner2);

            switch (o.get_hitbox().get_type()) {
                case COLLIDE:
                    sr.setColor(Color.LIME);
                    break;
                case HAZARD:
                    sr.setColor(Color.RED);
                    break;
                default:
                    sr.setColor(Color.BLUE);
                    break;
            }

            sr.rect(corner1.x, corner1.y, corner2.x-corner1.x, corner2.y-corner1.y);
        }
    }

}
