/**
 * <p>NinjaWars
 * アカウントドメインクラス
 * 
 * @since 2012/09/18
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.eldersoftware.ninjawars.player.Player

class Account {
	transient springSecurityService

	/** ユーザＩＤ */
	String userId

	/** パスワード */
	String password

	/** 有効フラグ */
	boolean enabled

	/** 期限切れフラグ */
	boolean accountExpired

	/** ロックフラグ */
	boolean accountLocked

	/** パスワード期限切れフラグ */
	boolean passwordExpired

	/** プレイヤー情報 */
	Player player

	/** エンティティ制約。 */
	static constraints = {
		userId(maxSize:20, nullable:false, blank:false, unique:true)
		password(nullable:false, blank:false)
	}

	/** エンティティのマッピング設定。 */
	static mapping = {
		password(column:"`password`")
		player(lazy:false)
	}

	/**
	 * <p>以下のプロパティは永続化対象外とする。
	 */
	static transients = [
		"authorities"
	]

	/** <p>INSERT前に実行される処理。 */
	def beforeInsert() {
		encodePassword()
	}

	/** <p>UPDATE前に実行される処理。 */
	def beforeUpdate() {
		if (isDirty("password")) {
			encodePassword()
		}
	}

	/**
	 * <p>ユーザが保持する権限を取得する。
	 * 
	 * @return ユーザが保持する権限の{@code Set}。
	 */
	Set<Role> getAuthorities() {
		AccountRole.findAllByAccount(this).collect { it.role } as Set
	}

	/**
	 * <p>パスワードのエンコードを行う内部処理。
	 */
	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}

	/**
	 * <p>アカウントの権限情報を登録する。
	 * <p>すでに登録済の場合は無視される。
	 *
	 * @param role 登録対象権限情報のモデルインスタンス。
	 */
	public void addAuthority(Role role, boolean flush = false) {
		AccountRole.create(this, role, flush)
	}

	/**
	 * <p>アカウントの権限情報を削除する。
	 * 
	 * @param role 削除対象権限情報のモデルインスタンス。
	 */
	public void removeAuthority(Role role, boolean flush = false) {
		AccountRole.remove(this, role, flush)
	}

	/**
	 * <p>アカウントの権限情報をすべて削除する。
	 * 
	 * @param account 削除対象アカウント情報のモデルインスタンス。
	 */
	public void removeAllAuthority() {
		AccountRole.removeAll(this)
	}
}
