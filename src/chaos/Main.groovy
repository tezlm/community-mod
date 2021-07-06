package chaos;

import mindustry.mod.*;

@SuppressWarnings("unused")
class Main extends Mod{
    def contentLists = [
        // ...
    ];
    
    @Override
    void loadContent(){
        contentLists.each{it.load()};
    }
    
    @Override
    void init(){
        
    }
}
