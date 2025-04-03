package shop.mtcoding.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        // 1. 유저 네임, 이메일 중복체크
        User chkName = userRepository.findByUsername(joinDTO.getUsername());
        //User chkEmail = userRepository.findByEmail(joinDTO.getUsername());

        // 2. 중복 있으면 런타임 터트리기
        if (chkName != null) throw new RuntimeException("동일한 아이디가 존재합니다.");
        //if (chkEmail != null) throw new RuntimeException("동일한 이메일이 존재합니다.");

        // 3. 중복 없으면 바로 회원가입
        userRepository.save(joinDTO.getUsername(), joinDTO.getPassword(), joinDTO.getEmail());
    }
}
