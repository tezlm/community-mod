const chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".split("");

function random(arr) {
	return arr[Math.round(Math.random() * arr.length)];
}

Events.on(ClientPreConnectEvent, () => {
	let uuid = "";
	for (i = 0; i < 10; i++) uuid += random(chars);
	Core.settings.put("uuid", uuid);
});


require("rtomega-s-nightmare-js");
require("hmmvus");
require("duos");
require("speedreigner");
require("fly-naval");

if(!Vars.headless){
	Events.run(Trigger.update, () => {
		Musics.launch.setVolume(10000000000000000);
	});
}
