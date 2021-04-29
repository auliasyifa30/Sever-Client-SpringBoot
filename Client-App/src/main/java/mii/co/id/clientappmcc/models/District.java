
package mii.co.id.clientappmcc.models;
import lombok.Data;


@Data
public class District {
    private Integer districtId;
    private String kotakab;
    private String districtName;
    private Province provinceId;


    public District() {
    }

    public District(District district) {
        this.districtId = district.getDistrictId();
        this.kotakab = district.getKotakab();
        this.districtName = district.getDistrictName();
        this.provinceId=district.getProvinceId();
    }
}
    