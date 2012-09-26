/*
 * NinjaWars初期データ
 */

// ユーザ権限
role {
	domainClass = org.eldersoftware.ninjawars.authority.Role
	datas = [
		[authority:"ROLE_USER", description:"一般ユーザの権限"],
		[authority:"ROLE_MANAGER", description:"管理ユーザの権限"]
	]
}

unitType {
	domainClass = org.eldersoftware.ninjawars.player.UnitType
	datas = [
		[code:"sin"],
		[code:"gi"],
		[code:"tai"],
	]
}

unitRarity {
	domainClass = org.eldersoftware.ninjawars.player.UnitRarity
	datas = [
		[code:"normal"],
		[code:"rare"],
		[code:"superrare"],
		[code:"legend"],
	]
}
