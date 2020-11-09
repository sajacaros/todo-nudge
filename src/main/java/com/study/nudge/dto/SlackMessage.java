package com.study.nudge.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class SlackMessage {
    final String channel;
    final String text;
}
