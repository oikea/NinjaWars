/**
 * <p>NinjaWars
 * 共通タグライブラリクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.taglib

class ApplicationTagLib {
	static def namespace = "nsw"

	/**
	 * <p>バージョン情報文字列を出力する。
	 * <p>アプリケーションメタ情報で設定されたバージョン(app.version)、
	 * リリース日(app.release_date)が文字列に出力される。
	 * 
	 * @return バージョン情報の文字列。
	 */
	def version = {
		out << "Ver "
		out << meta(name:"app.version")
		out << "(" + meta(name:"app.release_date") + " released)"
	}

	/**
	 * <p>見出しの出力を行う。
	 * 
	 * @attr tagName 見出しに出力されるタグ。
	 */
	def heading = { attrs, body ->
		if (attrs.tagName == null) {
			throwTagError("Tag [heading] is missing required attribute [tagName]")
		}

		out << "<${attrs.tagName} class=\"heading\">"
		out << body()
		out << "</${attrs.tagName}>"
	}
}
