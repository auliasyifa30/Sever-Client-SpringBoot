package mii.co.id.clientappmcc.models;

import lombok.Data;

@Data
public class Province {

    private Integer provinceId;
    private String provinceName;

    public Province() {
    }

    public Province(Province province) {
        this.provinceId = province.getProvinceId();
        this.provinceName = province.getProvinceName();
    }

}
