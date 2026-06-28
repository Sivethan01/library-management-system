package com.lms.library.repository;

import com.lms.library.model.BorrowRecord;
import com.lms.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {

    Integer member(Member member);
}
