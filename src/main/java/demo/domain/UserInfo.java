package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by hectorlueng on 4/19/18.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {
    private String username;
    private String address;
}
