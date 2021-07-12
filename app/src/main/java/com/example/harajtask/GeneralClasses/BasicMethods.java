package com.example.harajtask.GeneralClasses;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.format.DateFormat;

import java.util.Calendar;

public class BasicMethods {

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    public static String dateToString(long serverDate, String dateStyle){

        Calendar objectTime = Calendar.getInstance(); //any object time
        objectTime.setTimeInMillis(serverDate); //Server, json or so on time
        Calendar now = Calendar.getInstance();//Current system time

        //Full date of object with format like "2021/05/25 07:02AM"
        if (dateStyle.equals("Full Date"))
        return DateFormat.format("yyyy/MM/dd   HH:mma", objectTime).toString();


        else {

            //The object year is not this year
            if (now.get(Calendar.YEAR) != objectTime.get(Calendar.YEAR))
                return DateFormat.format("MMM, yyyy", objectTime).toString();

                //The object time is last month
            else if (now.get(Calendar.MONTH) - objectTime.get(Calendar.MONTH) == 1)
                return "Last Month" + DateFormat.format(" dd", objectTime).toString();

                //The object time is not this month ot last one
            else if (now.get(Calendar.MONTH) - objectTime.get(Calendar.MONTH) > 1)
                return DateFormat.format("dd MMMM", objectTime).toString();

                //The object time is this month but not this day
            else if (now.get(Calendar.WEEK_OF_MONTH) != objectTime.get(Calendar.WEEK_OF_MONTH))
                return "This Month" + DateFormat.format(" dd", objectTime).toString();

                //The object time is this week but not this day or yesterday
            else if (now.get(Calendar.DAY_OF_WEEK) - objectTime.get(Calendar.DAY_OF_WEEK) > 1)
                return DateFormat.format("EEEE", objectTime).toString();

                //The object time is yesterday
            else if (now.get(Calendar.DAY_OF_WEEK) - objectTime.get(Calendar.DAY_OF_WEEK) == 1)
                return "Yesterday" + DateFormat.format(" HH:mm", objectTime).toString();

                //The object time is last hour
            else if (now.get(Calendar.HOUR_OF_DAY) - objectTime.get(Calendar.HOUR_OF_DAY) == 1)
                return "Last Hour";

                //The object time is today but not this hour
            else if (now.get(Calendar.HOUR_OF_DAY) - objectTime.get(Calendar.HOUR_OF_DAY) > 1)
                return "Today" + DateFormat.format(" HH:mm a", objectTime).toString();

                //The object time is this hour but not this minute
            else if (now.get(Calendar.MINUTE) != objectTime.get(Calendar.MINUTE))
                return now.get(Calendar.MINUTE) - objectTime.get(Calendar.MINUTE) + " Min ago";

                //The object time is this minute
            else
                return "now";
        }
    }




}
