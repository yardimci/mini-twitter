package challenge.repository;

import challenge.domain.User;
import challenge.dto.PairUserListDto;

import java.util.List;

public interface UserRepository {
    User findByUsername(String username);
    User findById(long id);
    List<PairUserListDto> pairUserListDtoList();
}
