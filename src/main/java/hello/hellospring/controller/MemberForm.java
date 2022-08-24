package hello.hellospring.controller;

public class MemberForm {
    private String name; // createMemberForm.html 의 input태그의 name 값과 매칭

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
