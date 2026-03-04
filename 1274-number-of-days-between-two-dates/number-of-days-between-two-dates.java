class Solution {

    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(days(date1) - days(date2));
    }

    private int days(String date) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int totalDays = 0;

        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        for (int m = 1; m < month; m++) {
            totalDays += monthDays[m-1];
            if (m == 2 && isLeap(year)) {
                totalDays += 1;
            }
        }

        totalDays += day;

        return totalDays;
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}