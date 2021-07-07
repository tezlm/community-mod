package chaos

import arc.Events
import mindustry.Vars
import mindustry.game.EventType;
import mindustry.mod.*;

@SuppressWarnings("unused")
class Main extends Mod{

	//loading custom sounds
	chaos() {
		if(Vars.headless) {
			Events.on(EventType.FileTreeInitEvent.class, e -> {
				Sounds.load();
			});
		} else {
			Sounds.load();
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
	      
	  }
}
