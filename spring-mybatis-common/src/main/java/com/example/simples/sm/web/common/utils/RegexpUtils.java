package com.example.simples.sm.web.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tianyi
 *
 */
public final class RegexpUtils {

	/**
	 * 验证手机号码
	 * 
	 * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
	 * 联通号码段:130、131、132、136、185、186、145 电信号码段:133、153、180、189
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean isMobilePhone(String phoneNum) {
		Pattern p = Pattern.compile("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(phoneNum);
		return m.matches();
	}

	/**
	 * 验证固话号码
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean isTelephone(String phoneNum) {
		Pattern p = Pattern.compile("^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$");
		Matcher m = p.matcher(phoneNum);
		return m.matches();
	}

}
