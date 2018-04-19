package fr.jdrape.kata.berlinclockkata.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BerlinClockServiceImplTest {

	BerlinClockService service;

	private static final int SINGLE_MIN_ROW_START = 20;
	private static final int SINGLE_MIN_ROW_END = 24;
	private static final int FIVE_MIN_ROW_START = 9;
	private static final int FIVE_MIN_ROW_END = 20;

	private static final int SINGLE_HOUR_ROW_START = 5;
	private static final int SINGLE_HOUR_ROW_END = 9;

	private static final int FIVE_HOUR_ROW_START = 1;
	private static final int FIVE_HOUR_ROW_END = 5;

	private static final int SECOND_ROW_START = 0;
	private static final int SECOND_ROW_END = 1;

	@Before
	public void setUp() throws Exception {
		service = new BerlinClockServiceImpl();
	}

	private void testRow(List<String> times, String expectedValue, int start, int end) {

		for (String time : times) {
			String row = service.convertDigitalToBerlin(time).substring(start, end);
			Assert.assertEquals(row, expectedValue);
		}
	}

	/**
	 * Test single minute row
	 */
	@Test
	public void singleMinuteRowWith0Or5MinuesTime() {
		List<String> times = Arrays.asList("00:00:00", "00:05:00", "00:10:00");
		testRow(times, "OOOO", SINGLE_MIN_ROW_START, SINGLE_MIN_ROW_END);
	}

	@Test
	public void singleMinuteRowWith1Or6MinuesTime() {
		List<String> times = Arrays.asList("00:01:00", "00:06:00", "00:11:00");
		testRow(times, "YOOO", SINGLE_MIN_ROW_START, SINGLE_MIN_ROW_END);
	}

	@Test
	public void singleMinuteRowWith4Or9Time() {
		List<String> times = Arrays.asList("00:04:00", "00:09:00", "00:19:00");
		testRow(times, "YYYY", SINGLE_MIN_ROW_START, SINGLE_MIN_ROW_END);
	}

	/**
	 * Test 5 minutes row
	 */
	@Test
	public void fiveMinuteRowWithLess5() {
		List<String> times = Arrays.asList("00:01:00", "00:02:00", "00:04:00");
		testRow(times, "OOOOOOOOOOO", FIVE_MIN_ROW_START, FIVE_MIN_ROW_END);
	}

	@Test
	public void fiveMinuteRowBetween15And19() {
		List<String> times = Arrays.asList("00:15:00", "00:16:00", "00:19:00");
		testRow(times, "YYROOOOOOOO", FIVE_MIN_ROW_START, FIVE_MIN_ROW_END);
	}

	@Test
	public void fiveMinuteRowBetween45And49() {
		List<String> times = Arrays.asList("00:45:00", "00:46:00", "00:49:00");
		testRow(times, "YYRYYRYYROO", FIVE_MIN_ROW_START, FIVE_MIN_ROW_END);
	}

	@Test
	public void fiveMinuteRowBetwee55And59() {
		List<String> times = Arrays.asList("00:55:00", "00:56:00", "00:59:00");
		testRow(times, "YYRYYRYYRYY", FIVE_MIN_ROW_START, FIVE_MIN_ROW_END);
	}

	/**
	 * Test Single hour row
	 */
	@Test
	public void singleHourRowWith0Or5Time() {
		List<String> times = Arrays.asList("00:00:00", "05:05:00", "20:10:00");
		testRow(times, "OOOO", SINGLE_HOUR_ROW_START, SINGLE_HOUR_ROW_END);
	}

	@Test
	public void singleHourRowWith1Or6Time() {
		List<String> times = Arrays.asList("01:01:00", "06:06:00", "16:11:00");
		testRow(times, "ROOO", SINGLE_HOUR_ROW_START, SINGLE_HOUR_ROW_END);
	}

	@Test
	public void singleHourRowWith4Or9Time() {
		List<String> times = Arrays.asList("04:01:00", "09:06:00", "14:11:00");
		testRow(times, "RRRR", SINGLE_HOUR_ROW_START, SINGLE_HOUR_ROW_END);
	}

	/**
	 * Test 5 hours row
	 */
	@Test
	public void fiveHourRowWithLess5() {
		List<String> times = Arrays.asList("00:00:00", "03:00:00", "04:00:00");
		testRow(times, "OOOO", FIVE_HOUR_ROW_START, FIVE_HOUR_ROW_END);
	}

	@Test
	public void fiveHourRowBetween5And9() {
		List<String> times = Arrays.asList("05:00:00", "06:00:00", "09:00:00");
		testRow(times, "ROOO", FIVE_HOUR_ROW_START, FIVE_HOUR_ROW_END);
	}

	@Test
	public void fiveHourRowBetwee20And23() {
		List<String> times = Arrays.asList("20:00:00", "21:00:00", "23:00:00");
		testRow(times, "RRRR", FIVE_HOUR_ROW_START, FIVE_HOUR_ROW_END);
	}

	/**
	 * Test second row
	 */
	@Test
	public void secondRowWithEven() {
		List<String> times = Arrays.asList("00:00:00", "00:00:02", "00:00:58");
		testRow(times, "Y", SECOND_ROW_START, SECOND_ROW_END);
	}

	@Test
	public void secondRowWithOdd() {
		List<String> times = Arrays.asList("00:00:01", "00:00:03", "00:00:59");
		testRow(times, "O", SECOND_ROW_START, SECOND_ROW_END);
	}
}