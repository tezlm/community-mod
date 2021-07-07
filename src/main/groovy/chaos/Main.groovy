package chaos

import arc.Events
import mindustry.Vars
import mindustry.ctype.ContentList
import mindustry.game.EventType;
import mindustry.mod.*;

@SuppressWarnings("unused")
class Main extends Mod{
	//load sounds
	public Chaos() {
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
	      
	  }
}
