package chaos;

import mindustry.mod.*;


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
