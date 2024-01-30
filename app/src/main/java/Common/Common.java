package Common;

import android.text.format.DateFormat;

import java.util.Calendar;
import java.util.Locale;

import Model.Request;
import Model.User;
import Remote.APIService;
import Remote.RetrofitClient;

public class Common {
    public  static User currentUser;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public  static   final int PICK_IMAGE_REQUEST = 71;
    public static Request currentRequest;

    public static final  String fcmUrl ="https://fcm.googleapis.com/";
    public static String STAFF_NO_TEXT = "UserStaff No";

    public static  String convertCodeToStatus(String code)
    {
        if(code.equals("0"))
            return "Placed";
        else if(code.equals("1"))
            return  "On the way";
        else
            return "Ready";

    }


    public static APIService getFCMClient(){

        return RetrofitClient.getClient(fcmUrl).create(APIService.class);
    }
    public static String getDate(long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(DateFormat.format("dd-MM-yyyy HH:mm"
        ,calendar)
        .toString());
        return date.toString();
    }

}
