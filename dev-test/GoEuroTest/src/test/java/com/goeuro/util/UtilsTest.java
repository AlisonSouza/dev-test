package com.goeuro.util;

import static org.junit.Assert.*;
import org.junit.Test;

public class UtilsTest{

	@Test
	public void shouldReturnBerlin() throws Exception {
		String content = Utils.callURL("http://api.goeuro.com/api/v2/position/suggest/en/Berlin");
		assertNotNull(content);
		assertTrue(content.contains("Berlin"));
	}
	
	@Test
	public void shouldReturnEmpty() throws Exception {
		String content = Utils.callURL("http://api.goeuro.com/api/v2/position/suggest/en/GoEuro");
		assertEquals("[]", content);
	}
}
