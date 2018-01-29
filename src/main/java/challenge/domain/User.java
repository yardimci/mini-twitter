package challenge.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
//@Data var hepsini kapsiyor
public class User {
    private @NonNull Long id;
    private @NonNull String username;
    private @NonNull String name;
}
