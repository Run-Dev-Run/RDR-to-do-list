package com.rdr.schedule.schedule.dto.bundle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

public class ScheduleFindAllBundle {
    private ScheduleFindAllBundle() {
    }

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private final List<ScheduleFindBundle.Response> scheduleFindBundleResponses;

        public static Response of(List<ScheduleFindBundle.Response> scheduleFindBundleResponses) {
            return new Response(scheduleFindBundleResponses);
        }
    }
}
