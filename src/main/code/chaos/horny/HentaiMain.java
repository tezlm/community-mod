package chaos.horny;

//owned by horny part of cumunity

import arc.Events;
import arc.audio.Sound;
import mindustry.game.EventType;
import mindustry.game.Schematic;

import java.util.HashMap;
import java.util.Map;

import static mindustry.Vars.ui;

public class HentaiMain{

    protected static Map<String, Sound> hornySoundsMap = new HashMap<>();
    protected static Map<String, Schematic> hornySchemaMap = new HashMap<>();

    public HentaiMain(){
        if(showHornyConfirm()){
            eventsLoader();
            interfaceOverride();
            loadAssets();
        }
    }
    public void eventsLoader(){
        Events.on(EventType.WorldLoadEvent.class,r->{
            //hornySoundsMap.get("worldLoadEvent").play(1f, 1f, 0f);
        });
        Events.on(EventType.UnitDestroyEvent.class,e->{
            if(e.unit.isPlayer()){
                //hornySoundsMap.get("yamete_kudosai").play(1f, 1f, 0f);
            }else{
                //hornySoundsMap.get("hornyOhNo1").play(1f, 1f, 0f);
            }
        });
    }
    public void interfaceOverride(){
        //some custom interfaces and menus should be there
    }
    public void loadAssets(){
        //coming soon, assets in active search. If you can help with search send any content to misakacha2545@gmail.com or сестрёнка#8227
    }

    private boolean showHornyConfirm(){
        try{
        ui.showConfirm("@confirm", "Is you 18+ older?", () -> {
            throw new RuntimeException("Hentai is confirmed");
        });
        }catch (Exception confirmed){
            return true;
        }
        return false;
    }
}