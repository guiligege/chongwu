package org.guili.ecshop.util.common;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 各种验证
 * @author guili
 *
 */
public final class Validator {
	/**
	 * 判断元素是否为空
	 * <p>
	 * 目前可以判断一下元素
	 * <ul>
	 * <li>Collection,使用其isEmpty()</li>
	 * <li>Map,使用其isEmpty()</li>
	 * <li>Object[],判断length==0</li>
	 * <li>String,使用.trim().length()效率高</li>
	 * <li>Enumeration,使用hasMoreElements()</li>
	 * <li>Iterator,使用hasNext()</li>
	 * </ul>
	 * 
	 * @param value
	 *            可以是Collection,Map,Object[],String,Enumeration,Iterator类型
	 * @return 空返回true
	 * @since 1.0
	 */
	public final static boolean isNullOrEmpty(Object value){
		if (null == value){
			return true;
		}
		/*****************************************************************************/
		boolean flag = false;
		// 集合
		if (value instanceof Collection){
			flag = ((Collection) value).isEmpty();
		}
		// map
		else if (value instanceof Map){
			flag = ((Map) value).isEmpty();
		}
		// Object[]object数组
		else if (value instanceof Object[]){
			flag = ((Object[]) value).length == 0;
		}
		// 字符串
		else if (value instanceof String){
			// 比较字符串长度, 效率高
			flag = value.toString().trim().length() <= 0;
		}
		// 枚举
		else if (value instanceof Enumeration){
			flag = !((Enumeration) value).hasMoreElements();
		}
		// Iterator迭代器
		else if (value instanceof Iterator){
			flag = !((Iterator) value).hasNext();
		}
		return flag;
	}
	
	/**
	 * 判断一个Object 类型的 value,是否是一个特定的数<br>
	 * 系统自动将value 装成BigDecimal,并将specificNumber 也装成BigDecimal ,两个BigDecimal 进行compareTo,<br>
	 * 如果是0 ,则返回true
	 * 
	 * @param value
	 *            Object 类型的 value,类型必须是 Number 或者 String
	 * @param specificNumber
	 *            一个特定的数
	 * @return 系统自动将value 装成BigDecimal,并将specificNumber 也装成BigDecimal ,两个BigDecimal 进行compareTo,<br>
	 *         如果是0 ,则返回true
	 */
	public final static boolean isSpecificNumber(Object value,String specificNumber){
		boolean flag = false;
		if (!isNullOrEmpty(value)){
			String valueString = value.toString();
			// Number /String
			if (value instanceof Number || value instanceof String){
				BigDecimal bigDecimal = new BigDecimal(valueString);
				int i = bigDecimal.compareTo(new BigDecimal(specificNumber));
				flag = (i == 0);
			}
		}
		if (!flag){
			// String format = StringUtil.format("value is :%s,but specificNumber is %s", value, specificNumber);
			// log.debug(format);
		}
		return flag;
	}
	
	/**
	 * 验证是否是数字
	 * @param numberStr
	 * @return
	 */
	public static boolean isNumber(String numberStr){
		return Pattern.matches("^[0-9]+(.[0-9]{1,4})?$",numberStr);
	}
	//test
	public static void main(String[] args) {
		String num="1212312.121";
		System.out.println(Validator.isNumber(num));
	}
}
