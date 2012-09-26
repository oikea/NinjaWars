/**
 * <p>NinjaWars
 * ユーザ登録入力情報クラス
 * 
 * @since 2012/09/23
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class SignupInput {
	/** ユーザＩＤ */
	String userId

	/** パスワード */
	String password

	/** パスワード(確認用) */
	String confirmPassword

	/** エンティティ制約。 */
	static constraints = {
		userId(
			nullable:false, blank:false, unique:true, maxSize:20,
			validator: { val, obj ->
				if (val ==~ /[a-z_\d\-]+/) {
				} else {
					return "signupInput.userId.invalid.format.error"
				}

				if (Account.findByUserId(val)) {
					return "signupInput.userId.unique.error"
				}
			}
		)
		password(nullable:false, blank:false, size:6..255)
		confirmPassword(
			validator: { val, obj ->
				if (val != obj?.password) {
					return "signupInput.confirmPassword.not.equal.error"
				}
			}
		)
	}
}
