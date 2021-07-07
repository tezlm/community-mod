package chaos

import mindustry.mod.*;

@SuppressWarnings("unused")
class Main extends Mod{
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
