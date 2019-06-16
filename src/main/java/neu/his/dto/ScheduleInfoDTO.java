package neu.his.dto;

import neu.his.bean.ScheduleInfo;

import java.util.List;

public class ScheduleInfoDTO {
    private List<ScheduleInfo> scheduleInfos;

    public List<ScheduleInfo> getScheduleInfos() {
        return scheduleInfos;
    }

    public void setScheduleInfos(List<ScheduleInfo> scheduleInfos) {
        this.scheduleInfos = scheduleInfos;
    }
}
