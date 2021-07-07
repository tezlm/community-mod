package chaos

import mindustry.ctype.ContentList
import mindustry.type.Item

class ChaosItems : ContentList {
    companion object {
        lateinit var someItem: Item
    }

    override fun load() {
        someItem = Item("some-item")
    }
}