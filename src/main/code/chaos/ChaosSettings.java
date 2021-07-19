package chaos;

import arc.util.*;
import mindustry.gen.Icon;
import mindustry.graphics.Pal;
import mindustry.ui.Links;

import java.util.Arrays;

import static mindustry.Vars.*;

public class ChaosSettings{
    private static final String justAUrlNothingInteresting = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";

    public static void init(){
        if(ios || OS.isMac || steam){
            return;
        }

        Links.LinkEntry[] old = Links.getLinks();
        Links.LinkEntry[] newArr = Arrays.copyOf(old, old.length + 1);
        // swap
        newArr[old.length] = newArr[0];
        newArr[0] = new Links.LinkEntry("community-mod.unlock-all", justAUrlNothingInteresting, Icon.admin, Pal.accent);

        Reflect.set(Links.class, "links", newArr);
    }
}
