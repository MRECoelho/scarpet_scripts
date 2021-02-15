// This script enables transforming mycelium into grass blocks by
// using a grass or tall grass item on a mycelium block.

///Right click on a mycelium block to transform it.

// stay loaded
__config() -> (m(
  l('stay_loaded','true')
));


__on_player_right_clicks_block(player, item_tuple, hand, block, face, hitvec) -> (
	if(block!=block('mycelium'), return());
	if(item_tuple:0!='grass' && item_tuple:0!='tall_grass', return());
	bpos = pos(block);
	if(hand=='offhand', slot=-1,slot = player~'selected_slot');
	schedule(0, '_mycelium2grass',bpos, slot);
);



_mycelium2grass(pos,slot)-> (
	set(pos, 'grass_block');
	);
