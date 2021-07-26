package chaos;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.MusicLoader;
import arc.assets.loaders.SoundLoader;
import arc.audio.Music;
import arc.audio.Sound;
import mindustry.Vars;

public class ChaosMusicLoader {
    protected static Music loadMusic(String musicsName) {
        if (!Vars.headless) {
            String name = "chaosMusics/" + musicsName;
            String path = Vars.tree.get(name + ".mp3").exists() ? name + ".mp3" : name + ".ogg";

            Music music = new Music();

            AssetDescriptor<?> desc = Core.assets.load(path, Music.class, new MusicLoader.MusicParameter(music));
            desc.errored = Throwable::printStackTrace;

            return music;
        } else {
            return new Music();
        }
    }

    public static Music
            doom, crime, corvus, anukian_tomb_full;

    public static void load() {

        crime = loadMusic("crime");
        corvus = loadMusic("corvus");
        s1w1 = loadMusic("doom");
        anukian_tomb_full = loadMusic("anukian_tomb_full");
    }
}

