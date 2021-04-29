package mii.co.id.clientappmcc.models;

import lombok.Data;

/*
 * @param <R> Response object type
 */
@Data
public class ResponseData<R> {

    private R data;
    private String message;

    public ResponseData(R data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseData() {
    }
}
