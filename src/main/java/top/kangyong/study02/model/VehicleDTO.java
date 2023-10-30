package top.kangyong.study02.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Vehicle
 *
 * @author Kang Yong
 * @date 2023/10/30
 * @since 1.0.0
 */
@Data
public class VehicleDTO implements Serializable {

    private String name;

    private Car car;
}
