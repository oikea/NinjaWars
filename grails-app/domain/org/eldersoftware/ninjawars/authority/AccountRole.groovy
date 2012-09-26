/**
 * <p>NinjaWars
 * アカウント／ロール関連定義ドメインクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.apache.commons.lang.builder.HashCodeBuilder

class AccountRole implements Serializable {
	/** アカウント情報 */
	Account account

	/** 権限情報 */
	Role role

	/** エンティティのマッピング設定。 */
	static mapping = {
		id(composite:["role", "account"])
		version(false)
	}

	/**
	 * <p>関連情報を取得する。
	 * 
	 * @param accountId アカウント情報のＩＤ。
	 * @param roleId 権限情報のＩＤ。
	 * 
	 * @return 関連情報のモデルインスタンス。
	 */
	static AccountRole get(long accountId, long roleId) {
		return find(
			"from AccountRole where account.id=:accountId and role.id=:roleId", 
			[accountId:accountId, roleId:roleId]
		)
	}

	/**
	 * <p>指定したアカウントの権限情報を登録する。
	 * <p>すでに登録済の場合は無視される。
	 *
	 * @param account 登録対象アカウント情報のモデルインスタンス。
	 * @param role 登録対象権限情報のモデルインスタンス。
	 *
	 * @return 登録した関連情報のモデルインスタンス。
	 */
	static AccountRole create(Account account, Role role, boolean flush = false) {
		AccountRole instance = AccountRole.findByAccountAndRole(account, role)
		if (instance) return instance

		return new AccountRole(account:account, role:role).save(flush:flush, insert:true)
	}

	/**
	 * <p>指定したアカウントの権限情報を削除する。
	 * 
	 * @param account 削除対象アカウント情報のモデルインスタンス。
	 * @param role 削除対象権限情報のモデルインスタンス。
	 * 
	 * @return 削除成功時は{@code true}を返す。
	 */
	static boolean remove(Account account, Role role, boolean flush = false) {
		AccountRole instance = AccountRole.findByAccountAndRole(account, role)
		if (!instance) return false

		instance.delete(flush:flush)

		return true
	}

	/**
	 * <p>指定したアカウントの権限情報をすべて削除する。
	 * 
	 * @param account 削除対象アカウント情報のモデルインスタンス。
	 */
	static void removeAll(Account account) {
		executeUpdate("DELETE FROM AccountRole WHERE account=:account", [account:account])
	}

	/**
	 * <p>指定した権限情報をすべて削除する。
	 * 
	 * @param role 削除対象権限情報のモデルインスタンス。
	 */
	static void removeAll(Role role) {
		executeUpdate("DELETE FROM AccountRole WHERE role=:role", [role:role])
	}

	/** {@inheritDoc} */
	@Override public boolean equals(Object obj) {
		if (!(obj instanceof AccountRole)) return false

		return (obj.account?.id == account?.id && obj.role?.id == role?.id)
	}

	/** {@inheritDoc} */
	@Override public int hashCode() {
		def builder = new HashCodeBuilder()

		if (account) builder.append(account.id)
		if (role) builder.append(role.id)

		builder.toHashCode()
	}
}
