package mii.co.id.clientappmcc.models;

import java.util.List;
import lombok.Data;

@Data
public class AuthRequest {

    private String userName;
    private String userPassword;

    public AuthRequest(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public AuthRequest() {
    }
}
