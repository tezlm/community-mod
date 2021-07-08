package chaos;

import arc.audio.Music;
import arc.struct.Seq;

import static chaos.ChaosMusicLoader.crime;

public class ChaosMusic {
    public Seq<Music> ambientMusic = Seq.with(crime);
    public Seq<Music> darkMusic = Seq.with();
    public Seq<Music> bossMusic = Seq.with();
}
