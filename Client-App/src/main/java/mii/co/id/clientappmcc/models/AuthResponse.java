package mii.co.id.clientappmcc.models;

import java.util.List;
import lombok.Data;

@Data
public class AuthResponse {

    private String userName;
    private List<String> authorities;

    public AuthResponse(String userName, List<String> authorities) {
        this.userName = userName;
        this.authorities = authorities;
    }

    public AuthResponse() {
    }
}
