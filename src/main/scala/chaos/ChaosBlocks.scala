package chaos

import mindustry.ctype.ContentList
import mindustry.world.Block

class ChaosBlocks extends ContentList {
  var conveyor: Option[Block] = None

  override def load(): Unit = {
    conveyor = Some(new Block("chaotic-conveyor"))
  }
}