package com.rdr.diary.utils;

public class DiaryValidUtils {
    public static class Regexp {
        public static final String NAME = "^[가-힣]{2,10}$";
    }

    public static class Message {
        public static final String NAME = "이름 형식이 맞지 않습니다.";
    }
}
