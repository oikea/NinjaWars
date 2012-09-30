/**
 * <p>NinjaWars
 * チュートリアルコントローラクラス
 * 
 * @since 2012/09/27
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.tutorial

import org.eldersoftware.sgclone.tutorial.AbstractTutorialController
import grails.plugins.springsecurity.Secured
import org.eldersoftware.ninjawars.player.UnitType

@Secured(["ROLE_USER"])
public class TutorialController extends AbstractTutorialController {
	/**
	 * <p>チュートリアル開始
	 */
	protected def onStart() {
		nextAction("typeSelect")
	}

	/**
	 * <p>タイプ選択 - 選択イベント
	 */
	protected def onTypeSelect_select() {
		for (def unitType : UnitType.list()) {
			if (params[unitType.code]) {
				def progress = findProgress()

				progress.unitType = unitType
				progress.save()

				nextAction("typeConfirm")
			}
		}
	}

	/**
	 * <p>タイプ確認
	 */
	protected def onTypeConfirm() {
		def progress = findProgress()

		return [unitType:progress.unitType]
	}

	/**
	 * <p>タイプ確認 - 選択イベント
	 */
	protected def onTypeConfirm_select() {
		def progress = findProgress()

		if (params.next) {
			def player = playerService.getLoginPlayer()

			player.unitType = progress.unitType
			player.save()

			nextAction("end")
		} else {
			progress.unitType = null
			progress.save()

			nextAction("typeSelect")
		}
	}
}
