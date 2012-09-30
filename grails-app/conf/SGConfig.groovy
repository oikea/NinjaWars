sgclone {
	player {
		propertyName = "player"
		initialParameter {
			money = 0
			stamina = 10
			attackCost = 10
			defenceCost = 10
			maxFriends = 5
			maxUnits = 30
		}
	}

	top {
		titleImages = ["/images/top/title.jpg"]
	}

	unit {
		imageExtention = "jpg"
	}

	recoveryInterval {
		stamina = 3
		attackCost = 1
		defenceCost = 1
	}

	tutorial {
		domainClass = org.eldersoftware.sgclone.player.TutorialProgressBase
		controller = "tutorial"
		filter {
			enabled = true
			controllerExclude = [
				"login",
				"logout"
			]
		}
	}

	mypage {
		top.controller = "mypage"
	}
}
