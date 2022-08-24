package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // 시퀀스 생성 용도

    @Override
    public Member save(Member member) {
        // id로 Member를 생성해서 store에 저장
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null값을 감싸서 반환 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
        // store Map을 순회하면서 하나라도 찾으면 결과를 반환, 결과가 없으면 Optional에 Null이 포함되어 반환
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) // 매개변수와 값이 같은 경우에만 필터링 된다.
                .findAny(); // 하나라도 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store의 모든 member객체를 ArrayList에 담아 리턴
    }

    public void clearStore() {
        store.clear();
    }
}
