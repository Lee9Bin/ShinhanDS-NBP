package com.delivery.domain.orderDelivery.service;

import com.delivery.domain.member.entity.MemberEntity;
import com.delivery.domain.member.repository.MemberRepository;
import com.delivery.domain.orderDelivery.dto.OrderDeliveryDto;
import com.delivery.domain.orderDelivery.entiy.OrderDelivery;
import com.delivery.domain.orderDelivery.repositry.OrderDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderDeliveryService {

    private final OrderDeliveryRepository orderDeliveryRepository;
    private final MemberRepository memberRepository;

    //등록하는 거니깐 기본 트랜잭션 걸어주기
    //주문하기
    @Transactional
    public OrderDelivery save(Long id,OrderDeliveryDto orderDeliveryDto){
        // 처음 주믄을 하면 요청수락대기 단계
        Optional<MemberEntity> targetMember = memberRepository.findById(id);

        if(targetMember.isPresent()){
            OrderDelivery orderDelivery = OrderDelivery.toEntity(orderDeliveryDto, targetMember.get());
            orderDeliveryRepository.save(orderDelivery);
            return OrderDelivery.toEntity(orderDeliveryDto, targetMember.get());
        }
        return null;
    }

    public List<OrderDelivery> findAllByMemberEntity_Id(Long id){
        return orderDeliveryRepository.findAllByMemberEntity_Id(id);
    }
}
