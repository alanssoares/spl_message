/**
 * 
 */
package br.com.message.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import br.com.message.enums.EnumLanguage;

/**
 * @author alsoares
 *
 */
public class LanguageUtil {

	private static LanguageUtil instance;
	
	private static final String LANGUAGE_US_MSGS = "resources/messages_us.properties";
	private static final String LANGUAGE_BR_MSGS = "resources/messages_br.properties";
	
	private static final int LANGUAGE_US = 0;
	private static final int LANGUAGE_BR = 1;
	
	private static Properties propsUs;
	private static Properties propsBr;
	
	private static int language = LANGUAGE_US;
	
	public static final String TIT_BEGIN_= "tit.begin";
	public static final String TIT_OUT = "tit.out";
	public static final String TIT_HELP = "tit.help";
	public static final String TIT_SEND_COMMENT = "tit.send.comment";
	public static final String TIT_LIST_COMMENTS = "tit.list.comments";
	public static final String TIT_POLICY = "tit.policy";
	public static final String TIT_ABOUT = "tit.about";
	public static final String TIT_CONTACT = "tit.contact";
	public static final String TIT_ADD = "tit.add";
	public static final String TIT_ALTER = "tit.alter";
	public static final String TIT_REMOVE = "tit.remove";
	public static final String TIT_RECOVERY_PASSWORD = "tit.recovery.password";
	public static final String TIT_VISUALIZE = "tit.visualize";
	public static final String TIT_REGISTER_USER = "tit.register.user";
	public static final String TIT_ABOUT_SPL_MESSAGE = "tit.about.spl.message";
	public static final String TIT_ORDENATION_TYPE = "tit.ordenation.type";
	public static final String TIT_EMAIL_CONTACT = "tit.email.contact";
	public static final String TIT_NAME_GROUP = "tit.name.group";
	public static final String TIT_CHOOSE_GROUP = "tit.choose.group";
	public static final String TIT_CHOOSE_EMOCTION = "tit.choose.emoction";
	public static final String TIT_CHOOSE_STATUS = "tit.choose.status";
	public static final String TIT_GROUP = "tit.group=Grupo";
	public static final String TIT_ADD_CONTACT = "tit.add.contact";
	public static final String TIT_ALTER_CONTACT = "tit.alter.contact";
	public static final String TIT_STATUS = "tit.status";
	public static final String TIT_EMAIL = "tit.email";
	public static final String TIT_AVAILABLE = "tit.available";
	public static final String TIT_BUSY = "tit.busy";
	public static final String TIT_NOT_DISTURB = "tit.not.disturb";
	public static final String TIT_BE_RIGHT_BACK = "tit.be.right.back";
	public static final String TIT_ABSENT_FROM_WORK = "tit.absent.from.work";
	public static final String TIT_ABSENT = "tit.absent";
	public static final String TIT_DOUBT = "tit.doubt";
	public static final String TIT_COMPILMENT = "tit.compilment";
	public static final String TIT_SOLICITATION = "tit.solicitation";
	public static final String TIT_SUGGESTION = "tit.suggestion";
	public static final String TIT_COMPLAINT = "tit.complaint";
	public static final String LB_NAME = "lb.name"; 
	public static final String LB_EMAIL = "lb.email"; 
	public static final String LB_PASSWORD = "lb.password";
	public static final String LB_SUBJECT = "lb.subject";
	public static final String LB_TYPE = "lb.type";
	public static final String LB_MESSAGE = "lb.message";
	public static final String LB_GROUP = "lb.group";
	public static final String LB_ALTER_STATUS = "lb.alter.status";
	public static final String LB_REMOVE_CONTACT= "lb.remove.contact";
	public static final String LB_ADD_GROUP = "lb.add.group";
	public static final String LB_REMOVE_GROUP = "lb.remove.group";
	public static final String LB_EMOCTION = "lb.emoctions";
	public static final String LB_YOUR_PASSOWORD_IS = "lb.your.password.is";
	public static final String BTN_ADD = "btn.add";
	public static final String BTN_SEND = "btn.send";
	public static final String BTN_REGISTER = "btn.register";
	public static final String BTN_CANCEL = "btn.cancel";
	public static final String BTN_SIGN_IN = "btn.sign.in";
	public static final String BTN_OK = "btn.ok";
	public static final String BTN_NEW_REGISTER = "btn.new.register";
	public static final String BTN_RECOVERY_PASSWORD = "btn.recovery.password";
	public static final String BTN_ATTACH = "btn.attach";
	public static final String BTN_CLEAR = "btn.clear";
	public static final String BTN_SEARCH = "btn.search";
	public static final String BTN_ALTER = "btn.alter";
	public static final String BTN_VISUALIZE_SCREEN = "btn.visualize.screen";
	public static final String BTN_SORT = "btn.sort";
	public static final String MSG_MSG= "msg.msg";
	public static final String MSG_COMMENT_SEND_SUCCESS = "msg.comment.send.sucess";
	public static final String MSG_CONFIRMATION = "msg.confirmation";
	public static final String MSG_SUCCESS_ADD_CONTACT = "msg.success.add.contact";
	public static final String MSG_SUCCESS_ALTER_CONTACT = "msg.success.alter.contact";
	public static final String MSG_SUCCESS_ADD_GROUP = "msg.success.add.group";
	public static final String MSG_SUCCESS_REMOVE_GROUP= "msg.success.remove.group";
	public static final String MSG_SEND_FILE_ERROR = "msg.send.file.error";
	public static final String MSG_LOGIN_INVALID = "msg.login.invalid";
	public static final String MSG_LOGIN_ERROR = "msg.login.error";
	public static final String MSG_CLEAR_HISTORY_SUCCESS = "msg.clear.history.success";
	public static final String MSG_CLEAR_HISTORY_ERROR = "msg.clear.history.error";
	public static final String MSG_CONTACT_NOT_FOUND = "msg.contact.not.found";
	public static final String MSG_CONTACT_INVALID = "msg.contact.invalid";
	public static final String MSG_CONTACT_REGISTRED = "msg.contact.registred";
	public static final String MSG_ACCOUNT_REG_SUCCESS = "msg.account.reg.success";
	public static final String MSG_ACCOUNT_REG_ERROR = "msg.account.reg.erro";
	public static final String MSG_EMAIL_NOT_REG = "msg.email.not.registred";
	public static final String MSG_EMAIL_SEND_SUCCESS = "msg.email.send.success";
	public static final String MSG_EMAIL_SEND_ERROR = "msg.email.send.error";
	public static final String MSG_STATUS_ALTER_SUCCESS = "msg.status.alter.success";
	public static final String MSG_REMOVE_CONTACT_SUCCESS = "msg.remove.contact.success";
	public static final String MSG_GROUP_ALRADY_REGISTRED = "msg.group.alrady_registred";
	public static final String FILL_FIELDS_CORRECTLY = "fill.fields.correctly";
	
	public static synchronized LanguageUtil getInstance(){
		if(instance == null){
			instance = new LanguageUtil();
			loadLanguage(LANGUAGE_US);
			loadLanguage(LANGUAGE_BR);
		}
		return instance;
	}
	
	public static void loadLanguage(Integer l){
		InputStream input = null;
		try {
			if(l == LANGUAGE_BR){
				propsBr = new Properties();
				input = new FileInputStream(LANGUAGE_BR_MSGS);
				propsBr.load(input);
			} else if(l == LANGUAGE_US){
				propsUs = new Properties();
				input = new FileInputStream(LANGUAGE_US_MSGS);
				propsUs.load(input);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna a mensagem de acordo com a chave e a linguagem atual
	 * @param key
	 * @return
	 */
	public String getMessage(String key){
		if(language == LANGUAGE_BR){
			return propsBr.getProperty(key);
		} else if(language == LANGUAGE_US){
			return propsUs.getProperty(key);
		}
		return "";
	}

	/**
	 * Especify the new language
	 * @param newLanguage
	 */
	public static void setLanguage(EnumLanguage newLanguage) {
		language = newLanguage.getId();
	}
}