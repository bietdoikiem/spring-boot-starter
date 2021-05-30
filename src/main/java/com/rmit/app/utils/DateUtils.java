package com.rmit.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
    public static Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date parseDatetime(String datetimeStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = null;
        try {
            date = formatter.parse(datetimeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String stringDate = null;
        try {
            stringDate = formatter.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringDate;
    }

    public static Date normalizeDateAtStart(Date date) {
        String dateStr = DateUtils.dateToString(date);
        return DateUtils.parseDatetime(dateStr + " 00:00:00");
    }
    public static Date normalizeDateAtEnd(Date date) {
        String dateStr = DateUtils.dateToString(date);
        return DateUtils.parseDatetime(dateStr + " 23:59:59");
    }
}
