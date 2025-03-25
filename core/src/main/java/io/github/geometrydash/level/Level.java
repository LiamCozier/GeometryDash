package io.github.geometrydash.level;

import io.github.geometrydash.Vector2;
import io.github.geometrydash.level.objects.*;


public class Level {
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

}
