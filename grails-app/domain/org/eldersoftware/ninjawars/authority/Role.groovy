/**
 * <p>NinjaWars
 * ユーザ権限ドメインクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

class Role {
	/** 権限名。 */
	String authority

	/** 説明。 */
	String description

	/** エンティティのマッピング設定。 */
	static mapping = {
		cache(true)
	}

	/** エンティティ制約。 */
	static constraints = {
		authority(maxSize:20, nullable:false, blank:false, unique:true)
		description(maxSize:100)
	}
}
