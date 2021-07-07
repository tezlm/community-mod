package chaos;

import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class ChaosLiquids implements ContentList {
    public static Liquid someLiquid;

    @Override
    public void load() {
        someLiquid = new Liquid("some-liquid");
    }
}
