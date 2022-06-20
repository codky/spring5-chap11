package spring;

import org.springframework.stereotype.Service;
import spring.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class MemberRegisterService {
    private MemberDao memberDao;
    private UserRepository userRepository;

    public MemberRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long regist(RegisterRequest request) {
        Member member = userRepository.selectByEmail(request.getEmail());
        if (member != null) {
            throw new DuplicateMemberException("dup email " + request.getEmail());
        }
        Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), LocalDateTime.now());
        userRepository.insert(newMember);
        return newMember.getId();
    }
}
