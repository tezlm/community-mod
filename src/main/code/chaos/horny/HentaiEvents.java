package chaos.horny;

import arc.Events;
import mindustry.game.EventType;

public class HentaiEvents {
    public HentaiEvents(){
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
}
