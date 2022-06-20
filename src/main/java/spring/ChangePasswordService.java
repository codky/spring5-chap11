package spring;

import spring.repository.UserRepository;

public class ChangePasswordService {

    private MemberDao memberDao;
    private MemberDao userRepository;

    public void ChangePassword(String email,String oldPwd, String newPwd) {
        Member member = userRepository.selectByEmail(email);
        if (member == null) throw new MemberNotFoundException();

        member.changePassword(oldPwd, newPwd);

        userRepository.update(member);
        }

        public void setUserRepository(MemberDao userRepository) {
            this.userRepository = userRepository;

    }
}
