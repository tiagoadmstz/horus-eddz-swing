package com.cooperstandard.chart.ddz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import org.jfree.data.time.Minute;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DdzDataChart implements Serializable {

    @Builder.Default
    private Hour hour = new Hour(0, new Day());
    private Minute minute = new Minute(0, new Hour(0, new Day()));
    private Long value = 0L;

    public DdzDataChart(String date, Integer hour, Long value) {
        try {
            this.hour = new Hour(hour, new Day(new SimpleDateFormat("dd/MM/yyyy").parse(date)));
        } catch (Exception ex) {
            this.hour = new Hour(hour, new Day());
        }
        this.value = value;

    }

    public DdzDataChart(Date date, Long value) {
        this.hour = new Hour(date);
        this.minute = new Minute(date);
        this.value = value;
    }

    public DdzDataChart(LocalDateTime dateTime, Long value) {
        try {
            Date date = Date.from(ZonedDateTime.of(dateTime, ZoneId.systemDefault()).toInstant());
            this.hour = new Hour(date);
            this.minute = new Minute(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

}
