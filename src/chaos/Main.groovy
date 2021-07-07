package chaos

import mindustry.ctype.ContentList;
import mindustry.mod.*;

@SuppressWarnings("unused")
class Main extends Mod{
    ArrayList<ContentList> contentLists = [
            ChaosBlocks,
            ChaosItems,
            ChaosLiquids
    ];
    
    @Override
    void loadContent(){
        contentLists.each(ContentList::load);
    }
    
    @Override
    void init(){
        
    }
}
