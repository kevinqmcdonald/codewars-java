/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package codewars;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class App {

  private static final int SECONDS = 1;
  private static final int MINUTES = 60 * SECONDS;
  private static final int HOURS = 60 * MINUTES;
  private static final int DAYS = 24 * HOURS;
  private static final int YEARS = 365 * DAYS;

  public static String formatDuration(int seconds) {
    if(seconds < 0) throw new IllegalArgumentException();
    if(seconds == 0) return "now";

    int years = 0, days = 0, hours = 0, mins = 0;
    while(seconds - YEARS >= 0) {
      seconds -= YEARS;
      years++;
    }
    while(seconds - DAYS >= 0) {
      seconds -= DAYS;
      days++;
    }
    while(seconds - HOURS >= 0) {
      seconds -= HOURS;
      hours++;
    }
    while(seconds - MINUTES >= 0) {
      seconds -= MINUTES;
      mins++;
    }

    Map<String, Integer> unitMap = getUnitMap(seconds, years, days, hours, mins);
    if(unitMap.size() == 1) {
      String unit = unitMap.keySet().iterator().next();
      int value = unitMap.get(unit);
      return value + " " + unit;
    } else {
      StringBuilder sb = new StringBuilder();
      Iterator<String> keyIter = unitMap.keySet()
        .stream()
        .sorted(Comparator.comparingInt(App::getUnitPriority))
        .iterator();
      for (int i = 0; i < unitMap.size(); ++i) {
        String unit = keyIter.next();
        int value = unitMap.get(unit);
        String unitStr = value + " " + unit;

        if(i == unitMap.size() - 1) {
          sb.append("and ").append(unitStr);
        } else if(i == unitMap.size() - 2) {
          sb.append(unitStr).append(" ");
        } else {
          sb.append(unitStr).append(", ");
        }
      }

      return sb.toString().trim();
    }
  }

  private static Map<String, Integer> getUnitMap(int seconds, int years, int days, int hours, int mins) {
    Map<String, Integer> unitMap = new HashMap<>();
    if(years > 0) {
      if(years == 1) {
        unitMap.put("year", years);
      } else {
        unitMap.put("years", years);
      }
    }
    if(days > 0) {
      if(days == 1) {
        unitMap.put("day", days);
      } else {
        unitMap.put("days", days);
      }
    }
    if(hours > 0) {
      if(hours == 1) {
        unitMap.put("hour", hours);
      } else {
        unitMap.put("hours", hours);
      }
    }
    if(mins > 0) {
      if(mins == 1) {
        unitMap.put("minute", mins);
      } else {
        unitMap.put("minutes", mins);
      }
    }
    if(seconds > 0) {
      if(seconds == 1) {
        unitMap.put("second", seconds);
      } else {
        unitMap.put("seconds", seconds);
      }
    }
    return unitMap;
  }

  private static int getUnitPriority(String unit) {
    if(unit.startsWith("year")) return 0;
    else if(unit.startsWith("day")) return 1;
    else if(unit.startsWith("hour")) return 2;
    else if(unit.startsWith("minute")) return 3;
    else return 4;
  }
}
