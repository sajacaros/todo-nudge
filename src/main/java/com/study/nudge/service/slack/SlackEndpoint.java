package com.study.nudge.service.slack;

import com.study.nudge.dto.SlackMessage;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by sajacaros on 2020-10-06.
 */
public interface SlackEndpoint {
    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @POST
    Call<Object> messageToSlack(@Url String url, @Header("Authorization") String accessToken, @Body SlackMessage slackMessage);
}
