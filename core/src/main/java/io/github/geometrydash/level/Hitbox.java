package io.github.geometrydash.level;

import io.github.geometrydash.Vector2;

public class Hitbox {
    public Vector2 corner1;
    public Vector2 corner2;
    private HitboxType type;

    public Hitbox(Vector2 corner1, Vector2 corner2, HitboxType type) {
        float lesser_x = Math.min(corner1.x, corner2.x);
        float greater_x = Math.max(corner1.x, corner2.x);
        float lesser_y = Math.min(corner1.y, corner2.y);
        float greater_y = Math.max(corner1.y, corner2.y);

        this.corner1 = new Vector2(lesser_x, lesser_y);
        this.corner2 = new Vector2(greater_x, greater_y);

        this.type = type;
    }

    public static boolean is_intersecting(Hitbox a, Hitbox b) {
        return (a.corner1.x <= b.corner2.x &&
                a.corner2.x >= b.corner1.x &&
                a.corner1.y <= b.corner2.y &&
                a.corner2.y >= b.corner1.y
            );
    }

    public HitboxType get_type() {
        return this.type;
    }
}
