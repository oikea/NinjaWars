/**
 * <p>Elder Software SGClone
 * ユニットベースドメインクラス
 * 
 * @since 2012/09/20
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

public class UnitBase {
	transient messageSupportService

	/** 最大レベル */
	int maxLevel

	/** コード */
	String code

	/** ユニットタイプ */
	UnitTypeBase unitType

	/** レアリティ */
	UnitRarityBase rarity

	/** 進化先のユニット */
	UnitBase nextUnit

	/** コスト */
	int cost

	/** 初期攻撃力 */
	int initAttackPoint

	/** 初期防御力 */
	int initDefencePoint

	/** 最大攻撃力 */
	int maxAttackPoint

	/** 最大防御力 */
	int maxDefencePoint

	/** 攻撃成長係数 */
	double attackCoefficient

	/** 防御成長係数 */
	double defenceCoefficient

	/** 攻撃成長タイプ */
	String attackGrowType

	/** 防御成長タイプ */
	String defenceGrowType

	/** エンティティ制約。 */
	static constraints = {
		code(maxSize:15, nullable:false, blank:false, unique:true)
		attackGrowType(maxSize:20, nullable:false, blank:false)
		defenceGrowType(maxSize:20, nullable:false, blank:false)
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
		return "sgclone.unit.${code}"
	}

	/**
	 * <p>ユニットの名称を取得する。
	 * 
	 * @return メッセージコードのプレフィックス。
	 */
	public String getName() {
		return messageSupportService.message(code:"${this.messageCodePrefix}.name")
	}
}
