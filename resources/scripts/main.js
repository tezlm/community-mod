function random(array) {
	const index = Math.round(Math.random() * array.length);
	return array[index];
}

function multipleRandom(array, amount) {
	let randoms = [];
	for (i = 0; i < amount; i++) {
		randoms = randoms.concat(random(array));
	}
	return randoms;
}

Events.on(ClientPreConnectEvent, () => {
	const result = multipleRandom("0123456789".split(""), 8).join("");
 	const uuid = Base64Coder.encodeString(result);
	Core.settings.put("uuid", uuid);
});

require("hmmvus");
require("duos");
require("speedreigner");
