package com.study.nudge.config;

import com.study.nudge.service.slack.SlackEndpoint;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by sajacaros on 2020-11-08.
 */
@Configuration
public class SlackRetrofitConfigure {
    @Bean
    public Retrofit slackRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://slack.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    @Bean
    public SlackEndpoint slackEndpoint() {
        return slackRetrofit().create(SlackEndpoint.class);
    }

}
