package com.shitot.model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Next on 12.07.2016.
 */
public class Schedule {
    public static final Map<DayOfWeek,List<Interval>> SCHEDULE_MAP= new HashMap<>();
    static {
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            SCHEDULE_MAP.put(dayOfWeek,new ArrayList<>());
        }
    }

}
