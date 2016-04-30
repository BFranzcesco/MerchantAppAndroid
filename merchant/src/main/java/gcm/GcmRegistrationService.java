package gcm;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GcmRegistrationService {
    @FormUrlEncoded @POST("register") Call<Void> register(@Field("registrationID") String registrationID);
}