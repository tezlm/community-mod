package chaos;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import mindustry.Vars;

public class ChaosSounds {
    protected static Sound loadSound(String soundsName) {
        if (!Vars.headless) {
            String name = "chaosSounds/" + soundsName;
            String path = Vars.tree.get(name + ".mp3").exists() ? name + ".mp3" : name + ".ogg";

            Sound sound = new Sound();

            AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
            desc.errored = Throwable::printStackTrace;

            return sound;
        } else {
            return new Sound();
        }
    }

    public static Sound
            ohno;

    public static void load() {

        ohno = loadSound("ohno");
    }
}

