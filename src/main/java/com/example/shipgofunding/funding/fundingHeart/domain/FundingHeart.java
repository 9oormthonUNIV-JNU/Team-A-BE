package com.example.shipgofunding.funding.fundingHeart.domain;

import com.example.shipgofunding.config.utils.MetaData;
import com.example.shipgofunding.funding.domain.Funding;
import com.example.shipgofunding.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE funding_hearts SET deleted_at = CURRENT_TIMESTAMP, is_deleted = TRUE where id = ?")
@Entity
@Table(name = "funding_hearts")
public class FundingHeart extends MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Funding funding;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public FundingHeart(Funding funding, User user) {
        this.funding = funding;
        this.user = user;
    }
}
