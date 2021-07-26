package chaos;

import arc.audio.Music;
import arc.struct.Seq;

import static chaos.ChaosMusicLoader.*;

public class ChaosMusic {
    public Seq<Music> ambientMusic = Seq.with(crime, anukian_tomb_full);
    public Seq<Music> darkMusic = Seq.with(S1W1);
    public Seq<Music> bossMusic = Seq.with(corvus);
}
