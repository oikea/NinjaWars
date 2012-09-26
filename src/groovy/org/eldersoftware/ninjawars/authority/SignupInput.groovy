/**
 * <p>NinjaWars
 * ���[�U�o�^���͏��N���X
 * 
 * @since 2012/09/23
 * @author RaTTiE
 */
package org.eldersoftware.ninjawars.authority

import org.codehaus.groovy.grails.validation.Validateable

@Validateable
class SignupInput {
	/** ���[�U�h�c */
	String userId

	/** �p�X���[�h */
	String password

	/** �p�X���[�h(�m�F�p) */
	String confirmPassword

	/** �G���e�B�e�B����B */
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
