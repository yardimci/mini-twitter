package challenge.domain;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private @NonNull Long id;
    private @NonNull String username;
    private @NonNull String name;
}
