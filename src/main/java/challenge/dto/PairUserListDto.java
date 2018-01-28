package challenge.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PairUserListDto {

    private String username;
    private long mostPopulerFollowerId;

}
