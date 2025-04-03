package shop.mtcoding.blog.temp;

import shop.mtcoding.blog.user.User;

public class Member {
    private int id;
    private String name;
    private String password;

    public static Member builder() {
        return new Member();
    }

    public Member id(int id) {
        this.id = id;
        return this;
    }

    public Member name(String name) {
        this.name = name;
        return this;
    }

    public Member password(String password) {
        this.password = password;
        return this;
    }

    public static void main(String[] args) {

        // 생성자보다 더 효율적으로 사용할 수 있음, 편하게 꺼내서 사용할 수 있음!!
        // .builder(). ... .build(); 와 같은 문법으로 사용한다.
        User u = User.builder().username("admin").password("123456").build();

        Member m = Member.builder()
                .id(1)
                .name("길동");

    }
}