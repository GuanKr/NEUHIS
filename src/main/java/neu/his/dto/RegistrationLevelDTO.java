package neu.his.dto;

import neu.his.bean.RegistrationLevel;

import java.util.List;

public class RegistrationLevelDTO {
    private List<RegistrationLevel>  registrationLevels;

    public List<RegistrationLevel> getRegistrationLevels() {
        return registrationLevels;
    }

    public void setRegistrationLevels(List<RegistrationLevel> registrationLevels) {
        this.registrationLevels = registrationLevels;
    }
}
