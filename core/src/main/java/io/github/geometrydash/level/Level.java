package io.github.geometrydash.level;

import com.badlogic.gdx.graphics.Color;
import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.objects.*;


public class Level {
    private Color background_color = new Color(0.15f, 0.15f, 0.4f, 1f);
    private Color ground_color = new Color(0.2f, 0.2f, 0.6f, 1f);

    private LevelObject[] object_array = new LevelObject[5];

    public Level() {
        object_array[0] = new SquareObject(new Vector2(1, 0));
        object_array[1] = new SquareObject(new Vector2(2, 0));
        object_array[2] = new SquareObject(new Vector2(3, 0));
        object_array[3] = new SquareObject(new Vector2(3, 1));
        object_array[4] = new SpikeObject(new Vector2(5, 0));
    }

    public LevelObject[] get_objects() {
        LevelObject[] temp = new LevelObject[object_array.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            LevelObject o = object_array[i];
            if (o != null) {
                temp[i] = o;
            }
        }
        return temp;
    }

    public Color get_ground_color() {
        return ground_color;
    }

    public void set_ground_color(Color ground_color) {
        this.ground_color = ground_color;
    }

    public Color get_background_color() {
        return background_color;
    }

    public void set_background_color(Color background_color) {
        this.background_color = background_color;
    }
}
