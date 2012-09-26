/**
 * <p>Elder Software SGClone
 * ユニットレアリティベースドメインクラス
 * 
 * @since 2012/09/20
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

public class UnitRarityBase {
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
	 * </ul>
	 */
	static transients = [
		"messageCodePrefix",
		"name"
	]

	/**
	 * <p>メッセージコードのプレフックスを取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getMessageCodePrefix() {
		return "sgclone.unitRarity.${code}"
	}

	/**
	 * <p>レアリティの名称を取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getName() {
		return messageSupportService.message(code:"${this.messageCodePrefix}.name")
	}
}
