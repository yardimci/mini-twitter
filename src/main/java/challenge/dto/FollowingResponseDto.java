package challenge.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FollowingResponseDto {
    private String title;
    private List<FollowerDto> followerList;
}
