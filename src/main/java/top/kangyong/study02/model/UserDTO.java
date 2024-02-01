package top.kangyong.study02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * user
 *
 * @author Kang Yong
 * @date 2023/10/30
 * @since 1.0.0
 */
@Data
@ToString
public class UserDTO implements Serializable {

    private Long userId;

    private String userName;

    private VehicleDTO vehicleDTO;

    public UserDTO() {
    }

    public UserDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
