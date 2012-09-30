/**
 * <p>Elder Software SGClone
 * 共通タグライブラリクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.taglib

class ApplicationTagLib {
	static def namespace = "sg"

	def playerService

	/**
	 * <p>ヘッダメニューの出力を行う。
	 */
	def headerMenu = {
		def config = grailsApplication.config.sgclone.tutorial

		if (controllerName != (config.controller ?: "tutorial")) {
			out << "<ul class=\"nav-box header\">"
			out << sg.navBoxInner()
			out << "</ul>"
		}
	}

	/**
	 * <p>フッタメニューの出力を行う。
	 */
	def footerMenu = {
		def config = grailsApplication.config.sgclone.tutorial

		if (controllerName != (config.controller ?: "tutorial")) {
			out << "<ul class=\"nav-box footer\">"
			out << sg.navBoxInner()
			out << "</ul>"
		}
	}

	/**
	 * <p>ヘッダ／フッタメニューの内部を出力する。
	 */
	def navBoxInner = {
		def config = grailsApplication.config.sgclone

		out << "<li class=\"top\">"
		out << "<a href=\"${createLink(uri:'/')}\">"
		out << r.img(dir:"/images/common", file:"nav-box-top.png")
		out << "</a>"
		out << "</li>"
		out << "<li class=\"mypage\">"
		out << "<a href=\"${createLink(controller:config.mypage.top.controller ?: 'mypage')}\">"
		out << r.img(dir:"/images/common", file:"nav-box-mypage.png")
		out << "</a>"
		out << "</li>"
		out << "<li class=\"quest\">"
		out << "<a href=\"${createLink(controller:config.mypage.quest.controller ?: 'mypageQuest')}\">"
		out << r.img(dir:"/images/common", file:"nav-box-quest.png")
		out << "</a>"
		out << "</li>"
		out << "<li class=\"gacha\">"
		out << "<a href=\"${createLink(controller:config.mypage.gacha.controller ?: 'mypageGacha')}\">"
		out << r.img(dir:"/images/common", file:"nav-box-gacha.png")
		out << "</a>"
		out << "</li>"
		out << "<li class=\"strength\">"
		out << "<a href=\"${createLink(controller:config.mypage.strength.controller ?: 'mypageStrength')}\">"
		out << r.img(dir:"/images/common", file:"nav-box-strength.png")
		out << "</a>"
		out << "</li>"
	}

	/**
	 * <p>顔イメージ付きメッセージを出力する。
	 * 
	 * @attr image 顔イメージのファイル名。/images/faces内の画像ファイルが使用される。
	 */
	def faceMessage = { attrs, body ->
		if (attrs.image == null) {
			throwTagError("Tag [faceMessage] is missing required attribute [image]")
		}

		out << "<table class=\"face-message\">"
		out << "<tbody>"
		out << "<tr>"
		out << "<td class=\"image\">"
		out << r.img(dir:"/images/faces", file:attrs.image)
		out << "</td>"
		out << "<td class=\"message\">"
		out << body()
		out << "</td>"
		out << "</tr>"
		out << "</tbody>"
		out << "</table>"
	}

	/**
	 * <p>プレーヤー情報をページスコープにセットする。
	 */
	def setPlayer = {
		g.set(var:"player", value:playerService.loginPlayer)
	}
}
