package com.gm.shiro.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
/**
 * @Description: shiro 工具类  设置密码散列算法和散列次数  盐的生成规则
 * @Author: guomeng
 * @Date: 2019/9/20 8:45
 **/
public class ShiroUtil {
	public static final String HASH_ALGORITHM_NAME = "MD5";	//散列算法 MD5、SHA256、SHA1、SHA512、sha384
	public static final int HASH_ITERATIONS = 2;	//散列次数

	/**
	 *	加盐散列 得到散列后的新密码 
	 */
	public static final String newPassWord(String password, String salt){
	    //盐：为了即使相同的密码不同的盐加密后的结果也不同
	    ByteSource byteSalt = ByteSource.Util.bytes(salt);
	    //密码
	    Object source = password;
	    SimpleHash result = new SimpleHash(HASH_ALGORITHM_NAME, source, byteSalt, HASH_ITERATIONS);
	    return result.toString();
	}
	/**
	 *	根据规则生成盐  
	 */
	public static final String getSalt() {
		String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); 	//生成盐值
		return salt;
	}
}
