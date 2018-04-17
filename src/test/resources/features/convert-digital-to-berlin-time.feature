Feature: Converting Digital Time to Berlin Time

 Scenario Outline: Single minutes row displays 
	 As a clock user
	 I want to be able to see single minutes
	 So that I can accurately tell the time down to the minute
	
	   Given I have started the converter
	   When I enter <time>
	   Then <row> is returned for the single minutes row
	
	   Examples:
	     | time     | row  |
	     | 00:00:00 | OOOO |
	     | 23:59:59 | YYYY |
	     | 12:32:00 | YYOO |
	     | 12:34:00 | YYYY |
	     | 12:35:00 | OOOO |
     
 
 Scenario Outline: Five minutes row displays 
	 As a clock user
	 I want to be able to see five minutes
	 So that I can tell higher minute amounts more easily at a glance
	
	   Given I have started the converter
	   When I enter <time>
	   Then <row> is returned for the five minutes row
	
	   Examples:
	     | time     | row         |
	     | 00:00:00 | OOOOOOOOOOO |
	     | 23:59:59 | YYRYYRYYRYY |
	     | 12:04:00 | OOOOOOOOOOO |
	     | 12:23:00 | YYRYOOOOOOO |
	     | 12:35:00 | YYRYYRYOOOO |
     
 Scenario Outline: Single hours row displays
	 As a clock user
	 I want to be able to see single hours
	 So that I can tell what hour it is
	
	   Given I have started the converter
	   When I enter <time>
	   Then <row> is returned for the single hours row
	
	   Examples:
	     | time     | row  |
	     | 00:00:00 | OOOO |
	     | 23:59:59 | RRRO |
	     | 02:04:00 | RROO |
	     | 08:23:00 | RRRO |
	     | 14:35:00 | RRRR |     
 
 
 Scenario Outline: Five hours row displays
	 As a clock user
	 I want to be able to see five hours
	 So that I can tell higher hour amounts more easily at a glance
	
	   Given I have started the converter
	   When I enter <time>
	   Then <row> is returned for the five hours row
	
	   Examples:
	     | time     | row  |
	     | 00:00:00 | OOOO |
	     | 23:59:59 | RRRR |
	     | 02:04:00 | OOOO |
	     | 08:23:00 | ROOO |
	     | 16:35:00 | RRRO |
   
     
 Scenario Outline: Seconds lamp displays
	 As a clock user
	 I want to be able to see seconds passing
	 So that I can see if my clock is working at a glance
	
	   Given I have started the converter
	   When I enter <time>
	   Then <lamp> is returned for the seconds lamp
	
	   Examples:
	     | time     | lamp |
	     | 00:00:00 | Y    |
	     | 23:59:59 | O    |     
 
 
 Scenario Outline: Entire Berlin clock displays
	As a clock user
	I want to be able to see an entire clock
	So that I can tell what time it is at a glance
	
	   Given I have started the converter
	   When I enter <time>
	   Then <clock> is returned
	
	   Examples:
	     | time     | clock                    |
	     | 00:00:00 | YOOOOOOOOOOOOOOOOOOOOOOO |
	     | 23:59:59 | ORRRRRRROYYRYYRYYRYYYYYY |
	     | 16:50:06 | YRRROROOOYYRYYRYYRYOOOOO |
	     | 11:37:01 | ORROOROOOYYRYYRYOOOOYYOO |    