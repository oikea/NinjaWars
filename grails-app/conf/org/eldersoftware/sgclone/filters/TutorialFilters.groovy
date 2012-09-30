/**
 * <p>Elder Software SGClone
 * チュートリアル関連フィルタクラス
 * 
 * @since 2012/09/28
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.filters

class TutorialFilters {
	def grailsApplication
	def playerService

	def filters = {
		all(controller:"*", action:"*") {
			before = {
				def config = grailsApplication.config.sgclone.tutorial

				// 無効なら無視
				if (!config.filter.enabled) return
				if (controllerName == (config.controller ?: "tutorial")) return
				if (config.filter.controllerExclude?.contains(controllerName)) return

				// 未ログインなら無視
				def player = playerService.getLoginPlayer()
				if (!player) return

				// チュートリアル完了時は無視
				if (player.tutorialCompleted) return

				redirect(controller:config.controller ?: "tutorial", action:"execute")
			}
		}
	}
}
