package com.study.nudge.service.slack;

import com.study.nudge.dto.SlackMessage;
import com.study.nudge.dto.TodoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Supplier;

public interface SlackService {
    void sendTodo(TodoDto.Details details);

    @Service
    @Slf4j
    class Default implements SlackService {
        @Autowired
        private SlackEndpoint slackEndpoint;

        @Value("${key.path}")
        private String path;

        private static final String SLACK_URL = "https://slack.com/api/chat.postMessage";
        private static String SLACK_KEY;

        @PostConstruct
        public void init() throws IOException {
            this.SLACK_KEY = Files.readString(Paths.get(path), StandardCharsets.UTF_8).replaceAll("[\t\n\r]", "");
            log.info("key : {}",this.SLACK_KEY);
        }

        @Override
        public void sendTodo(TodoDto.Details details) {
            SlackMessage message = new SlackMessage(details.getChannel(), details.getTodo());
            executeRetrofit(
                    () -> slackEndpoint.messageToSlack(SLACK_URL, "Bearer " + SLACK_KEY, message)
            );

        }
        private void executeRetrofit(Supplier<Call> supplier) {
            try {
                Response<?> response = supplier.get().execute();
                log.info("slack response code : {}", response.code());
            } catch (IOException e) {
                e.printStackTrace();
                log.warn("slack 연결 실패, message : {}, cause : {}", e.getMessage(), e.getCause());
            }
        }
    }
}
