package dao;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import com.wzd.utils.SMSUtil;

public class TestSMS {
	@Test
	public void test1() {
		SMSUtil.send("3058503", new String[] { "13541305583" },
				new String[] { "钟成", "魏自东", "2017年第1001号受理通知书", "http://www.lqzgh.com", "y64mg", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") });
	}
}
