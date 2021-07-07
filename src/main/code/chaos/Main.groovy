package chaos

import arc.Events
import chaos.horny.HentaiMain
import mindustry.Vars
import mindustry.game.EventType
import mindustry.mod.Mod

@SuppressWarnings("unused")
class Main extends Mod{
	def Chaos() {
		if(Vars.headless) {
			Events.on(EventType.FileTreeInitEvent.class, e -> {
				ChaosSounds.load();
			});
		} else {
			ChaosSounds.load();
		}
	}

	def contentLists = [
			new ChaosBlocks(),
			new ChaosItems(),
			new ChaosLiquids()
	];

	@Override
	void loadContent(){
		contentLists.each{it.load()};
	}

	@Override
	void init(){
		new HentaiMain();
	}
}
