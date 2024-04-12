package com.gaebaljip.exceed.member.adapter.out.persistence.custom;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.gaebaljip.exceed.member.adapter.out.persistence.MemberEntity;

@Repository
public interface CustomMemberRepository {
    Optional<MemberEntity> findByIdAndDate(Long memberId, LocalDate date);
}
