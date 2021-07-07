package main.code.chaos.independent;

import arc.func.Cons;
import arc.util.Interval;
import arc.util.Timer;
import main.code.chaos.ChaosSounds;
import mindustry.gen.Bullet;
import mindustry.gen.Groups;
import mindustry.gen.Unit;

import java.util.Random;

public class Hrux {
    public static void load() {
        Random rand = new Random();
        Interval interval = new Interval(1);
        Timer.schedule(() -> {
            for (Unit unit : Groups.unit) {
                class Breakable implements Cons<Bullet> {
                    public boolean stop = false;

                    @Override
                    public void get(Bullet bullet) {
                        float pitch = 0f;
                        if (bullet.team != unit.team) {
                            if (interval.get(0, 60 * 30) && rand.nextInt((100)+1) == 69) {
                                pitch = rand.nextInt((5 - -5) + 1) + -5;
                                ChaosSounds.ohno.play(1f, pitch, 0f);
                            }
                            stop = true;
                        }
                    }
                }

                Breakable intersect = new Breakable();

                Groups.bullet.collide();
                if (intersect.stop) break;
            }
        }, 0f, 0.4f);

    }
}