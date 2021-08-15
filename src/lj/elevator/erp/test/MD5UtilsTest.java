package lj.elevator.erp.test;

import org.junit.Test;

import lj.elevator.erp.utils.MD5Utils;

public class MD5UtilsTest {

	@Test
	public void Md5HashTest() {

		String string = MD5Utils.encrypt("123456");
		System.out.println(string);
	}
}
