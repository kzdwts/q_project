package top.kangyong.study02.model;

import lombok.Data;

import java.io.Serializable;

/**
 * user
 *
 * @author Kang Yong
 * @date 2023/10/30
 * @since 1.0.0
 */
@Data
public class UserDTO implements Serializable {

    private Long userId;

    private String userName;

    private VehicleDTO vehicleDTO;

}
