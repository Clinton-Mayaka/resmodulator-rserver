package Remote;

import Model.MyResponse;
import Model.Sender;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(

            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAA_dvIF3Q:APA91bENe0C66FkGc7FlAV0S6xWzJtKb_rpPwfuRrK_nDV4RGro_dR2gq0c8JtOT6o98kq4p_MSXwuIESPDvG8GD6Jj-R9FWnscMwJQ8tDUdfno5Tp_mBTS_xj8ZiBf1E0aawedeQx1o"
            }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
