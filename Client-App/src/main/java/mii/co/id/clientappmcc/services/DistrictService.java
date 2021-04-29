package mii.co.id.clientappmcc.services;

import java.util.List;
import mii.co.id.clientappmcc.config.RequestFormat;
import mii.co.id.clientappmcc.models.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistrictService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.url}")
    private String url;

    //READ
    public List<District> getAll() {
        ResponseEntity<List<District>> response = restTemplate
                .exchange(url + "/list-district", HttpMethod.GET,
                        new HttpEntity(RequestFormat.createHeaders()),
                        new ParameterizedTypeReference<List<District>>() {
                });
        return response.getBody();
    }

    //GET BY ID
    public District getById(Integer id) {
        return restTemplate.getForEntity(url + "/disget/" + id, District.class).getBody();
    }

    //CREATE 
    public String create(District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/dis-insert", HttpMethod.POST, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

    //UPDATE
    public String update(Integer id, District district) {
        HttpEntity entity = new HttpEntity(district, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/dis-update/" + id, HttpMethod.PUT, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }

    //DELETE
    public String delete(Integer id) {
        HttpEntity entity = new HttpEntity(id, RequestFormat.createHeaders());
        ResponseEntity<String> res = restTemplate.exchange(url + "/dis-delete/" + id, HttpMethod.DELETE, entity,
                new ParameterizedTypeReference<String>() {
        });
        return res.getBody();
    }
}
