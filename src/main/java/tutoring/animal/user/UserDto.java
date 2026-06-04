package tutoring.animal.user;

public class UserDto {

    // 회원가입 및 로그인 요청을 위한 DTO
    public record UserRequest(
            String userId,
            String password
    ) {}

    // 사용자 정보를 반환하기 위한 DTO
    public record UserResponse(
            Long id,
            String userId
    ) {
        // 엔티티를 DTO로 변환하는 정적 메서드
        public static UserResponse from(User user) {
            return new UserResponse(
                    user.getId(),
                    user.getUserId()
            );
        }
    }
}
