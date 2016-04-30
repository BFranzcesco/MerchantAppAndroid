package gcm;

import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GcmRegistrationService {
    @POST("register") void register(@Body String registrationID);
}