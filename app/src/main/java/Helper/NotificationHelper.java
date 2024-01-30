package Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.resmodulatorserver.R;

public class NotificationHelper  extends ContextWrapper {
    private static final String ResModulator_CHANEL_ID =" com.example.resmodulatorServer";
    private static final String ResModulator_CHANEL_NAME ="Resmodulator";

    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
            createChannel();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel joseChannel = new NotificationChannel(ResModulator_CHANEL_ID,ResModulator_CHANEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        joseChannel.enableLights(false);
        joseChannel.enableVibration(true);
        joseChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(joseChannel);
    }

    public NotificationManager getManager() {
        if(manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return  manager;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getResModulatorNotification(String title, String body, PendingIntent contentIntent,
                                                            Uri soundUri)
    {
        return new Notification.Builder(getApplicationContext(),ResModulator_CHANEL_ID)
                .setContentIntent(contentIntent)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(soundUri)
                .setAutoCancel(false);

    }

}