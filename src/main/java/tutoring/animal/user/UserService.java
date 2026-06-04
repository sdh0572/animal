package tutoring.animal.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserDto.UserResponse signup(UserDto.UserRequest request) {
        if (userRepository.existsByUserId(request.userId())) {
            throw new IllegalArgumentException("이미 사용중인 아이디입니다.");
        }

        User newUser = new User(request.userId(), request.password());
        User savedUser = userRepository.save(newUser);

        return UserDto.UserResponse.from(savedUser);
    }

    @Transactional(readOnly = true)
    public UserDto.UserResponse login(UserDto.UserRequest request) {
        User user = userRepository.findByUserId(request.userId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!user.getPassword().equals(request.password())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return UserDto.UserResponse.from(user);
    }
}
