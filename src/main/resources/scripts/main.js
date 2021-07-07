const chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".split("");

function random(arr) {
	return arr[Math.round(Math.random() * arr.length)];
}

Events.on(ClientPreConnectEvent, () => {
	let uuid = "";
	for (i = 0; i < 10; i++) uuid += random(chars);
	Core.settings.put("uuid", uuid);
});

require("hmmvus");
require("duos");
require("speedreigner");
