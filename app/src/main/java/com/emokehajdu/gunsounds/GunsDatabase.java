package com.emokehajdu.gunsounds;

import java.util.ArrayList;
import java.util.List;

public class GunsDatabase {

    private List<Gun> guns = new ArrayList<>();
    private static GunsDatabase instance = new GunsDatabase();

    public List<Gun> getGuns() {
        return guns;
    }

    public static GunsDatabase getInstance() {
        return instance;
    }

    private GunsDatabase() {
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(null);
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));
        guns.add(new Gun("Gun 640", R.drawable.gun_2535417_640, R.raw.laser));
        guns.add(new Gun("Kalashnikov", R.drawable.kalasnikow, R.raw.plasma));

    }
}
