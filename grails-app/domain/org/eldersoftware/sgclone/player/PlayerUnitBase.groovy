/**
 * <p>Elder Software SGClone
 * プレイヤー所持ユニットベースドメインクラス
 * 
 * @since 2012/09/20
 * @author RaTTiE
 */
package org.eldersoftware.sgclone.player

import org.apache.commons.lang.StringUtils

public class PlayerUnitBase {
	transient grailsApplication
	transient grailsLinkGenerator

	/** ユニット */
	UnitBase unit

	/** ユニットレベル */
	int level

	/** 経験値 */
	int experience

	/** 進化前ユニットから引き継いだ攻撃力 */
	int inheritedAttackPoint

	/** 進化前ユニットから引き継いだ防御力 */
	int inheritedDefencePoint

	/**
	 * <p>以下のプロパティは永続化対象外とする。
	 * 
	 * <ul>
	 * <li>attackPoint
	 * <li>defencePoint
	 * <li>imageUrl
	 * </ul>
	 */
	static transients = [
		"attackPoint",
		"defencePoint",
		"imageUrl"
	]

	/** エンティティ制約。 */
	static constraints = {
		unit(nullable:false)
	}

	/**
	 * <p>ユニットの攻撃力を取得する。
	 * 
	 * @return 計算後の攻撃力。
	 */
	public int getAttackPoint() {
		return calcPower(
			unit.initAttackPoint,
			unit.maxAttackPoint,
			inheritedAttackPoint,
			unit.attackCoefficient,
			unit.attackGrowType
		)
	}

	/**
	 * <p>ユニットの防御力を取得する。
	 * 
	 * @return 計算後の防御力。
	 */
	public int getDefencePoint() {
		return calcPower(
			unit.initDefencePoint,
			unit.maxDefencePoint,
			inheritedDefencePoint,
			unit.defenceCoefficient,
			unit.defenceGrowType
		)
	}

	/**
	 * <p>攻撃力、防御力の基幹計算ルーチン。
	 * 
	 * @param initPoint ユニットの初期能力値。
	 * @param maxPoint ユニットの最大能力値。
	 * @param inheritedPoint ユニットの引継能力値。
	 * @param coefficient ユニットの成長係数。
	 * @param growType ユニットの成長タイプ。
	 * 
	 * @return 能力値の計算結果。
	 */
	protected int calcPower(int initPoint,
	                        int maxPoint,
	                        int inheritedPoint,
	                        double coefficient,
	                        String growType) {
		int inheritedInitPoint = initPoint + inheritedPoint
		int inheritedMaxPoint = maxPoint + inheritedPoint

		return inheritedInitPoint + Math.floor(
			(double) (inheritedMaxPoint - inheritedInitPoint) * 
			this."calcPowerRateFrom${StringUtils.capitalize(growType)}"(coefficient)
		)
	}

	/**
	 * <p>能力値の成長率計算関数(指数)。
	 * <p>大器晩成型のユニット成長となる。
	 * 
	 * @param coefficient 成長係数。
	 * 
	 * @return ユニットの成長倍率。
	 */
	protected double calcPowerRateFromPow(double coefficient) {
		return Math.pow((level - 1) / (unit.maxLevel - 1), coefficient)
	}

	/**
	 * <p>能力値の成長率計算関数(指数反転)。
	 * <p>早熟型のユニット成長となる。
	 * 
	 * @param coefficient 成長係数。
	 * 
	 * @return ユニットの成長倍率。
	 */
	protected double calcPowerRateFromReversePow(double coefficient) {
		return 1.0D - Math.pow((unit.maxLevel - level) / (unit.maxLevel - 1), coefficient)
	}

	/**
	 * <p>ユニットイメージのＵＲＬを取得する。
	 * 
	 * @return ユニットイメージのＵＲＬ。
	 */
	public String getImageUrl() {
		String idString = "0000" + id.toString()
		String ext = grailsApplication.config.sgclone.unit.imageExtention

		return grailsLinkGenerator.resource(
			dir:"images/sgresource/units", 
			file:"unit${(idString.substring(idString.length - 4))}.${ext}"
		)
	}
}
