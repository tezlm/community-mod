// yes
// ~~where is Solo.~~ sprite exists btw
const soloCopper = extend(BasicBulletType, {
        damage: 14,
        speed: 2.5,
        lifetime: 65,
        width: 6.5,
        height: 6.5,
        hitSound: Sounds.none,
        ammoMultiplier: 1,
});

const soloDense = extend(BasicBulletType, {
        damage: 24,
        speed: 2.5,
        lifetime: 65,
        width: 6.5,
        height: 6.5,
        hitSound: Sounds.none,
        reloadMultiplier: 0.5,
        ammoMultiplier: 1,
});

const soloHoming = extend(BasicBulletType, {
        damage: 15,
        speed: 2.5,
        lifetime: 65,
        width: 4,
        height: 5,
        hitSound: Sounds.none,
        homingPower: 0.08,
        ammoMultiplier: 1,
});

const soloIncendiary = extend(BasicBulletType, {
        damage: 15.5,
        speed: 2.5,
        lifetime: 65,
        width: 4,
        height: 5,
        hitSound: Sounds.none,
        frontColor: Pal.lightishOrange,
        backColor: Pal.lightOrange,
        status: StatusEffects.burning,
        makeFire: true,
        ammoMultiplier: 1,
});

// here have the Duo with the comically single barrel, Thanos
const solo = extend(ItemTurret, "solo", {
        spread: 1,
        shots: 1,
        alternate: true,
        reloadTime: 45,
        restitution: 0.03,
        range: 110,
        ammoUseEffect: Fx.casing1,
        inaccuracy: 3,
        rotateSpeed: 10,
        targetAir: true,
        targetGround: true,
        shootEffect: Fx.shootSmall,
        smokeEffect: Fx.shootSmallSmoke,
        shootSound: Sounds.pew,
});

const trioCopper = extend(BasicBulletType, {
	damage: 6,
	speed: 2.5,
	lifetime: 60,
	width: 4,
	height: 5,
	hitSound: Sounds.none,
	ammoMultiplier: 3,
});

const trioDense = extend(BasicBulletType, {
	damage: 12,
	speed: 2.5,
	lifetime: 60,
	width: 7,
	height: 8,
	hitSound: Sounds.none,
	reloadMultiplier: 0.5,
	ammoMultiplier: 3,
});

const trioHoming = extend(BasicBulletType, {
	damage: 6.5,
	speed: 2.5,
	lifetime: 60,
	width: 4,
	height: 5,
	hitSound: Sounds.none,
	homingPower: 0.08,
	ammoMultiplier: 3,
});

const trioIncendiary = extend(BasicBulletType, {
	damage: 7,
	speed: 2.5,
	lifetime: 60,
	width: 5,
	height: 6,
	hitSound: Sounds.none,
	frontColor: Pal.lightishOrange,
	backColor: Pal.lightOrange,
	status: StatusEffects.burning,
	makeFire: true,
	ammoMultiplier: 3,
});

const trio = extend(ItemTurret, "trio", {
	spread: 3,
	shots: 3,
	alternate: true,
	reloadTime: 8,
	restitution: 0.03,
	range: 110,
	shootCone: 15,
	ammoUseEffect: Fx.casing1,
	inaccuracy: 3,
	rotateSpeed: 10,
	targetAir: true,
	targetGround: true,
	shootEffect: Fx.shootSmall,
	smokeEffect: Fx.shootSmallSmoke,
	shootSound: Sounds.pew,
});

const quatroCopper = extend(BasicBulletType, {
	damage: 4.5,
	speed: 2.5,
	lifetime: 60,
	width: 3.5,
	height: 4.5,
	hitSound: Sounds.none,
	ammoMultiplier: 4,
});

const quatroDense = extend(BasicBulletType, {
	damage: 9,
	speed: 2.5,
	lifetime: 60,
	width: 6,
	height: 7,
	hitSound: Sounds.none,
	reloadMultiplier: 0.4,
	ammoMultiplier: 4,
});

const quatroHoming = extend(BasicBulletType, {
	damage: 5.55,
	speed: 2.5,
	lifetime: 60,
	width: 4,
	height: 5,
	hitSound: Sounds.none,
	homingPower: 0.08,
	ammoMultiplier: 4,
});

const quatroIncendiary = extend(BasicBulletType, {
	damage: 5.7,
	speed: 2.5,
	lifetime: 60,
	width: 5,
	height: 6,
	hitSound: Sounds.none,
	frontColor: Pal.lightishOrange,
	backColor: Pal.lightOrange,
	status: StatusEffects.burning,
	makeFire: true,
	ammoMultiplier: 4,
});

const quatro = extend(ItemTurret, "quatro", {
	spread: 2.5,
	shots: 4,
	alternate: true,
	reloadTime: 5.5,
	restitution: 0.03,
	range: 110,
	shootCone: 20,
	ammoUseEffect: Fx.casing1,
	inaccuracy: 4,
	rotateSpeed: 10,
	targetAir: true,
	targetGround: true,
	shootEffect: Fx.shootSmall,
	smokeEffect: Fx.shootSmallSmoke,
	shootSound: Sounds.pew,
});

solo.ammo(
        Items.copper, soloCopper,
        Items.graphite, soloDense,
        Items.silicon, soloHoming,
        Items.pyratite, soloIncendiary
);
trio.ammo(
	Items.copper, trioCopper,
	Items.graphite, trioDense,
	Items.silicon, trioHoming,
	Items.pyratite, trioIncendiary
);
quatro.ammo(
	Items.copper, quatroCopper,
	Items.graphite, quatroDense,
	Items.silicon, quatroHoming,
	Items.pyratite, quatroIncendiary
);
