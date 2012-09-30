/**
 * <p>Elder Software SGClone
 * ユニットタイプベースドメインクラス
 * 
 * @since 2012/09/20
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

public class UnitTypeBase {
	transient messageSupportService

	/** コード */
	String code

	/** エンティティ制約。 */
	static constraints = {
		code(maxSize:15, nullable:false, blank:false, unique:true)
	}

	/**
	 * <p>以下のプロパティは永続化対象外とする。
	 * 
	 * <ul>
	 * <li>messageCodePrefix
	 * <li>name
	 * <li>description
	 * </ul>
	 */
	static transients = [
		"messageCodePrefix",
		"name",
		"description"
	]

	/**
	 * <p>メッセージコードのプレフックスを取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getMessageCodePrefix() {
		return "sgclone.unitType.${code}"
	}

	/**
	 * <p>ユニットタイプの名称を取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getName() {
		return messageSupportService.message(code:"${this.messageCodePrefix}.name")
	}

	/**
	 * <p>ユニットタイプの説明文を取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getDescription() {
		return messageSupportService.message(code:"${this.messageCodePrefix}.description")
	}
}
